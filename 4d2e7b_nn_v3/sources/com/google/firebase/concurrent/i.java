package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9047a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f9049c;

    public /* synthetic */ i(o oVar, Runnable runnable, p.b bVar) {
        this.f9047a = oVar;
        this.f9048b = runnable;
        this.f9049c = bVar;
    }

    public final void run() {
        this.f9047a.u(this.f9048b, this.f9049c);
    }
}
