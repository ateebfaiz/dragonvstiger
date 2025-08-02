package com.facebook.imagepipeline.producers;

import b3.i;
import b3.k;
import com.facebook.imagepipeline.producers.g0;
import e5.j;
import g3.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import k5.b;
import m5.c;
import m5.d;
import y2.g;
import y2.l;
import y4.f;

public class k1 implements d1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Executor f20147a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f20148b;

    /* renamed from: c  reason: collision with root package name */
    private final d1 f20149c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20150d;

    /* renamed from: e  reason: collision with root package name */
    private final d f20151e;

    private class a extends t {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean f20152c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final d f20153d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final e1 f20154e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f20155f = false;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final g0 f20156g;

        /* renamed from: com.facebook.imagepipeline.producers.k1$a$a  reason: collision with other inner class name */
        class C0253a implements g0.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k1 f20158a;

            C0253a(k1 k1Var) {
                this.f20158a = k1Var;
            }

            public void a(j jVar, int i10) {
                if (jVar != null) {
                    a aVar = a.this;
                    aVar.v(jVar, i10, (c) l.g(aVar.f20153d.createImageTranscoder(jVar.v(), a.this.f20152c)));
                    return;
                }
                a.this.o().c((Object) null, i10);
            }
        }

        class b extends f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ k1 f20160a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ n f20161b;

            b(k1 k1Var, n nVar) {
                this.f20160a = k1Var;
                this.f20161b = nVar;
            }

            public void a() {
                a.this.f20156g.c();
                a.this.f20155f = true;
                this.f20161b.a();
            }

            public void b() {
                if (a.this.f20154e.A()) {
                    a.this.f20156g.h();
                }
            }
        }

        a(n nVar, e1 e1Var, boolean z10, d dVar) {
            super(nVar);
            this.f20154e = e1Var;
            Boolean r10 = e1Var.b().r();
            this.f20152c = r10 != null ? r10.booleanValue() : z10;
            this.f20153d = dVar;
            this.f20156g = new g0(k1.this.f20147a, new C0253a(k1.this), 100);
            e1Var.h(new b(k1.this, nVar));
        }

        private j A(j jVar) {
            if (this.f20154e.b().s().f() || jVar.l() == 0 || jVar.l() == -1) {
                return jVar;
            }
            return x(jVar, 0);
        }

        /* access modifiers changed from: private */
        public void v(j jVar, int i10, c cVar) {
            c3.a z10;
            j jVar2;
            this.f20154e.z().e(this.f20154e, "ResizeAndRotateProducer");
            k5.b b10 = this.f20154e.b();
            k a10 = k1.this.f20148b.a();
            Map map = null;
            try {
                m5.b c10 = cVar.c(jVar, a10, b10.s(), b10.q(), (q4.c) null, 85, jVar.n());
                if (c10.a() != 2) {
                    map = y(jVar, b10.q(), c10, cVar.b());
                    z10 = c3.a.z(a10.a());
                    jVar2 = new j(z10);
                    jVar2.R(q4.b.f23216b);
                    jVar2.K();
                    this.f20154e.z().j(this.f20154e, "ResizeAndRotateProducer", map);
                    if (c10.a() != 1) {
                        i10 |= 16;
                    }
                    o().c(jVar2, i10);
                    j.h(jVar2);
                    c3.a.m(z10);
                    a10.close();
                    return;
                }
                throw new RuntimeException("Error while transcoding the image");
            } catch (Exception e10) {
                this.f20154e.z().k(this.f20154e, "ResizeAndRotateProducer", e10, map);
                if (c.d(i10)) {
                    o().onFailure(e10);
                }
                a10.close();
            } catch (Throwable th) {
                a10.close();
                throw th;
            }
        }

        private void w(j jVar, int i10, q4.c cVar) {
            j jVar2;
            if (cVar == q4.b.f23216b || cVar == q4.b.f23226l) {
                jVar2 = A(jVar);
            } else {
                jVar2 = z(jVar);
            }
            o().c(jVar2, i10);
        }

        private j x(j jVar, int i10) {
            j b10 = j.b(jVar);
            if (b10 != null) {
                b10.S(i10);
            }
            return b10;
        }

        private Map y(j jVar, f fVar, m5.b bVar, String str) {
            String str2;
            if (!this.f20154e.z().g(this.f20154e, "ResizeAndRotateProducer")) {
                return null;
            }
            String str3 = jVar.getWidth() + "x" + jVar.getHeight();
            if (fVar != null) {
                str2 = fVar.f24926a + "x" + fVar.f24927b;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Image format", String.valueOf(jVar.v()));
            hashMap.put("Original size", str3);
            hashMap.put("Requested size", str2);
            hashMap.put("queueTime", String.valueOf(this.f20156g.f()));
            hashMap.put("Transcoder id", str);
            hashMap.put("Transcoding result", String.valueOf(bVar));
            return g.a(hashMap);
        }

        private j z(j jVar) {
            y4.g s10 = this.f20154e.b().s();
            if (s10.j() || !s10.i()) {
                return jVar;
            }
            return x(jVar, s10.h());
        }

        /* access modifiers changed from: protected */
        /* renamed from: B */
        public void h(j jVar, int i10) {
            if (!this.f20155f) {
                boolean d10 = c.d(i10);
                if (jVar != null) {
                    q4.c v10 = jVar.v();
                    e e10 = k1.h(this.f20154e.b(), jVar, (c) l.g(this.f20153d.createImageTranscoder(v10, this.f20152c)));
                    if (!d10 && e10 == e.UNSET) {
                        return;
                    }
                    if (e10 != e.YES) {
                        w(jVar, i10, v10);
                    } else if (this.f20156g.k(jVar, i10)) {
                        if (d10 || this.f20154e.A()) {
                            this.f20156g.h();
                        }
                    }
                } else if (d10) {
                    o().c((Object) null, 1);
                }
            }
        }
    }

    public k1(Executor executor, i iVar, d1 d1Var, boolean z10, d dVar) {
        this.f20147a = (Executor) l.g(executor);
        this.f20148b = (i) l.g(iVar);
        this.f20149c = (d1) l.g(d1Var);
        this.f20151e = (d) l.g(dVar);
        this.f20150d = z10;
    }

    private static boolean f(y4.g gVar, j jVar) {
        if (gVar.f() || (m5.e.e(gVar, jVar) == 0 && !g(gVar, jVar))) {
            return false;
        }
        return true;
    }

    private static boolean g(y4.g gVar, j jVar) {
        if (gVar.i() && !gVar.f()) {
            return m5.e.f22615b.contains(Integer.valueOf(jVar.F()));
        }
        jVar.P(0);
        return false;
    }

    /* access modifiers changed from: private */
    public static e h(b bVar, j jVar, c cVar) {
        boolean z10;
        if (jVar == null || jVar.v() == q4.c.f23230d) {
            return e.UNSET;
        }
        if (!cVar.d(jVar.v())) {
            return e.NO;
        }
        if (f(bVar.s(), jVar) || cVar.a(jVar, bVar.s(), bVar.q())) {
            z10 = true;
        } else {
            z10 = false;
        }
        return e.c(z10);
    }

    public void b(n nVar, e1 e1Var) {
        this.f20149c.b(new a(nVar, e1Var, this.f20150d, this.f20151e), e1Var);
    }
}
