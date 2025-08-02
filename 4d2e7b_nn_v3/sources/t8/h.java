package t8;

import com.fasterxml.jackson.annotation.p;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.b0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.l;
import com.fasterxml.jackson.databind.o;
import com.fasterxml.jackson.databind.ser.i;
import i8.b;
import java.util.Map;
import q8.g;
import t8.k;

public class h extends com.fasterxml.jackson.databind.ser.h implements i {
    public static final Object Y = p.a.NON_EMPTY;
    protected final Object C;
    protected final boolean X;

    /* renamed from: c  reason: collision with root package name */
    protected final d f13074c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f13075d;

    /* renamed from: e  reason: collision with root package name */
    protected final j f13076e;

    /* renamed from: f  reason: collision with root package name */
    protected final j f13077f;

    /* renamed from: g  reason: collision with root package name */
    protected final j f13078g;

    /* renamed from: h  reason: collision with root package name */
    protected o f13079h;

    /* renamed from: i  reason: collision with root package name */
    protected o f13080i;

    /* renamed from: j  reason: collision with root package name */
    protected final g f13081j;

    /* renamed from: w  reason: collision with root package name */
    protected k f13082w;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13083a;

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
                f13083a = r0
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13083a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_ABSENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13083a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_EMPTY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13083a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f13083a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.NON_NULL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f13083a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.p$a r1 = com.fasterxml.jackson.annotation.p.a.ALWAYS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t8.h.a.<clinit>():void");
        }
    }

    public h(j jVar, j jVar2, j jVar3, boolean z10, g gVar, d dVar) {
        super(jVar);
        this.f13076e = jVar;
        this.f13077f = jVar2;
        this.f13078g = jVar3;
        this.f13075d = z10;
        this.f13081j = gVar;
        this.f13074c = dVar;
        this.f13082w = k.c();
        this.C = null;
        this.X = false;
    }

    /* access modifiers changed from: protected */
    public final o A(k kVar, Class cls, b0 b0Var) {
        k.d h10 = kVar.h(cls, b0Var, this.f13074c);
        k kVar2 = h10.f13099b;
        if (kVar != kVar2) {
            this.f13082w = kVar2;
        }
        return h10.f13098a;
    }

    public j B() {
        return this.f13078g;
    }

    /* renamed from: C */
    public boolean d(b0 b0Var, Map.Entry entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this.X;
        }
        if (this.C == null) {
            return false;
        }
        o oVar = this.f13080i;
        if (oVar == null) {
            Class<?> cls = value.getClass();
            o j10 = this.f13082w.j(cls);
            if (j10 == null) {
                try {
                    oVar = A(this.f13082w, cls, b0Var);
                } catch (l unused) {
                    return false;
                }
            } else {
                oVar = j10;
            }
        }
        Object obj = this.C;
        if (obj == Y) {
            return oVar.d(b0Var, value);
        }
        return obj.equals(value);
    }

    /* renamed from: D */
    public void f(Map.Entry entry, f fVar, b0 b0Var) {
        fVar.p0(entry);
        E(entry, fVar, b0Var);
        fVar.Q();
    }

    /* access modifiers changed from: protected */
    public void E(Map.Entry entry, f fVar, b0 b0Var) {
        o oVar;
        o oVar2;
        g gVar = this.f13081j;
        Object key = entry.getKey();
        if (key == null) {
            oVar = b0Var.C(this.f13077f, this.f13074c);
        } else {
            oVar = this.f13079h;
        }
        Object value = entry.getValue();
        if (value != null) {
            oVar2 = this.f13080i;
            if (oVar2 == null) {
                Class<?> cls = value.getClass();
                o j10 = this.f13082w.j(cls);
                if (j10 != null) {
                    oVar2 = j10;
                } else if (this.f13078g.x()) {
                    oVar2 = z(this.f13082w, b0Var.t(this.f13078g, cls), b0Var);
                } else {
                    oVar2 = A(this.f13082w, cls, b0Var);
                }
            }
            Object obj = this.C;
            if (obj != null && ((obj == Y && oVar2.d(b0Var, value)) || this.C.equals(value))) {
                return;
            }
        } else if (!this.X) {
            oVar2 = b0Var.O();
        } else {
            return;
        }
        oVar.f(key, fVar, b0Var);
        if (gVar == null) {
            try {
                oVar2.f(value, fVar, b0Var);
            } catch (Exception e10) {
                w(b0Var, e10, entry, "" + key);
            }
        } else {
            oVar2.h(value, fVar, b0Var, gVar);
        }
    }

    /* renamed from: F */
    public void h(Map.Entry entry, f fVar, b0 b0Var, g gVar) {
        fVar.B(entry);
        b g10 = gVar.g(fVar, gVar.d(entry, com.fasterxml.jackson.core.k.START_OBJECT));
        E(entry, fVar, b0Var);
        gVar.h(fVar, g10);
    }

    public h G(Object obj, boolean z10) {
        if (this.C == obj && this.X == z10) {
            return this;
        }
        return new h(this, this.f13074c, this.f13081j, this.f13079h, this.f13080i, obj, z10);
    }

    public h H(d dVar, o oVar, o oVar2, Object obj, boolean z10) {
        return new h(this, dVar, this.f13081j, oVar, oVar2, obj, z10);
    }

    public o a(b0 b0Var, d dVar) {
        com.fasterxml.jackson.databind.introspect.i iVar;
        o oVar;
        o oVar2;
        o X2;
        boolean z10;
        Object obj;
        p.b c10;
        p.a f10;
        boolean Z;
        com.fasterxml.jackson.databind.b L = b0Var.L();
        Object obj2 = null;
        if (dVar == null) {
            iVar = null;
        } else {
            iVar = dVar.b();
        }
        if (iVar == null || L == null) {
            oVar2 = null;
            oVar = null;
        } else {
            Object p10 = L.p(iVar);
            if (p10 != null) {
                oVar = b0Var.i0(iVar, p10);
            } else {
                oVar = null;
            }
            Object f11 = L.f(iVar);
            if (f11 != null) {
                oVar2 = b0Var.i0(iVar, f11);
            } else {
                oVar2 = null;
            }
        }
        if (oVar2 == null) {
            oVar2 = this.f13080i;
        }
        o n10 = n(b0Var, dVar, oVar2);
        if (n10 == null && this.f13075d && !this.f13078g.H()) {
            n10 = b0Var.y(this.f13078g, dVar);
        }
        o oVar3 = n10;
        if (oVar == null) {
            oVar = this.f13079h;
        }
        if (oVar == null) {
            X2 = b0Var.A(this.f13077f, dVar);
        } else {
            X2 = b0Var.X(oVar, dVar);
        }
        o oVar4 = X2;
        Object obj3 = this.C;
        boolean z11 = this.X;
        if (dVar == null || (c10 = dVar.c(b0Var.f(), (Class) null)) == null || (f10 = c10.f()) == p.a.USE_DEFAULTS) {
            obj = obj3;
        } else {
            int i10 = a.f13083a[f10.ordinal()];
            z11 = true;
            if (i10 == 1) {
                obj2 = com.fasterxml.jackson.databind.util.d.b(this.f13078g);
                if (obj2 != null && obj2.getClass().isArray()) {
                    obj2 = com.fasterxml.jackson.databind.util.b.a(obj2);
                }
            } else if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        obj2 = b0Var.Y((s) null, c10.e());
                        if (obj2 != null) {
                            Z = b0Var.Z(obj2);
                        }
                    } else if (i10 != 5) {
                        Z = false;
                    }
                    z10 = Z;
                    obj = obj2;
                    return H(dVar, oVar4, oVar3, obj, z10);
                }
                obj2 = Y;
            } else if (this.f13078g.d()) {
                obj2 = Y;
            }
            obj = obj2;
        }
        z10 = z11;
        return H(dVar, oVar4, oVar3, obj, z10);
    }

    public com.fasterxml.jackson.databind.ser.h x(g gVar) {
        return new h(this, this.f13074c, gVar, this.f13079h, this.f13080i, this.C, this.X);
    }

    /* access modifiers changed from: protected */
    public final o z(k kVar, j jVar, b0 b0Var) {
        k.d g10 = kVar.g(jVar, b0Var, this.f13074c);
        k kVar2 = g10.f13099b;
        if (kVar != kVar2) {
            this.f13082w = kVar2;
        }
        return g10.f13098a;
    }

    protected h(h hVar, d dVar, g gVar, o oVar, o oVar2, Object obj, boolean z10) {
        super(Map.class, false);
        this.f13076e = hVar.f13076e;
        this.f13077f = hVar.f13077f;
        this.f13078g = hVar.f13078g;
        this.f13075d = hVar.f13075d;
        this.f13081j = hVar.f13081j;
        this.f13079h = oVar;
        this.f13080i = oVar2;
        this.f13082w = k.c();
        this.f13074c = hVar.f13074c;
        this.C = obj;
        this.X = z10;
    }
}
