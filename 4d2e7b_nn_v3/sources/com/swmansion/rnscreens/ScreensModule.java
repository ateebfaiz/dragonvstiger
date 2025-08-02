package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import cb.h;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "RNSModule")
public final class ScreensModule extends NativeScreensModuleSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "RNSModule";
    private final AtomicBoolean isActiveTransition = new AtomicBoolean(false);
    private e proxy;
    private final ReactApplicationContext reactContext;
    private int topScreenId = -1;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreensModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
        try {
            System.loadLibrary("rnscreens");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (javaScriptContextHolder != null) {
                nativeInstall(javaScriptContextHolder.get());
            } else {
                Log.e("[RNScreens]", "Could not install JSI bindings.");
            }
        } catch (UnsatisfiedLinkError unused) {
            Log.w("[RNScreens]", "Could not load RNScreens module.");
        }
    }

    @d6.a
    private final void finishTransition(Integer num, boolean z10) {
        View view;
        UiThreadUtil.assertOnUiThread();
        if (!this.isActiveTransition.get() || num == null) {
            Log.e("[RNScreens]", "Unable to call `finishTransition` method before transition start.");
            return;
        }
        UIManager i10 = k1.i(this.reactContext, num.intValue());
        if (i10 != null) {
            view = i10.resolveView(num.intValue());
        } else {
            view = null;
        }
        if (view instanceof ScreenStack) {
            if (z10) {
                ((ScreenStack) view).h();
            } else {
                ((ScreenStack) view).q();
            }
            this.isActiveTransition.set(false);
        }
        this.topScreenId = -1;
    }

    private final native void nativeInstall(long j10);

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r8 = (com.swmansion.rnscreens.ScreenStack) r8;
        r1 = r8.getFragments();
     */
    @d6.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int[] startTransition(java.lang.Integer r8) {
        /*
            r7 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.isActiveTransition
            boolean r0 = r0.get()
            r1 = -1
            if (r0 != 0) goto L_0x006e
            if (r8 != 0) goto L_0x000f
            goto L_0x006e
        L_0x000f:
            r7.topScreenId = r1
            r0 = 2
            int[] r2 = new int[r0]
            r3 = 0
            r2[r3] = r1
            r4 = 1
            r2[r4] = r1
            com.facebook.react.bridge.ReactApplicationContext r1 = r7.reactContext
            int r5 = r8.intValue()
            com.facebook.react.bridge.UIManager r1 = com.facebook.react.uimanager.k1.i(r1, r5)
            if (r1 == 0) goto L_0x002f
            int r8 = r8.intValue()
            android.view.View r8 = r1.resolveView(r8)
            goto L_0x0030
        L_0x002f:
            r8 = 0
        L_0x0030:
            boolean r1 = r8 instanceof com.swmansion.rnscreens.ScreenStack
            if (r1 == 0) goto L_0x006d
            com.swmansion.rnscreens.ScreenStack r8 = (com.swmansion.rnscreens.ScreenStack) r8
            java.util.ArrayList r1 = r8.getFragments()
            int r5 = r1.size()
            if (r5 <= r4) goto L_0x006d
            java.util.concurrent.atomic.AtomicBoolean r6 = r7.isActiveTransition
            r6.set(r4)
            r8.e()
            int r8 = r5 + -1
            java.lang.Object r8 = r1.get(r8)
            com.swmansion.rnscreens.n r8 = (com.swmansion.rnscreens.n) r8
            com.swmansion.rnscreens.Screen r8 = r8.i()
            int r8 = r8.getId()
            r7.topScreenId = r8
            r2[r3] = r8
            int r5 = r5 - r0
            java.lang.Object r8 = r1.get(r5)
            com.swmansion.rnscreens.n r8 = (com.swmansion.rnscreens.n) r8
            com.swmansion.rnscreens.Screen r8 = r8.i()
            int r8 = r8.getId()
            r2[r4] = r8
        L_0x006d:
            return r2
        L_0x006e:
            int[] r8 = new int[]{r1, r1}
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreensModule.startTransition(java.lang.Integer):int[]");
    }

    @d6.a
    private final void updateTransition(double d10) {
        UiThreadUtil.assertOnUiThread();
        if (this.topScreenId != -1) {
            float f10 = (float) d10;
            short a10 = ScreenFragment.f11530i.a(f10);
            e c10 = k1.c(this.reactContext, this.topScreenId);
            if (c10 != null) {
                c10.c(new h(k1.e(this.reactContext), this.topScreenId, f10, true, true, a10));
            }
        }
    }

    public String getName() {
        return "RNSModule";
    }

    public void initialize() {
        super.initialize();
    }
}
