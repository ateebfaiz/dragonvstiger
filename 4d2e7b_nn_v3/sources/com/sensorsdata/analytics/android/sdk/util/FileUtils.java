package com.sensorsdata.analytics.android.sdk.util;

public class FileUtils {
    /* JADX WARNING: Removed duplicated region for block: B:40:0x004d A[SYNTHETIC, Splitter:B:40:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0060 A[SYNTHETIC, Splitter:B:52:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFileToString(java.io.File r7) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x002c }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002c }
            r2.<init>(r7)     // Catch:{ Exception -> 0x002c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002c }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r7.<init>()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x0022 }
        L_0x0014:
            r4 = 0
            int r5 = r1.read(r3, r4, r2)     // Catch:{ IOException -> 0x0022 }
            r6 = -1
            if (r5 == r6) goto L_0x0024
            r7.write(r3, r4, r5)     // Catch:{ IOException -> 0x0022 }
            goto L_0x0014
        L_0x0020:
            r2 = move-exception
            goto L_0x0056
        L_0x0022:
            r2 = move-exception
            goto L_0x0040
        L_0x0024:
            java.lang.String r2 = r7.toString()     // Catch:{ IOException -> 0x0022 }
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002c:
            r7 = move-exception
            goto L_0x0069
        L_0x002e:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x002c }
        L_0x0032:
            r7.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x002c }
        L_0x003a:
            return r2
        L_0x003b:
            r2 = move-exception
            r7 = r0
            goto L_0x0056
        L_0x003e:
            r2 = move-exception
            r7 = r0
        L_0x0040:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)     // Catch:{ all -> 0x0020 }
            r1.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x002c }
        L_0x004b:
            if (r7 == 0) goto L_0x0055
            r7.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x002c }
        L_0x0055:
            return r0
        L_0x0056:
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Exception -> 0x002c }
        L_0x005e:
            if (r7 == 0) goto L_0x0068
            r7.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r7 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)     // Catch:{ Exception -> 0x002c }
        L_0x0068:
            throw r2     // Catch:{ Exception -> 0x002c }
        L_0x0069:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.FileUtils.readFileToString(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0024 A[SYNTHETIC, Splitter:B:18:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeToFile(java.io.File r2, java.lang.String r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001e }
            byte[] r2 = r3.getBytes()     // Catch:{ Exception -> 0x0019, all -> 0x0016 }
            r1.write(r2)     // Catch:{ Exception -> 0x0019, all -> 0x0016 }
            r1.close()     // Catch:{ IOException -> 0x0011 }
            goto L_0x0027
        L_0x0011:
            r2 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)
            goto L_0x0027
        L_0x0016:
            r2 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0019:
            r2 = move-exception
            r0 = r1
            goto L_0x001f
        L_0x001c:
            r2 = move-exception
            goto L_0x0028
        L_0x001e:
            r2 = move-exception
        L_0x001f:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0011 }
        L_0x0027:
            return
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.FileUtils.writeToFile(java.io.File, java.lang.String):void");
    }
}
