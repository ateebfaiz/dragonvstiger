package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class c extends LiveData {

    /* renamed from: a  reason: collision with root package name */
    final RoomDatabase f16455a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f16456b;

    /* renamed from: c  reason: collision with root package name */
    final Callable f16457c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16458d;

    /* renamed from: e  reason: collision with root package name */
    final InvalidationTracker.Observer f16459e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicBoolean f16460f = new AtomicBoolean(true);

    /* renamed from: g  reason: collision with root package name */
    final AtomicBoolean f16461g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    final AtomicBoolean f16462h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    final Runnable f16463i = new a();

    /* renamed from: j  reason: collision with root package name */
    final Runnable f16464j = new b();

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                androidx.room.c r0 = androidx.room.c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f16462h
                r1 = 0
                r2 = 1
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x001b
                androidx.room.c r0 = androidx.room.c.this
                androidx.room.RoomDatabase r0 = r0.f16455a
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.c r3 = androidx.room.c.this
                androidx.room.InvalidationTracker$Observer r3 = r3.f16459e
                r0.addWeakObserver(r3)
            L_0x001b:
                androidx.room.c r0 = androidx.room.c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f16461g
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 == 0) goto L_0x005d
                r0 = 0
                r3 = r1
            L_0x0027:
                androidx.room.c r4 = androidx.room.c.this     // Catch:{ all -> 0x003b }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f16460f     // Catch:{ all -> 0x003b }
                boolean r4 = r4.compareAndSet(r2, r1)     // Catch:{ all -> 0x003b }
                if (r4 == 0) goto L_0x0046
                androidx.room.c r0 = androidx.room.c.this     // Catch:{ Exception -> 0x003d }
                java.util.concurrent.Callable r0 = r0.f16457c     // Catch:{ Exception -> 0x003d }
                java.lang.Object r0 = r0.call()     // Catch:{ Exception -> 0x003d }
                r3 = r2
                goto L_0x0027
            L_0x003b:
                r0 = move-exception
                goto L_0x0055
            L_0x003d:
                r0 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x003b }
                java.lang.String r3 = "Exception while computing database live data."
                r2.<init>(r3, r0)     // Catch:{ all -> 0x003b }
                throw r2     // Catch:{ all -> 0x003b }
            L_0x0046:
                if (r3 == 0) goto L_0x004d
                androidx.room.c r4 = androidx.room.c.this     // Catch:{ all -> 0x003b }
                r4.postValue(r0)     // Catch:{ all -> 0x003b }
            L_0x004d:
                androidx.room.c r0 = androidx.room.c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f16461g
                r0.set(r1)
                goto L_0x005e
            L_0x0055:
                androidx.room.c r2 = androidx.room.c.this
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f16461g
                r2.set(r1)
                throw r0
            L_0x005d:
                r3 = r1
            L_0x005e:
                if (r3 == 0) goto L_0x006a
                androidx.room.c r0 = androidx.room.c.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f16460f
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x001b
            L_0x006a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.c.a.run():void");
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            boolean hasActiveObservers = c.this.hasActiveObservers();
            if (c.this.f16460f.compareAndSet(false, true) && hasActiveObservers) {
                c.this.b().execute(c.this.f16463i);
            }
        }
    }

    /* renamed from: androidx.room.c$c  reason: collision with other inner class name */
    class C0213c extends InvalidationTracker.Observer {
        C0213c(String[] strArr) {
            super(strArr);
        }

        public void onInvalidated(Set set) {
            ArchTaskExecutor.getInstance().executeOnMainThread(c.this.f16464j);
        }
    }

    c(RoomDatabase roomDatabase, a aVar, boolean z10, Callable callable, String[] strArr) {
        this.f16455a = roomDatabase;
        this.f16456b = z10;
        this.f16457c = callable;
        this.f16458d = aVar;
        this.f16459e = new C0213c(strArr);
    }

    /* access modifiers changed from: package-private */
    public Executor b() {
        if (this.f16456b) {
            return this.f16455a.getTransactionExecutor();
        }
        return this.f16455a.getQueryExecutor();
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        super.onActive();
        this.f16458d.b(this);
        b().execute(this.f16463i);
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        super.onInactive();
        this.f16458d.c(this);
    }
}
