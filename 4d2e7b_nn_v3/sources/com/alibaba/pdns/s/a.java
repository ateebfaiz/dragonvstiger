package com.alibaba.pdns.s;

import com.alibaba.pdns.s.e.c;
import com.alibaba.pdns.s.e.d;
import java.util.ArrayList;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f18234a;

    public a() {
        ArrayList<c> arrayList = new ArrayList<>();
        this.f18234a = arrayList;
        arrayList.add(c.a());
        this.f18234a.add(new d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.d a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            java.util.ArrayList<com.alibaba.pdns.s.c> r1 = r4.f18234a     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
        L_0x0007:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r2 == 0) goto L_0x0081
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            com.alibaba.pdns.s.c r2 = (com.alibaba.pdns.s.c) r2     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r3 = com.alibaba.pdns.DNSResolver.getAccountId()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            boolean r3 = com.alibaba.pdns.e.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 == 0) goto L_0x005a
            boolean r3 = com.alibaba.pdns.net.f.g.a.f()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 != 0) goto L_0x003a
            java.lang.String r1 = "-------------------->"
            java.lang.String r2 = "Please check the network and use it after confirming it is normal!"
            com.alibaba.pdns.u.a.b(r1, r2)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r1 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            com.alibaba.pdns.model.b r5 = com.alibaba.pdns.DNSResolver.getDomainStats(r1, r5, r6)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.util.concurrent.atomic.AtomicInteger r5 = r5.f17991a     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            r5.incrementAndGet()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            return r0
        L_0x0036:
            r5 = move-exception
            goto L_0x007a
        L_0x0038:
            r5 = move-exception
            goto L_0x007a
        L_0x003a:
            boolean r3 = com.alibaba.pdns.q.i(r5)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 != 0) goto L_0x0041
            return r0
        L_0x0041:
            r3 = 0
            com.alibaba.pdns.model.d r2 = r2.a(r5, r6, r3)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r2 == 0) goto L_0x0007
            java.lang.String r3 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            r2.f18031f = r3     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            boolean r3 = r2.f18026a     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 == 0) goto L_0x0051
            return r2
        L_0x0051:
            com.alibaba.pdns.model.d$a[] r3 = r2.f18030e     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 == 0) goto L_0x0007
            int r3 = r3.length     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            if (r3 != 0) goto L_0x0059
            goto L_0x0007
        L_0x0059:
            return r2
        L_0x005a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            r5.<init>()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r6 = "accoutID:"
            r5.append(r6)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r6 = com.alibaba.pdns.DNSResolver.getAccountId()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            r5.append(r6)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            com.alibaba.pdns.u.a.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            java.lang.String r6 = "DNSResolver Init accountID can not be empty please initalize the SDK before using it!!"
            r5.<init>(r6)     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
            throw r5     // Catch:{ Exception -> 0x0038, Error -> 0x0036 }
        L_0x007a:
            boolean r6 = com.alibaba.pdns.u.a.f18279a
            if (r6 == 0) goto L_0x0081
            r5.printStackTrace()
        L_0x0081:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.s.a.a(java.lang.String, java.lang.String):com.alibaba.pdns.model.d");
    }
}
