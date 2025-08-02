package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InputStream f17714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17715b;

    public /* synthetic */ l(InputStream inputStream, String str) {
        this.f17714a = inputStream;
        this.f17715b = str;
    }

    public final Object call() {
        return t.q(this.f17714a, this.f17715b);
    }
}
