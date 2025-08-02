package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class z0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f9324a;

    public /* synthetic */ z0(ScheduledFuture scheduledFuture) {
        this.f9324a = scheduledFuture;
    }

    public final void onComplete(Task task) {
        this.f9324a.cancel(false);
    }
}
