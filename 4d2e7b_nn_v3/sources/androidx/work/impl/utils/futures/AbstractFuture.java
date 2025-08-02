package androidx.work.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements ListenableFuture<V> {
    static final b ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Object NULL = new Object();
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log;
    @Nullable
    volatile e listeners;
    @Nullable
    volatile Object value;
    @Nullable
    volatile i waiters;

    private static abstract class b {
        private b() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractFuture abstractFuture, e eVar, e eVar2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractFuture abstractFuture, i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void d(i iVar, i iVar2);

        /* access modifiers changed from: package-private */
        public abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f17095c;

        /* renamed from: d  reason: collision with root package name */
        static final c f17096d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f17097a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f17098b;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
                f17096d = null;
                f17095c = null;
                return;
            }
            f17096d = new c(false, (Throwable) null);
            f17095c = new c(true, (Throwable) null);
        }

        c(boolean z10, Throwable th) {
            this.f17097a = z10;
            this.f17098b = th;
        }
    }

    private static final class d {

        /* renamed from: b  reason: collision with root package name */
        static final d f17099b = new d(new a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        final Throwable f17100a;

        class a extends Throwable {
            a(String str) {
                super(str);
            }

            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f17100a = (Throwable) AbstractFuture.checkNotNull(th);
        }
    }

    private static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f17101d = new e((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f17102a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f17103b;

        /* renamed from: c  reason: collision with root package name */
        e f17104c;

        e(Runnable runnable, Executor executor) {
            this.f17102a = runnable;
            this.f17103b = executor;
        }
    }

    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater f17105a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater f17106b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater f17107c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater f17108d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater f17109e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f17105a = atomicReferenceFieldUpdater;
            this.f17106b = atomicReferenceFieldUpdater2;
            this.f17107c = atomicReferenceFieldUpdater3;
            this.f17108d = atomicReferenceFieldUpdater4;
            this.f17109e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture abstractFuture, e eVar, e eVar2) {
            return androidx.concurrent.futures.a.a(this.f17108d, abstractFuture, eVar, eVar2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return androidx.concurrent.futures.a.a(this.f17109e, abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture abstractFuture, i iVar, i iVar2) {
            return androidx.concurrent.futures.a.a(this.f17107c, abstractFuture, iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            this.f17106b.lazySet(iVar, iVar2);
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            this.f17105a.lazySet(iVar, thread);
        }
    }

    private static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final AbstractFuture f17110a;

        /* renamed from: b  reason: collision with root package name */
        final ListenableFuture f17111b;

        g(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.f17110a = abstractFuture;
            this.f17111b = listenableFuture;
        }

        public void run() {
            if (this.f17110a.value == this) {
                if (AbstractFuture.ATOMIC_HELPER.b(this.f17110a, this, AbstractFuture.getFutureValue(this.f17111b))) {
                    AbstractFuture.complete(this.f17110a);
                }
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture abstractFuture, e eVar, e eVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.listeners != eVar) {
                        return false;
                    }
                    abstractFuture.listeners = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.value != obj) {
                        return false;
                    }
                    abstractFuture.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture abstractFuture, i iVar, i iVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.waiters != iVar) {
                        return false;
                    }
                    abstractFuture.waiters = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d(i iVar, i iVar2) {
            iVar.f17114b = iVar2;
        }

        /* access modifiers changed from: package-private */
        public void e(i iVar, Thread thread) {
            iVar.f17113a = thread;
        }
    }

    private static final class i {

        /* renamed from: c  reason: collision with root package name */
        static final i f17112c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f17113a;

        /* renamed from: b  reason: collision with root package name */
        volatile i f17114b;

        i(boolean z10) {
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            AbstractFuture.ATOMIC_HELPER.d(this, iVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f17113a;
            if (thread != null) {
                this.f17113a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            AbstractFuture.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.work.impl.utils.futures.AbstractFuture$h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.work.impl.utils.futures.AbstractFuture$f} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$i> r0 = androidx.work.impl.utils.futures.AbstractFuture.i.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            GENERATE_CANCELLATION_CAUSES = r1
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture> r1 = androidx.work.impl.utils.futures.AbstractFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            log = r2
            androidx.work.impl.utils.futures.AbstractFuture$f r2 = new androidx.work.impl.utils.futures.AbstractFuture$f     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "waiters"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.work.impl.utils.futures.AbstractFuture$e> r0 = androidx.work.impl.utils.futures.AbstractFuture.e.class
            java.lang.String r3 = "listeners"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "value"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.work.impl.utils.futures.AbstractFuture$h r2 = new androidx.work.impl.utils.futures.AbstractFuture$h
            r2.<init>()
        L_0x004e:
            ATOMIC_HELPER = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = log
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            NULL = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.<clinit>():void");
    }

    protected AbstractFuture() {
    }

    private void addDoneString(StringBuilder sb2) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(userObjectToString(uninterruptibly));
            sb2.append("]");
        } catch (ExecutionException e10) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e10.getCause());
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e11) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e11.getClass());
            sb2.append(" thrown from get()]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @NonNull
    static <T> T checkNotNull(@Nullable T t10) {
        t10.getClass();
        return t10;
    }

    private e clearListeners(e eVar) {
        e eVar2;
        do {
            eVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, eVar2, e.f17101d));
        e eVar3 = eVar2;
        e eVar4 = eVar;
        e eVar5 = eVar3;
        while (eVar5 != null) {
            e eVar6 = eVar5.f17104c;
            eVar5.f17104c = eVar4;
            eVar4 = eVar5;
            eVar5 = eVar6;
        }
        return eVar4;
    }

    static void complete(AbstractFuture<?> abstractFuture) {
        e eVar = null;
        while (true) {
            abstractFuture.releaseWaiters();
            abstractFuture.afterDone();
            e clearListeners = abstractFuture.clearListeners(eVar);
            while (true) {
                if (clearListeners != null) {
                    eVar = clearListeners.f17104c;
                    Runnable runnable = clearListeners.f17102a;
                    if (runnable instanceof g) {
                        g gVar = (g) runnable;
                        abstractFuture = gVar.f17110a;
                        if (abstractFuture.value == gVar) {
                            if (ATOMIC_HELPER.b(abstractFuture, gVar, getFutureValue(gVar.f17111b))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, clearListeners.f17103b);
                    }
                    clearListeners = eVar;
                } else {
                    return;
                }
            }
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e10);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((c) obj).f17098b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f17100a);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) listenableFuture).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (!cVar.f17097a) {
                return obj;
            }
            if (cVar.f17098b != null) {
                return new c(false, cVar.f17098b);
            }
            return c.f17096d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return c.f17096d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
        } catch (ExecutionException e10) {
            return new d(e10.getCause());
        } catch (CancellationException e11) {
            if (isCancelled) {
                return new c(false, e11);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e11));
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void releaseWaiters() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f17112c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f17114b;
        }
    }

    private void removeWaiter(i iVar) {
        iVar.f17113a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 != i.f17112c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f17114b;
                    if (iVar2.f17113a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f17114b = iVar4;
                        if (iVar3.f17113a == null) {
                        }
                    } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    private String userObjectToString(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        if (eVar != e.f17101d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f17104c = eVar;
                if (!ATOMIC_HELPER.a(this, eVar, eVar2)) {
                    eVar = this.listeners;
                } else {
                    return;
                }
            } while (eVar != e.f17101d);
        }
        executeListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r2
        L_0x0009:
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.g
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = new androidx.work.impl.utils.futures.AbstractFuture$c
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.c.f17095c
            goto L_0x0026
        L_0x0024:
            androidx.work.impl.utils.futures.AbstractFuture$c r3 = androidx.work.impl.utils.futures.AbstractFuture.c.f17096d
        L_0x0026:
            r4 = r7
            r5 = r2
        L_0x0028:
            androidx.work.impl.utils.futures.AbstractFuture$b r6 = ATOMIC_HELPER
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            complete(r4)
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.g
            if (r4 == 0) goto L_0x0062
            androidx.work.impl.utils.futures.AbstractFuture$g r0 = (androidx.work.impl.utils.futures.AbstractFuture.g) r0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.f17111b
            boolean r4 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.work.impl.utils.futures.AbstractFuture r4 = (androidx.work.impl.utils.futures.AbstractFuture) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = r1
            goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.g
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = r1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof androidx.work.impl.utils.futures.AbstractFuture.g
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = r2
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.cancel(boolean):boolean");
    }

    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j11 = j10;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j11);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof g))) {
                return getDoneValue(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= SPIN_THRESHOLD_NANOS) {
                i iVar = this.waiters;
                if (iVar != i.f17112c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof g))) {
                                        return getDoneValue(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    removeWaiter(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= SPIN_THRESHOLD_NANOS);
                            removeWaiter(iVar2);
                        } else {
                            iVar = this.waiters;
                        }
                    } while (iVar != i.f17112c);
                }
                return getDoneValue(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof g))) {
                    return getDoneValue(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j11 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + SPIN_THRESHOLD_NANOS < 0) {
                String str2 = str + " (plus ";
                long j12 = -nanos;
                long convert = timeUnit2.convert(j12, TimeUnit.NANOSECONDS);
                long nanos2 = j12 - timeUnit2.toNanos(convert);
                int i10 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z10 = i10 == 0 || nanos2 > SPIN_THRESHOLD_NANOS;
                if (i10 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    public final boolean isDone() {
        boolean z10;
        Object obj = this.value;
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(obj instanceof g)) & z10;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@Nullable Future<?> future) {
        boolean z10;
        if (future != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof g) {
            return "setFuture=[" + userObjectToString(((g) obj).f17111b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean set(@Nullable V v10) {
        if (v10 == null) {
            v10 = NULL;
        }
        if (!ATOMIC_HELPER.b(this, (Object) null, v10)) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, (Object) null, new d((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        g gVar;
        d dVar;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, (Object) null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            gVar = new g(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, (Object) null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, a.INSTANCE);
                } catch (Throwable unused) {
                    dVar = d.f17099b;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f17097a);
        }
        return false;
        ATOMIC_HELPER.b(this, gVar, dVar);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb2);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                addDoneString(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        if (!(obj instanceof c) || !((c) obj).f17097a) {
            return false;
        }
        return true;
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof g))) {
                return getDoneValue(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.f17112c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return getDoneValue(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.f17112c);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
