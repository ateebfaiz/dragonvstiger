package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.n0;

public final /* synthetic */ class m implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f9250a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n0.a f9252c;

    public /* synthetic */ m(FirebaseMessaging firebaseMessaging, String str, n0.a aVar) {
        this.f9250a = firebaseMessaging;
        this.f9251b = str;
        this.f9252c = aVar;
    }

    public final Task then(Object obj) {
        return this.f9250a.lambda$blockingGetToken$9(this.f9251b, this.f9252c, (String) obj);
    }
}
