package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageDownload f9219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9220b;

    public /* synthetic */ b0(ImageDownload imageDownload, TaskCompletionSource taskCompletionSource) {
        this.f9219a = imageDownload;
        this.f9220b = taskCompletionSource;
    }

    public final void run() {
        this.f9219a.lambda$start$0(this.f9220b);
    }
}
