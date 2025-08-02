package com.airbnb.android.react.lottie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.y0;
import com.alibaba.pdns.f;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f17564a = new g();

    public static final class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f17565a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f17566b;

        a(boolean z10, LottieAnimationView lottieAnimationView) {
            this.f17565a = z10;
            this.f17566b = lottieAnimationView;
        }

        public void onViewAttachedToWindow(View view) {
            m.f(view, DomainUhfReportModel.ENCRYPTYPE);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
            if (this.f17565a) {
                this.f17566b.v();
            } else {
                this.f17566b.w();
            }
            lottieAnimationView.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            m.f(view, DomainUhfReportModel.ENCRYPTYPE);
            ((LottieAnimationView) view).removeOnAttachStateChangeListener(this);
        }
    }

    private g() {
    }

    public static final void A(float f10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.m(Float.valueOf(f10));
    }

    public static final void B(String str, h hVar) {
        y0 y0Var;
        m.f(hVar, "viewManager");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 165298699) {
                if (hashCode != 899536360) {
                    if (hashCode == 2101957031 && str.equals("SOFTWARE")) {
                        y0Var = y0.SOFTWARE;
                        hVar.n(y0Var);
                    }
                } else if (str.equals("HARDWARE")) {
                    y0Var = y0.HARDWARE;
                    hVar.n(y0Var);
                }
            } else if (str.equals("AUTOMATIC")) {
                y0Var = y0.AUTOMATIC;
                hVar.n(y0Var);
            }
        }
        y0Var = null;
        hVar.n(y0Var);
    }

    public static final void C(String str, h hVar) {
        ImageView.ScaleType scaleType;
        m.f(hVar, "viewManager");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str.equals("contain")) {
                        scaleType = ImageView.ScaleType.FIT_CENTER;
                        hVar.o(scaleType);
                    }
                } else if (str.equals("cover")) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                    hVar.o(scaleType);
                }
            } else if (str.equals("center")) {
                scaleType = ImageView.ScaleType.CENTER_INSIDE;
                hVar.o(scaleType);
            }
        }
        scaleType = null;
        hVar.o(scaleType);
    }

    public static final void D(String str, h hVar) {
        m.f(hVar, "viewManager");
        hVar.p(str);
        hVar.a();
    }

    public static final void E(String str, h hVar) {
        m.f(hVar, "viewManager");
        hVar.c(str);
        hVar.a();
    }

    public static final void F(String str, h hVar) {
        m.f(hVar, "viewManager");
        if (str != null && !j.K(str, f.G, false, 2, (Object) null)) {
            str = str + ".json";
        }
        hVar.d(str);
        hVar.a();
    }

    public static final void G(String str, h hVar) {
        m.f(hVar, "viewManager");
        hVar.e(str);
        hVar.a();
    }

    public static final void H(double d10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.q(Float.valueOf((float) d10));
    }

    public static final void I(ReadableArray readableArray, h hVar) {
        m.f(hVar, "viewManager");
        hVar.r(readableArray);
    }

    public static final LottieAnimationView e(e1 e1Var) {
        m.f(e1Var, "context");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(e1Var);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return lottieAnimationView;
    }

    public static final Map f() {
        Map f10 = e6.f.f("topAnimationFinish", e6.f.d("registrationName", "onAnimationFinish"), "topAnimationFailure", e6.f.d("registrationName", "onAnimationFailure"), "topAnimationLoaded", e6.f.d("registrationName", "onAnimationLoaded"));
        m.e(f10, "of(...)");
        return f10;
    }

    public static final Map g() {
        Map a10 = e6.f.a().b("VERSION", 1).a();
        m.e(a10, "build(...)");
        return a10;
    }

    public static final void h(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new f(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void i(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.u();
        }
    }

    public static final void j(LottieAnimationView lottieAnimationView, int i10, int i11) {
        boolean z10;
        m.f(lottieAnimationView, "view");
        if (i10 == -1 || i11 == -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        new Handler(Looper.getMainLooper()).post(new e(z10, i10, i11, lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void k(boolean z10, int i10, int i11, LottieAnimationView lottieAnimationView) {
        Integer num;
        m.f(lottieAnimationView, "$view");
        if (!z10) {
            com.airbnb.lottie.j composition = lottieAnimationView.getComposition();
            Integer num2 = null;
            if (composition != null) {
                num = Integer.valueOf((int) composition.p());
            } else {
                num = null;
            }
            com.airbnb.lottie.j composition2 = lottieAnimationView.getComposition();
            if (composition2 != null) {
                num2 = Integer.valueOf((int) composition2.f());
            }
            int minFrame = (int) lottieAnimationView.getMinFrame();
            int maxFrame = (int) lottieAnimationView.getMaxFrame();
            if (!(num == null || num2 == null || (minFrame == num.intValue() && maxFrame == num2.intValue()))) {
                lottieAnimationView.D(num.intValue(), num2.intValue());
            }
        } else if (i10 > i11) {
            lottieAnimationView.D(i11, i10);
            if (lottieAnimationView.getSpeed() > 0.0f) {
                lottieAnimationView.x();
            }
        } else {
            lottieAnimationView.D(i10, i11);
            if (lottieAnimationView.getSpeed() < 0.0f) {
                lottieAnimationView.x();
            }
        }
        if (!ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.addOnAttachStateChangeListener(new a(z10, lottieAnimationView));
        } else if (z10) {
            lottieAnimationView.v();
        } else {
            lottieAnimationView.w();
        }
    }

    public static final void l(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new c(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void m(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.j();
            lottieAnimationView.setProgress(0.0f);
        }
    }

    public static final void n(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        new Handler(Looper.getMainLooper()).post(new d(lottieAnimationView));
    }

    /* access modifiers changed from: private */
    public static final void o(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "$view");
        if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
            lottieAnimationView.w();
        }
    }

    public static final void p(LottieAnimationView lottieAnimationView, Throwable th) {
        m.f(lottieAnimationView, "view");
        m.f(th, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Context context = lottieAnimationView.getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        e1 e1Var = (e1) context;
        e c10 = k1.c(e1Var, lottieAnimationView.getId());
        if (c10 != null) {
            c10.c(new j(e1Var.c(), lottieAnimationView.getId(), th));
        }
    }

    public static final void q(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        Context context = lottieAnimationView.getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        e1 e1Var = (e1) context;
        e c10 = k1.c(e1Var, lottieAnimationView.getId());
        if (c10 != null) {
            c10.c(new l(e1Var.c(), lottieAnimationView.getId()));
        }
    }

    public static final void r(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        Context context = lottieAnimationView.getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        e1 e1Var = (e1) context;
        e c10 = k1.c(e1Var, lottieAnimationView.getId());
        if (c10 != null) {
            c10.c(new k(e1Var.c(), lottieAnimationView.getId(), z10));
        }
    }

    public static final void s(boolean z10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.f(Boolean.valueOf(z10));
    }

    public static final void t(LottieAnimationView lottieAnimationView, boolean z10) {
        m.f(lottieAnimationView, "view");
        lottieAnimationView.setCacheComposition(z10);
    }

    public static final void u(ReadableArray readableArray, h hVar) {
        m.f(hVar, "viewManager");
        hVar.g(readableArray);
    }

    public static final void v(boolean z10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.h(Boolean.valueOf(z10));
    }

    public static final void w(boolean z10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.i(Boolean.valueOf(z10));
    }

    public static final void x(boolean z10, h hVar) {
        m.f(hVar, "viewManager");
        int i10 = 1;
        if (z10) {
            i10 = 2;
        }
        hVar.k(i10);
    }

    public static final void y(String str, h hVar) {
        m.f(hVar, "viewManager");
        hVar.j(str);
    }

    public static final void z(boolean z10, h hVar) {
        m.f(hVar, "viewManager");
        hVar.l(Boolean.valueOf(z10));
    }
}
