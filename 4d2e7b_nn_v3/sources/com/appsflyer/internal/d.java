package com.appsflyer.internal;

import android.app.Activity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFb1fSDK f18352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f18353b;

    public /* synthetic */ d(AFb1fSDK aFb1fSDK, Activity activity) {
        this.f18352a = aFb1fSDK;
        this.f18353b = activity;
    }

    public final void run() {
        AFb1fSDK.values(this.f18352a, this.f18353b);
    }
}
