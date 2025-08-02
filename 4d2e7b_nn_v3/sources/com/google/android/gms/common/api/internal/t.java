package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class t implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f6736a;

    t(zabe zabe, StatusPendingResult statusPendingResult) {
        this.f6736a = statusPendingResult;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f6736a.setResult(new Status(8));
    }
}
