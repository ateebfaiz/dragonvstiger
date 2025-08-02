package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 19)
public final class AFf1lSDK extends AFf1kSDK {
    final ProviderInfo AFInAppEventParameterName;
    private final AFc1vSDK AFKeystoreWrapper;

    public AFf1lSDK(ProviderInfo providerInfo, Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.AFKeystoreWrapper = aFc1vSDK;
        this.AFInAppEventParameterName = providerInfo;
    }

    public final void valueOf(final Context context) {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0075, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x007b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
                r0.release();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
                r0.release();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x007b;
             */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00dd  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r9 = this;
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    long r1 = java.lang.System.currentTimeMillis()
                    r0.afInfoLog = r1
                    com.appsflyer.internal.AFf1kSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.STARTED
                    r0.afRDLog = r1
                    com.appsflyer.internal.AFf1kSDK$2 r1 = new com.appsflyer.internal.AFf1kSDK$2
                    r1.<init>()
                    r0.addObserver(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "content://"
                    r0.<init>(r1)
                    com.appsflyer.internal.AFf1lSDK r1 = com.appsflyer.internal.AFf1lSDK.this
                    android.content.pm.ProviderInfo r1 = r1.AFInAppEventParameterName
                    java.lang.String r1 = r1.authority
                    r0.append(r1)
                    java.lang.String r1 = "/transaction_id"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    android.content.Context r0 = r2
                    android.content.ContentResolver r0 = r0.getContentResolver()
                    android.content.ContentProviderClient r0 = r0.acquireUnstableContentProviderClient(r2)
                    if (r0 == 0) goto L_0x0095
                    r7 = 0
                    r8 = 24
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    java.lang.String r3 = "app_id="
                    r1.<init>(r3)     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    android.content.Context r3 = r2     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    java.lang.String r3 = r3.getPackageName()     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    r1.append(r3)     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    java.lang.String r4 = r1.toString()     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    r5 = 0
                    r6 = 0
                    r3 = 0
                    r1 = r0
                    android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ DeadObjectException -> 0x006c, RemoteException -> 0x006a }
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r8) goto L_0x0064
                    r0.release()
                    goto L_0x0096
                L_0x0064:
                    r0.release()
                    goto L_0x0096
                L_0x0068:
                    r1 = move-exception
                    goto L_0x0089
                L_0x006a:
                    r1 = move-exception
                    goto L_0x006e
                L_0x006c:
                    r1 = move-exception
                    goto L_0x007f
                L_0x006e:
                    java.lang.String r2 = "[Preinstall]: Failed to query unstable content providerClient"
                    com.appsflyer.AFLogger.afErrorLog(r2, r1, r7)     // Catch:{ all -> 0x0068 }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r8) goto L_0x007b
                L_0x0077:
                    r0.release()
                    goto L_0x0095
                L_0x007b:
                    r0.release()
                    goto L_0x0095
                L_0x007f:
                    java.lang.String r2 = "[Preinstall]: Failed to acquire unstable content providerClient"
                    com.appsflyer.AFLogger.afErrorLog(r2, r1, r7)     // Catch:{ all -> 0x0068 }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r8) goto L_0x007b
                    goto L_0x0077
                L_0x0089:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r8) goto L_0x0091
                    r0.release()
                    goto L_0x0094
                L_0x0091:
                    r0.release()
                L_0x0094:
                    throw r1
                L_0x0095:
                    r1 = 0
                L_0x0096:
                    java.lang.String r0 = "response"
                    if (r1 == 0) goto L_0x00dd
                    java.lang.String r2 = "transaction_id"
                    int r2 = r1.getColumnIndex(r2)
                    r3 = -1
                    if (r2 != r3) goto L_0x00b2
                    java.lang.String r2 = "[Preinstall]: Wrong column name"
                    com.appsflyer.AFLogger.afWarnLog(r2)
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
                    java.lang.String r3 = "FEATURE_NOT_SUPPORTED"
                    r2.put(r0, r3)
                    goto L_0x00d9
                L_0x00b2:
                    com.appsflyer.internal.AFf1lSDK r3 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    java.lang.String r4 = "OK"
                    r3.put(r0, r4)
                    boolean r0 = r1.moveToFirst()
                    if (r0 == 0) goto L_0x00d9
                    java.lang.String r0 = r1.getString(r2)
                    r1.close()
                    if (r0 == 0) goto L_0x00d9
                    boolean r2 = r0.isEmpty()
                    if (r2 != 0) goto L_0x00d9
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
                    java.lang.String r3 = "referrer"
                    r2.put(r3, r0)
                L_0x00d9:
                    r1.close()
                    goto L_0x00eb
                L_0x00dd:
                    java.lang.String r1 = "[Preinstall]: ContentProvider query failed, got null Cursor"
                    com.appsflyer.AFLogger.afWarnLog(r1)
                    com.appsflyer.internal.AFf1lSDK r1 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFInAppEventType
                    java.lang.String r2 = "SERVICE_UNAVAILABLE"
                    r1.put(r0, r2)
                L_0x00eb:
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.AFInAppEventType
                    android.content.Context r2 = r2
                    android.content.pm.ProviderInfo r0 = r0.AFInAppEventParameterName
                    java.lang.String r0 = r0.packageName
                    long r2 = com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper(r2, r0)
                    java.lang.Long r0 = java.lang.Long.valueOf(r2)
                    java.lang.String r2 = "api_ver"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.AFInAppEventType
                    android.content.Context r2 = r2
                    android.content.pm.ProviderInfo r0 = r0.AFInAppEventParameterName
                    java.lang.String r0 = r0.packageName
                    java.lang.String r0 = com.appsflyer.internal.AFa1cSDK.values((android.content.Context) r2, (java.lang.String) r0)
                    java.lang.String r2 = "api_ver_name"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    r0.AFInAppEventType()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1lSDK.AnonymousClass4.run():void");
            }
        });
    }
}
