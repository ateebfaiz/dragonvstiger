package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

final class d0 implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabq f6679a;

    d0(zabq zabq) {
        this.f6679a = zabq;
    }

    public final void onSignOutComplete() {
        this.f6679a.zaa.zat.post(new c0(this));
    }
}
