package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import e6.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c implements NotThreadSafeBridgeIdleDebugListener, j7.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f3251f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f3252a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3253b;

    /* renamed from: c  reason: collision with root package name */
    private final d f3254c;

    /* renamed from: d  reason: collision with root package name */
    private final d f3255d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f3256e = true;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void d(d dVar, long j10) {
            int g10 = dVar.g();
            int i10 = 0;
            for (int i11 = 0; i11 < g10; i11++) {
                if (dVar.d(i11) < j10) {
                    i10++;
                }
            }
            if (i10 > 0) {
                int i12 = g10 - i10;
                for (int i13 = 0; i13 < i12; i13++) {
                    dVar.f(i13, dVar.d(i13 + i10));
                }
                dVar.c(i10);
            }
        }

        /* access modifiers changed from: private */
        public final long e(d dVar, long j10, long j11) {
            int g10 = dVar.g();
            long j12 = -1;
            for (int i10 = 0; i10 < g10; i10++) {
                long d10 = dVar.d(i10);
                if (j10 <= d10 && d10 < j11) {
                    j12 = d10;
                } else if (d10 >= j11) {
                    break;
                }
            }
            return j12;
        }

        /* access modifiers changed from: private */
        public final boolean f(d dVar, long j10, long j11) {
            int g10 = dVar.g();
            for (int i10 = 0; i10 < g10; i10++) {
                long d10 = dVar.d(i10);
                if (j10 <= d10 && d10 < j11) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c() {
        d b10 = d.b(20);
        m.e(b10, "createWithInitialCapacity(...)");
        this.f3252a = b10;
        d b11 = d.b(20);
        m.e(b11, "createWithInitialCapacity(...)");
        this.f3253b = b11;
        d b12 = d.b(20);
        m.e(b12, "createWithInitialCapacity(...)");
        this.f3254c = b12;
        d b13 = d.b(20);
        m.e(b13, "createWithInitialCapacity(...)");
        this.f3255d = b13;
    }

    private final boolean c(long j10, long j11) {
        a aVar = f3251f;
        long j12 = j10;
        long j13 = j11;
        long b10 = aVar.e(this.f3252a, j12, j13);
        long b11 = aVar.e(this.f3253b, j12, j13);
        if (b10 == -1 && b11 == -1) {
            return this.f3256e;
        }
        if (b10 > b11) {
            return true;
        }
        return false;
    }

    public synchronized void a() {
        this.f3254c.a(System.nanoTime());
    }

    public synchronized void b() {
        this.f3255d.a(System.nanoTime());
    }

    public final synchronized boolean d(long j10, long j11) {
        boolean z10;
        try {
            a aVar = f3251f;
            boolean c10 = aVar.f(this.f3255d, j10, j11);
            boolean c11 = c(j10, j11);
            z10 = true;
            if (!c10) {
                if (c11) {
                    if (!aVar.f(this.f3254c, j10, j11)) {
                    }
                }
                z10 = false;
            }
            aVar.d(this.f3252a, j11);
            aVar.d(this.f3253b, j11);
            aVar.d(this.f3254c, j11);
            aVar.d(this.f3255d, j11);
            this.f3256e = c11;
        } catch (Throwable th) {
            throw th;
        }
        return z10;
    }

    public synchronized void onBridgeDestroyed() {
    }

    public synchronized void onTransitionToBridgeBusy() {
        this.f3253b.a(System.nanoTime());
    }

    public synchronized void onTransitionToBridgeIdle() {
        this.f3252a.a(System.nanoTime());
    }
}
