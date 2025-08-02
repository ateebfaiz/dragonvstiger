package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class b extends d {
    b(zae zae, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zal) ((zah) anyClient).getService()).zae(new c(this));
    }
}
