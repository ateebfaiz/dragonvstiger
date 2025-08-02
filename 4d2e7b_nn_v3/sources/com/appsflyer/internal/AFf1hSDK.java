package com.appsflyer.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class AFf1hSDK {
    public static final String AFKeystoreWrapper;
    public static final String AFLogger;
    public static String AFVersionDeclaration;
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK((DefaultConstructorMarker) null);
    public static String afDebugLog;
    public static final String afErrorLog;
    private static final String afErrorLogForExcManagerOnly;
    public static String afInfoLog;
    public static String afRDLog;
    public static String getLevel;
    public static final String valueOf = "https://%sadrevenue.%s/api/v2/generic/v6.10.2/android?app_id=";
    public static final String values;
    public final AFc1vSDK AFInAppEventParameterName;
    public final AFf1fSDK AFInAppEventType;

    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AFb1xSDK.AFKeystoreWrapper);
        sb2.append("/androidevent?app_id=");
        String obj = sb2.toString();
        afErrorLogForExcManagerOnly = obj;
        StringBuilder sb3 = new StringBuilder("https://%sattr.%s/api/v");
        sb3.append(obj);
        AFKeystoreWrapper = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%sconversions.%s/api/v");
        sb4.append(obj);
        values = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%slaunches.%s/api/v");
        sb5.append(obj);
        AFLogger = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%sinapps.%s/api/v");
        sb6.append(obj);
        afErrorLog = sb6.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AFf1hSDK(AFc1vSDK aFc1vSDK) {
        this(aFc1vSDK, (AFf1fSDK) null, 2, (DefaultConstructorMarker) null);
        m.f(aFc1vSDK, "");
    }

    public static String AFInAppEventType(String str, boolean z10) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (!z10) {
            str2 = "&buildnumber=6.10.2";
        } else {
            str2 = "";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    private AFf1hSDK(AFc1vSDK aFc1vSDK, AFf1fSDK aFf1fSDK) {
        m.f(aFc1vSDK, "");
        m.f(aFf1fSDK, "");
        this.AFInAppEventParameterName = aFc1vSDK;
        this.AFInAppEventType = aFf1fSDK;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFf1hSDK(AFc1vSDK aFc1vSDK, AFf1fSDK aFf1fSDK, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1vSDK, (i10 & 2) != 0 ? new AFf1eSDK() : aFf1fSDK);
    }
}
