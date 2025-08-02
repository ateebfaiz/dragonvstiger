package com.alibaba.pdns;

import com.alibaba.pdns.model.b;
import com.alibaba.pdns.model.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f17948a = ",";

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f17949a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f17950b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17951c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17952d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f17953e;

        a(d dVar, b bVar, String str, String str2, int i10) {
            this.f17949a = dVar;
            this.f17950b = bVar;
            this.f17951c = str;
            this.f17952d = str2;
            this.f17953e = i10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7 A[Catch:{ Exception -> 0x00a0, Error -> 0x009d }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x018f A[Catch:{ Exception -> 0x00a0, Error -> 0x009d }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                com.alibaba.pdns.model.d r0 = r11.f17949a     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r0 == 0) goto L_0x020f
                com.alibaba.pdns.model.b r0 = r11.f17950b     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r0 != 0) goto L_0x000a
                goto L_0x020f
            L_0x000a:
                r0 = 0
                com.alibaba.pdns.model.f r0 = com.alibaba.pdns.f.c((java.lang.Object) r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r0 == 0) goto L_0x0217
                java.lang.String r0 = r0.f18049e     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r1 = com.alibaba.pdns.DNSResolver.getAccountId()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r2 = com.alibaba.pdns.e.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r2 == 0) goto L_0x0217
                boolean r2 = com.alibaba.pdns.e.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r2 == 0) goto L_0x0217
                java.lang.String r2 = com.alibaba.pdns.DNSResolver.getAccessKeyId()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r2 = com.alibaba.pdns.e.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r2 == 0) goto L_0x0217
                java.lang.String r2 = com.alibaba.pdns.DNSResolver.getAccessKeySecret()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r2 = com.alibaba.pdns.e.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r2 == 0) goto L_0x0217
                com.alibaba.pdns.model.b r2 = r11.f17950b     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.model.b r2 = com.alibaba.pdns.i.b(r2)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r2 != 0) goto L_0x0040
                return
            L_0x0040:
                java.util.HashSet r3 = new java.util.HashSet     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.model.d r4 = r11.f17949a     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = com.alibaba.pdns.i.b(r4, r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r5.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r6 = "hdns解析结果:"
                r5.append(r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r5.append(r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r5 = com.alibaba.pdns.f.f17922o     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r6 = 2
                r7 = 1
                java.lang.String r8 = ""
                if (r5 != r6) goto L_0x006a
                r3 = r7
            L_0x0068:
                r5 = r8
                goto L_0x00a5
            L_0x006a:
                if (r5 != r7) goto L_0x00a3
                com.alibaba.pdns.s.e.d r5 = new com.alibaba.pdns.s.e.d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r5.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r6 = r11.f17951c     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r9 = r11.f17952d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r10 = -1
                com.alibaba.pdns.model.d r5 = r5.a(r6, r9, r10)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.util.HashSet r6 = new java.util.HashSet     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r6.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = com.alibaba.pdns.i.b(r5, r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r9.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r10 = "ldns解析结果:"
                r9.append(r10)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r9.append(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r3 = com.alibaba.pdns.o.a((java.util.Set<java.lang.String>) r3, (java.util.Set<java.lang.String>) r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3 = r3 ^ r7
                goto L_0x00a5
            L_0x009d:
                r0 = move-exception
                goto L_0x0210
            L_0x00a0:
                r0 = move-exception
                goto L_0x0210
            L_0x00a3:
                r3 = 0
                goto L_0x0068
            L_0x00a5:
                if (r3 == 0) goto L_0x0217
                java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r6 = r11.f17952d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 != 0) goto L_0x00d6
                java.lang.String r6 = r11.f17952d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r6 = android.text.TextUtils.equals(r6, r8)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 != 0) goto L_0x00d6
                java.lang.String r6 = r11.f17952d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r9 = "1"
                boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 == 0) goto L_0x00c9
                java.lang.String r6 = "A"
                goto L_0x00d7
            L_0x00c9:
                java.lang.String r6 = r11.f17952d     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r9 = "28"
                boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 == 0) goto L_0x00d6
                java.lang.String r6 = "AAAA"
                goto L_0x00d7
            L_0x00d6:
                r6 = r8
            L_0x00d7:
                java.lang.String r9 = "qd"
                java.lang.String r10 = r11.f17951c     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r10 = java.net.IDN.toASCII(r10, r7)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r9, r10)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r9 = "qt"
                r3.put(r9, r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r6 = "sip"
                java.lang.String r9 = com.alibaba.pdns.f.f17921n     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r6, r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r6 = "s"
                int r9 = r11.f17953e     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r6, r9)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r6 = com.alibaba.pdns.f.f17922o     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 != r7) goto L_0x010e
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 != 0) goto L_0x010e
                boolean r6 = android.text.TextUtils.equals(r8, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r6 != 0) goto L_0x010e
                java.lang.String r6 = "ldns"
                r3.put(r6, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
            L_0x010e:
                java.lang.String r5 = "hdns"
                r3.put(r5, r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = "chc"
                java.util.concurrent.atomic.AtomicLong r5 = r2.f17997g     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r5 = r5.intValue()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = "tc"
                java.util.concurrent.atomic.AtomicInteger r5 = r2.f17995e     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r5 = r5.intValue()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = "nec"
                java.util.concurrent.atomic.AtomicInteger r5 = r2.f17992b     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r5 = r5.intValue()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = "oec"
                java.util.concurrent.atomic.AtomicInteger r5 = r2.f17991a     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                int r5 = r5.intValue()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r3 = com.alibaba.pdns.JsonUitl.objectToString(r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "bodyPramte:"
                r4.append(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = com.alibaba.pdns.DNSResolver.getAccessKeySecret()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r3 = com.alibaba.pdns.o.b(r4, r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "加密后的字符串:"
                r4.append(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r4 != 0) goto L_0x0217
                boolean r4 = android.text.TextUtils.equals(r3, r8)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                if (r4 != 0) goto L_0x0217
                java.util.concurrent.ConcurrentHashMap r4 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "v"
                int r6 = com.alibaba.pdns.f.f17929v     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.put(r5, r6)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "d"
                r4.put(r5, r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r3 = com.alibaba.pdns.JsonUitl.objectToString(r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "防劫持上传的data:"
                r4.append(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r3)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r5 = "https://"
                r4.append(r5)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = "/i?uid="
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r1)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = com.alibaba.pdns.f.f17925r     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = "2.2.6"
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = com.alibaba.pdns.f.f17926s     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = "android"
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = com.alibaba.pdns.f.f17927t     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = com.alibaba.pdns.DNSResolver.getAccessKeyId()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r4.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r1.<init>()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r4 = "上报的url:"
                r1.append(r4)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                r1.append(r0)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.u.a.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.model.b r1 = r11.f17950b     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                com.alibaba.pdns.i.a(r0, r3, r1, r2)     // Catch:{ Exception -> 0x00a0, Error -> 0x009d }
                goto L_0x0217
            L_0x020f:
                return
            L_0x0210:
                boolean r1 = com.alibaba.pdns.u.a.f18279a
                if (r1 == 0) goto L_0x0217
                r0.printStackTrace()
            L_0x0217:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.i.a.run():void");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(com.alibaba.pdns.model.d r5, java.util.Set<java.lang.String> r6) {
        /*
            if (r5 == 0) goto L_0x004f
            com.alibaba.pdns.model.d$a[] r0 = r5.f18030e     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            if (r0 == 0) goto L_0x004f
            int r0 = r0.length     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            if (r0 <= 0) goto L_0x004f
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            r0.<init>()     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            com.alibaba.pdns.model.d$a[] r5 = r5.f18030e     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            int r1 = r5.length     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            r2 = 0
        L_0x0012:
            if (r2 >= r1) goto L_0x0034
            r3 = r5[r2]     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            if (r3 == 0) goto L_0x0031
            java.lang.String r3 = r3.f18037a     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            if (r4 == 0) goto L_0x0021
            goto L_0x0031
        L_0x0021:
            r6.add(r3)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            r0.append(r3)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            java.lang.String r3 = f17948a     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            r0.append(r3)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r5 = move-exception
            goto L_0x0048
        L_0x002f:
            r5 = move-exception
            goto L_0x0048
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0034:
            int r5 = r0.length()     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            if (r5 <= 0) goto L_0x0043
            java.lang.String r5 = f17948a     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            int r5 = r0.lastIndexOf(r5)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            r0.deleteCharAt(r5)     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
        L_0x0043:
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x002f, Error -> 0x002d }
            return r5
        L_0x0048:
            boolean r6 = com.alibaba.pdns.u.a.f18279a
            if (r6 == 0) goto L_0x004f
            r5.printStackTrace()
        L_0x004f:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.i.b(com.alibaba.pdns.model.d, java.util.Set):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3 A[Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d8 A[SYNTHETIC, Splitter:B:48:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e0 A[Catch:{ IOException -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ee A[SYNTHETIC, Splitter:B:58:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6 A[Catch:{ IOException -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r3, java.lang.String r4, com.alibaba.pdns.model.b r5, com.alibaba.pdns.model.b r6) {
        /*
            r0 = 0
            com.alibaba.pdns.net.d r1 = com.alibaba.pdns.net.d.a()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.net.HttpURLConnection r3 = r1.a(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            if (r4 == 0) goto L_0x003c
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0039 }
            if (r1 != 0) goto L_0x003c
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "Content-Length"
            int r2 = r4.length     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0039 }
            r3.setRequestProperty(r1, r2)     // Catch:{ Exception -> 0x0039 }
            r3.connect()     // Catch:{ Exception -> 0x0039 }
            java.util.concurrent.atomic.AtomicBoolean r1 = com.alibaba.pdns.f.f17932y     // Catch:{ Exception -> 0x0039 }
            r2 = 0
            r1.set(r2)     // Catch:{ Exception -> 0x0039 }
            java.io.OutputStream r1 = r3.getOutputStream()     // Catch:{ Exception -> 0x0039 }
            r1.write(r4)     // Catch:{ Exception -> 0x0039 }
            r1.flush()     // Catch:{ Exception -> 0x0039 }
            r1.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x003c
        L_0x0036:
            r4 = move-exception
            goto L_0x00ec
        L_0x0039:
            r4 = move-exception
            goto L_0x00c9
        L_0x003c:
            java.lang.String r4 = "======================response========================="
            com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0039 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r4.<init>()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "ResponseCode:"
            r4.append(r1)     // Catch:{ Exception -> 0x0039 }
            int r1 = r3.getResponseCode()     // Catch:{ Exception -> 0x0039 }
            r4.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = ",ResponseMessage:"
            r4.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = r3.getResponseMessage()     // Catch:{ Exception -> 0x0039 }
            r4.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0039 }
            com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0039 }
            int r4 = r3.getResponseCode()     // Catch:{ Exception -> 0x0039 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r4 != r1) goto L_0x0072
            java.io.InputStream r4 = r3.getInputStream()     // Catch:{ Exception -> 0x0039 }
            goto L_0x007d
        L_0x0072:
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ Exception -> 0x0039 }
            if (r5 == 0) goto L_0x007d
            if (r6 == 0) goto L_0x007d
            a((com.alibaba.pdns.model.b) r5, (com.alibaba.pdns.model.b) r6)     // Catch:{ Exception -> 0x0039 }
        L_0x007d:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0039 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "UTF-8"
            r6.<init>(r4, r1)     // Catch:{ Exception -> 0x0039 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0039 }
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r4.<init>()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
        L_0x008e:
            java.lang.String r6 = r5.readLine()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            if (r6 == 0) goto L_0x009d
            r4.append(r6)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            goto L_0x008e
        L_0x0098:
            r4 = move-exception
            r0 = r5
            goto L_0x00ec
        L_0x009b:
            r4 = move-exception
            goto L_0x00c2
        L_0x009d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r6.<init>()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r0 = "response:"
            r6.append(r0)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r6.append(r4)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x009b, all -> 0x0098 }
            r5.close()     // Catch:{ IOException -> 0x00bc }
            r3.disconnect()     // Catch:{ IOException -> 0x00bc }
            goto L_0x00eb
        L_0x00bc:
            r3 = move-exception
            boolean r4 = com.alibaba.pdns.u.a.f18279a
            if (r4 == 0) goto L_0x00eb
            goto L_0x00e8
        L_0x00c2:
            r0 = r5
            goto L_0x00c9
        L_0x00c4:
            r4 = move-exception
            r3 = r0
            goto L_0x00ec
        L_0x00c7:
            r4 = move-exception
            r3 = r0
        L_0x00c9:
            java.util.concurrent.atomic.AtomicBoolean r5 = com.alibaba.pdns.f.f17932y     // Catch:{ all -> 0x0036 }
            r6 = 1
            r5.set(r6)     // Catch:{ all -> 0x0036 }
            boolean r5 = com.alibaba.pdns.u.a.f18279a     // Catch:{ all -> 0x0036 }
            if (r5 == 0) goto L_0x00d6
            r4.printStackTrace()     // Catch:{ all -> 0x0036 }
        L_0x00d6:
            if (r0 == 0) goto L_0x00de
            r0.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00de
        L_0x00dc:
            r3 = move-exception
            goto L_0x00e4
        L_0x00de:
            if (r3 == 0) goto L_0x00eb
            r3.disconnect()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00eb
        L_0x00e4:
            boolean r4 = com.alibaba.pdns.u.a.f18279a
            if (r4 == 0) goto L_0x00eb
        L_0x00e8:
            r3.printStackTrace()
        L_0x00eb:
            return
        L_0x00ec:
            if (r0 == 0) goto L_0x00f4
            r0.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f4
        L_0x00f2:
            r3 = move-exception
            goto L_0x00fa
        L_0x00f4:
            if (r3 == 0) goto L_0x0101
            r3.disconnect()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x0101
        L_0x00fa:
            boolean r5 = com.alibaba.pdns.u.a.f18279a
            if (r5 == 0) goto L_0x0101
            r3.printStackTrace()
        L_0x0101:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.i.a(java.lang.String, java.lang.String, com.alibaba.pdns.model.b, com.alibaba.pdns.model.b):void");
    }

    /* access modifiers changed from: private */
    public static b b(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            b bVar2 = new b();
            bVar2.f17997g.set(bVar.f17997g.getAndSet(0));
            bVar2.f17995e.set(bVar.f17995e.getAndSet(0));
            bVar2.f17992b.set(bVar.f17992b.getAndSet(0));
            bVar2.f17991a.set(bVar.f17991a.getAndSet(0));
            return bVar2;
        } catch (Error | Exception e10) {
            if (!com.alibaba.pdns.u.a.f18279a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    public static void a(d dVar, b bVar, int i10, String str, String str2) {
        if (f.f17922o != 0) {
            com.alibaba.pdns.pools.a.a().execute(new a(dVar, bVar, str, str2, i10));
        }
    }

    private static void a(b bVar, b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar.f17997g.addAndGet((long) bVar2.f17997g.intValue());
            bVar.f17995e.addAndGet(bVar2.f17995e.intValue());
            bVar.f17992b.addAndGet(bVar2.f17992b.intValue());
            bVar.f17991a.addAndGet(bVar2.f17991a.intValue());
        }
    }
}
