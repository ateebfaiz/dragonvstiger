package com.appsflyer.internal;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFc1qSDK f18366a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f18367b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f18368c;

    public /* synthetic */ m(AFc1qSDK aFc1qSDK, Throwable th, String str) {
        this.f18366a = aFc1qSDK;
        this.f18367b = th;
        this.f18368c = str;
    }

    public final void run() {
        AFc1qSDK.AFInAppEventParameterName(this.f18366a, this.f18367b, this.f18368c);
    }
}
