package com.facebook.react.runtime;

import com.facebook.react.bridge.Callback;
import com.facebook.react.runtime.ReactHostImpl;

public final /* synthetic */ class d0 implements ReactHostImpl.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f3447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3448b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3449c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3450d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Callback f3451e;

    public /* synthetic */ d0(ReactHostImpl reactHostImpl, String str, int i10, String str2, Callback callback) {
        this.f3447a = reactHostImpl;
        this.f3448b = str;
        this.f3449c = i10;
        this.f3450d = str2;
        this.f3451e = callback;
    }

    public final void a(ReactInstance reactInstance) {
        this.f3447a.l1(this.f3448b, this.f3449c, this.f3450d, this.f3451e, reactInstance);
    }
}
