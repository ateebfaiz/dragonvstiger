package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f9059a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f9060b;

    public /* synthetic */ m(Runnable runnable, p.b bVar) {
        this.f9059a = runnable;
        this.f9060b = bVar;
    }

    public final void run() {
        o.n(this.f9059a, this.f9060b);
    }
}
