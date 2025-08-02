package com.alibaba.pdns.r;

import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import com.alibaba.pdns.model.d;
import com.alibaba.pdns.o;
import com.alibaba.pdns.r.d;
import com.alibaba.pdns.x.b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class c implements e {

    /* renamed from: d  reason: collision with root package name */
    public static int f18219d = 30;

    /* renamed from: e  reason: collision with root package name */
    public static int f18220e = 60;

    /* renamed from: f  reason: collision with root package name */
    public static int f18221f = 9999;

    /* renamed from: a  reason: collision with root package name */
    private volatile com.alibaba.pdns.w.a f18222a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile b f18223b;

    /* renamed from: c  reason: collision with root package name */
    private final a f18224c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.alibaba.pdns.model.c f18225a;

        a(com.alibaba.pdns.model.c cVar) {
            this.f18225a = cVar;
        }

        public void run() {
            if (this.f18225a != null) {
                long nanoTime = System.nanoTime();
                float a10 = c.this.f18223b.a(this.f18225a.f18015e, DNSResolver.getSpeedPort());
                if (a10 > -1.0f) {
                    com.alibaba.pdns.model.c cVar = this.f18225a;
                    cVar.f18020j = a10;
                    cVar.f18012b = Long.valueOf(nanoTime);
                    com.alibaba.pdns.model.c cVar2 = this.f18225a;
                    cVar2.f18021k = String.valueOf(Integer.valueOf(cVar2.f18021k).intValue() + 1);
                    this.f18225a.f18023m = String.valueOf(System.currentTimeMillis());
                    return;
                }
                com.alibaba.pdns.model.c cVar3 = this.f18225a;
                cVar3.f18020j = 9999.0f;
                cVar3.f18012b = Long.valueOf(nanoTime);
                com.alibaba.pdns.model.c cVar4 = this.f18225a;
                cVar4.f18022l = String.valueOf(Integer.valueOf(cVar4.f18022l).intValue() + 1);
                this.f18225a.f18024n = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    public c() {
        this.f18222a = null;
        this.f18223b = null;
        this.f18224c = new a();
        this.f18222a = new com.alibaba.pdns.w.b();
        this.f18223b = new com.alibaba.pdns.x.c();
    }

    public CopyOnWriteArrayList<com.alibaba.pdns.model.a> b() {
        com.alibaba.pdns.model.a aVar;
        if (!DNSResolver.enableCache) {
            DNSResolver.getInstance().clear();
            return null;
        }
        CopyOnWriteArrayList<com.alibaba.pdns.model.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            if (d.d() != null) {
                for (d.a next : d.d().values()) {
                    if (!(next == null || (aVar = (com.alibaba.pdns.model.a) next.a()) == null)) {
                        copyOnWriteArrayList.add(aVar);
                    }
                }
            }
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    public void c() {
        DNSResolver.statisticalMap.clear();
    }

    public void d() {
        d.b();
    }

    public void e(com.alibaba.pdns.model.a aVar) {
        if (aVar != null) {
            try {
                CopyOnWriteArrayList<com.alibaba.pdns.model.c> copyOnWriteArrayList = aVar.f17988n;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                if (copyOnWriteArrayList.size() >= 1) {
                    Iterator<com.alibaba.pdns.model.c> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        com.alibaba.pdns.pools.a.a().execute(new a(it.next()));
                    }
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.a a(java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            r8 = this;
            r0 = 0
            boolean r1 = com.alibaba.pdns.DNSResolver.enableCache     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r1 != 0) goto L_0x0013
            com.alibaba.pdns.DNSResolver r9 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            r9.clear()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            return r0
        L_0x000d:
            r9 = move-exception
            goto L_0x0082
        L_0x0010:
            r9 = move-exception
            goto L_0x0082
        L_0x0013:
            java.lang.String r9 = com.alibaba.pdns.o.a((java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            long r1 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            com.alibaba.pdns.r.d$a r3 = com.alibaba.pdns.r.d.d(r9)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r3 == 0) goto L_0x0028
            java.lang.Object r3 = r3.a()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            com.alibaba.pdns.model.a r3 = (com.alibaba.pdns.model.a) r3     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            goto L_0x0029
        L_0x0028:
            r3 = r0
        L_0x0029:
            long r4 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            r6.<init>()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            java.lang.String r7 = "data from pdnscache time:"
            r6.append(r7)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            long r4 = r4 - r1
            r1 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r1
            r6.append(r4)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            java.lang.String r1 = "μs"
            r6.append(r1)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            com.alibaba.pdns.u.a.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r3 == 0) goto L_0x0053
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.c> r1 = r3.f17988n     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r1 == 0) goto L_0x0053
            com.alibaba.pdns.r.d.e(r9)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
        L_0x0053:
            if (r3 == 0) goto L_0x0080
            boolean r9 = r8.a((com.alibaba.pdns.model.a) r3)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            r1 = 2
            if (r9 != 0) goto L_0x0070
            boolean r9 = r8.c(r3)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r9 == 0) goto L_0x0080
            boolean r9 = com.alibaba.pdns.r.a.b(r3)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r9 != 0) goto L_0x006f
            com.alibaba.pdns.DNSResolver r9 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            r9.getPDnsDataAsync(r10, r11, r1)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
        L_0x006f:
            return r3
        L_0x0070:
            if (r12 != 0) goto L_0x0078
            boolean r9 = r8.d(r3)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            if (r9 == 0) goto L_0x0081
        L_0x0078:
            com.alibaba.pdns.DNSResolver r9 = com.alibaba.pdns.DNSResolver.getInstance()     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            r9.getPDnsDataAsync(r10, r11, r1)     // Catch:{ Exception -> 0x0010, Error -> 0x000d }
            return r3
        L_0x0080:
            r0 = r3
        L_0x0081:
            return r0
        L_0x0082:
            boolean r10 = com.alibaba.pdns.u.a.f18279a
            if (r10 == 0) goto L_0x0089
            r9.printStackTrace()
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.r.c.a(java.lang.String, java.lang.String, java.lang.String, boolean):com.alibaba.pdns.model.a");
    }

    public boolean c(com.alibaba.pdns.model.a aVar) {
        if (aVar == null) {
            return false;
        }
        int a10 = a(aVar.f17979e);
        int i10 = aVar.f17978d;
        if (i10 - a10 < Math.max((int) (((float) i10) * 0.1f), 1)) {
            return true;
        }
        return false;
    }

    public boolean d(com.alibaba.pdns.model.a aVar) {
        return aVar != null && a(aVar.f17979e) < f18219d;
    }

    public void b(com.alibaba.pdns.model.a aVar) {
        if (aVar != null) {
            try {
                com.alibaba.pdns.model.b bVar = aVar.f17975a;
                if (bVar != null) {
                    bVar.f17996f.incrementAndGet();
                    bVar.a((aVar.f17987m + bVar.a()) / 2.0f);
                    bVar.b(Math.max(aVar.f17987m, bVar.d()));
                }
            } catch (Error | Exception e10) {
                if (com.alibaba.pdns.u.a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public com.alibaba.pdns.model.a a(com.alibaba.pdns.model.d dVar) {
        d.a[] aVarArr;
        CopyOnWriteArrayList<com.alibaba.pdns.model.c> copyOnWriteArrayList;
        ConcurrentHashMap concurrentHashMap = null;
        if (dVar == null || (aVarArr = dVar.f18030e) == null || aVarArr.length == 0) {
            return null;
        }
        int i10 = f18220e;
        String str = dVar.f18033h;
        String str2 = dVar.f18028c;
        String str3 = dVar.f18031f;
        com.alibaba.pdns.model.a aVar = new com.alibaba.pdns.model.a();
        aVar.f17980f = str;
        aVar.f17977c = str3;
        aVar.f17976b = str2;
        aVar.f17987m = dVar.f18036k;
        aVar.f17981g = dVar.f18034i;
        aVar.f17986l = dVar.f18035j;
        aVar.f17975a = dVar.f18029d;
        aVar.f17979e = System.nanoTime();
        aVar.f17988n = new CopyOnWriteArrayList<>();
        if (DNSResolver.isEnableSpeedTest()) {
            com.alibaba.pdns.model.a a10 = a(str3, str2, str, false);
            String str4 = DNSResolver.sdkStartUpISP;
            if (!(a10 == null || !TextUtils.equals(str4, a10.f17977c) || (copyOnWriteArrayList = a10.f17988n) == null)) {
                concurrentHashMap = new ConcurrentHashMap();
                if (copyOnWriteArrayList.size() > 0) {
                    Iterator<com.alibaba.pdns.model.c> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        com.alibaba.pdns.model.c next = it.next();
                        concurrentHashMap.put(next.f18015e, Float.valueOf(next.f18020j));
                    }
                }
            }
        }
        String str5 = "";
        for (d.a aVar2 : dVar.f18030e) {
            if (aVar2 != null) {
                i10 = Math.max(i10, aVar2.f18038b);
                if (!TextUtils.isEmpty(aVar2.f18037a)) {
                    com.alibaba.pdns.model.c cVar = new com.alibaba.pdns.model.c();
                    cVar.f18015e = aVar2.f18037a;
                    cVar.f18018h = aVar2.f18038b;
                    cVar.f18011a = aVar2.f18039c;
                    cVar.f18016f = 80;
                    cVar.f18017g = aVar.f17977c;
                    str5 = str5 + cVar.f18015e + ";";
                    if (!DNSResolver.isEnableSpeedTest()) {
                        cVar.f18020j = (float) f18221f;
                    } else if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                        Float f10 = (Float) concurrentHashMap.get(aVar2.f18037a);
                        if (f10 != null) {
                            cVar.f18020j = f10.floatValue();
                        } else {
                            cVar.f18020j = (float) f18221f;
                        }
                    }
                    aVar.f17988n.add(cVar);
                }
            }
        }
        aVar.f17978d = i10;
        if (str5.length() > 1) {
            aVar.f17984j = str5.substring(0, str5.length() - 1);
        }
        CopyOnWriteArrayList<com.alibaba.pdns.model.c> copyOnWriteArrayList2 = aVar.f17988n;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty() && DNSResolver.isEnableSpeedTest()) {
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                this.f18222a.a(aVar);
            }
            e(aVar);
        }
        this.f18224c.a(aVar);
        a(o.a(str3, aVar.f17976b, dVar.f18033h), aVar);
        com.alibaba.pdns.u.a.a("lruCache缓存数量" + d.f() + "isNegativeResp:" + dVar.f18026a);
        return aVar;
    }

    public CopyOnWriteArrayList<com.alibaba.pdns.model.a> a() {
        if (!DNSResolver.enableCache) {
            DNSResolver.getInstance().clear();
            return null;
        }
        CopyOnWriteArrayList<com.alibaba.pdns.model.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String str = DNSResolver.sdkStartUpISP;
            if (d.d() != null) {
                for (d.a next : d.d().values()) {
                    if (next != null) {
                        com.alibaba.pdns.model.a aVar = (com.alibaba.pdns.model.a) next.a();
                        if (a(aVar) && TextUtils.equals(str, aVar.f17977c)) {
                            copyOnWriteArrayList.add(aVar);
                        }
                    }
                }
            }
        } catch (Error | Exception e10) {
            if (com.alibaba.pdns.u.a.f18279a) {
                e10.printStackTrace();
            }
        }
        return copyOnWriteArrayList;
    }

    public void a(int i10) {
        d.a(Integer.valueOf(i10));
    }

    public void a(String str, com.alibaba.pdns.model.a aVar) {
        d.a d10;
        if (aVar != null) {
            String str2 = aVar.f17981g;
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, DNSResolver.REQUEST_LOCAL_DNS_TYPE)) {
                d.a(str, (Object) aVar);
            } else if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, DNSResolver.REQUEST_LOCAL_DNS_TYPE) && (d10 = d.d(str)) != null) {
                com.alibaba.pdns.model.a aVar2 = (com.alibaba.pdns.model.a) d10.a();
                if (aVar2 != null) {
                    String str3 = aVar2.f17981g;
                    if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, DNSResolver.REQUEST_LOCAL_DNS_TYPE)) {
                        d.a(str, (Object) aVar);
                        return;
                    }
                    return;
                }
                d.a(str, (Object) aVar);
            }
        }
    }

    private int a(long j10) {
        if (!DNSResolver.immutableCacheEnable) {
            return (int) (((double) (System.nanoTime() - j10)) / 1.0E9d);
        }
        return 0;
    }

    public boolean a(com.alibaba.pdns.model.a aVar) {
        return aVar != null && a(aVar.f17979e) > aVar.f17978d;
    }
}
