package com.google.android.gms.internal.auth;

public final class zzcp {
    private static volatile zzdh zza;

    private zzcp() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:73|74) */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0167 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.auth.zzdh zza(android.content.Context r14) {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<com.google.android.gms.internal.auth.zzcp> r2 = com.google.android.gms.internal.auth.zzcp.class
            monitor-enter(r2)
            com.google.android.gms.internal.auth.zzdh r3 = zza     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x017e
            java.lang.String r3 = android.os.Build.TYPE     // Catch:{ all -> 0x001e }
            java.lang.String r4 = android.os.Build.TAGS     // Catch:{ all -> 0x001e }
            java.lang.String r5 = "eng"
            boolean r5 = r3.equals(r5)     // Catch:{ all -> 0x001e }
            if (r5 != 0) goto L_0x0021
            java.lang.String r5 = "userdebug"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0032
            goto L_0x0021
        L_0x001e:
            r14 = move-exception
            goto L_0x0180
        L_0x0021:
            java.lang.String r3 = "dev-keys"
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0039
            java.lang.String r3 = "test-keys"
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x001e }
        L_0x0036:
            r3 = r14
            goto L_0x0177
        L_0x0039:
            boolean r3 = com.google.android.gms.internal.auth.zzcc.zzb()     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0049
            boolean r3 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0049
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x001e }
        L_0x0049:
            android.os.StrictMode$ThreadPolicy r3 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x001e }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0068 }
            java.io.File r4 = new java.io.File     // Catch:{ RuntimeException -> 0x0070 }
            java.lang.String r5 = "phenotype_hermetic"
            java.io.File r5 = r14.getDir(r5, r1)     // Catch:{ RuntimeException -> 0x0070 }
            java.lang.String r6 = "overrides.txt"
            r4.<init>(r5, r6)     // Catch:{ RuntimeException -> 0x0070 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0068 }
            if (r5 == 0) goto L_0x006b
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzd(r4)     // Catch:{ all -> 0x0068 }
            goto L_0x007c
        L_0x0068:
            r14 = move-exception
            goto L_0x017a
        L_0x006b:
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
            goto L_0x007c
        L_0x0070:
            r4 = move-exception
            java.lang.String r5 = "HermeticFileOverrides"
            java.lang.String r6 = "no data dir"
            android.util.Log.e(r5, r6, r4)     // Catch:{ all -> 0x0068 }
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
        L_0x007c:
            boolean r5 = r4.zzb()     // Catch:{ all -> 0x0068 }
            if (r5 == 0) goto L_0x016e
            java.lang.Object r4 = r4.zza()     // Catch:{ all -> 0x0068 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ all -> 0x0068 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x014b }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x014b }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x014b }
            r7.<init>(r4)     // Catch:{ IOException -> 0x014b }
            r6.<init>(r7)     // Catch:{ IOException -> 0x014b }
            r5.<init>(r6)     // Catch:{ IOException -> 0x014b }
            androidx.collection.SimpleArrayMap r6 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00c8 }
            r6.<init>()     // Catch:{ all -> 0x00c8 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x00c8 }
            r7.<init>()     // Catch:{ all -> 0x00c8 }
        L_0x00a1:
            java.lang.String r8 = r5.readLine()     // Catch:{ all -> 0x00c8 }
            if (r8 == 0) goto L_0x0118
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x00c8 }
            int r11 = r9.length     // Catch:{ all -> 0x00c8 }
            if (r11 == r10) goto L_0x00cb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r9.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = "Invalid: "
            r9.append(r10)     // Catch:{ all -> 0x00c8 }
            r9.append(r8)     // Catch:{ all -> 0x00c8 }
            java.lang.String r8 = "HermeticFileOverrides"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00c8 }
            android.util.Log.e(r8, r9)     // Catch:{ all -> 0x00c8 }
            goto L_0x00a1
        L_0x00c8:
            r14 = move-exception
            goto L_0x014d
        L_0x00cb:
            r8 = r9[r1]     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00c8 }
            r10.<init>(r8)     // Catch:{ all -> 0x00c8 }
            r8 = r9[r0]     // Catch:{ all -> 0x00c8 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00c8 }
            r11.<init>(r8)     // Catch:{ all -> 0x00c8 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x00c8 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x00c8 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x00c8 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00c8 }
            if (r12 != 0) goto L_0x0100
            r9 = r9[r11]     // Catch:{ all -> 0x00c8 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00c8 }
            r11.<init>(r9)     // Catch:{ all -> 0x00c8 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x00c8 }
            int r9 = r12.length()     // Catch:{ all -> 0x00c8 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00fd
            if (r12 != r11) goto L_0x0100
        L_0x00fd:
            r7.put(r11, r12)     // Catch:{ all -> 0x00c8 }
        L_0x0100:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x00c8 }
            if (r9 != 0) goto L_0x010e
            androidx.collection.SimpleArrayMap r9 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00c8 }
            r9.<init>()     // Catch:{ all -> 0x00c8 }
            r6.put(r10, r9)     // Catch:{ all -> 0x00c8 }
        L_0x010e:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x00c8 }
            androidx.collection.SimpleArrayMap r9 = (androidx.collection.SimpleArrayMap) r9     // Catch:{ all -> 0x00c8 }
            r9.put(r8, r12)     // Catch:{ all -> 0x00c8 }
            goto L_0x00a1
        L_0x0118:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00c8 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x00c8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r7.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r8 = "Parsed "
            r7.append(r8)     // Catch:{ all -> 0x00c8 }
            r7.append(r4)     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = " for Android package "
            r7.append(r4)     // Catch:{ all -> 0x00c8 }
            r7.append(r14)     // Catch:{ all -> 0x00c8 }
            java.lang.String r14 = "HermeticFileOverrides"
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x00c8 }
            android.util.Log.w(r14, r4)     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.internal.auth.zzci r14 = new com.google.android.gms.internal.auth.zzci     // Catch:{ all -> 0x00c8 }
            r14.<init>(r6)     // Catch:{ all -> 0x00c8 }
            r5.close()     // Catch:{ IOException -> 0x014b }
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzd(r14)     // Catch:{ all -> 0x0068 }
            goto L_0x0172
        L_0x014b:
            r14 = move-exception
            goto L_0x0168
        L_0x014d:
            r5.close()     // Catch:{ all -> 0x0151 }
            goto L_0x0167
        L_0x0151:
            r4 = move-exception
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            r5[r1] = r6     // Catch:{ Exception -> 0x0167 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            java.lang.String r7 = "addSuppressed"
            java.lang.reflect.Method r5 = r6.getDeclaredMethod(r7, r5)     // Catch:{ Exception -> 0x0167 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0167 }
            r0[r1] = r4     // Catch:{ Exception -> 0x0167 }
            r5.invoke(r14, r0)     // Catch:{ Exception -> 0x0167 }
        L_0x0167:
            throw r14     // Catch:{ IOException -> 0x014b }
        L_0x0168:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0068 }
            r0.<init>(r14)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x016e:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
        L_0x0172:
            android.os.StrictMode.setThreadPolicy(r3)     // Catch:{ all -> 0x001e }
            goto L_0x0036
        L_0x0177:
            zza = r3     // Catch:{ all -> 0x001e }
            goto L_0x017e
        L_0x017a:
            android.os.StrictMode.setThreadPolicy(r3)     // Catch:{ all -> 0x001e }
            throw r14     // Catch:{ all -> 0x001e }
        L_0x017e:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return r3
        L_0x0180:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcp.zza(android.content.Context):com.google.android.gms.internal.auth.zzdh");
    }
}
