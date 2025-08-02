package com.google.android.material.color;

abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8055a = "h";

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0070 A[SYNTHETIC, Splitter:B:43:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.content.res.loader.ResourcesLoader a(android.content.Context r4, java.util.Map r5) {
        /*
            r0 = 0
            byte[] r4 = com.google.android.material.color.i.i(r4, r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = f8055a     // Catch:{ Exception -> 0x0052 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            r1.<init>()     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "Table created, length: "
            r1.append(r2)     // Catch:{ Exception -> 0x0052 }
            int r2 = r4.length     // Catch:{ Exception -> 0x0052 }
            r1.append(r2)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0052 }
            android.util.Log.i(r5, r1)     // Catch:{ Exception -> 0x0052 }
            int r5 = r4.length     // Catch:{ Exception -> 0x0052 }
            if (r5 != 0) goto L_0x0020
            return r0
        L_0x0020:
            java.lang.String r5 = "temp.arsc"
            r1 = 0
            java.io.FileDescriptor r5 = android.system.Os.memfd_create(r5, r1)     // Catch:{ all -> 0x006c }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            r1.write(r4)     // Catch:{ all -> 0x0047 }
            android.os.ParcelFileDescriptor r4 = android.os.ParcelFileDescriptor.dup(r5)     // Catch:{ all -> 0x0047 }
            com.google.android.material.color.d.a()     // Catch:{ all -> 0x0057 }
            android.content.res.loader.ResourcesLoader r2 = com.google.android.material.color.c.a()     // Catch:{ all -> 0x0057 }
            android.content.res.loader.ResourcesProvider r3 = android.content.res.loader.ResourcesProvider.loadFromTable(r4, r0)     // Catch:{ all -> 0x0057 }
            r2.addProvider(r3)     // Catch:{ all -> 0x0057 }
            if (r4 == 0) goto L_0x0049
            r4.close()     // Catch:{ all -> 0x0047 }
            goto L_0x0049
        L_0x0047:
            r4 = move-exception
            goto L_0x0063
        L_0x0049:
            r1.close()     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0054
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0054
        L_0x0052:
            r4 = move-exception
            goto L_0x0074
        L_0x0054:
            return r2
        L_0x0055:
            r4 = move-exception
            goto L_0x006e
        L_0x0057:
            r2 = move-exception
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ all -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r4 = move-exception
            r2.addSuppressed(r4)     // Catch:{ all -> 0x0047 }
        L_0x0062:
            throw r2     // Catch:{ all -> 0x0047 }
        L_0x0063:
            r1.close()     // Catch:{ all -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ all -> 0x0055 }
        L_0x006b:
            throw r4     // Catch:{ all -> 0x0055 }
        L_0x006c:
            r4 = move-exception
            r5 = r0
        L_0x006e:
            if (r5 == 0) goto L_0x0073
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x0052 }
        L_0x0073:
            throw r4     // Catch:{ Exception -> 0x0052 }
        L_0x0074:
            java.lang.String r5 = f8055a
            java.lang.String r1 = "Failed to create the ColorResourcesTableCreator."
            android.util.Log.e(r5, r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.h.a(android.content.Context, java.util.Map):android.content.res.loader.ResourcesLoader");
    }
}
