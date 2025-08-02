package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1lSDK;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFc1uSDK;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.b;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import tb.h;

@WorkerThread
public final class AFa1bSDK implements AFc1wSDK {
    static String AFKeystoreWrapper;
    @Nullable
    static Boolean values;
    private final AFc1sSDK valueOf;

    public AFa1bSDK() {
    }

    private File AFInAppEventType() {
        Context context = this.valueOf.AFKeystoreWrapper;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File afRDLog() {
        File AFInAppEventType = AFInAppEventType();
        if (AFInAppEventType == null) {
            return null;
        }
        File file = new File(AFInAppEventType, "6.10.2");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1oSDK.AFa1xSDK valueOf(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = AFKeystoreWrapper
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            r4 = 0
            if (r3 == 0) goto L_0x0011
        L_0x000f:
            r5 = r4
            goto L_0x0053
        L_0x0011:
            java.lang.Boolean r1 = values
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0027
        L_0x001b:
            java.lang.Boolean r1 = values
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L_0x0051
        L_0x0027:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0046 }
            r1.<init>(r5)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.isEnableLog()     // Catch:{ all -> 0x0046 }
            r1.setLogging(r5)     // Catch:{ all -> 0x0046 }
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0051
            java.lang.String r0 = r5.getId()     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x0043 }
            r1 = r0
            goto L_0x0053
        L_0x0043:
            r5 = move-exception
            r1 = r0
            goto L_0x0048
        L_0x0046:
            r5 = move-exception
            r1 = r4
        L_0x0048:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x000f
        L_0x0051:
            r5 = r4
            r1 = r5
        L_0x0053:
            if (r1 == 0) goto L_0x0061
            com.appsflyer.internal.AFc1oSDK$AFa1xSDK r0 = new com.appsflyer.internal.AFc1oSDK$AFa1xSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFInAppEventType = r5
            return r0
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.valueOf(android.content.Context):com.appsflyer.internal.AFc1oSDK$AFa1xSDK");
    }

    @Nullable
    public static AFc1oSDK.AFa1xSDK values(ContentResolver contentResolver) {
        String str;
        if (!valueOf() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i10 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i10 == 0) {
            return new AFc1oSDK.AFa1xSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i10 == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            str = "";
        }
        return new AFc1oSDK.AFa1xSDK(str, Boolean.TRUE);
    }

    public final int AFInAppEventParameterName() {
        int i10 = 0;
        for (AFc1uSDK aFc1uSDK : AFKeystoreWrapper()) {
            i10 += aFc1uSDK.AFKeystoreWrapper;
        }
        return i10;
    }

    public final List<AFc1uSDK> AFKeystoreWrapper() {
        List<AFc1uSDK> list;
        synchronized (this) {
            try {
                File afRDLog = afRDLog();
                list = null;
                if (afRDLog != null) {
                    File[] listFiles = afRDLog.listFiles();
                    if (listFiles != null) {
                        m.e(listFiles, "");
                        ArrayList arrayList = new ArrayList();
                        for (File file : listFiles) {
                            AFc1uSDK.AFa1xSDK aFa1xSDK = AFc1uSDK.AFa1xSDK;
                            m.e(file, "");
                            AFc1uSDK AFInAppEventType = AFc1uSDK.AFa1xSDK.AFInAppEventType(h.e(file, (Charset) null, 1, (Object) null));
                            if (AFInAppEventType != null) {
                                arrayList.add(AFInAppEventType);
                            }
                        }
                        list = arrayList;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
            if (list == null) {
                list = r.l();
            }
        }
        return list;
    }

    public AFa1bSDK(AFc1sSDK aFc1sSDK) {
        m.f(aFc1sSDK, "");
        this.valueOf = aFc1sSDK;
    }

    public final boolean AFInAppEventType(String... strArr) {
        boolean z10;
        m.f(strArr, "");
        synchronized (this) {
            try {
                File AFInAppEventType = AFInAppEventType();
                z10 = true;
                if (AFInAppEventType != null) {
                    if (strArr.length == 0) {
                        m.f("delete all exceptions", "");
                        AFLogger.afRDLog("[Exception Manager]: ".concat("delete all exceptions"));
                        z10 = h.m(AFInAppEventType);
                    } else {
                        StringBuilder sb2 = new StringBuilder("delete all exceptions except for: ");
                        sb2.append(j.N(strArr, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                        String obj = sb2.toString();
                        m.f(obj, "");
                        AFLogger.afRDLog("[Exception Manager]: ".concat(String.valueOf(obj)));
                        File[] listFiles = AFInAppEventType.listFiles();
                        if (listFiles != null) {
                            m.e(listFiles, "");
                            ArrayList<File> arrayList = new ArrayList<>();
                            for (File file : listFiles) {
                                if (!j.s(strArr, file.getName())) {
                                    arrayList.add(file);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList(r.v(arrayList, 10));
                            for (File file2 : arrayList) {
                                m.e(file2, "");
                                arrayList2.add(Boolean.valueOf(h.m(file2)));
                            }
                            Collection A0 = r.A0(arrayList2);
                            if (A0.isEmpty()) {
                                A0 = r0.c(Boolean.TRUE);
                            }
                            Set set = (Set) A0;
                            if (set.size() != 1 || !((Boolean) r.X(set)).booleanValue()) {
                                z10 = false;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008f A[SYNTHETIC, Splitter:B:35:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012a  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1oSDK.AFa1xSDK values(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            boolean r2 = valueOf()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.common.GoogleApiAvailability r4 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ all -> 0x001f }
            int r4 = r4.isGooglePlayServicesAvailable(r13)     // Catch:{ all -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r4 = move-exception
            java.lang.String r5 = "isGooglePlayServicesAvailable error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r5, r4)
            r4 = -1
        L_0x0026:
            r5 = 0
            r6 = 1
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r13)     // Catch:{ all -> 0x0055 }
            if (r7 == 0) goto L_0x005a
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x0055 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x0052 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x004a
            int r7 = r8.length()     // Catch:{ all -> 0x0043 }
            if (r7 != 0) goto L_0x004f
            goto L_0x004a
        L_0x0043:
            r7 = move-exception
            r9 = r6
        L_0x0045:
            r12 = r7
            r7 = r3
            r3 = r8
            r8 = r12
            goto L_0x0067
        L_0x004a:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ all -> 0x0043 }
        L_0x004f:
            r9 = r6
            goto L_0x00f6
        L_0x0052:
            r7 = move-exception
            r9 = r5
            goto L_0x0045
        L_0x0055:
            r7 = move-exception
            r9 = r5
            r8 = r7
            r7 = r3
            goto L_0x0067
        L_0x005a:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ all -> 0x0055 }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0055 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x0055 }
            throw r7     // Catch:{ all -> 0x0055 }
        L_0x0067:
            java.lang.String r10 = r8.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r8)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r2.append(r8)
            java.lang.String r8 = " |"
            r2.append(r8)
            java.lang.String r10 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r10)
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r10 = r10.getBoolean(r11, r6)
            if (r10 == 0) goto L_0x00f4
            com.appsflyer.internal.AFa1eSDK$AFa1ySDK r3 = com.appsflyer.internal.AFa1eSDK.values(r13)     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = r3.valueOf     // Catch:{ all -> 0x00a6 }
            boolean r3 = r3.AFKeystoreWrapper()     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x00a8
            int r10 = r7.length()     // Catch:{ all -> 0x00a6 }
            if (r10 != 0) goto L_0x00ad
            goto L_0x00a8
        L_0x00a6:
            r3 = move-exception
            goto L_0x00af
        L_0x00a8:
            java.lang.String r10 = "emptyOrNull (bypass) |"
            r2.append(r10)     // Catch:{ all -> 0x00a6 }
        L_0x00ad:
            r8 = r7
            goto L_0x00f6
        L_0x00af:
            java.lang.String r7 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r7, r3, r6, r5, r5)
            java.lang.Class r5 = r3.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            r2.append(r8)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r5.getString(r1)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = r5.getString(r0)
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            r5 = r5 ^ r6
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r7 = r3.getLocalizedMessage()
            if (r7 == 0) goto L_0x00eb
            java.lang.String r3 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r3)
            goto L_0x00f2
        L_0x00eb:
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.afInfoLog(r3)
        L_0x00f2:
            r3 = r5
            goto L_0x00f6
        L_0x00f4:
            r8 = r3
            r3 = r7
        L_0x00f6:
            java.lang.Class r13 = r13.getClass()
            java.lang.String r13 = r13.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x0124
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r13.getString(r1)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r13 = r13.getString(r0)
            boolean r13 = java.lang.Boolean.parseBoolean(r13)
            r13 = r13 ^ r6
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
            java.lang.String r13 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r13)
        L_0x0124:
            int r13 = r2.length()
            if (r13 <= 0) goto L_0x0143
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r4)
            java.lang.String r4 = ": "
            r13.append(r4)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            java.lang.String r2 = "gaidError"
            r14.put(r2, r13)
        L_0x0143:
            if (r8 == 0) goto L_0x0176
            if (r3 == 0) goto L_0x0176
            r14.put(r1, r8)
            boolean r13 = r3.booleanValue()
            r13 = r13 ^ r6
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14.put(r0, r13)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            r13.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r3.booleanValue()
            r1 = r1 ^ r6
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r13.set((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r13 = "isGaidWithGps"
            java.lang.String r0 = java.lang.String.valueOf(r9)
            r14.put(r13, r0)
        L_0x0176:
            com.appsflyer.internal.AFc1oSDK$AFa1xSDK r13 = new com.appsflyer.internal.AFc1oSDK$AFa1xSDK
            r13.<init>(r8, r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(android.content.Context, java.util.Map):com.appsflyer.internal.AFc1oSDK$AFa1xSDK");
    }

    private static boolean valueOf() {
        Boolean bool = values;
        return bool == null || bool.booleanValue();
    }

    public final String values(Throwable th, String str) {
        String str2;
        AFc1uSDK AFInAppEventType;
        Throwable th2 = th;
        String str3 = str;
        m.f(th2, "");
        m.f(str3, "");
        synchronized (this) {
            try {
                File afRDLog = afRDLog();
                str2 = null;
                if (afRDLog != null) {
                    m.f(th2, "");
                    m.f(str3, "");
                    StringBuilder sb2 = new StringBuilder();
                    m.f(th2, "");
                    String name = th.getClass().getName();
                    m.e(name, "");
                    sb2.append(name);
                    sb2.append(": ");
                    sb2.append(str3);
                    String obj = sb2.toString();
                    m.f(th2, "");
                    m.f(th2, "");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(th2);
                    sb3.append(10);
                    sb3.append(r.f0(AFc1lSDK.AFKeystoreWrapper(th), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AFc1lSDK.AnonymousClass1.AFInAppEventParameterName, 30, (Object) null));
                    AFc1uSDK aFc1uSDK = new AFc1uSDK(obj, AFc1oSDK.AFa1xSDK.valueOf(sb3.toString()), b.b(th), 0, 8, (DefaultConstructorMarker) null);
                    String str4 = aFc1uSDK.AFInAppEventParameterName;
                    File file = new File(afRDLog, str4);
                    if (file.exists() && (AFInAppEventType = AFc1uSDK.AFa1xSDK.AFInAppEventType(h.e(file, (Charset) null, 1, (Object) null))) != null) {
                        AFInAppEventType.AFKeystoreWrapper++;
                        aFc1uSDK = AFInAppEventType;
                    }
                    StringBuilder sb4 = new StringBuilder("label=");
                    sb4.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.valueOf));
                    sb4.append("\nhashName=");
                    sb4.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.AFInAppEventParameterName));
                    sb4.append("\nstackTrace=");
                    sb4.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.values));
                    sb4.append("\nc=");
                    sb4.append(aFc1uSDK.AFKeystoreWrapper);
                    h.h(file, sb4.toString(), (Charset) null, 2, (Object) null);
                    str2 = str4;
                }
            } catch (Exception e10) {
                StringBuilder sb5 = new StringBuilder("Could not cache exception\n");
                StringBuilder sb6 = new StringBuilder(" ");
                sb6.append(e10.getMessage());
                String obj2 = sb6.toString();
                m.f(obj2, "");
                sb5.append("[Exception Manager]: ".concat(String.valueOf(obj2)));
                AFLogger.afRDLog(sb5.toString());
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return str2;
    }

    public final boolean values() {
        return AFInAppEventType(new String[0]);
    }
}
