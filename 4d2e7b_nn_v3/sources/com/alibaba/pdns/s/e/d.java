package com.alibaba.pdns.s.e;

import com.alibaba.pdns.s.c;

public class d implements c {
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.d a(java.lang.String r13, java.lang.String r14, int r15) {
        /*
            r12 = this;
            java.lang.String r15 = "1"
            r0 = 0
            boolean r1 = com.alibaba.pdns.DNSResolver.isEnableLocalDns()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r1 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r1 = com.alibaba.pdns.net.f.g.a.f()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r1 != 0) goto L_0x0029
            java.lang.String r15 = "-------------------->"
            java.lang.String r1 = "Please check the network and use it after confirming it is normal!"
            com.alibaba.pdns.u.a.b(r15, r1)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r15 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.b r13 = com.alibaba.pdns.DNSResolver.getDomainStats(r15, r13, r14)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.util.concurrent.atomic.AtomicInteger r13 = r13.f17991a     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r13.incrementAndGet()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            return r0
        L_0x0023:
            r13 = move-exception
            goto L_0x017b
        L_0x0026:
            r13 = move-exception
            goto L_0x017b
        L_0x0029:
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r1 != 0) goto L_0x017a
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r1 == 0) goto L_0x0037
            goto L_0x017a
        L_0x0037:
            r1 = 1
            java.lang.String r13 = java.net.IDN.toASCII(r13, r1)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r2 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.b r3 = com.alibaba.pdns.DNSResolver.getDomainStats(r2, r13, r14)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            long r4 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            boolean r6 = android.text.TextUtils.equals(r14, r15)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r7 = "28"
            if (r6 == 0) goto L_0x0053
            java.net.InetAddress[] r6 = java.net.InetAddress.getAllByName(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            goto L_0x005f
        L_0x0053:
            boolean r6 = android.text.TextUtils.equals(r14, r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r6 == 0) goto L_0x005e
            java.net.InetAddress[] r6 = java.net.InetAddress.getAllByName(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            goto L_0x005f
        L_0x005e:
            r6 = r0
        L_0x005f:
            long r8 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            long r8 = r8 - r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 / r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r5 = 0
            if (r6 == 0) goto L_0x009d
            int r10 = r6.length     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r10 <= 0) goto L_0x009d
            r10 = r5
        L_0x0074:
            int r11 = r6.length     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r10 >= r11) goto L_0x009d
            boolean r11 = r14.equals(r15)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r11 == 0) goto L_0x0084
            r11 = r6[r10]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            boolean r11 = r11 instanceof java.net.Inet4Address     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r11 != 0) goto L_0x0091
            goto L_0x009a
        L_0x0084:
            boolean r11 = r14.equals(r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r11 == 0) goto L_0x0091
            r11 = r6[r10]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            boolean r11 = r11 instanceof java.net.Inet6Address     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r11 != 0) goto L_0x0091
            goto L_0x009a
        L_0x0091:
            r11 = r6[r10]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r11 = r11.getHostAddress()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r4.add(r11)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
        L_0x009a:
            int r10 = r10 + 1
            goto L_0x0074
        L_0x009d:
            int r15 = r4.size()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r6 = "localDns"
            if (r15 <= 0) goto L_0x015c
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r7 = "request host is "
            r15.append(r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.append(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r7 = ", type="
            r15.append(r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.append(r14)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r7 = ", data from localdns"
            r15.append(r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.u.a.a((java.lang.String) r15)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.d r15 = new com.alibaba.pdns.model.d     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            int r7 = r4.size()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.Object[] r4 = r4.toArray(r7)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r4 == 0) goto L_0x015b
            r15.f18033h = r14     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18028c = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18034i = r6     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            float r6 = (float) r8     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18036k = r6     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18031f = r2     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2 = 101(0x65, float:1.42E-43)
            r15.f18035j = r2     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r6 = "domain:"
            r2.append(r6)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.append(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r13 = ";\nipArray:"
            r2.append(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r13 = r2.toString()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18032g = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            int r13 = r4.length     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.d$a[] r13 = new com.alibaba.pdns.model.d.a[r13]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18030e = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r3 == 0) goto L_0x010e
            java.util.concurrent.atomic.AtomicLong r13 = r3.f18005o     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r13.incrementAndGet()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18029d = r3     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
        L_0x010e:
            int r13 = r4.length     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r5 >= r13) goto L_0x015b
            r13 = r4[r5]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            int r2 = r4.length     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            int r2 = r2 - r1
            if (r5 != r2) goto L_0x012b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r3 = r15.f18032g     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.append(r3)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.append(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18032g = r2     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            goto L_0x0143
        L_0x012b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r3 = r15.f18032g     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.append(r3)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.append(r13)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r3 = ","
            r2.append(r3)     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18032g = r2     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
        L_0x0143:
            com.alibaba.pdns.model.d$a[] r2 = r15.f18030e     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.d$a r3 = new com.alibaba.pdns.model.d$a     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r3.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2[r5] = r3     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            com.alibaba.pdns.model.d$a[] r2 = r15.f18030e     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2 = r2[r5]     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.f18037a = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r13 = 60
            r2.f18038b = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r2.f18039c = r14     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            int r5 = r5 + 1
            goto L_0x010e
        L_0x015b:
            return r15
        L_0x015c:
            com.alibaba.pdns.model.d r15 = new com.alibaba.pdns.model.d     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.<init>()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18033h = r14     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18028c = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18031f = r2     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18034i = r6     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r13 = 100
            r15.f18035j = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            float r13 = (float) r8     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18036k = r13     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            if (r3 == 0) goto L_0x0179
            java.util.concurrent.atomic.AtomicLong r13 = r3.f17999i     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r13.incrementAndGet()     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
            r15.f18029d = r3     // Catch:{ Exception -> 0x0026, Error -> 0x0023 }
        L_0x0179:
            return r15
        L_0x017a:
            return r0
        L_0x017b:
            boolean r14 = com.alibaba.pdns.u.a.f18279a
            if (r14 == 0) goto L_0x0182
            r13.printStackTrace()
        L_0x0182:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.s.e.d.a(java.lang.String, java.lang.String, int):com.alibaba.pdns.model.d");
    }
}
