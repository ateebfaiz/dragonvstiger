package okio;

import java.io.InputStream;
import kotlin.jvm.internal.m;

public final class Buffer$inputStream$1 extends InputStream {
    final /* synthetic */ Buffer this$0;

    Buffer$inputStream$1(Buffer buffer) {
        this.this$0 = buffer;
    }

    public int available() {
        return (int) Math.min(this.this$0.size(), (long) Integer.MAX_VALUE);
    }

    public void close() {
    }

    public int read() {
        if (this.this$0.size() > 0) {
            return this.this$0.readByte() & 255;
        }
        return -1;
    }

    public String toString() {
        return this.this$0 + ".inputStream()";
    }

    public int read(byte[] bArr, int i10, int i11) {
        m.f(bArr, "sink");
        return this.this$0.read(bArr, i10, i11);
    }
}
