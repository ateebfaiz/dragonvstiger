package com.hcaptcha.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;

final class j implements w {

    /* renamed from: a  reason: collision with root package name */
    private final HCaptchaConfig f9542a;

    /* renamed from: b  reason: collision with root package name */
    private final HCaptchaStateListener f9543b;

    /* renamed from: c  reason: collision with root package name */
    private final HCaptchaWebViewHelper f9544c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9545d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9546e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9547f;

    public j(Activity activity, HCaptchaConfig hCaptchaConfig, l lVar, HCaptchaStateListener hCaptchaStateListener) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        } else if (hCaptchaConfig == null) {
            throw new NullPointerException("config is marked non-null but is null");
        } else if (lVar == null) {
            throw new NullPointerException("internalConfig is marked non-null but is null");
        } else if (hCaptchaStateListener != null) {
            this.f9542a = hCaptchaConfig;
            this.f9543b = hCaptchaStateListener;
            HCaptchaWebView hCaptchaWebView = new HCaptchaWebView(activity);
            hCaptchaWebView.setId(x.f9566b);
            hCaptchaWebView.setVisibility(8);
            if (hCaptchaWebView.getParent() == null) {
                ((ViewGroup) activity.getWindow().getDecorView().getRootView()).addView(hCaptchaWebView);
            }
            this.f9544c = new HCaptchaWebViewHelper(new Handler(Looper.getMainLooper()), activity, hCaptchaConfig, lVar, this, hCaptchaWebView);
        } else {
            throw new NullPointerException("listener is marked non-null but is null");
        }
    }

    public void a() {
        this.f9543b.b();
    }

    /* renamed from: b */
    public void onSuccess(String str) {
        this.f9543b.c(str);
    }

    public void c() {
        if (this.f9545d) {
            this.f9544c.e();
            HCaptchaWebView d10 = this.f9544c.d();
            if (d10.getParent() != null) {
                ((ViewGroup) d10.getParent()).removeView(d10);
                return;
            }
            return;
        }
        this.f9547f = true;
    }

    public void f(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        } else if (this.f9544c.h(iVar)) {
            this.f9544c.f();
        } else {
            this.f9543b.a(iVar);
        }
    }

    public void h(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        } else if (this.f9545d) {
            this.f9544c.f();
        } else {
            this.f9546e = true;
        }
    }

    public void k() {
        this.f9545d = true;
        if (this.f9547f) {
            this.f9547f = false;
            c();
        } else if (this.f9546e) {
            this.f9546e = false;
            this.f9544c.f();
        }
    }
}
