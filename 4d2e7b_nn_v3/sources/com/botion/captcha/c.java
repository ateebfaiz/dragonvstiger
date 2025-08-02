package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.views.BOCWebView;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public d f18515a;

    /* renamed from: b  reason: collision with root package name */
    public BOCWebView f18516b;

    /* renamed from: c  reason: collision with root package name */
    public ai f18517c;

    /* renamed from: d  reason: collision with root package name */
    private BOCaptchaClient.OnDialogShowListener f18518d;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f18519a;

        a(d dVar) {
            this.f18519a = dVar;
        }

        public final void run() {
            this.f18519a.dismiss();
        }
    }

    public static final class b<T> implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18520a = new b();

        b() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            af afVar = af.f18475a;
            af.b("DialogController javascript:jsBridge.callback('showBox') return: ".concat(String.valueOf((String) obj)));
        }
    }

    /* renamed from: com.botion.captcha.c$c  reason: collision with other inner class name */
    public static final class C0241c implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f18521a;

        C0241c(w wVar) {
            this.f18521a = wVar;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 != 4 || keyEvent == null || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1) {
                return false;
            }
            this.f18521a.b();
            return false;
        }
    }

    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f18522a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f18523b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f18524c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ w f18525d;

        public d(c cVar, Context context, s sVar, w wVar) {
            this.f18522a = cVar;
            this.f18523b = context;
            this.f18524c = sVar;
            this.f18525d = wVar;
        }

        public final void run() {
            try {
                this.f18522a.b(this.f18523b, this.f18524c, this.f18525d);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public c() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0348 A[Catch:{ Exception -> 0x0339 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03e2 A[Catch:{ Exception -> 0x03e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x046f A[Catch:{ Exception -> 0x03e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x031c A[Catch:{ Exception -> 0x0339 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0341 A[Catch:{ Exception -> 0x0339 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r26, com.botion.captcha.s r27, com.botion.captcha.w r28) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            java.lang.String r6 = "observable"
            java.lang.String r7 = "url"
            java.lang.String r8 = "utf-8"
            java.lang.String r9 = "mi"
            java.lang.String r10 = "displayMode"
            java.lang.String r11 = "context"
            kotlin.jvm.internal.m.f(r2, r11)
            java.lang.String r12 = "dataBean"
            kotlin.jvm.internal.m.f(r3, r12)
            java.lang.String r0 = "webViewObserver"
            kotlin.jvm.internal.m.f(r4, r0)
            com.botion.captcha.v r13 = new com.botion.captcha.v
            r13.<init>()
            r13.a((com.botion.captcha.w) r4)
            com.botion.captcha.ad$b r0 = com.botion.captcha.ad.f18469a
            java.lang.String r0 = r3.f18561b
            com.botion.captcha.ad r0 = com.botion.captcha.ad.b.a(r0)
            java.lang.String r14 = "description"
            if (r0 != 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.botion.captcha.ab$a r2 = com.botion.captcha.ab.a.PARAM
            java.lang.String r2 = r2.getType()
            r0.append(r2)
            java.lang.String r2 = "75"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = com.botion.captcha.ac.c()
            com.botion.captcha.t$a r3 = com.botion.captcha.t.f18571a
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r5 = "Address configuration error"
            r3.put(r14, r5)
            kotlin.Unit r5 = kotlin.Unit.f12577a
            r4.a(r0, r2, r3)
            return
        L_0x0062:
            com.botion.captcha.ad$a r15 = r0.a()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            com.botion.captcha.y r0 = com.botion.captcha.y.CENTER
            java.lang.String r0 = r0.getValue()
            java.lang.String r4 = "displayArea"
            r5.put(r4, r0)
            java.lang.String r0 = "protocol"
            java.lang.String r4 = "https://"
            r5.put(r0, r4)
            java.lang.String r0 = "loading"
            java.lang.String r4 = "ns-loading.gif"
            r5.put(r0, r4)
            java.util.Map<java.lang.String, ? extends java.lang.Object> r0 = r3.f18566g
            com.botion.captcha.af r4 = com.botion.captcha.af.f18475a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r16 = r14
            java.lang.String r14 = "Config Params: "
            r4.<init>(r14)
            java.lang.String r14 = java.lang.String.valueOf(r0)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            com.botion.captcha.af.a((java.lang.String) r4)
            r4 = 0
            if (r0 == 0) goto L_0x011f
            boolean r14 = r0.isEmpty()
            if (r14 == 0) goto L_0x00aa
            goto L_0x011f
        L_0x00aa:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x00b2:
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x011d
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r17 = r14.getKey()
            r18 = r0
            r0 = r17
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r14 = r14.getValue()
            r17 = r4
            java.lang.String r4 = "xid"
            boolean r19 = kotlin.jvm.internal.m.b(r4, r0)
            if (r19 == 0) goto L_0x00ec
            com.botion.captcha.x r0 = com.botion.captcha.x.f18582a
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r14 == 0) goto L_0x00e6
            boolean r1 = r14 instanceof org.json.JSONObject
            if (r1 == 0) goto L_0x00e6
            r0.put(r4, r14)
        L_0x00e6:
            kotlin.Unit r1 = kotlin.Unit.f12577a
            com.botion.captcha.x.a(r0)
            goto L_0x0118
        L_0x00ec:
            java.lang.String r1 = "_gee_info"
            boolean r1 = kotlin.jvm.internal.m.b(r1, r0)
            if (r1 == 0) goto L_0x0115
            if (r14 == 0) goto L_0x0118
            boolean r0 = r14 instanceof org.json.JSONObject
            if (r0 == 0) goto L_0x0118
            r4 = r14
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r23 = "build"
            java.lang.String r24 = "clientVersion"
            java.lang.String r19 = "geeid"
            java.lang.String r20 = "packageName"
            java.lang.String r21 = "displayName"
            java.lang.String r22 = "appVer"
            java.lang.String[] r0 = new java.lang.String[]{r19, r20, r21, r22, r23, r24}
            a(r4, r0)
            r1 = r25
        L_0x0112:
            r0 = r18
            goto L_0x00b2
        L_0x0115:
            r5.put(r0, r14)
        L_0x0118:
            r1 = r25
            r4 = r17
            goto L_0x0112
        L_0x011d:
            r17 = r4
        L_0x011f:
            java.util.Map<java.lang.String, java.lang.String> r0 = r15.f18473b
            if (r0 == 0) goto L_0x0152
            java.util.Set r1 = r0.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x012b:
            boolean r14 = r1.hasNext()
            if (r14 == 0) goto L_0x014d
            java.lang.Object r14 = r1.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            java.lang.Object r17 = r14.getKey()
            r18 = r1
            r1 = r17
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r14 = r14.getValue()
            java.lang.String r14 = (java.lang.String) r14
            r5.put(r1, r14)
            r1 = r18
            goto L_0x012b
        L_0x014d:
            r0.clear()
            kotlin.Unit r0 = kotlin.Unit.f12577a
        L_0x0152:
            java.lang.String r0 = r3.f18560a
            java.lang.String r1 = "captchaId"
            if (r0 != 0) goto L_0x015b
            kotlin.jvm.internal.m.u(r1)
        L_0x015b:
            r5.put(r1, r0)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "challenge"
            r5.put(r1, r0)
            java.lang.String r0 = "debug"
            boolean r1 = r3.f18562c
            r5.put(r0, r1)
            java.lang.String r0 = r3.f18563d
            java.lang.String r1 = "language"
            if (r0 == 0) goto L_0x018a
            boolean r0 = kotlin.text.j.s(r0)
            if (r0 == 0) goto L_0x017f
            goto L_0x018a
        L_0x017f:
            java.lang.String r0 = r3.f18563d
            r5.put(r1, r0)
            r19 = r6
            r18 = r12
            goto L_0x020d
        L_0x018a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r14 = 24
            r18 = r12
            java.lang.String r12 = "context.applicationContext.resources"
            r19 = r6
            java.lang.String r6 = "context.applicationContext"
            if (r0 < r14) goto L_0x01be
            android.content.Context r0 = r26.getApplicationContext()
            kotlin.jvm.internal.m.e(r0, r6)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.m.e(r0, r12)
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.lang.String r6 = "context.applicationContext.resources.configuration"
            kotlin.jvm.internal.m.e(r0, r6)
            android.os.LocaleList r0 = r0.getLocales()
            r6 = 0
            java.util.Locale r0 = r0.get(r6)
            java.lang.String r6 = "context.applicationConte….configuration.locales[0]"
            kotlin.jvm.internal.m.e(r0, r6)
            goto L_0x01d7
        L_0x01be:
            android.content.Context r0 = r26.getApplicationContext()
            kotlin.jvm.internal.m.e(r0, r6)
            android.content.res.Resources r0 = r0.getResources()
            kotlin.jvm.internal.m.e(r0, r12)
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.util.Locale r0 = r0.locale
            java.lang.String r6 = "context.applicationConte…rces.configuration.locale"
            kotlin.jvm.internal.m.e(r0, r6)
        L_0x01d7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r0.getLanguage()
            r6.append(r12)
            r12 = 45
            r6.append(r12)
            java.lang.String r0 = r0.getCountry()
            java.lang.String r12 = "locale.country"
            kotlin.jvm.internal.m.e(r0, r12)
            java.util.Locale r12 = java.util.Locale.ROOT
            java.lang.String r14 = "Locale.ROOT"
            kotlin.jvm.internal.m.e(r12, r14)
            if (r0 == 0) goto L_0x04f6
            java.lang.String r0 = r0.toLowerCase(r12)
            java.lang.String r12 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.m.e(r0, r12)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r5.put(r1, r0)
        L_0x020d:
            java.lang.String[] r0 = r3.f18564e
            if (r0 == 0) goto L_0x0230
            int r0 = r0.length
            if (r0 != 0) goto L_0x0215
            goto L_0x0230
        L_0x0215:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.f18564e
            kotlin.jvm.internal.m.c(r1)
            int r6 = r1.length
            r12 = 0
        L_0x0221:
            if (r12 >= r6) goto L_0x022b
            r14 = r1[r12]
            r0.put(r14)
            r14 = 1
            int r12 = r12 + r14
            goto L_0x0221
        L_0x022b:
            java.lang.String r1 = "apiServers"
            r5.put(r1, r0)
        L_0x0230:
            java.lang.String[] r0 = r3.f18565f
            if (r0 == 0) goto L_0x0253
            int r0 = r0.length
            if (r0 != 0) goto L_0x0238
            goto L_0x0253
        L_0x0238:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.String[] r1 = r3.f18565f
            kotlin.jvm.internal.m.c(r1)
            int r6 = r1.length
            r12 = 0
        L_0x0244:
            if (r12 >= r6) goto L_0x024e
            r14 = r1[r12]
            r0.put(r14)
            r14 = 1
            int r12 = r12 + r14
            goto L_0x0244
        L_0x024e:
            java.lang.String r1 = "staticServers"
            r5.put(r1, r0)
        L_0x0253:
            java.lang.String r0 = "timeout"
            int r1 = r3.f18568i
            r5.put(r0, r1)
            java.lang.String r0 = "clientVersion"
            java.lang.String r1 = "1.0.3"
            r5.put(r0, r1)
            java.lang.String r6 = "clientType"
            java.lang.String r12 = "android"
            r5.put(r6, r12)
            java.lang.String r6 = "outside"
            boolean r12 = r3.f18567h
            r5.put(r6, r12)
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0310 }
            r6.<init>()     // Catch:{ Exception -> 0x0310 }
            java.lang.String r12 = "geeid"
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0310 }
            com.botion.captcha.f unused = com.botion.captcha.f.a.f18528a     // Catch:{ Exception -> 0x0310 }
            com.botion.captcha.g unused = com.botion.captcha.g.a.f18529a     // Catch:{ Exception -> 0x0310 }
            r20 = r13
            java.lang.String r13 = com.botion.captcha.g.a(r26)     // Catch:{ Exception -> 0x0301 }
            r14.<init>(r13)     // Catch:{ Exception -> 0x0301 }
            r6.put(r12, r14)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r12 = "packageName"
            java.lang.String r13 = r26.getPackageName()     // Catch:{ Exception -> 0x0301 }
            r6.put(r12, r13)     // Catch:{ Exception -> 0x0301 }
            android.content.pm.PackageManager r12 = r26.getPackageManager()     // Catch:{ Exception -> 0x0301 }
            java.lang.String r13 = r26.getPackageName()     // Catch:{ Exception -> 0x0301 }
            r14 = 0
            android.content.pm.ApplicationInfo r12 = r12.getApplicationInfo(r13, r14)     // Catch:{ Exception -> 0x0301 }
            android.content.pm.PackageManager r13 = r26.getPackageManager()     // Catch:{ Exception -> 0x0301 }
            java.lang.CharSequence r12 = r12.loadLabel(r13)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r13 = "context.packageManager.g…l(context.packageManager)"
            kotlin.jvm.internal.m.e(r12, r13)     // Catch:{ Exception -> 0x0301 }
            android.content.pm.PackageManager r13 = r26.getPackageManager()     // Catch:{ Exception -> 0x0301 }
            java.lang.String r14 = r26.getPackageName()     // Catch:{ Exception -> 0x0301 }
            r2 = 0
            android.content.pm.PackageInfo r13 = r13.getPackageInfo(r14, r2)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r2 = "displayName"
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0301 }
            java.lang.String r12 = java.net.URLEncoder.encode(r12, r8)     // Catch:{ Exception -> 0x0301 }
            r6.put(r2, r12)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r2 = "appVer"
            java.lang.String r12 = r13.versionName     // Catch:{ Exception -> 0x0301 }
            r6.put(r2, r12)     // Catch:{ Exception -> 0x0301 }
            java.lang.String r2 = "build"
            int r12 = r13.versionCode     // Catch:{ Exception -> 0x0301 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0301 }
            r6.put(r2, r12)     // Catch:{ Exception -> 0x0301 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0301 }
            if (r4 == 0) goto L_0x0303
            int r0 = r4.length()     // Catch:{ Exception -> 0x0301 }
            if (r0 <= 0) goto L_0x0303
            java.util.Iterator r0 = r4.keys()     // Catch:{ Exception -> 0x0301 }
            java.lang.String r1 = "keys"
            kotlin.jvm.internal.m.e(r0, r1)     // Catch:{ Exception -> 0x0301 }
        L_0x02ed:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0301 }
            if (r1 == 0) goto L_0x0303
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0301 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0301 }
            java.lang.Object r2 = r4.opt(r1)     // Catch:{ Exception -> 0x0301 }
            r6.put(r1, r2)     // Catch:{ Exception -> 0x0301 }
            goto L_0x02ed
        L_0x0301:
            r0 = move-exception
            goto L_0x0313
        L_0x0303:
            java.lang.String r0 = "zid"
            java.lang.String r1 = com.botion.captcha.ah.a(r26)     // Catch:{ Exception -> 0x0301 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0301 }
            r5.put(r9, r6)     // Catch:{ Exception -> 0x0301 }
            goto L_0x0316
        L_0x0310:
            r0 = move-exception
            r20 = r13
        L_0x0313:
            r0.printStackTrace()
        L_0x0316:
            boolean r0 = r5.has(r10)     // Catch:{ Exception -> 0x0339 }
            if (r0 == 0) goto L_0x033b
            java.lang.Object r0 = r5.get(r10)     // Catch:{ Exception -> 0x0339 }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0339 }
            if (r0 == 0) goto L_0x0352
            java.lang.Object r0 = r5.get(r10)     // Catch:{ Exception -> 0x0339 }
            com.botion.captcha.z r1 = com.botion.captcha.z.AUTO     // Catch:{ Exception -> 0x0339 }
            int r1 = r1.getValue()     // Catch:{ Exception -> 0x0339 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0339 }
            boolean r0 = kotlin.jvm.internal.m.b(r0, r1)     // Catch:{ Exception -> 0x0339 }
            if (r0 == 0) goto L_0x0352
            goto L_0x033b
        L_0x0339:
            r0 = move-exception
            goto L_0x034f
        L_0x033b:
            boolean r0 = com.botion.captcha.aa.c(r26)     // Catch:{ Exception -> 0x0339 }
            if (r0 == 0) goto L_0x0348
            com.botion.captcha.z r0 = com.botion.captcha.z.DARK     // Catch:{ Exception -> 0x0339 }
        L_0x0343:
            int r0 = r0.getValue()     // Catch:{ Exception -> 0x0339 }
            goto L_0x034b
        L_0x0348:
            com.botion.captcha.z r0 = com.botion.captcha.z.NORMAL     // Catch:{ Exception -> 0x0339 }
            goto L_0x0343
        L_0x034b:
            r5.put(r10, r0)     // Catch:{ Exception -> 0x0339 }
            goto L_0x0352
        L_0x034f:
            r0.printStackTrace()
        L_0x0352:
            com.botion.captcha.af r0 = com.botion.captcha.af.f18475a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "BaseURL: "
            r0.<init>(r1)
            java.lang.String r2 = r3.f18561b
            r0.append(r2)
            java.lang.String r2 = ", Parameter: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.botion.captcha.af.a((java.lang.String) r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r4 = r5.toString()
            r0.<init>(r4)
            boolean r4 = r0.has(r9)
            if (r4 == 0) goto L_0x0381
            r0.remove(r9)
        L_0x0381:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = r3.f18561b
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.botion.captcha.af.b(r0)
            java.lang.String r0 = r5.toString()
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r8)
            java.lang.String r1 = "name"
            java.lang.String r2 = "data"
            kotlin.jvm.internal.m.f(r2, r1)
            java.util.Map<java.lang.String, java.lang.String> r1 = r15.f18473b
            if (r1 == 0) goto L_0x03ae
            r1.put(r2, r0)
        L_0x03ae:
            com.botion.captcha.ai$a r0 = new com.botion.captcha.ai$a     // Catch:{ Exception -> 0x03e6 }
            r0.<init>()     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.ad r1 = new com.botion.captcha.ad     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = r15.f18472a     // Catch:{ Exception -> 0x03e6 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r15.f18473b     // Catch:{ Exception -> 0x03e6 }
            r5 = 0
            r1.<init>(r2, r4, r5)     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03e6 }
            kotlin.jvm.internal.m.f(r1, r7)     // Catch:{ Exception -> 0x03e6 }
            r0.f18497a = r1     // Catch:{ Exception -> 0x03e6 }
            r1 = r26
            kotlin.jvm.internal.m.f(r1, r11)     // Catch:{ Exception -> 0x03e6 }
            r2 = r19
            r4 = r20
            kotlin.jvm.internal.m.f(r4, r2)     // Catch:{ Exception -> 0x03e6 }
            r5 = r18
            kotlin.jvm.internal.m.f(r3, r5)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r6 = new com.botion.captcha.views.BOCWebView     // Catch:{ Exception -> 0x03e6 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x03e6 }
            r0.f18499c = r6     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r1 = r0.f18497a     // Catch:{ Exception -> 0x03e6 }
            if (r1 != 0) goto L_0x03eb
            kotlin.jvm.internal.m.u(r7)     // Catch:{ Exception -> 0x03e6 }
            goto L_0x03eb
        L_0x03e6:
            r0 = move-exception
            r2 = r25
            goto L_0x04b3
        L_0x03eb:
            kotlin.jvm.internal.m.f(r4, r2)     // Catch:{ Exception -> 0x03e6 }
            kotlin.jvm.internal.m.f(r3, r5)     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = "loadUrl"
            kotlin.jvm.internal.m.f(r1, r2)     // Catch:{ Exception -> 0x03e6 }
            android.webkit.WebSettings r2 = r6.getSettings()     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r5 = "settings"
            kotlin.jvm.internal.m.e(r2, r5)     // Catch:{ Exception -> 0x03e6 }
            r5 = 1
            r2.setDomStorageEnabled(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setJavaScriptEnabled(r5)     // Catch:{ Exception -> 0x03e6 }
            r7 = 0
            r2.setBlockNetworkImage(r7)     // Catch:{ Exception -> 0x03e6 }
            r2.setJavaScriptCanOpenWindowsAutomatically(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setLoadsImagesAutomatically(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setLoadWithOverviewMode(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setUseWideViewPort(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setAppCacheEnabled(r5)     // Catch:{ Exception -> 0x03e6 }
            r7 = 2
            r2.setCacheMode(r7)     // Catch:{ Exception -> 0x03e6 }
            r2.setSupportZoom(r5)     // Catch:{ Exception -> 0x03e6 }
            r5 = 100
            r2.setTextZoom(r5)     // Catch:{ Exception -> 0x03e6 }
            r5 = 0
            r2.setAllowFileAccess(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setSavePassword(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setGeolocationEnabled(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setAllowContentAccess(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setAllowFileAccessFromFileURLs(r5)     // Catch:{ Exception -> 0x03e6 }
            r2.setAllowUniversalAccessFromFileURLs(r5)     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = "searchBoxJavaBridge_"
            r6.removeJavascriptInterface(r2)     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = "accessibility"
            r6.removeJavascriptInterface(r2)     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = "accessibilityTraversal"
            r6.removeJavascriptInterface(r2)     // Catch:{ Exception -> 0x03e6 }
            r6.setOverScrollMode(r7)     // Catch:{ Exception -> 0x03e6 }
            r2 = 0
            r6.setScrollContainer(r2)     // Catch:{ Exception -> 0x03e6 }
            r6.setHorizontalScrollBarEnabled(r2)     // Catch:{ Exception -> 0x03e6 }
            r6.setVerticalScrollBarEnabled(r2)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView$b r2 = new com.botion.captcha.views.BOCWebView$b     // Catch:{ Exception -> 0x03e6 }
            r2.<init>()     // Catch:{ Exception -> 0x03e6 }
            r6.setWebChromeClient(r2)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView$c r2 = new com.botion.captcha.views.BOCWebView$c     // Catch:{ Exception -> 0x03e6 }
            r2.<init>(r1, r4)     // Catch:{ Exception -> 0x03e6 }
            r6.f18579a = r2     // Catch:{ Exception -> 0x03e6 }
            r6.setWebViewClient(r2)     // Catch:{ Exception -> 0x03e6 }
            int r1 = r3.f18569j     // Catch:{ Exception -> 0x03e6 }
            r6.setBackgroundColor(r1)     // Catch:{ Exception -> 0x03e6 }
            boolean r1 = r3.f18562c     // Catch:{ Exception -> 0x03e6 }
            if (r1 == 0) goto L_0x0473
            r1 = 1
            android.webkit.WebView.setWebContentsDebuggingEnabled(r1)     // Catch:{ Exception -> 0x03e6 }
        L_0x0473:
            r6.onResume()     // Catch:{ Exception -> 0x03e6 }
            r0.f18498b = r4     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.ai r1 = new com.botion.captcha.ai     // Catch:{ Exception -> 0x03e6 }
            r2 = 0
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.ai$b r0 = new com.botion.captcha.ai$b     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = r1.f18493a     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r3 = r1.f18495c     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.v r4 = r1.f18494b     // Catch:{ Exception -> 0x03e6 }
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x03e6 }
            r1.f18496d = r0     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r2 = r1.f18495c     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r3 = "JSInterface"
            r2.addJavascriptInterface(r0, r3)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r0 = r1.f18495c     // Catch:{ Exception -> 0x03e6 }
            r0.buildLayer()     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r0 = r1.f18495c     // Catch:{ Exception -> 0x03e6 }
            java.lang.String r2 = r1.f18493a     // Catch:{ Exception -> 0x03e6 }
            r0.loadUrl(r2)     // Catch:{ Exception -> 0x03e6 }
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x03e6 }
            r2 = -1
            r0.<init>(r2, r2)     // Catch:{ Exception -> 0x03e6 }
            com.botion.captcha.views.BOCWebView r2 = r1.f18495c     // Catch:{ Exception -> 0x03e6 }
            r2.setLayoutParams(r0)     // Catch:{ Exception -> 0x03e6 }
            r2 = r25
            r2.f18517c = r1     // Catch:{ Exception -> 0x04b2 }
            com.botion.captcha.views.BOCWebView r0 = r1.f18495c     // Catch:{ Exception -> 0x04b2 }
            r2.f18516b = r0     // Catch:{ Exception -> 0x04b2 }
            return
        L_0x04b2:
            r0 = move-exception
        L_0x04b3:
            r0.printStackTrace()
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x04f5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.botion.captcha.ab$a r3 = com.botion.captcha.ab.a.WEB_VIEW_NEW
            java.lang.String r3 = r3.getType()
            r1.append(r3)
            java.lang.String r3 = "99"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = com.botion.captcha.ac.e()
            com.botion.captcha.t$a r4 = com.botion.captcha.t.f18571a
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "Device not supported"
            r6 = r16
            r4.put(r6, r5)
            java.lang.String r5 = "exception"
            java.lang.String r0 = r0.getMessage()
            r4.put(r5, r0)
            kotlin.Unit r0 = kotlin.Unit.f12577a
            r5 = r28
            r5.a(r1, r3, r4)
        L_0x04f5:
            return
        L_0x04f6:
            r2 = r25
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.botion.captcha.c.a(android.content.Context, com.botion.captcha.s, com.botion.captcha.w):void");
    }

    public final void b(Context context, s sVar, w wVar) {
        d dVar;
        if (TextUtils.isEmpty(sVar.f18570k)) {
            dVar = new d(context);
        } else {
            String str = sVar.f18570k;
            if (str != null) {
                dVar = new d(context, str);
            } else {
                dVar = null;
            }
        }
        this.f18515a = dVar;
        if (dVar != null) {
            dVar.f18527b = this.f18518d;
        }
        if (dVar != null) {
            dVar.f18526a = this.f18516b;
        }
        if (dVar != null) {
            dVar.setOnKeyListener(new C0241c(wVar));
        }
        d dVar2 = this.f18515a;
        if (dVar2 != null) {
            dVar2.show();
        }
    }

    public c(BOCaptchaClient.OnDialogShowListener onDialogShowListener) {
        this.f18518d = onDialogShowListener;
    }

    public final void a() {
        d dVar = this.f18515a;
        if (dVar != null && dVar.isShowing()) {
            BOCWebView bOCWebView = this.f18516b;
            Context context = bOCWebView != null ? bOCWebView.getContext() : null;
            if (context != null) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    if (!m.b(Looper.getMainLooper(), Looper.myLooper())) {
                        activity.runOnUiThread(new a(dVar));
                    } else {
                        dVar.dismiss();
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
        }
    }

    private static void a(JSONObject jSONObject, String... strArr) {
        for (int i10 = 0; i10 < 6; i10++) {
            String str = strArr[i10];
            if (jSONObject.has(str)) {
                jSONObject.remove(str);
            }
        }
    }
}
