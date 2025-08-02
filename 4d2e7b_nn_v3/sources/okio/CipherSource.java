package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.m;

public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer = new Buffer();
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final  reason: not valid java name */
    private boolean f0final;
    private final BufferedSource source;

    public CipherSource(BufferedSource bufferedSource, Cipher cipher2) {
        boolean z10;
        m.f(bufferedSource, "source");
        m.f(cipher2, "cipher");
        this.source = bufferedSource;
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

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize != 0) {
            Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
            writableSegment$okio.limit += doFinal;
            Buffer buffer2 = this.buffer;
            buffer2.setSize$okio(buffer2.size() + ((long) doFinal));
            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                this.buffer.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
            }
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0) {
            if (this.source.exhausted()) {
                this.f0final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        m.c(segment);
        int i10 = segment.limit - segment.pos;
        Segment writableSegment$okio = this.buffer.writableSegment$okio(i10);
        int update = this.cipher.update(segment.data, segment.pos, i10, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip((long) i10);
        writableSegment$okio.limit += update;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public long read(Buffer buffer2, long j10) throws IOException {
        boolean z10;
        m.f(buffer2, "sink");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        } else if (!(true ^ this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (i10 == 0) {
            return 0;
        } else {
            if (this.f0final) {
                return this.buffer.read(buffer2, j10);
            }
            refill();
            return this.buffer.read(buffer2, j10);
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
