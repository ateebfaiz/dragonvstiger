package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.z0;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class RNGestureHandlerRootView extends ReactViewGroup {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11395c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f11396a;

    /* renamed from: b  reason: collision with root package name */
    private i f11397b;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final boolean b(ViewGroup viewGroup) {
            UiThreadUtil.assertOnUiThread();
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                if ((parent instanceof RNGestureHandlerEnabledRootView) || (parent instanceof RNGestureHandlerRootView)) {
                    return true;
                }
                if (parent instanceof z0) {
                    return false;
                }
            }
            return false;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.f11396a) {
            i iVar = this.f11397b;
            m.c(iVar);
            if (iVar.e(motionEvent)) {
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        m.f(motionEvent, "ev");
        if (this.f11396a) {
            i iVar = this.f11397b;
            m.c(iVar);
            if (iVar.e(motionEvent)) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean z10 = !f11395c.b(this);
        this.f11396a = z10;
        if (!z10) {
            Log.i("ReactNative", "[GESTURE HANDLER] Gesture handler is already enabled for a parent view");
        }
        if (this.f11396a && this.f11397b == null) {
            Context context = getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            this.f11397b = new i((ReactContext) context, this);
        }
    }

    public final void p(View view) {
        m.f(view, "view");
        i iVar = this.f11397b;
        if (iVar != null) {
            iVar.d(view);
        }
    }

    public final void q() {
        i iVar = this.f11397b;
        if (iVar != null) {
            iVar.j();
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (this.f11396a) {
            i iVar = this.f11397b;
            m.c(iVar);
            iVar.i();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }
}
