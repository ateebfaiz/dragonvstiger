package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

final class d implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConnectionCallbacks f6786a;

    d(ConnectionCallbacks connectionCallbacks) {
        this.f6786a = connectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        this.f6786a.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i10) {
        this.f6786a.onConnectionSuspended(i10);
    }
}
