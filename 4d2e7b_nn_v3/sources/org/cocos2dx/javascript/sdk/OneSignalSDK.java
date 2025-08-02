package org.cocos2dx.javascript.sdk;

import android.util.Log;
import com.onesignal.o3;
import org.cocos2dx.javascript.PlatformUtils;

public class OneSignalSDK {
    public static final String ONESIGNAL_SDK_LOG = "OneSignalSDKLog";

    public static void init() {
        String infoValue = PlatformUtils.getInfoValue("oneSignal");
        if (!infoValue.isEmpty()) {
            Log.d(ONESIGNAL_SDK_LOG, "Launch OneSignal");
            o3.L0(PlatformUtils.context);
            o3.D1(infoValue);
            o3.f1();
            o3.y("current_app_version", PlatformUtils.getHallVersion());
        }
    }
}
