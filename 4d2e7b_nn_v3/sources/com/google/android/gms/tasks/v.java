package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class v implements OnSuccessListener, OnFailureListener, OnCanceledListener, w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7880a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final SuccessContinuation f7881b;

    /* renamed from: c  reason: collision with root package name */
    private final c0 f7882c;

    public v(Executor executor, SuccessContinuation successContinuation, c0 c0Var) {
        this.f7880a = executor;
        this.f7881b = successContinuation;
        this.f7882c = c0Var;
    }

    public final void a(Task task) {
        this.f7880a.execute(new u(this, task));
    }

    public final void onCanceled() {
        this.f7882c.c();
    }

    public final void onFailure(Exception exc) {
        this.f7882c.a(exc);
    }

    public final void onSuccess(Object obj) {
        this.f7882c.b(obj);
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
