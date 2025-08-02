package com.alibaba.pdns;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.pdns.model.ReportDomanInfo;
import com.alibaba.pdns.model.d;
import com.alibaba.pdns.net.f.g;
import com.alibaba.pdns.r.e;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class DNSResolver {
    public static final int GOBACK_LOCAL = 101;
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    public static final int LOCAL_ERRO = 100;
    public static final int PORT_443 = 443;
    public static final int PORT_80 = 80;
    public static final int PORT_NULL = -1;
    public static final String QTYPE_IPV4 = "1";
    public static final String QTYPE_IPV4_IPV6 = "1_28";
    public static final String QTYPE_IPV6 = "28";
    public static final String REQUEST_AYSNC_PDNS_TYPE = "aysnc_pdns";
    public static final String REQUEST_LOCAL_DNS_TYPE = "localDns";
    public static final String REQUEST_PDNS_TYPE = "pdns";
    public static int TIMER_INTERVAL = 60000;
    public static int addressMode = 0;
    public static volatile AtomicLong atomicLong = new AtomicLong();
    public static String[] domains = null;
    public static boolean enableCache = true;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f17829i = false;
    public static boolean immutableCacheEnable = false;
    public static volatile AtomicBoolean isFristReportInfo = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private static boolean f17830j = true;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f17831k = false;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f17832l = true;

    /* renamed from: m  reason: collision with root package name */
    private static String f17833m = "";
    public static Set<String> mPersistentCacheDomains = null;
    public static int maxNegativeCache = 30;
    public static int maxTtlCache = 3600;
    public static int minTtlCache = 60;

    /* renamed from: n  reason: collision with root package name */
    private static String f17834n = "";

    /* renamed from: o  reason: collision with root package name */
    private static volatile String f17835o = "";

    /* renamed from: p  reason: collision with root package name */
    private static String f17836p = "https";
    public static int port = 80;

    /* renamed from: q  reason: collision with root package name */
    private static volatile DNSResolver f17837q = null;
    public static String qType = null;

    /* renamed from: r  reason: collision with root package name */
    private static Context f17838r = null;

    /* renamed from: s  reason: collision with root package name */
    private static String f17839s = null;
    public static String sdkStartUpISP = "";
    public static Map<String, com.alibaba.pdns.model.b> statisticalMap = new ConcurrentHashMap();

    /* renamed from: t  reason: collision with root package name */
    private static boolean f17840t = false;

    /* renamed from: u  reason: collision with root package name */
    private static final int f17841u = 5;

    /* renamed from: a  reason: collision with root package name */
    private boolean f17842a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public e f17843b = null;

    /* renamed from: c  reason: collision with root package name */
    private com.alibaba.pdns.v.a f17844c = null;

    /* renamed from: d  reason: collision with root package name */
    private com.alibaba.pdns.w.a f17845d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.alibaba.pdns.s.a f17846e = null;

    /* renamed from: f  reason: collision with root package name */
    private com.alibaba.pdns.x.b f17847f = null;

    /* renamed from: g  reason: collision with root package name */
    private ScheduledExecutorService f17848g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17849h = TIMER_INTERVAL;
    public volatile int mCurNetworkType = -1;
    public long timerTaskOldRunTime = 0;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17850a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17851b;

        a(String str, String str2) {
            this.f17850a = str;
            this.f17851b = str2;
        }

        public void run() {
            try {
                com.alibaba.pdns.model.a pDnsData = DNSResolver.this.getPDnsData(this.f17850a, this.f17851b);
                if (DNSResolver.this.f17843b != null) {
                    DNSResolver.this.f17843b.b(pDnsData);
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    class b implements ThreadFactory {
        b() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            thread.setDaemon(false);
            return thread;
        }
    }

    class c implements Runnable {
        c() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x001d  */
        /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r2 = this;
                boolean r0 = com.alibaba.pdns.f.f()     // Catch:{ Exception -> 0x000d, Error -> 0x000b }
                if (r0 == 0) goto L_0x000f
                r0 = 1
                com.alibaba.pdns.f.a((boolean) r0)     // Catch:{ Exception -> 0x000d, Error -> 0x000b }
                goto L_0x000f
            L_0x000b:
                r0 = move-exception
                goto L_0x0019
            L_0x000d:
                r0 = move-exception
                goto L_0x0019
            L_0x000f:
                boolean r0 = com.alibaba.pdns.f.e()     // Catch:{ Exception -> 0x000d, Error -> 0x000b }
                if (r0 == 0) goto L_0x0020
                com.alibaba.pdns.f.b()     // Catch:{ Exception -> 0x000d, Error -> 0x000b }
                goto L_0x0020
            L_0x0019:
                boolean r1 = com.alibaba.pdns.u.a.f18279a
                if (r1 == 0) goto L_0x0020
                r0.printStackTrace()
            L_0x0020:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.DNSResolver.c.run():void");
        }
    }

    private DNSResolver() {
        c();
        e();
    }

    public static void Init(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                f17838r = context.getApplicationContext();
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, "")) {
                    throw new IllegalArgumentException("DNSResolver Init accountID".concat(" can not be empty please fill in the correctnone on the console!"));
                }
                f17839s = str;
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, "")) {
                    setAccessKeyId(str2);
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, "")) {
                    setAccessKeySecret(str3);
                }
            } catch (Exception e10) {
                e = e10;
                e.printStackTrace();
            } catch (Error e11) {
                e = e11;
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("DNSResolver Init context can not be null please configure the context!");
        }
    }

    private DomainInfo[] b(String str, String str2) {
        try {
            String host = new URL(str).getHost();
            String[] c10 = c(host, str2);
            if (c10 != null) {
                if (c10.length != 0) {
                    return DomainInfo.domainInfoFactory(c10, str, host, str2);
                }
            }
            return null;
        } catch (MalformedURLException e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
            return null;
        } catch (Error | Exception e11) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e11.printStackTrace();
            }
            return null;
        }
    }

    private void c() {
        try {
            g.d();
            g.a(f17838r);
            this.mCurNetworkType = g.d().a();
            sdkStartUpISP = g.d().b();
            addressMode = com.alibaba.pdns.jni.a.a();
            f.f17923p = System.nanoTime();
            com.alibaba.pdns.net.f.c.a(f17838r);
            b.a(f17838r);
            a();
            f.d();
            com.alibaba.pdns.r.c cVar = new com.alibaba.pdns.r.c();
            this.f17843b = cVar;
            this.f17844c = new com.alibaba.pdns.v.b(cVar);
            this.f17845d = new com.alibaba.pdns.w.b();
            this.f17846e = new com.alibaba.pdns.s.a();
            this.f17847f = new com.alibaba.pdns.x.c();
        } catch (Error | Exception e10) {
            e10.printStackTrace();
        }
    }

    private void d(String str, String str2) {
        if (a(str, str2, false, false) == null) {
            getPDnsDataAsync(str, str2, 1);
        }
    }

    private void e() {
        this.timerTaskOldRunTime = System.nanoTime();
        if (this.f17848g == null) {
            ScheduledExecutorService b10 = b();
            this.f17848g = b10;
            if (!b10.isShutdown()) {
                ScheduledExecutorService scheduledExecutorService = this.f17848g;
                c cVar = new c();
                long j10 = (long) this.f17849h;
                scheduledExecutorService.scheduleAtFixedRate(cVar, j10, j10, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void f() {
        ScheduledExecutorService scheduledExecutorService = this.f17848g;
        if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
            this.f17848g.shutdown();
            do {
                try {
                } catch (InterruptedException e10) {
                    if (com.alibaba.pdns.u.a.f18279a) {
                        e10.printStackTrace();
                    }
                } catch (Error | Exception e11) {
                    if (com.alibaba.pdns.u.a.f18279a) {
                        e11.printStackTrace();
                    }
                } catch (Throwable th) {
                    this.f17848g = null;
                    throw th;
                }
            } while (!this.f17848g.awaitTermination(60, TimeUnit.SECONDS));
            this.f17848g = null;
            com.alibaba.pdns.u.a.a("awaitTermination...");
            com.alibaba.pdns.u.a.a("Finished all threads");
        }
        this.f17848g = null;
    }

    public static String getAccessKeyId() {
        return f17834n;
    }

    public static String getAccessKeySecret() {
        return f17833m;
    }

    public static String getAccountId() {
        return f17839s;
    }

    public static com.alibaba.pdns.model.b getDomainStats(String str, String str2, String str3) {
        String a10 = o.a(str, str2, str3);
        if (statisticalMap.get(a10) != null) {
            return statisticalMap.get(a10);
        }
        com.alibaba.pdns.model.b bVar = new com.alibaba.pdns.model.b();
        bVar.b(str);
        bVar.a(str2);
        bVar.a(Integer.parseInt(str3));
        statisticalMap.put(a10, bVar);
        return bVar;
    }

    public static String getEdnsSubnet() {
        return f17835o;
    }

    public static boolean getEnableCache() {
        return enableCache;
    }

    public static DNSResolver getInstance() {
        if (f17837q == null) {
            synchronized (DNSResolver.class) {
                try {
                    if (f17837q == null) {
                        f17837q = new DNSResolver();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f17837q;
    }

    public static int getMaxNegativeCache() {
        return maxNegativeCache;
    }

    public static int getMaxTtlCache() {
        return maxTtlCache;
    }

    public static int getMinTtlCache() {
        return minTtlCache;
    }

    public static String getSchemaType() {
        return f17836p;
    }

    public static int getSpeedPort() {
        return port;
    }

    public static boolean iSEnableShort() {
        return f17829i;
    }

    public static boolean isEnableIPv6() {
        return f17831k;
    }

    public static boolean isEnableLocalDns() {
        return f17832l;
    }

    public static boolean isEnableSpeedTest() {
        return f17840t;
    }

    public static boolean ispEnable() {
        return f17830j;
    }

    @Deprecated
    public static void setAccessKeyId(String str) {
        if (!TextUtils.isEmpty(str)) {
            f17834n = str.replaceAll("\\s*", "");
        }
    }

    @Deprecated
    public static void setAccessKeySecret(String str) {
        if (!TextUtils.isEmpty(str)) {
            f17833m = str.replaceAll("\\s*", "");
        }
    }

    public static void setAccountId(String str) {
        f17839s = str;
    }

    public static void setEdnsSubnet(String str) {
        if (!TextUtils.isEmpty(str)) {
            f17835o = str;
        }
    }

    @Deprecated
    public static void setEnableCache(boolean z10) {
        enableCache = z10;
        if (!z10) {
            getInstance().clear();
        }
    }

    public static void setEnableIPv6(boolean z10) {
        f17831k = z10;
    }

    public static void setEnableLocalDns(boolean z10) {
        f17832l = z10;
    }

    public static void setEnableLogger(boolean z10) {
        if (z10) {
            com.alibaba.pdns.u.a.f18279a = true;
            com.alibaba.pdns.u.a.a(6);
            return;
        }
        com.alibaba.pdns.u.a.f18279a = false;
        com.alibaba.pdns.u.a.a(0);
    }

    @Deprecated
    public static void setEnableShort(boolean z10) {
        f17829i = z10;
    }

    @Deprecated
    public static void setEnableSpeedTest(boolean z10) {
        f17840t = z10;
    }

    public static void setImmutableCacheEnable(boolean z10) {
        immutableCacheEnable = z10;
    }

    @Deprecated
    public static void setIspEnable(boolean z10) {
        f17830j = z10;
    }

    public static synchronized void setKeepAliveDomains(String[] strArr) {
        synchronized (DNSResolver.class) {
            if (strArr != null) {
                try {
                    if (strArr.length > 0) {
                        if (mPersistentCacheDomains == null) {
                            mPersistentCacheDomains = o.a(strArr.length);
                        }
                        for (String str : strArr) {
                            if (TextUtils.isEmpty(str)) {
                                str = str.trim();
                                if (TextUtils.isEmpty(str)) {
                                }
                            }
                            mPersistentCacheDomains.add(str);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Deprecated
    public static void setMaxNegativeCache(int i10) {
        maxNegativeCache = i10;
    }

    @Deprecated
    public static void setMaxTtlCache(int i10) {
        if (i10 <= getMinTtlCache()) {
            maxTtlCache = i10;
            minTtlCache = i10;
            return;
        }
        maxTtlCache = i10;
    }

    public static void setMinTtlCache(int i10) {
        int maxTtlCache2 = getMaxTtlCache();
        if (i10 >= maxTtlCache2) {
            minTtlCache = maxTtlCache2;
        } else {
            minTtlCache = i10;
        }
    }

    public static void setSchemaType(String str) {
        f17836p = str;
    }

    public static void setSpeedPort(int i10) {
        port = i10;
    }

    public void clear() {
        e dnsCacheManager = getDnsCacheManager();
        if (dnsCacheManager != null) {
            dnsCacheManager.d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearHostCache(java.lang.String[] r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x005f
            int r0 = r9.length     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r0 <= 0) goto L_0x005f
            int r0 = r9.length     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x006a
            r2 = r9[r1]     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r3 != 0) goto L_0x005c
            java.util.Map r3 = com.alibaba.pdns.r.d.d()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.util.Set r3 = r3.keySet()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
        L_0x001d:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r4 == 0) goto L_0x005c
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r5 != 0) goto L_0x001d
            java.lang.String r5 = ""
            boolean r5 = android.text.TextUtils.equals(r4, r5)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r5 != 0) goto L_0x001d
            java.lang.String r5 = sdkStartUpISP     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.lang.String r6 = "1"
            java.lang.String r5 = com.alibaba.pdns.o.a((java.lang.String) r5, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.lang.String r6 = sdkStartUpISP     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            java.lang.String r7 = "28"
            java.lang.String r6 = com.alibaba.pdns.o.a((java.lang.String) r6, (java.lang.String) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            boolean r5 = android.text.TextUtils.equals(r4, r5)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r5 != 0) goto L_0x0058
            boolean r5 = android.text.TextUtils.equals(r4, r6)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            if (r5 == 0) goto L_0x001d
            goto L_0x0058
        L_0x0054:
            r9 = move-exception
            goto L_0x0063
        L_0x0056:
            r9 = move-exception
            goto L_0x0063
        L_0x0058:
            com.alibaba.pdns.r.d.b(r4)     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            goto L_0x001d
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x005f:
            com.alibaba.pdns.r.d.b()     // Catch:{ Exception -> 0x0056, Error -> 0x0054 }
            goto L_0x006a
        L_0x0063:
            boolean r0 = com.alibaba.pdns.u.a.f18279a
            if (r0 == 0) goto L_0x006a
            r9.printStackTrace()
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.DNSResolver.clearHostCache(java.lang.String[]):void");
    }

    public e getDnsCacheManager() {
        return this.f17843b;
    }

    public String getIPV4ByHost(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        String[] c10 = c(str, "1");
        if (c10 == null || c10.length <= 0) {
            return null;
        }
        if (isEnableSpeedTest()) {
            return c10[0];
        }
        return c10[(int) (Math.random() * ((double) c10.length))];
    }

    public DomainInfo getIPV4DInfoByUrl(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        DomainInfo[] b10 = b(str, "1");
        if (b10 == null || b10.length <= 0) {
            return null;
        }
        return b10[(int) (Math.random() * ((double) b10.length))];
    }

    public String getIPV6ByHost(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        String[] c10 = c(str, QTYPE_IPV6);
        if (c10 == null || c10.length <= 0) {
            return null;
        }
        if (isEnableSpeedTest()) {
            return c10[0];
        }
        return c10[(int) (Math.random() * ((double) c10.length))];
    }

    public DomainInfo getIPV6DInfoByUrl(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        DomainInfo[] b10 = b(str, QTYPE_IPV6);
        if (b10 == null || b10.length <= 0) {
            return null;
        }
        return b10[(int) (Math.random() * ((double) b10.length))];
    }

    public String[] getIPsV4ByHost(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return c(str, "1");
    }

    public DomainInfo[] getIPsV4DInfoByUrl(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return b(str, "1");
    }

    public String[] getIPsV6ByHost(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return c(str, QTYPE_IPV6);
    }

    public DomainInfo[] getIPsV6DInfoByUrl(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return b(str, QTYPE_IPV6);
    }

    public String[] getIpsByHost(String str) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return a(str, false, false);
    }

    public String[] getIpsByHostFromCache(String str, boolean z10) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return a(str, z10, true);
    }

    public String[] getIpv4ByHostFromCache(String str, boolean z10) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return a(str, "1", z10);
    }

    public String[] getIpv6ByHostFromCache(String str, boolean z10) {
        com.alibaba.pdns.model.b.f17989u.incrementAndGet();
        return a(str, QTYPE_IPV6, z10);
    }

    public final com.alibaba.pdns.model.a getPDnsData(String str, String str2) {
        com.alibaba.pdns.model.a a10;
        try {
            com.alibaba.pdns.s.a aVar = this.f17846e;
            if (aVar != null) {
                if (this.f17843b != null) {
                    d a11 = aVar.a(str, str2);
                    if (a11 == null || (a10 = this.f17843b.a(a11)) == null) {
                        return null;
                    }
                    return a10;
                }
            }
            return null;
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    public void getPDnsDataAsync(String str, String str2, int i10) {
        try {
            if (!e.a(getAccountId())) {
                throw new RuntimeException("DNSResolver Init accountID can not be empty please initalize the SDK before using it!!");
            } else if (!g.a.f()) {
                com.alibaba.pdns.u.a.b("---------///-------->", "Please check the network and use it after confirming it is normal!");
                getDomainStats(sdkStartUpISP, str, str2).f17991a.incrementAndGet();
            } else {
                com.alibaba.pdns.s.e.c.a().b(str, str2, i10);
            }
        } catch (Exception e10) {
            e = e10;
            e.printStackTrace();
        } catch (Error e11) {
            e = e11;
            e.printStackTrace();
        }
    }

    public String getRequestReportInfo() {
        try {
            CopyOnWriteArrayList<ReportDomanInfo.DataJsonBean> b10 = g.b();
            if (b10 == null || b10.isEmpty()) {
                return null;
            }
            return JsonUitl.objectToString(b10);
        } catch (Error | Exception e10) {
            if (!com.alibaba.pdns.u.a.f18279a) {
                return null;
            }
            e10.printStackTrace();
            return null;
        }
    }

    public boolean isNetworkChanged() {
        int a10 = g.d().a();
        if (a10 == -1) {
            this.mCurNetworkType = a10;
            return false;
        } else if (this.mCurNetworkType == a10) {
            return false;
        } else {
            this.mCurNetworkType = a10;
            return true;
        }
    }

    public void onNetworkStatusChanged() {
        try {
            d();
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
    }

    public void preLoadDomains(String str, String[] strArr) {
        qType = str;
        domains = strArr;
        com.alibaba.pdns.model.b.f17990v.incrementAndGet();
        if (str != null && strArr != null) {
            int i10 = 0;
            if (TextUtils.isEmpty(str) || !str.equals(QTYPE_IPV4_IPV6)) {
                int length = strArr.length;
                while (i10 < length) {
                    d(strArr[i10], str);
                    i10++;
                }
                return;
            }
            int length2 = strArr.length;
            while (i10 < length2) {
                String str2 = strArr[i10];
                d(str2, "1");
                d(str2, QTYPE_IPV6);
                i10++;
            }
        }
    }

    public void setMaxCacheSize(int i10) {
        e dnsCacheManager = getDnsCacheManager();
        if (dnsCacheManager != null) {
            dnsCacheManager.a(i10);
        }
    }

    private static void a() {
        if (TextUtils.isEmpty(getAccessKeyId()) || TextUtils.equals(getAccessKeyId(), "")) {
            String b10 = b.b();
            if (TextUtils.isEmpty(b10) || TextUtils.equals(b10, "")) {
                throw new IllegalArgumentException("DNSResolver Init accessKeyId".concat(" can not be empty please fill in the correctnone on the console!"));
            }
            setAccessKeyId(b10);
        }
        if (TextUtils.isEmpty(getAccessKeySecret()) || TextUtils.equals(getAccessKeySecret(), "")) {
            String c10 = b.c();
            if (TextUtils.isEmpty(c10) || TextUtils.equals(c10, "")) {
                throw new IllegalArgumentException("DNSResolver Init accessKeySecret".concat(" can not be empty please fill in the correctnone on the console!"));
            }
            setAccessKeySecret(c10);
        }
    }

    private void d() {
        addressMode = com.alibaba.pdns.jni.a.a();
        if (isNetworkChanged()) {
            sdkStartUpISP = g.d().b();
            f.a();
            f.a(false);
            if (ispEnable() && enableCache) {
                if (this.f17842a) {
                    preLoadDomains(domains);
                } else {
                    preLoadDomains(qType, domains);
                }
            }
        }
    }

    private ScheduledExecutorService b() {
        return new ScheduledThreadPoolExecutor(5, new b());
    }

    public void preLoadDomains(String[] strArr) {
        this.f17842a = true;
        int i10 = addressMode;
        String str = "1";
        if (i10 != 1) {
            if (i10 == 2) {
                str = QTYPE_IPV6;
            } else if (i10 == 3) {
                str = QTYPE_IPV4_IPV6;
            }
        }
        preLoadDomains(str, strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0144 A[Catch:{ Exception -> 0x0019, Error -> 0x0016 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0159 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x015a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] a(java.lang.String r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7.isEmpty()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2 = 1
            if (r1 != 0) goto L_0x0031
            boolean r1 = com.alibaba.pdns.o.h(r7)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r1 == 0) goto L_0x001c
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            return r7
        L_0x0016:
            r7 = move-exception
            goto L_0x015b
        L_0x0019:
            r7 = move-exception
            goto L_0x015b
        L_0x001c:
            boolean r1 = com.alibaba.pdns.o.j(r7)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r1 == 0) goto L_0x0031
            java.lang.String r8 = "]"
            int r8 = r7.lastIndexOf(r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String r7 = r7.substring(r2, r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            return r7
        L_0x0031:
            int r1 = addressMode     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String r3 = "1"
            r4 = 0
            if (r1 == r2) goto L_0x0134
            r2 = 2
            java.lang.String r5 = "28"
            if (r1 == r2) goto L_0x00ec
            r2 = 3
            if (r1 == r2) goto L_0x0044
            r8 = r0
            r2 = r8
            goto L_0x0142
        L_0x0044:
            com.alibaba.pdns.model.a r1 = r6.a(r7, r3, r8, r4)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.a r8 = r6.a(r7, r5, r8, r4)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r1 == 0) goto L_0x0074
            if (r8 == 0) goto L_0x0074
            com.alibaba.pdns.model.a r2 = new com.alibaba.pdns.model.a     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r3.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.f17988n = r3     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r8 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r3.addAll(r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r8 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r1.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r8.addAll(r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            boolean r8 = isEnableSpeedTest()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r8 == 0) goto L_0x00df
            com.alibaba.pdns.w.a r8 = r6.f17845d     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r8.a((com.alibaba.pdns.model.a) r2)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x00df
        L_0x0074:
            if (r8 == 0) goto L_0x00a9
            com.alibaba.pdns.model.a r2 = new com.alibaba.pdns.model.a     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r1.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.f17988n = r1     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r8 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r1.addAll(r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r9 != 0) goto L_0x00df
            com.alibaba.pdns.s.a r8 = r6.f17846e     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.d r8 = r8.a(r7, r3)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r8 == 0) goto L_0x00df
            com.alibaba.pdns.r.e r1 = r6.f17843b     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.a r8 = r1.a((com.alibaba.pdns.model.d) r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r8 == 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r1 != 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r8 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r1.addAll(r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x00df
        L_0x00a9:
            if (r1 == 0) goto L_0x00de
            com.alibaba.pdns.model.a r2 = new com.alibaba.pdns.model.a     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList r8 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r8.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r2.f17988n = r8     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r1.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r8.addAll(r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r9 != 0) goto L_0x00df
            com.alibaba.pdns.s.a r8 = r6.f17846e     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.d r8 = r8.a(r7, r5)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r8 == 0) goto L_0x00df
            com.alibaba.pdns.r.e r1 = r6.f17843b     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.a r8 = r1.a((com.alibaba.pdns.model.d) r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r8 == 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r1 != 0) goto L_0x00df
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r8 = r8.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r1.addAll(r8)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x00df
        L_0x00de:
            r2 = r0
        L_0x00df:
            if (r2 == 0) goto L_0x00ea
            com.alibaba.pdns.w.a r8 = r6.f17845d     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r8 = r8.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x0142
        L_0x00ea:
            r8 = r0
            goto L_0x0142
        L_0x00ec:
            com.alibaba.pdns.model.a r2 = r6.a(r7, r5, r8, r4)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r2 != 0) goto L_0x012b
            com.alibaba.pdns.model.a r2 = r6.a(r7, r3, r8, r4)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r2 == 0) goto L_0x00ea
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            r8.<init>()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
        L_0x0103:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r3 == 0) goto L_0x0122
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.model.c r3 = (com.alibaba.pdns.model.c) r3     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String r3 = r3.f18015e     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String r5 = com.alibaba.pdns.l.a(r3)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            com.alibaba.pdns.l.b(r5)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r5 != 0) goto L_0x0103
            r8.add(r3)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x0103
        L_0x0122:
            java.lang.String[] r1 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.Object[] r8 = r8.toArray(r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x0142
        L_0x012b:
            com.alibaba.pdns.w.a r8 = r6.f17845d     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r8 = r8.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            goto L_0x0142
        L_0x0134:
            com.alibaba.pdns.model.a r2 = r6.a(r7, r3, r8, r4)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r2 == 0) goto L_0x00ea
            com.alibaba.pdns.w.a r8 = r6.f17845d     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r2.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r8 = r8.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r1)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
        L_0x0142:
            if (r2 != 0) goto L_0x0153
            com.alibaba.pdns.model.a r7 = r6.a((java.lang.String) r7, (boolean) r9)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r7 != 0) goto L_0x014b
            return r0
        L_0x014b:
            com.alibaba.pdns.w.a r8 = r6.f17845d     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r7 = r7.f17988n     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            java.lang.String[] r8 = r8.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r7)     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
        L_0x0153:
            if (r8 == 0) goto L_0x015a
            int r7 = r8.length     // Catch:{ Exception -> 0x0019, Error -> 0x0016 }
            if (r7 != 0) goto L_0x0159
            goto L_0x015a
        L_0x0159:
            return r8
        L_0x015a:
            return r0
        L_0x015b:
            r7.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.DNSResolver.a(java.lang.String, boolean, boolean):java.lang.String[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] c(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4.isEmpty()     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            r2 = 1
            if (r1 != 0) goto L_0x003f
            boolean r1 = com.alibaba.pdns.o.h(r4)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "1"
            boolean r1 = android.text.TextUtils.equals(r5, r1)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r1 == 0) goto L_0x0022
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            return r4
        L_0x001e:
            r4 = move-exception
            goto L_0x0057
        L_0x0020:
            r4 = move-exception
            goto L_0x0057
        L_0x0022:
            boolean r1 = com.alibaba.pdns.o.j(r4)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "28"
            boolean r1 = android.text.TextUtils.equals(r5, r1)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r1 == 0) goto L_0x003f
            java.lang.String r5 = "]"
            int r5 = r4.lastIndexOf(r5)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            java.lang.String r4 = r4.substring(r2, r5)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            return r4
        L_0x003f:
            r1 = 0
            com.alibaba.pdns.model.a r4 = r3.a(r4, r5, r1, r2)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r4 != 0) goto L_0x0047
            return r0
        L_0x0047:
            com.alibaba.pdns.w.a r5 = r3.f17845d     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r4 = r4.f17988n     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            java.lang.String[] r4 = r5.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r4)     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r4 == 0) goto L_0x0056
            int r5 = r4.length     // Catch:{ Exception -> 0x0020, Error -> 0x001e }
            if (r5 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            return r4
        L_0x0056:
            return r0
        L_0x0057:
            boolean r5 = com.alibaba.pdns.u.a.f18279a
            if (r5 == 0) goto L_0x005e
            r4.printStackTrace()
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.DNSResolver.c(java.lang.String, java.lang.String):java.lang.String[]");
    }

    private com.alibaba.pdns.model.a a(String str, boolean z10) {
        com.alibaba.pdns.model.a a10;
        com.alibaba.pdns.model.a a11;
        com.alibaba.pdns.model.a a12;
        com.alibaba.pdns.model.a a13;
        int i10 = addressMode;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return null;
                }
                if (z10) {
                    getPDnsDataAsync(str, QTYPE_IPV6, 2);
                    getPDnsDataAsync(str, "1", 2);
                    return null;
                }
                d a14 = this.f17846e.a(str, QTYPE_IPV6);
                d a15 = this.f17846e.a(str, "1");
                com.alibaba.pdns.model.a aVar = new com.alibaba.pdns.model.a();
                aVar.f17988n = new CopyOnWriteArrayList<>();
                if (!(a14 == null || (a13 = this.f17843b.a(a14)) == null || a13.f17988n.isEmpty())) {
                    aVar.f17988n.addAll(a13.f17988n);
                }
                if (!(a15 == null || (a12 = this.f17843b.a(a15)) == null || a12.f17988n.isEmpty())) {
                    aVar.f17988n.addAll(a12.f17988n);
                }
                return aVar;
            } else if (z10) {
                getPDnsDataAsync(str, QTYPE_IPV6, 2);
                return null;
            } else {
                d a16 = this.f17846e.a(str, QTYPE_IPV6);
                if (a16 == null || (a11 = this.f17843b.a(a16)) == null) {
                    return null;
                }
                return a11;
            }
        } else if (z10) {
            getPDnsDataAsync(str, "1", 2);
            return null;
        } else {
            d a17 = this.f17846e.a(str, "1");
            if (a17 == null || (a10 = this.f17843b.a(a17)) == null) {
                return null;
            }
            return a10;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] a(java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r3.isEmpty()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r1 != 0) goto L_0x003f
            boolean r1 = com.alibaba.pdns.o.h(r3)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r1 == 0) goto L_0x0021
            java.lang.String r1 = "1"
            boolean r1 = android.text.TextUtils.equals(r4, r1)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r1 == 0) goto L_0x0021
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            return r3
        L_0x001d:
            r3 = move-exception
            goto L_0x005f
        L_0x001f:
            r3 = move-exception
            goto L_0x005f
        L_0x0021:
            boolean r1 = com.alibaba.pdns.o.j(r3)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "28"
            boolean r1 = android.text.TextUtils.equals(r4, r1)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r1 == 0) goto L_0x003f
            java.lang.String r4 = "]"
            int r4 = r3.lastIndexOf(r4)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r5 = 1
            java.lang.String r3 = r3.substring(r5, r4)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            return r3
        L_0x003f:
            r1 = 0
            com.alibaba.pdns.model.a r5 = r2.a(r3, r4, r5, r1)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r5 != 0) goto L_0x004f
            com.alibaba.pdns.DNSResolver r5 = getInstance()     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            r1 = 2
            r5.getPDnsDataAsync(r3, r4, r1)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            return r0
        L_0x004f:
            com.alibaba.pdns.w.a r3 = r2.f17845d     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r4 = r5.f17988n     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            java.lang.String[] r3 = r3.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c>) r4)     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r3 == 0) goto L_0x005e
            int r4 = r3.length     // Catch:{ Exception -> 0x001f, Error -> 0x001d }
            if (r4 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            return r3
        L_0x005e:
            return r0
        L_0x005f:
            boolean r4 = com.alibaba.pdns.u.a.f18279a
            if (r4 == 0) goto L_0x0066
            r3.printStackTrace()
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.DNSResolver.a(java.lang.String, java.lang.String, boolean):java.lang.String[]");
    }

    private com.alibaba.pdns.model.a a(String str, String str2, boolean z10, boolean z11) {
        if (!q.i(str)) {
            return null;
        }
        if (ispEnable()) {
            String str3 = sdkStartUpISP;
            com.alibaba.pdns.v.a aVar = this.f17844c;
            if (aVar != null) {
                return aVar.a(str3, str, str2, z10, z11);
            }
            return null;
        }
        com.alibaba.pdns.v.a aVar2 = this.f17844c;
        if (aVar2 != null) {
            return aVar2.a("", str, str2, z10, z11);
        }
        return null;
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.alibaba.pdns.pools.a.a().execute(new a(str, str2));
        }
    }
}
