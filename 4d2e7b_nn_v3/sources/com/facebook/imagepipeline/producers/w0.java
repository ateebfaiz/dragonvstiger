package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import b3.i;
import b3.k;
import c5.e;
import com.facebook.imagepipeline.producers.x0;
import e5.j;
import java.io.InputStream;
import java.util.Map;
import l5.b;

public class w0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    protected final i f20291a;

    /* renamed from: b  reason: collision with root package name */
    private final b3.a f20292b;

    /* renamed from: c  reason: collision with root package name */
    private final x0 f20293c;

    class a implements x0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c0 f20294a;

        a(c0 c0Var) {
            this.f20294a = c0Var;
        }

        public void a() {
            w0.this.k(this.f20294a);
        }

        public void b(InputStream inputStream, int i10) {
            if (b.d()) {
                b.a("NetworkFetcher->onResponse");
            }
            w0.this.m(this.f20294a, inputStream, i10);
            if (b.d()) {
                b.b();
            }
        }

        public void onFailure(Throwable th) {
            w0.this.l(this.f20294a, th);
        }
    }

    public w0(i iVar, b3.a aVar, x0 x0Var) {
        this.f20291a = iVar;
        this.f20292b = aVar;
        this.f20293c = x0Var;
    }

    protected static float e(int i10, int i11) {
        if (i11 > 0) {
            return ((float) i10) / ((float) i11);
        }
        return 1.0f - ((float) Math.exp(((double) (-i10)) / 50000.0d));
    }

    private Map f(c0 c0Var, int i10) {
        if (!c0Var.d().g(c0Var.b(), "NetworkFetchProducer")) {
            return null;
        }
        return this.f20293c.c(c0Var, i10);
    }

    protected static void j(k kVar, int i10, y4.a aVar, n nVar, e1 e1Var) {
        c3.a z10 = c3.a.z(kVar.a());
        j jVar = null;
        try {
            j jVar2 = new j(z10);
            try {
                jVar2.O(aVar);
                jVar2.K();
                nVar.c(jVar2, i10);
                j.h(jVar2);
                c3.a.m(z10);
            } catch (Throwable th) {
                th = th;
                jVar = jVar2;
                j.h(jVar);
                c3.a.m(z10);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j.h(jVar);
            c3.a.m(z10);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void k(c0 c0Var) {
        c0Var.d().d(c0Var.b(), "NetworkFetchProducer", (Map) null);
        c0Var.a().a();
    }

    /* access modifiers changed from: private */
    public void l(c0 c0Var, Throwable th) {
        c0Var.d().k(c0Var.b(), "NetworkFetchProducer", th, (Map) null);
        c0Var.d().c(c0Var.b(), "NetworkFetchProducer", false);
        c0Var.b().y("network");
        c0Var.a().onFailure(th);
    }

    private boolean n(c0 c0Var, e1 e1Var) {
        e p10 = e1Var.j().p();
        if (p10 == null || !p10.c() || !c0Var.b().A()) {
            return false;
        }
        return this.f20293c.b(c0Var);
    }

    public void b(n nVar, e1 e1Var) {
        e1Var.z().e(e1Var, "NetworkFetchProducer");
        c0 e10 = this.f20293c.e(nVar, e1Var);
        this.f20293c.d(e10, new a(e10));
    }

    /* access modifiers changed from: protected */
    public long g() {
        return SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: protected */
    public void h(k kVar, c0 c0Var) {
        Map f10 = f(c0Var, kVar.size());
        g1 d10 = c0Var.d();
        d10.j(c0Var.b(), "NetworkFetchProducer", f10);
        d10.c(c0Var.b(), "NetworkFetchProducer", true);
        c0Var.b().y("network");
        j(kVar, c0Var.e() | 1, c0Var.f(), c0Var.a(), c0Var.b());
    }

    /* access modifiers changed from: protected */
    public void i(k kVar, c0 c0Var) {
        if (n(c0Var, c0Var.b())) {
            long g10 = g();
            if (g10 - c0Var.c() >= 100) {
                c0Var.h(g10);
                c0Var.d().a(c0Var.b(), "NetworkFetchProducer", "intermediate_result");
                j(kVar, c0Var.e(), c0Var.f(), c0Var.a(), c0Var.b());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void m(c0 c0Var, InputStream inputStream, int i10) {
        k kVar;
        if (i10 > 0) {
            kVar = this.f20291a.e(i10);
        } else {
            kVar = this.f20291a.a();
        }
        byte[] bArr = (byte[]) this.f20292b.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.f20293c.a(c0Var, kVar.size());
                    h(kVar, c0Var);
                    this.f20292b.release(bArr);
                    kVar.close();
                    return;
                } else if (read > 0) {
                    kVar.write(bArr, 0, read);
                    i(kVar, c0Var);
                    c0Var.a().b(e(kVar.size(), i10));
                }
            } catch (Throwable th) {
                this.f20292b.release(bArr);
                kVar.close();
                throw th;
            }
        }
    }
}
