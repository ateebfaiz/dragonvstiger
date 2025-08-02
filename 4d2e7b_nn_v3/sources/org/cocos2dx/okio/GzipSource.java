package org.cocos2dx.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section = 0;
    private final BufferedSource source;

    public GzipSource(Source source2) {
        if (source2 != null) {
            Inflater inflater2 = new Inflater(true);
            this.inflater = inflater2;
            BufferedSource buffer = Okio.buffer(source2);
            this.source = buffer;
            this.inflaterSource = new InflaterSource(buffer, inflater2);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void checkEqual(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}));
        }
    }

    private void consumeHeader() throws IOException {
        boolean z10;
        this.source.require(10);
        byte b10 = this.source.buffer().getByte(3);
        if (((b10 >> 1) & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            updateCrc(this.source.buffer(), 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((b10 >> 2) & 1) == 1) {
            this.source.require(2);
            if (z10) {
                updateCrc(this.source.buffer(), 0, 2);
            }
            long readShortLe = (long) this.source.buffer().readShortLe();
            this.source.require(readShortLe);
            if (z10) {
                updateCrc(this.source.buffer(), 0, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b10 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) SECTION_HEADER);
            if (indexOf != -1) {
                if (z10) {
                    updateCrc(this.source.buffer(), 0, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b10 >> FCOMMENT) & 1) == 1) {
            long indexOf2 = this.source.indexOf((byte) SECTION_HEADER);
            if (indexOf2 != -1) {
                if (z10) {
                    updateCrc(this.source.buffer(), 0, indexOf2 + 1);
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

    private void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private void updateCrc(Buffer buffer, long j10, long j11) {
        d dVar = buffer.head;
        while (true) {
            int i10 = dVar.f1791c;
            int i11 = dVar.f1790b;
            if (j10 < ((long) (i10 - i11))) {
                break;
            }
            j10 -= (long) (i10 - i11);
            dVar = dVar.f1794f;
        }
        while (j11 > 0) {
            int i12 = (int) (((long) dVar.f1790b) + j10);
            int min = (int) Math.min((long) (dVar.f1791c - i12), j11);
            this.crc.update(dVar.f1789a, i12, min);
            j11 -= (long) min;
            dVar = dVar.f1794f;
            j10 = 0;
        }
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long j10) throws IOException {
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        } else if (i10 == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long j11 = buffer.size;
                long read = this.inflaterSource.read(buffer, j10);
                if (read != -1) {
                    updateCrc(buffer, j11, read);
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
