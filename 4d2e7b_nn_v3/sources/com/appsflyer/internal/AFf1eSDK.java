package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.m;

public final class AFf1eSDK implements AFf1fSDK {
    public final String AFKeystoreWrapper(String str) {
        m.f(str, "");
        String format = String.format(str, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()});
        m.e(format, "");
        return format;
    }
}
