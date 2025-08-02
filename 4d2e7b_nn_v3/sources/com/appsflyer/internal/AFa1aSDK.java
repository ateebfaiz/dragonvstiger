package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;

final class AFa1aSDK extends AFb1jSDK<String> {
    AFa1aSDK(Context context, AFc1vSDK aFc1vSDK) {
        super(context, aFc1vSDK, "com.facebook.katana.provider.AttributionIdProvider", "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* renamed from: AFKeystoreWrapper */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String values() {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "aid"
            android.content.Context r2 = r9.values     // Catch:{ all -> 0x0044 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = "content://"
            r2.<init>(r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r9.AFInAppEventType     // Catch:{ all -> 0x0044 }
            r2.append(r4)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0044 }
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ all -> 0x0044 }
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch:{ all -> 0x0044 }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x003e
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x003e
            int r0 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x003c }
            r2.close()
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0047
        L_0x003e:
            if (r2 == 0) goto L_0x0043
            r2.close()
        L_0x0043:
            return r0
        L_0x0044:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0047:
            if (r2 == 0) goto L_0x004c
            r2.close()
        L_0x004c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1aSDK.values():java.lang.String");
    }

    @Nullable
    public final String AFInAppEventType() {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(this.valueOf);
        return (String) super.valueOf();
    }

    @Nullable
    public final /* synthetic */ Object valueOf() {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(this.valueOf);
        return (String) super.valueOf();
    }
}
