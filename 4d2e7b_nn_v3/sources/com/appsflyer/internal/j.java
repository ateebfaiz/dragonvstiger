package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFb1xSDK f18361a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f18362b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f18363c;

    public /* synthetic */ j(AFb1xSDK aFb1xSDK, Context context, Intent intent) {
        this.f18361a = aFb1xSDK;
        this.f18362b = context;
        this.f18363c = intent;
    }

    public final void run() {
        this.f18361a.AFKeystoreWrapper(this.f18362b, this.f18363c);
    }
}
