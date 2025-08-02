package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class t0 implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f6737a;

    /* renamed from: b  reason: collision with root package name */
    public final GoogleApiClient f6738b;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleApiClient.OnConnectionFailedListener f6739e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zak f6740f;

    public t0(zak zak, int i10, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6740f = zak;
        this.f6737a = i10;
        this.f6738b = googleApiClient;
        this.f6739e = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.f6740f.zah(connectionResult, this.f6737a);
    }
}
