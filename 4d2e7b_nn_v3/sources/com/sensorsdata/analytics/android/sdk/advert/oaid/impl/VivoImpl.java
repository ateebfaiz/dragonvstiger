package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.content.Context;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID;
import com.sensorsdata.analytics.android.sdk.advert.oaid.OAIDRom;

class VivoImpl implements IRomOAID {
    private static final String TAG = "SA.VivoImpl";
    private final Context mContext;

    public VivoImpl(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getRomOAID() {
        /*
            r9 = this;
            java.lang.String r0 = "SA.VivoImpl"
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r3 = android.net.Uri.parse(r1)
            r1 = 0
            android.content.Context r2 = r9.mContext     // Catch:{ all -> 0x0042 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0042 }
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x003c
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = "value"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r2.getString(r3)     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0037
            int r3 = r1.length()     // Catch:{ all -> 0x0032 }
            if (r3 != 0) goto L_0x003c
            goto L_0x0037
        L_0x0032:
            r3 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0044
        L_0x0037:
            java.lang.String r3 = "OAID query failed"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0032 }
        L_0x003c:
            if (r2 == 0) goto L_0x004d
            r2.close()
            goto L_0x004d
        L_0x0042:
            r3 = move-exception
            r2 = r1
        L_0x0044:
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.Throwable) r3)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004c
            r1.close()
        L_0x004c:
            r1 = r2
        L_0x004d:
            return r1
        L_0x004e:
            r0 = move-exception
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.advert.oaid.impl.VivoImpl.getRomOAID():java.lang.String");
    }

    public boolean isSupported() {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return false;
            }
            return OAIDRom.sysProperty("persist.sys.identifierid.supported", "0").equals("1");
        } catch (Throwable th) {
            SALog.i(TAG, th);
            return false;
        }
    }
}
