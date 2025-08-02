package ba;

import aa.h;
import ga.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import y9.d;
import y9.p;
import y9.q;
import y9.r;
import y9.s;

public final class i extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final s f2534c = f(p.DOUBLE);

    /* renamed from: a  reason: collision with root package name */
    private final d f2535a;

    /* renamed from: b  reason: collision with root package name */
    private final q f2536b;

    class a implements s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f2537a;

        a(q qVar) {
            this.f2537a = qVar;
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Object.class) {
                return new i(dVar, this.f2537a, (a) null);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2538a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                ga.b[] r0 = ga.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2538a = r0
                ga.b r1 = ga.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2538a     // Catch:{ NoSuchFieldError -> 0x001d }
                ga.b r1 = ga.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2538a     // Catch:{ NoSuchFieldError -> 0x0028 }
                ga.b r1 = ga.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2538a     // Catch:{ NoSuchFieldError -> 0x0033 }
                ga.b r1 = ga.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2538a     // Catch:{ NoSuchFieldError -> 0x003e }
                ga.b r1 = ga.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2538a     // Catch:{ NoSuchFieldError -> 0x0049 }
                ga.b r1 = ga.b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ba.i.b.<clinit>():void");
        }
    }

    /* synthetic */ i(d dVar, q qVar, a aVar) {
        this(dVar, qVar);
    }

    public static s e(q qVar) {
        if (qVar == p.DOUBLE) {
            return f2534c;
        }
        return f(qVar);
    }

    private static s f(q qVar) {
        return new a(qVar);
    }

    private Object g(ga.a aVar, ga.b bVar) {
        int i10 = b.f2538a[bVar.ordinal()];
        if (i10 == 3) {
            return aVar.M();
        }
        if (i10 == 4) {
            return this.f2536b.a(aVar);
        }
        if (i10 == 5) {
            return Boolean.valueOf(aVar.C());
        }
        if (i10 == 6) {
            aVar.K();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(ga.a aVar, ga.b bVar) {
        int i10 = b.f2538a[bVar.ordinal()];
        if (i10 == 1) {
            aVar.a();
            return new ArrayList();
        } else if (i10 != 2) {
            return null;
        } else {
            aVar.b();
            return new h();
        }
    }

    public Object b(ga.a aVar) {
        String str;
        boolean z10;
        ga.b O = aVar.O();
        Object h10 = h(aVar, O);
        if (h10 == null) {
            return g(aVar, O);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.y()) {
                if (h10 instanceof Map) {
                    str = aVar.I();
                } else {
                    str = null;
                }
                ga.b O2 = aVar.O();
                Object h11 = h(aVar, O2);
                if (h11 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (h11 == null) {
                    h11 = g(aVar, O2);
                }
                if (h10 instanceof List) {
                    ((List) h10).add(h11);
                } else {
                    ((Map) h10).put(str, h11);
                }
                if (z10) {
                    arrayDeque.addLast(h10);
                    h10 = h11;
                }
            } else {
                if (h10 instanceof List) {
                    aVar.m();
                } else {
                    aVar.n();
                }
                if (arrayDeque.isEmpty()) {
                    return h10;
                }
                h10 = arrayDeque.removeLast();
            }
        }
    }

    public void d(c cVar, Object obj) {
        if (obj == null) {
            cVar.B();
            return;
        }
        r l10 = this.f2535a.l(obj.getClass());
        if (l10 instanceof i) {
            cVar.j();
            cVar.n();
            return;
        }
        l10.d(cVar, obj);
    }

    private i(d dVar, q qVar) {
        this.f2535a = dVar;
        this.f2536b = qVar;
    }
}
