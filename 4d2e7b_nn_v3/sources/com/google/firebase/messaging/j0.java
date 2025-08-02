package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class j0 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k0 f9243a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9244b;

    public /* synthetic */ j0(k0 k0Var, String str) {
        this.f9243a = k0Var;
        this.f9244b = str;
    }

    public final Object then(Task task) {
        return this.f9243a.c(this.f9244b, task);
    }
}
