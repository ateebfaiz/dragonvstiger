package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class o implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f17730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZipInputStream f17731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17732c;

    public /* synthetic */ o(Context context, ZipInputStream zipInputStream, String str) {
        this.f17730a = context;
        this.f17731b = zipInputStream;
        this.f17732c = str;
    }

    public final Object call() {
        return t.E(this.f17730a, this.f17731b, this.f17732c);
    }
}
