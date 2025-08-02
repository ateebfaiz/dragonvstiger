package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.m;

public final class GzipSource implements Source {
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source2) {
        m.f(source2, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source2);
        this.source = realBufferedSource;
        Inflater inflater2 = new Inflater(true);
        this.inflater = inflater2;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater2);
    }

    private final void checkEqual(String str, int i10, int i11) {
        if (i11 != i10) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
            m.e(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void consumeHeader() throws IOException {
        boolean z10;
        this.source.require(10);
        byte b10 = this.source.bufferField.getByte(3);
        if (((b10 >> 1) & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            updateCrc(this.source.bufferField, 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((b10 >> 2) & 1) == 1) {
            this.source.require(2);
            if (z10) {
                updateCrc(this.source.bufferField, 0, 2);
            }
            long readShortLe = (long) this.source.bufferField.readShortLe();
            this.source.require(readShortLe);
            if (z10) {
                updateCrc(this.source.bufferField, 0, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b10 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z10) {
                    updateCrc(this.source.bufferField, 0, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b10 >> 4) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z10) {
                    updateCrc(this.source.bufferField, 0, indexOf2 + 1);
                }
                this.source.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z10) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j10, long j11) {
        Segment segment = buffer.head;
        m.c(segment);
        while (true) {
            int i10 = segment.limit;
            int i11 = segment.pos;
            if (j10 < ((long) (i10 - i11))) {
                break;
            }
            j10 -= (long) (i10 - i11);
            segment = segment.next;
            m.c(segment);
        }
        while (j11 > 0) {
            int i12 = (int) (((long) segment.pos) + j10);
            int min = (int) Math.min((long) (segment.limit - i12), j11);
            this.crc.update(segment.data, i12, min);
            j11 -= (long) min;
            segment = segment.next;
            m.c(segment);
            j10 = 0;
        }
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long j10) throws IOException {
        boolean z10;
        m.f(buffer, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long size = buffer.size();
                long read = this.inflaterSource.read(buffer, j10);
                if (read != -1) {
                    updateCrc(buffer, size, read);
                    return read;
                }
                this.section = 2;
            }
            if (this.section == 2) {
                consumeTrailer();
                this.section = 3;
                if (!this.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
