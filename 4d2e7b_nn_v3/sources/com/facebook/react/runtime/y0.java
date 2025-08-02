package com.facebook.react.runtime;

import com.facebook.react.bridge.NativeMap;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import java.util.Map;

public final /* synthetic */ class y0 implements UIConstantsProviderBinding.ConstantsForViewManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactInstance f3531a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f3532b;

    public /* synthetic */ y0(ReactInstance reactInstance, Map map) {
        this.f3531a = reactInstance;
        this.f3532b = map;
    }

    public final NativeMap getConstantsForViewManager(String str) {
        return this.f3531a.v(this.f3532b, str);
    }
}
