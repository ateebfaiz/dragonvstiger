package com.google.android.gms.tasks;

final class g extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f7848a = new c0();

    g() {
    }

    public final void a() {
        this.f7848a.e((Object) null);
    }

    public final boolean isCancellationRequested() {
        return this.f7848a.isComplete();
    }

    public final CancellationToken onCanceledRequested(OnTokenCanceledListener onTokenCanceledListener) {
        this.f7848a.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener) new a(this, onTokenCanceledListener));
        return this;
    }
}
