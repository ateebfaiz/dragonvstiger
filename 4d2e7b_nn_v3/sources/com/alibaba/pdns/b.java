package com.alibaba.pdns;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f17860a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f17861b = "com.alibaba.pdns.ACCESS_KEY_SECRET";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17862c = "com.alibaba.pdns.ACCESS_KEY_ID";

    public static void a(Context context) {
        f17860a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b() {
        /*
            android.content.Context r0 = f17860a     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r0 == 0) goto L_0x002a
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            android.content.Context r1 = f17860a     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            android.os.Bundle r1 = r0.metaData     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            java.lang.String r2 = "meta_name"
            r1.getString(r2)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r0 == 0) goto L_0x0039
            java.lang.String r1 = "com.alibaba.pdns.ACCESS_KEY_ID"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            return r0
        L_0x0026:
            r0 = move-exception
            goto L_0x0032
        L_0x0028:
            r0 = move-exception
            goto L_0x0032
        L_0x002a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            java.lang.String r1 = "DNSResolver Init mContext can not be empty please initalize the SDK before using it!!"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            throw r0     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
        L_0x0032:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0039
            r0.printStackTrace()
        L_0x0039:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.b.b():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c() {
        /*
            android.content.Context r0 = f17860a     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r0 == 0) goto L_0x0040
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            android.content.Context r1 = f17860a     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            android.os.Bundle r1 = r0.metaData     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r2 = "meta_name"
            r1.getString(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            android.os.Bundle r0 = r0.metaData     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r1.<init>()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r2 = "metaData="
            r1.append(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r1.append(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            com.alibaba.pdns.u.a.a((java.lang.String) r1)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r1 = "com.alibaba.pdns.ACCESS_KEY_SECRET"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0048
        L_0x003e:
            r0 = move-exception
            goto L_0x0048
        L_0x0040:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r1 = "DNSResolver Init mContext can not be empty please initalize the SDK before using it!!"
            r0.<init>(r1)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            throw r0     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
        L_0x0048:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x004f
            r0.printStackTrace()
        L_0x004f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.b.c():java.lang.String");
    }

    public static Context d() {
        Context context = f17860a;
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static File e() {
        File externalCacheDir = f17860a.getExternalCacheDir();
        if (externalCacheDir == null) {
            return a();
        }
        return externalCacheDir;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f() {
        /*
            java.lang.String r0 = ""
            android.content.Context r1 = f17860a     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            android.content.Context r2 = f17860a     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            r3 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0028, Error -> 0x0023 }
            if (r1 == 0) goto L_0x0022
            int r2 = r1.length()     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r2 > 0) goto L_0x0031
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            goto L_0x002a
        L_0x0020:
            r0 = move-exception
            goto L_0x002a
        L_0x0022:
            return r0
        L_0x0023:
            r1 = move-exception
        L_0x0024:
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x002a
        L_0x0028:
            r1 = move-exception
            goto L_0x0024
        L_0x002a:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x0031
            r0.printStackTrace()
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.b.f():java.lang.String");
    }

    private static File a() {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), f17860a.getPackageName()), "cache");
        return (file.exists() || file.mkdirs()) ? file : f17860a.getCacheDir();
    }
}
