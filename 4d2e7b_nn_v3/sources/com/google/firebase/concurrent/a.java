package com.google.firebase.concurrent;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9018a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f9019b;

    public /* synthetic */ a(b bVar, Runnable runnable) {
        this.f9018a = bVar;
        this.f9019b = runnable;
    }

    public final void run() {
        this.f9018a.b(this.f9019b);
    }
}
