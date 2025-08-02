package com.facebook.react.devsupport;

import com.facebook.react.bridge.ReadableArray;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f3163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f3164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3165c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ReadableArray f3166d;

    public /* synthetic */ t(a0 a0Var, int i10, String str, ReadableArray readableArray) {
        this.f3163a = a0Var;
        this.f3164b = i10;
        this.f3165c = str;
        this.f3166d = readableArray;
    }

    public final void run() {
        this.f3163a.I0(this.f3164b, this.f3165c, this.f3166d);
    }
}
