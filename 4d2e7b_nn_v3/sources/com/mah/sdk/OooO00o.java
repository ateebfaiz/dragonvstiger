package com.mah.sdk;

import OooOoO0.OooO0oO;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.alibaba.pdns.f;
import com.mah.ndk.MahxServer;
import com.mah.sdk.MahProxy;
import d.h;
import g.m;
import h.g;
import i.i;
import i.k;
import i.n;
import i.p;
import i.v;
import i.w;
import java.io.File;
import java.io.FilenameFilter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.HostnameVerifier;
import r9.b;
import w.d;

public class OooO00o {
    public static final int OooO = 1;
    public static final String OooO00o = d.f("");
    public static final int OooO0O0 = 1;
    public static final int OooO0OO = 2;
    public static final int OooO0Oo = 0;
    public static final int OooO0o = -2;

    /* renamed from: OooO0o0  reason: collision with root package name */
    public static final int f10169OooO0o0 = -1;
    public static final String OooO0oO = "wlan0";
    public static final int OooO0oo = 0;
    public static final int OooOO0 = 2;
    public static final int OooOO0O = 3;
    public static final Handler OooOO0o = new Handler(Looper.getMainLooper());
    public static final String OooOOO = "mahsdk_preference";
    public static final String OooOOO0 = "com.mah.shared_preference.app_";
    public static final AtomicReference<char[]> OooOOOO = new AtomicReference<>((Object) null);
    public static final AtomicReference<OooO0OO> OooOOOo = new AtomicReference<>((Object) null);
    public static final AtomicReference<String> OooOOo0 = new AtomicReference<>((Object) null);

    /* renamed from: com.mah.sdk.OooO00o$OooO00o  reason: collision with other inner class name */
    public class C0119OooO00o implements FilenameFilter {
        public final /* synthetic */ String OooO00o;

        public C0119OooO00o(String str) {
            this.OooO00o = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.OooO00o);
        }
    }

    public class OooO0O0 implements FilenameFilter {
        public boolean accept(File file, String str) {
            return str.startsWith("debug.log");
        }
    }

    public static class OooO0OO {
        public final int OooO00o;
        public final int OooO0O0;

        public OooO0OO(int i10, int i11) {
            this.OooO00o = i10;
            this.OooO0O0 = i11;
        }
    }

    public static SharedPreferences OooO00o(Context context, String str) {
        return context.getSharedPreferences(OooOOO0 + str, 0);
    }

    public static int OooO0O0(int i10) {
        return i10;
    }

    public static String OooO0OO() {
        AtomicReference<char[]> atomicReference = OooOOOO;
        char[] cArr = atomicReference.get();
        if (cArr != null) {
            return new String(cArr);
        }
        String OooO0o02 = MahxServer.OooO0o0();
        if (!TextUtils.isEmpty(OooO0o02)) {
            atomicReference.set(OooO0o02.toCharArray());
        }
        return OooO0o02;
    }

    public static String OooO0Oo() {
        return "android/" + Build.VERSION.RELEASE;
    }

    public static boolean OooO0o() {
        return false;
    }

    public static int OooO0o0() {
        return 3;
    }

    public static String OooO0O0() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String OooO0Oo(Context context) {
        return OooO0OO(context, "unknown");
    }

    public static boolean OooO0o(Context context) {
        try {
            context.getPackageManager().getServiceInfo(new ComponentName(context, OooO0oO.class), 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static SharedPreferences OooO0o0(Context context) {
        return context.getSharedPreferences(OooOOO, 0);
    }

    public static String OooO00o(Context context) {
        AtomicReference<String> atomicReference = OooOOo0;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(v.a(context), 0);
            if (packageInfo == null) {
                return "";
            }
            atomicReference.set(packageInfo.versionName);
            return atomicReference.get();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String OooO0O0(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return new k(context).c();
    }

    public static String OooO0Oo(String str) {
        return w.f(str, OooO0OO());
    }

    public static void OooO0o0(Context context, String str) {
        OooO00o((Runnable) new b(context, String.format(Locale.US, "mah: %s", new Object[]{str})));
    }

    public static MahProxy.ProxyChangedReason OooO0Oo(int i10) {
        MahProxy.ProxyChangedReason[] values = MahProxy.ProxyChangedReason.values();
        if (i10 < values.length) {
            return values[i10];
        }
        return MahProxy.ProxyChangedReason.UNKNOWN;
    }

    public static void OooO0O0(d.k kVar, String str) {
        OooO00o(kVar, MessageFormat.format("Authentication failure({0})", new Object[]{str}));
    }

    public static OooO0OO OooO0OO(Context context) {
        AtomicReference<OooO0OO> atomicReference = OooOOOo;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        DisplayMetrics t10 = v.t(context);
        if (t10 == null) {
            return new OooO0OO(0, 0);
        }
        atomicReference.set(new OooO0OO(t10.widthPixels, t10.heightPixels));
        return atomicReference.get();
    }

    public static void OooO0O0(d.k kVar) {
        OooO00o(kVar, "SDK terminated");
    }

    public static void OooO0O0(Context context, String str, boolean z10) throws h {
        if (!OooO0o()) {
            OooO00o(context, str, z10);
            if (!n.k(context)) {
                throw new h("unzip mah data failed", -18);
            } else if (!OooO0OO(context, true)) {
                throw new h("initial ssl failed", -22);
            }
        } else {
            throw new h("Only support Android 5.0 and above", -5);
        }
    }

    public static int OooO00o(Context context, m mVar) {
        return 2;
    }

    public static void OooO00o(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable can not be null");
        } else if (v.p()) {
            runnable.run();
        } else {
            OooOO0o.post(runnable);
        }
    }

    public static String OooO0OO(String str) {
        return w.f(str, OooO0OO());
    }

    public static String OooO0OO(Context context, String str) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager == null) {
                return str;
            }
            String simOperator = telephonyManager.getSimOperator();
            return TextUtils.isEmpty(simOperator) ? str : simOperator;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String OooO0O0(Context context) {
        String str = v.j(context) + File.separator + "com.mah.sdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    public static void OooO00o(Runnable runnable, long j10) {
        if (runnable != null) {
            OooOO0o.postDelayed(runnable, j10);
            return;
        }
        throw new IllegalArgumentException("runnable can not be null");
    }

    public static void OooO0OO(d.k kVar) {
        OooO00o(kVar, kVar.s() ? "Origin mode" : "Acceleration mode");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.f21787m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean OooO00o(h.g r1) {
        /*
            boolean r0 = r1.f21777c
            if (r0 == 0) goto L_0x000f
            int r1 = r1.f21787m
            r0 = 2
            if (r1 == r0) goto L_0x000f
            r0 = 3
            if (r1 != r0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r1 = 1
            return r1
        L_0x000f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mah.sdk.OooO00o.OooO00o(h.g):boolean");
    }

    public static void OooO00o(d.k kVar, String str) {
        if (OooO00o(kVar.o())) {
            OooO0o0(kVar.OooO00o(), str);
        }
    }

    public static void OooO0O0(String str) {
        File[] listFiles = new File(str).listFiles(new OooO0O0());
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
                file.getName();
            }
        }
    }

    public static boolean OooO0OO(Context context, boolean z10) {
        if (!n.i(context)) {
            return false;
        }
        String[] l10 = n.l();
        if (n.g(l10, z10)) {
            return true;
        }
        if (d.j() && l10 != null) {
            for (String str : l10) {
            }
        }
        return false;
    }

    public static void OooO00o(d.k kVar) {
        OooO00o(kVar, "Authentication successful");
    }

    public static void OooO00o(Context context, String str, boolean z10) throws h {
        int OooO00o2 = MahxServer.OooO00o(context);
        if (OooO00o2 == 0) {
            OooO00o();
            try {
                String OooO0Oo2 = MahxServer.OooO0Oo();
                String version = MahProxy.getVersion();
                if (version.startsWith(OooO0Oo2 + f.G)) {
                    try {
                        int OooO00o3 = MahxServer.OooO00o(context, str, z10);
                        if (OooO00o3 != 0) {
                            throw new h(String.format(Locale.US, "init Mahx failed, error code: %d", new Object[]{Integer.valueOf(OooO00o3)}), -2);
                        }
                    } catch (i e10) {
                        throw new h(e10.getMessage(), -2);
                    }
                } else {
                    throw new h("Invalid libmahjni.so's version: " + OooO0Oo2, -14);
                }
            } catch (i e11) {
                throw new h(e11.getMessage(), -2);
            }
        } else {
            throw new h(String.format(Locale.US, "load mahjni failed, error code: %d", new Object[]{Integer.valueOf(OooO00o2)}), -2);
        }
    }

    public static int OooO0O0(Context context, boolean z10) {
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    if (!nextElement.isPointToPoint()) {
                        if (!z10 || OooO0oO.equals(nextElement.getDisplayName())) {
                            Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement2 = inetAddresses.nextElement();
                                if (!nextElement2.isLoopbackAddress()) {
                                    if (!nextElement2.isLinkLocalAddress()) {
                                        nextElement2.getHostAddress();
                                        if (nextElement2 instanceof Inet4Address) {
                                            nextElement.getName();
                                            nextElement.isVirtual();
                                            i10 |= 1;
                                        } else if (nextElement2 instanceof Inet6Address) {
                                            nextElement.getName();
                                            nextElement.isVirtual();
                                            i10 |= 2;
                                        } else {
                                            nextElement.getName();
                                            nextElement.isVirtual();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return i10;
    }

    public static boolean OooO0OO(Context context, String str, boolean z10) throws PackageManager.NameNotFoundException {
        Bundle bundle = context.getPackageManager().getApplicationInfo(v.a(context), 128).metaData;
        return bundle != null ? bundle.getBoolean(str) : z10;
    }

    public static void OooO0OO(MahProxyAddress mahProxyAddress) {
        if (d.j() && mahProxyAddress != null) {
            OooO00o(mahProxyAddress);
        }
    }

    public static MahProxy.ProxyChangedReason OooO0OO(int i10) {
        if (i10 == -18) {
            return MahProxy.ProxyChangedReason.START_FAILED_UNZIP_CERT;
        }
        if (i10 == -14) {
            return MahProxy.ProxyChangedReason.START_FAILED_SO_VERSION_MISMATCH;
        }
        if (i10 == -5) {
            return MahProxy.ProxyChangedReason.START_FAILED_ANDROID_API;
        }
        if (i10 != -2) {
            return MahProxy.ProxyChangedReason.START_FAILED_UNKNOWN;
        }
        return MahProxy.ProxyChangedReason.START_FAILED_LOAD_SO_FAILED;
    }

    public static String OooO0OO(s.d dVar) {
        if (dVar.H("X-Via-Mah").equals("NODE")) {
            return dVar.H("X-Mah-Node-Ip");
        }
        return "";
    }

    public static void OooO00o() {
        String str;
        try {
            str = MahxServer.OooO0O0();
        } catch (i unused) {
            str = "unknown";
        }
        d.k("MAH", String.format(Locale.US, "Current CPU is %s", new Object[]{str}));
        v.m(str);
    }

    public static void OooO00o(OooO0o0.OooO0O0 oooO0O0, String str) {
        boolean z10 = oooO0O0.f13465a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String OooO00o(android.content.Context r3, boolean r4) {
        /*
            java.lang.String r0 = "com.mah.sdk"
            java.lang.String r1 = ""
            if (r4 == 0) goto L_0x0025
            java.lang.String r4 = i.v.v(r3)
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 != 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            r2.append(r4)
            r2.append(r0)
            java.lang.String r4 = r2.toString()
            goto L_0x0026
        L_0x0025:
            r4 = r1
        L_0x0026:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = i.v.j(r3)
            r4.append(r2)
            java.lang.String r2 = java.io.File.separator
            r4.append(r2)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
        L_0x0044:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0056
            boolean r2 = r0.mkdirs()
            if (r2 != 0) goto L_0x0056
            return r1
        L_0x0056:
            java.lang.String r3 = i.v.s(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x0061
            return r4
        L_0x0061:
            java.lang.String r3 = OooO00o((java.io.File) r0, (java.lang.String) r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mah.sdk.OooO00o.OooO00o(android.content.Context, boolean):java.lang.String");
    }

    public static void OooO0O0(g gVar) {
    }

    public static String OooO0O0(String str, String str2) {
        return p.b(str + f.f17924q + str2);
    }

    public static boolean OooO0O0(s.d dVar) {
        return "0".equals(dVar.H("X-Mah-Rsp-Type"));
    }

    public static boolean OooO0O0(MahProxyAddress mahProxyAddress) {
        return mahProxyAddress != null && !TextUtils.isEmpty(mahProxyAddress.getHost()) && mahProxyAddress.getPort() > 0;
    }

    public static String OooO00o(File file, String str) {
        File file2 = new File(file, str);
        if (file2.exists() || file2.mkdirs()) {
            return file2.getAbsolutePath();
        }
        String b10 = p.b(str);
        if (b10 == null) {
            return "";
        }
        File file3 = new File(file, b10);
        if (file3.exists()) {
            return file3.getAbsolutePath();
        }
        if (file3.mkdirs()) {
            return file3.getAbsolutePath();
        }
        file3.getAbsolutePath();
        return "";
    }

    public static void OooO00o(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    if (file.delete()) {
                        file.getAbsolutePath();
                    } else {
                        file.getAbsolutePath();
                    }
                }
            }
        }
    }

    public static void OooO00o(String str, String str2) {
        File[] listFiles;
        if (!TextUtils.isEmpty(str) && (listFiles = new File(str).listFiles(new C0119OooO00o(str2))) != null) {
            for (File file : listFiles) {
                if (file.delete()) {
                    file.getAbsolutePath();
                } else {
                    file.getAbsolutePath();
                }
            }
        }
    }

    public static h OooO00o(int i10) {
        if (i10 == 2) {
            return new h("Service start failed", -7);
        }
        if (i10 == 4) {
            return new h("Create service config error", -15);
        }
        if (i10 != 5) {
            return new h("Unknown Service start error", i10);
        }
        return new h("Service start failed case ndk abnormal exit.", -7);
    }

    public static String OooO00o(Date date, String str) {
        return new SimpleDateFormat(str, Locale.US).format(date);
    }

    public static boolean OooO00o(long j10, boolean z10) {
        return !z10 || j10 == 0 || System.currentTimeMillis() > j10;
    }

    public static String OooO00o(MahProxyAddress mahProxyAddress) {
        return String.format(Locale.US, "%s:%d;handshake=%b", new Object[]{mahProxyAddress.getHost(), Integer.valueOf(mahProxyAddress.getPort()), Boolean.valueOf(mahProxyAddress.isHandshake())});
    }

    public static boolean OooO00o(s.d dVar) {
        return "10503".equals(dVar.H("X-Mah-Connect-Error"));
    }

    public static s.d OooO00o(String str, MahProxyAddress mahProxyAddress) {
        return s.d.s(str).t(mahProxyAddress.getHost(), mahProxyAddress.getPort()).m(n.h(), n.b((HostnameVerifier) null));
    }
}
