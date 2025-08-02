package org.cocos2dx.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
    }

    private void releaseInflatedBytes() throws IOException {
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
        d writableSegment;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (i10 == 0) {
            return 0;
        } else {
            while (true) {
                boolean refill = refill();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.f1789a, writableSegment.f1791c, (int) Math.min(j10, (long) (8192 - writableSegment.f1791c)));
                    if (inflate > 0) {
                        writableSegment.f1791c += inflate;
                        long j11 = (long) inflate;
                        buffer.size += j11;
                        return j11;
                    } else if (this.inflater.finished()) {
                        break;
                    } else if (this.inflater.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e10) {
                    throw new IOException(e10);
                }
            }
            releaseInflatedBytes();
            if (writableSegment.f1790b != writableSegment.f1791c) {
                return -1;
            }
            buffer.head = writableSegment.b();
            e.a(writableSegment);
            return -1;
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.source.exhausted()) {
            return true;
        } else {
            d dVar = this.source.buffer().head;
            int i10 = dVar.f1791c;
            int i11 = dVar.f1790b;
            int i12 = i10 - i11;
            this.bufferBytesHeldByInflater = i12;
            this.inflater.setInput(dVar.f1789a, i11, i12);
            return false;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater2 != null) {
            this.source = bufferedSource;
            this.inflater = inflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
