package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f9052c;

    public /* synthetic */ j(o oVar, Runnable runnable, p.b bVar) {
        this.f9050a = oVar;
        this.f9051b = runnable;
        this.f9052c = bVar;
    }

    public final void run() {
        this.f9050a.o(this.f9051b, this.f9052c);
    }
}
