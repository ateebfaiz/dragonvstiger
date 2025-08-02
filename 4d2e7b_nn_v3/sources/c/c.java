package c;

import java.io.IOException;
import java.io.OutputStream;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f17200a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17201b;

    /* renamed from: c  reason: collision with root package name */
    public int f17202c;

    /* renamed from: d  reason: collision with root package name */
    public final OutputStream f17203d;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(byte[] bArr, int i10, int i11) {
        this.f17203d = null;
        this.f17200a = bArr;
        this.f17202c = i10;
        this.f17201b = i10 + i11;
    }

    public static int a(int i10, double d10) {
        return q(i10) + 8;
    }

    public static int b(int i10, int i11) {
        return o(i11) + q(i10);
    }

    public static int c(int i10, boolean z10) {
        return q(i10) + 1;
    }

    public static int d(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return o(bytes.length) + bytes.length;
        } catch (Exception unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static c e(OutputStream outputStream) {
        return new c(outputStream, new byte[128]);
    }

    public static c f(byte[] bArr) {
        return new c(bArr, 0, bArr.length);
    }

    public static int m(int i10, int i11) {
        int i12;
        int q10 = q(i10);
        if (i11 >= 0) {
            i12 = o(i11);
        } else {
            i12 = 10;
        }
        return q10 + i12;
    }

    public static int o(int i10) {
        if ((i10 & -128) == 0) {
            return 1;
        }
        if ((i10 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i10) == 0) {
            return 3;
        }
        if ((i10 & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    public static int q(int i10) {
        return o(i10 << 3);
    }

    public void g(byte b10) {
        if (this.f17202c == this.f17201b) {
            n();
        }
        byte[] bArr = this.f17200a;
        int i10 = this.f17202c;
        this.f17202c = i10 + 1;
        bArr[i10] = b10;
    }

    public void h() {
        if (this.f17203d != null) {
            n();
        }
    }

    public void i(int i10, double d10) {
        t(i10, 1);
        r(Double.doubleToLongBits(d10));
    }

    public void j(int i10, boolean z10) {
        t(i10, 0);
        g(z10 ? (byte) 1 : 0);
    }

    public void k(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        w(bytes.length);
        l(bytes, 0, bytes.length);
    }

    public void l(byte[] bArr, int i10, int i11) {
        int i12 = this.f17201b;
        int i13 = this.f17202c;
        int i14 = i12 - i13;
        if (i14 >= i11) {
            System.arraycopy(bArr, i10, this.f17200a, i13, i11);
            this.f17202c += i11;
            return;
        }
        System.arraycopy(bArr, i10, this.f17200a, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.f17202c = this.f17201b;
        n();
        if (i16 <= this.f17201b) {
            System.arraycopy(bArr, i15, this.f17200a, 0, i16);
            this.f17202c = i16;
            return;
        }
        this.f17203d.write(bArr, i15, i16);
    }

    public final void n() {
        OutputStream outputStream = this.f17203d;
        if (outputStream != null) {
            outputStream.write(this.f17200a, 0, this.f17202c);
            this.f17202c = 0;
            return;
        }
        throw new a();
    }

    public void p(int i10, int i11) {
        t(i10, 0);
        w(i11);
    }

    public void r(long j10) {
        g((byte) (((int) j10) & 255));
        g((byte) (((int) (j10 >> 8)) & 255));
        g((byte) (((int) (j10 >> 16)) & 255));
        g((byte) (((int) (j10 >> 24)) & 255));
        g((byte) (((int) (j10 >> 32)) & 255));
        g((byte) (((int) (j10 >> 40)) & 255));
        g((byte) (((int) (j10 >> 48)) & 255));
        g((byte) (((int) (j10 >> 56)) & 255));
    }

    public void s(long j10) {
        while ((-128 & j10) != 0) {
            g((byte) ((((int) j10) & 127) | 128));
            j10 >>>= 7;
        }
        g((byte) ((int) j10));
    }

    public void t(int i10, int i11) {
        w((i10 << 3) | i11);
    }

    public void u(int i10) {
        if (i10 >= 0) {
            w(i10);
        } else {
            s((long) i10);
        }
    }

    public void v(int i10, int i11) {
        t(i10, 0);
        w(i11);
    }

    public void w(int i10) {
        while ((i10 & -128) != 0) {
            g((byte) ((i10 & 127) | 128));
            i10 >>>= 7;
        }
        g((byte) i10);
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f17203d = outputStream;
        this.f17200a = bArr;
        this.f17202c = 0;
        this.f17201b = bArr.length;
    }
}
