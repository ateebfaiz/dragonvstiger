package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

public final class AFf1mSDK extends AFf1oSDK {
    private final AFc1vSDK AFKeystoreWrapper;

    public AFf1mSDK(Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("store", "huawei", runnable);
        this.AFKeystoreWrapper = aFc1vSDK;
    }

    public final void valueOf(Context context) {
        AFInAppEventType(context, new AFb1jSDK<Map<String, Object>>(context, this.AFKeystoreWrapper, "com.huawei.appmarket.commondata", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F") {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x00fd, code lost:
                if (r2 != null) goto L_0x00ff;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ff, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0111, code lost:
                if (r2 == null) goto L_0x0114;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0114, code lost:
                r10.AFInAppEventParameterName.AFInAppEventType();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x011d, code lost:
                return r10.AFInAppEventParameterName.AFInAppEventType;
             */
            /* renamed from: AFKeystoreWrapper */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.Object> values() {
                /*
                    r10 = this;
                    java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                    java.lang.String r1 = "response"
                    android.content.Context r2 = r10.values
                    android.content.pm.PackageManager r2 = r2.getPackageManager()
                    java.lang.String r3 = r10.AFInAppEventType
                    r4 = 128(0x80, float:1.794E-43)
                    android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r3, r4)
                    java.lang.String r2 = r2.packageName
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    android.content.Context r4 = r10.values
                    long r4 = com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper(r4, r2)
                    java.lang.Long r4 = java.lang.Long.valueOf(r4)
                    java.lang.String r5 = "api_ver"
                    r3.put(r5, r4)
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    android.content.Context r4 = r10.values
                    java.lang.String r2 = com.appsflyer.internal.AFa1cSDK.values((android.content.Context) r4, (java.lang.String) r2)
                    java.lang.String r4 = "api_ver_name"
                    r3.put(r4, r2)
                    r2 = 0
                    android.content.Context r3 = r10.values     // Catch:{ Exception -> 0x00d6 }
                    android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x00d6 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r5 = "content://"
                    r3.<init>(r5)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r5 = r10.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    r3.append(r5)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r5 = "/item/5"
                    r3.append(r5)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d6 }
                    android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00d6 }
                    android.content.Context r3 = r10.values     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x00d6 }
                    r9 = 0
                    r6 = 0
                    r7 = 0
                    android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00d6 }
                    if (r2 == 0) goto L_0x00f4
                    boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x00d6 }
                    if (r3 == 0) goto L_0x00ec
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r4 = "OK"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x00d6 }
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r4 = "referrer"
                    r5 = 0
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00d6 }
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r4 = "click_ts"
                    r5 = 1
                    long r5 = r2.getLong(r5)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00d6 }
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r4 = "install_end_ts"
                    r5 = 2
                    long r5 = r2.getLong(r5)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00d6 }
                    int r3 = r2.getColumnCount()     // Catch:{ Exception -> 0x00d6 }
                    r4 = 3
                    if (r3 <= r4) goto L_0x00fd
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r5 = "install_begin_ts"
                    long r6 = r2.getLong(r4)     // Catch:{ Exception -> 0x00d6 }
                    java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00d6 }
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x00d6 }
                    r3.<init>()     // Catch:{ Exception -> 0x00d6 }
                    r4 = 4
                    java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x00d6 }
                    if (r4 == 0) goto L_0x00d8
                    java.lang.String r5 = "track_id"
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x00d6 }
                    goto L_0x00d8
                L_0x00d4:
                    r0 = move-exception
                    goto L_0x011e
                L_0x00d6:
                    r3 = move-exception
                    goto L_0x0103
                L_0x00d8:
                    java.lang.String r4 = "referrer_ex"
                    r5 = 5
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x00d6 }
                    com.appsflyer.internal.AFf1mSDK r4 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r5 = "huawei_custom"
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x00d6 }
                    goto L_0x00fd
                L_0x00ec:
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    r3.put(r1, r0)     // Catch:{ Exception -> 0x00d6 }
                    goto L_0x00fd
                L_0x00f4:
                    com.appsflyer.internal.AFf1mSDK r3 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ Exception -> 0x00d6 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x00d6 }
                    java.lang.String r4 = "SERVICE_UNAVAILABLE"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x00d6 }
                L_0x00fd:
                    if (r2 == 0) goto L_0x0114
                L_0x00ff:
                    r2.close()
                    goto L_0x0114
                L_0x0103:
                    com.appsflyer.internal.AFf1mSDK r4 = com.appsflyer.internal.AFf1mSDK.this     // Catch:{ all -> 0x00d4 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ all -> 0x00d4 }
                    r4.put(r1, r0)     // Catch:{ all -> 0x00d4 }
                    java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x00d4 }
                    com.appsflyer.AFLogger.afErrorLog(r0, r3)     // Catch:{ all -> 0x00d4 }
                    if (r2 == 0) goto L_0x0114
                    goto L_0x00ff
                L_0x0114:
                    com.appsflyer.internal.AFf1mSDK r0 = com.appsflyer.internal.AFf1mSDK.this
                    r0.AFInAppEventType()
                    com.appsflyer.internal.AFf1mSDK r0 = com.appsflyer.internal.AFf1mSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFInAppEventType
                    return r0
                L_0x011e:
                    if (r2 == 0) goto L_0x0123
                    r2.close()
                L_0x0123:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1mSDK.AnonymousClass2.values():java.util.Map");
            }
        });
    }
}
