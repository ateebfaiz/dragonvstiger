package com.appsflyer.internal;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.appsflyer.internal.AFf1pSDK;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFf1pSDK.AnonymousClass1 f18370a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallReferrerClient f18371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f18372c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f18373d;

    public /* synthetic */ q(AFf1pSDK.AnonymousClass1 r12, InstallReferrerClient installReferrerClient, Context context, int i10) {
        this.f18370a = r12;
        this.f18371b = installReferrerClient;
        this.f18372c = context;
        this.f18373d = i10;
    }

    public final void run() {
        this.f18370a.lambda$onInstallReferrerSetupFinished$0(this.f18371b, this.f18372c, this.f18373d);
    }
}
