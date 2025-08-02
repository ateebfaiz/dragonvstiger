package ua;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.v0;
import com.facebook.react.w0;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b extends v0 implements w0 {

    class a implements t6.a {
        a() {
        }

        public Map a() {
            HashMap hashMap = new HashMap();
            Class cls = new Class[]{ClipboardModule.class}[0];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
            return hashMap;
        }
    }

    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ClipboardModule(reactApplicationContext));
        return arrayList;
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        return null;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(ClipboardModule.NAME)) {
            return null;
        }
        return new ClipboardModule(reactApplicationContext);
    }

    public t6.a getReactModuleInfoProvider() {
        try {
            return (t6.a) Class.forName("com.reactnativecommunity.clipboard.ClipboardPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new a();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.clipboard.ClipboardPackage$$ReactModuleInfoProvider", e10);
        }
    }

    /* access modifiers changed from: protected */
    public List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    public List getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return null;
    }
}
