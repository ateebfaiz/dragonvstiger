package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.m;

final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout2) {
        m.f(outputStream, "out");
        m.f(timeout2, "timeout");
        this.out = outputStream;
        this.timeout = timeout2;
    }

    public void close() {
        this.out.close();
    }

    public void flush() {
        this.out.flush();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    public void write(Buffer buffer, long j10) {
        m.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j10);
        while (j10 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            m.c(segment);
            int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j11 = (long) min;
            j10 -= j11;
            buffer.setSize$okio(buffer.size() - j11);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
