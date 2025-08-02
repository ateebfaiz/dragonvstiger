package org.cocos2dx.javascript;

import android.app.Activity;
import android.util.Log;
import com.hcaptcha.sdk.HCaptcha;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.i;
import com.hcaptcha.sdk.s;
import kotlin.jvm.internal.m;

public final class HCaptchaManager {
    public static final HCaptchaManager INSTANCE = new HCaptchaManager();
    private static final String TAG = "HCaptchaManager";
    private static HCaptcha mHCaptcha;

    public interface HCaptchaCallback {
        void result(boolean z10, String str);
    }

    private HCaptchaManager() {
    }

    private final HCaptchaConfig getConfig(String str, String str2) {
        HCaptchaConfig c10 = HCaptchaConfig.builder().t(str).m(str2).l(Boolean.FALSE).c();
        m.e(c10, "build(...)");
        return c10;
    }

    /* access modifiers changed from: private */
    public static final void start$lambda$0(HCaptchaCallback hCaptchaCallback, s sVar) {
        m.f(hCaptchaCallback, "$callback");
        m.f(sVar, "response");
        String a10 = sVar.a();
        m.e(a10, "getTokenResult(...)");
        hCaptchaCallback.result(true, a10);
    }

    /* access modifiers changed from: private */
    public static final void start$lambda$1(HCaptchaCallback hCaptchaCallback, i iVar) {
        m.f(hCaptchaCallback, "$callback");
        m.f(iVar, "e");
        Log.i(TAG, "startHCaptcha：" + iVar);
        if (iVar.b().c() == 30) {
            String message = iVar.getMessage();
            if (message == null) {
                message = "";
            }
            hCaptchaCallback.result(false, message);
        }
    }

    /* access modifiers changed from: private */
    public static final void start$lambda$2() {
    }

    public final void start(Activity activity, String str, String str2, HCaptchaCallback hCaptchaCallback) {
        m.f(activity, "activity");
        m.f(str, "siteKey");
        m.f(str2, "language");
        m.f(hCaptchaCallback, "callback");
        Log.i(TAG, "language:" + str2);
        if (mHCaptcha == null) {
            mHCaptcha = HCaptcha.t(activity);
        }
        HCaptcha hCaptcha = mHCaptcha;
        m.c(hCaptcha);
        hCaptcha.h();
        HCaptcha hCaptcha2 = mHCaptcha;
        m.c(hCaptcha2);
        hCaptcha2.d(new f(hCaptchaCallback)).b(new g(hCaptchaCallback)).c(new h());
        HCaptcha hCaptcha3 = mHCaptcha;
        m.c(hCaptcha3);
        hCaptcha3.w(getConfig(str, str2));
    }
}
