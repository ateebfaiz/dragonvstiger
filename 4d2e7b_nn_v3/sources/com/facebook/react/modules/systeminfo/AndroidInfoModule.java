package com.facebook.react.modules.systeminfo;

import a7.b;
import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.facebook.fbreact.specs.NativePlatformConstantsAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.HashMap;
import java.util.Map;
import s6.a;

@SuppressLint({"HardwareIds"})
@a(name = "PlatformConstants")
public class AndroidInfoModule extends NativePlatformConstantsAndroidSpec implements TurboModule {
    private static final String IS_DISABLE_ANIMATIONS = "IS_DISABLE_ANIMATIONS";
    private static final String IS_TESTING = "IS_TESTING";

    public AndroidInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Boolean isRunningScreenshotTest() {
        try {
            Class.forName("com.facebook.testing.react.screenshots.ReactAppScreenshotTestActivity");
            return Boolean.TRUE;
        } catch (ClassNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    private String uiMode() {
        int currentModeType = ((UiModeManager) getReactApplicationContext().getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 1) {
            return Constants.NORMAL;
        }
        if (currentModeType == 2) {
            return "desk";
        }
        if (currentModeType == 3) {
            return "car";
        }
        if (currentModeType == 4) {
            return "tv";
        }
        if (currentModeType == 6) {
            return "watch";
        }
        if (currentModeType != 7) {
            return "unknown";
        }
        return "vrheadset";
    }

    public String getAndroidID() {
        return Settings.Secure.getString(getReactApplicationContext().getContentResolver(), "android_id");
    }

    @Nullable
    public Map<String, Object> getTypedExportedConstants() {
        boolean z10;
        HashMap hashMap = new HashMap();
        hashMap.put("Version", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("Release", Build.VERSION.RELEASE);
        hashMap.put("Serial", Build.SERIAL);
        hashMap.put("Fingerprint", Build.FINGERPRINT);
        hashMap.put(ExifInterface.TAG_MODEL, Build.MODEL);
        hashMap.put("Manufacturer", Build.MANUFACTURER);
        hashMap.put("Brand", Build.BRAND);
        if ("true".equals(System.getProperty(IS_TESTING)) || isRunningScreenshotTest().booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        hashMap.put("isTesting", Boolean.valueOf(z10));
        String property = System.getProperty(IS_DISABLE_ANIMATIONS);
        if (property != null) {
            hashMap.put("isDisableAnimations", Boolean.valueOf("true".equals(property)));
        }
        hashMap.put("reactNativeVersion", b.f2250a);
        hashMap.put("uiMode", uiMode());
        return hashMap;
    }

    public void invalidate() {
    }
}
