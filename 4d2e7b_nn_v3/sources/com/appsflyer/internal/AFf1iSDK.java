package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import com.adjust.sdk.Constants;
import java.util.Map;

public final class AFf1iSDK extends AFf1oSDK {
    private final AFc1vSDK AFInAppEventParameterName;

    public AFf1iSDK(Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("store", Constants.REFERRER_API_SAMSUNG, runnable);
        this.AFInAppEventParameterName = aFc1vSDK;
    }

    public final void valueOf(Context context) {
        AFInAppEventType(context, new AFb1jSDK<Map<String, Object>>(context, this.AFInAppEventParameterName, "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") {
            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c3, code lost:
                if (r2 != null) goto L_0x00c5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c5, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d7, code lost:
                if (r2 == null) goto L_0x00da;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
                r0 = r10.values.getPackageManager().resolveContentProvider(r10.AFInAppEventType, 128).packageName;
                r10.AFInAppEventParameterName.AFInAppEventType.put("api_ver", java.lang.Long.valueOf(com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper(r10.values, r0)));
                r10.AFInAppEventParameterName.AFInAppEventType.put("api_ver_name", com.appsflyer.internal.AFa1cSDK.values(r10.values, r0));
                r10.AFInAppEventParameterName.AFInAppEventType();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0115, code lost:
                return r10.AFInAppEventParameterName.AFInAppEventType;
             */
            /* renamed from: AFKeystoreWrapper */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.Object> values() {
                /*
                    r10 = this;
                    java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
                    java.lang.String r1 = "response"
                    r2 = 0
                    android.content.Context r3 = r10.values     // Catch:{ Exception -> 0x0091 }
                    android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ Exception -> 0x0091 }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = "content://"
                    r3.<init>(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = r10.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    r3.append(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0091 }
                    android.net.Uri r5 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0091 }
                    r8 = 0
                    r9 = 0
                    r6 = 0
                    r7 = 0
                    android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0091 }
                    if (r2 == 0) goto L_0x00ba
                    boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0091 }
                    if (r3 == 0) goto L_0x00b2
                    com.appsflyer.internal.AFf1iSDK r3 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "OK"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "referrer"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    values(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "click_ts"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    valueOf(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "install_begin_ts"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    valueOf(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "install_end_ts"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    valueOf(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "organic_keywords"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    values(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r3 = "attr_type"
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    values(r3, r4, r2)     // Catch:{ Exception -> 0x0091 }
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0091 }
                    r3.<init>()     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "instant"
                    int r5 = r2.getColumnIndex(r4)     // Catch:{ Exception -> 0x0091 }
                    r6 = -1
                    if (r5 == r6) goto L_0x0093
                    java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0091 }
                    if (r5 == 0) goto L_0x0093
                    boolean r5 = java.lang.Boolean.parseBoolean(r5)     // Catch:{ Exception -> 0x0091 }
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0091 }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x0093
                L_0x008e:
                    r0 = move-exception
                    goto L_0x0116
                L_0x0091:
                    r3 = move-exception
                    goto L_0x00c9
                L_0x0093:
                    java.lang.String r4 = "click_server_ts"
                    valueOf(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "install_begin_server_ts"
                    valueOf(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "install_version"
                    values(r4, r3, r2)     // Catch:{ Exception -> 0x0091 }
                    boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x0091 }
                    if (r4 != 0) goto L_0x00c3
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r5 = "custom"
                    r4.put(r5, r3)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x00c3
                L_0x00b2:
                    com.appsflyer.internal.AFf1iSDK r3 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    r3.put(r1, r0)     // Catch:{ Exception -> 0x0091 }
                    goto L_0x00c3
                L_0x00ba:
                    com.appsflyer.internal.AFf1iSDK r3 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ Exception -> 0x0091 }
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType     // Catch:{ Exception -> 0x0091 }
                    java.lang.String r4 = "SERVICE_UNAVAILABLE"
                    r3.put(r1, r4)     // Catch:{ Exception -> 0x0091 }
                L_0x00c3:
                    if (r2 == 0) goto L_0x00da
                L_0x00c5:
                    r2.close()
                    goto L_0x00da
                L_0x00c9:
                    com.appsflyer.internal.AFf1iSDK r4 = com.appsflyer.internal.AFf1iSDK.this     // Catch:{ all -> 0x008e }
                    java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFInAppEventType     // Catch:{ all -> 0x008e }
                    r4.put(r1, r0)     // Catch:{ all -> 0x008e }
                    java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x008e }
                    com.appsflyer.AFLogger.afErrorLog(r0, r3)     // Catch:{ all -> 0x008e }
                    if (r2 == 0) goto L_0x00da
                    goto L_0x00c5
                L_0x00da:
                    android.content.Context r0 = r10.values
                    android.content.pm.PackageManager r0 = r0.getPackageManager()
                    java.lang.String r1 = r10.AFInAppEventType
                    r2 = 128(0x80, float:1.794E-43)
                    android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r1, r2)
                    java.lang.String r0 = r0.packageName
                    com.appsflyer.internal.AFf1iSDK r1 = com.appsflyer.internal.AFf1iSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFInAppEventType
                    android.content.Context r2 = r10.values
                    long r2 = com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper(r2, r0)
                    java.lang.Long r2 = java.lang.Long.valueOf(r2)
                    java.lang.String r3 = "api_ver"
                    r1.put(r3, r2)
                    com.appsflyer.internal.AFf1iSDK r1 = com.appsflyer.internal.AFf1iSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFInAppEventType
                    android.content.Context r2 = r10.values
                    java.lang.String r0 = com.appsflyer.internal.AFa1cSDK.values((android.content.Context) r2, (java.lang.String) r0)
                    java.lang.String r2 = "api_ver_name"
                    r1.put(r2, r0)
                    com.appsflyer.internal.AFf1iSDK r0 = com.appsflyer.internal.AFf1iSDK.this
                    r0.AFInAppEventType()
                    com.appsflyer.internal.AFf1iSDK r0 = com.appsflyer.internal.AFf1iSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFInAppEventType
                    return r0
                L_0x0116:
                    if (r2 == 0) goto L_0x011b
                    r2.close()
                L_0x011b:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1iSDK.AnonymousClass4.values():java.util.Map");
            }

            private static void valueOf(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex != -1) {
                    long j10 = cursor.getLong(columnIndex);
                    if (j10 != 0) {
                        map.put(str, Long.valueOf(j10));
                    }
                }
            }

            private static void values(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex != -1 && (string = cursor.getString(columnIndex)) != null) {
                    map.put(str, string);
                }
            }
        });
    }
}
