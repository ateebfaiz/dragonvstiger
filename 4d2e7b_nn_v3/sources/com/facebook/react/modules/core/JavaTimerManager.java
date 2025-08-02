package com.facebook.react.modules.core;

import android.util.SparseArray;
import android.view.Choreographer;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.a;
import e6.k;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class JavaTimerManager implements LifecycleEventListener, r6.d {
    private final d C = new d();
    /* access modifiers changed from: private */
    public boolean N0 = false;
    /* access modifiers changed from: private */
    public c X;
    private boolean Y = false;
    private boolean Z = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ReactApplicationContext f3210a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final w6.c f3211b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a f3212c;

    /* renamed from: d  reason: collision with root package name */
    private final k6.e f3213d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Object f3214e = new Object();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Object f3215f = new Object();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final PriorityQueue f3216g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray f3217h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f3218i = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f3219j = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private final f f3220w = new f();

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i10 = ((eVar.f3231d - eVar2.f3231d) > 0 ? 1 : ((eVar.f3231d - eVar2.f3231d) == 0 ? 0 : -1));
            if (i10 == 0) {
                return 0;
            }
            if (i10 < 0) {
                return -1;
            }
            return 1;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f3222a;

        b(boolean z10) {
            this.f3222a = z10;
        }

        public void run() {
            synchronized (JavaTimerManager.this.f3215f) {
                try {
                    if (this.f3222a) {
                        JavaTimerManager.this.z();
                    } else {
                        JavaTimerManager.this.q();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f3224a = false;

        /* renamed from: b  reason: collision with root package name */
        private final long f3225b;

        public c(long j10) {
            this.f3225b = j10;
        }

        public void a() {
            this.f3224a = true;
        }

        public void run() {
            boolean j10;
            if (!this.f3224a) {
                long c10 = k.c() - (this.f3225b / 1000000);
                long a10 = k.a() - c10;
                if (16.666666f - ((float) c10) >= 1.0f) {
                    synchronized (JavaTimerManager.this.f3215f) {
                        j10 = JavaTimerManager.this.N0;
                    }
                    if (j10) {
                        JavaTimerManager.this.f3211b.callIdleCallbacks((double) a10);
                    }
                    JavaTimerManager.this.X = null;
                }
            }
        }
    }

    private class d implements Choreographer.FrameCallback {
        public void doFrame(long j10) {
            if (!JavaTimerManager.this.f3218i.get() || JavaTimerManager.this.f3219j.get()) {
                c e10 = JavaTimerManager.this.X;
                if (e10 != null) {
                    e10.a();
                }
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                javaTimerManager.X = new c(j10);
                JavaTimerManager.this.f3210a.runOnJSQueueThread(JavaTimerManager.this.X);
                JavaTimerManager.this.f3212c.m(a.b.IDLE_EVENT, this);
            }
        }

        private d() {
        }
    }

    private static class e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f3228a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3229b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f3230c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public long f3231d;

        private e(int i10, long j10, int i11, boolean z10) {
            this.f3228a = i10;
            this.f3231d = j10;
            this.f3230c = i11;
            this.f3229b = z10;
        }
    }

    private class f implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private WritableArray f3232a;

        public void doFrame(long j10) {
            if (!JavaTimerManager.this.f3218i.get() || JavaTimerManager.this.f3219j.get()) {
                long j11 = j10 / 1000000;
                synchronized (JavaTimerManager.this.f3214e) {
                    while (!JavaTimerManager.this.f3216g.isEmpty() && ((e) JavaTimerManager.this.f3216g.peek()).f3231d < j11) {
                        try {
                            e eVar = (e) JavaTimerManager.this.f3216g.poll();
                            if (this.f3232a == null) {
                                this.f3232a = Arguments.createArray();
                            }
                            this.f3232a.pushInt(eVar.f3228a);
                            if (eVar.f3229b) {
                                eVar.f3231d = ((long) eVar.f3230c) + j11;
                                JavaTimerManager.this.f3216g.add(eVar);
                            } else {
                                JavaTimerManager.this.f3217h.remove(eVar.f3228a);
                            }
                        } finally {
                            while (true) {
                            }
                        }
                    }
                }
                if (this.f3232a != null) {
                    JavaTimerManager.this.f3211b.callTimers(this.f3232a);
                    this.f3232a = null;
                }
                JavaTimerManager.this.f3212c.m(a.b.TIMERS_EVENTS, this);
            }
        }

        private f() {
            this.f3232a = null;
        }
    }

    public JavaTimerManager(ReactApplicationContext reactApplicationContext, w6.c cVar, a aVar, k6.e eVar) {
        this.f3210a = reactApplicationContext;
        this.f3211b = cVar;
        this.f3212c = aVar;
        this.f3213d = eVar;
        this.f3216g = new PriorityQueue(11, new a());
        this.f3217h = new SparseArray();
        reactApplicationContext.addLifecycleEventListener(this);
    }

    /* access modifiers changed from: private */
    public void q() {
        if (this.Z) {
            this.f3212c.o(a.b.IDLE_EVENT, this.C);
            this.Z = false;
        }
    }

    private void r() {
        r6.c e10 = r6.c.e(this.f3210a);
        if (this.Y && this.f3218i.get() && !e10.f()) {
            this.f3212c.o(a.b.TIMERS_EVENTS, this.f3220w);
            this.Y = false;
        }
    }

    private static boolean u(e eVar, long j10) {
        if (eVar.f3229b || ((long) eVar.f3230c) >= j10) {
            return false;
        }
        return true;
    }

    private void v() {
        if (this.f3218i.get() && !this.f3219j.get()) {
            r();
        }
    }

    private void w() {
        synchronized (this.f3215f) {
            try {
                if (this.N0) {
                    z();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void y() {
        if (!this.Y) {
            this.f3212c.m(a.b.TIMERS_EVENTS, this.f3220w);
            this.Y = true;
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        if (!this.Z) {
            this.f3212c.m(a.b.IDLE_EVENT, this.C);
            this.Z = true;
        }
    }

    public void a(int i10) {
        if (!r6.c.e(this.f3210a).f()) {
            this.f3219j.set(false);
            r();
            v();
        }
    }

    public void b(int i10) {
        if (!this.f3219j.getAndSet(true)) {
            y();
            w();
        }
    }

    @d6.a
    public void createTimer(int i10, long j10, boolean z10) {
        e eVar = new e(i10, (k.b() / 1000000) + j10, (int) j10, z10);
        synchronized (this.f3214e) {
            this.f3216g.add(eVar);
            this.f3217h.put(i10, eVar);
        }
    }

    @d6.a
    public void deleteTimer(int i10) {
        synchronized (this.f3214e) {
            try {
                e eVar = (e) this.f3217h.get(i10);
                if (eVar != null) {
                    this.f3217h.remove(i10);
                    this.f3216g.remove(eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onHostDestroy() {
        r();
        v();
    }

    public void onHostPause() {
        this.f3218i.set(true);
        r();
        v();
    }

    public void onHostResume() {
        this.f3218i.set(false);
        y();
        w();
    }

    public void s(int i10, int i11, double d10, boolean z10) {
        long a10 = k.a();
        long j10 = (long) d10;
        if (this.f3213d.n() && Math.abs(j10 - a10) > 60000) {
            this.f3211b.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long max = Math.max(0, (j10 - a10) + ((long) i11));
        if (i11 != 0 || z10) {
            createTimer(i10, max, z10);
            return;
        }
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i10);
        this.f3211b.callTimers(createArray);
    }

    @d6.a
    public void setSendIdleEvents(boolean z10) {
        synchronized (this.f3215f) {
            this.N0 = z10;
        }
        UiThreadUtil.runOnUiThread(new b(z10));
    }

    /* access modifiers changed from: package-private */
    public boolean t(long j10) {
        synchronized (this.f3214e) {
            try {
                e eVar = (e) this.f3216g.peek();
                if (eVar == null) {
                    return false;
                }
                if (u(eVar, j10)) {
                    return true;
                }
                Iterator it = this.f3216g.iterator();
                while (it.hasNext()) {
                    if (u((e) it.next(), j10)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void x() {
        this.f3210a.removeLifecycleEventListener(this);
        r();
        q();
    }
}
