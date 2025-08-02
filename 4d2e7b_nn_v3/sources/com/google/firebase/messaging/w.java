package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9317a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9318b;

    public /* synthetic */ w(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f9317a = firebaseMessaging;
        this.f9318b = taskCompletionSource;
    }

    public final void run() {
        this.f9317a.lambda$deleteToken$6(this.f9318b);
    }
}
