package org.cocos2dx.javascript.rn;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.l0;
import com.facebook.react.m0;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RNPackage implements m0 {
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNModule(reactApplicationContext));
        arrayList.add(new ThirdLoginModule());
        arrayList.add(new CCSensorsDataAPIModule());
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public /* bridge */ /* synthetic */ NativeModule getModule(@NonNull String str, @NonNull ReactApplicationContext reactApplicationContext) {
        return l0.a(this, str, reactApplicationContext);
    }
}
