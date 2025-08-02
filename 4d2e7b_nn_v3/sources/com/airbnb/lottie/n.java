package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f17721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17723c;

    public /* synthetic */ n(Context context, String str, String str2) {
        this.f17721a = context;
        this.f17722b = str;
        this.f17723c = str2;
    }

    public final Object call() {
        return t.o(this.f17721a, this.f17722b, this.f17723c);
    }
}
