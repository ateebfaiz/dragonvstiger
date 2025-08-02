package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.i;
import com.fasterxml.jackson.annotation.i0;
import com.fasterxml.jackson.annotation.l0;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.ser.c;
import com.fasterxml.jackson.databind.ser.e;
import com.fasterxml.jackson.databind.ser.i;
import com.fasterxml.jackson.databind.ser.o;
import com.fasterxml.jackson.databind.util.l;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.z;
import i8.b;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import q8.g;
import t8.h;
import t8.t;

public abstract class d extends h0 implements i, o {
    protected static final c[] C = new c[0];

    /* renamed from: w  reason: collision with root package name */
    protected static final w f5536w = new w("#object-ref");

    /* renamed from: c  reason: collision with root package name */
    protected final j f5537c;

    /* renamed from: d  reason: collision with root package name */
    protected final c[] f5538d;

    /* renamed from: e  reason: collision with root package name */
    protected final c[] f5539e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.ser.a f5540f;

    /* renamed from: g  reason: collision with root package name */
    protected final Object f5541g;

    /* renamed from: h  reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.introspect.i f5542h;

    /* renamed from: i  reason: collision with root package name */
    protected final t8.i f5543i;

    /* renamed from: j  reason: collision with root package name */
    protected final i.c f5544j;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5545a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.fasterxml.jackson.annotation.i$c[] r0 = com.fasterxml.jackson.annotation.i.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5545a = r0
                com.fasterxml.jackson.annotation.i$c r1 = com.fasterxml.jackson.annotation.i.c.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5545a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.i$c r1 = com.fasterxml.jackson.annotation.i.c.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5545a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.i$c r1 = com.fasterxml.jackson.annotation.i.c.NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.d.a.<clinit>():void");
        }
    }

    protected d(j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar);
        this.f5537c = jVar;
        this.f5538d = cVarArr;
        this.f5539e = cVarArr2;
        if (eVar == null) {
            this.f5542h = null;
            this.f5540f = null;
            this.f5541g = null;
            this.f5543i = null;
            this.f5544j = null;
            return;
        }
        this.f5542h = eVar.h();
        this.f5540f = eVar.c();
        this.f5541g = eVar.e();
        this.f5543i = eVar.f();
        this.f5544j = eVar.d().c((i.d) null).i();
    }

    private static final c[] D(c[] cVarArr, l lVar) {
        if (cVarArr == null || cVarArr.length == 0 || lVar == null || lVar == l.f5692a) {
            return cVarArr;
        }
        int length = cVarArr.length;
        c[] cVarArr2 = new c[length];
        for (int i10 = 0; i10 < length; i10++) {
            c cVar = cVarArr[i10];
            if (cVar != null) {
                cVarArr2[i10] = cVar.t(lVar);
            }
        }
        return cVarArr2;
    }

    /* access modifiers changed from: protected */
    public final b A(g gVar, Object obj, k kVar) {
        com.fasterxml.jackson.databind.introspect.i iVar = this.f5542h;
        if (iVar == null) {
            return gVar.d(obj, kVar);
        }
        Object n10 = iVar.n(obj);
        if (n10 == null) {
            n10 = "";
        }
        return gVar.e(obj, kVar, n10);
    }

    /* access modifiers changed from: protected */
    public abstract d B();

    /* access modifiers changed from: protected */
    public com.fasterxml.jackson.databind.o C(b0 b0Var, c cVar) {
        com.fasterxml.jackson.databind.introspect.i b10;
        Object M;
        com.fasterxml.jackson.databind.b L = b0Var.L();
        if (L == null || (b10 = cVar.b()) == null || (M = L.M(b10)) == null) {
            return null;
        }
        b0Var.e(cVar.b(), M);
        b0Var.h();
        throw null;
    }

    /* access modifiers changed from: protected */
    public void E(Object obj, f fVar, b0 b0Var) {
        c[] cVarArr;
        String str = "[anySetter]";
        if (this.f5539e == null || b0Var.K() == null) {
            cVarArr = this.f5538d;
        } else {
            cVarArr = this.f5539e;
        }
        try {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    cVar.v(obj, fVar, b0Var);
                }
            }
            com.fasterxml.jackson.databind.ser.a aVar = this.f5540f;
            if (aVar != null) {
                aVar.b(obj, fVar, b0Var);
            }
        } catch (Exception e10) {
            if (0 != cVarArr.length) {
                str = cVarArr[0].m();
            }
            w(b0Var, e10, obj, str);
        } catch (StackOverflowError e11) {
            com.fasterxml.jackson.databind.l lVar = new com.fasterxml.jackson.databind.l(fVar, "Infinite recursion (StackOverflowError)", e11);
            if (0 != cVarArr.length) {
                str = cVarArr[0].m();
            }
            lVar.e(obj, str);
            throw lVar;
        }
    }

    /* access modifiers changed from: protected */
    public void F(Object obj, f fVar, b0 b0Var) {
        if (this.f5539e != null) {
            Class K = b0Var.K();
        }
        t(b0Var, this.f5541g, obj);
        E(obj, fVar, b0Var);
    }

    /* access modifiers changed from: protected */
    public abstract d G(Set set, Set set2);

    public abstract d H(Object obj);

    public abstract d I(t8.i iVar);

    /* access modifiers changed from: protected */
    public abstract d J(c[] cVarArr, c[] cVarArr2);

    public com.fasterxml.jackson.databind.o a(b0 b0Var, com.fasterxml.jackson.databind.d dVar) {
        com.fasterxml.jackson.databind.introspect.i iVar;
        i.c cVar;
        c[] cVarArr;
        Set set;
        Set set2;
        int i10;
        Object obj;
        d dVar2;
        t8.i c10;
        c[] cVarArr2;
        Set set3;
        Object obj2;
        Set set4;
        c cVar2;
        com.fasterxml.jackson.databind.introspect.b0 x10;
        b0 b0Var2 = b0Var;
        com.fasterxml.jackson.databind.d dVar3 = dVar;
        int i11 = 2;
        com.fasterxml.jackson.databind.b L = b0Var.L();
        if (dVar3 == null || L == null) {
            iVar = null;
        } else {
            iVar = dVar.b();
        }
        z N = b0Var.f();
        i.d q10 = q(b0Var2, dVar3, this.f5555a);
        if (q10 == null || !q10.n()) {
            cVar = null;
        } else {
            cVar = q10.i();
            if (!(cVar == i.c.ANY || cVar == this.f5544j)) {
                if (this.f5537c.E()) {
                    int i12 = a.f5545a[cVar.ordinal()];
                    if (i12 == 1 || i12 == 2 || i12 == 3) {
                        return b0Var2.W(m.z(this.f5537c.s(), b0Var.f(), N.C(this.f5537c), q10), dVar3);
                    }
                } else if (cVar == i.c.NATURAL && (!this.f5537c.I() || !Map.class.isAssignableFrom(this.f5555a))) {
                    Class<Map.Entry> cls = Map.Entry.class;
                    if (cls.isAssignableFrom(this.f5555a)) {
                        j j10 = this.f5537c.j(cls);
                        return b0Var2.W(new h(this.f5537c, j10.i(0), j10.i(1), false, (g) null, dVar), dVar3);
                    }
                }
            }
        }
        t8.i iVar2 = this.f5543i;
        if (iVar != null) {
            set = L.C(N, iVar).h();
            Set e10 = L.F(N, iVar).e();
            com.fasterxml.jackson.databind.introspect.b0 w10 = L.w(iVar);
            if (w10 == null) {
                if (!(iVar2 == null || (x10 = L.x(iVar, (com.fasterxml.jackson.databind.introspect.b0) null)) == null)) {
                    iVar2 = this.f5543i.b(x10.b());
                }
                cVarArr = null;
                set4 = e10;
            } else {
                com.fasterxml.jackson.databind.introspect.b0 x11 = L.x(iVar, w10);
                Class<l0> c11 = x11.c();
                j jVar = b0Var.h().G(b0Var2.d(c11), i0.class)[0];
                if (c11 == l0.class) {
                    String c12 = x11.d().c();
                    int length = this.f5538d.length;
                    i10 = 0;
                    while (true) {
                        if (i10 == length) {
                            j jVar2 = this.f5537c;
                            String Q = com.fasterxml.jackson.databind.util.f.Q(c());
                            String P = com.fasterxml.jackson.databind.util.f.P(c12);
                            set3 = e10;
                            Object[] objArr = new Object[i11];
                            objArr[0] = Q;
                            objArr[1] = P;
                            b0Var2.j(jVar2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                        } else {
                            set3 = e10;
                        }
                        cVar2 = this.f5538d[i10];
                        if (c12.equals(cVar2.m())) {
                            break;
                        }
                        i10++;
                        e10 = set3;
                        i11 = 2;
                    }
                    cVarArr = null;
                    iVar2 = t8.i.a(cVar2.getType(), (w) null, new t8.j(x11, cVar2), x11.b());
                    obj = L.k(iVar);
                    if (obj == null || ((obj2 = this.f5541g) != null && obj.equals(obj2))) {
                        obj = cVarArr;
                    }
                    set2 = set3;
                } else {
                    set4 = e10;
                    cVarArr = null;
                    iVar2 = t8.i.a(jVar, x11.d(), b0Var2.i(iVar, x11), x11.b());
                }
            }
            i10 = 0;
            obj = L.k(iVar);
            obj = cVarArr;
            set2 = set3;
        } else {
            cVarArr = null;
            i10 = 0;
            obj = null;
            set2 = null;
            set = null;
        }
        if (i10 > 0) {
            c[] cVarArr3 = this.f5538d;
            c[] cVarArr4 = (c[]) Arrays.copyOf(cVarArr3, cVarArr3.length);
            c cVar3 = cVarArr4[i10];
            System.arraycopy(cVarArr4, 0, cVarArr4, 1, i10);
            cVarArr4[0] = cVar3;
            c[] cVarArr5 = this.f5539e;
            if (cVarArr5 == null) {
                cVarArr2 = cVarArr;
            } else {
                c[] cVarArr6 = (c[]) Arrays.copyOf(cVarArr5, cVarArr5.length);
                c cVar4 = cVarArr6[i10];
                System.arraycopy(cVarArr6, 0, cVarArr6, 1, i10);
                cVarArr6[0] = cVar4;
                cVarArr2 = cVarArr6;
            }
            dVar2 = J(cVarArr4, cVarArr2);
        } else {
            dVar2 = this;
        }
        if (!(iVar2 == null || (c10 = iVar2.c(b0Var2.I(iVar2.f13084a, dVar3))) == this.f5543i)) {
            dVar2 = dVar2.I(c10);
        }
        if ((set != null && !set.isEmpty()) || set2 != null) {
            dVar2 = dVar2.G(set, set2);
        }
        if (obj != null) {
            dVar2 = dVar2.H(obj);
        }
        if (cVar == null) {
            cVar = this.f5544j;
        }
        if (cVar == i.c.ARRAY) {
            return dVar2.B();
        }
        return dVar2;
    }

    public void b(b0 b0Var) {
        int i10;
        c cVar;
        g gVar;
        com.fasterxml.jackson.databind.o D;
        c cVar2;
        c[] cVarArr = this.f5539e;
        if (cVarArr == null) {
            i10 = 0;
        } else {
            i10 = cVarArr.length;
        }
        int length = this.f5538d.length;
        for (int i11 = 0; i11 < length; i11++) {
            c cVar3 = this.f5538d[i11];
            if (!cVar3.A() && !cVar3.q() && (D = b0Var.D(cVar3)) != null) {
                cVar3.h(D);
                if (i11 < i10 && (cVar2 = this.f5539e[i11]) != null) {
                    cVar2.h(D);
                }
            }
            if (!cVar3.s()) {
                com.fasterxml.jackson.databind.o C2 = C(b0Var, cVar3);
                if (C2 == null) {
                    j n10 = cVar3.n();
                    if (n10 == null) {
                        n10 = cVar3.getType();
                        if (!n10.F()) {
                            if (n10.C() || n10.h() > 0) {
                                cVar3.y(n10);
                            }
                        }
                    }
                    com.fasterxml.jackson.databind.o I = b0Var.I(n10, cVar3);
                    if (!n10.C() || (gVar = (g) n10.l().v()) == null || !(I instanceof com.fasterxml.jackson.databind.ser.h)) {
                        C2 = I;
                    } else {
                        C2 = ((com.fasterxml.jackson.databind.ser.h) I).y(gVar);
                    }
                }
                if (i11 >= i10 || (cVar = this.f5539e[i11]) == null) {
                    cVar3.i(C2);
                } else {
                    cVar.i(C2);
                }
            }
        }
        com.fasterxml.jackson.databind.ser.a aVar = this.f5540f;
        if (aVar != null) {
            aVar.c(b0Var);
        }
    }

    public void h(Object obj, f fVar, b0 b0Var, g gVar) {
        if (this.f5543i != null) {
            y(obj, fVar, b0Var, gVar);
            return;
        }
        b A = A(gVar, obj, k.START_OBJECT);
        gVar.g(fVar, A);
        fVar.B(obj);
        if (this.f5541g != null) {
            F(obj, fVar, b0Var);
        } else {
            E(obj, fVar, b0Var);
        }
        gVar.h(fVar, A);
    }

    public boolean j() {
        if (this.f5543i != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void x(Object obj, f fVar, b0 b0Var, g gVar, t tVar) {
        t8.i iVar = this.f5543i;
        b A = A(gVar, obj, k.START_OBJECT);
        gVar.g(fVar, A);
        fVar.B(obj);
        tVar.b(fVar, b0Var, iVar);
        if (this.f5541g != null) {
            F(obj, fVar, b0Var);
        } else {
            E(obj, fVar, b0Var);
        }
        gVar.h(fVar, A);
    }

    /* access modifiers changed from: protected */
    public final void y(Object obj, f fVar, b0 b0Var, g gVar) {
        t8.i iVar = this.f5543i;
        t E = b0Var.E(obj, iVar.f13086c);
        if (!E.c(fVar, b0Var, iVar)) {
            Object a10 = E.a(obj);
            if (iVar.f13088e) {
                iVar.f13087d.f(a10, fVar, b0Var);
            } else {
                x(obj, fVar, b0Var, gVar, E);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void z(Object obj, f fVar, b0 b0Var, boolean z10) {
        t8.i iVar = this.f5543i;
        t E = b0Var.E(obj, iVar.f13086c);
        if (!E.c(fVar, b0Var, iVar)) {
            Object a10 = E.a(obj);
            if (iVar.f13088e) {
                iVar.f13087d.f(a10, fVar, b0Var);
                return;
            }
            if (z10) {
                fVar.p0(obj);
            }
            E.b(fVar, b0Var, iVar);
            if (this.f5541g != null) {
                F(obj, fVar, b0Var);
            } else {
                E(obj, fVar, b0Var);
            }
            if (z10) {
                fVar.Q();
            }
        }
    }

    protected d(d dVar, c[] cVarArr, c[] cVarArr2) {
        super(dVar.f5555a);
        this.f5537c = dVar.f5537c;
        this.f5538d = cVarArr;
        this.f5539e = cVarArr2;
        this.f5542h = dVar.f5542h;
        this.f5540f = dVar.f5540f;
        this.f5543i = dVar.f5543i;
        this.f5541g = dVar.f5541g;
        this.f5544j = dVar.f5544j;
    }

    protected d(d dVar, t8.i iVar) {
        this(dVar, iVar, dVar.f5541g);
    }

    protected d(d dVar, t8.i iVar, Object obj) {
        super(dVar.f5555a);
        this.f5537c = dVar.f5537c;
        this.f5538d = dVar.f5538d;
        this.f5539e = dVar.f5539e;
        this.f5542h = dVar.f5542h;
        this.f5540f = dVar.f5540f;
        this.f5543i = iVar;
        this.f5541g = obj;
        this.f5544j = dVar.f5544j;
    }

    /* JADX WARNING: type inference failed for: r11v11, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected d(com.fasterxml.jackson.databind.ser.std.d r10, java.util.Set r11, java.util.Set r12) {
        /*
            r9 = this;
            java.lang.Class r0 = r10.f5555a
            r9.<init>((java.lang.Class) r0)
            com.fasterxml.jackson.databind.j r0 = r10.f5537c
            r9.f5537c = r0
            com.fasterxml.jackson.databind.ser.c[] r0 = r10.f5538d
            com.fasterxml.jackson.databind.ser.c[] r1 = r10.f5539e
            int r2 = r0.length
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r4 = 0
            if (r1 != 0) goto L_0x0018
            r5 = r4
            goto L_0x001d
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
        L_0x001d:
            r6 = 0
        L_0x001e:
            if (r6 >= r2) goto L_0x003a
            r7 = r0[r6]
            java.lang.String r8 = r7.m()
            boolean r8 = com.fasterxml.jackson.databind.util.i.b(r8, r11, r12)
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r3.add(r7)
            if (r1 == 0) goto L_0x0037
            r7 = r1[r6]
            r5.add(r7)
        L_0x0037:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x003a:
            int r11 = r3.size()
            com.fasterxml.jackson.databind.ser.c[] r11 = new com.fasterxml.jackson.databind.ser.c[r11]
            java.lang.Object[] r11 = r3.toArray(r11)
            com.fasterxml.jackson.databind.ser.c[] r11 = (com.fasterxml.jackson.databind.ser.c[]) r11
            r9.f5538d = r11
            if (r5 != 0) goto L_0x004b
            goto L_0x0058
        L_0x004b:
            int r11 = r5.size()
            com.fasterxml.jackson.databind.ser.c[] r11 = new com.fasterxml.jackson.databind.ser.c[r11]
            java.lang.Object[] r11 = r5.toArray(r11)
            r4 = r11
            com.fasterxml.jackson.databind.ser.c[] r4 = (com.fasterxml.jackson.databind.ser.c[]) r4
        L_0x0058:
            r9.f5539e = r4
            com.fasterxml.jackson.databind.introspect.i r11 = r10.f5542h
            r9.f5542h = r11
            com.fasterxml.jackson.databind.ser.a r11 = r10.f5540f
            r9.f5540f = r11
            t8.i r11 = r10.f5543i
            r9.f5543i = r11
            java.lang.Object r11 = r10.f5541g
            r9.f5541g = r11
            com.fasterxml.jackson.annotation.i$c r10 = r10.f5544j
            r9.f5544j = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.d.<init>(com.fasterxml.jackson.databind.ser.std.d, java.util.Set, java.util.Set):void");
    }

    protected d(d dVar, l lVar) {
        this(dVar, D(dVar.f5538d, lVar), D(dVar.f5539e, lVar));
    }
}
