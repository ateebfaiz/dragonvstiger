package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f9235b;

    public /* synthetic */ g(Context context, Intent intent) {
        this.f9234a = context;
        this.f9235b = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f9234a, this.f9235b));
    }
}
