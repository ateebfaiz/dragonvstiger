package com.onesignal;

import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

abstract class b4 {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10400a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f10401b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f10402c;

        a(String str, JSONObject jSONObject, g gVar) {
            this.f10400a = str;
            this.f10401b = jSONObject;
            this.f10402c = gVar;
        }

        public void run() {
            b4.h(this.f10400a, "PUT", this.f10401b, this.f10402c, 120000, (String) null);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10403a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f10404b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f10405c;

        b(String str, JSONObject jSONObject, g gVar) {
            this.f10403a = str;
            this.f10404b = jSONObject;
            this.f10405c = gVar;
        }

        public void run() {
            b4.h(this.f10403a, "POST", this.f10404b, this.f10405c, 120000, (String) null);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f10407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10408c;

        c(String str, g gVar, String str2) {
            this.f10406a = str;
            this.f10407b = gVar;
            this.f10408c = str2;
        }

        public void run() {
            b4.h(this.f10406a, (String) null, (JSONObject) null, this.f10407b, 60000, this.f10408c);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Thread[] f10409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10410b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10411c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f10412d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f10413e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f10414f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f10415g;

        d(Thread[] threadArr, String str, String str2, JSONObject jSONObject, g gVar, int i10, String str3) {
            this.f10409a = threadArr;
            this.f10410b = str;
            this.f10411c = str2;
            this.f10412d = jSONObject;
            this.f10413e = gVar;
            this.f10414f = i10;
            this.f10415g = str3;
        }

        public void run() {
            this.f10409a[0] = b4.n(this.f10410b, this.f10411c, this.f10412d, this.f10413e, this.f10414f, this.f10415g);
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f10416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10417b;

        e(g gVar, String str) {
            this.f10416a = gVar;
            this.f10417b = str;
        }

        public void run() {
            this.f10416a.b(this.f10417b);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f10418a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10419b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10420c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Throwable f10421d;

        f(g gVar, int i10, String str, Throwable th) {
            this.f10418a = gVar;
            this.f10419b = i10;
            this.f10420c = str;
            this.f10421d = th;
        }

        public void run() {
            this.f10418a.a(this.f10419b, this.f10420c, this.f10421d);
        }
    }

    static abstract class g {
        g() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i10, String str, Throwable th) {
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
        }
    }

    private static Thread c(g gVar, int i10, String str, Throwable th) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new f(gVar, i10, str, th), "OS_REST_FAILURE_CALLBACK");
        OSUtils.W(thread);
        return thread;
    }

    private static Thread d(g gVar, String str) {
        if (gVar == null) {
            return null;
        }
        Thread thread = new Thread(new e(gVar, str), "OS_REST_SUCCESS_CALLBACK");
        OSUtils.W(thread);
        return thread;
    }

    public static void e(String str, g gVar, String str2) {
        OSUtils.W(new Thread(new c(str, gVar, str2), "OS_REST_ASYNC_GET"));
    }

    public static void f(String str, g gVar, String str2) {
        h(str, (String) null, (JSONObject) null, gVar, 60000, str2);
    }

    private static int g(int i10) {
        return i10 + 5000;
    }

    /* access modifiers changed from: private */
    public static void h(String str, String str2, JSONObject jSONObject, g gVar, int i10, String str3) {
        String str4 = str2;
        if (OSUtils.H()) {
            throw new f3("Method: " + str2 + " was called from the Main Thread!");
        } else if (str4 == null || !o3.L1((String) null)) {
            Thread[] threadArr = new Thread[1];
            Thread thread = new Thread(new d(threadArr, str, str2, jSONObject, gVar, i10, str3), "OS_HTTPConnection");
            OSUtils.W(thread);
            try {
                thread.join((long) g(i10));
                if (thread.getState() != Thread.State.TERMINATED) {
                    thread.interrupt();
                }
                Thread thread2 = threadArr[0];
                if (thread2 != null) {
                    thread2.join();
                }
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    private static HttpURLConnection i(String str) {
        return (HttpURLConnection) new URL("https://api.onesignal.com/" + str).openConnection();
    }

    public static void j(String str, JSONObject jSONObject, g gVar) {
        OSUtils.W(new Thread(new b(str, jSONObject, gVar), "OS_REST_ASYNC_POST"));
    }

    public static void k(String str, JSONObject jSONObject, g gVar) {
        h(str, "POST", jSONObject, gVar, 120000, (String) null);
    }

    public static void l(String str, JSONObject jSONObject, g gVar) {
        OSUtils.W(new Thread(new a(str, jSONObject, gVar), "OS_REST_ASYNC_PUT"));
    }

    public static void m(String str, JSONObject jSONObject, g gVar) {
        h(str, "PUT", jSONObject, gVar, 120000, (String) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b3, code lost:
        if (r9 == null) goto L_0x02b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x026e A[Catch:{ all -> 0x028e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Thread n(java.lang.String r16, java.lang.String r17, org.json.JSONObject r18, com.onesignal.b4.g r19, int r20, java.lang.String r21) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r20
            r4 = r21
            java.lang.String r5 = "OneSignalRestClient: "
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r6 < r7) goto L_0x0017
            r6 = 10000(0x2710, float:1.4013E-41)
            android.net.TrafficStats.setThreadStatsTag(r6)
        L_0x0017:
            r6 = -1
            r7 = 0
            com.onesignal.o3$v r8 = com.onesignal.o3.v.DEBUG     // Catch:{ all -> 0x0268 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0268 }
            r9.<init>()     // Catch:{ all -> 0x0268 }
            java.lang.String r10 = "OneSignalRestClient: Making request to: https://api.onesignal.com/"
            r9.append(r10)     // Catch:{ all -> 0x0268 }
            r9.append(r0)     // Catch:{ all -> 0x0268 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0268 }
            com.onesignal.o3.a(r8, r9)     // Catch:{ all -> 0x0268 }
            java.net.HttpURLConnection r9 = i(r16)     // Catch:{ all -> 0x0268 }
            r10 = 0
            r9.setUseCaches(r10)     // Catch:{ all -> 0x0065 }
            r9.setConnectTimeout(r3)     // Catch:{ all -> 0x0065 }
            r9.setReadTimeout(r3)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "SDK-Version"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r10.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = "onesignal/android/"
            r10.append(r11)     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = com.onesignal.o3.r0()     // Catch:{ all -> 0x0065 }
            r10.append(r11)     // Catch:{ all -> 0x0065 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0065 }
            r9.setRequestProperty(r3, r10)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "Accept"
            java.lang.String r10 = "application/vnd.onesignal.v1+json"
            r9.setRequestProperty(r3, r10)     // Catch:{ all -> 0x0065 }
            r3 = 1
            if (r18 == 0) goto L_0x0068
            r9.setDoInput(r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0068
        L_0x0065:
            r0 = move-exception
            goto L_0x026a
        L_0x0068:
            if (r1 == 0) goto L_0x0077
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "application/json; charset=UTF-8"
            r9.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0065 }
            r9.setRequestMethod(r1)     // Catch:{ all -> 0x0065 }
            r9.setDoOutput(r3)     // Catch:{ all -> 0x0065 }
        L_0x0077:
            java.lang.String r3 = "UTF-8"
            if (r18 == 0) goto L_0x00a8
            java.lang.String r10 = com.onesignal.f0.g(r18)     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r11.<init>()     // Catch:{ all -> 0x0065 }
            r11.append(r5)     // Catch:{ all -> 0x0065 }
            r11.append(r1)     // Catch:{ all -> 0x0065 }
            java.lang.String r12 = " SEND JSON: "
            r11.append(r12)     // Catch:{ all -> 0x0065 }
            r11.append(r10)     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r8, r11)     // Catch:{ all -> 0x0065 }
            byte[] r10 = r10.getBytes(r3)     // Catch:{ all -> 0x0065 }
            int r11 = r10.length     // Catch:{ all -> 0x0065 }
            r9.setFixedLengthStreamingMode(r11)     // Catch:{ all -> 0x0065 }
            java.io.OutputStream r11 = r9.getOutputStream()     // Catch:{ all -> 0x0065 }
            r11.write(r10)     // Catch:{ all -> 0x0065 }
        L_0x00a8:
            java.lang.String r10 = "PREFS_OS_ETAG_PREFIX_"
            if (r4 == 0) goto L_0x00dc
            java.lang.String r11 = com.onesignal.z3.f11153a     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r12.<init>()     // Catch:{ all -> 0x0065 }
            r12.append(r10)     // Catch:{ all -> 0x0065 }
            r12.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = com.onesignal.z3.f(r11, r12, r7)     // Catch:{ all -> 0x0065 }
            if (r11 == 0) goto L_0x00dc
            java.lang.String r12 = "if-none-match"
            r9.setRequestProperty(r12, r11)     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r12.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r13 = "OneSignalRestClient: Adding header if-none-match: "
            r12.append(r13)     // Catch:{ all -> 0x0065 }
            r12.append(r11)     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = r12.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r8, r11)     // Catch:{ all -> 0x0065 }
        L_0x00dc:
            int r6 = r9.getResponseCode()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3$v r11 = com.onesignal.o3.v.VERBOSE     // Catch:{ all -> 0x0264 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
            r12.<init>()     // Catch:{ all -> 0x0264 }
            java.lang.String r13 = "OneSignalRestClient: After con.getResponseCode to: https://api.onesignal.com/"
            r12.append(r13)     // Catch:{ all -> 0x0264 }
            r12.append(r0)     // Catch:{ all -> 0x0264 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0264 }
            com.onesignal.o3.a(r11, r12)     // Catch:{ all -> 0x0264 }
            r11 = 200(0xc8, float:2.8E-43)
            java.lang.String r12 = " RECEIVED JSON: "
            java.lang.String r13 = ""
            java.lang.String r14 = "\\A"
            java.lang.String r15 = "GET"
            java.lang.String r7 = "PREFS_OS_HTTP_CACHE_PREFIX_"
            if (r6 == r11) goto L_0x01c1
            r11 = 202(0xca, float:2.83E-43)
            if (r6 == r11) goto L_0x01c1
            r10 = 304(0x130, float:4.26E-43)
            if (r6 == r10) goto L_0x0187
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r4.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = "OneSignalRestClient: Failed request to: https://api.onesignal.com/"
            r4.append(r7)     // Catch:{ all -> 0x0065 }
            r4.append(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r8, r0)     // Catch:{ all -> 0x0065 }
            java.io.InputStream r0 = r9.getErrorStream()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x012a
            java.io.InputStream r0 = r9.getInputStream()     // Catch:{ all -> 0x0065 }
        L_0x012a:
            if (r0 == 0) goto L_0x015e
            java.util.Scanner r4 = new java.util.Scanner     // Catch:{ all -> 0x0065 }
            r4.<init>(r0, r3)     // Catch:{ all -> 0x0065 }
            java.util.Scanner r0 = r4.useDelimiter(r14)     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x013f
            java.lang.String r13 = r4.next()     // Catch:{ all -> 0x0065 }
        L_0x013f:
            r4.close()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3$v r0 = com.onesignal.o3.v.WARN     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            r3.append(r5)     // Catch:{ all -> 0x0065 }
            r3.append(r1)     // Catch:{ all -> 0x0065 }
            r3.append(r12)     // Catch:{ all -> 0x0065 }
            r3.append(r13)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r0, r3)     // Catch:{ all -> 0x0065 }
            r3 = 0
            goto L_0x0181
        L_0x015e:
            com.onesignal.o3$v r0 = com.onesignal.o3.v.WARN     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            r3.append(r5)     // Catch:{ all -> 0x0065 }
            r3.append(r1)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " HTTP Code: "
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            r3.append(r6)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " No response body!"
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r0, r3)     // Catch:{ all -> 0x0065 }
            r3 = 0
            r13 = 0
        L_0x0181:
            java.lang.Thread r0 = c(r2, r6, r13, r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0260
        L_0x0187:
            java.lang.String r0 = com.onesignal.z3.f11153a     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            r3.append(r7)     // Catch:{ all -> 0x0065 }
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0065 }
            r4 = 0
            java.lang.String r0 = com.onesignal.z3.f(r0, r3, r4)     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r3.<init>()     // Catch:{ all -> 0x0065 }
            r3.append(r5)     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x01a8
            goto L_0x01a9
        L_0x01a8:
            r15 = r1
        L_0x01a9:
            r3.append(r15)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = " - Using Cached response due to 304: "
            r3.append(r4)     // Catch:{ all -> 0x0065 }
            r3.append(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0065 }
            com.onesignal.o3.a(r8, r3)     // Catch:{ all -> 0x0065 }
            java.lang.Thread r0 = d(r2, r0)     // Catch:{ all -> 0x0065 }
            goto L_0x0260
        L_0x01c1:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
            r11.<init>()     // Catch:{ all -> 0x0264 }
            r18 = r6
            java.lang.String r6 = "OneSignalRestClient: Successfully finished request to: https://api.onesignal.com/"
            r11.append(r6)     // Catch:{ all -> 0x01ef }
            r11.append(r0)     // Catch:{ all -> 0x01ef }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x01ef }
            com.onesignal.o3.a(r8, r0)     // Catch:{ all -> 0x01ef }
            java.io.InputStream r0 = r9.getInputStream()     // Catch:{ all -> 0x01ef }
            java.util.Scanner r6 = new java.util.Scanner     // Catch:{ all -> 0x01ef }
            r6.<init>(r0, r3)     // Catch:{ all -> 0x01ef }
            java.util.Scanner r0 = r6.useDelimiter(r14)     // Catch:{ all -> 0x01ef }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x01ef }
            if (r0 == 0) goto L_0x01f4
            java.lang.String r13 = r6.next()     // Catch:{ all -> 0x01ef }
            goto L_0x01f4
        L_0x01ef:
            r0 = move-exception
            r6 = r18
            goto L_0x026a
        L_0x01f4:
            r6.close()     // Catch:{ all -> 0x01ef }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
            r0.<init>()     // Catch:{ all -> 0x01ef }
            r0.append(r5)     // Catch:{ all -> 0x01ef }
            if (r1 != 0) goto L_0x0202
            goto L_0x0203
        L_0x0202:
            r15 = r1
        L_0x0203:
            r0.append(r15)     // Catch:{ all -> 0x01ef }
            r0.append(r12)     // Catch:{ all -> 0x01ef }
            r0.append(r13)     // Catch:{ all -> 0x01ef }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01ef }
            com.onesignal.o3.a(r8, r0)     // Catch:{ all -> 0x01ef }
            if (r4 == 0) goto L_0x025c
            java.lang.String r0 = "etag"
            java.lang.String r0 = r9.getHeaderField(r0)     // Catch:{ all -> 0x01ef }
            if (r0 == 0) goto L_0x025c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
            r3.<init>()     // Catch:{ all -> 0x01ef }
            java.lang.String r6 = "OneSignalRestClient: Response has etag of "
            r3.append(r6)     // Catch:{ all -> 0x01ef }
            r3.append(r0)     // Catch:{ all -> 0x01ef }
            java.lang.String r6 = " so caching the response."
            r3.append(r6)     // Catch:{ all -> 0x01ef }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01ef }
            com.onesignal.o3.a(r8, r3)     // Catch:{ all -> 0x01ef }
            java.lang.String r3 = com.onesignal.z3.f11153a     // Catch:{ all -> 0x01ef }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
            r6.<init>()     // Catch:{ all -> 0x01ef }
            r6.append(r10)     // Catch:{ all -> 0x01ef }
            r6.append(r4)     // Catch:{ all -> 0x01ef }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01ef }
            com.onesignal.z3.m(r3, r6, r0)     // Catch:{ all -> 0x01ef }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ef }
            r0.<init>()     // Catch:{ all -> 0x01ef }
            r0.append(r7)     // Catch:{ all -> 0x01ef }
            r0.append(r4)     // Catch:{ all -> 0x01ef }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01ef }
            com.onesignal.z3.m(r3, r0, r13)     // Catch:{ all -> 0x01ef }
        L_0x025c:
            java.lang.Thread r0 = d(r2, r13)     // Catch:{ all -> 0x01ef }
        L_0x0260:
            r9.disconnect()
            goto L_0x02b6
        L_0x0264:
            r0 = move-exception
            r18 = r6
            goto L_0x026a
        L_0x0268:
            r0 = move-exception
            r9 = 0
        L_0x026a:
            boolean r3 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x028e }
            if (r3 != 0) goto L_0x0290
            boolean r3 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x028e }
            if (r3 == 0) goto L_0x0273
            goto L_0x0290
        L_0x0273:
            com.onesignal.o3$v r3 = com.onesignal.o3.v.WARN     // Catch:{ all -> 0x028e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x028e }
            r4.<init>()     // Catch:{ all -> 0x028e }
            r4.append(r5)     // Catch:{ all -> 0x028e }
            r4.append(r1)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = " Error thrown from network stack. "
            r4.append(r1)     // Catch:{ all -> 0x028e }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x028e }
            com.onesignal.o3.b(r3, r1, r0)     // Catch:{ all -> 0x028e }
        L_0x028c:
            r1 = 0
            goto L_0x02af
        L_0x028e:
            r0 = move-exception
            goto L_0x02b7
        L_0x0290:
            com.onesignal.o3$v r1 = com.onesignal.o3.v.INFO     // Catch:{ all -> 0x028e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x028e }
            r3.<init>()     // Catch:{ all -> 0x028e }
            java.lang.String r4 = "OneSignalRestClient: Could not send last request, device is offline. Throwable: "
            r3.append(r4)     // Catch:{ all -> 0x028e }
            java.lang.Class r4 = r0.getClass()     // Catch:{ all -> 0x028e }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x028e }
            r3.append(r4)     // Catch:{ all -> 0x028e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x028e }
            com.onesignal.o3.a(r1, r3)     // Catch:{ all -> 0x028e }
            goto L_0x028c
        L_0x02af:
            java.lang.Thread r0 = c(r2, r6, r1, r0)     // Catch:{ all -> 0x028e }
            if (r9 == 0) goto L_0x02b6
            goto L_0x0260
        L_0x02b6:
            return r0
        L_0x02b7:
            if (r9 == 0) goto L_0x02bc
            r9.disconnect()
        L_0x02bc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.b4.n(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.b4$g, int, java.lang.String):java.lang.Thread");
    }
}
