package com.reactnativepagerview;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.m0;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

public final class a implements m0 {
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "reactContext");
        return r.l();
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "reactContext");
        return r.e(new PagerViewViewManager());
    }
}
