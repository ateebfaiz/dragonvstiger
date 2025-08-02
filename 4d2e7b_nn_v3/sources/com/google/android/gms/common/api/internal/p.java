package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

final class p implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f6726a;

    /* synthetic */ p(zaaw zaaw, zaas zaas) {
        this.f6726a = zaaw;
    }

    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings = (ClientSettings) Preconditions.checkNotNull(this.f6726a.zar);
        ((zae) Preconditions.checkNotNull(this.f6726a.zak)).zad(new o(this.f6726a));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f6726a.zab.lock();
        try {
            if (this.f6726a.zaI(connectionResult)) {
                this.f6726a.zaA();
                this.f6726a.zaF();
            } else {
                this.f6726a.zaD(connectionResult);
            }
        } finally {
            this.f6726a.zab.unlock();
        }
    }

    public final void onConnectionSuspended(int i10) {
    }
}
