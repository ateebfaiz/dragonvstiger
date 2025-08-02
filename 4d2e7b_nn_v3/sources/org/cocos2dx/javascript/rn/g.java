package org.cocos2dx.javascript.rn;

import android.app.Activity;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1492a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f1493b;

    public /* synthetic */ g(String str, Activity activity) {
        this.f1492a = str;
        this.f1493b = activity;
    }

    public final void run() {
        ShareUtils.lambda$sysShare$0(this.f1492a, this.f1493b);
    }
}
