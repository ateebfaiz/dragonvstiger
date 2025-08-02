package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.s0;
import java.util.Map;

public final /* synthetic */ class r0 implements s0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f20915a;

    public /* synthetic */ r0(Map map) {
        this.f20915a = map;
    }

    public final NativeModule getModule(String str) {
        return (NativeModule) this.f20915a.get(str);
    }
}
