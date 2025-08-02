package com.google.firebase.installations;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f9132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f9133b;

    public /* synthetic */ d(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f9132a = firebaseInstallations;
        this.f9133b = z10;
    }

    public final void run() {
        this.f9132a.lambda$doRegistrationOrRefresh$3(this.f9133b);
    }
}
