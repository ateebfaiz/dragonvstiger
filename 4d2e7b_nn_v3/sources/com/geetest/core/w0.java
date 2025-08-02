package com.geetest.core;

import java.io.IOException;
import java.util.Iterator;
import okhttp3.HttpUrl;

public abstract class w0 extends p0 implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final v[] f6201a;

    /* renamed from: b  reason: collision with root package name */
    public v[] f6202b;

    public w0() {
        v[] vVarArr = w.f6197a;
        this.f6201a = vVarArr;
        this.f6202b = vVarArr;
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) p0Var;
        int length = this.f6201a.length;
        if (w0Var.f6201a.length != length) {
            return false;
        }
        i2 i2Var = (i2) h();
        i2 i2Var2 = (i2) w0Var.h();
        for (int i10 = 0; i10 < length; i10++) {
            p0 d10 = i2Var.f6201a[i10].d();
            p0 d11 = i2Var2.f6201a[i10].d();
            if (d10 != d11 && !d10.a(d11)) {
                return false;
            }
        }
        return true;
    }

    public boolean g() {
        return true;
    }

    public p0 h() {
        if (this.f6202b == null) {
            v[] vVarArr = (v[]) this.f6201a.clone();
            this.f6202b = vVarArr;
            a(vVarArr);
        }
        return new i2(true, this.f6202b);
    }

    public int hashCode() {
        int length = this.f6201a.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 += this.f6201a[length].d().hashCode();
        }
    }

    public p0 i() {
        return new w2(this.f6201a, this.f6202b);
    }

    public Iterator<v> iterator() {
        v[] vVarArr;
        v[] vVarArr2 = this.f6201a;
        if (vVarArr2.length < 1) {
            vVarArr = w.f6197a;
        } else {
            vVarArr = (v[]) vVarArr2.clone();
        }
        return new f3(vVarArr);
    }

    public String toString() {
        int length = this.f6201a.length;
        if (length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f6201a[i10]);
            i10++;
            if (i10 >= length) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public w0(w wVar, boolean z10) {
        v[] vVarArr;
        if (wVar != null) {
            if (!z10 || wVar.b() < 2) {
                vVarArr = wVar.c();
            } else {
                vVarArr = wVar.a();
                a(vVarArr);
            }
            this.f6201a = vVarArr;
            if (!z10 && vVarArr.length >= 2) {
                vVarArr = null;
            }
            this.f6202b = vVarArr;
            return;
        }
        throw new NullPointerException("'elementVector' cannot be null");
    }

    public static byte[] a(v vVar) {
        try {
            return vVar.d().a("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public w0(boolean z10, v[] vVarArr) {
        this.f6201a = vVarArr;
        if (!z10 && vVarArr.length >= 2) {
            vVarArr = null;
        }
        this.f6202b = vVarArr;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        byte b10 = bArr[0] & 223;
        byte b11 = bArr2[0] & 223;
        if (b10 == b11) {
            int min = Math.min(bArr.length, bArr2.length) - 1;
            int i10 = 1;
            while (i10 < min) {
                byte b12 = bArr[i10];
                byte b13 = bArr2[i10];
                if (b12 == b13) {
                    i10++;
                } else if ((b12 & 255) < (b13 & 255)) {
                    return true;
                } else {
                    return false;
                }
            }
            if ((bArr[min] & 255) <= (bArr2[min] & 255)) {
                return true;
            }
            return false;
        } else if (b10 < b11) {
            return true;
        } else {
            return false;
        }
    }

    public w0(v[] vVarArr, v[] vVarArr2) {
        this.f6201a = vVarArr;
        this.f6202b = vVarArr2;
    }

    public static void a(v[] vVarArr) {
        int i10;
        int length = vVarArr.length;
        if (length >= 2) {
            v vVar = vVarArr[0];
            v vVar2 = vVarArr[1];
            byte[] a10 = a(vVar);
            byte[] a11 = a(vVar2);
            if (a(a11, a10)) {
                v vVar3 = vVar2;
                vVar2 = vVar;
                vVar = vVar3;
                byte[] bArr = a11;
                a11 = a10;
                a10 = bArr;
            }
            for (int i11 = 2; i11 < length; i11++) {
                v vVar4 = vVarArr[i11];
                byte[] a12 = a(vVar4);
                if (a(a11, a12)) {
                    vVarArr[i11 - 2] = vVar;
                    vVar = vVar2;
                    a10 = a11;
                    vVar2 = vVar4;
                    a11 = a12;
                } else if (a(a10, a12)) {
                    vVarArr[i11 - 2] = vVar;
                    vVar = vVar4;
                    a10 = a12;
                } else {
                    int i12 = i11 - 1;
                    while (true) {
                        i10 = i12 - 1;
                        if (i10 <= 0) {
                            break;
                        }
                        v vVar5 = vVarArr[i12 - 2];
                        if (a(a(vVar5), a12)) {
                            break;
                        }
                        vVarArr[i10] = vVar5;
                        i12 = i10;
                    }
                    vVarArr[i10] = vVar4;
                }
            }
            vVarArr[length - 2] = vVar;
            vVarArr[length - 1] = vVar2;
        }
    }
}
