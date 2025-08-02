package com.facebook.react.runtime;

import com.facebook.react.bridge.NativeArray;
import com.facebook.react.runtime.ReactHostImpl;

public final /* synthetic */ class o0 implements ReactHostImpl.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3490b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeArray f3491c;

    public /* synthetic */ o0(String str, String str2, NativeArray nativeArray) {
        this.f3489a = str;
        this.f3490b = str2;
        this.f3491c = nativeArray;
    }

    public final void a(ReactInstance reactInstance) {
        reactInstance.callFunctionOnModule(this.f3489a, this.f3490b, this.f3491c);
    }
}
