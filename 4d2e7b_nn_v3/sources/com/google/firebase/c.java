package com.google.firebase;

import com.google.firebase.FirebaseApp;

public final /* synthetic */ class c implements FirebaseApp.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f8973a;

    public /* synthetic */ c(FirebaseApp firebaseApp) {
        this.f8973a = firebaseApp;
    }

    public final void onBackgroundStateChanged(boolean z10) {
        this.f8973a.lambda$new$1(z10);
    }
}
