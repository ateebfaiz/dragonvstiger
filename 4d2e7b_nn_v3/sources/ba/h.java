package ba;

import ga.c;
import y9.d;
import y9.m;
import y9.p;
import y9.q;
import y9.r;
import y9.s;

public final class h extends r {

    /* renamed from: b  reason: collision with root package name */
    private static final s f2530b = f(p.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final q f2531a;

    class a implements s {
        a() {
        }

        public r a(d dVar, fa.a aVar) {
            if (aVar.d() == Number.class) {
                return h.this;
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                ga.b[] r0 = ga.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2533a = r0
                ga.b r1 = ga.b.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2533a     // Catch:{ NoSuchFieldError -> 0x001d }
                ga.b r1 = ga.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                ga.b r1 = ga.b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ba.h.b.<clinit>():void");
        }
    }

    private h(q qVar) {
        this.f2531a = qVar;
    }

    public static s e(q qVar) {
        if (qVar == p.LAZILY_PARSED_NUMBER) {
            return f2530b;
        }
        return f(qVar);
    }

    private static s f(q qVar) {
        return new a();
    }

    /* renamed from: g */
    public Number b(ga.a aVar) {
        ga.b O = aVar.O();
        int i10 = b.f2533a[O.ordinal()];
        if (i10 == 1) {
            aVar.K();
            return null;
        } else if (i10 == 2 || i10 == 3) {
            return this.f2531a.a(aVar);
        } else {
            throw new m("Expecting number, got: " + O + "; at path " + aVar.getPath());
        }
    }

    /* renamed from: h */
    public void d(c cVar, Number number) {
        cVar.Q(number);
    }
}
