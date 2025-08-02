package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.m;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        m.f(bufferedSink, "sink");
        m.f(deflater2, "deflater");
        this.sink = bufferedSink;
        this.deflater = deflater2;
    }

    @IgnoreJRERequirement
    private final void deflate(boolean z10) {
        Segment writableSegment$okio;
        int i10;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z10) {
                Deflater deflater2 = this.deflater;
                byte[] bArr = writableSegment$okio.data;
                int i11 = writableSegment$okio.limit;
                i10 = deflater2.deflate(bArr, i11, 8192 - i11, 2);
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment$okio.data;
                int i12 = writableSegment$okio.limit;
                i10 = deflater3.deflate(bArr2, i12, 8192 - i12);
            }
            if (i10 > 0) {
                writableSegment$okio.limit += i10;
                buffer.setSize$okio(buffer.size() + ((long) i10));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                finishDeflate$okio();
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

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    public void write(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j10);
        while (j10 > 0) {
            Segment segment = buffer.head;
            m.c(segment);
            int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j11 = (long) min;
            buffer.setSize$okio(buffer.size() - j11);
            int i10 = segment.pos + min;
            segment.pos = i10;
            if (i10 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j10 -= j11;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
        m.f(sink2, "sink");
        m.f(deflater2, "deflater");
    }
}
