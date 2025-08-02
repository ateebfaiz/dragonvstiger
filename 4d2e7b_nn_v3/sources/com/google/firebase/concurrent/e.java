package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f9031a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f9032b;

    public /* synthetic */ e(Runnable runnable, p.b bVar) {
        this.f9031a = runnable;
        this.f9032b = bVar;
    }

    public final void run() {
        o.z(this.f9031a, this.f9032b);
    }
}
