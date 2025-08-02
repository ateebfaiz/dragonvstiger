package p1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.component.MTCommonService;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import u1.m;
import u1.n;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f23052a = true;

    /* renamed from: b  reason: collision with root package name */
    public static Context f23053b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f23054c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f23055d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f23056e = false;

    /* renamed from: f  reason: collision with root package name */
    private static String f23057f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f23058g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f23059h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f23060i = null;

    /* renamed from: j  reason: collision with root package name */
    private static int f23061j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static String f23062k = null;

    /* renamed from: l  reason: collision with root package name */
    private static MTCommonService f23063l = null;

    /* renamed from: m  reason: collision with root package name */
    private static MTCommonReceiver f23064m = null;

    /* renamed from: n  reason: collision with root package name */
    private static AtomicBoolean f23065n = null;

    /* renamed from: o  reason: collision with root package name */
    private static AtomicBoolean f23066o = null;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f23067p = false;

    /* renamed from: q  reason: collision with root package name */
    private static int f23068q = 0;

    /* renamed from: r  reason: collision with root package name */
    private static String f23069r = "unknown";

    /* renamed from: s  reason: collision with root package name */
    private static String f23070s = "";

    /* renamed from: t  reason: collision with root package name */
    private static boolean f23071t = false;

    /* renamed from: u  reason: collision with root package name */
    private static String f23072u = "";

    /* renamed from: v  reason: collision with root package name */
    private static String f23073v;

    /* renamed from: w  reason: collision with root package name */
    private static int f23074w;

    public static boolean A(Context context) {
        AtomicBoolean atomicBoolean = f23066o;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        f23066o = new AtomicBoolean(false);
        try {
            String l10 = l(context);
            if (TextUtils.isEmpty(l10)) {
                f23066o.set(true);
            }
            if (TextUtils.equals(l10, w(context, h(context).getClass()))) {
                f23066o.set(true);
            }
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "isRemoteProcess failed " + th.getMessage());
        }
        return f23066o.get();
    }

    public static void B(String str) {
        f23073v = str;
    }

    public static void C(String str) {
        f23072u = str;
    }

    public static void D(boolean z10) {
        f23055d = z10;
    }

    public static void E(boolean z10) {
        f23071t = z10;
    }

    public static void F(String str) {
        f23069r = str;
    }

    public static void G(String str) {
        f23070s = str;
    }

    public static void H(boolean z10) {
        f23067p = z10;
    }

    public static void I(int i10) {
        f23068q = i10;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f23058g)) {
            f23058g = r(context, "ENGAGELAB_PRIVATES_CHANNEL");
        }
        return f23058g;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f23057f)) {
            f23057f = r(context, "ENGAGELAB_PRIVATES_APPKEY");
        }
        return f23057f;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f23059h)) {
            f23059h = r(context, "ENGAGELAB_PRIVATES_PROCESS");
        }
        return f23059h;
    }

    public static int d(Context context) {
        int i10 = f23061j;
        if (i10 != 0) {
            return i10;
        }
        try {
            int i11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            f23061j = i11;
            return i11;
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getAppVersionCode failed: " + th.getMessage());
            return 0;
        }
    }

    public static String e(Context context) {
        if (!TextUtils.isEmpty(f23062k)) {
            return f23062k;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f23062k = str;
            return str;
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getAppVersionName failed: " + th.getMessage());
            return "";
        }
    }

    public static MTCommonReceiver f(Context context) {
        MTCommonReceiver g10 = g(context);
        if (g10 == null) {
            s1.a.h("MTGlobal", "getCommonReceiver is null");
        }
        return g10;
    }

    private static MTCommonReceiver g(Context context) {
        MTCommonReceiver mTCommonReceiver = f23064m;
        if (mTCommonReceiver != null) {
            return mTCommonReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.engagelab.privates.intent.USER_RECEIVER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str = activityInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonReceiver.class.isAssignableFrom(cls)) {
                            MTCommonReceiver mTCommonReceiver2 = (MTCommonReceiver) cls.newInstance();
                            f23064m = mTCommonReceiver2;
                            return mTCommonReceiver2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getCommonReceiver failed " + th.getMessage());
            return null;
        }
    }

    public static MTCommonService h(Context context) {
        MTCommonService i10 = i(context);
        if (i10 == null) {
            s1.a.h("MTGlobal", "getCommonService is null");
        }
        return i10;
    }

    private static MTCommonService i(Context context) {
        MTCommonService mTCommonService = f23063l;
        if (mTCommonService != null) {
            return mTCommonService;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.engagelab.privates.intent.USER_SERVICE");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentServices(intent, 0)) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str = serviceInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonService.class.isAssignableFrom(cls)) {
                            MTCommonService mTCommonService2 = (MTCommonService) cls.newInstance();
                            f23063l = mTCommonService2;
                            return mTCommonService2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getCommonService failed " + th.getMessage());
            return null;
        }
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(f23073v)) {
            f23073v = n.a(context);
        }
        return f23073v;
    }

    public static String k() {
        return f23072u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f A[Catch:{ all -> 0x007b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC, Splitter:B:38:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9 A[SYNTHETIC, Splitter:B:47:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String l(android.content.Context r9) {
        /*
            r9 = 1
            java.lang.String r0 = "MTGlobal"
            java.lang.String r1 = "getCurrentProcessName failed "
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0010 }
            r3 = 28
            if (r2 < r3) goto L_0x0027
            java.lang.String r9 = android.app.Application.getProcessName()     // Catch:{ all -> 0x0010 }
            return r9
        L_0x0010:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            s1.a.h(r0, r2)
        L_0x0027:
            java.lang.String r2 = "android.app.ActivityThread"
            r3 = 0
            r4 = 0
            java.lang.Class<android.app.Application> r5 = android.app.Application.class
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0049 }
            java.lang.Class r2 = java.lang.Class.forName(r2, r3, r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = "currentProcessName"
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r4)     // Catch:{ all -> 0x0049 }
            r2.setAccessible(r9)     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.invoke(r4, r4)     // Catch:{ all -> 0x0049 }
            boolean r5 = r2 instanceof java.lang.String     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0060
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0049 }
            return r2
        L_0x0049:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r2 = r2.getMessage()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            s1.a.h(r0, r2)
        L_0x0060:
            java.lang.String r2 = "/proc/self/cmdline"
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x00c0 }
            r5.<init>(r2)     // Catch:{ all -> 0x00c0 }
            r2 = 256(0x100, float:3.59E-43)
            byte[] r4 = new byte[r2]     // Catch:{ all -> 0x007b }
            r6 = r3
        L_0x006c:
            int r7 = r5.read()     // Catch:{ all -> 0x007b }
            if (r7 <= 0) goto L_0x007d
            if (r6 >= r2) goto L_0x007d
            int r8 = r6 + 1
            byte r7 = (byte) r7     // Catch:{ all -> 0x007b }
            r4[r6] = r7     // Catch:{ all -> 0x007b }
            r6 = r8
            goto L_0x006c
        L_0x007b:
            r9 = move-exception
            goto L_0x00be
        L_0x007d:
            if (r6 <= 0) goto L_0x00a2
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x007b }
            java.lang.String r2 = "UTF-8"
            r9.<init>(r4, r3, r6, r2)     // Catch:{ all -> 0x007b }
            r5.close()     // Catch:{ all -> 0x008a }
            goto L_0x00a1
        L_0x008a:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = r2.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            s1.a.h(r0, r1)
        L_0x00a1:
            return r9
        L_0x00a2:
            r5.close()     // Catch:{ all -> 0x00a6 }
            goto L_0x00f4
        L_0x00a6:
            r9 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r9 = r9.getMessage()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            s1.a.h(r0, r9)
            goto L_0x00f4
        L_0x00be:
            r4 = r5
            goto L_0x00c1
        L_0x00c0:
            r9 = move-exception
        L_0x00c1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r2.<init>()     // Catch:{ all -> 0x00f7 }
            r2.append(r1)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f7 }
            r2.append(r9)     // Catch:{ all -> 0x00f7 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00f7 }
            s1.a.h(r0, r9)     // Catch:{ all -> 0x00f7 }
            if (r4 == 0) goto L_0x00f4
            r4.close()     // Catch:{ all -> 0x00dd }
            goto L_0x00f4
        L_0x00dd:
            r9 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r9 = r9.getMessage()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            s1.a.h(r0, r9)
        L_0x00f4:
            java.lang.String r9 = ""
            return r9
        L_0x00f7:
            r9 = move-exception
            if (r4 == 0) goto L_0x0115
            r4.close()     // Catch:{ all -> 0x00fe }
            goto L_0x0115
        L_0x00fe:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = r2.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            s1.a.h(r0, r1)
        L_0x0115:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.a.l(android.content.Context):java.lang.String");
    }

    public static boolean m() {
        return f23055d;
    }

    public static String n(Context context) {
        String str;
        String a10 = m1.a.a(context);
        if (!TextUtils.isEmpty(a10)) {
            return a10;
        }
        try {
            str = m.b(" " + Settings.Secure.getString(context.getContentResolver(), "android_id") + " " + (Build.PRODUCT.toLowerCase() + "_" + Build.TIME));
        } catch (Throwable unused) {
            str = m.b(" " + UUID.randomUUID().toString() + "  ");
        }
        m1.a.e(context, str);
        return str;
    }

    public static int o() {
        return f23074w;
    }

    public static boolean p() {
        return f23071t;
    }

    private static String q(Context context) {
        return context.getPackageName();
    }

    public static String r(Context context, String str) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) {
                return "";
            }
            return String.valueOf(obj);
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getMetaData failed " + th.getMessage());
        }
        return "";
    }

    public static String s() {
        return f23069r;
    }

    public static String t() {
        return f23070s;
    }

    public static boolean u() {
        return f23067p;
    }

    public static int v() {
        return f23068q;
    }

    private static String w(Context context, Class cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), cls.getCanonicalName()), 128).processName;
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "getRemoteProcessName failed " + th.getMessage());
            return "";
        }
    }

    public static boolean x() {
        return f23056e;
    }

    public static String y(Context context) {
        if (TextUtils.isEmpty(f23060i)) {
            f23060i = r(context, "ENGAGELAB_PRIVATES_TRANSFER");
        }
        return f23060i;
    }

    public static boolean z(Context context) {
        AtomicBoolean atomicBoolean = f23065n;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        f23065n = new AtomicBoolean(false);
        try {
            if (TextUtils.equals(l(context), q(context))) {
                f23065n.set(true);
            }
        } catch (Throwable th) {
            s1.a.h("MTGlobal", "isMainProcess failed " + th.getMessage());
        }
        return f23065n.get();
    }
}
