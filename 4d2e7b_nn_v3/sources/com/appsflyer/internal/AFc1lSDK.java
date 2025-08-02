package com.appsflyer.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class AFc1lSDK implements AFb1zSDK {
    private final AFc1sSDK valueOf;

    AFc1lSDK() {
    }

    public static Map<String, String> AFInAppEventType(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put("size", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't aggregate screen stats: ", th);
        }
        return hashMap;
    }

    public static final List<StackTraceElement> AFKeystoreWrapper(Throwable th) {
        m.f(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        m.e(stackTrace, "");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            m.e(className, "");
            if (!j.F(className, "com.appsflyer", false, 2, (Object) null)) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041 A[SYNTHETIC, Splitter:B:26:0x0041] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.internal.AFa1oSDK valueOf(java.io.File r5) {
        /*
            java.lang.String r0 = "could not close load reader"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x002d, all -> 0x002b }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002d, all -> 0x002b }
            long r3 = r5.length()     // Catch:{ Exception -> 0x0029 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x0029 }
            char[] r3 = new char[r3]     // Catch:{ Exception -> 0x0029 }
            r2.read(r3)     // Catch:{ Exception -> 0x0029 }
            com.appsflyer.internal.AFa1oSDK r4 = new com.appsflyer.internal.AFa1oSDK     // Catch:{ Exception -> 0x0029 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0029 }
            r4.AFInAppEventType = r5     // Catch:{ Exception -> 0x0029 }
            r2.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x0025:
            return r4
        L_0x0026:
            r5 = move-exception
            r1 = r2
            goto L_0x003f
        L_0x0029:
            r5 = move-exception
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            goto L_0x003f
        L_0x002d:
            r5 = move-exception
            r2 = r1
        L_0x002f:
            java.lang.String r3 = "error while loading request from cache"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r5)     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x003e:
            return r1
        L_0x003f:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x0049:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.valueOf(java.io.File):com.appsflyer.internal.AFa1oSDK");
    }

    @WorkerThread
    public final void values() {
        try {
            File file = new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    StringBuilder sb2 = new StringBuilder("CACHE: Found cached request");
                    sb2.append(file2.getName());
                    AFLogger.afInfoLog(sb2.toString());
                    StringBuilder sb3 = new StringBuilder("CACHE: Deleting ");
                    sb3.append(file2.getName());
                    sb3.append(" from cache");
                    AFLogger.afInfoLog(sb3.toString());
                    file2.delete();
                }
            }
        } catch (Exception e10) {
            AFLogger.afErrorLog("CACHE: Could not cache request", e10);
        }
    }

    public AFc1lSDK(AFc1sSDK aFc1sSDK) {
        this.valueOf = aFc1sSDK;
    }

    @WorkerThread
    @NonNull
    public final List<AFa1oSDK> AFKeystoreWrapper() {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (File file2 : listFiles) {
                StringBuilder sb2 = new StringBuilder("CACHE: Found cached request");
                sb2.append(file2.getName());
                AFLogger.afInfoLog(sb2.toString());
                arrayList.add(valueOf(file2));
            }
            return arrayList;
        } catch (Exception e10) {
            AFLogger.afErrorLog("CACHE: Could not get cached requests", e10);
        }
    }

    @WorkerThread
    public final void AFInAppEventType() {
        try {
            if (!new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").exists()) {
                new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").mkdir();
            }
        } catch (Exception e10) {
            AFLogger.afErrorLog("CACHE: Could not create cache directory", e10);
        }
    }

    @WorkerThread
    public final boolean AFKeystoreWrapper(String str) {
        File file = new File(new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb2 = new StringBuilder("CACHE: Deleting ");
        sb2.append(str);
        sb2.append(" from cache");
        AFLogger.afInfoLog(sb2.toString());
        if (!file.exists()) {
            return true;
        }
        try {
            return file.delete();
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder("CACHE: Could not delete ");
            sb3.append(str);
            sb3.append(" from cache");
            AFLogger.afErrorLog(sb3.toString(), e10);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00dc A[SYNTHETIC, Splitter:B:36:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e7 A[SYNTHETIC, Splitter:B:42:0x00e7] */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFInAppEventType(com.appsflyer.internal.AFa1oSDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AFRequestCache"
            java.lang.String r1 = "could not close cache writer"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            com.appsflyer.internal.AFc1sSDK r4 = r7.valueOf     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            android.content.Context r4 = r4.AFKeystoreWrapper     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r3.<init>(r4, r0)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            if (r4 != 0) goto L_0x0023
            r3.mkdir()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            return r2
        L_0x001c:
            r8 = move-exception
            goto L_0x00e5
        L_0x001f:
            r8 = move-exception
            r0 = r2
            goto L_0x00d5
        L_0x0023:
            java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            if (r3 == 0) goto L_0x0034
            int r3 = r3.length     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r4 = 40
            if (r3 <= r4) goto L_0x0034
            java.lang.String r8 = "CACHE: reached cache limit, not caching request"
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            return r2
        L_0x0034:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r4 = "CACHE: caching request with URL: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r4 = r8.values     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r3.append(r4)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            com.appsflyer.internal.AFc1sSDK r6 = r7.valueOf     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            android.content.Context r6 = r6.AFKeystoreWrapper     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r4.createNewFile()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r6 = 1
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r0.<init>(r5)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            java.lang.String r4 = "version="
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r4 = r8.AFInAppEventParameterName     // Catch:{ Exception -> 0x00ba }
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            r4 = 10
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "url="
            r0.write(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = r8.values     // Catch:{ Exception -> 0x00ba }
            r0.write(r5)     // Catch:{ Exception -> 0x00ba }
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r5 = "data="
            r0.write(r5)     // Catch:{ Exception -> 0x00ba }
            byte[] r5 = r8.valueOf()     // Catch:{ Exception -> 0x00ba }
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch:{ Exception -> 0x00ba }
            r0.write(r5)     // Catch:{ Exception -> 0x00ba }
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            com.appsflyer.internal.AFd1rSDK r8 = r8.valueOf     // Catch:{ Exception -> 0x00ba }
            if (r8 == 0) goto L_0x00bc
            java.lang.String r5 = "type="
            r0.write(r5)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x00ba }
            r0.write(r8)     // Catch:{ Exception -> 0x00ba }
            r0.write(r4)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00bc
        L_0x00b7:
            r8 = move-exception
            r2 = r0
            goto L_0x00e5
        L_0x00ba:
            r8 = move-exception
            goto L_0x00d5
        L_0x00bc:
            r0.flush()     // Catch:{ Exception -> 0x00ba }
            java.lang.String r8 = "CACHE: done, cacheKey: "
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r8 = r8.concat(r4)     // Catch:{ Exception -> 0x00ba }
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x00ba }
            r0.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00d4:
            return r3
        L_0x00d5:
            java.lang.String r3 = "CACHE: Could not cache request"
            com.appsflyer.AFLogger.afErrorLog(r3, r8)     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00e4
            r0.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r2 == 0) goto L_0x00ef
            r2.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ef
        L_0x00eb:
            r0 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
        L_0x00ef:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.AFInAppEventType(com.appsflyer.internal.AFa1oSDK):java.lang.String");
    }
}
