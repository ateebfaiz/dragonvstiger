package i3;

import java.util.List;
import y2.j;
import y2.l;
import y2.o;

public class g implements o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f22072a;

    private class a extends a {

        /* renamed from: h  reason: collision with root package name */
        private int f22073h = 0;

        /* renamed from: i  reason: collision with root package name */
        private c f22074i = null;

        /* renamed from: j  reason: collision with root package name */
        private c f22075j = null;

        /* renamed from: i3.g$a$a  reason: collision with other inner class name */
        private class C0288a implements e {
            public void a(c cVar) {
                a.this.q(Math.max(a.this.getProgress(), cVar.getProgress()));
            }

            public void b(c cVar) {
                a.this.C(cVar);
            }

            public void c(c cVar) {
            }

            public void d(c cVar) {
                if (cVar.a()) {
                    a.this.D(cVar);
                } else if (cVar.b()) {
                    a.this.C(cVar);
                }
            }

            private C0288a() {
            }
        }

        public a() {
            if (!F()) {
                n(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized y2.o A() {
            /*
                r3 = this;
                monitor-enter(r3)
                boolean r0 = r3.i()     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x002b
                int r0 = r3.f22073h     // Catch:{ all -> 0x0029 }
                i3.g r1 = i3.g.this     // Catch:{ all -> 0x0029 }
                java.util.List r1 = r1.f22072a     // Catch:{ all -> 0x0029 }
                int r1 = r1.size()     // Catch:{ all -> 0x0029 }
                if (r0 >= r1) goto L_0x002b
                i3.g r0 = i3.g.this     // Catch:{ all -> 0x0029 }
                java.util.List r0 = r0.f22072a     // Catch:{ all -> 0x0029 }
                int r1 = r3.f22073h     // Catch:{ all -> 0x0029 }
                int r2 = r1 + 1
                r3.f22073h = r2     // Catch:{ all -> 0x0029 }
                java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0029 }
                y2.o r0 = (y2.o) r0     // Catch:{ all -> 0x0029 }
                monitor-exit(r3)
                return r0
            L_0x0029:
                r0 = move-exception
                goto L_0x002e
            L_0x002b:
                monitor-exit(r3)
                r0 = 0
                return r0
            L_0x002e:
                monitor-exit(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.g.a.A():y2.o");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0014, code lost:
            y(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void B(i3.c r2, boolean r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                i3.c r0 = r1.f22074i     // Catch:{ all -> 0x0018 }
                if (r2 != r0) goto L_0x001a
                i3.c r0 = r1.f22075j     // Catch:{ all -> 0x0018 }
                if (r2 != r0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                if (r0 == 0) goto L_0x0011
                if (r3 == 0) goto L_0x000f
                goto L_0x0011
            L_0x000f:
                r0 = 0
                goto L_0x0013
            L_0x0011:
                r1.f22075j = r2     // Catch:{ all -> 0x0018 }
            L_0x0013:
                monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                r1.y(r0)
                return
            L_0x0018:
                r2 = move-exception
                goto L_0x001c
            L_0x001a:
                monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                return
            L_0x001c:
                monitor-exit(r1)     // Catch:{ all -> 0x0018 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.g.a.B(i3.c, boolean):void");
        }

        /* access modifiers changed from: private */
        public void C(c cVar) {
            if (x(cVar)) {
                if (cVar != z()) {
                    y(cVar);
                }
                if (!F()) {
                    o(cVar.c(), cVar.getExtras());
                }
            }
        }

        /* access modifiers changed from: private */
        public void D(c cVar) {
            B(cVar, cVar.b());
            if (cVar == z()) {
                s((Object) null, cVar.b(), cVar.getExtras());
            }
        }

        private synchronized boolean E(c cVar) {
            if (i()) {
                return false;
            }
            this.f22074i = cVar;
            return true;
        }

        private boolean F() {
            c cVar;
            o A = A();
            if (A != null) {
                cVar = (c) A.get();
            } else {
                cVar = null;
            }
            if (!E(cVar) || cVar == null) {
                y(cVar);
                return false;
            }
            cVar.e(new C0288a(), w2.a.a());
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized boolean x(i3.c r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.i()     // Catch:{ all -> 0x0012 }
                if (r0 != 0) goto L_0x0014
                i3.c r0 = r1.f22074i     // Catch:{ all -> 0x0012 }
                if (r2 == r0) goto L_0x000c
                goto L_0x0014
            L_0x000c:
                r2 = 0
                r1.f22074i = r2     // Catch:{ all -> 0x0012 }
                monitor-exit(r1)
                r2 = 1
                return r2
            L_0x0012:
                r2 = move-exception
                goto L_0x0017
            L_0x0014:
                monitor-exit(r1)
                r2 = 0
                return r2
            L_0x0017:
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.g.a.x(i3.c):boolean");
        }

        private void y(c cVar) {
            if (cVar != null) {
                cVar.close();
            }
        }

        private synchronized c z() {
            return this.f22075j;
        }

        public synchronized boolean a() {
            boolean z10;
            c z11 = z();
            if (z11 == null || !z11.a()) {
                z10 = false;
            } else {
                z10 = true;
            }
            return z10;
        }

        public boolean close() {
            synchronized (this) {
                try {
                    if (!super.close()) {
                        return false;
                    }
                    c cVar = this.f22074i;
                    this.f22074i = null;
                    c cVar2 = this.f22075j;
                    this.f22075j = null;
                    y(cVar2);
                    y(cVar);
                    return true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public synchronized Object getResult() {
            Object obj;
            c z10 = z();
            if (z10 != null) {
                obj = z10.getResult();
            } else {
                obj = null;
            }
            return obj;
        }
    }

    private g(List list) {
        l.c(!list.isEmpty(), "List of suppliers is empty!");
        this.f22072a = list;
    }

    public static g b(List list) {
        return new g(list);
    }

    /* renamed from: c */
    public c get() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return j.a(this.f22072a, ((g) obj).f22072a);
    }

    public int hashCode() {
        return this.f22072a.hashCode();
    }

    public String toString() {
        return j.c(this).b("list", this.f22072a).toString();
    }
}
