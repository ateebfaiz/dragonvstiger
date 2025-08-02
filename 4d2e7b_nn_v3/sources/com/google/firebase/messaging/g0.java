package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9236a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f9237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9238c;

    public /* synthetic */ g0(Context context, boolean z10, TaskCompletionSource taskCompletionSource) {
        this.f9236a = context;
        this.f9237b = z10;
        this.f9238c = taskCompletionSource;
    }

    public final void run() {
        h0.e(this.f9236a, this.f9237b, this.f9238c);
    }
}
