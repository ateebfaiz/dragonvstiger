package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.n  reason: invalid package */
final class n extends q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Credential f6884a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(zbl zbl, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.f6884a = credential;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, zbt zbt) {
        zbt.zbc(new p(this), new zbp(this.f6884a));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
