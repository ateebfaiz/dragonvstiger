package org.cocos2dx.javascript;

import com.hcaptcha.sdk.s;
import f9.d;
import org.cocos2dx.javascript.HCaptchaManager;

public final /* synthetic */ class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HCaptchaManager.HCaptchaCallback f1466a;

    public /* synthetic */ f(HCaptchaManager.HCaptchaCallback hCaptchaCallback) {
        this.f1466a = hCaptchaCallback;
    }

    public final void onSuccess(Object obj) {
        HCaptchaManager.start$lambda$0(this.f1466a, (s) obj);
    }
}
