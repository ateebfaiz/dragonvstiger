package com.geetest.core;

public class OaidHelper {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031 A[SYNTHETIC, Splitter:B:13:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOaid(android.content.Context r6) {
        /*
            boolean r0 = com.geetest.core.c.a()
            java.lang.String r1 = "ro.build.version.emui"
            r2 = 0
            java.lang.String r3 = ""
            r4 = 1
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = com.geetest.core.c.a((java.lang.String) r1, (java.lang.String) r3)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0025
        L_0x0017:
            android.content.pm.PackageManager r0 = r6.getPackageManager()
            java.lang.String r5 = "com.huawei.hwid"
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r5, r2)     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x0025
            r0 = r4
            goto L_0x002f
        L_0x0025:
            com.geetest.core.c5 r0 = com.geetest.core.c.c((android.content.Context) r6)
            boolean r0 = r0.a()
            goto L_0x002f
        L_0x002e:
            r0 = r2
        L_0x002f:
            if (r0 == 0) goto L_0x0079
            boolean r0 = com.geetest.core.c.a()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0071
            java.lang.String r0 = com.geetest.core.c.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x006f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006f }
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0043
            goto L_0x0071
        L_0x0043:
            java.lang.String[] r0 = new java.lang.String[r4]     // Catch:{ all -> 0x006f }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x006f }
            r1.<init>(r4)     // Catch:{ all -> 0x006f }
            com.geetest.core.z4 r4 = new com.geetest.core.z4     // Catch:{ all -> 0x006f }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x006f }
            com.geetest.core.c5 r6 = com.geetest.core.c.c((android.content.Context) r6)     // Catch:{ all -> 0x006f }
            r6.getClass()     // Catch:{ all -> 0x006f }
            r6.a(r4)     // Catch:{ all -> 0x006f }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x006f }
            r4 = 1
            boolean r6 = r1.await(r4, r6)     // Catch:{ all -> 0x006f }
            if (r6 == 0) goto L_0x0079
            r6 = r0[r2]     // Catch:{ all -> 0x006f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x006f }
            if (r6 != 0) goto L_0x0079
            r6 = r0[r2]     // Catch:{ all -> 0x006f }
        L_0x006d:
            r3 = r6
            goto L_0x0079
        L_0x006f:
            r6 = move-exception
            goto L_0x0076
        L_0x0071:
            java.lang.String r6 = com.geetest.core.a5.a(r6)     // Catch:{ all -> 0x006f }
            goto L_0x006d
        L_0x0076:
            r6.printStackTrace()
        L_0x0079:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.OaidHelper.getOaid(android.content.Context):java.lang.String");
    }
}
