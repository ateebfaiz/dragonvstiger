package com.reactnativecommunity.asyncstorage;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i extends v0 {

    class a implements t6.a {
        a() {
        }

        public Map a() {
            HashMap hashMap = new HashMap();
            Class cls = new Class[]{AsyncStorageModule.class}[0];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), false));
            return hashMap;
        }
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(AsyncStorageModule.NAME)) {
            return null;
        }
        return new AsyncStorageModule(reactApplicationContext);
    }

    public t6.a getReactModuleInfoProvider() {
        try {
            return (t6.a) Class.forName("com.reactnativecommunity.asyncstorage.AsyncStoragePackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new a();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.asyncstorage.AsyncStoragePackage$$ReactModuleInfoProvider", e10);
        }
    }

    /* access modifiers changed from: protected */
    public List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return null;
    }
}
