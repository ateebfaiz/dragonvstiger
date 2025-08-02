package com.bugsnag.android;

import java.util.concurrent.Callable;

public final /* synthetic */ class w1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y1 f19090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f19091b;

    public /* synthetic */ w1(y1 y1Var, String str) {
        this.f19090a = y1Var;
        this.f19091b = str;
    }

    public final Object call() {
        return y1.K(this.f19090a, this.f19091b);
    }
}
