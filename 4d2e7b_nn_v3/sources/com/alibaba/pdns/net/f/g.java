package com.alibaba.pdns.net.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class g extends a {
    public static final int A = 0;
    public static final int B = 1;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static Context f18121n = null;

    /* renamed from: o  reason: collision with root package name */
    private static volatile g f18122o = null;

    /* renamed from: p  reason: collision with root package name */
    public static final String f18123p = "46000";

    /* renamed from: q  reason: collision with root package name */
    public static final String f18124q = "46002";

    /* renamed from: r  reason: collision with root package name */
    public static final String f18125r = "46007";

    /* renamed from: s  reason: collision with root package name */
    public static final String f18126s = "46020";

    /* renamed from: t  reason: collision with root package name */
    public static final String f18127t = "46001";

    /* renamed from: u  reason: collision with root package name */
    public static final String f18128u = "46006";

    /* renamed from: v  reason: collision with root package name */
    public static final String f18129v = "46009";

    /* renamed from: w  reason: collision with root package name */
    public static final String f18130w = "46003";

    /* renamed from: x  reason: collision with root package name */
    public static final String f18131x = "46005";

    /* renamed from: y  reason: collision with root package name */
    public static final String f18132y = "46011";

    /* renamed from: z  reason: collision with root package name */
    public static final int f18133z = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f18134k = -1111;

    /* renamed from: l  reason: collision with root package name */
    public String f18135l = "";

    /* renamed from: m  reason: collision with root package name */
    public int f18136m = 0;

    public static class a {
        public static String a(String str) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case 49679470:
                    if (str.equals(g.f18123p)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 49679471:
                    if (str.equals(g.f18127t)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 49679472:
                    if (str.equals(g.f18124q)) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 49679473:
                    if (str.equals(g.f18130w)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 49679475:
                    if (str.equals(g.f18131x)) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 49679476:
                    if (str.equals(g.f18128u)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 49679477:
                    if (str.equals(g.f18125r)) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 49679479:
                    if (str.equals(g.f18129v)) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 49679502:
                    if (str.equals(g.f18132y)) {
                        c10 = 8;
                        break;
                    }
                    break;
                case 49679532:
                    if (str.equals(g.f18126s)) {
                        c10 = 9;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 2:
                case 6:
                case 9:
                    return a.f18117j;
                case 1:
                case 5:
                case 7:
                    return a.f18116i;
                case 3:
                case 4:
                case 8:
                    return a.f18115h;
                default:
                    return str;
            }
        }

        public static String b() {
            ArrayList<T> list;
            try {
                if (!(NetworkInterface.getNetworkInterfaces() == null || (list = Collections.list(NetworkInterface.getNetworkInterfaces())) == null || list.size() <= 0)) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Iterator<T> it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                InetAddress inetAddress = (InetAddress) it2.next();
                                if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                                    return inetAddress.getHostAddress();
                                }
                            }
                        }
                    }
                }
            } catch (SocketException e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            } catch (Error | Exception e11) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e11.printStackTrace();
                }
            }
            return "0";
        }

        public static boolean c() {
            try {
                NetworkInfo a10 = a();
                if (a10 == null || !a10.isAvailable() || a10.getState() != NetworkInfo.State.CONNECTED) {
                    return false;
                }
                return true;
            } catch (Error | Exception e10) {
                if (!com.alibaba.pdns.u.a.f18279a) {
                    return false;
                }
                e10.printStackTrace();
                return false;
            }
        }

        public static int d() {
            NetworkInfo a10;
            try {
                if (f() && (a10 = a()) != null) {
                    if (a10.getType() == 1) {
                        return 1;
                    }
                    if (a10.getType() != 0) {
                        return 0;
                    }
                    switch (a10.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 3;
                        case 13:
                        case 18:
                            return 4;
                        case 20:
                            return 5;
                        default:
                            String subtypeName = a10.getSubtypeName();
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return 3;
                            }
                            return 0;
                    }
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
            return -1;
        }

        public static String e() {
            TelephonyManager telephonyManager;
            try {
                if (g.f18121n == null || (telephonyManager = (TelephonyManager) g.f18121n.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) == null) {
                    return "";
                }
                String simOperator = telephonyManager.getSimOperator();
                if (!TextUtils.isEmpty(simOperator)) {
                    return a(simOperator);
                }
                return "";
            } catch (Error | Exception e10) {
                if (!com.alibaba.pdns.u.a.f18279a) {
                    return "";
                }
                e10.printStackTrace();
                return "";
            }
        }

        public static boolean f() {
            ConnectivityManager connectivityManager;
            NetworkCapabilities networkCapabilities;
            try {
                if (g.f18121n == null || (connectivityManager = (ConnectivityManager) g.f18121n.getSystemService("connectivity")) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                    return false;
                }
                return networkCapabilities.hasCapability(12);
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
                return true;
            }
        }

        public static NetworkInfo a() {
            ConnectivityManager connectivityManager;
            try {
                if (g.f18121n == null || (connectivityManager = (ConnectivityManager) g.f18121n.getSystemService("connectivity")) == null) {
                    return null;
                }
                return connectivityManager.getActiveNetworkInfo();
            } catch (Error | Exception e10) {
                if (!com.alibaba.pdns.u.a.f18279a) {
                    return null;
                }
                e10.printStackTrace();
                return null;
            }
        }
    }

    private g() {
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (f18121n != applicationContext) {
                    f18121n = applicationContext;
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static g d() {
        if (f18122o == null) {
            synchronized (g.class) {
                try {
                    if (f18122o == null) {
                        f18122o = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18122o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b() {
        /*
            r2 = this;
            int r0 = com.alibaba.pdns.net.f.g.a.d()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r2.f18134k = r0     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r1 = 1
            if (r0 == r1) goto L_0x0021
            r1 = 2
            if (r0 == r1) goto L_0x0016
            r1 = 3
            if (r0 == r1) goto L_0x0016
            r1 = 4
            if (r0 == r1) goto L_0x0016
            r1 = 5
            if (r0 == r1) goto L_0x0016
            goto L_0x002d
        L_0x0016:
            java.lang.String r0 = com.alibaba.pdns.net.f.g.a.e()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r2.f18135l = r0     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x002d
        L_0x001d:
            r0 = move-exception
            goto L_0x0026
        L_0x001f:
            r0 = move-exception
            goto L_0x0026
        L_0x0021:
            java.lang.String r0 = "WIFI"
            r2.f18135l = r0     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x002d
        L_0x0026:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x002d
            r0.printStackTrace()
        L_0x002d:
            java.lang.String r0 = r2.f18135l
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.f.g.b():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a() {
        /*
            r2 = this;
            int r0 = com.alibaba.pdns.net.f.g.a.d()     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
            r2.f18134k = r0     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
            switch(r0) {
                case -1: goto L_0x0016;
                case 0: goto L_0x0016;
                case 1: goto L_0x0012;
                case 2: goto L_0x000a;
                case 3: goto L_0x000a;
                case 4: goto L_0x000a;
                case 5: goto L_0x000a;
                default: goto L_0x0009;
            }     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
        L_0x0009:
            goto L_0x0021
        L_0x000a:
            r0 = 1
            r2.f18136m = r0     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
            goto L_0x0021
        L_0x000e:
            r0 = move-exception
            goto L_0x001a
        L_0x0010:
            r0 = move-exception
            goto L_0x001a
        L_0x0012:
            r0 = 0
            r2.f18136m = r0     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
            goto L_0x0021
        L_0x0016:
            r0 = -1
            r2.f18136m = r0     // Catch:{ Exception -> 0x0010, Error -> 0x000e }
            goto L_0x0021
        L_0x001a:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0021
            r0.printStackTrace()
        L_0x0021:
            int r0 = r2.f18136m
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.f.g.a():int");
    }
}
