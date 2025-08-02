package hc;

import be.a;
import java.io.EOFException;
import java.io.InputStream;

class o1 extends t1 {

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f404e = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private final int f405c;

    /* renamed from: d  reason: collision with root package name */
    private int f406d;

    o1(InputStream inputStream, int i10) {
        super(inputStream, i10);
        if (i10 >= 0) {
            this.f405c = i10;
            this.f406d = i10;
            if (i10 == 0) {
                b(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f406d;
    }

    /* access modifiers changed from: package-private */
    public byte[] h() {
        int i10 = this.f406d;
        if (i10 == 0) {
            return f404e;
        }
        byte[] bArr = new byte[i10];
        int c10 = i10 - a.c(this.f426a, bArr);
        this.f406d = c10;
        if (c10 == 0) {
            b(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.f405c + " object truncated by " + this.f406d);
    }

    public int read() {
        if (this.f406d == 0) {
            return -1;
        }
        int read = this.f426a.read();
        if (read >= 0) {
            int i10 = this.f406d - 1;
            this.f406d = i10;
            if (i10 == 0) {
                b(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f405c + " object truncated by " + this.f406d);
    }

    public int read(byte[] bArr, int i10, int i11) {
        int i12 = this.f406d;
        if (i12 == 0) {
            return -1;
        }
        int read = this.f426a.read(bArr, i10, Math.min(i11, i12));
        if (read >= 0) {
            int i13 = this.f406d - read;
            this.f406d = i13;
            if (i13 == 0) {
                b(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f405c + " object truncated by " + this.f406d);
    }
}
