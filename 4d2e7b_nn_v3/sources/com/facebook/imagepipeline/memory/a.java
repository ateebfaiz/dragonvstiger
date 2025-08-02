package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import b3.d;
import b3.f;
import h5.f0;
import h5.g0;
import java.util.Set;
import y2.l;
import y2.n;

public abstract class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Class f19963a;

    /* renamed from: b  reason: collision with root package name */
    final d f19964b;

    /* renamed from: c  reason: collision with root package name */
    final f0 f19965c;

    /* renamed from: d  reason: collision with root package name */
    final SparseArray f19966d;

    /* renamed from: e  reason: collision with root package name */
    final Set f19967e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19968f;

    /* renamed from: g  reason: collision with root package name */
    final C0251a f19969g;

    /* renamed from: h  reason: collision with root package name */
    final C0251a f19970h;

    /* renamed from: i  reason: collision with root package name */
    private final g0 f19971i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19972j;

    /* renamed from: com.facebook.imagepipeline.memory.a$a  reason: collision with other inner class name */
    static class C0251a {

        /* renamed from: a  reason: collision with root package name */
        int f19973a;

        /* renamed from: b  reason: collision with root package name */
        int f19974b;

        C0251a() {
        }

        public void a(int i10) {
            int i11;
            int i12 = this.f19974b;
            if (i12 < i10 || (i11 = this.f19973a) <= 0) {
                z2.a.M("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i10), Integer.valueOf(this.f19974b), Integer.valueOf(this.f19973a));
                return;
            }
            this.f19973a = i11 - 1;
            this.f19974b = i12 - i10;
        }

        public void b(int i10) {
            this.f19973a++;
            this.f19974b += i10;
        }
    }

    public static class b extends RuntimeException {
        public b(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class c extends RuntimeException {
        public c(int i10, int i11, int i12, int i13) {
            super("Pool hard cap violation? Hard cap = " + i10 + " Used size = " + i11 + " Free size = " + i12 + " Request size = " + i13);
        }
    }

    public a(d dVar, f0 f0Var, g0 g0Var) {
        this.f19963a = getClass();
        this.f19964b = (d) l.g(dVar);
        f0 f0Var2 = (f0) l.g(f0Var);
        this.f19965c = f0Var2;
        this.f19971i = (g0) l.g(g0Var);
        this.f19966d = new SparseArray();
        if (f0Var2.f21949f) {
            r();
        } else {
            v(new SparseIntArray(0));
        }
        this.f19967e = n.b();
        this.f19970h = new C0251a();
        this.f19969g = new C0251a();
    }

    private synchronized void i() {
        boolean z10;
        try {
            if (t()) {
                if (this.f19970h.f19974b != 0) {
                    z10 = false;
                    l.i(z10);
                }
            }
            z10 = true;
            l.i(z10);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void j(SparseIntArray sparseIntArray) {
        this.f19966d.clear();
        for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
            int keyAt = sparseIntArray.keyAt(i10);
            this.f19966d.put(keyAt, new b(p(keyAt), sparseIntArray.valueAt(i10), 0, this.f19965c.f21949f));
        }
    }

    private synchronized b m(int i10) {
        return (b) this.f19966d.get(i10);
    }

    private synchronized void r() {
        try {
            SparseIntArray sparseIntArray = this.f19965c.f21946c;
            if (sparseIntArray != null) {
                j(sparseIntArray);
                this.f19968f = false;
            } else {
                this.f19968f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void v(SparseIntArray sparseIntArray) {
        try {
            l.g(sparseIntArray);
            this.f19966d.clear();
            SparseIntArray sparseIntArray2 = this.f19965c.f21946c;
            if (sparseIntArray2 != null) {
                for (int i10 = 0; i10 < sparseIntArray2.size(); i10++) {
                    int keyAt = sparseIntArray2.keyAt(i10);
                    this.f19966d.put(keyAt, new b(p(keyAt), sparseIntArray2.valueAt(i10), sparseIntArray.get(keyAt, 0), this.f19965c.f21949f));
                }
                this.f19968f = false;
            } else {
                this.f19968f = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void w() {
        if (z2.a.u(2)) {
            z2.a.z(this.f19963a, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f19969g.f19973a), Integer.valueOf(this.f19969g.f19974b), Integer.valueOf(this.f19970h.f19973a), Integer.valueOf(this.f19970h.f19974b));
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object g(int i10);

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = g(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4.f19969g.a(r2);
        r3 = l(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        if (r3 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        y2.q.c(r0);
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0089, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        y2.l.i(r4.f19967e.add(r0));
        z();
        r4.f19971i.a(r2);
        w();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (z2.a.u(2) == false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        z2.a.x(r4.f19963a, "get (alloc) (object, size) = (%x, %s)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bb, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(int r5) {
        /*
            r4 = this;
            r4.i()
            int r5 = r4.n(r5)
            monitor-enter(r4)
            com.facebook.imagepipeline.memory.b r0 = r4.l(r5)     // Catch:{ all -> 0x0052 }
            r1 = 2
            if (r0 == 0) goto L_0x0057
            java.lang.Object r2 = r4.q(r0)     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x0057
            java.util.Set r5 = r4.f19967e     // Catch:{ all -> 0x0052 }
            boolean r5 = r5.add(r2)     // Catch:{ all -> 0x0052 }
            y2.l.i(r5)     // Catch:{ all -> 0x0052 }
            int r5 = r4.o(r2)     // Catch:{ all -> 0x0052 }
            int r0 = r4.p(r5)     // Catch:{ all -> 0x0052 }
            com.facebook.imagepipeline.memory.a$a r3 = r4.f19969g     // Catch:{ all -> 0x0052 }
            r3.b(r0)     // Catch:{ all -> 0x0052 }
            com.facebook.imagepipeline.memory.a$a r3 = r4.f19970h     // Catch:{ all -> 0x0052 }
            r3.a(r0)     // Catch:{ all -> 0x0052 }
            h5.g0 r3 = r4.f19971i     // Catch:{ all -> 0x0052 }
            r3.b(r0)     // Catch:{ all -> 0x0052 }
            r4.w()     // Catch:{ all -> 0x0052 }
            boolean r0 = z2.a.u(r1)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0055
            java.lang.Class r0 = r4.f19963a     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "get (reuse) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r2)     // Catch:{ all -> 0x0052 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0052 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0052 }
            z2.a.x(r0, r1, r3, r5)     // Catch:{ all -> 0x0052 }
            goto L_0x0055
        L_0x0052:
            r5 = move-exception
            goto L_0x00d2
        L_0x0055:
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            return r2
        L_0x0057:
            int r2 = r4.p(r5)     // Catch:{ all -> 0x0052 }
            boolean r3 = r4.h(r2)     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x00c0
            com.facebook.imagepipeline.memory.a$a r3 = r4.f19969g     // Catch:{ all -> 0x0052 }
            r3.b(r2)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x006b
            r0.e()     // Catch:{ all -> 0x0052 }
        L_0x006b:
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r4.g(r5)     // Catch:{ all -> 0x0071 }
            goto L_0x0089
        L_0x0071:
            r0 = move-exception
            monitor-enter(r4)
            com.facebook.imagepipeline.memory.a$a r3 = r4.f19969g     // Catch:{ all -> 0x0082 }
            r3.a(r2)     // Catch:{ all -> 0x0082 }
            com.facebook.imagepipeline.memory.b r3 = r4.l(r5)     // Catch:{ all -> 0x0082 }
            if (r3 == 0) goto L_0x0084
            r3.b()     // Catch:{ all -> 0x0082 }
            goto L_0x0084
        L_0x0082:
            r5 = move-exception
            goto L_0x00be
        L_0x0084:
            monitor-exit(r4)     // Catch:{ all -> 0x0082 }
            y2.q.c(r0)
            r0 = 0
        L_0x0089:
            monitor-enter(r4)
            java.util.Set r3 = r4.f19967e     // Catch:{ all -> 0x00b8 }
            boolean r3 = r3.add(r0)     // Catch:{ all -> 0x00b8 }
            y2.l.i(r3)     // Catch:{ all -> 0x00b8 }
            r4.z()     // Catch:{ all -> 0x00b8 }
            h5.g0 r3 = r4.f19971i     // Catch:{ all -> 0x00b8 }
            r3.a(r2)     // Catch:{ all -> 0x00b8 }
            r4.w()     // Catch:{ all -> 0x00b8 }
            boolean r1 = z2.a.u(r1)     // Catch:{ all -> 0x00b8 }
            if (r1 == 0) goto L_0x00ba
            java.lang.Class r1 = r4.f19963a     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "get (alloc) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00b8 }
            z2.a.x(r1, r2, r3, r5)     // Catch:{ all -> 0x00b8 }
            goto L_0x00ba
        L_0x00b8:
            r5 = move-exception
            goto L_0x00bc
        L_0x00ba:
            monitor-exit(r4)     // Catch:{ all -> 0x00b8 }
            return r0
        L_0x00bc:
            monitor-exit(r4)     // Catch:{ all -> 0x00b8 }
            throw r5
        L_0x00be:
            monitor-exit(r4)     // Catch:{ all -> 0x0082 }
            throw r5
        L_0x00c0:
            com.facebook.imagepipeline.memory.a$c r5 = new com.facebook.imagepipeline.memory.a$c     // Catch:{ all -> 0x0052 }
            h5.f0 r0 = r4.f19965c     // Catch:{ all -> 0x0052 }
            int r0 = r0.f21944a     // Catch:{ all -> 0x0052 }
            com.facebook.imagepipeline.memory.a$a r1 = r4.f19969g     // Catch:{ all -> 0x0052 }
            int r1 = r1.f19974b     // Catch:{ all -> 0x0052 }
            com.facebook.imagepipeline.memory.a$a r3 = r4.f19970h     // Catch:{ all -> 0x0052 }
            int r3 = r3.f19974b     // Catch:{ all -> 0x0052 }
            r5.<init>(r0, r1, r3, r2)     // Catch:{ all -> 0x0052 }
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x00d2:
            monitor-exit(r4)     // Catch:{ all -> 0x0052 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.a.get(int):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean h(int i10) {
        if (this.f19972j) {
            return true;
        }
        f0 f0Var = this.f19965c;
        int i11 = f0Var.f21944a;
        int i12 = this.f19969g.f19974b;
        if (i10 > i11 - i12) {
            this.f19971i.f();
            return false;
        }
        int i13 = f0Var.f21945b;
        if (i10 > i13 - (i12 + this.f19970h.f19974b)) {
            y(i13 - i10);
        }
        if (i10 <= i11 - (this.f19969g.f19974b + this.f19970h.f19974b)) {
            return true;
        }
        this.f19971i.f();
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void k(Object obj);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.memory.b l(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray r0 = r3.f19966d     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0023 }
            com.facebook.imagepipeline.memory.b r0 = (com.facebook.imagepipeline.memory.b) r0     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0030
            boolean r1 = r3.f19968f     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0030
        L_0x0010:
            r0 = 2
            boolean r0 = z2.a.u(r0)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0025
            java.lang.Class r0 = r3.f19963a     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "creating new bucket %s"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0023 }
            z2.a.w(r0, r1, r2)     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            r4 = move-exception
            goto L_0x0032
        L_0x0025:
            com.facebook.imagepipeline.memory.b r0 = r3.x(r4)     // Catch:{ all -> 0x0023 }
            android.util.SparseArray r1 = r3.f19966d     // Catch:{ all -> 0x0023 }
            r1.put(r4, r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)
            return r0
        L_0x0030:
            monitor-exit(r3)
            return r0
        L_0x0032:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.a.l(int):com.facebook.imagepipeline.memory.b");
    }

    /* access modifiers changed from: protected */
    public abstract int n(int i10);

    /* access modifiers changed from: protected */
    public abstract int o(Object obj);

    /* access modifiers changed from: protected */
    public abstract int p(int i10);

    /* access modifiers changed from: protected */
    public synchronized Object q(b bVar) {
        return bVar.c();
    }

    public void release(Object obj) {
        l.g(obj);
        int o10 = o(obj);
        int p10 = p(o10);
        synchronized (this) {
            try {
                b m10 = m(o10);
                if (!this.f19967e.remove(obj)) {
                    z2.a.h(this.f19963a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(o10));
                    k(obj);
                    this.f19971i.e(p10);
                } else {
                    if (m10 != null && !m10.f() && !t()) {
                        if (u(obj)) {
                            m10.h(obj);
                            this.f19970h.b(p10);
                            this.f19969g.a(p10);
                            this.f19971i.g(p10);
                            if (z2.a.u(2)) {
                                z2.a.x(this.f19963a, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(o10));
                            }
                        }
                    }
                    if (m10 != null) {
                        m10.b();
                    }
                    if (z2.a.u(2)) {
                        z2.a.x(this.f19963a, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(o10));
                    }
                    k(obj);
                    this.f19969g.a(p10);
                    this.f19971i.e(p10);
                }
                w();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        this.f19964b.a(this);
        this.f19971i.c(this);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean t() {
        boolean z10;
        if (this.f19969g.f19974b + this.f19970h.f19974b > this.f19965c.f21945b) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f19971i.d();
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public boolean u(Object obj) {
        l.g(obj);
        return true;
    }

    /* access modifiers changed from: package-private */
    public b x(int i10) {
        return new b(p(i10), Integer.MAX_VALUE, 0, this.f19965c.f21949f);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void y(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.a$a r0 = r7.f19969g     // Catch:{ all -> 0x0037 }
            int r0 = r0.f19974b     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.a$a r1 = r7.f19970h     // Catch:{ all -> 0x0037 }
            int r1 = r1.f19974b     // Catch:{ all -> 0x0037 }
            int r0 = r0 + r1
            int r0 = r0 - r8
            int r0 = java.lang.Math.min(r0, r1)     // Catch:{ all -> 0x0037 }
            if (r0 > 0) goto L_0x0013
            monitor-exit(r7)
            return
        L_0x0013:
            r1 = 2
            boolean r2 = z2.a.u(r1)     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0039
            java.lang.Class r2 = r7.f19963a     // Catch:{ all -> 0x0037 }
            java.lang.String r3 = "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.a$a r5 = r7.f19969g     // Catch:{ all -> 0x0037 }
            int r5 = r5.f19974b     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.a$a r6 = r7.f19970h     // Catch:{ all -> 0x0037 }
            int r6 = r6.f19974b     // Catch:{ all -> 0x0037 }
            int r5 = r5 + r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0037 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0037 }
            z2.a.y(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r8 = move-exception
            goto L_0x0091
        L_0x0039:
            r7.w()     // Catch:{ all -> 0x0037 }
            r2 = 0
        L_0x003d:
            android.util.SparseArray r3 = r7.f19966d     // Catch:{ all -> 0x0037 }
            int r3 = r3.size()     // Catch:{ all -> 0x0037 }
            if (r2 >= r3) goto L_0x006e
            if (r0 > 0) goto L_0x0048
            goto L_0x006e
        L_0x0048:
            android.util.SparseArray r3 = r7.f19966d     // Catch:{ all -> 0x0037 }
            java.lang.Object r3 = r3.valueAt(r2)     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.b r3 = (com.facebook.imagepipeline.memory.b) r3     // Catch:{ all -> 0x0037 }
            java.lang.Object r3 = y2.l.g(r3)     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.b r3 = (com.facebook.imagepipeline.memory.b) r3     // Catch:{ all -> 0x0037 }
        L_0x0056:
            if (r0 <= 0) goto L_0x006b
            java.lang.Object r4 = r3.g()     // Catch:{ all -> 0x0037 }
            if (r4 != 0) goto L_0x005f
            goto L_0x006b
        L_0x005f:
            r7.k(r4)     // Catch:{ all -> 0x0037 }
            int r4 = r3.f19975a     // Catch:{ all -> 0x0037 }
            int r0 = r0 - r4
            com.facebook.imagepipeline.memory.a$a r5 = r7.f19970h     // Catch:{ all -> 0x0037 }
            r5.a(r4)     // Catch:{ all -> 0x0037 }
            goto L_0x0056
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x003d
        L_0x006e:
            r7.w()     // Catch:{ all -> 0x0037 }
            boolean r0 = z2.a.u(r1)     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x008f
            java.lang.Class r0 = r7.f19963a     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "trimToSize: TargetSize = %d; Final Size = %d"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.a$a r2 = r7.f19969g     // Catch:{ all -> 0x0037 }
            int r2 = r2.f19974b     // Catch:{ all -> 0x0037 }
            com.facebook.imagepipeline.memory.a$a r3 = r7.f19970h     // Catch:{ all -> 0x0037 }
            int r3 = r3.f19974b     // Catch:{ all -> 0x0037 }
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0037 }
            z2.a.x(r0, r1, r8, r2)     // Catch:{ all -> 0x0037 }
        L_0x008f:
            monitor-exit(r7)
            return
        L_0x0091:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.a.y(int):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void z() {
        if (t()) {
            y(this.f19965c.f21945b);
        }
    }

    public a(d dVar, f0 f0Var, g0 g0Var, boolean z10) {
        this(dVar, f0Var, g0Var);
        this.f19972j = z10;
    }
}
