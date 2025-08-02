package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f20759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ y[] f20760b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f20761c;

    public /* synthetic */ d0(g0 g0Var, y[] yVarArr, ReactApplicationContext reactApplicationContext) {
        this.f20759a = g0Var;
        this.f20760b = yVarArr;
        this.f20761c = reactApplicationContext;
    }

    public final void run() {
        this.f20759a.P(this.f20760b, this.f20761c);
    }
}
