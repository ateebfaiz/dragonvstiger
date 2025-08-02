package org.cocos2dx.javascript;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

public class SDKInfo {
    private static final Map<String, String> SDKMap = new a();

    class a extends HashMap {
        a() {
            put("AppsFlyer", "appsFlyerKey");
            put("FireBase", "mobilesdk_app_id");
            put(Constants.LOGTAG, "adjustToken");
            put("FaceBook", "facebook_client_token");
        }
    }

    public static boolean CheckSDK(String str) {
        String str2 = SDKMap.get(str);
        if (str2 == null) {
            return false;
        }
        return !PlatformUtils.getInfoValue(str2).isEmpty();
    }
}
