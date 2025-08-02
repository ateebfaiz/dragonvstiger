package d4;

import android.util.SparseArray;
import c3.a;
import e5.f;
import e5.g;
import e5.n;
import t4.c;

public class b implements c4.b {

    /* renamed from: e  reason: collision with root package name */
    private static final Class f21037e = b.class;

    /* renamed from: a  reason: collision with root package name */
    private final c f21038a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21039b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f21040c = new SparseArray();

    /* renamed from: d  reason: collision with root package name */
    private a f21041d;

    public b(c cVar, boolean z10) {
        this.f21038a = cVar;
        this.f21039b = z10;
    }

    static a a(a aVar) {
        g gVar;
        try {
            if (a.y(aVar) && (aVar.p() instanceof g) && (gVar = (g) aVar.p()) != null) {
                return gVar.i();
            }
            a.m(aVar);
            return null;
        } finally {
            a.m(aVar);
        }
    }

    private static a h(a aVar) {
        return a.z(f.c(aVar, n.f21287d, 0));
    }

    private synchronized void i(int i10) {
        a aVar = (a) this.f21040c.get(i10);
        if (aVar != null) {
            this.f21040c.delete(i10);
            a.m(aVar);
            z2.a.x(f21037e, "removePreparedReference(%d) removed. Pending frames: %s", Integer.valueOf(i10), this.f21040c);
        }
    }

    public synchronized boolean b(int i10) {
        return this.f21038a.b(i10);
    }

    public synchronized a c(int i10, int i11, int i12) {
        if (!this.f21039b) {
            return null;
        }
        return a(this.f21038a.d());
    }

    public synchronized void clear() {
        try {
            a.m(this.f21041d);
            this.f21041d = null;
            for (int i10 = 0; i10 < this.f21040c.size(); i10++) {
                a.m((a) this.f21040c.valueAt(i10));
            }
            this.f21040c.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized a d(int i10) {
        return a(this.f21038a.c(i10));
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0026=Splitter:B:16:0x0026, B:9:0x001d=Splitter:B:9:0x001d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e(int r1, c3.a r2, int r3) {
        /*
            r0 = this;
            monitor-enter(r0)
            y2.l.g(r2)     // Catch:{ all -> 0x0022 }
            r0.i(r1)     // Catch:{ all -> 0x0022 }
            c3.a r2 = h(r2)     // Catch:{ all -> 0x0024 }
            if (r2 == 0) goto L_0x001d
            c3.a r3 = r0.f21041d     // Catch:{ all -> 0x001b }
            c3.a.m(r3)     // Catch:{ all -> 0x001b }
            t4.c r3 = r0.f21038a     // Catch:{ all -> 0x001b }
            c3.a r1 = r3.a(r1, r2)     // Catch:{ all -> 0x001b }
            r0.f21041d = r1     // Catch:{ all -> 0x001b }
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            goto L_0x0026
        L_0x001d:
            c3.a.m(r2)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)
            return
        L_0x0022:
            r1 = move-exception
            goto L_0x002a
        L_0x0024:
            r1 = move-exception
            r2 = 0
        L_0x0026:
            c3.a.m(r2)     // Catch:{ all -> 0x0022 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x002a:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.b.e(int, c3.a, int):void");
    }

    public synchronized a f(int i10) {
        return a(a.j(this.f21041d));
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0044=Splitter:B:22:0x0044, B:16:0x003d=Splitter:B:16:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void g(int r3, c3.a r4, int r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            y2.l.g(r4)     // Catch:{ all -> 0x000f }
            c3.a r4 = h(r4)     // Catch:{ all -> 0x0042 }
            if (r4 != 0) goto L_0x0011
            c3.a.m(r4)     // Catch:{ all -> 0x000f }
            monitor-exit(r2)
            return
        L_0x000f:
            r3 = move-exception
            goto L_0x0048
        L_0x0011:
            t4.c r5 = r2.f21038a     // Catch:{ all -> 0x003b }
            c3.a r5 = r5.a(r3, r4)     // Catch:{ all -> 0x003b }
            boolean r0 = c3.a.y(r5)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x003d
            android.util.SparseArray r0 = r2.f21040c     // Catch:{ all -> 0x003b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x003b }
            c3.a r0 = (c3.a) r0     // Catch:{ all -> 0x003b }
            c3.a.m(r0)     // Catch:{ all -> 0x003b }
            android.util.SparseArray r0 = r2.f21040c     // Catch:{ all -> 0x003b }
            r0.put(r3, r5)     // Catch:{ all -> 0x003b }
            java.lang.Class r5 = f21037e     // Catch:{ all -> 0x003b }
            java.lang.String r0 = "cachePreparedFrame(%d) cached. Pending frames: %s"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003b }
            android.util.SparseArray r1 = r2.f21040c     // Catch:{ all -> 0x003b }
            z2.a.x(r5, r0, r3, r1)     // Catch:{ all -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r3 = move-exception
            goto L_0x0044
        L_0x003d:
            c3.a.m(r4)     // Catch:{ all -> 0x000f }
            monitor-exit(r2)
            return
        L_0x0042:
            r3 = move-exception
            r4 = 0
        L_0x0044:
            c3.a.m(r4)     // Catch:{ all -> 0x000f }
            throw r3     // Catch:{ all -> 0x000f }
        L_0x0048:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.b.g(int, c3.a, int):void");
    }
}
