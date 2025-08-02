package t8;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.a0;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.ser.h;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.ser.std.a;
import com.fasterxml.jackson.databind.type.o;
import q8.g;

public class m extends a implements i {

    /* renamed from: f  reason: collision with root package name */
    private static final j f13112f = o.F().I(String.class);

    /* renamed from: g  reason: collision with root package name */
    public static final m f13113g = new m();

    /* renamed from: e  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.o f13114e;

    protected m() {
        super(String[].class);
        this.f13114e = null;
    }

    private void F(String[] strArr, f fVar, b0 b0Var, com.fasterxml.jackson.databind.o oVar) {
        for (String str : strArr) {
            if (str == null) {
                b0Var.x(fVar);
            } else {
                oVar.f(str, fVar, b0Var);
            }
        }
    }

    public com.fasterxml.jackson.databind.o A(d dVar, Boolean bool) {
        return new m(this, dVar, this.f13114e, bool);
    }

    /* renamed from: C */
    public boolean d(b0 b0Var, String[] strArr) {
        if (strArr.length == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: D */
    public final void f(String[] strArr, f fVar, b0 b0Var) {
        int length = strArr.length;
        if (length != 1 || ((this.f5519d != null || !b0Var.b0(a0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && this.f5519d != Boolean.TRUE)) {
            fVar.n0(strArr, length);
            B(strArr, fVar, b0Var);
            fVar.P();
            return;
        }
        B(strArr, fVar, b0Var);
    }

    /* renamed from: E */
    public void B(String[] strArr, f fVar, b0 b0Var) {
        if (r0 != 0) {
            com.fasterxml.jackson.databind.o oVar = this.f13114e;
            if (oVar != null) {
                F(strArr, fVar, b0Var, oVar);
                return;
            }
            for (String str : strArr) {
                if (str == null) {
                    fVar.U();
                } else {
                    fVar.s0(str);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.o a(com.fasterxml.jackson.databind.b0 r5, com.fasterxml.jackson.databind.d r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.b r1 = r5.L()
            com.fasterxml.jackson.databind.introspect.i r2 = r6.b()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.f(r2)
            if (r1 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.o r1 = r5.i0(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            com.fasterxml.jackson.annotation.i$a r3 = com.fasterxml.jackson.annotation.i.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r4.p(r5, r6, r2, r3)
            if (r1 != 0) goto L_0x0025
            com.fasterxml.jackson.databind.o r1 = r4.f13114e
        L_0x0025:
            com.fasterxml.jackson.databind.o r1 = r4.n(r5, r6, r1)
            if (r1 != 0) goto L_0x0031
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            com.fasterxml.jackson.databind.o r1 = r5.z(r1, r6)
        L_0x0031:
            boolean r5 = r4.u(r1)
            if (r5 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r0 = r1
        L_0x0039:
            com.fasterxml.jackson.databind.o r5 = r4.f13114e
            if (r0 != r5) goto L_0x0046
            java.lang.Boolean r5 = r4.f5519d
            boolean r5 = java.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L_0x0046
            return r4
        L_0x0046:
            t8.m r5 = new t8.m
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.m.a(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.d):com.fasterxml.jackson.databind.o");
    }

    public h x(g gVar) {
        return this;
    }

    public m(m mVar, d dVar, com.fasterxml.jackson.databind.o oVar, Boolean bool) {
        super(mVar, dVar, bool);
        this.f13114e = oVar;
    }
}
