package x4;

import android.os.SystemClock;
import c3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import x4.n;
import x4.x;
import y2.l;
import y2.m;
import y2.o;

public class w implements n, x {

    /* renamed from: a  reason: collision with root package name */
    private final n.b f24816a;

    /* renamed from: b  reason: collision with root package name */
    final m f24817b;

    /* renamed from: c  reason: collision with root package name */
    final m f24818c;

    /* renamed from: d  reason: collision with root package name */
    final Map f24819d = new WeakHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final d0 f24820e;

    /* renamed from: f  reason: collision with root package name */
    private final x.a f24821f;

    /* renamed from: g  reason: collision with root package name */
    private final o f24822g;

    /* renamed from: h  reason: collision with root package name */
    protected y f24823h;

    /* renamed from: i  reason: collision with root package name */
    private long f24824i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final boolean f24825j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f24826k;

    class a implements d0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0 f24827a;

        a(d0 d0Var) {
            this.f24827a = d0Var;
        }

        /* renamed from: b */
        public int a(n.a aVar) {
            if (w.this.f24825j) {
                return aVar.f24807g;
            }
            return this.f24827a.a(aVar.f24802b.p());
        }
    }

    class b implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n.a f24829a;

        b(n.a aVar) {
            this.f24829a = aVar;
        }

        public void release(Object obj) {
            w.this.y(this.f24829a);
        }
    }

    public w(d0 d0Var, x.a aVar, o oVar, n.b bVar, boolean z10, boolean z11) {
        this.f24820e = d0Var;
        this.f24817b = new m(A(d0Var));
        this.f24818c = new m(A(d0Var));
        this.f24821f = aVar;
        this.f24822g = oVar;
        this.f24823h = (y) l.h((y) oVar.get(), "mMemoryCacheParamsSupplier returned null");
        this.f24824i = SystemClock.uptimeMillis();
        this.f24816a = bVar;
        this.f24825j = z10;
        this.f24826k = z11;
    }

    private d0 A(d0 d0Var) {
        return new a(d0Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (l() <= (r3.f24823h.f24831a - r4)) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean i(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            x4.y r0 = r3.f24823h     // Catch:{ all -> 0x001f }
            int r0 = r0.f24835e     // Catch:{ all -> 0x001f }
            if (r4 > r0) goto L_0x0021
            int r0 = r3.k()     // Catch:{ all -> 0x001f }
            x4.y r1 = r3.f24823h     // Catch:{ all -> 0x001f }
            int r1 = r1.f24832b     // Catch:{ all -> 0x001f }
            r2 = 1
            int r1 = r1 - r2
            if (r0 > r1) goto L_0x0021
            int r0 = r3.l()     // Catch:{ all -> 0x001f }
            x4.y r1 = r3.f24823h     // Catch:{ all -> 0x001f }
            int r1 = r1.f24831a     // Catch:{ all -> 0x001f }
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0021
            goto L_0x0022
        L_0x001f:
            r4 = move-exception
            goto L_0x0024
        L_0x0021:
            r2 = 0
        L_0x0022:
            monitor-exit(r3)
            return r2
        L_0x0024:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.w.i(int):boolean");
    }

    private synchronized void j(n.a aVar) {
        boolean z10;
        l.g(aVar);
        if (aVar.f24803c > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        l.i(z10);
        aVar.f24803c--;
    }

    private synchronized void m(n.a aVar) {
        l.g(aVar);
        l.i(!aVar.f24804d);
        aVar.f24803c++;
    }

    private synchronized void n(n.a aVar) {
        l.g(aVar);
        l.i(!aVar.f24804d);
        aVar.f24804d = true;
    }

    private synchronized void o(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n((n.a) it.next());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean p(x4.n.a r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r3.f24804d     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0015
            int r0 = r3.f24803c     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0015
            x4.m r0 = r2.f24817b     // Catch:{ all -> 0x0013 }
            java.lang.Object r1 = r3.f24801a     // Catch:{ all -> 0x0013 }
            r0.h(r1, r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x0013:
            r3 = move-exception
            goto L_0x0018
        L_0x0015:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x0018:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.w.p(x4.n$a):boolean");
    }

    private void q(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c3.a.m(x((n.a) it.next()));
            }
        }
    }

    private static void s(n.a aVar) {
        n.b bVar;
        if (aVar != null && (bVar = aVar.f24805e) != null) {
            bVar.a(aVar.f24801a, true);
        }
    }

    private void t(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                u((n.a) it.next());
            }
        }
    }

    private static void u(n.a aVar) {
        n.b bVar;
        if (aVar != null && (bVar = aVar.f24805e) != null) {
            bVar.a(aVar.f24801a, false);
        }
    }

    private synchronized void v() {
        if (this.f24824i + this.f24823h.f24836f <= SystemClock.uptimeMillis()) {
            this.f24824i = SystemClock.uptimeMillis();
            this.f24823h = (y) l.h((y) this.f24822g.get(), "mMemoryCacheParamsSupplier returned null");
        }
    }

    private synchronized c3.a w(n.a aVar) {
        m(aVar);
        return c3.a.B(aVar.f24802b.p(), new b(aVar));
    }

    private synchronized c3.a x(n.a aVar) {
        c3.a aVar2;
        l.g(aVar);
        if (!aVar.f24804d || aVar.f24803c != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar.f24802b;
        }
        return aVar2;
    }

    /* access modifiers changed from: private */
    public void y(n.a aVar) {
        boolean p10;
        c3.a x10;
        l.g(aVar);
        synchronized (this) {
            j(aVar);
            p10 = p(aVar);
            x10 = x(aVar);
        }
        c3.a.m(x10);
        if (!p10) {
            aVar = null;
        }
        s(aVar);
        v();
        r();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        if (r4.f24826k == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r4.f24817b.k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        throw new java.lang.IllegalStateException(java.lang.String.format("key is null, but exclusiveEntries count: %d, size: %d", new java.lang.Object[]{java.lang.Integer.valueOf(r4.f24817b.c()), java.lang.Integer.valueOf(r4.f24817b.f())}));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.ArrayList z(int r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            monitor-enter(r4)
            int r5 = java.lang.Math.max(r5, r0)     // Catch:{ all -> 0x001d }
            int r6 = java.lang.Math.max(r6, r0)     // Catch:{ all -> 0x001d }
            x4.m r1 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r1 = r1.c()     // Catch:{ all -> 0x001d }
            if (r1 > r5) goto L_0x001f
            x4.m r1 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r1 = r1.f()     // Catch:{ all -> 0x001d }
            if (r1 > r6) goto L_0x001f
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x001d:
            r5 = move-exception
            goto L_0x0080
        L_0x001f:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x001d }
            r1.<init>()     // Catch:{ all -> 0x001d }
        L_0x0024:
            x4.m r2 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r2 = r2.c()     // Catch:{ all -> 0x001d }
            if (r2 > r5) goto L_0x0034
            x4.m r2 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r2 = r2.f()     // Catch:{ all -> 0x001d }
            if (r2 <= r6) goto L_0x0045
        L_0x0034:
            x4.m r2 = r4.f24817b     // Catch:{ all -> 0x001d }
            java.lang.Object r2 = r2.d()     // Catch:{ all -> 0x001d }
            if (r2 != 0) goto L_0x006f
            boolean r5 = r4.f24826k     // Catch:{ all -> 0x001d }
            if (r5 == 0) goto L_0x0047
            x4.m r5 = r4.f24817b     // Catch:{ all -> 0x001d }
            r5.k()     // Catch:{ all -> 0x001d }
        L_0x0045:
            monitor-exit(r4)
            return r1
        L_0x0047:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001d }
            java.lang.String r6 = "key is null, but exclusiveEntries count: %d, size: %d"
            x4.m r1 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r1 = r1.c()     // Catch:{ all -> 0x001d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x001d }
            x4.m r2 = r4.f24817b     // Catch:{ all -> 0x001d }
            int r2 = r2.f()     // Catch:{ all -> 0x001d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x001d }
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x001d }
            r3[r0] = r1     // Catch:{ all -> 0x001d }
            r0 = 1
            r3[r0] = r2     // Catch:{ all -> 0x001d }
            java.lang.String r6 = java.lang.String.format(r6, r3)     // Catch:{ all -> 0x001d }
            r5.<init>(r6)     // Catch:{ all -> 0x001d }
            throw r5     // Catch:{ all -> 0x001d }
        L_0x006f:
            x4.m r3 = r4.f24817b     // Catch:{ all -> 0x001d }
            r3.i(r2)     // Catch:{ all -> 0x001d }
            x4.m r3 = r4.f24818c     // Catch:{ all -> 0x001d }
            java.lang.Object r2 = r3.i(r2)     // Catch:{ all -> 0x001d }
            x4.n$a r2 = (x4.n.a) r2     // Catch:{ all -> 0x001d }
            r1.add(r2)     // Catch:{ all -> 0x001d }
            goto L_0x0024
        L_0x0080:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.w.z(int, int):java.util.ArrayList");
    }

    public int a(m mVar) {
        ArrayList j10;
        ArrayList j11;
        synchronized (this) {
            j10 = this.f24817b.j(mVar);
            j11 = this.f24818c.j(mVar);
            o(j11);
        }
        q(j11);
        t(j10);
        v();
        r();
        return j11.size();
    }

    public c3.a b(Object obj, c3.a aVar) {
        return e(obj, aVar, this.f24816a);
    }

    public void c(Object obj) {
        l.g(obj);
        synchronized (this) {
            try {
                n.a aVar = (n.a) this.f24817b.i(obj);
                if (aVar != null) {
                    this.f24817b.h(obj, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean contains(Object obj) {
        return this.f24818c.a(obj);
    }

    public c3.a d(Object obj) {
        n.a aVar;
        boolean z10;
        c3.a aVar2;
        l.g(obj);
        synchronized (this) {
            try {
                aVar = (n.a) this.f24817b.i(obj);
                z10 = false;
                if (aVar != null) {
                    n.a aVar3 = (n.a) this.f24818c.i(obj);
                    l.g(aVar3);
                    if (aVar3.f24803c == 0) {
                        z10 = true;
                    }
                    l.i(z10);
                    aVar2 = aVar3.f24802b;
                    z10 = true;
                } else {
                    aVar2 = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z10) {
            u(aVar);
        }
        return aVar2;
    }

    public c3.a e(Object obj, c3.a aVar, n.b bVar) {
        n.a aVar2;
        c3.a aVar3;
        c3.a aVar4;
        n.a aVar5;
        l.g(obj);
        l.g(aVar);
        v();
        synchronized (this) {
            try {
                aVar2 = (n.a) this.f24817b.i(obj);
                n.a aVar6 = (n.a) this.f24818c.i(obj);
                aVar3 = null;
                if (aVar6 != null) {
                    n(aVar6);
                    aVar4 = x(aVar6);
                } else {
                    aVar4 = null;
                }
                int a10 = this.f24820e.a(aVar.p());
                if (i(a10)) {
                    if (this.f24825j) {
                        aVar5 = n.a.a(obj, aVar, a10, bVar);
                    } else {
                        aVar5 = n.a.b(obj, aVar, bVar);
                    }
                    this.f24818c.h(obj, aVar5);
                    aVar3 = w(aVar5);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        c3.a.m(aVar4);
        u(aVar2);
        r();
        return aVar3;
    }

    public synchronized boolean f(m mVar) {
        return !this.f24818c.e(mVar).isEmpty();
    }

    public c3.a get(Object obj) {
        n.a aVar;
        c3.a aVar2;
        l.g(obj);
        synchronized (this) {
            try {
                aVar = (n.a) this.f24817b.i(obj);
                n.a aVar3 = (n.a) this.f24818c.b(obj);
                if (aVar3 != null) {
                    aVar2 = w(aVar3);
                } else {
                    aVar2 = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        u(aVar);
        v();
        r();
        return aVar2;
    }

    public synchronized int k() {
        return this.f24818c.c() - this.f24817b.c();
    }

    public synchronized int l() {
        return this.f24818c.f() - this.f24817b.f();
    }

    public void r() {
        ArrayList z10;
        synchronized (this) {
            y yVar = this.f24823h;
            int min = Math.min(yVar.f24834d, yVar.f24832b - k());
            y yVar2 = this.f24823h;
            z10 = z(min, Math.min(yVar2.f24833c, yVar2.f24831a - l()));
            o(z10);
        }
        q(z10);
        t(z10);
    }
}
