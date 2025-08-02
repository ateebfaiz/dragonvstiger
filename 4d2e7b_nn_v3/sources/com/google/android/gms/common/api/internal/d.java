package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class d implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6677a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f6678b;

    d(zaad zaad, TaskCompletionSource taskCompletionSource) {
        this.f6678b = zaad;
        this.f6677a = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.f6678b.zab.remove(this.f6677a);
    }
}
