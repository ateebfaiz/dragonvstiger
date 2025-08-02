package com.alibaba.pdns;

import android.text.TextUtils;
import com.alibaba.pdns.model.ReportDomanInfo;
import com.alibaba.pdns.model.b;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f17934a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final String f17935b = "TCP";

    /* renamed from: c  reason: collision with root package name */
    public static final int f17936c = 4;

    /* renamed from: d  reason: collision with root package name */
    public static final int f17937d = 6;

    /* renamed from: e  reason: collision with root package name */
    public static final int f17938e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static float f17939f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public static float f17940g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public static CopyOnWriteArraySet<String> f17941h = new CopyOnWriteArraySet<>();

    /* renamed from: i  reason: collision with root package name */
    public static final String f17942i = "pdns_term_api";

    /* renamed from: j  reason: collision with root package name */
    public static final String f17943j = "4728df553ce79a7efd2633c71d59f5d1";

    /* renamed from: k  reason: collision with root package name */
    public static final String f17944k = "https://dnsrepo-pub.alibaba.com/api/internet/putTermData";

    /* renamed from: l  reason: collision with root package name */
    public static final String f17945l = "https://dnsrepo-pub.alibaba.com/api/internet/putTermStatusData";

    static class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                if (g.d()) {
                    g.f();
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.ReportDomanInfo.DataJsonBean> b() {
        /*
            java.util.Map<java.lang.String, com.alibaba.pdns.model.b> r0 = com.alibaba.pdns.DNSResolver.statisticalMap     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            if (r0 != 0) goto L_0x00d6
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r0.<init>()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.Map<java.lang.String, com.alibaba.pdns.model.b> r1 = com.alibaba.pdns.DNSResolver.statisticalMap     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.Collection r1 = r1.values()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
        L_0x0019:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            com.alibaba.pdns.model.b r2 = (com.alibaba.pdns.model.b) r2     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            com.alibaba.pdns.model.ReportDomanInfo$DataJsonBean r3 = new com.alibaba.pdns.model.ReportDomanInfo$DataJsonBean     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.<init>()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            if (r2 == 0) goto L_0x00c9
            java.lang.String r4 = r2.c()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setIsp(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.lang.String r4 = r2.b()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setDomainName(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            int r4 = r2.e()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setQueryType(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            float r4 = r2.a()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setAvgRtt(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            float r4 = r2.d()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setMaxRtt(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f17997g     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setHitDnsCacheCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f17996f     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setRecursiveReqCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f17998h     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setResolveSuccessCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18001k     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setReqParameterErrCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18002l     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setPermissionErrCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18003m     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setReqPathErrCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18004n     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setReqServerErrCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18000j     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setReqTimeoutCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f18005o     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setDegradeLocalDnsCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicLong r4 = r2.f17999i     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setLocalDnsResolveErrCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicInteger r4 = r2.f17995e     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setUtfNetWorkErroNum(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicInteger r4 = r2.f17991a     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setNonetworkCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            java.util.concurrent.atomic.AtomicInteger r2 = r2.f17992b     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            long r4 = r2.longValue()     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            r3.setHttpabnormalCount(r4)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r0 = move-exception
            goto L_0x00cf
        L_0x00c7:
            r0 = move-exception
            goto L_0x00cf
        L_0x00c9:
            r0.add(r3)     // Catch:{ Exception -> 0x00c7, Error -> 0x00c5 }
            goto L_0x0019
        L_0x00ce:
            return r0
        L_0x00cf:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x00d6
            r0.printStackTrace()
        L_0x00d6:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.g.b():java.util.concurrent.CopyOnWriteArrayList");
    }

    private static String c() {
        try {
            CopyOnWriteArrayList<ReportDomanInfo.DataJsonBean> b10 = b();
            if (b10 == null || b10.isEmpty()) {
                return null;
            }
            ReportDomanInfo reportDomanInfo = new ReportDomanInfo();
            String c10 = o.c(f17942i, f17943j);
            reportDomanInfo.setData(b10);
            reportDomanInfo.setTransactionId(o.b(32));
            reportDomanInfo.setAccountId(DNSResolver.getAccountId());
            reportDomanInfo.setApiUser(f17942i);
            reportDomanInfo.setApiToken(c10);
            return JsonUitl.objectToString(reportDomanInfo);
        } catch (Error | Exception e10) {
            if (!com.alibaba.pdns.u.a.f18279a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean d() {
        float f10 = f17940g;
        com.alibaba.pdns.u.a.a("定时器reportFrequency:" + f10);
        float floatValue = o.a(Float.valueOf(0.0f), Float.valueOf(1.0f)).floatValue();
        com.alibaba.pdns.u.a.a("定时器randomNum:" + floatValue);
        if (floatValue <= f10) {
            return true;
        }
        return false;
    }

    public static void e() {
        com.alibaba.pdns.pools.a.a().execute(new a());
    }

    public static void f() {
        String c10 = c();
        if (c10 != null) {
            com.alibaba.pdns.u.a.a("上报信息:" + c10);
            if (!TextUtils.isEmpty(c10) && !TextUtils.equals("", c10)) {
                if (a(c10)) {
                    DNSResolver.isFristReportInfo.set(true);
                    Map<String, b> map = DNSResolver.statisticalMap;
                    if (map != null) {
                        map.clear();
                        return;
                    }
                    return;
                }
                DNSResolver.isFristReportInfo.set(false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.alibaba.pdns.model.a r11, java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r12) {
        /*
            if (r12 == 0) goto L_0x00b6
            int r0 = r12.size()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            if (r0 != 0) goto L_0x000a
            goto L_0x00b6
        L_0x000a:
            int r0 = r12.size()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r1 = 50
            if (r0 <= r1) goto L_0x0013
            r0 = r1
        L_0x0013:
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r1.<init>()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            com.alibaba.pdns.model.DomainRttModel r2 = new com.alibaba.pdns.model.DomainRttModel     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r2.<init>()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r3 = "pdns_term_api"
            java.lang.String r4 = "4728df553ce79a7efd2633c71d59f5d1"
            java.lang.String r4 = com.alibaba.pdns.o.c(r3, r4)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r5 = 0
        L_0x0026:
            if (r5 >= r0) goto L_0x00a5
            java.lang.Object r6 = r12.get(r5)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            com.alibaba.pdns.model.c r6 = (com.alibaba.pdns.model.c) r6     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            if (r6 == 0) goto L_0x0089
            com.alibaba.pdns.model.DomainRttModel$ItemsJosnBean r7 = new com.alibaba.pdns.model.DomainRttModel$ItemsJosnBean     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.<init>()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r8 = r6.f18011a     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r10 = 4
            if (r9 != 0) goto L_0x004d
            java.lang.String r9 = "1"
            boolean r8 = android.text.TextUtils.equals(r8, r9)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            if (r8 == 0) goto L_0x0047
            goto L_0x004d
        L_0x0047:
            r10 = 6
            goto L_0x004d
        L_0x0049:
            r11 = move-exception
            goto L_0x00af
        L_0x004b:
            r11 = move-exception
            goto L_0x00af
        L_0x004d:
            java.lang.String r8 = com.alibaba.pdns.o.c()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setTermIp(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            float r8 = r6.f18020j     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            double r8 = (double) r8     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setLatency(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r8 = "2.2.6"
            r7.setSdkVersion(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r8 = "android"
            r7.setPlatform(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r8 = "TCP"
            r7.setDetectProtocol(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setDetectIpVersion(r10)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r8 = r11.f17976b     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setDetectDomainName(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.Long r8 = r6.f18012b     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            long r8 = r8.longValue()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setTimestamp(r8)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r6 = r6.f18015e     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setDetectIp(r6)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            int r6 = com.alibaba.pdns.DNSResolver.getSpeedPort()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r7.setDetectPort(r6)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r1.add(r7)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
        L_0x0089:
            r2.setItems(r1)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r6 = 32
            java.lang.String r6 = com.alibaba.pdns.o.b((int) r6)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r2.setTransactionId(r6)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r6 = com.alibaba.pdns.DNSResolver.getAccountId()     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r2.setAccountId(r6)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r2.setApiUser(r3)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            r2.setApiToken(r4)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            int r5 = r5 + 1
            goto L_0x0026
        L_0x00a5:
            java.lang.String r11 = com.alibaba.pdns.JsonUitl.objectToString(r2)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            java.lang.String r12 = "https://dnsrepo-pub.alibaba.com/api/internet/putTermData"
            com.alibaba.pdns.net.b.a(r12, r11)     // Catch:{ Exception -> 0x004b, Error -> 0x0049 }
            goto L_0x00b6
        L_0x00af:
            boolean r12 = com.alibaba.pdns.u.a.f18279a
            if (r12 == 0) goto L_0x00b6
            r11.printStackTrace()
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.g.a(com.alibaba.pdns.model.a, java.util.concurrent.CopyOnWriteArrayList):void");
    }

    public static boolean a(String str) {
        return com.alibaba.pdns.net.b.a(f17945l, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.alibaba.pdns.model.e r1, int r2) {
        /*
            if (r1 == 0) goto L_0x0055
            com.alibaba.pdns.model.b r0 = r1.d()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            if (r0 != 0) goto L_0x0009
            goto L_0x0055
        L_0x0009:
            com.alibaba.pdns.model.b r1 = r1.f18040a     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            if (r1 == 0) goto L_0x0055
            r0 = 200(0xc8, float:2.8E-43)
            if (r2 == r0) goto L_0x0048
            r0 = 404(0x194, float:5.66E-43)
            if (r2 == r0) goto L_0x0042
            r0 = 500(0x1f4, float:7.0E-43)
            if (r2 == r0) goto L_0x003c
            r0 = 504(0x1f8, float:7.06E-43)
            if (r2 == r0) goto L_0x0036
            r0 = 400(0x190, float:5.6E-43)
            if (r2 == r0) goto L_0x0030
            r0 = 401(0x191, float:5.62E-43)
            if (r2 == r0) goto L_0x0026
            goto L_0x0055
        L_0x0026:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f18002l     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x002c:
            r1 = move-exception
            goto L_0x004e
        L_0x002e:
            r1 = move-exception
            goto L_0x004e
        L_0x0030:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f18001k     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x0036:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f18000j     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x003c:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f18004n     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x0042:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f18003m     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x0048:
            java.util.concurrent.atomic.AtomicLong r1 = r1.f17998h     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            r1.incrementAndGet()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            goto L_0x0055
        L_0x004e:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x0055
            r1.printStackTrace()
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.g.a(com.alibaba.pdns.model.e, int):void");
    }
}
