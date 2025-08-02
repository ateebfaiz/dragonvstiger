package org.cocos2dx.javascript;

import com.facebook.react.bridge.Callback;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1473a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1474b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f1475c;

    public /* synthetic */ p(String str, String str2, Callback callback) {
        this.f1473a = str;
        this.f1474b = str2;
        this.f1475c = callback;
    }

    public final void run() {
        HCaptchaManager.INSTANCE.start(PlatformUtils.mActivity, this.f1473a, this.f1474b, new q(this.f1475c));
    }
}
