package com.google.firebase.messaging;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

public final /* synthetic */ class n implements FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9259a;

    public /* synthetic */ n(FirebaseMessaging firebaseMessaging) {
        this.f9259a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.f9259a.lambda$new$0(str);
    }
}
