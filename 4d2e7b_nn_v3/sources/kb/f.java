package kb;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.v0;
import com.zoontek.rnpermissions.RNPermissionsModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import t6.a;

public final class f extends v0 {
    /* access modifiers changed from: private */
    public static final Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNPermissions", new ReactModuleInfo("RNPermissions", "RNPermissions", false, false, true, false, false));
        return hashMap;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        m.f(str, "name");
        m.f(reactApplicationContext, "reactContext");
        if (m.b(str, "RNPermissions")) {
            return new RNPermissionsModule(reactApplicationContext);
        }
        return null;
    }

    public a getReactModuleInfoProvider() {
        return new e();
    }
}
