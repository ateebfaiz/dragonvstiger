package com.geetest.core;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.HttpUrl;

public abstract class s0 extends p0 implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public v[] f6170a;

    public class a implements t0 {

        /* renamed from: a  reason: collision with root package name */
        public int f6171a = 0;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f6172b;

        public a(int i10) {
            this.f6172b = i10;
        }

        public p0 b() {
            return s0.this;
        }

        public p0 d() {
            return s0.this;
        }

        public v f() throws IOException {
            int i10 = this.f6172b;
            int i11 = this.f6171a;
            if (i10 == i11) {
                return null;
            }
            v[] vVarArr = s0.this.f6170a;
            this.f6171a = i11 + 1;
            v vVar = vVarArr[i11];
            if (vVar instanceof s0) {
                s0 s0Var = (s0) vVar;
                return new a(s0Var.m());
            } else if (!(vVar instanceof w0)) {
                return vVar;
            } else {
                w0 w0Var = (w0) vVar;
                return new v0(w0Var, w0Var.f6201a.length);
            }
        }
    }

    public s0() {
        this.f6170a = w.f6197a;
    }

    public v a(int i10) {
        return this.f6170a[i10];
    }

    public boolean g() {
        return true;
    }

    public p0 h() {
        return new h2(this.f6170a, false);
    }

    public int hashCode() {
        int length = this.f6170a.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ this.f6170a[length].d().hashCode();
        }
    }

    public p0 i() {
        return new u2(this.f6170a, false);
    }

    public Iterator<v> iterator() {
        return new f3(this.f6170a);
    }

    public s[] j() {
        v vVar;
        int m10 = m();
        s[] sVarArr = new s[m10];
        for (int i10 = 0; i10 < m10; i10++) {
            v vVar2 = this.f6170a[i10];
            if (vVar2 == null || (vVar2 instanceof s)) {
                vVar = vVar2;
            } else {
                vVar = vVar2.d();
                if (!(vVar instanceof s)) {
                    throw new IllegalArgumentException("illegal object in getInstance: " + vVar2.getClass().getName());
                }
            }
            sVarArr[i10] = (s) vVar;
        }
        return sVarArr;
    }

    public l0[] k() {
        v vVar;
        int m10 = m();
        l0[] l0VarArr = new l0[m10];
        for (int i10 = 0; i10 < m10; i10++) {
            v vVar2 = this.f6170a[i10];
            if (vVar2 == null || (vVar2 instanceof l0)) {
                vVar = vVar2;
            } else {
                vVar = vVar2.d();
                if (!(vVar instanceof l0)) {
                    throw new IllegalArgumentException("illegal object in getInstance: " + vVar2.getClass().getName());
                }
            }
            l0VarArr[i10] = (l0) vVar;
        }
        return l0VarArr;
    }

    public t0 l() {
        return new a(m());
    }

    public int m() {
        return this.f6170a.length;
    }

    public abstract s n();

    public abstract l0 o();

    public String toString() {
        int m10 = m();
        if (m10 == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f6170a[i10]);
            i10++;
            if (i10 >= m10) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) p0Var;
        int m10 = m();
        if (s0Var.m() != m10) {
            return false;
        }
        for (int i10 = 0; i10 < m10; i10++) {
            p0 d10 = this.f6170a[i10].d();
            p0 d11 = s0Var.f6170a[i10].d();
            if (d10 != d11 && !d10.a(d11)) {
                return false;
            }
        }
        return true;
    }

    public s0(v vVar) {
        if (vVar != null) {
            this.f6170a = new v[]{vVar};
            return;
        }
        throw new NullPointerException("'element' cannot be null");
    }

    public s0(w wVar) {
        if (wVar != null) {
            this.f6170a = wVar.c();
            return;
        }
        throw new NullPointerException("'elementVector' cannot be null");
    }

    public s0(v[] vVarArr, boolean z10) {
        this.f6170a = z10 ? w.a(vVarArr) : vVarArr;
    }
}
