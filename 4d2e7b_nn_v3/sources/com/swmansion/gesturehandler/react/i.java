package com.swmansion.gesturehandler.react;

import ab.d;
import ab.g;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.z0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class i {

    /* renamed from: g  reason: collision with root package name */
    public static final a f11413g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ReactContext f11414a;

    /* renamed from: b  reason: collision with root package name */
    private final g f11415b;

    /* renamed from: c  reason: collision with root package name */
    private final d f11416c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f11417d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f11418e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11419f;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final ViewGroup b(ViewGroup viewGroup) {
            UiThreadUtil.assertOnUiThread();
            ViewParent viewParent = viewGroup;
            while (viewParent != null && !(viewParent instanceof z0)) {
                viewParent = viewParent.getParent();
            }
            if (viewParent != null) {
                return (ViewGroup) viewParent;
            }
            throw new IllegalStateException(("View " + viewGroup + " has not been mounted under ReactRootView").toString());
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class b extends d {
        public b() {
        }

        /* access modifiers changed from: protected */
        public void g0() {
            i.this.f11418e = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            if (i.this.f() instanceof z0) {
                ((z0) i.this.f()).a(i.this.f(), obtain);
            }
            obtain.recycle();
        }

        /* access modifiers changed from: protected */
        public void h0(MotionEvent motionEvent, MotionEvent motionEvent2) {
            g N2;
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            m.f(motionEvent2, "sourceEvent");
            if (Q() == 0 && (!i.this.f11418e || (N2 = N()) == null || !N2.r())) {
                n();
                i.this.f11418e = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                z();
            }
        }
    }

    public i(ReactContext reactContext, ViewGroup viewGroup) {
        m.f(reactContext, "context");
        m.f(viewGroup, "wrappedView");
        this.f11414a = reactContext;
        UiThreadUtil.assertOnUiThread();
        int id2 = viewGroup.getId();
        if (id2 >= 1) {
            m.d(reactContext, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
            NativeModule nativeModule = ((e1) reactContext).b().getNativeModule(RNGestureHandlerModule.class);
            m.c(nativeModule);
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
            g registry = rNGestureHandlerModule.getRegistry();
            ViewGroup a10 = f11413g.b(viewGroup);
            this.f11417d = a10;
            Log.i("ReactNative", "[GESTURE HANDLER] Initialize gesture handler for root view " + a10);
            g gVar = new g(viewGroup, registry, new l());
            gVar.B(0.1f);
            this.f11415b = gVar;
            b bVar = new b();
            bVar.G0(-id2);
            this.f11416c = bVar;
            registry.j(bVar);
            registry.c(bVar.R(), id2, 3);
            rNGestureHandlerModule.registerRootHelper(this);
            return;
        }
        throw new IllegalStateException(("Expect view tag to be set for " + viewGroup).toString());
    }

    /* access modifiers changed from: private */
    public static final void h(i iVar) {
        m.f(iVar, "this$0");
        iVar.k();
    }

    private final void k() {
        d dVar = this.f11416c;
        if (dVar != null && dVar.Q() == 2) {
            dVar.i();
            dVar.z();
        }
    }

    public final void d(View view) {
        m.f(view, "view");
        g gVar = this.f11415b;
        if (gVar != null) {
            gVar.d(view);
        }
    }

    public final boolean e(MotionEvent motionEvent) {
        m.f(motionEvent, "ev");
        this.f11419f = true;
        g gVar = this.f11415b;
        m.c(gVar);
        gVar.x(motionEvent);
        this.f11419f = false;
        return this.f11418e;
    }

    public final ViewGroup f() {
        return this.f11417d;
    }

    public final void g(int i10, boolean z10) {
        if (z10) {
            UiThreadUtil.runOnUiThread(new h(this));
        }
    }

    public final void i() {
        if (this.f11415b != null && !this.f11419f) {
            k();
        }
    }

    public final void j() {
        ViewGroup viewGroup = this.f11417d;
        Log.i("ReactNative", "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + viewGroup);
        ReactContext reactContext = this.f11414a;
        m.d(reactContext, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        NativeModule nativeModule = ((e1) reactContext).b().getNativeModule(RNGestureHandlerModule.class);
        m.c(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        g registry = rNGestureHandlerModule.getRegistry();
        d dVar = this.f11416c;
        m.c(dVar);
        registry.g(dVar.R());
        rNGestureHandlerModule.unregisterRootHelper(this);
    }
}
