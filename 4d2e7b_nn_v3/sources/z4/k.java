package z4;

import android.net.Uri;
import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.f0;
import com.facebook.imagepipeline.producers.l1;
import com.facebook.imagepipeline.producers.p1;
import g3.f;
import g5.c;
import g5.d;
import g5.e;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import x4.j;
import x4.x;
import y2.o;

public final class k {

    /* renamed from: o  reason: collision with root package name */
    public static final a f25026o = new a((DefaultConstructorMarker) null);

    /* renamed from: p  reason: collision with root package name */
    private static final CancellationException f25027p = new CancellationException("Prefetching is not enabled");

    /* renamed from: q  reason: collision with root package name */
    private static final CancellationException f25028q = new CancellationException("ImageRequest is null");

    /* renamed from: a  reason: collision with root package name */
    private final t f25029a;

    /* renamed from: b  reason: collision with root package name */
    private final o f25030b;

    /* renamed from: c  reason: collision with root package name */
    private final e f25031c;

    /* renamed from: d  reason: collision with root package name */
    private final d f25032d;

    /* renamed from: e  reason: collision with root package name */
    private final x f25033e;

    /* renamed from: f  reason: collision with root package name */
    private final x f25034f;

    /* renamed from: g  reason: collision with root package name */
    private final j f25035g;

    /* renamed from: h  reason: collision with root package name */
    private final j f25036h;

    /* renamed from: i  reason: collision with root package name */
    private final x4.k f25037i;

    /* renamed from: j  reason: collision with root package name */
    private final p1 f25038j;

    /* renamed from: k  reason: collision with root package name */
    private final o f25039k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicLong f25040l = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    private final o f25041m;

    /* renamed from: n  reason: collision with root package name */
    private final m f25042n;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25043a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                k5.b$b[] r0 = k5.b.C0299b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                k5.b$b r1 = k5.b.C0299b.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                k5.b$b r1 = k5.b.C0299b.SMALL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f25043a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: z4.k.b.<clinit>():void");
        }
    }

    public k(t tVar, Set set, Set set2, o oVar, x xVar, x xVar2, j jVar, j jVar2, x4.k kVar, p1 p1Var, o oVar2, o oVar3, t2.a aVar, m mVar) {
        m.f(tVar, "producerSequenceFactory");
        m.f(set, "requestListeners");
        m.f(set2, "requestListener2s");
        m.f(oVar, "isPrefetchEnabledSupplier");
        m.f(xVar, "bitmapMemoryCache");
        m.f(xVar2, "encodedMemoryCache");
        m.f(jVar, "mainBufferedDiskCache");
        m.f(jVar2, "smallImageBufferedDiskCache");
        m.f(kVar, "cacheKeyFactory");
        m.f(p1Var, "threadHandoffProducerQueue");
        m.f(oVar2, "suppressBitmapPrefetchingSupplier");
        m.f(oVar3, "lazyDataSource");
        m.f(mVar, "config");
        this.f25029a = tVar;
        this.f25030b = oVar;
        this.f25031c = new c(set);
        this.f25032d = new g5.b(set2);
        this.f25033e = xVar;
        this.f25034f = xVar2;
        this.f25035g = jVar;
        this.f25036h = jVar2;
        this.f25037i = kVar;
        this.f25038j = p1Var;
        this.f25039k = oVar2;
        this.f25041m = oVar3;
        this.f25042n = mVar;
    }

    private final i3.c A(d1 d1Var, k5.b bVar, b.c cVar, Object obj, y4.e eVar, e eVar2) {
        boolean z10;
        k5.b bVar2 = bVar;
        f0 f0Var = new f0(o(bVar, eVar2), this.f25032d);
        try {
            b.c a10 = b.c.a(bVar.j(), cVar);
            m.e(a10, "getMax(\n              im…ttedRequestLevelOnSubmit)");
            String l10 = l();
            n F = this.f25042n.F();
            if (F == null || !F.b() || !bVar.o()) {
                z10 = false;
            } else {
                z10 = true;
            }
            d1 d1Var2 = d1Var;
            return a5.d.f13680j.a(d1Var, new l1(bVar, l10, f0Var, obj, a10, true, z10, eVar, this.f25042n), f0Var);
        } catch (Exception e10) {
            i3.c b10 = i3.d.b(e10);
            m.e(b10, "{\n      DataSources.imme…taSource(exception)\n    }");
            return b10;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean f(r2.d dVar) {
        m.f(dVar, "it");
        return true;
    }

    public static /* synthetic */ i3.c j(k kVar, k5.b bVar, Object obj, b.c cVar, e eVar, String str, int i10, Object obj2) {
        b.c cVar2;
        e eVar2;
        String str2;
        if ((i10 & 4) != 0) {
            cVar2 = null;
        } else {
            cVar2 = cVar;
        }
        if ((i10 & 8) != 0) {
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        if ((i10 & 16) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        return kVar.i(bVar, obj, cVar2, eVar2, str2);
    }

    private final y2.m u(Uri uri) {
        return new i(uri);
    }

    /* access modifiers changed from: private */
    public static final boolean v(Uri uri, r2.d dVar) {
        m.f(uri, "$uri");
        m.f(dVar, "key");
        return dVar.a(uri);
    }

    private final i3.c y(d1 d1Var, k5.b bVar, b.c cVar, Object obj, e eVar, String str) {
        return z(d1Var, bVar, cVar, obj, eVar, str, (Map) null);
    }

    private final i3.c z(d1 d1Var, k5.b bVar, b.c cVar, Object obj, e eVar, String str, Map map) {
        i3.c cVar2;
        boolean z10;
        boolean z11;
        d1 d1Var2 = d1Var;
        k5.b bVar2 = bVar;
        b.c cVar3 = cVar;
        e eVar2 = eVar;
        Map map2 = map;
        if (!l5.b.d()) {
            f0 f0Var = new f0(o(bVar2, eVar2), this.f25032d);
            try {
                b.c a10 = b.c.a(bVar.j(), cVar3);
                m.e(a10, "getMax(\n                …ttedRequestLevelOnSubmit)");
                String l10 = l();
                if (!bVar.o()) {
                    if (f.o(bVar.u())) {
                        z11 = false;
                        l1 l1Var = r2;
                        l1 l1Var2 = new l1(bVar, l10, str, f0Var, obj, a10, false, z11, bVar.n(), this.f25042n);
                        l1 l1Var3 = l1Var;
                        l1Var3.m(map2);
                        i3.c F = a5.c.F(d1Var2, l1Var3, f0Var);
                        m.e(F, "{\n          val lowestPe…questListener2)\n        }");
                        return F;
                    }
                }
                z11 = true;
                l1 l1Var4 = l1Var2;
                l1 l1Var22 = new l1(bVar, l10, str, f0Var, obj, a10, false, z11, bVar.n(), this.f25042n);
                l1 l1Var32 = l1Var4;
                l1Var32.m(map2);
                i3.c F2 = a5.c.F(d1Var2, l1Var32, f0Var);
                m.e(F2, "{\n          val lowestPe…questListener2)\n        }");
                return F2;
            } catch (Exception e10) {
                i3.c b10 = i3.d.b(e10);
                m.e(b10, "{\n          DataSources.…urce(exception)\n        }");
                return b10;
            }
        } else {
            l5.b.a("ImagePipeline#submitFetchRequest");
            try {
                f0 f0Var2 = new f0(o(bVar2, eVar2), this.f25032d);
                b.c a11 = b.c.a(bVar.j(), cVar3);
                m.e(a11, "getMax(\n                …ttedRequestLevelOnSubmit)");
                String l11 = l();
                if (!bVar.o()) {
                    if (f.o(bVar.u())) {
                        z10 = false;
                        l1 l1Var5 = r2;
                        l1 l1Var6 = new l1(bVar, l11, str, f0Var2, obj, a11, false, z10, bVar.n(), this.f25042n);
                        l1 l1Var7 = l1Var5;
                        l1Var7.m(map2);
                        cVar2 = a5.c.F(d1Var2, l1Var7, f0Var2);
                        m.e(cVar2, "{\n          val lowestPe…questListener2)\n        }");
                        l5.b.b();
                        return cVar2;
                    }
                }
                z10 = true;
                l1 l1Var52 = l1Var6;
                l1 l1Var62 = new l1(bVar, l11, str, f0Var2, obj, a11, false, z10, bVar.n(), this.f25042n);
                l1 l1Var72 = l1Var52;
                l1Var72.m(map2);
                cVar2 = a5.c.F(d1Var2, l1Var72, f0Var2);
                m.e(cVar2, "{\n          val lowestPe…questListener2)\n        }");
            } catch (Exception e11) {
                cVar2 = i3.d.b(e11);
                m.e(cVar2, "{\n          DataSources.…urce(exception)\n        }");
            } catch (Throwable th) {
                l5.b.b();
                throw th;
            }
            l5.b.b();
            return cVar2;
        }
    }

    public final void c() {
        e();
        d();
    }

    public final void d() {
        this.f25035g.h();
        this.f25036h.h();
    }

    public final void e() {
        j jVar = new j();
        this.f25033e.a(jVar);
        this.f25034f.a(jVar);
    }

    public final i3.c g(k5.b bVar, Object obj) {
        return j(this, bVar, obj, (b.c) null, (e) null, (String) null, 24, (Object) null);
    }

    public final i3.c h(k5.b bVar, Object obj, b.c cVar) {
        m.f(cVar, "lowestPermittedRequestLevelOnSubmit");
        return j(this, bVar, obj, cVar, (e) null, (String) null, 16, (Object) null);
    }

    public final i3.c i(k5.b bVar, Object obj, b.c cVar, e eVar, String str) {
        if (bVar == null) {
            i3.c b10 = i3.d.b(new NullPointerException());
            m.e(b10, "immediateFailedDataSource(NullPointerException())");
            return b10;
        }
        try {
            d1 p10 = this.f25029a.p(bVar);
            if (cVar == null) {
                cVar = b.c.FULL_FETCH;
            }
            return y(p10, bVar, cVar, obj, eVar, str);
        } catch (Exception e10) {
            i3.c b11 = i3.d.b(e10);
            m.e(b11, "{\n      DataSources.imme…taSource(exception)\n    }");
            return b11;
        }
    }

    public final i3.c k(k5.b bVar, Object obj) {
        m.f(bVar, "imageRequest");
        return h(bVar, obj, b.c.BITMAP_MEMORY_CACHE);
    }

    public final String l() {
        return String.valueOf(this.f25040l.getAndIncrement());
    }

    public final x m() {
        return this.f25033e;
    }

    public final x4.k n() {
        return this.f25037i;
    }

    public final e o(k5.b bVar, e eVar) {
        if (bVar == null) {
            throw new IllegalStateException("Required value was null.".toString());
        } else if (eVar == null) {
            if (bVar.p() == null) {
                return this.f25031c;
            }
            return new c(this.f25031c, bVar.p());
        } else if (bVar.p() == null) {
            return new c(this.f25031c, eVar);
        } else {
            return new c(this.f25031c, eVar, bVar.p());
        }
    }

    public final boolean p(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.f25033e.f(u(uri));
    }

    public final boolean q(k5.b bVar) {
        if (bVar == null) {
            return false;
        }
        r2.d d10 = this.f25037i.d(bVar, (Object) null);
        x xVar = this.f25033e;
        m.e(d10, "cacheKey");
        c3.a aVar = xVar.get(d10);
        try {
            return c3.a.y(aVar);
        } finally {
            c3.a.m(aVar);
        }
    }

    public final boolean r(Uri uri) {
        if (s(uri, b.C0299b.SMALL) || s(uri, b.C0299b.DEFAULT)) {
            return true;
        }
        return false;
    }

    public final boolean s(Uri uri, b.C0299b bVar) {
        k5.b a10 = k5.c.w(uri).z(bVar).a();
        m.e(a10, "imageRequest");
        return t(a10);
    }

    public final boolean t(k5.b bVar) {
        m.f(bVar, "imageRequest");
        r2.d c10 = this.f25037i.c(bVar, (Object) null);
        b.C0299b c11 = bVar.c();
        m.e(c11, "imageRequest.cacheChoice");
        int i10 = b.f25043a[c11.ordinal()];
        if (i10 == 1) {
            j jVar = this.f25035g;
            m.e(c10, "cacheKey");
            return jVar.k(c10);
        } else if (i10 != 2) {
            return false;
        } else {
            j jVar2 = this.f25036h;
            m.e(c10, "cacheKey");
            return jVar2.k(c10);
        }
    }

    public final i3.c w(k5.b bVar, Object obj) {
        return x(bVar, obj, y4.e.MEDIUM, (e) null);
    }

    public final i3.c x(k5.b bVar, Object obj, y4.e eVar, e eVar2) {
        m.f(eVar, "priority");
        if (!((Boolean) this.f25030b.get()).booleanValue()) {
            i3.c b10 = i3.d.b(f25027p);
            m.e(b10, "immediateFailedDataSource(PREFETCH_EXCEPTION)");
            return b10;
        } else if (bVar == null) {
            i3.c b11 = i3.d.b(new NullPointerException("imageRequest is null"));
            m.e(b11, "{\n      DataSources.imme…eRequest is null\"))\n    }");
            return b11;
        } else {
            try {
                return A(this.f25029a.r(bVar), bVar, b.c.FULL_FETCH, obj, eVar, eVar2);
            } catch (Exception e10) {
                i3.c b12 = i3.d.b(e10);
                m.e(b12, "{\n        DataSources.im…Source(exception)\n      }");
                return b12;
            }
        }
    }
}
