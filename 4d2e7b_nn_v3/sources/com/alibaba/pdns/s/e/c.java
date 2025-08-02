package com.alibaba.pdns.s.e;

import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.f;
import com.alibaba.pdns.j;
import com.alibaba.pdns.model.d;
import com.alibaba.pdns.net.b;
import com.alibaba.pdns.net.e;
import java.net.IDN;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class c implements com.alibaba.pdns.s.c {

    /* renamed from: j  reason: collision with root package name */
    private static volatile c f18245j = null;

    /* renamed from: k  reason: collision with root package name */
    public static final String f18246k = "http://";

    /* renamed from: l  reason: collision with root package name */
    public static final String f18247l = "https://";

    /* renamed from: m  reason: collision with root package name */
    private static final String f18248m = "/resolve?";

    /* renamed from: n  reason: collision with root package name */
    public static String f18249n = "&short=1";

    /* renamed from: o  reason: collision with root package name */
    private static String f18250o = "&type=";

    /* renamed from: p  reason: collision with root package name */
    private static String f18251p = "&name=";

    /* renamed from: q  reason: collision with root package name */
    private static final String f18252q = "c";

    /* renamed from: a  reason: collision with root package name */
    private e f18253a = new b();

    /* renamed from: b  reason: collision with root package name */
    private a f18254b = new a();

    /* renamed from: c  reason: collision with root package name */
    private b f18255c = new b();

    /* renamed from: d  reason: collision with root package name */
    private String f18256d = "&uid=";

    /* renamed from: e  reason: collision with root package name */
    private String f18257e = "&key=";

    /* renamed from: f  reason: collision with root package name */
    private String f18258f = "&pf=";

    /* renamed from: g  reason: collision with root package name */
    private String f18259g = "&sv=";

    /* renamed from: h  reason: collision with root package name */
    private String f18260h = "&ts=";

    /* renamed from: i  reason: collision with root package name */
    private String f18261i = "&ak=";

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Future f18262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18264c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f18265d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f18266e;

        a(Future future, String str, String str2, int i10, boolean z10) {
            this.f18262a = future;
            this.f18263b = str;
            this.f18264c = str2;
            this.f18265d = i10;
            this.f18266e = z10;
        }

        public void run() {
            com.alibaba.pdns.model.e eVar;
            try {
                Future future = this.f18262a;
                if (future != null && (eVar = (com.alibaba.pdns.model.e) future.get()) != null) {
                    String str = eVar.f18041b;
                    if (str == null || TextUtils.isEmpty(str)) {
                        c.this.a(this.f18263b, this.f18264c);
                    } else {
                        c.this.a(this.f18263b, this.f18264c, this.f18265d, eVar, this.f18266e);
                    }
                }
            } catch (ExecutionException e10) {
                e10.printStackTrace();
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f18245j == null) {
            synchronized (c.class) {
                try {
                    if (f18245j == null) {
                        f18245j = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18245j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r11 = this;
            r0 = 1
            java.lang.String r12 = java.net.IDN.toASCII(r12, r0)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            com.alibaba.pdns.model.e r7 = new com.alibaba.pdns.model.e     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            r7.<init>()     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            java.lang.String r0 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            com.alibaba.pdns.model.b r0 = com.alibaba.pdns.DNSResolver.getDomainStats(r0, r12, r13)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            if (r0 == 0) goto L_0x001a
            r7.a((com.alibaba.pdns.model.b) r0)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r12 = move-exception
            goto L_0x0056
        L_0x0018:
            r12 = move-exception
            goto L_0x0056
        L_0x001a:
            boolean r0 = com.alibaba.pdns.DNSResolver.iSEnableShort()     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            r1 = 0
            com.alibaba.pdns.model.f r3 = com.alibaba.pdns.f.c((java.lang.Object) r1)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            if (r3 == 0) goto L_0x005d
            java.lang.String r1 = r3.f18049e     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            boolean r2 = com.alibaba.pdns.e.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = com.alibaba.pdns.f.a((java.lang.String) r12, (java.lang.String) r1, (java.lang.String) r13, (boolean) r0)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            java.util.concurrent.ExecutorService r9 = com.alibaba.pdns.k.a()     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            com.alibaba.pdns.net.HttpRequestAysnc r10 = new com.alibaba.pdns.net.HttpRequestAysnc     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            r8 = 0
            r1 = r10
            r4 = r12
            r5 = r0
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            java.util.concurrent.Future r3 = r9.submit(r10)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            com.alibaba.pdns.pools.d r8 = com.alibaba.pdns.pools.a.a()     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            com.alibaba.pdns.s.e.c$a r9 = new com.alibaba.pdns.s.e.c$a     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            r1 = r9
            r2 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r0
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            r8.execute(r9)     // Catch:{ Exception -> 0x0018, Error -> 0x0016 }
            goto L_0x005d
        L_0x0056:
            boolean r13 = com.alibaba.pdns.u.a.f18279a
            if (r13 == 0) goto L_0x005d
            r12.printStackTrace()
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.s.e.c.b(java.lang.String, java.lang.String, int):void");
    }

    public String a(StringBuffer stringBuffer, String str, String str2) {
        String str3;
        Long valueOf = Long.valueOf((System.currentTimeMillis() / 1000) + DNSResolver.atomicLong.longValue());
        String accountId = DNSResolver.getAccountId();
        String accessKeySecret = DNSResolver.getAccessKeySecret();
        String accessKeyId = DNSResolver.getAccessKeyId();
        if (TextUtils.isEmpty(accessKeySecret) || TextUtils.equals(accessKeySecret, "")) {
            str3 = a(stringBuffer, str, str2, accountId);
        } else if (TextUtils.isEmpty(accessKeyId) || TextUtils.equals(accessKeyId, "")) {
            str3 = a(stringBuffer, str, str2, accountId);
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(accountId);
            stringBuffer2.append(accessKeySecret);
            stringBuffer2.append(valueOf);
            stringBuffer2.append(str);
            stringBuffer2.append(accessKeyId);
            String stringBuffer3 = stringBuffer2.toString();
            String a10 = j.a(stringBuffer3, "SHA-256");
            com.alibaba.pdns.u.a.a("加密的之accessKeySecret=" + accessKeySecret);
            com.alibaba.pdns.u.a.a("加密的之ak=" + accessKeyId);
            com.alibaba.pdns.u.a.a("加密的之前值=" + stringBuffer3);
            com.alibaba.pdns.u.a.a("加密的key=" + a10);
            str3 = a(stringBuffer, str, str2, valueOf, accountId, accessKeyId, a10);
        }
        com.alibaba.pdns.u.a.a("拼接后的url=" + str3);
        return str3;
    }

    private String a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append(f18248m);
        stringBuffer.append(f18251p);
        stringBuffer.append(str);
        stringBuffer.append(f18250o);
        stringBuffer.append(str2);
        stringBuffer.append(this.f18256d);
        stringBuffer.append(str3);
        stringBuffer.append(this.f18258f);
        stringBuffer.append(f.f17924q);
        stringBuffer.append(this.f18259g);
        stringBuffer.append(f.f17916i);
        return stringBuffer.toString();
    }

    private String a(StringBuffer stringBuffer, String str, String str2, Long l10, String str3, String str4, String str5) {
        stringBuffer.append(f18248m);
        stringBuffer.append(f18251p);
        stringBuffer.append(str);
        stringBuffer.append(f18250o);
        stringBuffer.append(str2);
        stringBuffer.append(this.f18256d);
        stringBuffer.append(str3);
        stringBuffer.append(this.f18258f);
        stringBuffer.append(f.f17924q);
        stringBuffer.append(this.f18259g);
        stringBuffer.append(f.f17916i);
        stringBuffer.append(this.f18260h);
        stringBuffer.append(l10);
        stringBuffer.append(this.f18257e);
        stringBuffer.append(str5);
        stringBuffer.append(this.f18261i);
        stringBuffer.append(str4);
        if (DNSResolver.getEdnsSubnet().length() <= 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append("&edns_client_subnet=" + DNSResolver.getEdnsSubnet());
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, java.lang.String r4, int r5, com.alibaba.pdns.model.e r6, boolean r7) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r0.<init>()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = "AsncRequest host is "
            r0.append(r1)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r0.append(r3)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = ", type="
            r0.append(r1)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r0.append(r4)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = ", data from pdns"
            r0.append(r1)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r0 = "requestDnsAync_response"
            java.lang.String r1 = r6.f18041b     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.u.a.b(r0, r1)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.model.b r0 = r6.d()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            if (r7 == 0) goto L_0x003b
            com.alibaba.pdns.s.e.b r7 = r2.f18255c     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = r6.f18041b     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.model.d r7 = r7.b(r1, r4)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            goto L_0x0043
        L_0x0037:
            r3 = move-exception
            goto L_0x007a
        L_0x0039:
            r3 = move-exception
            goto L_0x007a
        L_0x003b:
            com.alibaba.pdns.s.e.a r7 = r2.f18254b     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = r6.f18041b     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.model.d r7 = r7.a(r1, r4)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
        L_0x0043:
            if (r7 == 0) goto L_0x0081
            r7.f18028c = r3     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r7.f18033h = r4     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            float r1 = r6.c()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r7.f18036k = r1     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r1 = "aysnc_pdns"
            r7.f18034i = r1     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.model.b r1 = r6.d()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r7.f18029d = r1     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            int r6 = r6.e()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r7.f18035j = r6     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            java.lang.String r6 = r0.c()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r7.f18031f = r6     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.DNSResolver r6 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            com.alibaba.pdns.r.e r6 = r6.getDnsCacheManager()     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            if (r6 == 0) goto L_0x0076
            com.alibaba.pdns.model.a r1 = r6.a((com.alibaba.pdns.model.d) r7)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            r6.b(r1)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
        L_0x0076:
            com.alibaba.pdns.i.a(r7, r0, r5, r3, r4)     // Catch:{ Exception -> 0x0039, Error -> 0x0037 }
            goto L_0x0081
        L_0x007a:
            boolean r4 = com.alibaba.pdns.u.a.f18279a
            if (r4 == 0) goto L_0x0081
            r3.printStackTrace()
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.s.e.c.a(java.lang.String, java.lang.String, int, com.alibaba.pdns.model.e, boolean):void");
    }

    public void a(String str, String str2) {
        d dVar = new d();
        com.alibaba.pdns.u.a.a("AsncRequest host is " + str + ", type=" + str2 + ", data from pdns");
        com.alibaba.pdns.u.a.b("requestDnsAync_response", "data is from localdns!");
        d a10 = dVar.a(str, str2, -1);
        if (a10 != null) {
            DNSResolver.getInstance().getDnsCacheManager().a(a10);
        }
    }

    public d a(String str, String str2, int i10) {
        return a(IDN.toASCII(str, 1), str2, DNSResolver.iSEnableShort(), i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.d a(java.lang.String r18, java.lang.String r19, boolean r20, int r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r11 = r19
            r12 = r20
            com.alibaba.pdns.net.e r2 = r1.f18253a
            r13 = 0
            if (r2 != 0) goto L_0x000e
            return r13
        L_0x000e:
            com.alibaba.pdns.model.e r14 = new com.alibaba.pdns.model.e     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r14.<init>()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r2 = com.alibaba.pdns.DNSResolver.sdkStartUpISP     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.model.b r15 = com.alibaba.pdns.DNSResolver.getDomainStats(r2, r0, r11)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r15 == 0) goto L_0x0025
            r14.a((com.alibaba.pdns.model.b) r15)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            goto L_0x0025
        L_0x001f:
            r0 = move-exception
            goto L_0x00d6
        L_0x0022:
            r0 = move-exception
            goto L_0x00d6
        L_0x0025:
            com.alibaba.pdns.model.f r4 = com.alibaba.pdns.f.c((java.lang.Object) r13)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r4 == 0) goto L_0x00d4
            java.lang.String r2 = r4.f18049e     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            boolean r3 = com.alibaba.pdns.e.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r3 == 0) goto L_0x00d4
            java.lang.String r10 = com.alibaba.pdns.f.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r11, (boolean) r12)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.net.e r2 = r1.f18253a     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r5 = 0
            r16 = 0
            r3 = r10
            r6 = r18
            r7 = r20
            r8 = r19
            r9 = r14
            r13 = r10
            r10 = r16
            java.lang.Object r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.model.e r2 = (com.alibaba.pdns.model.e) r2     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r2 == 0) goto L_0x00d2
            java.lang.String r3 = r2.f18041b     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r4 != 0) goto L_0x00cb
            java.lang.String r4 = ""
            boolean r4 = android.text.TextUtils.equals(r3, r4)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r4 != 0) goto L_0x00cb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r4.<init>()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r5 = "requestDns_ host is "
            r4.append(r5)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r4.append(r0)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r5 = ", type="
            r4.append(r5)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r4.append(r11)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r5 = ", data from pdns"
            r4.append(r5)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r4.<init>()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r5 = "url="
            r4.append(r5)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r4.append(r13)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.u.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r4 = "requestDns_response"
            com.alibaba.pdns.u.a.b(r4, r3)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.model.b r4 = r14.d()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            if (r12 == 0) goto L_0x00a6
            com.alibaba.pdns.s.e.b r5 = r1.f18255c     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.model.d r3 = r5.b(r3, r11)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            goto L_0x00ac
        L_0x00a6:
            com.alibaba.pdns.s.e.a r5 = r1.f18254b     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            com.alibaba.pdns.model.d r3 = r5.a(r3, r11)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
        L_0x00ac:
            if (r3 == 0) goto L_0x00c8
            r3.f18028c = r0     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r3.f18033h = r11     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r5 = "pdns"
            r3.f18034i = r5     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            float r5 = r2.f18042c     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r3.f18036k = r5     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            int r2 = r2.e()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r3.f18035j = r2     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r3.f18029d = r4     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            java.lang.String r2 = r4.c()     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            r3.f18031f = r2     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
        L_0x00c8:
            r2 = r21
            goto L_0x00ce
        L_0x00cb:
            r2 = r21
            r3 = 0
        L_0x00ce:
            com.alibaba.pdns.i.a(r3, r15, r2, r0, r11)     // Catch:{ Exception -> 0x0022, Error -> 0x001f }
            return r3
        L_0x00d2:
            r2 = 0
            goto L_0x00de
        L_0x00d4:
            r2 = r13
            goto L_0x00de
        L_0x00d6:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x00d2
            r0.printStackTrace()
            goto L_0x00d2
        L_0x00de:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.s.e.c.a(java.lang.String, java.lang.String, boolean, int):com.alibaba.pdns.model.d");
    }
}
