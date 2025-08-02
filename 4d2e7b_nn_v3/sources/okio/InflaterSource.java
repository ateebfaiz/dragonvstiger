package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.m;

public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        m.f(bufferedSource, "source");
        m.f(inflater2, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater2;
    }

    private final void releaseBytesAfterInflate() {
        int i10 = this.bufferBytesHeldByInflater;
        if (i10 != 0) {
            int remaining = i10 - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    public long read(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "sink");
        do {
            long readOrInflate = readOrInflate(buffer, j10);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer buffer, long j10) throws IOException {
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
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                refill();
                int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j10, (long) (8192 - writableSegment$okio.limit)));
                releaseBytesAfterInflate();
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j11 = (long) inflate;
                    buffer.setSize$okio(buffer.size() + j11);
                    return j11;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                return 0;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        m.c(segment);
        int i10 = segment.limit;
        int i11 = segment.pos;
        int i12 = i10 - i11;
        this.bufferBytesHeldByInflater = i12;
        this.inflater.setInput(segment.data, i11, i12);
        return false;
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
        m.f(source2, "source");
        m.f(inflater2, "inflater");
    }
}
