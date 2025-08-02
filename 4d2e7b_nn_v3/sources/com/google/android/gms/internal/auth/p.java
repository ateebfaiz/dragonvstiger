package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

final class p extends zzbd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f6977a;

    p(q qVar) {
        this.f6977a = qVar;
    }

    public final void zzb(ProxyResponse proxyResponse) {
        this.f6977a.setResult(new t(proxyResponse));
    }
}
