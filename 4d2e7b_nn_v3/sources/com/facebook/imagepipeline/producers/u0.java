package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import l5.b;
import y2.l;
import y2.n;
import y4.e;

public abstract class u0 implements d1 {

    /* renamed from: a  reason: collision with root package name */
    final Map f20263a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d1 f20264b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f20265c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f20266d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f20267e;

    class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f20268a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final CopyOnWriteArraySet f20269b = n.a();

        /* renamed from: c  reason: collision with root package name */
        private Closeable f20270c;

        /* renamed from: d  reason: collision with root package name */
        private float f20271d;

        /* renamed from: e  reason: collision with root package name */
        private int f20272e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public e f20273f;

        /* renamed from: g  reason: collision with root package name */
        private b f20274g;

        /* renamed from: com.facebook.imagepipeline.producers.u0$a$a  reason: collision with other inner class name */
        class C0255a extends f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Pair f20276a;

            C0255a(Pair pair) {
                this.f20276a = pair;
            }

            public void a() {
                boolean remove;
                List list;
                List list2;
                List list3;
                e eVar;
                synchronized (a.this) {
                    try {
                        remove = a.this.f20269b.remove(this.f20276a);
                        list = null;
                        if (!remove) {
                            eVar = null;
                            list3 = null;
                        } else if (a.this.f20269b.isEmpty()) {
                            eVar = a.this.f20273f;
                            list3 = null;
                        } else {
                            List e10 = a.this.s();
                            list3 = a.this.t();
                            list2 = a.this.r();
                            List list4 = e10;
                            eVar = null;
                            list = list4;
                        }
                        list2 = list3;
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                e.e(list);
                e.f(list3);
                e.d(list2);
                if (eVar != null) {
                    if (!u0.this.f20265c || eVar.n()) {
                        eVar.o();
                    } else {
                        e.f(eVar.C(e.LOW));
                    }
                }
                if (remove) {
                    ((n) this.f20276a.first).a();
                }
            }

            public void b() {
                e.d(a.this.r());
            }

            public void c() {
                e.f(a.this.t());
            }

            public void d() {
                e.e(a.this.s());
            }
        }

        private class b extends c {
            /* access modifiers changed from: protected */
            public void f() {
                try {
                    if (l5.b.d()) {
                        l5.b.a("MultiplexProducer#onCancellation");
                    }
                    a.this.m(this);
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                } catch (Throwable th) {
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void g(Throwable th) {
                try {
                    if (l5.b.d()) {
                        l5.b.a("MultiplexProducer#onFailure");
                    }
                    a.this.n(this, th);
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                } catch (Throwable th2) {
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                    throw th2;
                }
            }

            /* access modifiers changed from: protected */
            public void i(float f10) {
                try {
                    if (l5.b.d()) {
                        l5.b.a("MultiplexProducer#onProgressUpdate");
                    }
                    a.this.p(this, f10);
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                } catch (Throwable th) {
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: o */
            public void h(Closeable closeable, int i10) {
                try {
                    if (l5.b.d()) {
                        l5.b.a("MultiplexProducer#onNewResult");
                    }
                    a.this.o(this, closeable, i10);
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                } catch (Throwable th) {
                    if (l5.b.d()) {
                        l5.b.b();
                    }
                    throw th;
                }
            }

            private b() {
            }
        }

        public a(Object obj) {
            this.f20268a = obj;
        }

        private void g(Pair pair, e1 e1Var) {
            e1Var.h(new C0255a(pair));
        }

        private void i(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }

        private synchronized boolean j() {
            Iterator it = this.f20269b.iterator();
            while (it.hasNext()) {
                if (((e1) ((Pair) it.next()).second).A()) {
                    return true;
                }
            }
            return false;
        }

        private synchronized boolean k() {
            Iterator it = this.f20269b.iterator();
            while (it.hasNext()) {
                if (!((e1) ((Pair) it.next()).second).n()) {
                    return false;
                }
            }
            return true;
        }

        private synchronized e l() {
            e eVar;
            eVar = e.LOW;
            Iterator it = this.f20269b.iterator();
            while (it.hasNext()) {
                eVar = e.b(eVar, ((e1) ((Pair) it.next()).second).getPriority());
            }
            return eVar;
        }

        /* access modifiers changed from: private */
        public void q(g3.e eVar) {
            boolean z10;
            synchronized (this) {
                try {
                    boolean z11 = false;
                    if (this.f20273f == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    l.b(Boolean.valueOf(z10));
                    if (this.f20274g == null) {
                        z11 = true;
                    }
                    l.b(Boolean.valueOf(z11));
                    if (this.f20269b.isEmpty()) {
                        u0.this.k(this.f20268a, this);
                        return;
                    }
                    e1 e1Var = (e1) ((Pair) this.f20269b.iterator().next()).second;
                    e eVar2 = new e(e1Var.b(), e1Var.getId(), e1Var.z(), e1Var.a(), e1Var.B(), k(), j(), l(), e1Var.j());
                    this.f20273f = eVar2;
                    eVar2.m(e1Var.getExtras());
                    if (eVar.b()) {
                        this.f20273f.w("started_as_prefetch", Boolean.valueOf(eVar.a()));
                    }
                    b bVar = new b();
                    this.f20274g = bVar;
                    e eVar3 = this.f20273f;
                    u0.this.f20264b.b(bVar, eVar3);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public synchronized List r() {
            e eVar = this.f20273f;
            if (eVar == null) {
                return null;
            }
            return eVar.r(j());
        }

        /* access modifiers changed from: private */
        public synchronized List s() {
            e eVar = this.f20273f;
            if (eVar == null) {
                return null;
            }
            return eVar.t(k());
        }

        /* access modifiers changed from: private */
        public synchronized List t() {
            e eVar = this.f20273f;
            if (eVar == null) {
                return null;
            }
            return eVar.C(l());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            com.facebook.imagepipeline.producers.e.e(r1);
            com.facebook.imagepipeline.producers.e.f(r2);
            com.facebook.imagepipeline.producers.e.d(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            if (r4 == r7.f20270c) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            if (r4 == null) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
            r4 = r7.f20275h.g(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            if (r4 == null) goto L_0x005c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
            if (r5 <= 0.0f) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r8.b(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
            r8.c(r4, r6);
            i(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
            g(r0, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            throw r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0065, code lost:
            throw r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean h(com.facebook.imagepipeline.producers.n r8, com.facebook.imagepipeline.producers.e1 r9) {
            /*
                r7 = this;
                android.util.Pair r0 = android.util.Pair.create(r8, r9)
                monitor-enter(r7)
                com.facebook.imagepipeline.producers.u0 r1 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0012 }
                java.lang.Object r2 = r7.f20268a     // Catch:{ all -> 0x0012 }
                com.facebook.imagepipeline.producers.u0$a r1 = r1.i(r2)     // Catch:{ all -> 0x0012 }
                if (r1 == r7) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0012 }
                r8 = 0
                return r8
            L_0x0012:
                r8 = move-exception
                goto L_0x0066
            L_0x0014:
                java.util.concurrent.CopyOnWriteArraySet r1 = r7.f20269b     // Catch:{ all -> 0x0012 }
                r1.add(r0)     // Catch:{ all -> 0x0012 }
                java.util.List r1 = r7.s()     // Catch:{ all -> 0x0012 }
                java.util.List r2 = r7.t()     // Catch:{ all -> 0x0012 }
                java.util.List r3 = r7.r()     // Catch:{ all -> 0x0012 }
                java.io.Closeable r4 = r7.f20270c     // Catch:{ all -> 0x0012 }
                float r5 = r7.f20271d     // Catch:{ all -> 0x0012 }
                int r6 = r7.f20272e     // Catch:{ all -> 0x0012 }
                monitor-exit(r7)     // Catch:{ all -> 0x0012 }
                com.facebook.imagepipeline.producers.e.e(r1)
                com.facebook.imagepipeline.producers.e.f(r2)
                com.facebook.imagepipeline.producers.e.d(r3)
                monitor-enter(r0)
                monitor-enter(r7)     // Catch:{ all -> 0x0054 }
                java.io.Closeable r1 = r7.f20270c     // Catch:{ all -> 0x0046 }
                if (r4 == r1) goto L_0x003d
                r4 = 0
                goto L_0x0048
            L_0x003d:
                if (r4 == 0) goto L_0x0048
                com.facebook.imagepipeline.producers.u0 r1 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0046 }
                java.io.Closeable r4 = r1.g(r4)     // Catch:{ all -> 0x0046 }
                goto L_0x0048
            L_0x0046:
                r8 = move-exception
                goto L_0x0062
            L_0x0048:
                monitor-exit(r7)     // Catch:{ all -> 0x0046 }
                if (r4 == 0) goto L_0x005c
                r1 = 0
                int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r1 <= 0) goto L_0x0056
                r8.b(r5)     // Catch:{ all -> 0x0054 }
                goto L_0x0056
            L_0x0054:
                r8 = move-exception
                goto L_0x0064
            L_0x0056:
                r8.c(r4, r6)     // Catch:{ all -> 0x0054 }
                r7.i(r4)     // Catch:{ all -> 0x0054 }
            L_0x005c:
                monitor-exit(r0)     // Catch:{ all -> 0x0054 }
                r7.g(r0, r9)
                r8 = 1
                return r8
            L_0x0062:
                monitor-exit(r7)     // Catch:{ all -> 0x0046 }
                throw r8     // Catch:{ all -> 0x0054 }
            L_0x0064:
                monitor-exit(r0)     // Catch:{ all -> 0x0054 }
                throw r8
            L_0x0066:
                monitor-exit(r7)     // Catch:{ all -> 0x0012 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.u0.a.h(com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.e1):boolean");
        }

        public void m(b bVar) {
            synchronized (this) {
                try {
                    if (this.f20274g == bVar) {
                        this.f20274g = null;
                        this.f20273f = null;
                        i(this.f20270c);
                        this.f20270c = null;
                        q(g3.e.UNSET);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
            if (r6.hasNext() == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
            r1 = (android.util.Pair) r6.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            ((com.facebook.imagepipeline.producers.e1) r1.second).z().k((com.facebook.imagepipeline.producers.e1) r1.second, com.facebook.imagepipeline.producers.u0.f(r5.f20275h), r7, (java.util.Map) null);
            ((com.facebook.imagepipeline.producers.n) r1.first).onFailure(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void n(com.facebook.imagepipeline.producers.u0.a.b r6, java.lang.Throwable r7) {
            /*
                r5 = this;
                monitor-enter(r5)
                com.facebook.imagepipeline.producers.u0$a$b r0 = r5.f20274g     // Catch:{ all -> 0x0007 }
                if (r0 == r6) goto L_0x0009
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r6 = move-exception
                goto L_0x0053
            L_0x0009:
                java.util.concurrent.CopyOnWriteArraySet r6 = r5.f20269b     // Catch:{ all -> 0x0007 }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0007 }
                java.util.concurrent.CopyOnWriteArraySet r0 = r5.f20269b     // Catch:{ all -> 0x0007 }
                r0.clear()     // Catch:{ all -> 0x0007 }
                com.facebook.imagepipeline.producers.u0 r0 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0007 }
                java.lang.Object r1 = r5.f20268a     // Catch:{ all -> 0x0007 }
                r0.k(r1, r5)     // Catch:{ all -> 0x0007 }
                java.io.Closeable r0 = r5.f20270c     // Catch:{ all -> 0x0007 }
                r5.i(r0)     // Catch:{ all -> 0x0007 }
                r0 = 0
                r5.f20270c = r0     // Catch:{ all -> 0x0007 }
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
            L_0x0024:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0052
                java.lang.Object r1 = r6.next()
                android.util.Pair r1 = (android.util.Pair) r1
                monitor-enter(r1)
                java.lang.Object r2 = r1.second     // Catch:{ all -> 0x004f }
                com.facebook.imagepipeline.producers.e1 r2 = (com.facebook.imagepipeline.producers.e1) r2     // Catch:{ all -> 0x004f }
                com.facebook.imagepipeline.producers.g1 r2 = r2.z()     // Catch:{ all -> 0x004f }
                java.lang.Object r3 = r1.second     // Catch:{ all -> 0x004f }
                com.facebook.imagepipeline.producers.e1 r3 = (com.facebook.imagepipeline.producers.e1) r3     // Catch:{ all -> 0x004f }
                com.facebook.imagepipeline.producers.u0 r4 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x004f }
                java.lang.String r4 = r4.f20266d     // Catch:{ all -> 0x004f }
                r2.k(r3, r4, r7, r0)     // Catch:{ all -> 0x004f }
                java.lang.Object r2 = r1.first     // Catch:{ all -> 0x004f }
                com.facebook.imagepipeline.producers.n r2 = (com.facebook.imagepipeline.producers.n) r2     // Catch:{ all -> 0x004f }
                r2.onFailure(r7)     // Catch:{ all -> 0x004f }
                monitor-exit(r1)     // Catch:{ all -> 0x004f }
                goto L_0x0024
            L_0x004f:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x004f }
                throw r6
            L_0x0052:
                return
            L_0x0053:
                monitor-exit(r5)     // Catch:{ all -> 0x0007 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.u0.a.n(com.facebook.imagepipeline.producers.u0$a$b, java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            if (r0.hasNext() == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
            r2 = (android.util.Pair) r0.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
            if (com.facebook.imagepipeline.producers.c.d(r9) == false) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            ((com.facebook.imagepipeline.producers.e1) r2.second).z().j((com.facebook.imagepipeline.producers.e1) r2.second, com.facebook.imagepipeline.producers.u0.f(r6.f20275h), (java.util.Map) null);
            r3 = r6.f20273f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
            if (r3 == null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
            ((com.facebook.imagepipeline.producers.e1) r2.second).m(r3.getExtras());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
            ((com.facebook.imagepipeline.producers.e1) r2.second).w(com.facebook.imagepipeline.producers.u0.c(r6.f20275h), java.lang.Integer.valueOf(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
            ((com.facebook.imagepipeline.producers.n) r2.first).c(r8, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
            throw r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void o(com.facebook.imagepipeline.producers.u0.a.b r7, java.io.Closeable r8, int r9) {
            /*
                r6 = this;
                monitor-enter(r6)
                com.facebook.imagepipeline.producers.u0$a$b r0 = r6.f20274g     // Catch:{ all -> 0x0007 }
                if (r0 == r7) goto L_0x000a
                monitor-exit(r6)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r7 = move-exception
                goto L_0x0093
            L_0x000a:
                java.io.Closeable r7 = r6.f20270c     // Catch:{ all -> 0x0007 }
                r6.i(r7)     // Catch:{ all -> 0x0007 }
                r7 = 0
                r6.f20270c = r7     // Catch:{ all -> 0x0007 }
                java.util.concurrent.CopyOnWriteArraySet r0 = r6.f20269b     // Catch:{ all -> 0x0007 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0007 }
                java.util.concurrent.CopyOnWriteArraySet r1 = r6.f20269b     // Catch:{ all -> 0x0007 }
                int r1 = r1.size()     // Catch:{ all -> 0x0007 }
                boolean r2 = com.facebook.imagepipeline.producers.c.e(r9)     // Catch:{ all -> 0x0007 }
                if (r2 == 0) goto L_0x002f
                com.facebook.imagepipeline.producers.u0 r2 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0007 }
                java.io.Closeable r2 = r2.g(r8)     // Catch:{ all -> 0x0007 }
                r6.f20270c = r2     // Catch:{ all -> 0x0007 }
                r6.f20272e = r9     // Catch:{ all -> 0x0007 }
                goto L_0x003b
            L_0x002f:
                java.util.concurrent.CopyOnWriteArraySet r2 = r6.f20269b     // Catch:{ all -> 0x0007 }
                r2.clear()     // Catch:{ all -> 0x0007 }
                com.facebook.imagepipeline.producers.u0 r2 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0007 }
                java.lang.Object r3 = r6.f20268a     // Catch:{ all -> 0x0007 }
                r2.k(r3, r6)     // Catch:{ all -> 0x0007 }
            L_0x003b:
                monitor-exit(r6)     // Catch:{ all -> 0x0007 }
            L_0x003c:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0092
                java.lang.Object r2 = r0.next()
                android.util.Pair r2 = (android.util.Pair) r2
                monitor-enter(r2)
                boolean r3 = com.facebook.imagepipeline.producers.c.d(r9)     // Catch:{ all -> 0x0074 }
                if (r3 == 0) goto L_0x0087
                java.lang.Object r3 = r2.second     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.e1 r3 = (com.facebook.imagepipeline.producers.e1) r3     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.g1 r3 = r3.z()     // Catch:{ all -> 0x0074 }
                java.lang.Object r4 = r2.second     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.e1 r4 = (com.facebook.imagepipeline.producers.e1) r4     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.u0 r5 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0074 }
                java.lang.String r5 = r5.f20266d     // Catch:{ all -> 0x0074 }
                r3.j(r4, r5, r7)     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.e r3 = r6.f20273f     // Catch:{ all -> 0x0074 }
                if (r3 == 0) goto L_0x0076
                java.lang.Object r4 = r2.second     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.e1 r4 = (com.facebook.imagepipeline.producers.e1) r4     // Catch:{ all -> 0x0074 }
                java.util.Map r3 = r3.getExtras()     // Catch:{ all -> 0x0074 }
                r4.m(r3)     // Catch:{ all -> 0x0074 }
                goto L_0x0076
            L_0x0074:
                r7 = move-exception
                goto L_0x0090
            L_0x0076:
                java.lang.Object r3 = r2.second     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.e1 r3 = (com.facebook.imagepipeline.producers.e1) r3     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.u0 r4 = com.facebook.imagepipeline.producers.u0.this     // Catch:{ all -> 0x0074 }
                java.lang.String r4 = r4.f20267e     // Catch:{ all -> 0x0074 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0074 }
                r3.w(r4, r5)     // Catch:{ all -> 0x0074 }
            L_0x0087:
                java.lang.Object r3 = r2.first     // Catch:{ all -> 0x0074 }
                com.facebook.imagepipeline.producers.n r3 = (com.facebook.imagepipeline.producers.n) r3     // Catch:{ all -> 0x0074 }
                r3.c(r8, r9)     // Catch:{ all -> 0x0074 }
                monitor-exit(r2)     // Catch:{ all -> 0x0074 }
                goto L_0x003c
            L_0x0090:
                monitor-exit(r2)     // Catch:{ all -> 0x0074 }
                throw r7
            L_0x0092:
                return
            L_0x0093:
                monitor-exit(r6)     // Catch:{ all -> 0x0007 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.u0.a.o(com.facebook.imagepipeline.producers.u0$a$b, java.io.Closeable, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
            if (r3.hasNext() == false) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            r0 = (android.util.Pair) r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            ((com.facebook.imagepipeline.producers.n) r0.first).b(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void p(com.facebook.imagepipeline.producers.u0.a.b r3, float r4) {
            /*
                r2 = this;
                monitor-enter(r2)
                com.facebook.imagepipeline.producers.u0$a$b r0 = r2.f20274g     // Catch:{ all -> 0x0007 }
                if (r0 == r3) goto L_0x0009
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r3 = move-exception
                goto L_0x002c
            L_0x0009:
                r2.f20271d = r4     // Catch:{ all -> 0x0007 }
                java.util.concurrent.CopyOnWriteArraySet r3 = r2.f20269b     // Catch:{ all -> 0x0007 }
                java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0007 }
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
            L_0x0012:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x002b
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                monitor-enter(r0)
                java.lang.Object r1 = r0.first     // Catch:{ all -> 0x0028 }
                com.facebook.imagepipeline.producers.n r1 = (com.facebook.imagepipeline.producers.n) r1     // Catch:{ all -> 0x0028 }
                r1.b(r4)     // Catch:{ all -> 0x0028 }
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                goto L_0x0012
            L_0x0028:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r3
            L_0x002b:
                return
            L_0x002c:
                monitor-exit(r2)     // Catch:{ all -> 0x0007 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.u0.a.p(com.facebook.imagepipeline.producers.u0$a$b, float):void");
        }
    }

    protected u0(d1 d1Var, String str, String str2) {
        this(d1Var, str, str2, false);
    }

    private synchronized a h(Object obj) {
        a aVar;
        aVar = new a(obj);
        this.f20263a.put(obj, aVar);
        return aVar;
    }

    public void b(n nVar, e1 e1Var) {
        a i10;
        boolean z10;
        try {
            if (b.d()) {
                b.a("MultiplexProducer#produceResults");
            }
            e1Var.z().e(e1Var, this.f20266d);
            Object j10 = j(e1Var);
            do {
                synchronized (this) {
                    i10 = i(j10);
                    if (i10 == null) {
                        i10 = h(j10);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                }
            } while (!i10.h(nVar, e1Var));
            if (z10) {
                i10.q(g3.e.c(e1Var.n()));
            }
            if (b.d()) {
                b.b();
            }
        } catch (Throwable th) {
            if (b.d()) {
                b.b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Closeable g(Closeable closeable);

    /* access modifiers changed from: protected */
    public synchronized a i(Object obj) {
        return (a) this.f20263a.get(obj);
    }

    /* access modifiers changed from: protected */
    public abstract Object j(e1 e1Var);

    /* access modifiers changed from: protected */
    public synchronized void k(Object obj, a aVar) {
        if (this.f20263a.get(obj) == aVar) {
            this.f20263a.remove(obj);
        }
    }

    protected u0(d1 d1Var, String str, String str2, boolean z10) {
        this.f20264b = d1Var;
        this.f20263a = new HashMap();
        this.f20265c = z10;
        this.f20266d = str;
        this.f20267e = str2;
    }
}
