package i3;

import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private Map f22054a;

    /* renamed from: b  reason: collision with root package name */
    private d f22055b = d.IN_PROGRESS;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22056c = false;

    /* renamed from: d  reason: collision with root package name */
    private Object f22057d = null;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f22058e = null;

    /* renamed from: f  reason: collision with root package name */
    private float f22059f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private final ConcurrentLinkedQueue f22060g = new ConcurrentLinkedQueue();

    /* renamed from: i3.a$a  reason: collision with other inner class name */
    class C0287a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f22061a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f22062b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f22063c;

        C0287a(boolean z10, e eVar, boolean z11) {
            this.f22061a = z10;
            this.f22062b = eVar;
            this.f22063c = z11;
        }

        public void run() {
            if (this.f22061a) {
                this.f22062b.b(a.this);
            } else if (this.f22063c) {
                this.f22062b.c(a.this);
            } else {
                this.f22062b.d(a.this);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f22065a;

        b(e eVar) {
            this.f22065a = eVar;
        }

        public void run() {
            this.f22065a.a(a.this);
        }
    }

    public interface c {
    }

    private enum d {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    protected a() {
    }

    public static c g() {
        return null;
    }

    private void k() {
        boolean h10 = h();
        boolean u10 = u();
        Iterator it = this.f22060g.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            j((e) pair.first, (Executor) pair.second, h10, u10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean p(java.lang.Throwable r3, java.util.Map r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f22056c     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0019
            i3.a$d r0 = r2.f22055b     // Catch:{ all -> 0x0017 }
            i3.a$d r1 = i3.a.d.IN_PROGRESS     // Catch:{ all -> 0x0017 }
            if (r0 == r1) goto L_0x000c
            goto L_0x0019
        L_0x000c:
            i3.a$d r0 = i3.a.d.FAILURE     // Catch:{ all -> 0x0017 }
            r2.f22055b = r0     // Catch:{ all -> 0x0017 }
            r2.f22058e = r3     // Catch:{ all -> 0x0017 }
            r2.f22054a = r4     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x001c
        L_0x0019:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x001c:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.p(java.lang.Throwable, java.util.Map):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean r(float r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f22056c     // Catch:{ all -> 0x001a }
            r1 = 0
            if (r0 != 0) goto L_0x001c
            i3.a$d r0 = r3.f22055b     // Catch:{ all -> 0x001a }
            i3.a$d r2 = i3.a.d.IN_PROGRESS     // Catch:{ all -> 0x001a }
            if (r0 == r2) goto L_0x000d
            goto L_0x001c
        L_0x000d:
            float r0 = r3.f22059f     // Catch:{ all -> 0x001a }
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            monitor-exit(r3)
            return r1
        L_0x0015:
            r3.f22059f = r4     // Catch:{ all -> 0x001a }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x001a:
            r4 = move-exception
            goto L_0x001e
        L_0x001c:
            monitor-exit(r3)
            return r1
        L_0x001e:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.r(float):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0027, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0029, code lost:
        f(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return false;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0032=Splitter:B:27:0x0032, B:21:0x0026=Splitter:B:21:0x0026} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean t(java.lang.Object r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            monitor-enter(r3)     // Catch:{ all -> 0x003c }
            boolean r1 = r3.f22056c     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0032
            i3.a$d r1 = r3.f22055b     // Catch:{ all -> 0x0018 }
            i3.a$d r2 = i3.a.d.IN_PROGRESS     // Catch:{ all -> 0x0018 }
            if (r1 == r2) goto L_0x000d
            goto L_0x0032
        L_0x000d:
            if (r5 == 0) goto L_0x001a
            i3.a$d r5 = i3.a.d.SUCCESS     // Catch:{ all -> 0x0018 }
            r3.f22055b = r5     // Catch:{ all -> 0x0018 }
            r5 = 1065353216(0x3f800000, float:1.0)
            r3.f22059f = r5     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r4 = move-exception
            goto L_0x003a
        L_0x001a:
            java.lang.Object r5 = r3.f22057d     // Catch:{ all -> 0x0018 }
            if (r5 == r4) goto L_0x0025
            r3.f22057d = r4     // Catch:{ all -> 0x0022 }
            r4 = r5
            goto L_0x0026
        L_0x0022:
            r4 = move-exception
            r0 = r5
            goto L_0x003a
        L_0x0025:
            r4 = r0
        L_0x0026:
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x002c
            r3.f(r4)
        L_0x002c:
            r4 = 1
            return r4
        L_0x002e:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x003a
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x0038
            r3.f(r4)
        L_0x0038:
            r4 = 0
            return r4
        L_0x003a:
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            throw r4     // Catch:{ all -> 0x003c }
        L_0x003c:
            r4 = move-exception
            if (r0 == 0) goto L_0x0042
            r3.f(r0)
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.t(java.lang.Object, boolean):boolean");
    }

    private synchronized boolean u() {
        boolean z10;
        if (!i() || b()) {
            z10 = false;
        } else {
            z10 = true;
        }
        return z10;
    }

    public synchronized boolean a() {
        boolean z10;
        if (this.f22057d != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean b() {
        boolean z10;
        if (this.f22055b != d.IN_PROGRESS) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized Throwable c() {
        return this.f22058e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r1 == null) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        f(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (b() != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.f22060g.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean close() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f22056c     // Catch:{ all -> 0x0008 }
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            r0 = 0
            return r0
        L_0x0008:
            r0 = move-exception
            goto L_0x002c
        L_0x000a:
            r0 = 1
            r3.f22056c = r0     // Catch:{ all -> 0x0008 }
            java.lang.Object r1 = r3.f22057d     // Catch:{ all -> 0x0008 }
            r2 = 0
            r3.f22057d = r2     // Catch:{ all -> 0x0008 }
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            if (r1 == 0) goto L_0x0018
            r3.f(r1)
        L_0x0018:
            boolean r1 = r3.b()
            if (r1 != 0) goto L_0x0021
            r3.k()
        L_0x0021:
            monitor-enter(r3)
            java.util.concurrent.ConcurrentLinkedQueue r1 = r3.f22060g     // Catch:{ all -> 0x0029 }
            r1.clear()     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            return r0
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0029 }
            throw r0
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x0008 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.close():boolean");
    }

    public boolean d() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        if (r0 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        j(r3, r4, h(), u());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(i3.e r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            y2.l.g(r3)
            y2.l.g(r4)
            monitor-enter(r2)
            boolean r0 = r2.f22056c     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r3 = move-exception
            goto L_0x0043
        L_0x000f:
            i3.a$d r0 = r2.f22055b     // Catch:{ all -> 0x000d }
            i3.a$d r1 = i3.a.d.IN_PROGRESS     // Catch:{ all -> 0x000d }
            if (r0 != r1) goto L_0x001e
            java.util.concurrent.ConcurrentLinkedQueue r0 = r2.f22060g     // Catch:{ all -> 0x000d }
            android.util.Pair r1 = android.util.Pair.create(r3, r4)     // Catch:{ all -> 0x000d }
            r0.add(r1)     // Catch:{ all -> 0x000d }
        L_0x001e:
            boolean r0 = r2.a()     // Catch:{ all -> 0x000d }
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.b()     // Catch:{ all -> 0x000d }
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.u()     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r0 = 0
            goto L_0x0034
        L_0x0033:
            r0 = 1
        L_0x0034:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x0042
            boolean r0 = r2.h()
            boolean r1 = r2.u()
            r2.j(r3, r4, r0, r1)
        L_0x0042:
            return
        L_0x0043:
            monitor-exit(r2)     // Catch:{ all -> 0x000d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.e(i3.e, java.util.concurrent.Executor):void");
    }

    /* access modifiers changed from: protected */
    public void f(Object obj) {
    }

    public Map getExtras() {
        return this.f22054a;
    }

    public synchronized float getProgress() {
        return this.f22059f;
    }

    public synchronized Object getResult() {
        return this.f22057d;
    }

    public synchronized boolean h() {
        boolean z10;
        if (this.f22055b == d.FAILURE) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean i() {
        return this.f22056c;
    }

    /* access modifiers changed from: protected */
    public void j(e eVar, Executor executor, boolean z10, boolean z11) {
        C0287a aVar = new C0287a(z10, eVar, z11);
        g();
        executor.execute(aVar);
    }

    /* access modifiers changed from: protected */
    public void l() {
        Iterator it = this.f22060g.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((Executor) pair.second).execute(new b((e) pair.first));
        }
    }

    /* access modifiers changed from: protected */
    public void m(Map map) {
        this.f22054a = map;
    }

    /* access modifiers changed from: protected */
    public boolean n(Throwable th) {
        return o(th, (Map) null);
    }

    /* access modifiers changed from: protected */
    public boolean o(Throwable th, Map map) {
        boolean p10 = p(th, map);
        if (p10) {
            k();
        }
        return p10;
    }

    /* access modifiers changed from: protected */
    public boolean q(float f10) {
        boolean r10 = r(f10);
        if (r10) {
            l();
        }
        return r10;
    }

    /* access modifiers changed from: protected */
    public boolean s(Object obj, boolean z10, Map map) {
        m(map);
        boolean t10 = t(obj, z10);
        if (t10) {
            k();
        }
        return t10;
    }
}
