package com.google.firebase.installations;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f9135a;

    public /* synthetic */ f(FirebaseInstallations firebaseInstallations) {
        this.f9135a = firebaseInstallations;
    }

    public final Object call() {
        return this.f9135a.deleteFirebaseInstallationId();
    }
}
