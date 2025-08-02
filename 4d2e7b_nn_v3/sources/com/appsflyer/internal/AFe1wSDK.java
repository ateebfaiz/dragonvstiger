package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

public final class AFe1wSDK extends AFd1pSDK<AFe1vSDK> {
    public AFb1cSDK AFLogger;
    private final AFe1sSDK AFLogger$LogLevel;
    private final AFe1qSDK AFVersionDeclaration;
    private final AFc1zSDK afDebugLog;
    @Nullable
    public final AFe1xSDK afErrorLog;
    private final String afErrorLogForExcManagerOnly;
    private final AFe1ySDK afInfoLog;
    @Nullable
    public AFe1vSDK afRDLog = null;
    private final AFc1kSDK afWarnLog;
    private final AFe1nSDK getLevel;

    public AFe1wSDK(@NonNull AFe1ySDK aFe1ySDK, @NonNull AFc1zSDK aFc1zSDK, @NonNull AFe1nSDK aFe1nSDK, @NonNull AFe1qSDK aFe1qSDK, @NonNull AFc1kSDK aFc1kSDK, @NonNull AFe1sSDK aFe1sSDK, @NonNull String str, @Nullable AFe1xSDK aFe1xSDK) {
        super(AFd1rSDK.RC_CDN, new AFd1rSDK[0], "UpdateRemoteConfiguration");
        this.afInfoLog = aFe1ySDK;
        this.afDebugLog = aFc1zSDK;
        this.getLevel = aFe1nSDK;
        this.AFVersionDeclaration = aFe1qSDK;
        this.afWarnLog = aFc1kSDK;
        this.AFLogger$LogLevel = aFe1sSDK;
        this.afErrorLogForExcManagerOnly = str;
        this.afErrorLog = aFe1xSDK;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e A[SYNTHETIC, Splitter:B:12:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appsflyer.internal.AFe1vSDK AFLogger() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            r16 = this;
            r10 = r16
            java.lang.String r0 = " seconds"
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r1 = r10.afErrorLogForExcManagerOnly
            com.appsflyer.internal.AFe1nSDK r2 = r10.getLevel
            java.lang.String r2 = r2.values
            java.lang.String r3 = "CFG: Dev key is not set, SDK is not started."
            if (r2 == 0) goto L_0x0040
            java.lang.String r4 = r2.trim()
            int r4 = r4.length()
            if (r4 != 0) goto L_0x001d
            goto L_0x0040
        L_0x001d:
            if (r1 != 0) goto L_0x0026
            java.lang.String r1 = "CFG: Can't create CDN token, domain or version is not provided."
            com.appsflyer.AFLogger.afWarnLog(r1)
        L_0x0024:
            r12 = 0
            goto L_0x0044
        L_0x0026:
            com.appsflyer.internal.AFc1zSDK r4 = r10.afDebugLog
            com.appsflyer.internal.AFc1sSDK r4 = r4.AFKeystoreWrapper
            android.content.Context r4 = r4.AFKeystoreWrapper
            java.lang.String r4 = r4.getPackageName()
            java.lang.String r5 = "appsflyersdk.com"
            java.lang.String[] r1 = new java.lang.String[]{r5, r1, r4}
            java.lang.String r1 = com.appsflyer.internal.AFb1ySDK.valueOf(r1)
            java.lang.String r1 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(r1, r2)
            r12 = r1
            goto L_0x0044
        L_0x0040:
            com.appsflyer.AFLogger.afWarnLog(r3)
            goto L_0x0024
        L_0x0044:
            if (r12 != 0) goto L_0x004e
            java.lang.String r0 = "CFG: can't create CDN token, skipping fetch config"
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE
            return r0
        L_0x004e:
            com.appsflyer.internal.AFe1sSDK r1 = r10.AFLogger$LogLevel     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            boolean r1 = r1.valueOf()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            if (r1 == 0) goto L_0x0151
            java.lang.String r1 = "CFG: Cached config is expired, updating..."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1sSDK r1 = r10.AFLogger$LogLevel     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            boolean r1 = r1.AFInAppEventType()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1sSDK r2 = r10.AFLogger$LogLevel     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            boolean r2 = r2.values()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFc1kSDK r4 = r10.afWarnLog     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5 = 1500(0x5dc, float:2.102E-42)
            com.appsflyer.internal.AFc1jSDK r1 = r4.AFInAppEventParameterName(r1, r2, r12, r5)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFd1zSDK r15 = r1.AFInAppEventParameterName()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            boolean r1 = r15.isSuccessful()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            if (r1 == 0) goto L_0x012f
            java.lang.Object r1 = r15.getBody()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFb1iSDK r1 = (com.appsflyer.internal.AFb1iSDK) r1     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r2 = "x-amz-meta-af-auth-v1"
            java.lang.String r2 = r15.values(r2)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r4 = "CF-Cache-Status"
            java.lang.String r6 = r15.values(r4)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1nSDK r4 = r10.getLevel     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r4 = r4.values     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            if (r4 == 0) goto L_0x0129
            java.lang.String r5 = r4.trim()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            int r5 = r5.length()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            if (r5 != 0) goto L_0x009d
            goto L_0x0129
        L_0x009d:
            com.appsflyer.internal.AFe1ySDK r3 = r10.afInfoLog     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1tSDK r2 = r3.valueOf(r1, r2, r12, r4)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            boolean r3 = r2.valueOf()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            if (r3 == 0) goto L_0x0117
            com.appsflyer.internal.AFe1sSDK r3 = r10.AFLogger$LogLevel     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            long r3 = r3.AFKeystoreWrapper()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r7 = "CFG: using max-age fallback: "
            r5.<init>(r7)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5.append(r3)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5.append(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.AFLogger.afRDLog(r5)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1qSDK r5 = r10.AFVersionDeclaration     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r7 = r1.values     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.nio.charset.Charset r11 = com.appsflyer.internal.AFe1qSDK.AFInAppEventType     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            byte[] r7 = r7.getBytes(r11)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r11 = 2
            java.lang.String r7 = android.util.Base64.encodeToString(r7, r11)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFc1ySDK r11 = r5.AFInAppEventParameterName     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = "af_remote_config"
            r11.valueOf(r10, r7)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFc1ySDK r7 = r5.AFInAppEventParameterName     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = "af_rc_timestamp"
            r7.AFInAppEventType((java.lang.String) r10, (long) r13)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFc1ySDK r7 = r5.AFInAppEventParameterName     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = "af_rc_max_age"
            r7.AFInAppEventType((java.lang.String) r10, (long) r3)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5.valueOf = r1     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5.AFKeystoreWrapper = r13     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r5.values = r3     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r5 = "CFG: Config successfully updated, timeToLive: "
            r1.<init>(r5)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r1.append(r3)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r1.append(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFf1tSDK r5 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r1 = r16
            r2 = r12
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.SUCCESS     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            return r0
        L_0x0112:
            r0 = move-exception
            goto L_0x0159
        L_0x0114:
            r0 = move-exception
            goto L_0x018f
        L_0x0117:
            com.appsflyer.internal.AFf1tSDK r5 = r2.AFInAppEventType     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r1 = r16
            r2 = r12
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r0 = "CFG: fetched config is not valid (MITM?) refuse to use it."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            return r0
        L_0x0129:
            com.appsflyer.AFLogger.afWarnLog(r3)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            return r0
        L_0x012f:
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r12
            r3 = r8
            r7 = r15
            r1.values(r2, r3, r5, r6, r7)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r1 = "CFG: failed to fetch remote config from CDN with status code: "
            r0.<init>(r1)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            int r1 = r15.getStatusCode()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            r0.append(r1)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            return r0
        L_0x0151:
            java.lang.String r0 = "CFG: active config is valid, skipping fetch"
            com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.USE_CACHED     // Catch:{ IOException -> 0x0114, all -> 0x0112 }
            return r0
        L_0x0159:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to update remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            r7 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r12
            r3 = r8
            r8 = r10
            r9 = r0
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.lang.InterruptedException
            if (r1 != 0) goto L_0x0188
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE
            return r0
        L_0x0188:
            java.lang.Throwable r0 = r0.getCause()
            java.lang.InterruptedException r0 = (java.lang.InterruptedException) r0
            throw r0
        L_0x018f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CFG: failed to fetch remote config: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r3 = 0
            com.appsflyer.AFLogger.afErrorLog(r1, r0, r2, r3, r3)
            boolean r1 = r0 instanceof com.appsflyer.internal.components.network.http.exceptions.ParsingException
            if (r1 == 0) goto L_0x01b3
            r1 = r0
            com.appsflyer.internal.components.network.http.exceptions.ParsingException r1 = (com.appsflyer.internal.components.network.http.exceptions.ParsingException) r1
            com.appsflyer.internal.AFd1zSDK r1 = r1.getRawResponse()
            r5 = r1
            goto L_0x01b4
        L_0x01b3:
            r5 = 0
        L_0x01b4:
            r7 = 0
            r10 = 0
            r6 = 0
            r1 = r16
            r2 = r12
            r3 = r8
            r8 = r10
            r9 = r0
            r1.AFInAppEventType(r2, r3, r5, r6, r7, r8, r9)
            java.lang.Throwable r1 = r0.getCause()
            boolean r1 = r1 instanceof java.io.InterruptedIOException
            if (r1 != 0) goto L_0x01cb
            com.appsflyer.internal.AFe1vSDK r0 = com.appsflyer.internal.AFe1vSDK.FAILURE
            return r0
        L_0x01cb:
            java.lang.Throwable r0 = r0.getCause()
            java.io.InterruptedIOException r0 = (java.io.InterruptedIOException) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1wSDK.AFLogger():com.appsflyer.internal.AFe1vSDK");
    }

    private void values(String str, long j10, AFf1tSDK aFf1tSDK, @Nullable String str2, @Nullable AFd1zSDK<AFb1iSDK> aFd1zSDK) {
        AFb1iSDK aFb1iSDK;
        String str3;
        if (aFd1zSDK != null) {
            aFb1iSDK = aFd1zSDK.getBody();
        } else {
            aFb1iSDK = null;
        }
        if (str2 != null) {
            str3 = str2;
        } else {
            str3 = null;
        }
        AFInAppEventType(str, j10, aFd1zSDK, aFb1iSDK, aFf1tSDK, str3, (Throwable) null);
    }

    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        try {
            AFe1vSDK AFLogger2 = AFLogger();
            this.afRDLog = AFLogger2;
            if (AFLogger2 == AFe1vSDK.FAILURE) {
                return AFd1tSDK.FAILURE;
            }
            return AFd1tSDK.SUCCESS;
        } catch (InterruptedIOException | InterruptedException e10) {
            AFLogger.afErrorLogForExcManagerOnly("RC update config failed", e10);
            this.afRDLog = AFe1vSDK.FAILURE;
            return AFd1tSDK.TIMEOUT;
        }
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    public final long valueOf() {
        return 1500;
    }

    private void AFInAppEventType(String str, long j10, @Nullable AFd1zSDK<?> aFd1zSDK, AFb1iSDK aFb1iSDK, AFf1tSDK aFf1tSDK, @Nullable String str2, @Nullable Throwable th) {
        long j11;
        int i10;
        Throwable th2;
        long j12;
        AFd1zSDK<?> aFd1zSDK2 = aFd1zSDK;
        AFb1iSDK aFb1iSDK2 = aFb1iSDK;
        Throwable th3 = th;
        if (aFd1zSDK2 != null) {
            j11 = aFd1zSDK2.valueOf.AFInAppEventType;
            i10 = aFd1zSDK.getStatusCode();
        } else {
            j11 = 0;
            i10 = 0;
        }
        int i11 = i10;
        if (th3 instanceof HttpException) {
            th2 = th.getCause();
            j12 = ((HttpException) th3).getMetrics().AFInAppEventType;
        } else {
            th2 = th3;
            j12 = j11;
        }
        this.AFLogger = new AFb1cSDK(aFb1iSDK2 != null ? aFb1iSDK2.AFInAppEventParameterName : null, str, j12, System.currentTimeMillis() - j10, i11, aFf1tSDK, str2, th2);
    }
}
