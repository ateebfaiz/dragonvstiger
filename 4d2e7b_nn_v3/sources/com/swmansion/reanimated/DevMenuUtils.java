package com.swmansion.reanimated;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.u;
import k6.d;
import k6.e;

public class DevMenuUtils {
    public static void addDevMenuOption(ReactApplicationContext reactApplicationContext, d dVar) {
        e eVar;
        if (reactApplicationContext.getApplicationContext() instanceof u) {
            if (reactApplicationContext.isBridgeless()) {
                eVar = ((u) reactApplicationContext.getApplicationContext()).getReactHost().h();
            } else {
                eVar = ((u) reactApplicationContext.getApplicationContext()).getReactNativeHost().p().D();
            }
            if (eVar != null) {
                eVar.C("Toggle slow animations (Reanimated)", dVar);
                return;
            }
            throw new RuntimeException("[Reanimated] DevSupportManager is not available");
        }
    }
}
