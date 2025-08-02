package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class i implements w {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7851a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Continuation f7852b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c0 f7853c;

    public i(Executor executor, Continuation continuation, c0 c0Var) {
        this.f7851a = executor;
        this.f7852b = continuation;
        this.f7853c = c0Var;
    }

    public final void a(Task task) {
        this.f7851a.execute(new h(this, task));
    }

    public final void zzc() {
        throw new UnsupportedOperationException();
    }
}
