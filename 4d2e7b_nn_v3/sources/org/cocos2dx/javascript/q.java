package org.cocos2dx.javascript;

import com.facebook.react.bridge.Callback;
import org.cocos2dx.javascript.HCaptchaManager;

public final /* synthetic */ class q implements HCaptchaManager.HCaptchaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callback f1476a;

    public /* synthetic */ q(Callback callback) {
        this.f1476a = callback;
    }

    public final void result(boolean z10, String str) {
        PlatformUtils.lambda$startHCaptcha$6(this.f1476a, z10, str);
    }
}
