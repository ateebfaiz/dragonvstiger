package com.alibaba.pdns.v;

import com.alibaba.pdns.model.a;
import com.alibaba.pdns.r.e;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private e f18286a;

    public b(e eVar) {
        this.f18286a = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.a a(java.lang.String r1, java.lang.String r2, java.lang.String r3, boolean r4, boolean r5) {
        /*
            r0 = this;
            com.alibaba.pdns.model.a r1 = r0.a(r1, r2, r3, r4)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            boolean r4 = r0.a(r1)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            if (r4 != 0) goto L_0x0032
            com.alibaba.pdns.model.b r2 = r1.f17975a     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            if (r2 == 0) goto L_0x004b
            java.util.concurrent.atomic.AtomicLong r3 = r2.f17997g     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            r3.incrementAndGet()     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            r3.<init>()     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            java.lang.String r4 = "命中缓存的次数"
            r3.append(r4)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            java.util.concurrent.atomic.AtomicLong r2 = r2.f17997g     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            r3.append(r4)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            com.alibaba.pdns.u.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            return r1
        L_0x002e:
            r1 = move-exception
            goto L_0x0044
        L_0x0030:
            r1 = move-exception
            goto L_0x0044
        L_0x0032:
            if (r5 == 0) goto L_0x004b
            com.alibaba.pdns.DNSResolver r1 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            com.alibaba.pdns.model.a r1 = r1.getPDnsData(r2, r3)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            com.alibaba.pdns.r.e r2 = r0.f18286a     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            if (r2 == 0) goto L_0x004b
            r2.b(r1)     // Catch:{ Exception -> 0x0030, Error -> 0x002e }
            return r1
        L_0x0044:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x004b
            r1.printStackTrace()
        L_0x004b:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.v.b.a(java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.alibaba.pdns.model.a");
    }

    private boolean a(a aVar) {
        return aVar == null || aVar.f17988n == null;
    }

    public a a(String str, String str2, String str3, boolean z10) {
        e eVar = this.f18286a;
        if (eVar != null) {
            return eVar.a(str, str2, str3, z10);
        }
        return null;
    }
}
