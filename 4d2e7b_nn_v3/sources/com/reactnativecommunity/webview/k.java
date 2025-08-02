package com.reactnativecommunity.webview;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t6.a;

public class k extends v0 {
    /* access modifiers changed from: private */
    public static /* synthetic */ Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNCWebViewModule", new ReactModuleInfo("RNCWebViewModule", "RNCWebViewModule", false, false, true, false, false));
        return hashMap;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNCWebViewManager());
        return arrayList;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("RNCWebViewModule")) {
            return new RNCWebViewModule(reactApplicationContext);
        }
        return null;
    }

    public a getReactModuleInfoProvider() {
        return new j();
    }
}
