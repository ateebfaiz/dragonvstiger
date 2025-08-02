package ta;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.v0;
import com.facebook.react.w0;
import com.reactnativecommunity.cameraroll.CameraRollModule;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g extends v0 implements w0 {

    class a implements t6.a {
        a() {
        }

        public Map a() {
            HashMap hashMap = new HashMap();
            Class cls = new Class[]{CameraRollModule.class}[0];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
            return hashMap;
        }
    }

    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new CameraRollModule(reactApplicationContext)});
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        return null;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(CameraRollModule.NAME)) {
            return null;
        }
        return new CameraRollModule(reactApplicationContext);
    }

    public t6.a getReactModuleInfoProvider() {
        try {
            return (t6.a) Class.forName("com.reactnativecommunity.cameraroll.CameraRollPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new a();
        } catch (IllegalAccessException | InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.cameraroll.CameraRollPackage$$ReactModuleInfoProvider", e10);
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
