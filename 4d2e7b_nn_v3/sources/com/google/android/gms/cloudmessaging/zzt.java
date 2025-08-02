package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzt {
    private final Context zza;
    private int zzb;
    private int zzc = 0;

    public zzt(Context context) {
        this.zza = context;
    }

    public final synchronized int zza() {
        PackageInfo packageInfo;
        if (this.zzb == 0) {
            try {
                packageInfo = Wrappers.packageManager(this.zza).getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e10) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
                sb2.append("Failed to find package ");
                sb2.append(valueOf);
                Log.w("Metadata", sb2.toString());
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.zzb = packageInfo.versionCode;
            }
        }
        return this.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.zzc     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r5)
            return r0
        L_0x0007:
            android.content.Context r0 = r5.zza     // Catch:{ all -> 0x0028 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0028 }
            android.content.Context r1 = r5.zza     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ all -> 0x0028 }
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            int r1 = r1.checkPermission(r2, r3)     // Catch:{ all -> 0x0028 }
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L_0x002a
            java.lang.String r0 = "Metadata"
            java.lang.String r1 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r5)
            return r3
        L_0x0028:
            r0 = move-exception
            goto L_0x0081
        L_0x002a:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0028 }
            r2 = 1
            if (r1 != 0) goto L_0x004e
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r1.<init>(r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0028 }
            java.util.List r1 = r0.queryIntentServices(r1, r3)     // Catch:{ all -> 0x0028 }
            if (r1 == 0) goto L_0x004e
            int r1 = r1.size()     // Catch:{ all -> 0x0028 }
            if (r1 > 0) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            r5.zzc = r2     // Catch:{ all -> 0x0028 }
            monitor-exit(r5)
            return r2
        L_0x004e:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r1.<init>(r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0028 }
            java.util.List r0 = r0.queryBroadcastReceivers(r1, r3)     // Catch:{ all -> 0x0028 }
            r1 = 2
            if (r0 == 0) goto L_0x006c
            int r0 = r0.size()     // Catch:{ all -> 0x0028 }
            if (r0 > 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            r5.zzc = r1     // Catch:{ all -> 0x0028 }
            monitor-exit(r5)
            return r1
        L_0x006c:
            java.lang.String r0 = "Metadata"
            java.lang.String r3 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x0028 }
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x007d
            r5.zzc = r1     // Catch:{ all -> 0x0028 }
            r2 = r1
            goto L_0x007f
        L_0x007d:
            r5.zzc = r2     // Catch:{ all -> 0x0028 }
        L_0x007f:
            monitor-exit(r5)
            return r2
        L_0x0081:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzt.zzb():int");
    }
}
