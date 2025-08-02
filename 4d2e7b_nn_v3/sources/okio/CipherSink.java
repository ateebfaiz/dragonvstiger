package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.m;

public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink bufferedSink, Cipher cipher2) {
        boolean z10;
        m.f(bufferedSink, "sink");
        m.f(cipher2, "cipher");
        this.sink = bufferedSink;
        this.cipher = cipher2;
        int blockSize2 = cipher2.getBlockSize();
        this.blockSize = blockSize2;
        boolean z11 = false;
        if (blockSize2 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (!(blockSize2 <= 8192 ? true : z11)) {
                throw new IllegalArgumentException(("Cipher block size " + blockSize2 + " too large " + cipher2).toString());
            }
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher2).toString());
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th = null;
        if (outputSize == 0) {
            return null;
        }
        Buffer buffer = this.sink.getBuffer();
        Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
        try {
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
            writableSegment$okio.limit += doFinal;
            buffer.setSize$okio(buffer.size() + ((long) doFinal));
        } catch (Throwable th2) {
            th = th2;
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        return th;
    }

    private final int update(Buffer buffer, long j10) {
        Segment segment = buffer.head;
        m.c(segment);
        int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
        Buffer buffer2 = this.sink.getBuffer();
        Segment writableSegment$okio = buffer2.writableSegment$okio(min);
        int update = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
        writableSegment$okio.limit += update;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer2.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        buffer.setSize$okio(buffer.size() - ((long) min));
        int i10 = segment.pos + min;
        segment.pos = i10;
        if (i10 == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            Throwable doFinal = doFinal();
            try {
                this.sink.close();
            } catch (Throwable th) {
                if (doFinal == null) {
                    doFinal = th;
                }
            }
            if (doFinal != null) {
                throw doFinal;
            }
        }
    }

    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j10);
        if (!this.closed) {
            while (j10 > 0) {
                j10 -= (long) update(buffer, j10);
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }
}
