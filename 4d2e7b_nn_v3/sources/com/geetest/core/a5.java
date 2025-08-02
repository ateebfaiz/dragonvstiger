package com.geetest.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

public class a5 {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5904a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static Context f5905b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5906c;

    /* renamed from: d  reason: collision with root package name */
    public static PackageManager f5907d;

    public static class a extends e {
        public a() {
            super("com.huawei.hwid", (String) null, "com.uodis.opendevice.OPENIDS_SERVICE", "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        }
    }

    public static class b implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f5908a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5909b;

        public b(IBinder iBinder, String str) {
            this.f5908a = iBinder;
            this.f5909b = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2.recycle();
            r3.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
            return "";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0037 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5) {
            /*
                r1 = this;
                android.os.Parcel r2 = android.os.Parcel.obtain()
                android.os.Parcel r3 = android.os.Parcel.obtain()
                java.lang.String r4 = r1.f5909b     // Catch:{ all -> 0x0037 }
                r2.writeInterfaceToken(r4)     // Catch:{ all -> 0x0037 }
                r4 = 0
                boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0037 }
                if (r0 != 0) goto L_0x0017
                r2.writeString(r4)     // Catch:{ all -> 0x0037 }
            L_0x0017:
                boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0037 }
                if (r0 != 0) goto L_0x0020
                r2.writeString(r4)     // Catch:{ all -> 0x0037 }
            L_0x0020:
                boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0037 }
                if (r0 != 0) goto L_0x0029
                r2.writeString(r4)     // Catch:{ all -> 0x0037 }
            L_0x0029:
                android.os.IBinder r4 = r1.f5908a     // Catch:{ all -> 0x0037 }
                r0 = 0
                r4.transact(r5, r2, r3, r0)     // Catch:{ all -> 0x0037 }
                r3.readException()     // Catch:{ all -> 0x0037 }
                java.lang.String r2 = r3.readString()     // Catch:{ all -> 0x0037 }
                goto L_0x003f
            L_0x0037:
                r2.recycle()     // Catch:{ Exception -> 0x003d }
                r3.recycle()     // Catch:{ Exception -> 0x003d }
            L_0x003d:
                java.lang.String r2 = ""
            L_0x003f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.a5.b.a(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
        }

        public final IBinder asBinder() {
            return this.f5908a;
        }
    }

    public interface c {
    }

    public static class d implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public b f5910a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5911b;

        /* renamed from: c  reason: collision with root package name */
        public final CountDownLatch f5912c;

        /* renamed from: d  reason: collision with root package name */
        public IBinder f5913d;

        public d(String str, CountDownLatch countDownLatch) {
            this.f5911b = str;
            this.f5912c = countDownLatch;
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [android.os.IInterface] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                com.geetest.core.a5$b r0 = r3.f5910a
                r1 = 1
                if (r0 == 0) goto L_0x0006
                return r1
            L_0x0006:
                boolean r4 = r4.bindService(r5, r3, r1)     // Catch:{ all -> 0x0030 }
                java.util.concurrent.CountDownLatch r5 = r3.f5912c     // Catch:{ all -> 0x0030 }
                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0030 }
                r1 = 1
                r5.await(r1, r0)     // Catch:{ all -> 0x0030 }
                android.os.IBinder r5 = r3.f5913d     // Catch:{ all -> 0x0030 }
                java.lang.String r0 = r3.f5911b     // Catch:{ all -> 0x0030 }
                if (r5 != 0) goto L_0x001b
                r5 = 0
                goto L_0x002d
            L_0x001b:
                android.os.IInterface r1 = r5.queryLocalInterface(r0)     // Catch:{ all -> 0x0030 }
                boolean r2 = r1 instanceof com.geetest.core.a5.b     // Catch:{ all -> 0x0030 }
                if (r2 == 0) goto L_0x0027
                r5 = r1
                com.geetest.core.a5$b r5 = (com.geetest.core.a5.b) r5     // Catch:{ all -> 0x0030 }
                goto L_0x002d
            L_0x0027:
                com.geetest.core.a5$b r1 = new com.geetest.core.a5$b     // Catch:{ all -> 0x0030 }
                r1.<init>(r5, r0)     // Catch:{ all -> 0x0030 }
                r5 = r1
            L_0x002d:
                r3.f5910a = r5     // Catch:{ all -> 0x0030 }
                return r4
            L_0x0030:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.a5.d.a(android.content.Context, android.content.Intent):boolean");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f5913d = iBinder;
                this.f5912c.countDown();
            } catch (Throwable unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f5910a = null;
            this.f5913d = null;
        }
    }

    public static class e implements c {

        /* renamed from: a  reason: collision with root package name */
        public static String f5914a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f5915b;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f5916c;

        /* renamed from: d  reason: collision with root package name */
        public static final CountDownLatch f5917d = new CountDownLatch(1);

        /* renamed from: e  reason: collision with root package name */
        public final String f5918e;

        /* renamed from: f  reason: collision with root package name */
        public final String f5919f = null;

        /* renamed from: g  reason: collision with root package name */
        public final String f5920g;

        /* renamed from: h  reason: collision with root package name */
        public final String f5921h;

        /* renamed from: i  reason: collision with root package name */
        public d f5922i;

        public e(String str, String str2, String str3, String str4) {
            this.f5918e = str;
            this.f5920g = str3;
            this.f5921h = str4;
        }

        public boolean a(Context context) {
            if (f5916c) {
                return f5915b;
            }
            boolean z10 = false;
            if (context == null || TextUtils.isEmpty(this.f5918e)) {
                f5915b = false;
            } else {
                try {
                    if (a5.f5907d == null) {
                        a5.f5907d = context.getPackageManager();
                    }
                    PackageInfo packageInfo = a5.f5907d.getPackageInfo(this.f5918e, 0);
                    if (Build.VERSION.SDK_INT < 28) {
                        if (packageInfo != null && packageInfo.versionCode > 0) {
                            z10 = true;
                        }
                        f5915b = z10;
                    } else if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Throwable unused) {
                    return false;
                }
            }
            f5916c = true;
            return f5915b;
        }
    }

    static {
        Build.MANUFACTURER.toUpperCase();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:36|(4:42|43|44|(1:48))|49|50|52) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00a4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5) {
        /*
            com.geetest.core.a5$c r0 = f5904a
            if (r0 == 0) goto L_0x006e
            if (r5 == 0) goto L_0x006e
            android.content.Context r5 = r5.getApplicationContext()
            f5905b = r5
            if (r5 != 0) goto L_0x000f
            goto L_0x006e
        L_0x000f:
            r1 = r0
            com.geetest.core.a5$e r1 = (com.geetest.core.a5.e) r1     // Catch:{ all -> 0x006e }
            boolean r5 = r1.a(r5)     // Catch:{ all -> 0x006e }
            if (r5 == 0) goto L_0x006e
            android.content.Context r5 = f5905b
            com.geetest.core.a5$e r0 = (com.geetest.core.a5.e) r0
            r0.getClass()
            if (r5 == 0) goto L_0x006b
            java.lang.String r1 = r0.f5918e
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006b
            com.geetest.core.a5$d r1 = r0.f5922i
            if (r1 != 0) goto L_0x0038
            com.geetest.core.a5$d r1 = new com.geetest.core.a5$d
            java.lang.String r2 = r0.f5921h
            java.util.concurrent.CountDownLatch r3 = com.geetest.core.a5.e.f5917d
            r1.<init>(r2, r3)
            r0.f5922i = r1
        L_0x0038:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = r0.f5919f
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r0.f5918e
            r1.setPackage(r2)
            goto L_0x0057
        L_0x004b:
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = r0.f5918e
            java.lang.String r4 = r0.f5919f
            r2.<init>(r3, r4)
            r1.setComponent(r2)
        L_0x0057:
            java.lang.String r2 = r0.f5920g
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0064
            java.lang.String r2 = r0.f5920g
            r1.setAction(r2)
        L_0x0064:
            com.geetest.core.a5$d r0 = r0.f5922i
            boolean r5 = r0.a(r5, r1)
            goto L_0x006c
        L_0x006b:
            r5 = 0
        L_0x006c:
            f5906c = r5
        L_0x006e:
            boolean r5 = f5906c
            r0 = 0
            if (r5 == 0) goto L_0x00a6
            android.content.Context r1 = f5905b     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0078
            goto L_0x00a6
        L_0x0078:
            com.geetest.core.a5$c r2 = f5904a     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x00a6
            if (r5 == 0) goto L_0x00a6
            com.geetest.core.a5$e r2 = (com.geetest.core.a5.e) r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = com.geetest.core.a5.e.f5914a     // Catch:{ all -> 0x00a6 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            com.geetest.core.a5$d r5 = r2.f5922i     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            com.geetest.core.a5$b r5 = r5.f5910a     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a4
            r3 = 1
            java.lang.String r5 = r5.a(r0, r0, r0, r3)     // Catch:{ all -> 0x00a4 }
            com.geetest.core.a5.e.f5914a = r5     // Catch:{ all -> 0x00a4 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a4 }
            if (r5 != 0) goto L_0x00a4
            com.geetest.core.a5$d r5 = r2.f5922i     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x00a4
            r1.unbindService(r5)     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            java.lang.String r0 = com.geetest.core.a5.e.f5914a     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.a5.a(android.content.Context):java.lang.String");
    }
}
