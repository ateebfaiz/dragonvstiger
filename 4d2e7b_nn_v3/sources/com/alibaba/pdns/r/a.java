package com.alibaba.pdns.r;

import com.alibaba.pdns.DNSResolver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final float f18211a = 0.75f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, b> f18212b = new ConcurrentHashMap();

    /* renamed from: com.alibaba.pdns.r.a$a  reason: collision with other inner class name */
    class C0233a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18213a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18214b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f18215c;

        /* renamed from: com.alibaba.pdns.r.a$a$a  reason: collision with other inner class name */
        class C0234a implements Runnable {
            C0234a() {
            }

            public void run() {
                DNSResolver instance = DNSResolver.getInstance();
                C0233a aVar = C0233a.this;
                instance.getPDnsDataAsync(aVar.f18213a, aVar.f18214b, 3);
            }
        }

        C0233a(String str, String str2, b bVar) {
            this.f18213a = str;
            this.f18214b = str2;
            this.f18215c = bVar;
        }

        public void run() {
            com.alibaba.pdns.t.a.f18272e.execute(new C0234a());
            com.alibaba.pdns.t.a.f18271d.a(this);
            a.f18212b.remove(this.f18213a);
            this.f18215c.f18218a = null;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f18218a;

        private b() {
        }

        /* synthetic */ b(C0233a aVar) {
            this();
        }
    }

    public static boolean b(com.alibaba.pdns.model.a aVar) {
        if (aVar == null) {
            return false;
        }
        String str = aVar.f17976b;
        String str2 = aVar.f17980f;
        b bVar = f18212b.get(str + "_" + str2);
        if (bVar == null || bVar.f18218a == null) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.alibaba.pdns.model.a r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r9.f17976b     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r1 = r9.f17980f     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            int r9 = r9.f17978d     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r2.<init>()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r2.append(r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r2.append(r1)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.util.Set<java.lang.String> r3 = com.alibaba.pdns.DNSResolver.mPersistentCacheDomains     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r3 == 0) goto L_0x006b
            int r4 = r3.size()     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r4 <= 0) goto L_0x006b
            boolean r3 = r3.contains(r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r3 == 0) goto L_0x006b
            java.util.Map<java.lang.String, com.alibaba.pdns.r.a$b> r3 = f18212b     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            java.lang.Object r4 = r3.get(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            com.alibaba.pdns.r.a$b r4 = (com.alibaba.pdns.r.a.b) r4     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r4 == 0) goto L_0x0040
            java.lang.Runnable r5 = r4.f18218a     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r5 == 0) goto L_0x0046
            return
        L_0x003c:
            r9 = move-exception
            goto L_0x0064
        L_0x003e:
            r9 = move-exception
            goto L_0x0064
        L_0x0040:
            com.alibaba.pdns.r.a$b r4 = new com.alibaba.pdns.r.a$b     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r5 = 0
            r4.<init>(r5)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
        L_0x0046:
            com.alibaba.pdns.r.a$a r5 = new com.alibaba.pdns.r.a$a     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r5.<init>(r0, r1, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r4.f18218a = r5     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            com.alibaba.pdns.t.b r0 = com.alibaba.pdns.t.a.f18271d     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            float r9 = (float) r9     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r1 = 1061158912(0x3f400000, float:0.75)
            float r9 = r9 * r1
            r1 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 * r1
            long r6 = (long) r9     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            r0.a(r5, r6)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            boolean r9 = r3.containsKey(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            if (r9 != 0) goto L_0x006b
            r3.put(r2, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003c }
            goto L_0x006b
        L_0x0064:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x006b
            r9.printStackTrace()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.r.a.a(com.alibaba.pdns.model.a):void");
    }
}
