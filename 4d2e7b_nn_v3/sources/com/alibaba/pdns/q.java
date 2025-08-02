package com.alibaba.pdns;

import android.text.TextUtils;
import com.alibaba.pdns.u.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, q> f18208a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private String f18209b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18210c = false;

    public q() {
    }

    private static boolean c() {
        Map<String, Integer> map = f.Q;
        return map != null && map.size() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f18208a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean d() {
        /*
            com.alibaba.pdns.q r0 = com.alibaba.pdns.f.S
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, com.alibaba.pdns.q> r0 = r0.f18208a
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.q.d():boolean");
    }

    private static boolean e(String str) {
        if (a()) {
            return f.R.containsKey(str);
        }
        return false;
    }

    private static boolean f(String str) {
        q qVar = f.T;
        if (qVar != null) {
            return qVar.b(str);
        }
        return false;
    }

    private static boolean g(String str) {
        if (c()) {
            return f.Q.containsKey(str);
        }
        return false;
    }

    private static boolean h(String str) {
        q qVar = f.S;
        if (qVar != null) {
            return qVar.b(str);
        }
        return false;
    }

    public static boolean i(String str) {
        if (str != null && !TextUtils.equals(str, "")) {
            String d10 = o.d(str, f.G);
            if (d(d10) && !c(d10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            int r0 = r7.length     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            r1 = 1
            int r0 = r0 - r1
            r2 = r6
        L_0x000a:
            if (r0 < 0) goto L_0x003b
            r3 = r7[r0]     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            java.util.Map<java.lang.String, com.alibaba.pdns.q> r4 = r2.f18208a     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            boolean r4 = r4.containsKey(r3)     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            if (r4 != 0) goto L_0x0025
            java.util.Map<java.lang.String, com.alibaba.pdns.q> r4 = r2.f18208a     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            com.alibaba.pdns.q r5 = new com.alibaba.pdns.q     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            r4.put(r3, r5)     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r7 = move-exception
            goto L_0x0034
        L_0x0023:
            r7 = move-exception
            goto L_0x0034
        L_0x0025:
            java.util.Map<java.lang.String, com.alibaba.pdns.q> r2 = r2.f18208a     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            com.alibaba.pdns.q r2 = (com.alibaba.pdns.q) r2     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
            if (r0 != 0) goto L_0x0031
            r2.f18210c = r1     // Catch:{ Exception -> 0x0023, Error -> 0x0021 }
        L_0x0031:
            int r0 = r0 + -1
            goto L_0x000a
        L_0x0034:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x003b
            r7.printStackTrace()
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.q.a(java.lang.String):void");
    }

    public boolean b(String str) {
        try {
            String[] split = str.split("\\.");
            q qVar = this;
            for (int length = split.length - 1; length >= 0; length--) {
                String str2 = split[length];
                if (qVar.f18210c) {
                    return true;
                }
                if (!qVar.f18208a.containsKey(str2)) {
                    return false;
                }
                qVar = qVar.f18208a.get(str2);
            }
            return false;
        } catch (Error | Exception e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return false;
        }
    }

    public static boolean c(String str) {
        if (!b() && !a()) {
            return false;
        }
        if (!e(str) && !f(str)) {
            return false;
        }
        return true;
    }

    public static boolean d(String str) {
        if ((d() || c()) && !g(str) && !h(str)) {
            return false;
        }
        return true;
    }

    public q(String str) {
        this.f18209b = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.f18208a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b() {
        /*
            com.alibaba.pdns.q r0 = com.alibaba.pdns.f.T
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, com.alibaba.pdns.q> r0 = r0.f18208a
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.q.b():boolean");
    }

    private static boolean a() {
        Map<String, Integer> map = f.R;
        return map != null && map.size() > 0;
    }
}
