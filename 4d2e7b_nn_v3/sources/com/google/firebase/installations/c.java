package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class c implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f9131a;

    public /* synthetic */ c(FirebaseApp firebaseApp) {
        this.f9131a = firebaseApp;
    }

    public final Object get() {
        return FirebaseInstallations.lambda$new$0(this.f9131a);
    }
}
