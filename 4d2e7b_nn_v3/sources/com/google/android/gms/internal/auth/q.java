package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class q extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProxyRequest f6988a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    q(zzbt zzbt, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.f6988a = proxyRequest;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, zzbh zzbh) {
        zzbh.zze(new p(this), this.f6988a);
    }
}
