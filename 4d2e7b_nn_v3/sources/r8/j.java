package r8;

import com.fasterxml.jackson.annotation.c0;
import com.fasterxml.jackson.databind.d;
import com.fasterxml.jackson.databind.z;
import java.util.Collection;
import l8.l;
import q8.c;
import q8.e;
import q8.f;
import q8.g;

public class j implements f {

    /* renamed from: a  reason: collision with root package name */
    protected c0.b f12953a;

    /* renamed from: b  reason: collision with root package name */
    protected c0.a f12954b;

    /* renamed from: c  reason: collision with root package name */
    protected String f12955c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f12956d = false;

    /* renamed from: e  reason: collision with root package name */
    protected Class f12957e;

    /* renamed from: f  reason: collision with root package name */
    protected e f12958f;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12959a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f12960b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0078 */
        static {
            /*
                com.fasterxml.jackson.annotation.c0$b[] r0 = com.fasterxml.jackson.annotation.c0.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12960b = r0
                r1 = 1
                com.fasterxml.jackson.annotation.c0$b r2 = com.fasterxml.jackson.annotation.c0.b.DEDUCTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f12960b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fasterxml.jackson.annotation.c0$b r3 = com.fasterxml.jackson.annotation.c0.b.CLASS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f12960b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fasterxml.jackson.annotation.c0$b r4 = com.fasterxml.jackson.annotation.c0.b.MINIMAL_CLASS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f12960b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fasterxml.jackson.annotation.c0$b r5 = com.fasterxml.jackson.annotation.c0.b.NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f12960b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.fasterxml.jackson.annotation.c0$b r6 = com.fasterxml.jackson.annotation.c0.b.NONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = f12960b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.fasterxml.jackson.annotation.c0$b r6 = com.fasterxml.jackson.annotation.c0.b.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.fasterxml.jackson.annotation.c0$a[] r5 = com.fasterxml.jackson.annotation.c0.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f12959a = r5
                com.fasterxml.jackson.annotation.c0$a r6 = com.fasterxml.jackson.annotation.c0.a.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x005a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f12959a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.fasterxml.jackson.annotation.c0$a r5 = com.fasterxml.jackson.annotation.c0.a.PROPERTY     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f12959a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f12959a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.EXTERNAL_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f12959a     // Catch:{ NoSuchFieldError -> 0x0082 }
                com.fasterxml.jackson.annotation.c0$a r1 = com.fasterxml.jackson.annotation.c0.a.EXISTING_PROPERTY     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r8.j.a.<clinit>():void");
        }
    }

    public static j l() {
        return new j().f(c0.b.NONE, (e) null);
    }

    public g d(z zVar, com.fasterxml.jackson.databind.j jVar, Collection collection) {
        if (this.f12953a == c0.b.NONE) {
            return null;
        }
        if (jVar.J() && !g(zVar, jVar)) {
            return null;
        }
        e i10 = i(zVar, jVar, m(zVar), collection, true, false);
        if (this.f12953a == c0.b.DEDUCTION) {
            return new b(i10, (d) null, this.f12955c);
        }
        int i11 = a.f12959a[this.f12954b.ordinal()];
        if (i11 == 1) {
            return new a(i10, (d) null);
        }
        if (i11 == 2) {
            return new d(i10, (d) null, this.f12955c);
        }
        if (i11 == 3) {
            return new e(i10, (d) null);
        }
        if (i11 == 4) {
            return new c(i10, (d) null, this.f12955c);
        }
        if (i11 == 5) {
            return new b(i10, (d) null, this.f12955c);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f12954b);
    }

    /* access modifiers changed from: protected */
    public boolean g(l lVar, com.fasterxml.jackson.databind.j jVar) {
        return false;
    }

    /* renamed from: h */
    public j c(Class cls) {
        this.f12957e = cls;
        return this;
    }

    /* access modifiers changed from: protected */
    public e i(l lVar, com.fasterxml.jackson.databind.j jVar, c cVar, Collection collection, boolean z10, boolean z11) {
        e eVar = this.f12958f;
        if (eVar != null) {
            return eVar;
        }
        c0.b bVar = this.f12953a;
        if (bVar != null) {
            int i10 = a.f12960b[bVar.ordinal()];
            if (i10 == 1 || i10 == 2) {
                return f.e(jVar, lVar, cVar);
            }
            if (i10 == 3) {
                return h.f(jVar, lVar, cVar);
            }
            if (i10 == 4) {
                return l.e(lVar, jVar, collection, z10, z11);
            }
            if (i10 == 5) {
                return null;
            }
            throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f12953a);
        }
        throw new IllegalStateException("Cannot build, 'init()' not yet called");
    }

    /* renamed from: j */
    public j e(c0.a aVar) {
        if (aVar != null) {
            this.f12954b = aVar;
            return this;
        }
        throw new IllegalArgumentException("includeAs cannot be null");
    }

    /* renamed from: k */
    public j f(c0.b bVar, e eVar) {
        if (bVar != null) {
            this.f12953a = bVar;
            this.f12958f = eVar;
            this.f12955c = bVar.a();
            return this;
        }
        throw new IllegalArgumentException("idType cannot be null");
    }

    public c m(l lVar) {
        return lVar.y();
    }

    /* renamed from: n */
    public j a(boolean z10) {
        this.f12956d = z10;
        return this;
    }

    /* renamed from: o */
    public j b(String str) {
        if (str == null || str.isEmpty()) {
            str = this.f12953a.a();
        }
        this.f12955c = str;
        return this;
    }
}
