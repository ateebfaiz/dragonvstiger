package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import android.view.Choreographer;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.core.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.ws.WebSocketProtocol;

public class f implements e, LifecycleEventListener {
    /* access modifiers changed from: private */
    public static final Comparator O0 = new a();
    /* access modifiers changed from: private */
    public d[] C = new d[16];
    /* access modifiers changed from: private */
    public volatile boolean N0 = false;
    /* access modifiers changed from: private */
    public int X = 0;
    /* access modifiers changed from: private */
    public volatile ReactEventEmitter Y;
    private short Z = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object f3591a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f3592b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ReactApplicationContext f3593c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray f3594d = new LongSparseArray();

    /* renamed from: e  reason: collision with root package name */
    private final Map f3595e = e6.f.b();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final c f3596f = new c();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList f3597g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final CopyOnWriteArrayList f3598h = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final CopyOnWriteArrayList f3599i = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final d f3600j = new d();
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final AtomicInteger f3601w = new AtomicInteger();

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            if (dVar == null && dVar2 == null) {
                return 0;
            }
            if (dVar == null) {
                return -1;
            }
            if (dVar2 == null) {
                return 1;
            }
            int i10 = ((dVar.getTimestampMs() - dVar2.getTimestampMs()) > 0 ? 1 : ((dVar.getTimestampMs() - dVar2.getTimestampMs()) == 0 ? 0 : -1));
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
        b() {
        }

        public void run() {
            f.this.G();
        }
    }

    private class c implements Runnable {
        public void run() {
            c8.a.c(0, "DispatchEventsRunnable");
            try {
                c8.a.d(0, "ScheduleDispatchFrameCallback", f.this.f3601w.getAndIncrement());
                f.this.N0 = false;
                p5.a.c(f.this.Y);
                synchronized (f.this.f3592b) {
                    if (f.this.X > 0) {
                        if (f.this.X > 1) {
                            Arrays.sort(f.this.C, 0, f.this.X, f.O0);
                        }
                        for (int i10 = 0; i10 < f.this.X; i10++) {
                            d dVar = f.this.C[i10];
                            if (dVar != null) {
                                c8.a.d(0, dVar.getEventName(), dVar.getUniqueID());
                                dVar.dispatchModern(f.this.Y);
                                dVar.dispose();
                            }
                        }
                        f.this.B();
                        f.this.f3594d.clear();
                    }
                }
                Iterator it = f.this.f3599i.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onBatchEventDispatched();
                }
                c8.a.g(0);
            } catch (Throwable th) {
                c8.a.g(0);
                throw th;
            }
        }

        private c() {
        }
    }

    private class d implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f3604a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3605b;

        class a implements Runnable {
            a() {
            }

            public void run() {
                d.this.a();
            }
        }

        private void c() {
            if (!ReactFeatureFlags.enableFabricRendererExclusively) {
                com.facebook.react.modules.core.a.h().m(a.b.TIMERS_EVENTS, f.this.f3600j);
            }
        }

        public void a() {
            if (!this.f3604a) {
                this.f3604a = true;
                c();
            }
        }

        public void b() {
            if (!this.f3604a) {
                if (f.this.f3593c.isOnUiQueueThread()) {
                    a();
                } else {
                    f.this.f3593c.runOnUiQueueThread(new a());
                }
            }
        }

        public void d() {
            this.f3605b = true;
        }

        public void doFrame(long j10) {
            UiThreadUtil.assertOnUiThread();
            if (this.f3605b) {
                this.f3604a = false;
            } else {
                c();
            }
            c8.a.c(0, "ScheduleDispatchFrameCallback");
            try {
                f.this.F();
                if (!f.this.N0) {
                    f.this.N0 = true;
                    c8.a.j(0, "ScheduleDispatchFrameCallback", f.this.f3601w.get());
                    f.this.f3593c.runOnJSQueueThread(f.this.f3596f);
                }
            } finally {
                c8.a.g(0);
            }
        }

        private d() {
            this.f3604a = false;
            this.f3605b = false;
        }
    }

    public f(ReactApplicationContext reactApplicationContext) {
        this.f3593c = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.Y = new ReactEventEmitter(reactApplicationContext);
    }

    private void A(d dVar) {
        int i10 = this.X;
        d[] dVarArr = this.C;
        if (i10 == dVarArr.length) {
            this.C = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        d[] dVarArr2 = this.C;
        int i11 = this.X;
        this.X = i11 + 1;
        dVarArr2[i11] = dVar;
    }

    /* access modifiers changed from: private */
    public void B() {
        Arrays.fill(this.C, 0, this.X, (Object) null);
        this.X = 0;
    }

    private long C(int i10, String str, short s10) {
        short s11;
        Short sh = (Short) this.f3595e.get(str);
        if (sh != null) {
            s11 = sh.shortValue();
        } else {
            short s12 = this.Z;
            this.Z = (short) (s12 + 1);
            this.f3595e.put(str, Short.valueOf(s12));
            s11 = s12;
        }
        return D(i10, s11, s10);
    }

    private static long D(int i10, short s10, short s11) {
        return ((((long) s10) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((long) i10) | ((((long) s11) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48);
    }

    private void E() {
        if (this.Y != null) {
            this.f3600j.b();
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        synchronized (this.f3591a) {
            synchronized (this.f3592b) {
                int i10 = 0;
                while (i10 < this.f3597g.size()) {
                    try {
                        d dVar = (d) this.f3597g.get(i10);
                        if (!dVar.canCoalesce()) {
                            A(dVar);
                        } else {
                            long C2 = C(dVar.getViewTag(), dVar.getEventName(), dVar.getCoalescingKey());
                            Integer num = (Integer) this.f3594d.get(C2);
                            d dVar2 = null;
                            if (num == null) {
                                this.f3594d.put(C2, Integer.valueOf(this.X));
                            } else {
                                d dVar3 = this.C[num.intValue()];
                                d coalesce = dVar.coalesce(dVar3);
                                if (coalesce != dVar3) {
                                    this.f3594d.put(C2, Integer.valueOf(this.X));
                                    this.C[num.intValue()] = null;
                                    dVar2 = dVar3;
                                    dVar = coalesce;
                                } else {
                                    dVar2 = dVar;
                                    dVar = null;
                                }
                            }
                            if (dVar != null) {
                                A(dVar);
                            }
                            if (dVar2 != null) {
                                dVar2.dispose();
                            }
                        }
                        i10++;
                    } finally {
                        while (true) {
                        }
                    }
                }
            }
            this.f3597g.clear();
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        UiThreadUtil.assertOnUiThread();
        this.f3600j.d();
    }

    public void a(int i10, RCTEventEmitter rCTEventEmitter) {
        this.Y.register(i10, rCTEventEmitter);
    }

    public void b(i iVar) {
        this.f3598h.add(iVar);
    }

    public void c(d dVar) {
        p5.a.b(dVar.isInitialized(), "Dispatched event hasn't been initialized");
        Iterator it = this.f3598h.iterator();
        while (it.hasNext()) {
            ((i) it.next()).onEventDispatch(dVar);
        }
        synchronized (this.f3591a) {
            this.f3597g.add(dVar);
            c8.a.j(0, dVar.getEventName(), dVar.getUniqueID());
        }
        E();
    }

    public void d() {
        E();
    }

    public void e(a aVar) {
        this.f3599i.remove(aVar);
    }

    public void f(a aVar) {
        this.f3599i.add(aVar);
    }

    public void g() {
        UiThreadUtil.runOnUiThread(new b());
    }

    public void h(int i10, RCTModernEventEmitter rCTModernEventEmitter) {
        this.Y.register(i10, rCTModernEventEmitter);
    }

    public void i(int i10) {
        this.Y.unregister(i10);
    }

    public void j(i iVar) {
        this.f3598h.remove(iVar);
    }

    public void onHostDestroy() {
        G();
    }

    public void onHostPause() {
        G();
    }

    public void onHostResume() {
        E();
    }
}
