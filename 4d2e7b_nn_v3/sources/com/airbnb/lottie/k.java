package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f17676a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17677b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17678c;

    public /* synthetic */ k(Context context, String str, String str2) {
        this.f17676a = context;
        this.f17677b = str;
        this.f17678c = str2;
    }

    public final Object call() {
        return t.Q(this.f17676a, this.f17677b, this.f17678c);
    }
}
