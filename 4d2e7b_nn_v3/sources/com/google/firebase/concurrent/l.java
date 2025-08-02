package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9056a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f9058c;

    public /* synthetic */ l(o oVar, Runnable runnable, p.b bVar) {
        this.f9056a = oVar;
        this.f9057b = runnable;
        this.f9058c = bVar;
    }

    public final void run() {
        this.f9056a.w(this.f9057b, this.f9058c);
    }
}
