package e3;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f21228a;

    /* renamed from: b  reason: collision with root package name */
    private int f21229b;

    /* renamed from: c  reason: collision with root package name */
    private int f21230c;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        inputStream.getClass();
        bArr.getClass();
        this.f21228a = bArr;
    }

    private int a() {
        int i10 = this.f21229b;
        byte[] bArr = this.f21228a;
        if (i10 >= bArr.length) {
            return -1;
        }
        this.f21229b = i10 + 1;
        return bArr[i10] & 255;
    }

    public void mark(int i10) {
        if (this.in.markSupported()) {
            super.mark(i10);
            this.f21230c = this.f21229b;
        }
    }

    public int read() {
        int read = this.in.read();
        if (read != -1) {
            return read;
        }
        return a();
    }

    public void reset() {
        if (this.in.markSupported()) {
            this.in.reset();
            this.f21229b = this.f21230c;
            return;
        }
        throw new IOException("mark is not supported");
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i10, int i11) {
        int read = this.in.read(bArr, i10, i11);
        if (read != -1) {
            return read;
        }
        int i12 = 0;
        if (i11 == 0) {
            return 0;
        }
        while (i12 < i11) {
            int a10 = a();
            if (a10 == -1) {
                break;
            }
            bArr[i10 + i12] = (byte) a10;
            i12++;
        }
        if (i12 > 0) {
            return i12;
        }
        return -1;
    }
}
