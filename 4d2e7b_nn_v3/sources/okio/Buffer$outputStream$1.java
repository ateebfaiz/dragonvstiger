package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.m;

public final class Buffer$outputStream$1 extends OutputStream {
    final /* synthetic */ Buffer this$0;

    Buffer$outputStream$1(Buffer buffer) {
        this.this$0 = buffer;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.this$0 + ".outputStream()";
    }

    public void write(int i10) {
        this.this$0.writeByte(i10);
    }

    public void write(byte[] bArr, int i10, int i11) {
        m.f(bArr, "data");
        this.this$0.write(bArr, i10, i11);
    }
}
