package b3;

import java.io.Closeable;
import java.nio.ByteBuffer;

public interface h extends Closeable {

    public static class a extends RuntimeException {
        public a() {
            super("Invalid bytebuf. Already closed");
        }
    }

    byte c(int i10);

    int d(int i10, byte[] bArr, int i11, int i12);

    ByteBuffer e();

    long f();

    boolean isClosed();

    int size();
}
