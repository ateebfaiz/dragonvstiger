package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9312a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9313b;

    public /* synthetic */ v(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f9312a = firebaseMessaging;
        this.f9313b = taskCompletionSource;
    }

    public final void run() {
        this.f9312a.lambda$deleteToken$5(this.f9313b);
    }
}
