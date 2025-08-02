package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.producers.x0;
import g3.f;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.cocos2dx.javascript.PlatformUtils;
import y2.j;

public class d0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f20056a;

    /* renamed from: b  reason: collision with root package name */
    private String f20057b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f20058c;

    /* renamed from: d  reason: collision with root package name */
    private final ExecutorService f20059d;

    /* renamed from: e  reason: collision with root package name */
    private final f3.c f20060e;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20061a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x0.a f20062b;

        a(c cVar, x0.a aVar) {
            this.f20061a = cVar;
            this.f20062b = aVar;
        }

        public void run() {
            d0.this.j(this.f20061a, this.f20062b);
        }
    }

    class b extends f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Future f20064a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x0.a f20065b;

        b(Future future, x0.a aVar) {
            this.f20064a = future;
            this.f20065b = aVar;
        }

        public void a() {
            if (this.f20064a.cancel(false)) {
                this.f20065b.a();
            }
        }
    }

    public static class c extends c0 {
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public long f20067f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f20068g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public long f20069h;

        public c(n nVar, e1 e1Var) {
            super(nVar, e1Var);
        }
    }

    public d0(int i10) {
        this((String) null, (Map) null, RealtimeSinceBootClock.get());
        this.f20056a = i10;
    }

    private HttpURLConnection g(Uri uri, int i10) {
        Uri uri2;
        String str;
        HttpURLConnection o10 = o(uri);
        String str2 = this.f20057b;
        if (str2 != null) {
            o10.setRequestProperty("User-Agent", str2);
        }
        Map map = this.f20058c;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                o10.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        o10.setConnectTimeout(this.f20056a);
        int responseCode = o10.getResponseCode();
        if (m(responseCode)) {
            return o10;
        }
        if (l(responseCode)) {
            String headerField = o10.getHeaderField("Location");
            o10.disconnect();
            if (headerField == null) {
                uri2 = null;
            } else {
                uri2 = Uri.parse(headerField);
            }
            String scheme = uri.getScheme();
            if (i10 > 0 && uri2 != null && !j.a(uri2.getScheme(), scheme)) {
                return g(uri2, i10 - 1);
            }
            if (i10 == 0) {
                str = h("URL %s follows too many redirects", uri.toString());
            } else {
                str = h("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
            }
            throw new IOException(str);
        }
        o10.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{uri.toString(), Integer.valueOf(responseCode)}));
    }

    private static String h(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }

    private static boolean l(int i10) {
        if (i10 == 307 || i10 == 308) {
            return true;
        }
        switch (i10) {
            case 300:
            case PlatformUtils.LOCATION_CODE:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    private static boolean m(int i10) {
        return i10 >= 200 && i10 < 300;
    }

    static HttpURLConnection o(Uri uri) {
        return (HttpURLConnection) f.q(uri).openConnection();
    }

    /* renamed from: f */
    public c e(n nVar, e1 e1Var) {
        return new c(nVar, e1Var);
    }

    /* renamed from: i */
    public void d(c cVar, x0.a aVar) {
        cVar.f20067f = this.f20060e.now();
        cVar.b().h(new b(this.f20059d.submit(new a(cVar, aVar)), aVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v7 ?
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.collectCodeVars(ProcessVariables.java:122)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:45)
        */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A[SYNTHETIC, Splitter:B:22:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A[SYNTHETIC, Splitter:B:27:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public void j(com.facebook.imagepipeline.producers.d0.c r5, com.facebook.imagepipeline.producers.x0.a r6) {
        /*
            r4 = this;
            r0 = 0
            android.net.Uri r1 = r5.g()     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r2 = 5
            java.net.HttpURLConnection r1 = r4.g(r1, r2)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            f3.c r2 = r4.f20060e     // Catch:{ IOException -> 0x0020 }
            long r2 = r2.now()     // Catch:{ IOException -> 0x0020 }
            r5.f20068g = r2     // Catch:{ IOException -> 0x0020 }
            if (r1 == 0) goto L_0x0022
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x0020 }
            r5 = -1
            r6.b(r0, r5)     // Catch:{ IOException -> 0x0020 }
            goto L_0x0022
        L_0x001e:
            r5 = move-exception
            goto L_0x003e
        L_0x0020:
            r5 = move-exception
            goto L_0x0032
        L_0x0022:
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            if (r1 == 0) goto L_0x003d
        L_0x0029:
            r1.disconnect()
            goto L_0x003d
        L_0x002d:
            r5 = move-exception
            r1 = r0
            goto L_0x003e
        L_0x0030:
            r5 = move-exception
            r1 = r0
        L_0x0032:
            r6.onFailure(r5)     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            if (r1 == 0) goto L_0x003d
            goto L_0x0029
        L_0x003d:
            return
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.disconnect()
        L_0x0048:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.d0.j(com.facebook.imagepipeline.producers.d0$c, com.facebook.imagepipeline.producers.x0$a):void");
    }

    /* renamed from: k */
    public Map c(c cVar, int i10) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(cVar.f20068g - cVar.f20067f));
        hashMap.put("fetch_time", Long.toString(cVar.f20069h - cVar.f20068g));
        hashMap.put("total_time", Long.toString(cVar.f20069h - cVar.f20067f));
        hashMap.put("image_size", Integer.toString(i10));
        return hashMap;
    }

    /* renamed from: n */
    public void a(c cVar, int i10) {
        cVar.f20069h = this.f20060e.now();
    }

    d0(String str, Map map, f3.c cVar) {
        this.f20059d = Executors.newFixedThreadPool(3);
        this.f20060e = cVar;
        this.f20058c = map;
        this.f20057b = str;
    }
}
