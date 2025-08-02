package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.m;

final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout2) {
        m.f(inputStream, "input");
        m.f(timeout2, "timeout");
        this.input = inputStream;
        this.timeout = timeout2;
    }

    public void close() {
        this.input.close();
    }

    public long read(Buffer buffer, long j10) {
        boolean z10;
        m.f(buffer, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 == 0) {
            return 0;
        }
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            try {
                this.timeout.throwIfReached();
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j10, (long) (8192 - writableSegment$okio.limit)));
                if (read != -1) {
                    writableSegment$okio.limit += read;
                    long j11 = (long) read;
                    buffer.setSize$okio(buffer.size() + j11);
                    return j11;
                } else if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1;
                } else {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1;
                }
            } catch (AssertionError e10) {
                if (Okio.isAndroidGetsocknameError(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
