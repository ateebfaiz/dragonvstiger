package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.databind.b;
import com.fasterxml.jackson.databind.c;
import com.fasterxml.jackson.databind.introspect.i;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.util.f;
import com.fasterxml.jackson.databind.z;
import k8.e;
import q8.g;

public class l {

    /* renamed from: g  reason: collision with root package name */
    private static final Object f5508g = Boolean.FALSE;

    /* renamed from: a  reason: collision with root package name */
    protected final z f5509a;

    /* renamed from: b  reason: collision with root package name */
    protected final c f5510b;

    /* renamed from: c  reason: collision with root package name */
    protected final b f5511c;

    /* renamed from: d  reason: collision with root package name */
    protected Object f5512d;

    /* renamed from: e  reason: collision with root package name */
    protected final p.b f5513e;

    /* renamed from: f  reason: collision with root package name */
    protected final boolean f5514f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5515a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.fasterxml.jackson.annotation.p$a[] r0 = com.fasterxml.jackson.annotation.p.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5515a = r0
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5515a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5515a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5515a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5515a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5515a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.l.a.<clinit>():void");
        }
    }

    public l(z zVar, c cVar) {
        boolean z10;
        this.f5509a = zVar;
        this.f5510b = cVar;
        p.b j10 = p.b.j(cVar.g(p.b.c()), zVar.s(cVar.i(), p.b.c()));
        this.f5513e = p.b.j(zVar.P(), j10);
        if (j10.i() == p.a.NON_DEFAULT) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f5514f = z10;
        this.f5511c = zVar.h();
    }

    /* access modifiers changed from: protected */
    public c a(s sVar, i iVar, com.fasterxml.jackson.databind.util.a aVar, j jVar, o oVar, g gVar, j jVar2, boolean z10, Object obj, Class[] clsArr) {
        return new c(sVar, iVar, aVar, jVar, oVar, gVar, jVar2, z10, obj, clsArr);
    }

    /* access modifiers changed from: protected */
    public Object b(Exception exc, String str, Object obj) {
        while (true) {
            Throwable cause = r3.getCause();
            Throwable th = exc;
            if (cause != null) {
                th = th.getCause();
            } else {
                f.U(th);
                f.W(th);
                throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.ser.c c(com.fasterxml.jackson.databind.b0 r16, com.fasterxml.jackson.databind.introspect.s r17, com.fasterxml.jackson.databind.j r18, com.fasterxml.jackson.databind.o r19, q8.g r20, q8.g r21, com.fasterxml.jackson.databind.introspect.i r22, boolean r23) {
        /*
            r15 = this;
            r12 = r15
            r13 = r16
            r2 = r17
            r5 = r18
            r0 = r21
            r14 = r22
            r1 = 0
            r3 = r23
            com.fasterxml.jackson.databind.j r3 = r15.d(r14, r3, r5)     // Catch:{ l -> 0x0153 }
            if (r0 == 0) goto L_0x0043
            if (r3 != 0) goto L_0x0017
            r3 = r5
        L_0x0017:
            com.fasterxml.jackson.databind.j r4 = r3.l()
            if (r4 != 0) goto L_0x003a
            com.fasterxml.jackson.databind.c r4 = r12.f5510b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "serialization type "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r7 = " has no content"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r13.e0(r4, r2, r6, r7)
        L_0x003a:
            com.fasterxml.jackson.databind.j r0 = r3.Q(r0)
            r0.l()
            r8 = r0
            goto L_0x0044
        L_0x0043:
            r8 = r3
        L_0x0044:
            if (r8 != 0) goto L_0x0048
            r0 = r5
            goto L_0x0049
        L_0x0048:
            r0 = r8
        L_0x0049:
            com.fasterxml.jackson.databind.introspect.i r3 = r17.e()
            if (r3 != 0) goto L_0x005c
            com.fasterxml.jackson.databind.c r0 = r12.f5510b
            java.lang.String r3 = "could not determine property type"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r0 = r13.e0(r0, r2, r3, r1)
            com.fasterxml.jackson.databind.ser.c r0 = (com.fasterxml.jackson.databind.ser.c) r0
            return r0
        L_0x005c:
            java.lang.Class r3 = r3.d()
            com.fasterxml.jackson.databind.z r4 = r12.f5509a
            java.lang.Class r6 = r0.s()
            com.fasterxml.jackson.annotation.p$b r7 = r12.f5513e
            com.fasterxml.jackson.annotation.p$b r3 = r4.n(r6, r3, r7)
            com.fasterxml.jackson.annotation.p$b r4 = r17.b()
            com.fasterxml.jackson.annotation.p$b r3 = r3.n(r4)
            com.fasterxml.jackson.annotation.p$a r4 = r3.i()
            com.fasterxml.jackson.annotation.p$a r6 = com.fasterxml.jackson.annotation.p.a.USE_DEFAULTS
            if (r4 != r6) goto L_0x007e
            com.fasterxml.jackson.annotation.p$a r4 = com.fasterxml.jackson.annotation.p.a.ALWAYS
        L_0x007e:
            int[] r6 = com.fasterxml.jackson.databind.ser.l.a.f5515a
            int r4 = r4.ordinal()
            r4 = r6[r4]
            r6 = 1
            r7 = 0
            if (r4 == r6) goto L_0x00d2
            r9 = 2
            if (r4 == r9) goto L_0x00c7
            r9 = 3
            if (r4 == r9) goto L_0x00c4
            r9 = 4
            if (r4 == r9) goto L_0x00b2
            r3 = 5
            if (r4 == r3) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r1 = r6
        L_0x0098:
            com.fasterxml.jackson.databind.a0 r3 = com.fasterxml.jackson.databind.a0.WRITE_EMPTY_JSON_ARRAYS
            boolean r0 = r0.C()
            if (r0 == 0) goto L_0x00ae
            com.fasterxml.jackson.databind.z r0 = r12.f5509a
            boolean r0 = r0.b0(r3)
            if (r0 != 0) goto L_0x00ae
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.c.Q0
        L_0x00aa:
            r10 = r0
            r9 = r1
            goto L_0x0115
        L_0x00ae:
            r9 = r1
        L_0x00af:
            r10 = r7
            goto L_0x0115
        L_0x00b2:
            java.lang.Class r0 = r3.h()
            java.lang.Object r0 = r13.Y(r2, r0)
            if (r0 != 0) goto L_0x00bf
        L_0x00bc:
            r10 = r0
            r9 = r6
            goto L_0x0115
        L_0x00bf:
            boolean r1 = r13.Z(r0)
            goto L_0x00aa
        L_0x00c4:
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.c.Q0
            goto L_0x00bc
        L_0x00c7:
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x00d0
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.c.Q0
            goto L_0x00bc
        L_0x00d0:
            r9 = r6
            goto L_0x00af
        L_0x00d2:
            boolean r3 = r12.f5514f
            if (r3 == 0) goto L_0x00fe
            java.lang.Object r3 = r15.e()
            if (r3 == 0) goto L_0x00fe
            com.fasterxml.jackson.databind.q r0 = com.fasterxml.jackson.databind.q.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r0 = r13.a0(r0)
            if (r0 == 0) goto L_0x00ef
            com.fasterxml.jackson.databind.z r0 = r12.f5509a
            com.fasterxml.jackson.databind.q r4 = com.fasterxml.jackson.databind.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS
            boolean r0 = r0.F(r4)
            r14.i(r0)
        L_0x00ef:
            java.lang.Object r7 = r14.n(r3)     // Catch:{ Exception -> 0x00f4 }
            goto L_0x0103
        L_0x00f4:
            r0 = move-exception
            r4 = r0
            java.lang.String r0 = r17.l()
            r15.b(r4, r0, r3)
            goto L_0x0103
        L_0x00fe:
            java.lang.Object r7 = com.fasterxml.jackson.databind.util.d.b(r0)
            r1 = r6
        L_0x0103:
            if (r7 != 0) goto L_0x0106
            goto L_0x00d0
        L_0x0106:
            java.lang.Class r0 = r7.getClass()
            boolean r0 = r0.isArray()
            if (r0 == 0) goto L_0x00ae
            java.lang.Object r0 = com.fasterxml.jackson.databind.util.b.a(r7)
            goto L_0x00aa
        L_0x0115:
            java.lang.Class[] r0 = r17.d()
            if (r0 != 0) goto L_0x0121
            com.fasterxml.jackson.databind.c r0 = r12.f5510b
            java.lang.Class[] r0 = r0.b()
        L_0x0121:
            r11 = r0
            com.fasterxml.jackson.databind.c r0 = r12.f5510b
            com.fasterxml.jackson.databind.util.a r4 = r0.j()
            r1 = r15
            r2 = r17
            r3 = r22
            r5 = r18
            r6 = r19
            r7 = r20
            com.fasterxml.jackson.databind.ser.c r0 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            com.fasterxml.jackson.databind.b r1 = r12.f5511c
            java.lang.Object r1 = r1.v(r14)
            if (r1 == 0) goto L_0x0146
            com.fasterxml.jackson.databind.o r1 = r13.i0(r14, r1)
            r0.h(r1)
        L_0x0146:
            com.fasterxml.jackson.databind.b r1 = r12.f5511c
            com.fasterxml.jackson.databind.util.l r1 = r1.V(r14)
            if (r1 == 0) goto L_0x0152
            com.fasterxml.jackson.databind.ser.c r0 = r0.z(r1)
        L_0x0152:
            return r0
        L_0x0153:
            r0 = move-exception
            r3 = r0
            if (r2 != 0) goto L_0x0162
            java.lang.String r0 = com.fasterxml.jackson.databind.util.f.m(r3)
            java.lang.Object r0 = r13.j(r5, r0)
            com.fasterxml.jackson.databind.ser.c r0 = (com.fasterxml.jackson.databind.ser.c) r0
            return r0
        L_0x0162:
            com.fasterxml.jackson.databind.c r0 = r12.f5510b
            java.lang.String r3 = com.fasterxml.jackson.databind.util.f.m(r3)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r0 = r13.e0(r0, r2, r3, r1)
            com.fasterxml.jackson.databind.ser.c r0 = (com.fasterxml.jackson.databind.ser.c) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.l.c(com.fasterxml.jackson.databind.b0, com.fasterxml.jackson.databind.introspect.s, com.fasterxml.jackson.databind.j, com.fasterxml.jackson.databind.o, q8.g, q8.g, com.fasterxml.jackson.databind.introspect.i, boolean):com.fasterxml.jackson.databind.ser.c");
    }

    /* access modifiers changed from: protected */
    public j d(com.fasterxml.jackson.databind.introspect.b bVar, boolean z10, j jVar) {
        j l02 = this.f5511c.l0(this.f5509a, bVar, jVar);
        boolean z11 = true;
        if (l02 != jVar) {
            Class s10 = l02.s();
            Class s11 = jVar.s();
            if (!s10.isAssignableFrom(s11) && !s11.isAssignableFrom(s10)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + bVar.c() + "': class " + s10.getName() + " not a super-type of (declared) class " + s11.getName());
            }
            jVar = l02;
            z10 = true;
        }
        e.b P = this.f5511c.P(bVar);
        if (!(P == null || P == e.b.DEFAULT_TYPING)) {
            if (P != e.b.STATIC) {
                z11 = false;
            }
            z10 = z11;
        }
        if (z10) {
            return jVar.S();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object e() {
        Object obj = this.f5512d;
        if (obj == null) {
            obj = this.f5510b.o(this.f5509a.b());
            if (obj == null) {
                obj = f5508g;
            }
            this.f5512d = obj;
        }
        if (obj == f5508g) {
            return null;
        }
        return this.f5512d;
    }
}
