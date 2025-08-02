package com.geetest.core;

import java.io.IOException;
import java.io.OutputStream;

public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f6110a;

    public n0(OutputStream outputStream) {
        this.f6110a = outputStream;
    }

    public static int a(int i10) {
        if (i10 < 128) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 8;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public static int b(int i10) {
        if (i10 < 31) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 7;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public final void c(int i10) throws IOException {
        if (i10 < 128) {
            this.f6110a.write(i10);
            return;
        }
        int i11 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i12 = i11 - 1;
            bArr[i12] = (byte) i10;
            i10 >>>= 8;
            if (i10 == 0) {
                int i13 = i11 - 2;
                bArr[i13] = (byte) ((5 - i12) | 128);
                this.f6110a.write(bArr, i13, 6 - i12);
                return;
            }
            i11 = i12;
        }
    }

    public f2 a() {
        return new f2(this.f6110a);
    }

    public t2 b() {
        return new t2(this.f6110a);
    }

    public final void a(boolean z10, int i10, int i11) throws IOException {
        if (z10) {
            if (i11 < 31) {
                this.f6110a.write(i10 | i11);
                return;
            }
            byte[] bArr = new byte[6];
            int i12 = 5;
            bArr[5] = (byte) (i11 & 127);
            while (i11 > 127) {
                i11 >>>= 7;
                i12--;
                bArr[i12] = (byte) ((i11 & 127) | 128);
            }
            int i13 = i12 - 1;
            bArr[i13] = (byte) (31 | i10);
            this.f6110a.write(bArr, i13, 6 - i13);
        }
    }

    public final void b(boolean z10, int i10) throws IOException {
        if (z10) {
            this.f6110a.write(i10);
        }
    }

    public void a(v[] vVarArr) throws IOException {
        for (v d10 : vVarArr) {
            d10.d().a(this, true);
        }
    }

    public final void a(boolean z10, int i10, byte[] bArr) throws IOException {
        b(z10, i10);
        c(bArr.length);
        this.f6110a.write(bArr, 0, bArr.length);
    }

    public final void a(boolean z10, int i10, v[] vVarArr) throws IOException {
        b(z10, i10);
        this.f6110a.write(128);
        a(vVarArr);
        this.f6110a.write(0);
        this.f6110a.write(0);
    }

    public void a(p0 p0Var, boolean z10) throws IOException {
        p0Var.a(this, z10);
    }

    public void a(p0[] p0VarArr) throws IOException {
        for (p0 a10 : p0VarArr) {
            a10.a(this, true);
        }
    }

    public static int a(boolean z10, int i10) {
        return (z10 ? 1 : 0) + a(i10) + i10;
    }
}
