package com.geetest.core;

import java.io.IOException;

public class g1 extends s {

    /* renamed from: d  reason: collision with root package name */
    public final int f5981d;

    /* renamed from: e  reason: collision with root package name */
    public final s[] f5982e;

    public g1(byte[] bArr, int i10, int i11) {
        super(bArr, i10);
        this.f5982e = null;
        this.f5981d = i11;
    }

    public static byte[] a(s[] sVarArr) {
        if (r1 == 0) {
            return new byte[]{0};
        } else if (r1 == 1) {
            return sVarArr[0].f6169c;
        } else {
            int i10 = r1 - 1;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                byte[] bArr = sVarArr[i11].f6169c;
                if (bArr[0] == 0) {
                    i12 += bArr.length - 1;
                    i11++;
                } else {
                    throw new IllegalArgumentException("only the last nested bitstring can have padding");
                }
            }
            byte[] bArr2 = sVarArr[i10].f6169c;
            byte b10 = bArr2[0];
            byte[] bArr3 = new byte[(i12 + bArr2.length)];
            bArr3[0] = b10;
            int i13 = 1;
            for (s sVar : sVarArr) {
                byte[] bArr4 = sVar.f6169c;
                int length = bArr4.length - 1;
                System.arraycopy(bArr4, 1, bArr3, i13, length);
                i13 += length;
            }
            return bArr3;
        }
    }

    public boolean g() {
        if (this.f5982e != null || this.f6169c.length > this.f5981d) {
            return true;
        }
        return false;
    }

    public g1(s[] sVarArr, int i10) {
        super(a(sVarArr), false);
        this.f5982e = sVarArr;
        this.f5981d = i10;
    }

    public int a(boolean z10) throws IOException {
        if (!g()) {
            return n0.a(z10, this.f6169c.length);
        }
        int i10 = z10 ? 4 : 3;
        if (this.f5982e != null) {
            int i11 = 0;
            while (true) {
                s[] sVarArr = this.f5982e;
                if (i11 >= sVarArr.length) {
                    return i10;
                }
                i10 += sVarArr[i11].a(true);
                i11++;
            }
        } else {
            byte[] bArr = this.f6169c;
            if (bArr.length < 2) {
                return i10;
            }
            int i12 = this.f5981d;
            int length = (bArr.length - 2) / (i12 - 1);
            return i10 + (n0.a(true, i12) * length) + n0.a(true, this.f6169c.length - (length * (this.f5981d - 1)));
        }
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        if (!g()) {
            byte[] bArr = this.f6169c;
            int length = bArr.length;
            n0Var.b(z10, 3);
            n0Var.c(length);
            n0Var.f6110a.write(bArr, 0, length);
            return;
        }
        n0Var.b(z10, 35);
        n0Var.f6110a.write(128);
        s[] sVarArr = this.f5982e;
        if (sVarArr != null) {
            n0Var.a((p0[]) sVarArr);
        } else {
            byte[] bArr2 = this.f6169c;
            if (bArr2.length >= 2) {
                byte b10 = bArr2[0];
                int length2 = bArr2.length;
                int i10 = length2 - 1;
                int i11 = this.f5981d;
                int i12 = i11 - 1;
                while (i10 > i12) {
                    n0Var.b(true, 3);
                    n0Var.c(i11);
                    n0Var.f6110a.write(0);
                    n0Var.f6110a.write(this.f6169c, length2 - i10, i12);
                    i10 -= i12;
                }
                n0Var.b(true, 3);
                n0Var.c(i10 + 1);
                n0Var.f6110a.write(b10);
                n0Var.f6110a.write(this.f6169c, length2 - i10, i10);
            }
        }
        n0Var.f6110a.write(0);
        n0Var.f6110a.write(0);
    }
}
