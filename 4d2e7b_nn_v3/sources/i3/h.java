package i3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import y2.j;
import y2.l;
import y2.o;

public class h implements o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f22078a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22079b;

    private class a extends a {

        /* renamed from: h  reason: collision with root package name */
        private ArrayList f22080h;

        /* renamed from: i  reason: collision with root package name */
        private int f22081i;

        /* renamed from: j  reason: collision with root package name */
        private int f22082j;

        /* renamed from: k  reason: collision with root package name */
        private AtomicInteger f22083k;

        /* renamed from: l  reason: collision with root package name */
        private Throwable f22084l;

        /* renamed from: m  reason: collision with root package name */
        private Map f22085m;

        /* renamed from: i3.h$a$a  reason: collision with other inner class name */
        private class C0289a implements e {

            /* renamed from: a  reason: collision with root package name */
            private int f22087a;

            public C0289a(int i10) {
                this.f22087a = i10;
            }

            public void a(c cVar) {
                if (this.f22087a == 0) {
                    a.this.q(cVar.getProgress());
                }
            }

            public void b(c cVar) {
                a.this.E(this.f22087a, cVar);
            }

            public void c(c cVar) {
            }

            public void d(c cVar) {
                if (cVar.a()) {
                    a.this.F(this.f22087a, cVar);
                } else if (cVar.b()) {
                    a.this.E(this.f22087a, cVar);
                }
            }
        }

        public a() {
            if (!h.this.f22079b) {
                y();
            }
        }

        private synchronized c A(int i10) {
            c cVar;
            ArrayList arrayList = this.f22080h;
            if (arrayList == null || i10 >= arrayList.size()) {
                cVar = null;
            } else {
                cVar = (c) this.f22080h.get(i10);
            }
            return cVar;
        }

        private synchronized c B() {
            return A(this.f22081i);
        }

        private void C() {
            Throwable th;
            if (this.f22083k.incrementAndGet() == this.f22082j && (th = this.f22084l) != null) {
                o(th, this.f22085m);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
            if (r0 <= r3) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
            x(z(r0));
            r0 = r0 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void D(int r3, i3.c r4, boolean r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                int r0 = r2.f22081i     // Catch:{ all -> 0x001b }
                i3.c r1 = r2.A(r3)     // Catch:{ all -> 0x001b }
                if (r4 != r1) goto L_0x002f
                int r4 = r2.f22081i     // Catch:{ all -> 0x001b }
                if (r3 != r4) goto L_0x000e
                goto L_0x002f
            L_0x000e:
                i3.c r4 = r2.B()     // Catch:{ all -> 0x001b }
                if (r4 == 0) goto L_0x001f
                if (r5 == 0) goto L_0x001d
                int r4 = r2.f22081i     // Catch:{ all -> 0x001b }
                if (r3 >= r4) goto L_0x001d
                goto L_0x001f
            L_0x001b:
                r3 = move-exception
                goto L_0x0031
            L_0x001d:
                r3 = r0
                goto L_0x0021
            L_0x001f:
                r2.f22081i = r3     // Catch:{ all -> 0x001b }
            L_0x0021:
                monitor-exit(r2)     // Catch:{ all -> 0x001b }
            L_0x0022:
                if (r0 <= r3) goto L_0x002e
                i3.c r4 = r2.z(r0)
                r2.x(r4)
                int r0 = r0 + -1
                goto L_0x0022
            L_0x002e:
                return
            L_0x002f:
                monitor-exit(r2)     // Catch:{ all -> 0x001b }
                return
            L_0x0031:
                monitor-exit(r2)     // Catch:{ all -> 0x001b }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.h.a.D(int, i3.c, boolean):void");
        }

        /* access modifiers changed from: private */
        public void E(int i10, c cVar) {
            x(G(i10, cVar));
            if (i10 == 0) {
                this.f22084l = cVar.c();
                this.f22085m = cVar.getExtras();
            }
            C();
        }

        /* access modifiers changed from: private */
        public void F(int i10, c cVar) {
            boolean z10;
            D(i10, cVar, cVar.b());
            if (cVar == B()) {
                if (i10 != 0 || !cVar.b()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                s((Object) null, z10, cVar.getExtras());
            }
            C();
        }

        private synchronized c G(int i10, c cVar) {
            if (cVar == B()) {
                return null;
            }
            if (cVar != A(i10)) {
                return cVar;
            }
            return z(i10);
        }

        private void x(c cVar) {
            if (cVar != null) {
                cVar.close();
            }
        }

        private void y() {
            if (this.f22083k == null) {
                synchronized (this) {
                    try {
                        if (this.f22083k == null) {
                            int i10 = 0;
                            this.f22083k = new AtomicInteger(0);
                            int size = h.this.f22078a.size();
                            this.f22082j = size;
                            this.f22081i = size;
                            this.f22080h = new ArrayList(size);
                            while (true) {
                                if (i10 >= size) {
                                    break;
                                }
                                c cVar = (c) ((o) h.this.f22078a.get(i10)).get();
                                this.f22080h.add(cVar);
                                cVar.e(new C0289a(i10), w2.a.a());
                                if (cVar.a()) {
                                    break;
                                }
                                i10++;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: i3.c} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized i3.c z(int r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                java.util.ArrayList r0 = r2.f22080h     // Catch:{ all -> 0x0016 }
                r1 = 0
                if (r0 == 0) goto L_0x0018
                int r0 = r0.size()     // Catch:{ all -> 0x0016 }
                if (r3 >= r0) goto L_0x0018
                java.util.ArrayList r0 = r2.f22080h     // Catch:{ all -> 0x0016 }
                java.lang.Object r3 = r0.set(r3, r1)     // Catch:{ all -> 0x0016 }
                r1 = r3
                i3.c r1 = (i3.c) r1     // Catch:{ all -> 0x0016 }
                goto L_0x0018
            L_0x0016:
                r3 = move-exception
                goto L_0x001a
            L_0x0018:
                monitor-exit(r2)
                return r1
            L_0x001a:
                monitor-exit(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.h.a.z(int):i3.c");
        }

        public synchronized boolean a() {
            boolean z10;
            try {
                if (h.this.f22079b) {
                    y();
                }
                c B = B();
                if (B == null || !B.a()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
            return z10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r1 >= r0.size()) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            x((i3.c) r0.get(r1));
            r1 = r1 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean close() {
            /*
                r3 = this;
                i3.h r0 = i3.h.this
                boolean r0 = r0.f22079b
                if (r0 == 0) goto L_0x000b
                r3.y()
            L_0x000b:
                monitor-enter(r3)
                boolean r0 = super.close()     // Catch:{ all -> 0x0015 }
                r1 = 0
                if (r0 != 0) goto L_0x0017
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                return r1
            L_0x0015:
                r0 = move-exception
                goto L_0x0033
            L_0x0017:
                java.util.ArrayList r0 = r3.f22080h     // Catch:{ all -> 0x0015 }
                r2 = 0
                r3.f22080h = r2     // Catch:{ all -> 0x0015 }
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                if (r0 == 0) goto L_0x0031
            L_0x001f:
                int r2 = r0.size()
                if (r1 >= r2) goto L_0x0031
                java.lang.Object r2 = r0.get(r1)
                i3.c r2 = (i3.c) r2
                r3.x(r2)
                int r1 = r1 + 1
                goto L_0x001f
            L_0x0031:
                r0 = 1
                return r0
            L_0x0033:
                monitor-exit(r3)     // Catch:{ all -> 0x0015 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: i3.h.a.close():boolean");
        }

        public synchronized Object getResult() {
            Object obj;
            try {
                if (h.this.f22079b) {
                    y();
                }
                c B = B();
                if (B != null) {
                    obj = B.getResult();
                } else {
                    obj = null;
                }
            } catch (Throwable th) {
                throw th;
            }
            return obj;
        }
    }

    private h(List list, boolean z10) {
        l.c(!list.isEmpty(), "List of suppliers is empty!");
        this.f22078a = list;
        this.f22079b = z10;
    }

    public static h c(List list, boolean z10) {
        return new h(list, z10);
    }

    /* renamed from: d */
    public c get() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return j.a(this.f22078a, ((h) obj).f22078a);
    }

    public int hashCode() {
        return this.f22078a.hashCode();
    }

    public String toString() {
        return j.c(this).b("list", this.f22078a).toString();
    }
}
