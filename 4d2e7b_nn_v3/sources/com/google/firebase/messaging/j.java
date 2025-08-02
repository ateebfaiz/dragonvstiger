package com.google.firebase.messaging;

import android.content.Intent;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f9241a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f9242b;

    public /* synthetic */ j(k kVar, Intent intent) {
        this.f9241a = kVar;
        this.f9242b = intent;
    }

    public final void run() {
        this.f9241a.b(this.f9242b);
    }
}
