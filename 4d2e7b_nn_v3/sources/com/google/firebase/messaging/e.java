package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f9231a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f9232b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9233c;

    public /* synthetic */ e(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f9231a = enhancedIntentService;
        this.f9232b = intent;
        this.f9233c = taskCompletionSource;
    }

    public final void run() {
        this.f9231a.lambda$processIntent$0(this.f9232b, this.f9233c);
    }
}
