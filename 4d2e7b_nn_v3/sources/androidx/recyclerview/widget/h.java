package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class h implements ThreadUtil {

    class a implements ThreadUtil.MainThreadCallback {

        /* renamed from: a  reason: collision with root package name */
        final c f16376a = new c();

        /* renamed from: b  reason: collision with root package name */
        private final Handler f16377b = new Handler(Looper.getMainLooper());

        /* renamed from: c  reason: collision with root package name */
        private Runnable f16378c = new C0210a();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ThreadUtil.MainThreadCallback f16379d;

        /* renamed from: androidx.recyclerview.widget.h$a$a  reason: collision with other inner class name */
        class C0210a implements Runnable {
            C0210a() {
            }

            public void run() {
                d a10 = a.this.f16376a.a();
                while (a10 != null) {
                    int i10 = a10.f16394b;
                    if (i10 == 1) {
                        a.this.f16379d.updateItemCount(a10.f16395c, a10.f16396d);
                    } else if (i10 == 2) {
                        a.this.f16379d.addTile(a10.f16395c, (TileList.Tile) a10.f16400h);
                    } else if (i10 != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a10.f16394b);
                    } else {
                        a.this.f16379d.removeTile(a10.f16395c, a10.f16396d);
                    }
                    a10 = a.this.f16376a.a();
                }
            }
        }

        a(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.f16379d = mainThreadCallback;
        }

        private void a(d dVar) {
            this.f16376a.c(dVar);
            this.f16377b.post(this.f16378c);
        }

        public void addTile(int i10, TileList.Tile tile) {
            a(d.c(2, i10, tile));
        }

        public void removeTile(int i10, int i11) {
            a(d.a(3, i10, i11));
        }

        public void updateItemCount(int i10, int i11) {
            a(d.a(1, i10, i11));
        }
    }

    class b implements ThreadUtil.BackgroundCallback {

        /* renamed from: a  reason: collision with root package name */
        final c f16382a = new c();

        /* renamed from: b  reason: collision with root package name */
        private final Executor f16383b = AsyncTask.THREAD_POOL_EXECUTOR;

        /* renamed from: c  reason: collision with root package name */
        AtomicBoolean f16384c = new AtomicBoolean(false);

        /* renamed from: d  reason: collision with root package name */
        private Runnable f16385d = new a();

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ThreadUtil.BackgroundCallback f16386e;

        class a implements Runnable {
            a() {
            }

            public void run() {
                while (true) {
                    d a10 = b.this.f16382a.a();
                    if (a10 == null) {
                        b.this.f16384c.set(false);
                        return;
                    }
                    int i10 = a10.f16394b;
                    if (i10 == 1) {
                        b.this.f16382a.b(1);
                        b.this.f16386e.refresh(a10.f16395c);
                    } else if (i10 == 2) {
                        b.this.f16382a.b(2);
                        b.this.f16382a.b(3);
                        b.this.f16386e.updateRange(a10.f16395c, a10.f16396d, a10.f16397e, a10.f16398f, a10.f16399g);
                    } else if (i10 == 3) {
                        b.this.f16386e.loadTile(a10.f16395c, a10.f16396d);
                    } else if (i10 != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a10.f16394b);
                    } else {
                        b.this.f16386e.recycleTile((TileList.Tile) a10.f16400h);
                    }
                }
            }
        }

        b(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.f16386e = backgroundCallback;
        }

        private void a() {
            if (this.f16384c.compareAndSet(false, true)) {
                this.f16383b.execute(this.f16385d);
            }
        }

        private void b(d dVar) {
            this.f16382a.c(dVar);
            a();
        }

        private void c(d dVar) {
            this.f16382a.d(dVar);
            a();
        }

        public void loadTile(int i10, int i11) {
            b(d.a(3, i10, i11));
        }

        public void recycleTile(TileList.Tile tile) {
            b(d.c(4, 0, tile));
        }

        public void refresh(int i10) {
            c(d.c(1, i10, (Object) null));
        }

        public void updateRange(int i10, int i11, int i12, int i13, int i14) {
            c(d.b(2, i10, i11, i12, i13, i14, (Object) null));
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private d f16389a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f16390b = new Object();

        c() {
        }

        /* access modifiers changed from: package-private */
        public d a() {
            synchronized (this.f16390b) {
                try {
                    d dVar = this.f16389a;
                    if (dVar == null) {
                        return null;
                    }
                    this.f16389a = dVar.f16393a;
                    return dVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0017 A[Catch:{ all -> 0x0013 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f16390b
                monitor-enter(r0)
            L_0x0003:
                androidx.recyclerview.widget.h$d r1 = r5.f16389a     // Catch:{ all -> 0x0013 }
                if (r1 == 0) goto L_0x0015
                int r2 = r1.f16394b     // Catch:{ all -> 0x0013 }
                if (r2 != r6) goto L_0x0015
                androidx.recyclerview.widget.h$d r2 = r1.f16393a     // Catch:{ all -> 0x0013 }
                r5.f16389a = r2     // Catch:{ all -> 0x0013 }
                r1.d()     // Catch:{ all -> 0x0013 }
                goto L_0x0003
            L_0x0013:
                r6 = move-exception
                goto L_0x002c
            L_0x0015:
                if (r1 == 0) goto L_0x002a
                androidx.recyclerview.widget.h$d r2 = r1.f16393a     // Catch:{ all -> 0x0013 }
            L_0x0019:
                if (r2 == 0) goto L_0x002a
                androidx.recyclerview.widget.h$d r3 = r2.f16393a     // Catch:{ all -> 0x0013 }
                int r4 = r2.f16394b     // Catch:{ all -> 0x0013 }
                if (r4 != r6) goto L_0x0027
                r1.f16393a = r3     // Catch:{ all -> 0x0013 }
                r2.d()     // Catch:{ all -> 0x0013 }
                goto L_0x0028
            L_0x0027:
                r1 = r2
            L_0x0028:
                r2 = r3
                goto L_0x0019
            L_0x002a:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                return
            L_0x002c:
                monitor-exit(r0)     // Catch:{ all -> 0x0013 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.h.c.b(int):void");
        }

        /* access modifiers changed from: package-private */
        public void c(d dVar) {
            synchronized (this.f16390b) {
                try {
                    d dVar2 = this.f16389a;
                    if (dVar2 == null) {
                        this.f16389a = dVar;
                        return;
                    }
                    while (true) {
                        d dVar3 = dVar2.f16393a;
                        if (dVar3 != null) {
                            dVar2 = dVar3;
                        } else {
                            dVar2.f16393a = dVar;
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(d dVar) {
            synchronized (this.f16390b) {
                dVar.f16393a = this.f16389a;
                this.f16389a = dVar;
            }
        }
    }

    static class d {

        /* renamed from: i  reason: collision with root package name */
        private static d f16391i;

        /* renamed from: j  reason: collision with root package name */
        private static final Object f16392j = new Object();

        /* renamed from: a  reason: collision with root package name */
        d f16393a;

        /* renamed from: b  reason: collision with root package name */
        public int f16394b;

        /* renamed from: c  reason: collision with root package name */
        public int f16395c;

        /* renamed from: d  reason: collision with root package name */
        public int f16396d;

        /* renamed from: e  reason: collision with root package name */
        public int f16397e;

        /* renamed from: f  reason: collision with root package name */
        public int f16398f;

        /* renamed from: g  reason: collision with root package name */
        public int f16399g;

        /* renamed from: h  reason: collision with root package name */
        public Object f16400h;

        d() {
        }

        static d a(int i10, int i11, int i12) {
            return b(i10, i11, i12, 0, 0, 0, (Object) null);
        }

        static d b(int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            d dVar;
            synchronized (f16392j) {
                try {
                    dVar = f16391i;
                    if (dVar == null) {
                        dVar = new d();
                    } else {
                        f16391i = dVar.f16393a;
                        dVar.f16393a = null;
                    }
                    dVar.f16394b = i10;
                    dVar.f16395c = i11;
                    dVar.f16396d = i12;
                    dVar.f16397e = i13;
                    dVar.f16398f = i14;
                    dVar.f16399g = i15;
                    dVar.f16400h = obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return dVar;
        }

        static d c(int i10, int i11, Object obj) {
            return b(i10, i11, 0, 0, 0, 0, obj);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f16393a = null;
            this.f16399g = 0;
            this.f16398f = 0;
            this.f16397e = 0;
            this.f16396d = 0;
            this.f16395c = 0;
            this.f16394b = 0;
            this.f16400h = null;
            synchronized (f16392j) {
                try {
                    d dVar = f16391i;
                    if (dVar != null) {
                        this.f16393a = dVar;
                    }
                    f16391i = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    h() {
    }

    public ThreadUtil.BackgroundCallback a(ThreadUtil.BackgroundCallback backgroundCallback) {
        return new b(backgroundCallback);
    }

    public ThreadUtil.MainThreadCallback b(ThreadUtil.MainThreadCallback mainThreadCallback) {
        return new a(mainThreadCallback);
    }
}
