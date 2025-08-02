package com.appsflyer.internal;

import com.appsflyer.AFLogger;

@Deprecated
public final class AFb1vSDK implements AFa1vSDK {
    private final AFa1vSDK values = this;

    interface AFa1vSDK {
        Class<?> values(String str) throws ClassNotFoundException;
    }

    enum AFa1ySDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");
        
        /* access modifiers changed from: private */
        public final String afWarnLog;
        /* access modifiers changed from: private */
        public final String onInstallConversionFailureNative;

        private AFa1ySDK(String str, String str2) {
            this.afWarnLog = str;
            this.onInstallConversionFailureNative = str2;
        }
    }

    private boolean AFInAppEventType(String str) {
        try {
            this.values.values(str);
            StringBuilder sb2 = new StringBuilder("Class: ");
            sb2.append(str);
            sb2.append(" is found.");
            AFLogger.afRDLog(sb2.toString());
            return true;
        } catch (ClassNotFoundException e10) {
            StringBuilder sb3 = new StringBuilder("Class: ");
            sb3.append(str);
            sb3.append(" is  not found. (Platform extension)");
            AFLogger.afErrorLogForExcManagerOnly(sb3.toString(), e10, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    public final String AFKeystoreWrapper() {
        for (AFa1ySDK aFa1ySDK : AFa1ySDK.values()) {
            if (AFInAppEventType(aFa1ySDK.onInstallConversionFailureNative)) {
                return aFa1ySDK.afWarnLog;
            }
        }
        return AFa1ySDK.DEFAULT.afWarnLog;
    }

    public final Class<?> values(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
