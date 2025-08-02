package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.m;

public final class RealBufferedSink$outputStream$1 extends OutputStream {
    final /* synthetic */ RealBufferedSink this$0;

    RealBufferedSink$outputStream$1(RealBufferedSink realBufferedSink) {
        this.this$0 = realBufferedSink;
    }

    public void close() {
        this.this$0.close();
    }

    public void flush() {
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.flush();
        }
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    public void write(int i10) {
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte((int) (byte) i10);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }

    public void write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "data");
        RealBufferedSink realBufferedSink = this.this$0;
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i10, i11);
            this.this$0.emitCompleteSegments();
            return;
        }
        throw new IOException("closed");
    }
}
