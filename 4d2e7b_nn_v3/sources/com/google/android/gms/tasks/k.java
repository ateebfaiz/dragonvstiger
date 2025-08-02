package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class k implements OnSuccessListener, OnFailureListener, OnCanceledListener, w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7856a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Continuation f7857b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c0 f7858c;

    public k(Executor executor, Continuation continuation, c0 c0Var) {
        this.f7856a = executor;
        this.f7857b = continuation;
        this.f7858c = c0Var;
    }

    public final void a(Task task) {
        this.f7856a.execute(new j(this, task));
    }

    public final void onCanceled() {
        this.f7858c.c();
    }

    public final void onFailure(Exception exc) {
        this.f7858c.a(exc);
    }

    public final void onSuccess(Object obj) {
        this.f7858c.b(obj);
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
