package com.alibaba.pdns;

import android.text.TextUtils;
import com.alibaba.pdns.net.d;
import com.alibaba.pdns.net.f.g;
import com.alibaba.pdns.s.e.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> A = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> B = new CopyOnWriteArrayList<>();
    public static final String C = "temp_ipv4";
    public static final String D = "temp_ipv6";
    public static final String E = "temp_host";
    public static String F = ":";
    public static final String G = ".";
    public static h H = new h();
    public static Map<String, Object> I = new ConcurrentHashMap();
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> J = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> K = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> L = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> M = new CopyOnWriteArrayList<>();
    private static final String N = "/resolve?name=auto.sdk.alidns.com&type=SRV&uid=9999";
    private static final String O = "/conf?uid=";
    public static final String P = "/i?uid=";
    public static final Map<String, Integer> Q = new ConcurrentHashMap();
    public static final Map<String, Integer> R = new ConcurrentHashMap();
    public static q S = new q();
    public static q T = new q();
    public static long U = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f17908a = "223.5.5.5";

    /* renamed from: b  reason: collision with root package name */
    private static final String f17909b = "223.6.6.6";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17910c = "dns.alidns.com";

    /* renamed from: d  reason: collision with root package name */
    private static final String f17911d = "[2400:3200::1]";

    /* renamed from: e  reason: collision with root package name */
    private static final String f17912e = "[2400:3200:baba::1]";

    /* renamed from: f  reason: collision with root package name */
    private static String[] f17913f = {f17908a, f17909b};

    /* renamed from: g  reason: collision with root package name */
    private static String[] f17914g = {f17911d, f17912e};

    /* renamed from: h  reason: collision with root package name */
    private static String[] f17915h = {f17910c};

    /* renamed from: i  reason: collision with root package name */
    public static final String f17916i = "2.2.6";

    /* renamed from: j  reason: collision with root package name */
    public static long f17917j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static long f17918k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static int f17919l = 60;

    /* renamed from: m  reason: collision with root package name */
    public static int f17920m = 70;

    /* renamed from: n  reason: collision with root package name */
    public static String f17921n = "";

    /* renamed from: o  reason: collision with root package name */
    public static int f17922o = 0;

    /* renamed from: p  reason: collision with root package name */
    public static long f17923p = 0;

    /* renamed from: q  reason: collision with root package name */
    public static final String f17924q = "android";

    /* renamed from: r  reason: collision with root package name */
    public static String f17925r = "&v=";

    /* renamed from: s  reason: collision with root package name */
    public static String f17926s = "&p=";

    /* renamed from: t  reason: collision with root package name */
    public static String f17927t = "&ak=";

    /* renamed from: u  reason: collision with root package name */
    public static String f17928u = "&ev=";

    /* renamed from: v  reason: collision with root package name */
    public static int f17929v = 10000;

    /* renamed from: w  reason: collision with root package name */
    public static final int f17930w = 60;

    /* renamed from: x  reason: collision with root package name */
    public static boolean f17931x;

    /* renamed from: y  reason: collision with root package name */
    public static AtomicBoolean f17932y = new AtomicBoolean();

    /* renamed from: z  reason: collision with root package name */
    public static CopyOnWriteArrayList<com.alibaba.pdns.model.f> f17933z = new CopyOnWriteArrayList<>();

    static class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                com.alibaba.pdns.model.f c10 = f.c((Object) null);
                if (c10 != null) {
                    String str = c10.f18049e;
                    String accountId = DNSResolver.getAccountId();
                    if (e.a(str) && e.a(accountId) && e.a(DNSResolver.getAccessKeyId()) && e.a(DNSResolver.getAccessKeySecret())) {
                        com.alibaba.pdns.net.a.a(c.f18247l + str + f.O + DNSResolver.getAccountId() + f.f17925r + f.f17916i + f.f17926s + f.f17924q + f.f17927t + DNSResolver.getAccessKeyId() + f.f17928u + f.f17929v, str);
                    }
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    static class b implements Runnable {
        b() {
        }

        public void run() {
            try {
                com.alibaba.pdns.model.f c10 = f.c((Object) null);
                if (c10 != null) {
                    String str = c10.f18049e;
                    if (e.a(str)) {
                        com.alibaba.pdns.net.c.a(c.f18247l + str + f.N, str);
                    }
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private static void a(String[] strArr, String str) {
        if (e.a(strArr)) {
            for (String str2 : strArr) {
                com.alibaba.pdns.model.f fVar = new com.alibaba.pdns.model.f();
                fVar.f18051g = 60;
                fVar.f18056l = System.nanoTime();
                fVar.f18049e = str2;
                fVar.f18050f = str;
                fVar.f18052h = 0.0f;
                if (TextUtils.equals(str, C)) {
                    f17933z.add(fVar);
                } else if (TextUtils.equals(str, D)) {
                    A.add(fVar);
                } else if (TextUtils.equals(str, E)) {
                    B.add(fVar);
                }
            }
        }
    }

    public static void b() {
        if (!g.a.f()) {
            com.alibaba.pdns.u.a.b("-------------------->>", "Please check the network and use it after confirming it is normal!");
        } else {
            com.alibaba.pdns.pools.a.a().execute(new a());
        }
    }

    private static void c() {
        a(f17913f, C);
        a(f17914g, D);
        a(f17915h, E);
    }

    public static void d() {
        c();
        a(false);
        b();
    }

    public static boolean e() {
        if (((int) (((double) (System.nanoTime() - f17923p)) / 1.0E9d)) > f17919l) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        com.alibaba.pdns.model.f fVar;
        if (e.a(K)) {
            fVar = K.get(0);
        } else if (e.a(L)) {
            fVar = L.get(0);
        } else if (e.a(M)) {
            fVar = M.get(0);
        } else if (e.a(J)) {
            fVar = J.get(0);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            long j10 = fVar.f18056l;
            long nanoTime = System.nanoTime();
            int i10 = fVar.f18051g;
            if (i10 == 0) {
                i10 = 60;
            }
            if (((int) (((double) (nanoTime - j10)) / 1.0E9d)) > i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean g() {
        if (((int) (((double) (System.nanoTime() - U)) / 1.0E9d)) > f17920m) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.pdns.model.f b(java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2) {
        /*
            boolean r0 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r2)     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            if (r0 == 0) goto L_0x0033
            boolean r0 = g()     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            if (r0 != 0) goto L_0x0019
            java.util.concurrent.atomic.AtomicBoolean r0 = f17932y     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            boolean r0 = r0.get()     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            if (r0 == 0) goto L_0x001c
            goto L_0x0019
        L_0x0015:
            r2 = move-exception
            goto L_0x002c
        L_0x0017:
            r2 = move-exception
            goto L_0x002c
        L_0x0019:
            d(r2)     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
        L_0x001c:
            long r0 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            U = r0     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            com.alibaba.pdns.model.f r2 = (com.alibaba.pdns.model.f) r2     // Catch:{ Exception -> 0x0017, Error -> 0x0015 }
            if (r2 == 0) goto L_0x0033
            return r2
        L_0x002c:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x0033
            r2.printStackTrace()
        L_0x0033:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.b(java.util.concurrent.CopyOnWriteArrayList):com.alibaba.pdns.model.f");
    }

    public static com.alibaba.pdns.model.f c(Object obj) {
        com.alibaba.pdns.model.f b10 = b(obj);
        return b10 == null ? a(obj) : b10;
    }

    public static void d(CopyOnWriteArrayList<com.alibaba.pdns.model.f> copyOnWriteArrayList) {
        h hVar;
        if (e.b(copyOnWriteArrayList) && (hVar = H) != null) {
            hVar.b(copyOnWriteArrayList);
        }
    }

    public static void c(CopyOnWriteArrayList<com.alibaba.pdns.model.f> copyOnWriteArrayList) {
        try {
            Iterator<com.alibaba.pdns.model.f> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.alibaba.pdns.model.f next = it.next();
                if (next != null) {
                    next.f18052h = 0.0f;
                }
            }
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.alibaba.pdns.model.f b(java.lang.Object r4) {
        /*
            int r0 = com.alibaba.pdns.DNSResolver.addressMode     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r1 = 1
            java.lang.String r2 = "temp_ipv4"
            if (r0 == r1) goto L_0x004c
            r1 = 2
            java.lang.String r3 = "temp_ipv6"
            if (r0 == r1) goto L_0x0047
            r1 = 3
            if (r0 == r1) goto L_0x0010
            goto L_0x0058
        L_0x0010:
            if (r4 != 0) goto L_0x0026
            boolean r4 = com.alibaba.pdns.DNSResolver.isEnableIPv6()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r4 == 0) goto L_0x0021
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r3)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x001d:
            r4 = move-exception
            goto L_0x0051
        L_0x001f:
            r4 = move-exception
            goto L_0x0051
        L_0x0021:
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x0026:
            boolean r0 = r4 instanceof java.lang.Integer     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r0 == 0) goto L_0x0058
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r4 != 0) goto L_0x0042
            boolean r4 = com.alibaba.pdns.DNSResolver.isEnableIPv6()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r4 == 0) goto L_0x003d
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r3)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x003d:
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x0042:
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x0047:
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r3)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x004c:
            com.alibaba.pdns.model.f r4 = b((java.lang.String) r2)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            goto L_0x0059
        L_0x0051:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x0058
            r4.printStackTrace()
        L_0x0058:
            r4 = 0
        L_0x0059:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.b(java.lang.Object):com.alibaba.pdns.model.f");
    }

    public static void a(boolean z10) {
        if (!g.a.f()) {
            com.alibaba.pdns.u.a.b("-------------------->>", "Please check the network and use it after confirming it is normal!");
            return;
        }
        f17931x = z10;
        com.alibaba.pdns.pools.a.a().execute(new b());
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.alibaba.pdns.model.f a(java.lang.Object r4) {
        /*
            int r0 = com.alibaba.pdns.DNSResolver.addressMode     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            r1 = 1
            if (r0 == r1) goto L_0x00e4
            r1 = 2
            if (r0 == r1) goto L_0x00c6
            r1 = 3
            if (r0 == r1) goto L_0x000d
            goto L_0x0109
        L_0x000d:
            if (r4 != 0) goto L_0x0059
            boolean r4 = com.alibaba.pdns.DNSResolver.isEnableIPv6()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x003a
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x0034:
            r4 = move-exception
            goto L_0x0102
        L_0x0037:
            r4 = move-exception
            goto L_0x0102
        L_0x003a:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x0059:
            boolean r0 = r4 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r0 == 0) goto L_0x0109
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 != 0) goto L_0x00a8
            boolean r4 = com.alibaba.pdns.DNSResolver.isEnableIPv6()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x008a
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x008a:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x00a8:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x00c6:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = A     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x00e4:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            boolean r4 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r4)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            if (r4 == 0) goto L_0x0109
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = java.lang.Math.random()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = f17933z     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            double r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            com.alibaba.pdns.model.f r4 = (com.alibaba.pdns.model.f) r4     // Catch:{ Exception -> 0x0037, Error -> 0x0034 }
            goto L_0x010a
        L_0x0102:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x0109
            r4.printStackTrace()
        L_0x0109:
            r4 = 0
        L_0x010a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.a(java.lang.Object):com.alibaba.pdns.model.f");
    }

    private static com.alibaba.pdns.model.f b(String str) {
        com.alibaba.pdns.model.f fVar = null;
        if (!e.a(str)) {
            return null;
        }
        if (e.a(str, C)) {
            fVar = b(K);
        } else if (e.a(str, D)) {
            fVar = b(L);
        }
        return fVar == null ? b(M) : fVar;
    }

    public static int b(String str, String str2, String str3) {
        Object obj;
        try {
            if (!e.a(I) || (obj = I.get(o.a(str, str2, str3, d.f18104g))) == null) {
                return 0;
            }
            return ((Integer) obj).intValue();
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    public static void b(String str, String str2, String str3, String str4) {
        try {
            if (e.a(I)) {
                String a10 = o.a(str, str2, str3, str4);
                Map<String, Object> map = I;
                if (map != null && !map.isEmpty()) {
                    I.remove(a10);
                }
            }
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.pdns.model.f a(java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2) {
        /*
            boolean r0 = com.alibaba.pdns.e.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r2)     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0017
            d(r2)     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            com.alibaba.pdns.model.f r2 = (com.alibaba.pdns.model.f) r2     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            if (r2 == 0) goto L_0x0027
            return r2
        L_0x0013:
            r2 = move-exception
            goto L_0x0020
        L_0x0015:
            r2 = move-exception
            goto L_0x0020
        L_0x0017:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r2 = B     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            com.alibaba.pdns.model.f r2 = (com.alibaba.pdns.model.f) r2     // Catch:{ Exception -> 0x0015, Error -> 0x0013 }
            return r2
        L_0x0020:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x0027
            r2.printStackTrace()
        L_0x0027:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.a(java.util.concurrent.CopyOnWriteArrayList):com.alibaba.pdns.model.f");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041 A[Catch:{ Exception -> 0x0028, Error -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[Catch:{ Exception -> 0x0028, Error -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> a(java.lang.String r4) {
        /*
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r0 == 0) goto L_0x0056
            int r0 = r4.hashCode()     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            r1 = 1969925939(0x756aaf33, float:2.9749778E32)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x0034
            r1 = 1969956720(0x756b2770, float:2.9809318E32)
            if (r0 == r1) goto L_0x002a
            r1 = 1969956722(0x756b2772, float:2.9809321E32)
            if (r0 == r1) goto L_0x001c
            goto L_0x003e
        L_0x001c:
            java.lang.String r0 = "temp_ipv6"
            boolean r4 = r4.equals(r0)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r4 == 0) goto L_0x003e
            r4 = r3
            goto L_0x003f
        L_0x0026:
            r4 = move-exception
            goto L_0x004f
        L_0x0028:
            r4 = move-exception
            goto L_0x004f
        L_0x002a:
            java.lang.String r0 = "temp_ipv4"
            boolean r4 = r4.equals(r0)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r4 == 0) goto L_0x003e
            r4 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "temp_host"
            boolean r4 = r4.equals(r0)     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            if (r4 == 0) goto L_0x003e
            r4 = r2
            goto L_0x003f
        L_0x003e:
            r4 = -1
        L_0x003f:
            if (r4 == 0) goto L_0x004c
            if (r4 == r3) goto L_0x0049
            if (r4 == r2) goto L_0x0046
            goto L_0x0056
        L_0x0046:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = M     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            goto L_0x0057
        L_0x0049:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = L     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            goto L_0x0057
        L_0x004c:
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r4 = K     // Catch:{ Exception -> 0x0028, Error -> 0x0026 }
            goto L_0x0057
        L_0x004f:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x0056
            r4.printStackTrace()
        L_0x0056:
            r4 = 0
        L_0x0057:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.a(java.lang.String):java.util.concurrent.CopyOnWriteArrayList");
    }

    public static String a(String str, String str2, String str3, boolean z10) {
        StringBuffer stringBuffer = new StringBuffer();
        if (DNSResolver.getSchemaType().equals("http")) {
            stringBuffer.append(c.f18246k);
        } else if (DNSResolver.getSchemaType().equals("https")) {
            stringBuffer.append(c.f18247l);
        }
        stringBuffer.append(str2);
        String a10 = c.a().a(stringBuffer, str, str3);
        if (!z10) {
            return a10;
        }
        return a10 + c.f18249n;
    }

    public static void a(com.alibaba.pdns.model.f fVar) {
        if (fVar != null) {
            CopyOnWriteArrayList<com.alibaba.pdns.model.f> a10 = a(fVar.f18050f);
            if (e.a(a10)) {
                Iterator<com.alibaba.pdns.model.f> it = a10.iterator();
                while (it.hasNext()) {
                    com.alibaba.pdns.model.f next = it.next();
                    if (next != null) {
                        float g10 = next.g();
                        if (TextUtils.equals(next.f18049e, fVar.f18049e)) {
                            fVar.a(g10 + 200.0f);
                        } else {
                            fVar.a((float) (((double) g10) * 0.98d));
                        }
                    }
                }
            }
        }
    }

    public static float a(String str, String str2, String str3, String str4) {
        Object obj;
        try {
            if (!e.a(I) || (obj = I.get(o.a(str, str2, str3, str4))) == null) {
                return 0.0f;
            }
            return ((Float) obj).floatValue();
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    public static int a(String str, String str2, String str3) {
        Object obj;
        try {
            if (!e.a(I) || (obj = I.get(o.a(str, str2, str3, d.f18105h))) == null) {
                return 0;
            }
            return ((Integer) obj).intValue();
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, java.lang.String r4, boolean r5, long r6) {
        /*
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0018
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0016, Error -> 0x0014 }
            long r6 = r6 - r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r0
            java.util.concurrent.atomic.AtomicLong r0 = com.alibaba.pdns.DNSResolver.atomicLong     // Catch:{ Exception -> 0x0016, Error -> 0x0014 }
            r0.set(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0014 }
            goto L_0x0018
        L_0x0014:
            r2 = move-exception
            goto L_0x001d
        L_0x0016:
            r2 = move-exception
            goto L_0x001d
        L_0x0018:
            java.lang.String r2 = a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x0016, Error -> 0x0014 }
            return r2
        L_0x001d:
            boolean r3 = com.alibaba.pdns.u.a.f18279a
            if (r3 == 0) goto L_0x0024
            r2.printStackTrace()
        L_0x0024:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.f.a(java.lang.String, java.lang.String, java.lang.String, boolean, long):java.lang.String");
    }

    public static void a() {
        I.clear();
        c(f17933z);
        c(A);
        c(B);
    }

    public static void a(com.alibaba.pdns.model.f fVar, float f10) {
        if (fVar != null) {
            try {
                fVar.f18052h = (float) ((((double) fVar.g()) * 0.7d) + (((double) f10) * 0.3d));
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
