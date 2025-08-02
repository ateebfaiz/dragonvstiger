package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.m  reason: invalid package */
final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Credential f6883a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(zbl zbl, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.f6883a = credential;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, zbt zbt) {
        zbt.zbe(new p(this), new zbu(this.f6883a));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
