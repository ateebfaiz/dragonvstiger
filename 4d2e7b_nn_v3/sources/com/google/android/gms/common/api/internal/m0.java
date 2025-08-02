package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

final class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zak f6720a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zact f6721b;

    m0(zact zact, zak zak) {
        this.f6721b = zact;
        this.f6720a = zak;
    }

    public final void run() {
        zact.zad(this.f6721b, this.f6720a);
    }
}
