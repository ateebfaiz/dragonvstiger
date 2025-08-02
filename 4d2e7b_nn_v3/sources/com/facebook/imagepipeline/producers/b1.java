package com.facebook.imagepipeline.producers;

import e5.e;
import e5.f;
import e5.g;
import java.util.Map;
import java.util.concurrent.Executor;
import w4.d;
import y2.l;

public class b1 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    private final d1 f20034a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f20035b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Executor f20036c;

    private class a extends t {

        /* renamed from: c  reason: collision with root package name */
        private final g1 f20037c;

        /* renamed from: d  reason: collision with root package name */
        private final e1 f20038d;

        /* renamed from: e  reason: collision with root package name */
        private final k5.d f20039e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f20040f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public c3.a f20041g = null;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f20042h = 0;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f20043i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f20044j = false;

        /* renamed from: com.facebook.imagepipeline.producers.b1$a$a  reason: collision with other inner class name */
        class C0252a extends f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b1 f20046a;

            C0252a(b1 b1Var) {
                this.f20046a = b1Var;
            }

            public void a() {
                a.this.B();
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                c3.a p10;
                int q10;
                synchronized (a.this) {
                    p10 = a.this.f20041g;
                    q10 = a.this.f20042h;
                    a.this.f20041g = null;
                    a.this.f20043i = false;
                }
                if (c3.a.y(p10)) {
                    try {
                        a.this.y(p10, q10);
                    } finally {
                        c3.a.m(p10);
                    }
                }
                a.this.w();
            }
        }

        public a(n nVar, g1 g1Var, k5.d dVar, e1 e1Var) {
            super(nVar);
            this.f20037c = g1Var;
            this.f20039e = dVar;
            this.f20038d = e1Var;
            e1Var.h(new C0252a(b1.this));
        }

        private synchronized boolean A() {
            return this.f20040f;
        }

        /* access modifiers changed from: private */
        public void B() {
            if (x()) {
                o().a();
            }
        }

        private void C(Throwable th) {
            if (x()) {
                o().onFailure(th);
            }
        }

        private void D(c3.a aVar, int i10) {
            boolean d10 = c.d(i10);
            if ((!d10 && !A()) || (d10 && x())) {
                o().c(aVar, i10);
            }
        }

        private c3.a F(e eVar) {
            g gVar = (g) eVar;
            c3.a a10 = this.f20039e.a(gVar.x(), b1.this.f20035b);
            try {
                g d10 = f.d(a10, eVar.s(), gVar.l(), gVar.F());
                d10.m(gVar.getExtras());
                return c3.a.z(d10);
            } finally {
                c3.a.m(a10);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized boolean G() {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.f20040f     // Catch:{ all -> 0x001a }
                if (r0 != 0) goto L_0x001c
                boolean r0 = r1.f20043i     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x001c
                boolean r0 = r1.f20044j     // Catch:{ all -> 0x001a }
                if (r0 != 0) goto L_0x001c
                c3.a r0 = r1.f20041g     // Catch:{ all -> 0x001a }
                boolean r0 = c3.a.y(r0)     // Catch:{ all -> 0x001a }
                if (r0 == 0) goto L_0x001c
                r0 = 1
                r1.f20044j = r0     // Catch:{ all -> 0x001a }
                monitor-exit(r1)
                return r0
            L_0x001a:
                r0 = move-exception
                goto L_0x001f
            L_0x001c:
                monitor-exit(r1)
                r0 = 0
                return r0
            L_0x001f:
                monitor-exit(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.b1.a.G():boolean");
        }

        private boolean H(e eVar) {
            return eVar instanceof g;
        }

        private void I() {
            b1.this.f20036c.execute(new b());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
            c3.a.m(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            if (r2 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            I();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void J(c3.a r2, int r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.f20040f     // Catch:{ all -> 0x0007 }
                if (r0 == 0) goto L_0x0009
                monitor-exit(r1)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r2 = move-exception
                goto L_0x0024
            L_0x0009:
                c3.a r0 = r1.f20041g     // Catch:{ all -> 0x0007 }
                c3.a r2 = c3.a.j(r2)     // Catch:{ all -> 0x0007 }
                r1.f20041g = r2     // Catch:{ all -> 0x0007 }
                r1.f20042h = r3     // Catch:{ all -> 0x0007 }
                r2 = 1
                r1.f20043i = r2     // Catch:{ all -> 0x0007 }
                boolean r2 = r1.G()     // Catch:{ all -> 0x0007 }
                monitor-exit(r1)     // Catch:{ all -> 0x0007 }
                c3.a.m(r0)
                if (r2 == 0) goto L_0x0023
                r1.I()
            L_0x0023:
                return
            L_0x0024:
                monitor-exit(r1)     // Catch:{ all -> 0x0007 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.b1.a.J(c3.a, int):void");
        }

        /* access modifiers changed from: private */
        public void w() {
            boolean G;
            synchronized (this) {
                this.f20044j = false;
                G = G();
            }
            if (G) {
                I();
            }
        }

        private boolean x() {
            synchronized (this) {
                try {
                    if (this.f20040f) {
                        return false;
                    }
                    c3.a aVar = this.f20041g;
                    this.f20041g = null;
                    this.f20040f = true;
                    c3.a.m(aVar);
                    return true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void y(c3.a aVar, int i10) {
            l.b(Boolean.valueOf(c3.a.y(aVar)));
            if (!H((e) aVar.p())) {
                D(aVar, i10);
                return;
            }
            this.f20037c.e(this.f20038d, "PostprocessorProducer");
            c3.a aVar2 = null;
            try {
                aVar2 = F((e) aVar.p());
                g1 g1Var = this.f20037c;
                e1 e1Var = this.f20038d;
                g1Var.j(e1Var, "PostprocessorProducer", z(g1Var, e1Var, this.f20039e));
                D(aVar2, i10);
            } catch (Exception e10) {
                g1 g1Var2 = this.f20037c;
                e1 e1Var2 = this.f20038d;
                g1Var2.k(e1Var2, "PostprocessorProducer", e10, z(g1Var2, e1Var2, this.f20039e));
                C(e10);
            } finally {
                c3.a.m(aVar2);
            }
        }

        private Map z(g1 g1Var, e1 e1Var, k5.d dVar) {
            if (!g1Var.g(e1Var, "PostprocessorProducer")) {
                return null;
            }
            return y2.g.of("Postprocessor", dVar.getName());
        }

        /* access modifiers changed from: protected */
        /* renamed from: E */
        public void h(c3.a aVar, int i10) {
            if (c3.a.y(aVar)) {
                J(aVar, i10);
            } else if (c.d(i10)) {
                D((c3.a) null, i10);
            }
        }

        /* access modifiers changed from: protected */
        public void f() {
            B();
        }

        /* access modifiers changed from: protected */
        public void g(Throwable th) {
            C(th);
        }
    }

    class b extends t {
        /* access modifiers changed from: protected */
        /* renamed from: p */
        public void h(c3.a aVar, int i10) {
            if (!c.e(i10)) {
                o().c(aVar, i10);
            }
        }

        private b(a aVar) {
            super(aVar);
        }
    }

    public b1(d1 d1Var, d dVar, Executor executor) {
        this.f20034a = (d1) l.g(d1Var);
        this.f20035b = dVar;
        this.f20036c = (Executor) l.g(executor);
    }

    public void b(n nVar, e1 e1Var) {
        g1 z10 = e1Var.z();
        k5.d k10 = e1Var.b().k();
        l.g(k10);
        this.f20034a.b(new b(new a(nVar, z10, k10, e1Var)), e1Var);
    }
}
