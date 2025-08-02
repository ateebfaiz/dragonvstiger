package com.facebook.react.runtime;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import com.facebook.react.uimanager.o1;
import java.util.Map;

public final /* synthetic */ class x0 implements UIConstantsProviderBinding.DefaultEventTypesProvider {
    public final NativeMap getDefaultEventTypes() {
        return Arguments.makeNativeMap((Map<String, Object>) o1.d());
    }
}
