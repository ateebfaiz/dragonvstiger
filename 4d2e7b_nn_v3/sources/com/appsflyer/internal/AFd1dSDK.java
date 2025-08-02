package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.os.Build;
import android.os.Process;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.alibaba.pdns.DNSResolver;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1oSDK;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

public final class AFd1dSDK extends AFe1zSDK {
    private static int AFVersionDeclaration = 0;
    private static int AppsFlyer2dXConversionCallback = 1;
    private static int getLevel = 120;
    private final String AFLogger$LogLevel;
    private final AFc1sSDK afErrorLogForExcManagerOnly;

    public AFd1dSDK(@NonNull String str, @NonNull AFc1vSDK aFc1vSDK) {
        super(new AFe1kSDK(aFc1vSDK.AFLogger$LogLevel().AFKeystoreWrapper), aFc1vSDK, str);
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFLogger$LogLevel();
        this.AFLogger$LogLevel = str;
    }

    private void AFLogger$LogLevel() {
        AFc1ySDK aFc1ySDK;
        boolean z10;
        int i10 = AFVersionDeclaration + 67;
        AppsFlyer2dXConversionCallback = i10 % 128;
        if (i10 % 2 == 0) {
            aFc1ySDK = this.afWarnLog;
            z10 = false;
        } else {
            aFc1ySDK = this.afWarnLog;
            z10 = true;
        }
        aFc1ySDK.AFInAppEventType("sentRegisterRequestToAF", z10);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        int i10 = AppsFlyer2dXConversionCallback + DNSResolver.GOBACK_LOCAL;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            return true;
        }
        return false;
    }

    public final void values() {
        super.values();
        AFd1zSDK<Result> aFd1zSDK = this.afErrorLog;
        if (aFd1zSDK != null) {
            AppsFlyer2dXConversionCallback = (AFVersionDeclaration + 81) % 128;
            if (aFd1zSDK.isSuccessful()) {
                int i10 = AFVersionDeclaration + 13;
                AppsFlyer2dXConversionCallback = i10 % 128;
                int i11 = i10 % 2;
                AFLogger$LogLevel();
                if (i11 != 0) {
                    AppsFlyer2dXConversionCallback = (AFVersionDeclaration + 53) % 128;
                    return;
                }
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void values(AFa1sSDK aFa1sSDK) {
        super.values(aFa1sSDK);
        Context context = this.afErrorLogForExcManagerOnly.AFKeystoreWrapper;
        AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
        if (context == null) {
            throw new IllegalStateException("Context is not provided, can't send register request");
        } else if (!AFInAppEventType.valueOf()) {
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                aFa1sSDK.AFKeystoreWrapper("app_version_code", Integer.toString(packageInfo.versionCode));
                aFa1sSDK.AFKeystoreWrapper("app_version_name", packageInfo.versionName);
                aFa1sSDK.AFKeystoreWrapper("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                aFa1sSDK.AFKeystoreWrapper("installDate", AFb1xSDK.AFInAppEventType(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while collecting application version info.", th);
            }
            AFInAppEventType.AFInAppEventType(context, (Map<String, ? super String>) aFa1sSDK.AFKeystoreWrapper());
            String values = AFb1xSDK.values();
            if (values != null) {
                aFa1sSDK.AFKeystoreWrapper("appUserId", values);
                AFVersionDeclaration = (AppsFlyer2dXConversionCallback + 113) % 128;
            }
            try {
                aFa1sSDK.AFKeystoreWrapper("model", Build.MODEL);
                Object[] objArr = new Object[1];
                values("￻�\u0007￺\u000b", true, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 222 - ImageFormat.getBitsPerPixel(0), 6 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), objArr);
                aFa1sSDK.AFKeystoreWrapper(((String) objArr[0]).intern(), Build.BRAND);
            } catch (Throwable th2) {
                AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
            }
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                aFa1sSDK.AFKeystoreWrapper(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
            AFc1oSDK.AFa1xSDK values2 = AFa1bSDK.values(context.getContentResolver());
            if (values2 != null) {
                int i10 = AppsFlyer2dXConversionCallback + 45;
                AFVersionDeclaration = i10 % 128;
                if (i10 % 2 != 0) {
                    aFa1sSDK.AFKeystoreWrapper("amazon_aid", values2.AFInAppEventParameterName);
                    aFa1sSDK.AFKeystoreWrapper("amazon_aid_limit", String.valueOf(values2.valueOf));
                    int i11 = 84 / 0;
                } else {
                    aFa1sSDK.AFKeystoreWrapper("amazon_aid", values2.AFInAppEventParameterName);
                    aFa1sSDK.AFKeystoreWrapper("amazon_aid_limit", String.valueOf(values2.valueOf));
                }
            }
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if (string != null) {
                aFa1sSDK.AFKeystoreWrapper("advertiserId", string);
            }
            aFa1sSDK.AFKeystoreWrapper("devkey", this.afDebugLog.values);
            aFa1sSDK.AFKeystoreWrapper("uid", AFb1wSDK.AFKeystoreWrapper(new WeakReference(context)));
            aFa1sSDK.AFKeystoreWrapper("af_gcm_token", this.AFLogger$LogLevel);
            aFa1sSDK.AFKeystoreWrapper("launch_counter", Integer.toString(this.afWarnLog.AFInAppEventType("appsFlyerCount", 0)));
            aFa1sSDK.AFKeystoreWrapper("sdk", Integer.toString(Build.VERSION.SDK_INT));
            String AFInAppEventParameterName = AFInAppEventType.AFInAppEventParameterName(context);
            if (AFInAppEventParameterName != null) {
                aFa1sSDK.AFKeystoreWrapper(AppsFlyerProperties.CHANNEL, AFInAppEventParameterName);
                AFVersionDeclaration = (AppsFlyer2dXConversionCallback + 105) % 128;
            }
        } else {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            throw new IllegalStateException("CustomerUserId not set, register is not sent");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void values(java.lang.String r6, boolean r7, int r8, int r9, int r10, java.lang.Object[] r11) {
        /*
            if (r6 == 0) goto L_0x0006
            char[] r6 = r6.toCharArray()
        L_0x0006:
            char[] r6 = (char[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFg1pSDK.values
            monitor-enter(r0)
            char[] r1 = new char[r10]     // Catch:{ all -> 0x002f }
            r2 = 0
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch:{ all -> 0x002f }
        L_0x0010:
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
            if (r3 >= r10) goto L_0x0031
            char r3 = r6[r3]     // Catch:{ all -> 0x002f }
            com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper = r3     // Catch:{ all -> 0x002f }
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
            int r4 = com.appsflyer.internal.AFg1pSDK.AFKeystoreWrapper     // Catch:{ all -> 0x002f }
            int r4 = r4 + r9
            char r4 = (char) r4     // Catch:{ all -> 0x002f }
            r1[r3] = r4     // Catch:{ all -> 0x002f }
            int r3 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
            char r4 = r1[r3]     // Catch:{ all -> 0x002f }
            int r5 = getLevel     // Catch:{ all -> 0x002f }
            int r4 = r4 - r5
            char r4 = (char) r4     // Catch:{ all -> 0x002f }
            r1[r3] = r4     // Catch:{ all -> 0x002f }
            int r3 = r3 + 1
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r3     // Catch:{ all -> 0x002f }
            goto L_0x0010
        L_0x002f:
            r6 = move-exception
            goto L_0x0069
        L_0x0031:
            if (r8 <= 0) goto L_0x0048
            com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName = r8     // Catch:{ all -> 0x002f }
            char[] r6 = new char[r10]     // Catch:{ all -> 0x002f }
            java.lang.System.arraycopy(r1, r2, r6, r2, r10)     // Catch:{ all -> 0x002f }
            int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002f }
            int r9 = r10 - r8
            java.lang.System.arraycopy(r6, r2, r1, r9, r8)     // Catch:{ all -> 0x002f }
            int r8 = com.appsflyer.internal.AFg1pSDK.AFInAppEventParameterName     // Catch:{ all -> 0x002f }
            int r9 = r10 - r8
            java.lang.System.arraycopy(r6, r8, r1, r2, r9)     // Catch:{ all -> 0x002f }
        L_0x0048:
            if (r7 == 0) goto L_0x0060
            char[] r6 = new char[r10]     // Catch:{ all -> 0x002f }
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r2     // Catch:{ all -> 0x002f }
        L_0x004e:
            int r7 = com.appsflyer.internal.AFg1pSDK.AFInAppEventType     // Catch:{ all -> 0x002f }
            if (r7 >= r10) goto L_0x005f
            int r8 = r10 - r7
            int r8 = r8 + -1
            char r8 = r1[r8]     // Catch:{ all -> 0x002f }
            r6[r7] = r8     // Catch:{ all -> 0x002f }
            int r7 = r7 + 1
            com.appsflyer.internal.AFg1pSDK.AFInAppEventType = r7     // Catch:{ all -> 0x002f }
            goto L_0x004e
        L_0x005f:
            r1 = r6
        L_0x0060:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x002f }
            r6.<init>(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            r11[r2] = r6
            return
        L_0x0069:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1dSDK.values(java.lang.String, boolean, int, int, int, java.lang.Object[]):void");
    }
}
