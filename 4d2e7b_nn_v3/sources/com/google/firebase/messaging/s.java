package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9286a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9287b;

    public /* synthetic */ s(FirebaseMessaging firebaseMessaging, TaskCompletionSource taskCompletionSource) {
        this.f9286a = firebaseMessaging;
        this.f9287b = taskCompletionSource;
    }

    public final void run() {
        this.f9286a.lambda$getToken$4(this.f9287b);
    }
}
