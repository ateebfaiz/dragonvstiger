package o7;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.util.RCTLog;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.m;
import z2.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f12876a = new c();

    private c() {
    }

    public static final void a(String str) {
        m.f(str, "message");
        a.j("ReactNative", str);
    }

    private final String b(int i10) {
        if (i10 == 2 || i10 == 3) {
            return "log";
        }
        if (i10 == 4 || i10 == 5) {
            return "warn";
        }
        if (i10 != 6) {
            return DevicePublicKeyStringDef.NONE;
        }
        return Constants.IPC_BUNDLE_KEY_SEND_ERROR;
    }

    private final void c(ReactContext reactContext, String str, int i10) {
        if (i10 >= 5 && reactContext != null && reactContext.hasActiveReactInstance() && str != null) {
            ((RCTLog) reactContext.getJSModule(RCTLog.class)).logIfNoNativeHook(b(i10), str);
        }
    }

    public static final void d(ReactContext reactContext, String str) {
        m.f(str, "message");
        f12876a.c(reactContext, str, 5);
        a.G("ReactNative", str);
    }
}
