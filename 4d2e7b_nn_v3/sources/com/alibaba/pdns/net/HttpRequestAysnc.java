package com.alibaba.pdns.net;

import com.alibaba.pdns.model.e;
import com.alibaba.pdns.model.f;
import java.util.concurrent.Callable;

public class HttpRequestAysnc implements Callable<e> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f18061i = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private int f18062a = 3;

    /* renamed from: b  reason: collision with root package name */
    private String f18063b;

    /* renamed from: c  reason: collision with root package name */
    private String f18064c;

    /* renamed from: d  reason: collision with root package name */
    private f f18065d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18066e;

    /* renamed from: f  reason: collision with root package name */
    private String f18067f;

    /* renamed from: g  reason: collision with root package name */
    private e f18068g;

    /* renamed from: h  reason: collision with root package name */
    private int f18069h;

    public HttpRequestAysnc(String str, f fVar, String str2, boolean z10, String str3, e eVar, int i10) {
        this.f18063b = str;
        this.f18064c = str2;
        this.f18065d = fVar;
        this.f18066e = z10;
        this.f18067f = str3;
        this.f18068g = eVar;
        this.f18069h = i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, com.alibaba.pdns.model.e r8, int r9) {
        /*
            r6 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r8.b()     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            java.lang.String r1 = "Ts is expired"
            boolean r1 = r0.contains(r1)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r1 == 0) goto L_0x005f
            int r9 = r9 + 1
            int r7 = r6.f18062a     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r9 <= r7) goto L_0x0016
            return
        L_0x0016:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            com.alibaba.pdns.model.f r7 = com.alibaba.pdns.f.c((java.lang.Object) r7)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r7 == 0) goto L_0x007c
            java.lang.String r1 = r7.f18049e     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r1)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r0 == 0) goto L_0x007c
            java.lang.String r0 = r6.f18064c     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            java.lang.String r2 = r6.f18067f     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            boolean r3 = r6.f18066e     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            long r4 = r8.a()     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            java.lang.String r8 = com.alibaba.pdns.f.a(r0, r1, r2, r3, r4)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r8)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r0 != 0) goto L_0x003d
            return
        L_0x003d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r0.<init>()     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            java.lang.String r1 = "reurl:"
            r0.append(r1)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r0.append(r8)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            com.alibaba.pdns.u.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r6.f18065d = r7     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r6.f18063b = r8     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r6.f18069h = r9     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r6.call()     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            goto L_0x007c
        L_0x005b:
            r7 = move-exception
            goto L_0x0075
        L_0x005d:
            r7 = move-exception
            goto L_0x0075
        L_0x005f:
            java.lang.String r8 = "User is unauthorized"
            boolean r8 = r0.contains(r8)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r8 == 0) goto L_0x0068
            goto L_0x007c
        L_0x0068:
            int r9 = r9 + 1
            int r8 = r6.f18062a     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            if (r9 <= r8) goto L_0x006f
            return
        L_0x006f:
            int r8 = r6.f18069h     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x005d, Error -> 0x005b }
            goto L_0x007c
        L_0x0075:
            boolean r8 = com.alibaba.pdns.u.a.f18279a
            if (r8 == 0) goto L_0x007c
            r7.printStackTrace()
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.HttpRequestAysnc.a(java.lang.String, com.alibaba.pdns.model.e, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.pdns.model.e call() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "请求的url:"
            r0.append(r1)
            java.lang.String r1 = r11.f18063b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alibaba.pdns.u.a.a((java.lang.String) r0)
            java.lang.String r0 = r11.f18063b
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r0)
            r1 = 0
            if (r0 != 0) goto L_0x0020
            return r1
        L_0x0020:
            java.lang.String r0 = r11.f18064c
            boolean r0 = com.alibaba.pdns.e.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            java.lang.String r0 = r11.f18064c
            boolean r0 = com.alibaba.pdns.q.i(r0)
            if (r0 != 0) goto L_0x0032
            return r1
        L_0x0032:
            com.alibaba.pdns.model.e r0 = r11.f18068g     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            if (r0 == 0) goto L_0x0041
            com.alibaba.pdns.model.b r0 = r0.d()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            goto L_0x0042
        L_0x003b:
            r0 = move-exception
            goto L_0x0100
        L_0x003e:
            r0 = move-exception
            goto L_0x0100
        L_0x0041:
            r0 = r1
        L_0x0042:
            com.alibaba.pdns.model.f r2 = r11.f18065d     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r10 = r2.f18049e     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.net.d r2 = com.alibaba.pdns.net.d.a()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = r11.f18063b     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r5 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r6 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.model.f r7 = r11.f18065d     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.model.e r8 = r11.f18068g     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r4 = r10
            r9 = r0
            com.alibaba.pdns.model.e r1 = r2.a(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            if (r1 == 0) goto L_0x0107
            if (r0 == 0) goto L_0x0107
            int r2 = r1.e()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.g.a((com.alibaba.pdns.model.e) r1, (int) r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            if (r2 <= 0) goto L_0x0107
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 == r3) goto L_0x00da
            r3 = 401(0x191, float:5.62E-43)
            java.lang.String r4 = "se"
            if (r2 == r3) goto L_0x00b6
            r3 = 500(0x1f4, float:7.0E-43)
            if (r2 == r3) goto L_0x0092
            java.util.concurrent.atomic.AtomicInteger r2 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.incrementAndGet()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.Map<java.lang.String, java.lang.Object> r2 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r5 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = com.alibaba.pdns.o.a(r10, r3, r5, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            goto L_0x0107
        L_0x0092:
            java.util.concurrent.atomic.AtomicInteger r2 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.incrementAndGet()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.Map<java.lang.String, java.lang.Object> r2 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r5 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = com.alibaba.pdns.o.a(r10, r3, r5, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r0 = r11.f18063b     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            int r2 = r11.f18069h     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            goto L_0x0107
        L_0x00b6:
            java.util.concurrent.atomic.AtomicInteger r2 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.incrementAndGet()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.Map<java.lang.String, java.lang.Object> r2 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r5 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = com.alibaba.pdns.o.a(r10, r3, r5, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f17993c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r0 = r11.f18063b     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            int r2 = r11.f18069h     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r11.a(r0, r1, r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            goto L_0x0107
        L_0x00da:
            java.lang.String r0 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r2 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = "c"
            java.lang.String r0 = com.alibaba.pdns.o.a(r10, r0, r2, r3)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            float r2 = r1.c()     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.util.Map<java.lang.String, java.lang.Object> r3 = com.alibaba.pdns.f.I     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.Float r4 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.model.f r0 = r11.f18065d     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            com.alibaba.pdns.f.a((com.alibaba.pdns.model.f) r0, (float) r2)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r0 = r11.f18064c     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r2 = r11.f18067f     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            java.lang.String r3 = "ne"
            com.alibaba.pdns.f.b(r10, r0, r2, r3)     // Catch:{ Exception -> 0x003e, Error -> 0x003b }
            goto L_0x0107
        L_0x0100:
            boolean r2 = com.alibaba.pdns.u.a.f18279a
            if (r2 == 0) goto L_0x0107
            r0.printStackTrace()
        L_0x0107:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.HttpRequestAysnc.call():com.alibaba.pdns.model.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            int r7 = r7 + 1
            int r0 = r5.f18062a     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            if (r7 <= r0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r1 = "reLoad"
            r2 = 0
            if (r7 >= r0) goto L_0x0033
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            com.alibaba.pdns.model.f r0 = com.alibaba.pdns.f.c((java.lang.Object) r0)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            if (r0 == 0) goto L_0x005f
            java.lang.String r3 = r0.f18049e     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            boolean r4 = com.alibaba.pdns.e.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            if (r4 == 0) goto L_0x005f
            java.lang.String r6 = com.alibaba.pdns.o.b(r3, r2, r6)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            com.alibaba.pdns.u.a.b(r1, r6)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18065d = r0     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18063b = r6     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18069h = r7     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.call()     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            goto L_0x005f
        L_0x002f:
            r6 = move-exception
            goto L_0x0058
        L_0x0031:
            r6 = move-exception
            goto L_0x0058
        L_0x0033:
            if (r7 != r0) goto L_0x005f
            java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f> r0 = com.alibaba.pdns.f.M     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            com.alibaba.pdns.model.f r0 = com.alibaba.pdns.f.a((java.util.concurrent.CopyOnWriteArrayList<com.alibaba.pdns.model.f>) r0)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            if (r0 == 0) goto L_0x005f
            java.lang.String r3 = r0.f18049e     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            boolean r3 = com.alibaba.pdns.e.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            if (r3 == 0) goto L_0x005f
            java.lang.String r3 = r0.f18049e     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            java.lang.String r6 = com.alibaba.pdns.o.b(r3, r2, r6)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            com.alibaba.pdns.u.a.b(r1, r6)     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18065d = r0     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18063b = r6     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.f18069h = r7     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            r5.call()     // Catch:{ Exception -> 0x0031, Error -> 0x002f }
            goto L_0x005f
        L_0x0058:
            boolean r7 = com.alibaba.pdns.u.a.f18279a
            if (r7 == 0) goto L_0x005f
            r6.printStackTrace()
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.net.HttpRequestAysnc.a(java.lang.String, int):void");
    }
}
