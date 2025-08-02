package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zact f6717a;

    l0(zact zact) {
        this.f6717a = zact;
    }

    public final void run() {
        this.f6717a.zah.zae(new ConnectionResult(4));
    }
}
