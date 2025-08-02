package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

final class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f6745a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f6746b;

    u0(ConnectionResult connectionResult, int i10) {
        Preconditions.checkNotNull(connectionResult);
        this.f6746b = connectionResult;
        this.f6745a = i10;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f6745a;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.f6746b;
    }
}
