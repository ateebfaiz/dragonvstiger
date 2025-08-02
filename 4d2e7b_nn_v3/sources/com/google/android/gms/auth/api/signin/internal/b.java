package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class b extends g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6628a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ GoogleSignInOptions f6629b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        super(googleApiClient);
        this.f6628a = context;
        this.f6629b = googleSignInOptions;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult((GoogleSignInAccount) null, status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zbs) ((zbe) anyClient).getService()).zbe(new a(this), this.f6629b);
    }
}
