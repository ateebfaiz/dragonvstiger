package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.DNSResolver;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.google.android.gms.common.ConnectionResult;
import com.zing.zalo.zalosdk.common.Constant;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class AFc1kSDK {
    @VisibleForTesting
    private static String AFInAppEventParameterName = "https://%sonelink.%s/shortlink-sdk/v2";
    @VisibleForTesting
    private static String AFInAppEventType = "https://%smonitorsdk.%s/remote-debug?app_id=";
    private static int AFLogger = ((afInfoLog + 41) % 128);
    private static int afInfoLog;
    private static int[] afRDLog;
    public static String values = "https://%sgcdsdk.%s/install_data/v5.0/";
    private final CreateOneLinkHttpTask AFKeystoreWrapper;
    private final AppsFlyerProperties afDebugLog;
    private final AFd1wSDK afErrorLog;
    private final AFc1zSDK valueOf;

    static {
        AFKeystoreWrapper();
    }

    public AFc1kSDK(CreateOneLinkHttpTask createOneLinkHttpTask, AFc1zSDK aFc1zSDK, AppsFlyerProperties appsFlyerProperties, AFd1wSDK aFd1wSDK) {
        this.AFKeystoreWrapper = createOneLinkHttpTask;
        this.valueOf = aFc1zSDK;
        this.afDebugLog = appsFlyerProperties;
        this.afErrorLog = aFd1wSDK;
    }

    static void AFKeystoreWrapper() {
        afRDLog = new int[]{-672765460, 973734950, -481961226, -2045304833, 25430739, 432217355, 64525102, 1055828195, 664986047, 1353405260, 512053792, 1366916719, -1888366569, 375619018, 1675056026, 1471284235, -566253957, -219256705};
    }

    @NonNull
    public final AFc1jSDK<String> AFInAppEventParameterName(Map<String, Object> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String obj = sb2.toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(37 - (ViewConfiguration.getWindowTouchSlop() >> 8), Gravity.getAbsoluteGravity(0, 0) + 73, (char) ((Process.myTid() >> 22) + 48063))).getMethod("values", new Class[]{Map.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), true), new AFc1dSDK());
            afInfoLog = (AFLogger + 39) % 128;
            return valueOf2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1jSDK<Map<String, Object>> AFInAppEventType(String str, String str2) {
        AFc1jSDK<Map<String, Object>> valueOf2 = valueOf(AFc1mSDK.valueOf(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName(), AFb1wSDK.AFKeystoreWrapper(new WeakReference(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper)), str, str2), new AFc1eSDK());
        int i10 = afInfoLog + 21;
        AFLogger = i10 % 128;
        if (i10 % 2 != 0) {
            return valueOf2;
        }
        throw null;
    }

    @NonNull
    public final AFc1jSDK<String> valueOf(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(sb2.toString(), new JSONObject(map).toString().getBytes(), "POST", Collections.emptyMap(), false), new AFc1dSDK());
        AFLogger = (afInfoLog + 57) % 128;
        return valueOf2;
    }

    public final AFc1jSDK<String> values(@NonNull String str, @NonNull Map<String, String> map, @Nullable String str2, @NonNull UUID uuid, @NonNull String str3) {
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put("uuid", obj);
        hashMap.put("data", map);
        hashMap.put("meta", values());
        if (str2 != null) {
            int i10 = afInfoLog + 3;
            AFLogger = i10 % 128;
            if (i10 % 2 != 0) {
                hashMap.put("brand_domain", str2);
            } else {
                hashMap.put("brand_domain", str2);
                throw null;
            }
        }
        String jSONObject = AFa1oSDK.AFKeystoreWrapper((Map<String, ?>) hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        valueOf(new int[]{80594839, 1788865157, -1077787898, -1986835446, 771314473, 1329780629}, (Process.myTid() >> 22) + 12, objArr);
        hashMap2.put(((String) objArr[0]).intern(), AFKeystoreWrapper(str3, obj, "POST", jSONObject));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(DomExceptionUtils.SEPARATOR);
        sb2.append(str);
        AFc1jSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1rSDK(sb2.toString(), jSONObject.getBytes(Charset.forName("UTF-8")), "POST", hashMap2, false), new AFc1dSDK(), true);
        int i11 = AFLogger + 105;
        afInfoLog = i11 % 128;
        if (i11 % 2 == 0) {
            return AFKeystoreWrapper2;
        }
        throw null;
    }

    @NonNull
    public final AFc1jSDK<String> AFKeystoreWrapper(Map<String, Object> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sars.%s/api/v2/android/validate_subscription?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String obj = sb2.toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(37 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 73 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (48063 - ExpandableListView.getPackedPositionGroup(0)))).getMethod("values", new Class[]{Map.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), true), new AFc1dSDK());
            afInfoLog = (AFLogger + 27) % 128;
            return valueOf2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1jSDK<String> AFInAppEventType(AFe1aSDK aFe1aSDK) {
        AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(aFe1aSDK.afErrorLog, aFe1aSDK.values(), "POST", Collections.emptyMap(), true), new AFc1dSDK());
        AFLogger = (afInfoLog + 79) % 128;
        return valueOf2;
    }

    private <T> AFc1jSDK<T> valueOf(AFc1rSDK aFc1rSDK, AFc1cSDK<T> aFc1cSDK) {
        int i10 = AFLogger + 123;
        afInfoLog = i10 % 128;
        if (i10 % 2 == 0) {
            return AFKeystoreWrapper(aFc1rSDK, aFc1cSDK, AFInAppEventType());
        }
        AFKeystoreWrapper(aFc1rSDK, aFc1cSDK, AFInAppEventType());
        throw null;
    }

    @NonNull
    public final AFc1jSDK<AFb1iSDK> AFInAppEventParameterName(boolean z10, boolean z11, @NonNull String str, int i10) {
        String str2;
        String str3;
        afInfoLog = (AFLogger + 43) % 128;
        AFd1wSDK aFd1wSDK = this.afErrorLog;
        m.f(str, "");
        String str4 = !z10 ? AFd1wSDK.AFInAppEventType : AFd1wSDK.AFInAppEventParameterName;
        if (z11) {
            AFLogger = (afInfoLog + 15) % 128;
            str2 = "stg";
        } else {
            afInfoLog = (AFLogger + 17) % 128;
            str2 = "";
        }
        b0 b0Var = b0.f709a;
        if (AFd1wSDK.AFInAppEventParameterName()) {
            str3 = (String) aFd1wSDK.values.getValue();
        } else {
            str3 = "";
        }
        String format = String.format(str4, Arrays.copyOf(new Object[]{str3, str2, aFd1wSDK.values(), str}, 4));
        m.e(format, "");
        AFc1rSDK aFc1rSDK = new AFc1rSDK(format, "GET");
        aFc1rSDK.valueOf(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        return valueOf(aFc1rSDK, new AFc1gSDK());
    }

    private <T> AFc1jSDK<T> AFKeystoreWrapper(AFc1rSDK aFc1rSDK, AFc1cSDK<T> aFc1cSDK, boolean z10) {
        aFc1rSDK.AFKeystoreWrapper(z10);
        CreateOneLinkHttpTask createOneLinkHttpTask = this.AFKeystoreWrapper;
        AFc1jSDK<T> aFc1jSDK = new AFc1jSDK<>(aFc1rSDK, createOneLinkHttpTask.valueOf, createOneLinkHttpTask.AFInAppEventParameterName, aFc1cSDK);
        int i10 = afInfoLog + 107;
        AFLogger = i10 % 128;
        if (i10 % 2 != 0) {
            return aFc1jSDK;
        }
        throw null;
    }

    private boolean AFInAppEventType() {
        AFLogger = (afInfoLog + 29) % 128;
        if (!this.afDebugLog.getBoolean(AppsFlyerProperties.HTTP_CACHE, true)) {
            afInfoLog = (AFLogger + 47) % 128;
            return true;
        }
        int i10 = AFLogger + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        afInfoLog = i10 % 128;
        if (i10 % 2 == 0) {
            return false;
        }
        throw null;
    }

    private static String AFKeystoreWrapper(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String valueOf2 = AFb1ySDK.valueOf((String[]) arrayList.toArray(new String[0]));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append("v2");
        String AFKeystoreWrapper2 = AFb1ySDK.AFKeystoreWrapper(valueOf2, sb2.toString());
        int i10 = afInfoLog + 83;
        AFLogger = i10 % 128;
        if (i10 % 2 != 0) {
            return AFKeystoreWrapper2;
        }
        throw null;
    }

    private static void valueOf(int[] iArr, int i10, Object[] objArr) {
        String str;
        synchronized (AFg1mSDK.AFKeystoreWrapper) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[(iArr.length << 1)];
                int[] iArr2 = (int[]) afRDLog.clone();
                AFg1mSDK.valueOf = 0;
                while (true) {
                    int i11 = AFg1mSDK.valueOf;
                    if (i11 < iArr.length) {
                        int i12 = iArr[i11];
                        char c10 = (char) (i12 >> 16);
                        cArr[0] = c10;
                        char c11 = (char) i12;
                        cArr[1] = c11;
                        char c12 = (char) (iArr[i11 + 1] >> 16);
                        cArr[2] = c12;
                        char c13 = (char) iArr[i11 + 1];
                        cArr[3] = c13;
                        AFg1mSDK.AFInAppEventParameterName = (c10 << 16) + c11;
                        AFg1mSDK.values = (c12 << 16) + c13;
                        AFg1mSDK.AFInAppEventParameterName(iArr2);
                        for (int i13 = 0; i13 < 16; i13++) {
                            int i14 = AFg1mSDK.AFInAppEventParameterName ^ iArr2[i13];
                            AFg1mSDK.AFInAppEventParameterName = i14;
                            AFg1mSDK.values = AFg1mSDK.AFInAppEventType(i14) ^ AFg1mSDK.values;
                            int i15 = AFg1mSDK.AFInAppEventParameterName;
                            AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                            AFg1mSDK.values = i15;
                        }
                        int i16 = AFg1mSDK.AFInAppEventParameterName;
                        AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                        AFg1mSDK.values = i16;
                        AFg1mSDK.values = i16 ^ iArr2[16];
                        AFg1mSDK.AFInAppEventParameterName ^= iArr2[17];
                        int i17 = AFg1mSDK.valueOf;
                        int i18 = AFg1mSDK.AFInAppEventParameterName;
                        cArr[0] = (char) (i18 >>> 16);
                        cArr[1] = (char) i18;
                        int i19 = AFg1mSDK.values;
                        cArr[2] = (char) (i19 >>> 16);
                        cArr[3] = (char) i19;
                        AFg1mSDK.AFInAppEventParameterName(iArr2);
                        int i20 = AFg1mSDK.valueOf;
                        cArr2[i20 << 1] = cArr[0];
                        cArr2[(i20 << 1) + 1] = cArr[1];
                        cArr2[(i20 << 1) + 2] = cArr[2];
                        cArr2[(i20 << 1) + 3] = cArr[3];
                        AFg1mSDK.valueOf = i20 + 2;
                    } else {
                        str = new String(cArr2, 0, i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str;
    }

    public final AFc1jSDK<Map<String, String>> values(@NonNull String str, @NonNull String str2, @NonNull UUID uuid, @NonNull String str3) {
        String str4 = str;
        String str5 = str2;
        String obj = uuid.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(DomExceptionUtils.SEPARATOR);
        sb2.append(str);
        sb2.append("?id=");
        sb2.append(str5);
        String obj2 = sb2.toString();
        Map<String, Object> values2 = values();
        String valueOf2 = String.valueOf(values2.get("build_number"));
        HashMap hashMap = new HashMap();
        hashMap.put("Af-UUID", uuid.toString());
        hashMap.put("Af-Meta-Sdk-Ver", valueOf2);
        hashMap.put("Af-Meta-Counter", String.valueOf(values2.get("counter")));
        hashMap.put("Af-Meta-Model", String.valueOf(values2.get("model")));
        hashMap.put("Af-Meta-Platform", String.valueOf(values2.get("platformextension")));
        hashMap.put("Af-Meta-System-Version", String.valueOf(values2.get("sdk")));
        Object[] objArr = new Object[1];
        valueOf(new int[]{80594839, 1788865157, -1077787898, -1986835446, 771314473, 1329780629}, 12 - (Process.myPid() >> 22), objArr);
        hashMap.put(((String) objArr[0]).intern(), AFKeystoreWrapper(str3, obj, "GET", obj, str, str5, valueOf2));
        AFc1jSDK<Map<String, String>> valueOf3 = valueOf(new AFc1rSDK(obj2, (byte[]) null, "GET", hashMap, false), new AFc1bSDK());
        int i10 = AFLogger + 59;
        afInfoLog = i10 % 128;
        if (i10 % 2 == 0) {
            return valueOf3;
        }
        throw null;
    }

    public final AFc1jSDK<String> AFInAppEventParameterName(AFa1sSDK aFa1sSDK, String str) {
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = aFa1sSDK;
            AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(aFa1sSDK.afErrorLog, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(TextUtils.indexOf("", "") + 37, 73 - TextUtils.indexOf("", "", 0), (char) (48064 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("AFKeystoreWrapper", new Class[]{AFa1sSDK.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), aFa1sSDK.valueOf()), new AFc1dSDK());
            AFLogger = (afInfoLog + 61) % 128;
            return valueOf2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1jSDK<String> values(@NonNull String str) {
        AFc1jSDK<String> valueOf2 = valueOf(new AFc1rSDK(str, (byte[]) null, "GET", Collections.emptyMap(), false).valueOf(10000).afErrorLogForExcManagerOnly(), new AFc1dSDK());
        int i10 = AFLogger + DNSResolver.GOBACK_LOCAL;
        afInfoLog = i10 % 128;
        if (i10 % 2 == 0) {
            return valueOf2;
        }
        throw null;
    }

    @VisibleForTesting
    private Map<String, Object> values() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.10.2");
        hashMap.put("counter", Integer.valueOf(this.valueOf.valueOf.AFInAppEventType("appsFlyerCount", 0)));
        hashMap.put("model", Build.MODEL);
        Object[] objArr = new Object[1];
        valueOf(new int[]{1178321395, -716875729, -127298173, -1662430870}, -16777211 - Color.rgb(0, 0, 0), objArr);
        hashMap.put(((String) objArr[0]).intern(), Build.BRAND);
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        Context context = this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper;
        hashMap.put("app_version_name", AFa1cSDK.values(context, context.getPackageName()));
        hashMap.put(Constant.PARAM_APP_ID, this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        hashMap.put("platformextension", new AFb1vSDK().AFKeystoreWrapper());
        AFLogger = (afInfoLog + 35) % 128;
        return hashMap;
    }
}
