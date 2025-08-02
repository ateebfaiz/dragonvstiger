package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import t6.a;

public final class e extends v0 {
    /* access modifiers changed from: private */
    public static final Map f(Map map) {
        m.f(map, "$reactModuleInfoMap");
        return map;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        m.f(reactApplicationContext, "reactContext");
        return r.o(new SafeAreaProviderManager(), new SafeAreaViewManager());
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        m.f(str, "name");
        m.f(reactApplicationContext, "reactContext");
        if (m.b(str, SafeAreaContextModule.NAME)) {
            return new SafeAreaContextModule(reactApplicationContext);
        }
        return null;
    }

    public a getReactModuleInfoProvider() {
        HashMap hashMap = new HashMap();
        Class cls = new Class[]{SafeAreaContextModule.class}[0];
        s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
        if (aVar != null) {
            String name = aVar.name();
            String name2 = aVar.name();
            String name3 = cls.getName();
            m.e(name3, "getName(...)");
            hashMap.put(name, new ReactModuleInfo(name2, name3, true, aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), false));
        }
        return new d(hashMap);
    }
}
