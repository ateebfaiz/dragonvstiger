package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Callable f9061a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p.b f9062b;

    public /* synthetic */ n(Callable callable, p.b bVar) {
        this.f9061a = callable;
        this.f9062b = bVar;
    }

    public final void run() {
        o.q(this.f9061a, this.f9062b);
    }
}
