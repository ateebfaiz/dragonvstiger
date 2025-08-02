package com.facebook.react.uimanager.events;

import android.view.Choreographer;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.k1;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class k implements e, LifecycleEventListener {

    /* renamed from: a  reason: collision with root package name */
    private final ReactEventEmitter f3608a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ReactApplicationContext f3609b;

    /* renamed from: c  reason: collision with root package name */
    private final CopyOnWriteArrayList f3610c = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList f3611d = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final b f3612e = new b();

    class a implements Runnable {
        a() {
        }

        public void run() {
            k.this.q();
        }
    }

    private class b implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f3614a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3615b;

        class a implements Runnable {
            a() {
            }

            public void run() {
                b.this.a();
            }
        }

        private void c() {
            com.facebook.react.modules.core.a.h().m(a.b.TIMERS_EVENTS, k.this.f3612e);
        }

        public void a() {
            if (!this.f3614a) {
                this.f3614a = true;
                c();
            }
        }

        public void b() {
            if (!this.f3614a) {
                if (k.this.f3609b.isOnUiQueueThread()) {
                    a();
                } else {
                    k.this.f3609b.runOnUiQueueThread(new a());
                }
            }
        }

        public void d() {
            this.f3615b = true;
        }

        public void doFrame(long j10) {
            UiThreadUtil.assertOnUiThread();
            if (this.f3615b) {
                this.f3614a = false;
            } else {
                c();
            }
            c8.a.c(0, "BatchEventDispatchedListeners");
            try {
                Iterator it = k.this.f3611d.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onBatchEventDispatched();
                }
            } finally {
                c8.a.g(0);
            }
        }

        private b() {
            this.f3614a = false;
            this.f3615b = false;
        }
    }

    public k(ReactApplicationContext reactApplicationContext) {
        this.f3609b = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.f3608a = new ReactEventEmitter(reactApplicationContext);
    }

    private void o(d dVar) {
        c8.a.c(0, "FabricEventDispatcher.dispatchSynchronous('" + dVar.getEventName() + "')");
        try {
            UIManager g10 = k1.g(this.f3609b, 2);
            if (g10 instanceof p) {
                ((p) g10).receiveEvent(dVar.getSurfaceId(), dVar.getViewTag(), dVar.getEventName(), dVar.canCoalesce(), dVar.getEventData(), dVar.getEventCategory(), true);
            } else {
                ReactSoftExceptionLogger.logSoftException("FabricEventDispatcher", new ReactNoCrashSoftException("Fabric UIManager expected to implement SynchronousEventReceiver."));
            }
        } finally {
            c8.a.g(0);
        }
    }

    private void p() {
        if (this.f3608a != null) {
            this.f3612e.b();
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        UiThreadUtil.assertOnUiThread();
        this.f3612e.d();
    }

    public void a(int i10, RCTEventEmitter rCTEventEmitter) {
        this.f3608a.register(i10, rCTEventEmitter);
    }

    public void b(i iVar) {
        this.f3610c.add(iVar);
    }

    public void c(d dVar) {
        Iterator it = this.f3610c.iterator();
        while (it.hasNext()) {
            ((i) it.next()).onEventDispatch(dVar);
        }
        if (dVar.experimental_isSynchronous()) {
            o(dVar);
        } else {
            dVar.dispatchModern(this.f3608a);
        }
        dVar.dispose();
        p();
    }

    public void d() {
        p();
    }

    public void e(a aVar) {
        this.f3611d.remove(aVar);
    }

    public void f(a aVar) {
        this.f3611d.add(aVar);
    }

    public void g() {
        UiThreadUtil.runOnUiThread(new a());
    }

    public void h(int i10, RCTModernEventEmitter rCTModernEventEmitter) {
        this.f3608a.register(i10, rCTModernEventEmitter);
    }

    public void i(int i10) {
        this.f3608a.unregister(i10);
    }

    public void j(i iVar) {
        this.f3610c.remove(iVar);
    }

    public void onHostDestroy() {
        q();
    }

    public void onHostPause() {
        q();
    }

    public void onHostResume() {
        p();
    }
}
