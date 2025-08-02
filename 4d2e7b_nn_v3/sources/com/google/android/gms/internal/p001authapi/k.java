package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.k  reason: invalid package */
final class k extends zbd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f6881a;

    k(l lVar) {
        this.f6881a = lVar;
    }

    public final void zbb(Status status, Credential credential) {
        this.f6881a.setResult(new zbe(status, credential));
    }

    public final void zbc(Status status) {
        this.f6881a.setResult(new zbe(status, (Credential) null));
    }
}
