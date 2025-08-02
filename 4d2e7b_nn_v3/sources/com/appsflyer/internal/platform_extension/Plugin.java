package com.appsflyer.internal.platform_extension;

public enum Plugin {
    NATIVE("android_native"),
    UNITY("android_unity"),
    FLUTTER("android_flutter"),
    REACT_NATIVE("android_react_native"),
    ADOBE_AIR("android_adobe_air"),
    ADOBE_MOBILE("android_adobe_mobile"),
    COCOS_2DX("android_cocos2dx"),
    CORDOVA("android_cordova"),
    MPARTICLE("android_mparticle"),
    NATIVE_SCRIPT("android_native_script"),
    EXPO("android_expo"),
    UNREAL("android_unreal"),
    XAMARIN("android_xamarin"),
    CAPACITOR("android_capacitor"),
    SEGMENT("android_segment");
    
    private final String AFKeystoreWrapper;

    private Plugin(String str) {
        this.AFKeystoreWrapper = str;
    }

    public final String getPluginName() {
        return this.AFKeystoreWrapper;
    }
}
