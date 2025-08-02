package com.facebook.imagepipeline.producers;

import android.net.Uri;
import b3.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.d;
import k0.f;
import x4.j;
import x4.k;
import y2.g;
import y2.l;

public class y0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f20307a;

    /* renamed from: b  reason: collision with root package name */
    private final k f20308b;

    /* renamed from: c  reason: collision with root package name */
    private final i f20309c;

    /* renamed from: d  reason: collision with root package name */
    private final b3.a f20310d;

    /* renamed from: e  reason: collision with root package name */
    private final d1 f20311e;

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g1 f20312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e1 f20313b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n f20314c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r2.d f20315d;

        a(g1 g1Var, e1 e1Var, n nVar, r2.d dVar) {
            this.f20312a = g1Var;
            this.f20313b = e1Var;
            this.f20314c = nVar;
            this.f20315d = dVar;
        }

        /* renamed from: b */
        public Void a(f fVar) {
            if (y0.g(fVar)) {
                this.f20312a.d(this.f20313b, "PartialDiskCacheProducer", (Map) null);
                this.f20314c.a();
            } else if (fVar.n()) {
                this.f20312a.k(this.f20313b, "PartialDiskCacheProducer", fVar.i(), (Map) null);
                y0.this.i(this.f20314c, this.f20313b, this.f20315d, (e5.j) null);
            } else {
                e5.j jVar = (e5.j) fVar.j();
                if (jVar != null) {
                    g1 g1Var = this.f20312a;
                    e1 e1Var = this.f20313b;
                    g1Var.j(e1Var, "PartialDiskCacheProducer", y0.f(g1Var, e1Var, true, jVar.A()));
                    y4.a e10 = y4.a.e(jVar.A() - 1);
                    jVar.O(e10);
                    int A = jVar.A();
                    k5.b b10 = this.f20313b.b();
                    if (e10.b(b10.b())) {
                        this.f20313b.k("disk", "partial");
                        this.f20312a.c(this.f20313b, "PartialDiskCacheProducer", true);
                        this.f20314c.c(jVar, 9);
                    } else {
                        this.f20314c.c(jVar, 8);
                        y0.this.i(this.f20314c, new l1(k5.c.b(b10).y(y4.a.c(A - 1)).a(), this.f20313b), this.f20315d, jVar);
                    }
                } else {
                    g1 g1Var2 = this.f20312a;
                    e1 e1Var2 = this.f20313b;
                    g1Var2.j(e1Var2, "PartialDiskCacheProducer", y0.f(g1Var2, e1Var2, false, 0));
                    y0.this.i(this.f20314c, this.f20313b, this.f20315d, jVar);
                }
            }
            return null;
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f20317a;

        b(AtomicBoolean atomicBoolean) {
            this.f20317a = atomicBoolean;
        }

        public void a() {
            this.f20317a.set(true);
        }
    }

    private static class c extends t {

        /* renamed from: c  reason: collision with root package name */
        private final j f20319c;

        /* renamed from: d  reason: collision with root package name */
        private final r2.d f20320d;

        /* renamed from: e  reason: collision with root package name */
        private final i f20321e;

        /* renamed from: f  reason: collision with root package name */
        private final b3.a f20322f;

        /* renamed from: g  reason: collision with root package name */
        private final e5.j f20323g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f20324h;

        private void p(InputStream inputStream, OutputStream outputStream, int i10) {
            byte[] bArr = (byte[]) this.f20322f.get(16384);
            int i11 = i10;
            while (i11 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i11));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i11 -= read;
                    }
                } catch (Throwable th) {
                    this.f20322f.release(bArr);
                    throw th;
                }
            }
            this.f20322f.release(bArr);
            if (i11 > 0) {
                throw new IOException(String.format((Locale) null, "Failed to read %d bytes - finished %d short", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
            }
        }

        private b3.k q(e5.j jVar, e5.j jVar2) {
            int i10 = ((y4.a) l.g(jVar2.m())).f24892a;
            b3.k e10 = this.f20321e.e(jVar2.A() + i10);
            p(jVar.y(), e10, i10);
            p(jVar2.y(), e10, jVar2.A());
            return e10;
        }

        private void s(b3.k kVar) {
            e5.j jVar;
            Throwable th;
            c3.a z10 = c3.a.z(kVar.a());
            try {
                jVar = new e5.j(z10);
                try {
                    jVar.K();
                    o().c(jVar, 1);
                    e5.j.h(jVar);
                    c3.a.m(z10);
                } catch (Throwable th2) {
                    th = th2;
                    e5.j.h(jVar);
                    c3.a.m(z10);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                jVar = null;
                th = th4;
                e5.j.h(jVar);
                c3.a.m(z10);
                throw th;
            }
        }

        /* renamed from: r */
        public void h(e5.j jVar, int i10) {
            if (!c.e(i10)) {
                if (this.f20323g != null && jVar != null && jVar.m() != null) {
                    try {
                        s(q(this.f20323g, jVar));
                    } catch (IOException e10) {
                        z2.a.k("PartialDiskCacheProducer", "Error while merging image data", e10);
                        o().onFailure(e10);
                    } catch (Throwable th) {
                        jVar.close();
                        this.f20323g.close();
                        throw th;
                    }
                    jVar.close();
                    this.f20323g.close();
                    this.f20319c.s(this.f20320d);
                } else if (!this.f20324h || !c.m(i10, 8) || !c.d(i10) || jVar == null || jVar.v() == q4.c.f23230d) {
                    o().c(jVar, i10);
                } else {
                    this.f20319c.p(this.f20320d, jVar);
                    o().c(jVar, i10);
                }
            }
        }

        private c(n nVar, j jVar, r2.d dVar, i iVar, b3.a aVar, e5.j jVar2, boolean z10) {
            super(nVar);
            this.f20319c = jVar;
            this.f20320d = dVar;
            this.f20321e = iVar;
            this.f20322f = aVar;
            this.f20323g = jVar2;
            this.f20324h = z10;
        }
    }

    public y0(j jVar, k kVar, i iVar, b3.a aVar, d1 d1Var) {
        this.f20307a = jVar;
        this.f20308b = kVar;
        this.f20309c = iVar;
        this.f20310d = aVar;
        this.f20311e = d1Var;
    }

    private static Uri e(k5.b bVar) {
        return bVar.u().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    static Map f(g1 g1Var, e1 e1Var, boolean z10, int i10) {
        if (!g1Var.g(e1Var, "PartialDiskCacheProducer")) {
            return null;
        }
        if (z10) {
            return g.of("cached_value_found", String.valueOf(z10), "encodedImageSize", String.valueOf(i10));
        }
        return g.of("cached_value_found", String.valueOf(z10));
    }

    /* access modifiers changed from: private */
    public static boolean g(f fVar) {
        if (fVar.l() || (fVar.n() && (fVar.i() instanceof CancellationException))) {
            return true;
        }
        return false;
    }

    private d h(n nVar, e1 e1Var, r2.d dVar) {
        return new a(e1Var.z(), e1Var, nVar, dVar);
    }

    /* access modifiers changed from: private */
    public void i(n nVar, e1 e1Var, r2.d dVar, e5.j jVar) {
        this.f20311e.b(new c(nVar, this.f20307a, dVar, this.f20309c, this.f20310d, jVar, e1Var.b().x(32)), e1Var);
    }

    private void j(AtomicBoolean atomicBoolean, e1 e1Var) {
        e1Var.h(new b(atomicBoolean));
    }

    public void b(n nVar, e1 e1Var) {
        k5.b b10 = e1Var.b();
        boolean x10 = e1Var.b().x(16);
        boolean x11 = e1Var.b().x(32);
        if (x10 || x11) {
            g1 z10 = e1Var.z();
            z10.e(e1Var, "PartialDiskCacheProducer");
            r2.d a10 = this.f20308b.a(b10, e(b10), e1Var.a());
            if (!x10) {
                z10.j(e1Var, "PartialDiskCacheProducer", f(z10, e1Var, false, 0));
                i(nVar, e1Var, a10, (e5.j) null);
                return;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f20307a.m(a10, atomicBoolean).e(h(nVar, e1Var, a10));
            j(atomicBoolean, e1Var);
            return;
        }
        this.f20311e.b(nVar, e1Var);
    }
}
