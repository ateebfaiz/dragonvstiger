package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.text.d;
import kotlin.text.h;
import kotlin.text.j;

public class AFd1wSDK {
    public static String AFInAppEventParameterName = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    public static String AFInAppEventType = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static AFc1aSDK afErrorLog;
    /* access modifiers changed from: private */
    public static final List<String> afInfoLog = r.o("googleplay", "playstore", "googleplaystore");
    /* access modifiers changed from: private */
    public final AFc1zSDK AFKeystoreWrapper;
    private final Lazy afRDLog = i.b(new Function0<String>(this) {
        private /* synthetic */ AFd1wSDK valueOf;

        {
            this.valueOf = r1;
        }

        /* renamed from: AFKeystoreWrapper */
        public final String invoke() {
            String AFInAppEventType = AFb1xSDK.AFInAppEventType(this.valueOf.valueOf, this.valueOf.AFKeystoreWrapper.AFInAppEventType());
            String str = "";
            if (AFInAppEventType != null && !j.s(AFInAppEventType)) {
                String obj = j.P0(AFInAppEventType).toString();
                List<String> values = AFa1zSDK.values();
                Locale locale = Locale.getDefault();
                m.e(locale, str);
                String lowerCase = obj.toLowerCase(locale);
                m.e(lowerCase, str);
                if (!values.contains(lowerCase)) {
                    AFInAppEventType = "-".concat(obj);
                } else {
                    b0 b0Var = b0.f709a;
                    String format = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{obj}, 1));
                    m.e(format, str);
                    AFLogger.afWarnLog(format);
                    AFInAppEventType = str;
                }
            }
            if (AFInAppEventType != null) {
                str = AFInAppEventType;
            }
            return j.P0(str).toString();
        }
    });
    /* access modifiers changed from: private */
    public final AFc1ySDK valueOf;
    public final Lazy values = i.b(new Function0<String>(this) {
        private /* synthetic */ AFd1wSDK AFInAppEventType;

        {
            this.AFInAppEventType = r1;
        }

        /* renamed from: AFInAppEventType */
        public final String invoke() {
            String packageName = this.AFInAppEventType.AFKeystoreWrapper.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
            m.e(packageName, "");
            return AFd1wSDK.AFKeystoreWrapper(packageName, AFd1wSDK.AFInAppEventParameterName(this.AFInAppEventType));
        }
    });

    public /* synthetic */ class AFa1wSDK {
        public static final /* synthetic */ int[] AFInAppEventParameterName;

        static {
            int[] iArr = new int[AFd1vSDK.values().length];
            iArr[AFd1vSDK.DEFAULT.ordinal()] = 1;
            iArr[AFd1vSDK.API.ordinal()] = 2;
            iArr[AFd1vSDK.RC.ordinal()] = 3;
            AFInAppEventParameterName = iArr;
        }
    }

    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        public static void valueOf(AFc1aSDK aFc1aSDK) {
            AFd1wSDK.afErrorLog = aFc1aSDK;
        }

        public static List<String> values() {
            return AFd1wSDK.afInfoLog;
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFd1wSDK(AFc1zSDK aFc1zSDK, AFc1ySDK aFc1ySDK) {
        m.f(aFc1zSDK, "");
        m.f(aFc1ySDK, "");
        this.AFKeystoreWrapper = aFc1zSDK;
        this.valueOf = aFc1ySDK;
    }

    public static final void AFInAppEventParameterName(AFc1aSDK aFc1aSDK) {
        AFa1zSDK.valueOf(aFc1aSDK);
    }

    public static final /* synthetic */ String AFKeystoreWrapper(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str2);
        String obj = sb3.toString();
        m.f(obj, "");
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = obj.getBytes(d.f797b);
        m.e(bytes, "");
        byte[] digest = instance.digest(bytes);
        m.e(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        m.e(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        m.e(lowerCase, "");
        String substring = new h("[^\\w]+").d(lowerCase, "").substring(0, 6);
        m.e(substring, "");
        sb2.append(substring);
        sb2.append('-');
        return sb2.toString();
    }

    public static boolean AFInAppEventParameterName() {
        return afErrorLog == null;
    }

    public final String AFInAppEventType() {
        AFd1vSDK aFd1vSDK;
        if (AFInAppEventParameterName()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i10 = AFa1wSDK.AFInAppEventParameterName[aFd1vSDK.ordinal()];
        if (i10 == 1) {
            return (String) this.values.getValue();
        }
        if (i10 == 2) {
            AFc1aSDK aFc1aSDK = afErrorLog;
            String str = aFc1aSDK != null ? aFc1aSDK.AFInAppEventParameterName : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i10 == 3) {
            return "";
        } else {
            throw new n();
        }
    }

    public final String values() {
        AFd1vSDK aFd1vSDK;
        if (AFInAppEventParameterName()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i10 = AFa1wSDK.AFInAppEventParameterName[aFd1vSDK.ordinal()];
        if (i10 == 1) {
            return "appsflyersdk.com";
        }
        if (i10 == 2) {
            AFc1aSDK aFc1aSDK = afErrorLog;
            String str = aFc1aSDK != null ? aFc1aSDK.valueOf : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i10 == 3) {
            return "";
        } else {
            throw new n();
        }
    }

    public static final /* synthetic */ String AFInAppEventParameterName(AFd1wSDK aFd1wSDK) {
        return (String) aFd1wSDK.afRDLog.getValue();
    }
}
