package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class u0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f9311a;

    public /* synthetic */ u0(Intent intent) {
        this.f9311a = intent;
    }

    public final void onComplete(Task task) {
        v0.c(this.f9311a);
    }
}
