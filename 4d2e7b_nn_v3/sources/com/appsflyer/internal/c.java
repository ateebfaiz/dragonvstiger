package com.appsflyer.internal;

import android.app.Activity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFb1fSDK f18350a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f18351b;

    public /* synthetic */ c(AFb1fSDK aFb1fSDK, Activity activity) {
        this.f18350a = aFb1fSDK;
        this.f18351b = activity;
    }

    public final void run() {
        AFb1fSDK.AFInAppEventType(this.f18350a, this.f18351b);
    }
}
