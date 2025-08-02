package d1;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class e implements d, Runnable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21016c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Thread f21017d;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f21018a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f21019b;

    public static final class a {
        private a() {
        }

        public final Thread a() {
            Thread b10 = b();
            m.c(b10);
            return b10;
        }

        public final Thread b() {
            if (e.f21017d == null) {
                e.f21017d = Looper.getMainLooper().getThread();
            }
            return e.f21017d;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void d() {
        synchronized (this) {
            while (!f()) {
                try {
                    wait();
                } finally {
                }
            }
            Unit unit = Unit.f12577a;
        }
    }

    private final boolean f() {
        int i10 = this.f21018a.get();
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        return true;
    }

    private final boolean g() {
        if (Thread.currentThread() == f21016c.a()) {
            return true;
        }
        return false;
    }

    public Object a() {
        while (true) {
            int i10 = this.f21018a.get();
            if (i10 != 0) {
                if (i10 == 1) {
                    d();
                } else if (i10 == 2) {
                    return this.f21019b;
                } else {
                    if (i10 == 999) {
                        return null;
                    }
                }
            } else if (g()) {
                d();
            } else {
                run();
            }
        }
    }

    public abstract Object e();

    public Object get() {
        while (true) {
            int i10 = this.f21018a.get();
            if (i10 != 0) {
                if (i10 == 1) {
                    d();
                } else if (i10 == 2) {
                    return this.f21019b;
                } else {
                    if (i10 == 999) {
                        Object obj = this.f21019b;
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                        throw ((Throwable) obj);
                    }
                }
            } else if (g()) {
                d();
            } else {
                run();
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void run() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f21018a
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r3.e()     // Catch:{ all -> 0x0021 }
            r3.f21019b = r0     // Catch:{ all -> 0x0021 }
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f21018a     // Catch:{ all -> 0x0021 }
            r1 = 2
            r0.set(r1)     // Catch:{ all -> 0x0021 }
            monitor-enter(r3)
            r3.notifyAll()     // Catch:{ all -> 0x001e }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r3)
            goto L_0x0041
        L_0x001e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0021:
            r0 = move-exception
            r3.f21019b = r0     // Catch:{ all -> 0x0035 }
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f21018a     // Catch:{ all -> 0x0035 }
            r1 = 999(0x3e7, float:1.4E-42)
            r0.set(r1)     // Catch:{ all -> 0x0035 }
            monitor-enter(r3)
            r3.notifyAll()     // Catch:{ all -> 0x0032 }
            kotlin.Unit r0 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0032 }
            goto L_0x001c
        L_0x0032:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0035:
            r0 = move-exception
            monitor-enter(r3)
            r3.notifyAll()     // Catch:{ all -> 0x003e }
            kotlin.Unit r1 = kotlin.Unit.f12577a     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            throw r0
        L_0x003e:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.e.run():void");
    }
}
