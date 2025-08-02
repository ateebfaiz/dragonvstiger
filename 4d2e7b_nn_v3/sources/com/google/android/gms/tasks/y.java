package com.google.android.gms.tasks;

final class y implements OnTokenCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f7886a;

    y(TaskCompletionSource taskCompletionSource) {
        this.f7886a = taskCompletionSource;
    }

    public final void onCanceled() {
        this.f7886a.zza.c();
    }
}
