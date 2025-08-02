package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.l  reason: invalid package */
final class l extends q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CredentialRequest f6882a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(zbl zbl, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.f6882a = credentialRequest;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, zbt zbt) {
        zbt.zbd(new k(this), this.f6882a);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zbe(status, (Credential) null);
    }
}
