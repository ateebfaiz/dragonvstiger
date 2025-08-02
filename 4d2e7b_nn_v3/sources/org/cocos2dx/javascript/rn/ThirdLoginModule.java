package org.cocos2dx.javascript.rn;

import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import org.cocos2dx.javascript.PlatformUtils;

public class ThirdLoginModule extends ReactContextBaseJavaModule {
    private static ThirdLoginModule instance;
    private Callback facebookLoginCallback;
    private Callback googleLoginCallback;
    private Callback lineLoginCallback;

    ThirdLoginModule() {
        instance = this;
    }

    public static ThirdLoginModule getInstance() {
        if (instance == null) {
            Log.d("ThirdLoginModule", "getInstance: null");
        }
        return instance;
    }

    @ReactMethod
    public void facebookLogin(Callback callback) {
        this.facebookLoginCallback = callback;
        PlatformUtils.facebookLogin();
    }

    public void facebookLoginResult(String str, String str2) {
        Callback callback = this.facebookLoginCallback;
        if (callback != null) {
            callback.invoke(str, str2);
            this.facebookLoginCallback = null;
        }
    }

    @ReactMethod
    public void facebookLogout() {
        PlatformUtils.facebookLogout();
    }

    @NonNull
    public String getName() {
        return "ThirdLoginModule";
    }

    @ReactMethod
    public void googleLogin(String str, Callback callback) {
        PlatformUtils.googleLogin(str);
        this.googleLoginCallback = callback;
    }

    public void googleLoginResult(String str, String str2) {
        Callback callback = this.googleLoginCallback;
        if (callback != null) {
            callback.invoke(str, str2);
            this.googleLoginCallback = null;
        }
    }

    @ReactMethod
    public void googleLogout() {
        PlatformUtils.googleLogout();
    }

    @ReactMethod
    public void lineLogin(String str, Callback callback) {
        this.lineLoginCallback = callback;
        PlatformUtils.lineLogin(str);
    }

    public void lineLoginResult(String str) {
        Callback callback = this.lineLoginCallback;
        if (callback != null) {
            callback.invoke(str);
            this.lineLoginCallback = null;
        }
    }
}
