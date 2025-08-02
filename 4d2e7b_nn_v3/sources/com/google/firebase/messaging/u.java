package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.k0;
import com.google.firebase.messaging.n0;

public final /* synthetic */ class u implements k0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9308a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9309b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n0.a f9310c;

    public /* synthetic */ u(FirebaseMessaging firebaseMessaging, String str, n0.a aVar) {
        this.f9308a = firebaseMessaging;
        this.f9309b = str;
        this.f9310c = aVar;
    }

    public final Task start() {
        return this.f9308a.lambda$blockingGetToken$10(this.f9309b, this.f9310c);
    }
}
