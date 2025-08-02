package com.hcaptcha.sdk;

import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.i;
import com.fasterxml.jackson.databind.s;
import java.io.Serializable;
import java.util.Objects;

class q implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final transient Handler f9557a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9558b;

    /* renamed from: c  reason: collision with root package name */
    private final transient w f9559c;

    public q(Handler handler, HCaptchaConfig hCaptchaConfig, w wVar) {
        String str;
        if (handler == null) {
            throw new NullPointerException("handler is marked non-null but is null");
        } else if (hCaptchaConfig == null) {
            throw new NullPointerException("config is marked non-null but is null");
        } else if (wVar != null) {
            this.f9557a = handler;
            this.f9559c = wVar;
            try {
                str = new s().j(hCaptchaConfig);
            } catch (i unused) {
                Log.w("JSInterface", "Cannot prepare config for passing to WebView. A fallback config will be used");
                str = null;
            }
            this.f9558b = str;
        } else {
            throw new NullPointerException("captchaVerifier is marked non-null but is null");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(h hVar) {
        this.f9559c.f(new i(hVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(String str) {
        this.f9559c.onSuccess(str);
    }

    @JavascriptInterface
    @Nullable
    public String getConfig() {
        return this.f9558b;
    }

    @JavascriptInterface
    public void onError(int i10) {
        this.f9557a.post(new n(this, h.b(i10)));
    }

    @JavascriptInterface
    public void onLoaded() {
        Handler handler = this.f9557a;
        w wVar = this.f9559c;
        Objects.requireNonNull(wVar);
        handler.post(new p(wVar));
    }

    @JavascriptInterface
    public void onOpen() {
        Handler handler = this.f9557a;
        w wVar = this.f9559c;
        Objects.requireNonNull(wVar);
        handler.post(new o(wVar));
    }

    @JavascriptInterface
    public void onPass(String str) {
        this.f9557a.post(new m(this, str));
    }
}
