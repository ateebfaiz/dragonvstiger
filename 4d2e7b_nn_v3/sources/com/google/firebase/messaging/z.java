package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class z implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f9323a;

    public /* synthetic */ z(a0 a0Var) {
        this.f9323a = a0Var;
    }

    public final Object then(Task task) {
        return this.f9323a.i(task);
    }
}
