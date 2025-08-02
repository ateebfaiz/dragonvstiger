package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f9224a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f9225b;

    public /* synthetic */ d(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f9224a = enhancedIntentService;
        this.f9225b = intent;
    }

    public final void onComplete(Task task) {
        this.f9224a.lambda$onStartCommand$1(this.f9225b, task);
    }
}
