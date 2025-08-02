package com.adjust.sdk;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class InstallReferrerHuawei {
    private static final int COLUMN_INDEX_CLICK_TIME = 1;
    private static final int COLUMN_INDEX_INSTALL_TIME = 2;
    private static final int COLUMN_INDEX_REFERRER = 0;
    private static final int COLUMN_INDEX_TRACK_ID = 4;
    private static final String REFERRER_PROVIDER_AUTHORITY = "com.huawei.appmarket.commondata";
    private static final String REFERRER_PROVIDER_URI = "content://com.huawei.appmarket.commondata/item/5";
    private Context context;
    private ILogger logger = AdjustFactory.getLogger();
    private final InstallReferrerReadListener referrerCallback;
    private final AtomicBoolean shouldTryToRead;

    public InstallReferrerHuawei(Context context2, InstallReferrerReadListener installReferrerReadListener) {
        this.context = context2;
        this.referrerCallback = installReferrerReadListener;
        this.shouldTryToRead = new AtomicBoolean(true);
    }

    private boolean isValidReferrerHuaweiAds(String str) {
        return str != null && !str.isEmpty();
    }

    private boolean isValidReferrerHuaweiAppGallery(String str) {
        return str != null && !str.isEmpty();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c2, code lost:
        if (r11 != null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d4, code lost:
        if (r11 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d6, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d9, code lost:
        r1.shouldTryToRead.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00de, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readReferrer() {
        /*
            r18 = this;
            r1 = r18
            r0 = 2
            r2 = 1
            java.util.concurrent.atomic.AtomicBoolean r3 = r1.shouldTryToRead
            boolean r3 = r3.get()
            r4 = 0
            if (r3 != 0) goto L_0x0017
            com.adjust.sdk.ILogger r0 = r1.logger
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = "Should not try to read Install referrer Huawei"
            r0.debug(r3, r2)
            return
        L_0x0017:
            android.content.Context r3 = r1.context
            java.lang.String r5 = "com.huawei.appmarket.commondata"
            boolean r3 = com.adjust.sdk.Util.resolveContentProvider(r3, r5)
            if (r3 != 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r3 = "content://com.huawei.appmarket.commondata/item/5"
            android.net.Uri r3 = android.net.Uri.parse(r3)
            android.content.Context r5 = r1.context
            android.content.ContentResolver r5 = r5.getContentResolver()
            android.content.Context r6 = r1.context
            java.lang.String r6 = r6.getPackageName()
            java.lang.String[] r9 = new java.lang.String[]{r6}
            r8 = 0
            r10 = 0
            r11 = 0
            r7 = 0
            r6 = r3
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0095 }
            if (r11 == 0) goto L_0x00ab
            boolean r5 = r11.moveToFirst()     // Catch:{ Exception -> 0x0095 }
            if (r5 == 0) goto L_0x00ab
            java.lang.String r13 = r11.getString(r4)     // Catch:{ Exception -> 0x0095 }
            r3 = 4
            java.lang.String r6 = r11.getString(r3)     // Catch:{ Exception -> 0x0095 }
            com.adjust.sdk.ILogger r3 = r1.logger     // Catch:{ Exception -> 0x0095 }
            java.lang.String r5 = "InstallReferrerHuawei reads index_referrer[%s] index_track_id[%s]"
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0095 }
            r7[r4] = r13     // Catch:{ Exception -> 0x0095 }
            r7[r2] = r6     // Catch:{ Exception -> 0x0095 }
            r3.debug(r5, r7)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = r11.getString(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r5 = r11.getString(r0)     // Catch:{ Exception -> 0x0095 }
            com.adjust.sdk.ILogger r7 = r1.logger     // Catch:{ Exception -> 0x0095 }
            java.lang.String r8 = "InstallReferrerHuawei reads clickTime[%s] installTime[%s]"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0095 }
            r0[r4] = r3     // Catch:{ Exception -> 0x0095 }
            r0[r2] = r5     // Catch:{ Exception -> 0x0095 }
            r7.debug(r8, r0)     // Catch:{ Exception -> 0x0095 }
            long r7 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x0095 }
            long r9 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0095 }
            boolean r0 = r1.isValidReferrerHuaweiAds(r13)     // Catch:{ Exception -> 0x0095 }
            if (r0 == 0) goto L_0x0097
            com.adjust.sdk.ReferrerDetails r0 = new com.adjust.sdk.ReferrerDetails     // Catch:{ Exception -> 0x0095 }
            r12 = r0
            r14 = r7
            r16 = r9
            r12.<init>(r13, r14, r16)     // Catch:{ Exception -> 0x0095 }
            com.adjust.sdk.InstallReferrerReadListener r3 = r1.referrerCallback     // Catch:{ Exception -> 0x0095 }
            java.lang.String r5 = "huawei_ads"
            r3.onInstallReferrerRead(r0, r5)     // Catch:{ Exception -> 0x0095 }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            goto L_0x00df
        L_0x0095:
            r0 = move-exception
            goto L_0x00c5
        L_0x0097:
            boolean r0 = r1.isValidReferrerHuaweiAppGallery(r6)     // Catch:{ Exception -> 0x0095 }
            if (r0 == 0) goto L_0x00c2
            com.adjust.sdk.ReferrerDetails r0 = new com.adjust.sdk.ReferrerDetails     // Catch:{ Exception -> 0x0095 }
            r5 = r0
            r5.<init>(r6, r7, r9)     // Catch:{ Exception -> 0x0095 }
            com.adjust.sdk.InstallReferrerReadListener r3 = r1.referrerCallback     // Catch:{ Exception -> 0x0095 }
            java.lang.String r5 = "huawei_app_gallery"
            r3.onInstallReferrerRead(r0, r5)     // Catch:{ Exception -> 0x0095 }
            goto L_0x00c2
        L_0x00ab:
            com.adjust.sdk.ILogger r5 = r1.logger     // Catch:{ Exception -> 0x0095 }
            java.lang.String r6 = "InstallReferrerHuawei fail to read referrer for package [%s] and content uri [%s]"
            android.content.Context r7 = r1.context     // Catch:{ Exception -> 0x0095 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0095 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0095 }
            r0[r4] = r7     // Catch:{ Exception -> 0x0095 }
            r0[r2] = r3     // Catch:{ Exception -> 0x0095 }
            r5.debug(r6, r0)     // Catch:{ Exception -> 0x0095 }
        L_0x00c2:
            if (r11 == 0) goto L_0x00d9
            goto L_0x00d6
        L_0x00c5:
            com.adjust.sdk.ILogger r3 = r1.logger     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = "InstallReferrerHuawei error [%s]"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0093 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0093 }
            r2[r4] = r0     // Catch:{ all -> 0x0093 }
            r3.debug(r5, r2)     // Catch:{ all -> 0x0093 }
            if (r11 == 0) goto L_0x00d9
        L_0x00d6:
            r11.close()
        L_0x00d9:
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.shouldTryToRead
            r0.set(r4)
            return
        L_0x00df:
            if (r11 == 0) goto L_0x00e4
            r11.close()
        L_0x00e4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.InstallReferrerHuawei.readReferrer():void");
    }
}
