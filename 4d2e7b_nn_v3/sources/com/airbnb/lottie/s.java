package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final /* synthetic */ class s implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WeakReference f17764a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f17765b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17766c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f17767d;

    public /* synthetic */ s(WeakReference weakReference, Context context, int i10, String str) {
        this.f17764a = weakReference;
        this.f17765b = context;
        this.f17766c = i10;
        this.f17767d = str;
    }

    public final Object call() {
        return t.P(this.f17764a, this.f17765b, this.f17766c, this.f17767d);
    }
}
