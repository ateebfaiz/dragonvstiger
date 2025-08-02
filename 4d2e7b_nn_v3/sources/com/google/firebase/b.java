package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f8971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f8972b;

    public /* synthetic */ b(FirebaseApp firebaseApp, Context context) {
        this.f8971a = firebaseApp;
        this.f8972b = context;
    }

    public final Object get() {
        return this.f8971a.lambda$new$0(this.f8972b);
    }
}
