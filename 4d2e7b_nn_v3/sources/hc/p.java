package hc;

import java.io.IOException;
import java.io.OutputStream;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f407a;

    private class a extends p {

        /* renamed from: b  reason: collision with root package name */
        private boolean f408b = true;

        public a(OutputStream outputStream) {
            super(outputStream);
        }

        public void c(int i10) {
            if (this.f408b) {
                this.f408b = false;
            } else {
                p.super.c(i10);
            }
        }
    }

    public p(OutputStream outputStream) {
        this.f407a = outputStream;
    }

    /* access modifiers changed from: package-private */
    public p a() {
        return new x0(this.f407a);
    }

    /* access modifiers changed from: package-private */
    public p b() {
        return new k1(this.f407a);
    }

    /* access modifiers changed from: package-private */
    public void c(int i10) {
        this.f407a.write(i10);
    }

    /* access modifiers changed from: package-private */
    public void d(byte[] bArr) {
        this.f407a.write(bArr);
    }

    /* access modifiers changed from: package-private */
    public void e(byte[] bArr, int i10, int i11) {
        this.f407a.write(bArr, i10, i11);
    }

    /* access modifiers changed from: package-private */
    public void f(int i10, int i11, byte[] bArr) {
        k(i10, i11);
        i(bArr.length);
        d(bArr);
    }

    /* access modifiers changed from: package-private */
    public void g(int i10, byte[] bArr) {
        c(i10);
        i(bArr.length);
        d(bArr);
    }

    /* access modifiers changed from: package-private */
    public void h(r rVar) {
        if (rVar != null) {
            rVar.i(new a(this.f407a));
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public void i(int i10) {
        if (i10 > 127) {
            int i11 = i10;
            int i12 = 1;
            while (true) {
                i11 >>>= 8;
                if (i11 == 0) {
                    break;
                }
                i12++;
            }
            c((byte) (i12 | 128));
            for (int i13 = (i12 - 1) * 8; i13 >= 0; i13 -= 8) {
                c((byte) (i10 >> i13));
            }
            return;
        }
        c((byte) i10);
    }

    public void j(d dVar) {
        if (dVar != null) {
            dVar.c().i(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* access modifiers changed from: package-private */
    public void k(int i10, int i11) {
        if (i11 < 31) {
            c(i10 | i11);
            return;
        }
        c(i10 | 31);
        if (i11 < 128) {
            c(i11);
            return;
        }
        byte[] bArr = new byte[5];
        int i12 = 4;
        bArr[4] = (byte) (i11 & 127);
        do {
            i11 >>= 7;
            i12--;
            bArr[i12] = (byte) ((i11 & 127) | 128);
        } while (i11 > 127);
        e(bArr, i12, 5 - i12);
    }
}
