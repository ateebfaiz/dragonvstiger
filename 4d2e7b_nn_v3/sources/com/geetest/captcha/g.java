package com.geetest.captcha;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.views.GTC4WebView;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public h f5802a;

    /* renamed from: b  reason: collision with root package name */
    public GTC4WebView f5803b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f5804c;

    /* renamed from: d  reason: collision with root package name */
    public GTCaptcha4Client.OnDialogShowListener f5805d;

    public g(GTCaptcha4Client.OnDialogShowListener onDialogShowListener) {
        this.f5805d = onDialogShowListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0329 A[Catch:{ Exception -> 0x0346 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0360 A[Catch:{ Exception -> 0x0346 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0363 A[Catch:{ Exception -> 0x0346 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0401 A[Catch:{ Exception -> 0x0405 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r25, com.geetest.captcha.v r26, com.geetest.captcha.z r27) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            java.lang.String r5 = "url"
            java.lang.String r6 = "utf-8"
            java.lang.String r7 = "mi"
            java.lang.String r8 = "displayMode"
            java.lang.String r9 = "context"
            kotlin.jvm.internal.m.f(r2, r9)
            java.lang.String r10 = "dataBean"
            kotlin.jvm.internal.m.f(r3, r10)
            java.lang.String r0 = "webViewObserver"
            kotlin.jvm.internal.m.f(r4, r0)
            com.geetest.captcha.y r11 = new com.geetest.captcha.y
            r11.<init>()
            r11.a(r4)
            com.geetest.captcha.f0$a r0 = com.geetest.captcha.f0.f5799c
            java.lang.String r12 = r3.f5865b
            com.geetest.captcha.f0 r0 = r0.a(r12)
            java.lang.String r12 = "description"
            if (r0 != 0) goto L_0x005e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.geetest.captcha.d0 r2 = com.geetest.captcha.d0.PARAM
            java.lang.String r2 = r2.getType()
            r0.append(r2)
            java.lang.String r2 = "75"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = com.geetest.captcha.e0.f5791c
            com.geetest.captcha.w$a r3 = com.geetest.captcha.w.f5877d
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r5 = "Address configuration error"
            r3.put(r12, r5)
            kotlin.Unit r5 = kotlin.Unit.f12577a
            r4.a(r0, r2, r3)
            return
        L_0x005e:
            java.lang.String r13 = r0.f5800a
            java.util.Map<java.lang.String, java.lang.String> r14 = r0.f5801b
            java.lang.String r0 = "baseUrl"
            kotlin.jvm.internal.m.f(r13, r0)
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            com.geetest.captcha.b0 r0 = com.geetest.captcha.b0.CENTER
            java.lang.String r0 = r0.getValue()
            java.lang.String r4 = "displayArea"
            r15.put(r4, r0)
            java.lang.String r0 = "protocol"
            java.lang.String r4 = "https://"
            r15.put(r0, r4)
            java.lang.String r0 = "loading"
            java.lang.String r4 = "./gt4-loading.gif"
            r15.put(r0, r4)
            java.util.Map<java.lang.String, ? extends java.lang.Object> r0 = r3.f5870g
            com.geetest.captcha.h0 r4 = com.geetest.captcha.h0.f5812d
            r16 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "Config Params: "
            r12.append(r1)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r4.a(r1)
            r4 = 0
            if (r0 == 0) goto L_0x012f
            boolean r12 = r0.isEmpty()
            if (r12 == 0) goto L_0x00ae
            goto L_0x012f
        L_0x00ae:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00b6:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x012d
            java.lang.Object r12 = r0.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r17 = r12.getKey()
            r1 = r17
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r12 = r12.getValue()
            r17 = r0
            java.lang.String r0 = "xid"
            boolean r18 = kotlin.jvm.internal.m.b(r0, r1)
            if (r18 == 0) goto L_0x00ed
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r18 = r4
            if (r12 == 0) goto L_0x00e8
            boolean r4 = r12 instanceof org.json.JSONObject
            if (r4 == 0) goto L_0x00e8
            r1.put(r0, r12)
        L_0x00e8:
            kotlin.Unit r0 = kotlin.Unit.f12577a
            com.geetest.captcha.a0.f5772a = r1
            goto L_0x0128
        L_0x00ed:
            r18 = r4
            java.lang.String r0 = "_gee_info"
            boolean r0 = kotlin.jvm.internal.m.b(r0, r1)
            if (r0 == 0) goto L_0x0125
            if (r12 == 0) goto L_0x0128
            boolean r0 = r12 instanceof org.json.JSONObject
            if (r0 == 0) goto L_0x0128
            r4 = r12
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r22 = "build"
            java.lang.String r23 = "clientVersion"
            java.lang.String r18 = "geeid"
            java.lang.String r19 = "packageName"
            java.lang.String r20 = "displayName"
            java.lang.String r21 = "appVer"
            java.lang.String[] r0 = new java.lang.String[]{r18, r19, r20, r21, r22, r23}
            r1 = 0
        L_0x0111:
            r12 = 6
            if (r1 >= r12) goto L_0x0122
            r12 = r0[r1]
            boolean r18 = r4.has(r12)
            if (r18 == 0) goto L_0x011f
            r4.remove(r12)
        L_0x011f:
            int r1 = r1 + 1
            goto L_0x0111
        L_0x0122:
            r0 = r17
            goto L_0x00b6
        L_0x0125:
            r15.put(r1, r12)
        L_0x0128:
            r0 = r17
            r4 = r18
            goto L_0x00b6
        L_0x012d:
            r18 = r4
        L_0x012f:
            if (r14 == 0) goto L_0x015a
            java.util.Set r0 = r14.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0139:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0155
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r15.put(r12, r1)
            goto L_0x0139
        L_0x0155:
            r14.clear()
            kotlin.Unit r0 = kotlin.Unit.f12577a
        L_0x015a:
            java.lang.String r0 = r3.f5864a
            java.lang.String r1 = "captchaId"
            if (r0 != 0) goto L_0x0163
            kotlin.jvm.internal.m.u(r1)
        L_0x0163:
            r15.put(r1, r0)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "challenge"
            r15.put(r1, r0)
            boolean r0 = r3.f5866c
            java.lang.String r1 = "debug"
            r15.put(r1, r0)
            java.lang.String r0 = r3.f5867d
            java.lang.String r1 = "language"
            if (r0 == 0) goto L_0x0192
            boolean r0 = kotlin.text.j.s(r0)
            if (r0 == 0) goto L_0x0187
            goto L_0x0192
        L_0x0187:
            java.lang.String r0 = r3.f5867d
            r15.put(r1, r0)
            r17 = r10
            r18 = r11
            goto L_0x0215
        L_0x0192:
            int r0 = android.os.Build.VERSION.SDK_INT
            r12 = 24
            r17 = r10
            java.lang.String r10 = "context.applicationContext.resources"
            r18 = r11
            java.lang.String r11 = "context.applicationContext"
            if (r0 < r12) goto L_0x01c6
            android.content.Context r0 = r25.getApplicationContext()
            kotlin.jvm.internal.m.e(r0, r11)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.m.e(r0, r10)
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.lang.String r10 = "context.applicationContext.resources.configuration"
            kotlin.jvm.internal.m.e(r0, r10)
            android.os.LocaleList r0 = r0.getLocales()
            r10 = 0
            java.util.Locale r0 = r0.get(r10)
            java.lang.String r10 = "context.applicationConte….configuration.locales[0]"
            kotlin.jvm.internal.m.e(r0, r10)
            goto L_0x01df
        L_0x01c6:
            android.content.Context r0 = r25.getApplicationContext()
            kotlin.jvm.internal.m.e(r0, r11)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.m.e(r0, r10)
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.util.Locale r0 = r0.locale
            java.lang.String r10 = "context.applicationConte…rces.configuration.locale"
            kotlin.jvm.internal.m.e(r0, r10)
        L_0x01df:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r0.getLanguage()
            r10.append(r11)
            r11 = 45
            r10.append(r11)
            java.lang.String r0 = r0.getCountry()
            java.lang.String r11 = "locale.country"
            kotlin.jvm.internal.m.e(r0, r11)
            java.util.Locale r11 = java.util.Locale.ROOT
            java.lang.String r12 = "Locale.ROOT"
            kotlin.jvm.internal.m.e(r11, r12)
            if (r0 == 0) goto L_0x0462
            java.lang.String r0 = r0.toLowerCase(r11)
            java.lang.String r11 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.m.e(r0, r11)
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r15.put(r1, r0)
        L_0x0215:
            java.lang.String[] r0 = r3.f5868e
            if (r0 == 0) goto L_0x0238
            int r0 = r0.length
            if (r0 != 0) goto L_0x021d
            goto L_0x0238
        L_0x021d:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.f5868e
            kotlin.jvm.internal.m.c(r1)
            int r10 = r1.length
            r11 = 0
        L_0x0229:
            if (r11 >= r10) goto L_0x0233
            r12 = r1[r11]
            r0.put(r12)
            int r11 = r11 + 1
            goto L_0x0229
        L_0x0233:
            java.lang.String r1 = "apiServers"
            r15.put(r1, r0)
        L_0x0238:
            java.lang.String[] r0 = r3.f5869f
            if (r0 == 0) goto L_0x025b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0240
            goto L_0x025b
        L_0x0240:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.f5869f
            kotlin.jvm.internal.m.c(r1)
            int r10 = r1.length
            r11 = 0
        L_0x024c:
            if (r11 >= r10) goto L_0x0256
            r12 = r1[r11]
            r0.put(r12)
            int r11 = r11 + 1
            goto L_0x024c
        L_0x0256:
            java.lang.String r1 = "staticServers"
            r15.put(r1, r0)
        L_0x025b:
            int r0 = r3.f5872i
            java.lang.String r1 = "timeout"
            r15.put(r1, r0)
            java.lang.String r0 = "clientVersion"
            java.lang.String r1 = "1.8.3.1"
            r15.put(r0, r1)
            java.lang.String r10 = "clientType"
            java.lang.String r11 = "android"
            r15.put(r10, r11)
            boolean r10 = r3.f5871h
            java.lang.String r11 = "outside"
            r15.put(r11, r10)
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x031c }
            r10.<init>()     // Catch:{ Exception -> 0x031c }
            java.lang.String r11 = "geeid"
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x031c }
            r19 = r5
            com.geetest.captcha.j r5 = com.geetest.captcha.j.a.f5823a     // Catch:{ Exception -> 0x0318 }
            java.lang.String r5 = r5.a(r2)     // Catch:{ Exception -> 0x0318 }
            r12.<init>(r5)     // Catch:{ Exception -> 0x0318 }
            r10.put(r11, r12)     // Catch:{ Exception -> 0x0318 }
            java.lang.String r5 = "packageName"
            java.lang.String r11 = r25.getPackageName()     // Catch:{ Exception -> 0x0318 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x0318 }
            android.content.pm.PackageManager r5 = r25.getPackageManager()     // Catch:{ Exception -> 0x0318 }
            java.lang.String r11 = r25.getPackageName()     // Catch:{ Exception -> 0x0318 }
            r12 = 0
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r11, r12)     // Catch:{ Exception -> 0x0318 }
            android.content.pm.PackageManager r11 = r25.getPackageManager()     // Catch:{ Exception -> 0x0318 }
            java.lang.CharSequence r5 = r5.loadLabel(r11)     // Catch:{ Exception -> 0x0318 }
            java.lang.String r11 = "context.packageManager.g…l(context.packageManager)"
            kotlin.jvm.internal.m.e(r5, r11)     // Catch:{ Exception -> 0x0318 }
            android.content.pm.PackageManager r11 = r25.getPackageManager()     // Catch:{ Exception -> 0x0318 }
            java.lang.String r12 = r25.getPackageName()     // Catch:{ Exception -> 0x0318 }
            r20 = r13
            r13 = 0
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r12, r13)     // Catch:{ Exception -> 0x0307 }
            java.lang.String r12 = "displayName"
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0307 }
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r6)     // Catch:{ Exception -> 0x0307 }
            r10.put(r12, r5)     // Catch:{ Exception -> 0x0307 }
            java.lang.String r5 = "appVer"
            java.lang.String r12 = r11.versionName     // Catch:{ Exception -> 0x0307 }
            r10.put(r5, r12)     // Catch:{ Exception -> 0x0307 }
            java.lang.String r5 = "build"
            int r11 = r11.versionCode     // Catch:{ Exception -> 0x0307 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0307 }
            r10.put(r5, r11)     // Catch:{ Exception -> 0x0307 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x0307 }
            if (r4 == 0) goto L_0x0309
            int r0 = r4.length()     // Catch:{ Exception -> 0x0307 }
            if (r0 <= 0) goto L_0x0309
            java.util.Iterator r0 = r4.keys()     // Catch:{ Exception -> 0x0307 }
            java.lang.String r1 = "keys"
            kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ Exception -> 0x0307 }
        L_0x02f3:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0307 }
            if (r1 == 0) goto L_0x0309
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0307 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0307 }
            java.lang.Object r5 = r4.opt(r1)     // Catch:{ Exception -> 0x0307 }
            r10.put(r1, r5)     // Catch:{ Exception -> 0x0307 }
            goto L_0x02f3
        L_0x0307:
            r0 = move-exception
            goto L_0x0320
        L_0x0309:
            java.lang.String r0 = "zid"
            com.geetest.captcha.k0 r1 = com.geetest.captcha.k0.f5826a     // Catch:{ Exception -> 0x0307 }
            java.lang.String r1 = r1.a(r2)     // Catch:{ Exception -> 0x0307 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x0307 }
            r15.put(r7, r10)     // Catch:{ Exception -> 0x0307 }
            goto L_0x0323
        L_0x0318:
            r0 = move-exception
        L_0x0319:
            r20 = r13
            goto L_0x0320
        L_0x031c:
            r0 = move-exception
            r19 = r5
            goto L_0x0319
        L_0x0320:
            r0.printStackTrace()
        L_0x0323:
            boolean r0 = r15.has(r8)     // Catch:{ Exception -> 0x0346 }
            if (r0 == 0) goto L_0x0348
            java.lang.Object r0 = r15.get(r8)     // Catch:{ Exception -> 0x0346 }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0346 }
            if (r0 == 0) goto L_0x0370
            java.lang.Object r0 = r15.get(r8)     // Catch:{ Exception -> 0x0346 }
            com.geetest.captcha.c0 r1 = com.geetest.captcha.c0.AUTO     // Catch:{ Exception -> 0x0346 }
            int r1 = r1.getValue()     // Catch:{ Exception -> 0x0346 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0346 }
            boolean r0 = kotlin.jvm.internal.m.b(r0, r1)     // Catch:{ Exception -> 0x0346 }
            if (r0 == 0) goto L_0x0370
            goto L_0x0348
        L_0x0346:
            r0 = move-exception
            goto L_0x036d
        L_0x0348:
            kotlin.jvm.internal.m.f(r2, r9)     // Catch:{ Exception -> 0x0346 }
            android.content.res.Resources r0 = r25.getResources()     // Catch:{ Exception -> 0x0346 }
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ Exception -> 0x0346 }
            android.content.res.Configuration r0 = r0.getConfiguration()     // Catch:{ Exception -> 0x0346 }
            int r0 = r0.uiMode     // Catch:{ Exception -> 0x0346 }
            r0 = r0 & 48
            r1 = 32
            if (r0 != r1) goto L_0x0363
            com.geetest.captcha.c0 r0 = com.geetest.captcha.c0.DARK     // Catch:{ Exception -> 0x0346 }
            goto L_0x0365
        L_0x0363:
            com.geetest.captcha.c0 r0 = com.geetest.captcha.c0.NORMAL     // Catch:{ Exception -> 0x0346 }
        L_0x0365:
            int r0 = r0.getValue()     // Catch:{ Exception -> 0x0346 }
            r15.put(r8, r0)     // Catch:{ Exception -> 0x0346 }
            goto L_0x0370
        L_0x036d:
            r0.printStackTrace()
        L_0x0370:
            com.geetest.captcha.h0 r0 = com.geetest.captcha.h0.f5812d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "BaseURL: "
            r1.append(r4)
            java.lang.String r5 = r3.f5865b
            r1.append(r5)
            java.lang.String r5 = ", Parameter: "
            r1.append(r5)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.a(r1)
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r8 = r15.toString()
            r1.<init>(r8)
            boolean r8 = r1.has(r7)
            if (r8 == 0) goto L_0x03a2
            r1.remove(r7)
        L_0x03a2:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = r3.f5865b
            r7.append(r4)
            r7.append(r5)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            r0.c(r1)
            java.lang.String r0 = r15.toString()
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r6)
            java.lang.String r1 = "name"
            java.lang.String r4 = "data"
            kotlin.jvm.internal.m.f(r4, r1)
            if (r14 == 0) goto L_0x03d0
            r14.put(r4, r0)
        L_0x03d0:
            com.geetest.captcha.l0$a r0 = new com.geetest.captcha.l0$a     // Catch:{ Exception -> 0x0405 }
            r0.<init>()     // Catch:{ Exception -> 0x0405 }
            com.geetest.captcha.f0 r1 = new com.geetest.captcha.f0     // Catch:{ Exception -> 0x0405 }
            r4 = r20
            r1.<init>(r4, r14)     // Catch:{ Exception -> 0x0405 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0405 }
            r4 = r19
            kotlin.jvm.internal.m.f(r1, r4)     // Catch:{ Exception -> 0x0405 }
            r0.f5833a = r1     // Catch:{ Exception -> 0x0405 }
            kotlin.jvm.internal.m.f(r2, r9)     // Catch:{ Exception -> 0x0405 }
            java.lang.String r1 = "observable"
            r5 = r18
            kotlin.jvm.internal.m.f(r5, r1)     // Catch:{ Exception -> 0x0405 }
            r1 = r17
            kotlin.jvm.internal.m.f(r3, r1)     // Catch:{ Exception -> 0x0405 }
            com.geetest.captcha.views.GTC4WebView r1 = new com.geetest.captcha.views.GTC4WebView     // Catch:{ Exception -> 0x0405 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0405 }
            r0.f5835c = r1     // Catch:{ Exception -> 0x0405 }
            java.lang.String r2 = r0.f5833a     // Catch:{ Exception -> 0x0405 }
            if (r2 != 0) goto L_0x0409
            kotlin.jvm.internal.m.u(r4)     // Catch:{ Exception -> 0x0405 }
            goto L_0x0409
        L_0x0405:
            r0 = move-exception
            r1 = r24
            goto L_0x0421
        L_0x0409:
            r1.a(r5, r3, r2)     // Catch:{ Exception -> 0x0405 }
            r0.f5834b = r5     // Catch:{ Exception -> 0x0405 }
            com.geetest.captcha.l0 r1 = new com.geetest.captcha.l0     // Catch:{ Exception -> 0x0405 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0405 }
            com.geetest.captcha.l0 r0 = r1.a()     // Catch:{ Exception -> 0x0405 }
            r1 = r24
            r1.f5804c = r0     // Catch:{ Exception -> 0x0420 }
            com.geetest.captcha.views.GTC4WebView r0 = r0.f5831c     // Catch:{ Exception -> 0x0420 }
            r1.f5803b = r0     // Catch:{ Exception -> 0x0420 }
            goto L_0x0461
        L_0x0420:
            r0 = move-exception
        L_0x0421:
            r0.printStackTrace()
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x0461
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.geetest.captcha.d0 r3 = com.geetest.captcha.d0.WEB_VIEW_NEW
            java.lang.String r3 = r3.getType()
            r2.append(r3)
            java.lang.String r3 = "99"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = com.geetest.captcha.e0.f5793e
            com.geetest.captcha.w$a r4 = com.geetest.captcha.w.f5877d
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "Device not supported"
            r6 = r16
            r4.put(r6, r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r5 = "exception"
            r4.put(r5, r0)
            kotlin.Unit r0 = kotlin.Unit.f12577a
            r5 = r27
            r5.a(r2, r3, r4)
        L_0x0461:
            return
        L_0x0462:
            r1 = r24
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.g.a(android.content.Context, com.geetest.captcha.v, com.geetest.captcha.z):void");
    }

    public final void b(Context context, v vVar, z zVar) {
        h hVar;
        if (TextUtils.isEmpty(vVar.f5874k)) {
            hVar = new h(context);
        } else {
            String str = vVar.f5874k;
            if (str != null) {
                hVar = new h(context, str);
            } else {
                hVar = null;
            }
        }
        this.f5802a = hVar;
        if (hVar != null) {
            hVar.f5808b = this.f5805d;
        }
        if (hVar != null) {
            hVar.f5807a = this.f5803b;
        }
        if (hVar != null) {
            hVar.setOnKeyListener(new e(zVar));
        }
        h hVar2 = this.f5802a;
        if (hVar2 != null) {
            hVar2.show();
        }
    }
}
