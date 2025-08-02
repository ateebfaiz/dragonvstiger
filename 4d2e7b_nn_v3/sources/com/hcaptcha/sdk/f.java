package com.hcaptcha.sdk;

import android.view.KeyEvent;
import android.view.View;

public final /* synthetic */ class f implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f9519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HCaptchaConfig f9520b;

    public /* synthetic */ f(g gVar, HCaptchaConfig hCaptchaConfig) {
        this.f9519a = gVar;
        this.f9520b = hCaptchaConfig;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return this.f9519a.s(this.f9520b, view, i10, keyEvent);
    }
}
