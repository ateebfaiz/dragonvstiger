package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.m;

public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink sink2) {
        m.f(sink2, "sink");
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink2);
        this.sink = realBufferedSink;
        Deflater deflater2 = new Deflater(-1, true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((BufferedSink) realBufferedSink, deflater2);
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long j10) {
        Segment segment = buffer.head;
        m.c(segment);
        while (j10 > 0) {
            int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
            this.crc.update(segment.data, segment.pos, min);
            j10 -= (long) min;
            segment = segment.next;
            m.c(segment);
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m148deprecated_deflater() {
        return this.deflater;
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                this.deflaterSink.finishDeflate$okio();
                writeFooter();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.deflater.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        }
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j10) throws IOException {
        boolean z10;
        m.f(buffer, "source");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (i10 != 0) {
            updateCrc(buffer, j10);
            this.deflaterSink.write(buffer, j10);
        }
    }
}
