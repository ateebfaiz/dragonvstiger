package org.cocos2dx.javascript;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1495a;

    public /* synthetic */ u(String str) {
        this.f1495a = str;
    }

    public final void run() {
        CaptchaDialog.Companion.newInstance(this.f1495a).showUniqueDialog(PlatformUtils.mActivity.getSupportFragmentManager());
    }
}
