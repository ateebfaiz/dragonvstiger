package org.cocos2dx.javascript;

import com.hcaptcha.sdk.i;
import f9.a;
import org.cocos2dx.javascript.HCaptchaManager;

public final /* synthetic */ class g implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HCaptchaManager.HCaptchaCallback f1467a;

    public /* synthetic */ g(HCaptchaManager.HCaptchaCallback hCaptchaCallback) {
        this.f1467a = hCaptchaCallback;
    }

    public final void f(i iVar) {
        HCaptchaManager.start$lambda$1(this.f1467a, iVar);
    }
}
