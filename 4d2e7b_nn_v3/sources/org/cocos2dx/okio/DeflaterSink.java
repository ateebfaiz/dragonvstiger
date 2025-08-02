package org.cocos2dx.okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
    }

    @IgnoreJRERequirement
    private void deflate(boolean z10) throws IOException {
        d writableSegment;
        int i10;
        Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z10) {
                Deflater deflater2 = this.deflater;
                byte[] bArr = writableSegment.f1789a;
                int i11 = writableSegment.f1791c;
                i10 = deflater2.deflate(bArr, i11, 8192 - i11, 2);
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment.f1789a;
                int i12 = writableSegment.f1791c;
                i10 = deflater3.deflate(bArr2, i12, 8192 - i12);
            }
            if (i10 > 0) {
                writableSegment.f1791c += i10;
                buffer.size += (long) i10;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.f1790b == writableSegment.f1791c) {
            buffer.head = writableSegment.b();
            e.a(writableSegment);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                finishDeflate();
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
                g.f(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void finishDeflate() throws IOException {
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
        return "DeflaterSink(" + this.sink + ")";
    }

    public void write(Buffer buffer, long j10) throws IOException {
        g.b(buffer.size, 0, j10);
        while (j10 > 0) {
            d dVar = buffer.head;
            int min = (int) Math.min(j10, (long) (dVar.f1791c - dVar.f1790b));
            this.deflater.setInput(dVar.f1789a, dVar.f1790b, min);
            deflate(false);
            long j11 = (long) min;
            buffer.size -= j11;
            int i10 = dVar.f1790b + min;
            dVar.f1790b = i10;
            if (i10 == dVar.f1791c) {
                buffer.head = dVar.b();
                e.a(dVar);
            }
            j10 -= j11;
        }
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater2 != null) {
            this.sink = bufferedSink;
            this.deflater = deflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
