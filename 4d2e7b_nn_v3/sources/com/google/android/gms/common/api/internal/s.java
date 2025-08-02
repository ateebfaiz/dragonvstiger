package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

final class s implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f6732a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f6733b;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zabe f6734e;

    s(zabe zabe, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.f6734e = zabe;
        this.f6732a = atomicReference;
        this.f6733b = statusPendingResult;
    }

    public final void onConnected(Bundle bundle) {
        this.f6734e.zam((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.f6732a.get()), this.f6733b, true);
    }

    public final void onConnectionSuspended(int i10) {
    }
}
