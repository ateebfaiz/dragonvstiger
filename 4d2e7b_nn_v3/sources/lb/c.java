package lb;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import fr.greweb.reactnativeviewshot.NativeRNViewShotSpec;
import fr.greweb.reactnativeviewshot.RNViewShotModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import t6.a;

public class c extends v0 {
    /* access modifiers changed from: private */
    public static /* synthetic */ Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeRNViewShotSpec.NAME, new ReactModuleInfo(NativeRNViewShotSpec.NAME, NativeRNViewShotSpec.NAME, false, false, false, false));
        return hashMap;
    }

    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNViewShotModule(reactApplicationContext));
        return arrayList;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeRNViewShotSpec.NAME)) {
            return new RNViewShotModule(reactApplicationContext);
        }
        return null;
    }

    public a getReactModuleInfoProvider() {
        return new b();
    }
}
