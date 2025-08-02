package com.geetest.captcha;

import com.geetest.captcha.GTCaptcha4Client;

/* renamed from: com.geetest.captcha.r  reason: case insensitive filesystem */
public final class C0364r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f5858a;

    public C0364r(p pVar) {
        this.f5858a = pVar;
    }

    public final void run() {
        GTCaptcha4Client.OnWebViewShowListener onWebViewShowListener = this.f5858a.f5850f;
        if (onWebViewShowListener != null) {
            onWebViewShowListener.onWebViewShow();
        }
    }
}
