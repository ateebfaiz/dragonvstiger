package com.hcaptcha.sdk;

import android.net.Uri;
import com.hcaptcha.sdk.HCaptchaWebViewHelper;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HCaptchaWebViewHelper.b f9563a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f9564b;

    public /* synthetic */ t(HCaptchaWebViewHelper.b bVar, Uri uri) {
        this.f9563a = bVar;
        this.f9564b = uri;
    }

    public final void run() {
        this.f9563a.b(this.f9564b);
    }
}
