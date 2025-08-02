package b3;

import java.io.InputStream;
import java.io.OutputStream;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final int f17171a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17172b;

    public l(a aVar) {
        this(aVar, 16384);
    }

    public long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = (byte[]) this.f17172b.get(this.f17171a);
        long j10 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.f17171a);
                if (read == -1) {
                    return j10;
                }
                outputStream.write(bArr, 0, read);
                j10 += (long) read;
            } finally {
                this.f17172b.release(bArr);
            }
        }
    }

    public l(a aVar, int i10) {
        y2.l.b(Boolean.valueOf(i10 > 0));
        this.f17171a = i10;
        this.f17172b = aVar;
    }
}
