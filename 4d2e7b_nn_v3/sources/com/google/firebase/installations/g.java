package com.google.firebase.installations;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f9136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f9137b;

    public /* synthetic */ g(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f9136a = firebaseInstallations;
        this.f9137b = z10;
    }

    public final void run() {
        this.f9136a.lambda$getToken$2(this.f9137b);
    }
}
