package com.airbnb.android.react.lottie;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.j;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.e1;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.m;

public final class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
    private final WeakHashMap<LottieAnimationView, h> propManagersMap = new WeakHashMap<>();

    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f17554a;

        a(LottieAnimationView lottieAnimationView) {
            this.f17554a = lottieAnimationView;
        }

        public void onAnimationCancel(Animator animator) {
            m.f(animator, "animation");
            g.r(this.f17554a, true);
        }

        public void onAnimationEnd(Animator animator) {
            m.f(animator, "animation");
            g.r(this.f17554a, false);
        }

        public void onAnimationRepeat(Animator animator) {
            m.f(animator, "animation");
        }

        public void onAnimationStart(Animator animator) {
            m.f(animator, "animation");
        }
    }

    /* access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(LottieAnimationView lottieAnimationView, Throwable th) {
        m.f(lottieAnimationView, "$view");
        m.c(th);
        g.p(lottieAnimationView, th);
    }

    /* access modifiers changed from: private */
    public static final void createViewInstance$lambda$1(LottieAnimationView lottieAnimationView, j jVar) {
        m.f(lottieAnimationView, "$view");
        g.q(lottieAnimationView);
    }

    private final h getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        h hVar = this.propManagersMap.get(lottieAnimationView);
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, hVar2);
        return hVar2;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return g.f();
    }

    public Map<String, Object> getExportedViewConstants() {
        return g.g();
    }

    public String getName() {
        return "LottieAnimationView";
    }

    @h7.a(name = "autoPlay")
    public final void setAutoPlay(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        g.s(z10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "cacheComposition")
    public final void setCacheComposition(LottieAnimationView lottieAnimationView, boolean z10) {
        m.c(lottieAnimationView);
        g.t(lottieAnimationView, z10);
    }

    @h7.a(name = "colorFilters")
    public final void setColorFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        m.f(lottieAnimationView, "view");
        g.u(readableArray, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "enableMergePathsAndroidForKitKatAndAbove")
    public final void setEnableMergePaths(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        g.v(z10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "enableSafeModeAndroid")
    public final void setEnableSafeMode(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        g.w(z10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "hardwareAccelerationAndroid")
    public final void setHardwareAccelerationAndroid(LottieAnimationView lottieAnimationView, Boolean bool) {
        m.f(lottieAnimationView, "view");
        m.c(bool);
        g.x(bool.booleanValue(), getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "imageAssetsFolder")
    public final void setImageAssetsFolder(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.y(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "loop")
    public final void setLoop(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        g.z(z10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "progress")
    public final void setProgress(LottieAnimationView lottieAnimationView, float f10) {
        m.f(lottieAnimationView, "view");
        g.A(f10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "renderMode")
    public final void setRenderMode(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.B(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "resizeMode")
    public final void setResizeMode(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.C(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "sourceDotLottieURI")
    public final void setSourceDotLottie(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.D(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "sourceJson")
    public final void setSourceJson(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.E(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "sourceName")
    public final void setSourceName(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.F(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "sourceURL")
    public final void setSourceURL(LottieAnimationView lottieAnimationView, String str) {
        m.f(lottieAnimationView, "view");
        g.G(str, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "speed")
    public final void setSpeed(LottieAnimationView lottieAnimationView, double d10) {
        m.f(lottieAnimationView, "view");
        g.H(d10, getOrCreatePropertyManager(lottieAnimationView));
    }

    @h7.a(name = "textFiltersAndroid")
    public final void setTextFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        m.f(lottieAnimationView, "view");
        g.I(readableArray, getOrCreatePropertyManager(lottieAnimationView));
    }

    public LottieAnimationView createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        LottieAnimationView e10 = g.e(e1Var);
        e10.setFailureListener(new a(e10));
        e10.h(new b(e10));
        e10.g(new a(e10));
        return e10;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        super.onAfterUpdateTransaction(lottieAnimationView);
        getOrCreatePropertyManager(lottieAnimationView).a();
    }

    public void receiveCommand(LottieAnimationView lottieAnimationView, String str, ReadableArray readableArray) {
        m.f(lottieAnimationView, "view");
        m.f(str, "commandName");
        switch (str.hashCode()) {
            case -934426579:
                if (str.equals("resume")) {
                    g.n(lottieAnimationView);
                    return;
                }
                return;
            case 3443508:
                if (str.equals("play")) {
                    int i10 = -1;
                    int i11 = readableArray != null ? readableArray.getInt(0) : -1;
                    if (readableArray != null) {
                        i10 = readableArray.getInt(1);
                    }
                    g.j(lottieAnimationView, i11, i10);
                    return;
                }
                return;
            case 106440182:
                if (str.equals("pause")) {
                    g.h(lottieAnimationView);
                    return;
                }
                return;
            case 108404047:
                if (str.equals("reset")) {
                    g.l(lottieAnimationView);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
