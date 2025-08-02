package org.cocos2dx.javascript.rn;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import org.cocos2dx.javascript.CCSensorsDataAPI;

public class CCSensorsDataAPIModule extends ReactContextBaseJavaModule {
    @ReactMethod
    public void flush() {
        CCSensorsDataAPI.flush();
    }

    @NonNull
    public String getName() {
        return "CCSensorsDataAPIModule";
    }

    @ReactMethod
    public void login(String str) {
        CCSensorsDataAPI.login(str);
    }

    @ReactMethod
    public void logout() {
        CCSensorsDataAPI.logout();
    }

    @ReactMethod
    public void track(String str, String str2) {
        CCSensorsDataAPI.track(str, str2);
    }
}
