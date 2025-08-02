package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class d extends g {
    d(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zbe zbe = (zbe) anyClient;
        ((zbs) zbe.getService()).zbd(new c(this), zbe.zba());
    }
}
