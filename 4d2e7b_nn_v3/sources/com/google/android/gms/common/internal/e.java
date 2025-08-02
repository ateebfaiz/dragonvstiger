package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

final class e implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ OnConnectionFailedListener f6787a;

    e(OnConnectionFailedListener onConnectionFailedListener) {
        this.f6787a = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f6787a.onConnectionFailed(connectionResult);
    }
}
