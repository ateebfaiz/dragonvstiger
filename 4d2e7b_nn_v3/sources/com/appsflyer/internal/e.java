package com.appsflyer.internal;

import android.app.Activity;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFb1fSDK f18354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f18355b;

    public /* synthetic */ e(AFb1fSDK aFb1fSDK, Activity activity) {
        this.f18354a = aFb1fSDK;
        this.f18355b = activity;
    }

    public final void run() {
        AFb1fSDK.AFKeystoreWrapper(this.f18354a, this.f18355b);
    }
}
