package com.geetest.core;

import java.io.IOException;

public class j1 extends l0 {

    /* renamed from: d  reason: collision with root package name */
    public final int f6039d;

    /* renamed from: e  reason: collision with root package name */
    public final l0[] f6040e;

    public j1(byte[] bArr, int i10) {
        this(bArr, (l0[]) null, i10);
    }

    public static byte[] a(l0[] l0VarArr) {
        if (r0 == 0) {
            return l0.f6065b;
        }
        if (r0 == 1) {
            return l0VarArr[0].f6066c;
        }
        int i10 = 0;
        for (l0 l0Var : l0VarArr) {
            i10 += l0Var.f6066c.length;
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        for (l0 l0Var2 : l0VarArr) {
            byte[] bArr2 = l0Var2.f6066c;
            System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
            i11 += bArr2.length;
        }
        return bArr;
    }

    public boolean g() {
        return true;
    }

    public j1(l0[] l0VarArr, int i10) {
        this(a(l0VarArr), l0VarArr, i10);
    }

    public j1(byte[] bArr, l0[] l0VarArr, int i10) {
        super(bArr);
        this.f6040e = l0VarArr;
        this.f6039d = i10;
    }

    public int a(boolean z10) throws IOException {
        int i10 = z10 ? 4 : 3;
        if (this.f6040e != null) {
            int i11 = 0;
            while (true) {
                l0[] l0VarArr = this.f6040e;
                if (i11 >= l0VarArr.length) {
                    return i10;
                }
                i10 += l0VarArr[i11].a(true);
                i11++;
            }
        } else {
            int length = this.f6066c.length;
            int i12 = this.f6039d;
            int i13 = length / i12;
            int a10 = i10 + (n0.a(true, i12) * i13);
            int length2 = this.f6066c.length - (i13 * this.f6039d);
            return length2 > 0 ? a10 + n0.a(true, length2) : a10;
        }
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 36);
        n0Var.f6110a.write(128);
        l0[] l0VarArr = this.f6040e;
        if (l0VarArr == null) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.f6066c;
                if (i10 >= bArr.length) {
                    break;
                }
                int min = Math.min(bArr.length - i10, this.f6039d);
                byte[] bArr2 = this.f6066c;
                n0Var.b(true, 4);
                n0Var.c(min);
                n0Var.f6110a.write(bArr2, i10, min);
                i10 += min;
            }
        } else {
            n0Var.a((p0[]) l0VarArr);
        }
        n0Var.f6110a.write(0);
        n0Var.f6110a.write(0);
    }
}
