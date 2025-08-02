package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9239a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f9240b;

    public /* synthetic */ h(Context context, Intent intent) {
        this.f9239a = context;
        this.f9240b = intent;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.f9239a, this.f9240b, task);
    }
}
