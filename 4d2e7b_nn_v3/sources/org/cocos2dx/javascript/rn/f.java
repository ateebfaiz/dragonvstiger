package org.cocos2dx.javascript.rn;

import android.app.Activity;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1490b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f1491c;

    public /* synthetic */ f(String str, String str2, Activity activity) {
        this.f1489a = str;
        this.f1490b = str2;
        this.f1491c = activity;
    }

    public final void run() {
        ShareUtils.lambda$contactQQ$1(this.f1489a, this.f1490b, this.f1491c);
    }
}
