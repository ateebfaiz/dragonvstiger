package com.facebook.react.modules.network;

import com.facebook.react.bridge.ReactApplicationContext;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class g implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NetworkingModule f3323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3324b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f3325c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f3326d;

    public /* synthetic */ g(NetworkingModule networkingModule, String str, ReactApplicationContext reactApplicationContext, int i10) {
        this.f3323a = networkingModule;
        this.f3324b = str;
        this.f3325c = reactApplicationContext;
        this.f3326d = i10;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return this.f3323a.lambda$sendRequestInternal$0(this.f3324b, this.f3325c, this.f3326d, chain);
    }
}
