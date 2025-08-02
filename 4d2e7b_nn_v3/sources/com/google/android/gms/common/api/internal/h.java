package com.google.android.gms.common.api.internal;

final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaw f6697a;

    h(zaaw zaaw) {
        this.f6697a = zaaw;
    }

    public final void run() {
        zaaw zaaw = this.f6697a;
        zaaw.zad.cancelAvailabilityErrorNotifications(zaaw.zac);
    }
}
