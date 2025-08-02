package com.alibaba.pdns.r;

import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static Integer f18227a = 100;

    /* renamed from: b  reason: collision with root package name */
    static final Long f18228b = 60000L;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, a> f18229c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static List<String> f18230d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    private static volatile Boolean f18231e = Boolean.FALSE;

    /* renamed from: f  reason: collision with root package name */
    public static int f18232f = 30;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Object f18233a;

        public a(Object obj) {
            this.f18233a = obj;
        }

        public Object a() {
            return this.f18233a;
        }

        public String toString() {
            return "CacheObj {CacheValue = " + this.f18233a + '}';
        }
    }

    public static void a(Integer num) {
        f18227a = num;
    }

    public static void b(String str, Object obj) {
        a();
        if (f18229c.size() < f18227a.intValue()) {
            e(str);
            com.alibaba.pdns.u.a.a("缓存的个数" + f18230d.size());
            f18229c.put(str, new a(obj));
            com.alibaba.pdns.u.a.a("Cache", "have set key :" + str);
        }
    }

    public static void c(String str) {
        if (f18229c.remove(str) != null) {
            com.alibaba.pdns.u.a.a("Cache", "have delete key :" + str);
        }
    }

    public static Map<String, a> d() {
        return f18229c;
    }

    public static List<String> e() {
        return f18230d;
    }

    public static String f() {
        List<String> list;
        String str = "";
        if (com.alibaba.pdns.u.a.f18279a && (list = f18230d) != null && list.size() > 0) {
            for (String str2 : f18230d) {
                str = str + str2 + ";";
            }
        }
        return str;
    }

    public static int g() {
        return f18227a.intValue();
    }

    static void h() {
        f18231e = Boolean.TRUE;
    }

    private static void i() {
        if (!f18231e.booleanValue()) {
            new b();
        }
    }

    public static void a(String str, Object obj) {
        if (DNSResolver.enableCache) {
            b(str, obj);
        } else {
            DNSResolver.getInstance().clear();
        }
    }

    public static a d(String str) {
        a a10;
        if (str == null || (a10 = a(str)) == null) {
            return null;
        }
        return a10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A[Catch:{ all -> 0x0020 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(java.lang.String r5) {
        /*
            java.lang.Class<com.alibaba.pdns.r.d> r0 = com.alibaba.pdns.r.d.class
            monitor-enter(r0)
            int r1 = g()     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            java.util.List<java.lang.String> r2 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            int r3 = r1 / 2
            r4 = 0
            if (r2 > r3) goto L_0x0026
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            if (r1 != 0) goto L_0x0062
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            r1.add(r4, r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            goto L_0x0062
        L_0x0020:
            r5 = move-exception
            goto L_0x0064
        L_0x0022:
            r5 = move-exception
            goto L_0x005b
        L_0x0024:
            r5 = move-exception
            goto L_0x005b
        L_0x0026:
            if (r2 <= r3) goto L_0x0062
            if (r2 >= r1) goto L_0x0062
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            if (r1 == 0) goto L_0x004d
            boolean r1 = android.text.TextUtils.equals(r5, r1)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            if (r1 != 0) goto L_0x004d
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            if (r1 == 0) goto L_0x004d
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            r1.remove(r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            r1.add(r4, r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            goto L_0x0062
        L_0x004d:
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            boolean r1 = r1.contains(r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            if (r1 != 0) goto L_0x0062
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            r1.add(r4, r5)     // Catch:{ Exception -> 0x0024, Error -> 0x0022 }
            goto L_0x0062
        L_0x005b:
            boolean r1 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0062
            r5.printStackTrace()     // Catch:{ all -> 0x0020 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.r.d.e(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007a A[Catch:{ all -> 0x0050 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c() {
        /*
            java.lang.String r0 = "Cache"
            java.lang.String r1 = "delete Least recently used run!"
            com.alibaba.pdns.u.a.a(r0, r1)
            java.lang.Class<com.alibaba.pdns.r.d> r0 = com.alibaba.pdns.r.d.class
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String[] r2 = com.alibaba.pdns.DNSResolver.domains     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r3 = com.alibaba.pdns.DNSResolver.qType     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.util.concurrent.CopyOnWriteArrayList r2 = a((java.lang.String[]) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            r3.<init>()     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r4 = "cacheSize:"
            r3.append(r4)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.util.List<java.lang.String> r4 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            r3.append(r4)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            com.alibaba.pdns.u.a.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            r3 = 1
            if (r1 <= r3) goto L_0x007d
            java.util.List<java.lang.String> r4 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            int r1 = r1 - r3
            java.lang.Object r3 = r4.get(r1)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            if (r3 != 0) goto L_0x0056
            java.util.List<java.lang.String> r2 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.Object r1 = r2.remove(r1)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            if (r1 == 0) goto L_0x007d
            c(r1)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            goto L_0x007d
        L_0x0050:
            r1 = move-exception
            goto L_0x007f
        L_0x0052:
            r1 = move-exception
            goto L_0x0076
        L_0x0054:
            r1 = move-exception
            goto L_0x0076
        L_0x0056:
            if (r1 < 0) goto L_0x007d
            java.util.List<java.lang.String> r3 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            if (r3 != 0) goto L_0x0073
            java.util.List<java.lang.String> r3 = f18230d     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.Object r3 = r3.remove(r1)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
            if (r3 == 0) goto L_0x0073
            c(r3)     // Catch:{ Exception -> 0x0054, Error -> 0x0052 }
        L_0x0073:
            int r1 = r1 + -1
            goto L_0x0056
        L_0x0076:
            boolean r2 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x007d
            r1.printStackTrace()     // Catch:{ all -> 0x0050 }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.r.d.c():void");
    }

    private static a a(String str) {
        Map<String, a> map = f18229c;
        if (map == null || map.size() <= 0) {
            return null;
        }
        if (com.alibaba.pdns.u.a.f18279a) {
            String str2 = "";
            for (Map.Entry<String, a> key : f18229c.entrySet()) {
                str2 = str2 + ((String) key.getKey()) + ";";
            }
            com.alibaba.pdns.u.a.a("cache size is:" + f18229c.size());
            com.alibaba.pdns.u.a.b("Cache", "cacheKeys is:" + str2);
        }
        return f18229c.get(str);
    }

    public static void b() {
        com.alibaba.pdns.u.a.a("Cache", "have clean all key !");
        d().clear();
        e().clear();
    }

    public static void b(String str) {
        d().remove(str);
        e().remove(str);
    }

    public static CopyOnWriteArrayList<String> a(String[] strArr, String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (strArr != null && strArr.length > 0 && !TextUtils.isEmpty(str)) {
            for (String append : strArr) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(DNSResolver.sdkStartUpISP);
                stringBuffer.append("_");
                stringBuffer.append(append);
                stringBuffer.append("_");
                stringBuffer.append(str);
                copyOnWriteArrayList.add(stringBuffer.toString());
            }
        }
        return copyOnWriteArrayList;
    }

    private static void a() {
        if (f18229c.size() >= f18227a.intValue()) {
            c();
        }
    }
}
