package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class c implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9112a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9113b;

    public /* synthetic */ c(Context context, String str) {
        this.f9112a = context;
        this.f9113b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.f9112a, this.f9113b);
    }
}
