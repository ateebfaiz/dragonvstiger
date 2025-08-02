package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f9053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Callable f9054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p.b f9055c;

    public /* synthetic */ k(o oVar, Callable callable, p.b bVar) {
        this.f9053a = oVar;
        this.f9054b = callable;
        this.f9055c = bVar;
    }

    public final Object call() {
        return this.f9053a.r(this.f9054b, this.f9055c);
    }
}
