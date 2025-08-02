package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f9029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f9030b;

    public /* synthetic */ d(Runnable runnable, p.b bVar) {
        this.f9029a = runnable;
        this.f9030b = bVar;
    }

    public final void run() {
        o.t(this.f9029a, this.f9030b);
    }
}
