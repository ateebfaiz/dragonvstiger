package com.swmansion.reanimated;

import androidx.annotation.NonNull;
import c8.a;
import com.facebook.react.b;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.g0;
import com.facebook.react.m0;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.u;
import com.facebook.react.uimanager.ReanimatedUIManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.swmansion.worklets.WorkletsModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReanimatedPackage extends b implements m0 {
    private UIManagerModule createUIManager(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        a.c(0, "createUIManagerModule");
        try {
            return ReanimatedUIManagerFactory.create(reactApplicationContext, getReactInstanceManager(reactApplicationContext).G(reactApplicationContext), -1);
        } finally {
            a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map lambda$getReactModuleInfoProvider$0(Map map) {
        return map;
    }

    public NativeModule getModule(@NonNull String str, @NonNull ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1023230923:
                if (str.equals(NativeWorkletsModuleSpec.NAME)) {
                    c10 = 0;
                    break;
                }
                break;
            case 1093251842:
                if (str.equals(NativeReanimatedModuleSpec.NAME)) {
                    c10 = 1;
                    break;
                }
                break;
            case 1861242489:
                if (str.equals(UIManagerModule.NAME)) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new WorkletsModule(reactApplicationContext);
            case 1:
                return new ReanimatedModule(reactApplicationContext);
            case 2:
                return createUIManager(reactApplicationContext);
            default:
                return null;
        }
    }

    public g0 getReactInstanceManager(ReactApplicationContext reactApplicationContext) {
        return ((u) reactApplicationContext.getApplicationContext()).getReactNativeHost().p();
    }

    public t6.a getReactModuleInfoProvider() {
        Class[] clsArr = {WorkletsModule.class, ReanimatedModule.class, ReanimatedUIManager.class};
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < 3; i10++) {
            Class cls = clsArr[i10];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            Objects.requireNonNull(aVar);
            s6.a aVar2 = aVar;
            hashMap.put(aVar2.name(), new ReactModuleInfo(aVar2.name(), cls.getName(), true, aVar2.needsEagerInit(), aVar2.isCxxModule(), false));
        }
        return new j(hashMap);
    }
}
