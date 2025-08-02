package com.facebook.react.runtime;

import com.facebook.react.bridge.NativeMap;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import java.util.Map;

public final /* synthetic */ class z0 implements UIConstantsProviderBinding.ConstantsProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactInstance f3535a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f3536b;

    public /* synthetic */ z0(ReactInstance reactInstance, Map map) {
        this.f3535a = reactInstance;
        this.f3536b = map;
    }

    public final NativeMap getConstants() {
        return this.f3535a.w(this.f3536b);
    }
}
