package y2;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class c extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f24872a = 0;

    public c(OutputStream outputStream) {
        super(outputStream);
    }

    public long a() {
        return this.f24872a;
    }

    public void close() {
        this.out.close();
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
        this.f24872a += (long) i11;
    }

    public void write(int i10) {
        this.out.write(i10);
        this.f24872a++;
    }
}
