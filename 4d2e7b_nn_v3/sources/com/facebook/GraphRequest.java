package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.s;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;
import q5.i0;
import q5.p0;
import q5.q0;

public final class GraphRequest {

    /* renamed from: o  reason: collision with root package name */
    public static final String f19536o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final String f19537p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static String f19538q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f19539r = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static volatile String f19540s;

    /* renamed from: t  reason: collision with root package name */
    public static final c f19541t = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private AccessToken f19542a;

    /* renamed from: b  reason: collision with root package name */
    private String f19543b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f19544c;

    /* renamed from: d  reason: collision with root package name */
    private String f19545d;

    /* renamed from: e  reason: collision with root package name */
    private String f19546e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19547f;

    /* renamed from: g  reason: collision with root package name */
    private Bundle f19548g;

    /* renamed from: h  reason: collision with root package name */
    private Object f19549h;

    /* renamed from: i  reason: collision with root package name */
    private String f19550i;

    /* renamed from: j  reason: collision with root package name */
    private b f19551j;

    /* renamed from: k  reason: collision with root package name */
    private u f19552k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19553l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19554m;

    /* renamed from: n  reason: collision with root package name */
    private String f19555n;

    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final b f19556c = new b((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f19557a;

        /* renamed from: b  reason: collision with root package name */
        private final Parcelable f19558b;

        public static final class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                m.f(parcel, "source");
                return new ParcelableResourceWithMimeType(parcel, (DefaultConstructorMarker) null);
            }

            /* renamed from: b */
            public ParcelableResourceWithMimeType[] newArray(int i10) {
                return new ParcelableResourceWithMimeType[i10];
            }
        }

        public static final class b {
            private b() {
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final String a() {
            return this.f19557a;
        }

        public final Parcelable b() {
            return this.f19558b;
        }

        public int describeContents() {
            return 1;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            m.f(parcel, "out");
            parcel.writeString(this.f19557a);
            parcel.writeParcelable(this.f19558b, i10);
        }

        public ParcelableResourceWithMimeType(Parcelable parcelable, String str) {
            this.f19557a = str;
            this.f19558b = parcelable;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.f19557a = parcel.readString();
            this.f19558b = parcel.readParcelable(o.f().getClassLoader());
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final GraphRequest f19559a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f19560b;

        public a(GraphRequest graphRequest, Object obj) {
            m.f(graphRequest, "request");
            this.f19559a = graphRequest;
            this.f19560b = obj;
        }

        public final GraphRequest a() {
            return this.f19559a;
        }

        public final Object b() {
            return this.f19560b;
        }
    }

    public interface b {
        void a(t tVar);
    }

    public static final class c {

        static final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f19561a;

            a(d dVar) {
                this.f19561a = dVar;
            }

            public final void a(t tVar) {
                m.f(tVar, "response");
                d dVar = this.f19561a;
                if (dVar != null) {
                    dVar.a(tVar.c(), tVar);
                }
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ArrayList f19562a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ s f19563b;

            b(ArrayList arrayList, s sVar) {
                this.f19562a = arrayList;
                this.f19563b = sVar;
            }

            public final void run() {
                if (!v5.a.d(this)) {
                    try {
                        Iterator it = this.f19562a.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            Object obj = pair.second;
                            m.e(obj, "pair.second");
                            ((b) pair.first).a((t) obj);
                        }
                        for (s.a a10 : this.f19563b.n()) {
                            a10.a(this.f19563b);
                        }
                    } catch (Throwable th) {
                        v5.a.b(th, this);
                    }
                }
            }
        }

        private c() {
        }

        private final void A(String str, Object obj, e eVar, boolean z10) {
            Class<?> cls = obj.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) obj;
                if (z10) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b0 b0Var = b0.f709a;
                        String format = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        m.e(format, "java.lang.String.format(format, *args)");
                        Object opt = jSONObject.opt(next);
                        m.e(opt, "jsonObject.opt(propertyName)");
                        A(format, opt, eVar, z10);
                    }
                } else if (jSONObject.has("id")) {
                    String optString = jSONObject.optString("id");
                    m.e(optString, "jsonObject.optString(\"id\")");
                    A(str, optString, eVar, z10);
                } else if (jSONObject.has(ImagesContract.URL)) {
                    String optString2 = jSONObject.optString(ImagesContract.URL);
                    m.e(optString2, "jsonObject.optString(\"url\")");
                    A(str, optString2, eVar, z10);
                } else if (jSONObject.has("fbsdk:create_object")) {
                    String jSONObject2 = jSONObject.toString();
                    m.e(jSONObject2, "jsonObject.toString()");
                    A(str, jSONObject2, eVar, z10);
                }
            } else if (JSONArray.class.isAssignableFrom(cls)) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    b0 b0Var2 = b0.f709a;
                    String format2 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10)}, 2));
                    m.e(format2, "java.lang.String.format(locale, format, *args)");
                    Object opt2 = jSONArray.opt(i10);
                    m.e(opt2, "jsonArray.opt(i)");
                    A(format2, opt2, eVar, z10);
                }
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
                eVar.a(str, obj.toString());
            } else if (Date.class.isAssignableFrom(cls)) {
                String format3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                m.e(format3, "iso8601DateFormat.format(date)");
                eVar.a(str, format3);
            }
        }

        private final void B(s sVar, d0 d0Var, int i10, URL url, OutputStream outputStream, boolean z10) {
            f fVar = new f(outputStream, d0Var, z10);
            if (i10 == 1) {
                GraphRequest k10 = sVar.get(0);
                HashMap hashMap = new HashMap();
                for (String next : k10.s().keySet()) {
                    Object obj = k10.s().get(next);
                    if (t(obj)) {
                        m.e(next, "key");
                        hashMap.put(next, new a(k10, obj));
                    }
                }
                if (d0Var != null) {
                    d0Var.b("  Parameters:\n");
                }
                E(k10.s(), fVar, k10);
                if (d0Var != null) {
                    d0Var.b("  Attachments:\n");
                }
                D(hashMap, fVar);
                JSONObject o10 = k10.o();
                if (o10 != null) {
                    String path = url.getPath();
                    m.e(path, "url.path");
                    z(o10, path, fVar);
                    return;
                }
                return;
            }
            String n10 = n(sVar);
            if (n10.length() != 0) {
                fVar.a("batch_app_id", n10);
                HashMap hashMap2 = new HashMap();
                F(fVar, sVar, hashMap2);
                if (d0Var != null) {
                    d0Var.b("  Attachments:\n");
                }
                D(hashMap2, fVar);
                return;
            }
            throw new l("App ID was not specified at the request or Settings.");
        }

        private final void D(Map map, f fVar) {
            for (Map.Entry entry : map.entrySet()) {
                if (GraphRequest.f19541t.t(((a) entry.getValue()).b())) {
                    fVar.j((String) entry.getKey(), ((a) entry.getValue()).b(), ((a) entry.getValue()).a());
                }
            }
        }

        private final void E(Bundle bundle, f fVar, GraphRequest graphRequest) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (u(obj)) {
                    m.e(next, "key");
                    fVar.j(next, obj, graphRequest);
                }
            }
        }

        private final void F(f fVar, Collection collection, Map map) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).A(jSONArray, map);
            }
            fVar.l("batch", jSONArray, collection);
        }

        private final void H(HttpURLConnection httpURLConnection, boolean z10) {
            if (z10) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                return;
            }
            httpURLConnection.setRequestProperty("Content-Type", o());
        }

        private final HttpURLConnection e(URL url) {
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestProperty("User-Agent", p());
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
                httpURLConnection.setChunkedStreamingMode(0);
                return httpURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        private final String n(s sVar) {
            String l10 = sVar.l();
            if (l10 != null && (!sVar.isEmpty())) {
                return l10;
            }
            Iterator it = sVar.iterator();
            while (it.hasNext()) {
                AccessToken k10 = ((GraphRequest) it.next()).k();
                if (k10 != null) {
                    return k10.c();
                }
            }
            String a10 = GraphRequest.f19538q;
            if (a10 == null || a10.length() <= 0) {
                return o.g();
            }
            return a10;
        }

        private final String o() {
            b0 b0Var = b0.f709a;
            String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.f19537p}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            return format;
        }

        private final String p() {
            if (GraphRequest.f19540s == null) {
                b0 b0Var = b0.f709a;
                String format = String.format("%s.%s", Arrays.copyOf(new Object[]{"FBAndroidSDK", "12.3.0"}, 2));
                m.e(format, "java.lang.String.format(format, *args)");
                GraphRequest.f19540s = format;
                String a10 = q5.b0.a();
                if (!p0.Y(a10)) {
                    String format2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.f19540s, a10}, 2));
                    m.e(format2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.f19540s = format2;
                }
            }
            return GraphRequest.f19540s;
        }

        private final boolean q(s sVar) {
            for (s.a aVar : sVar.n()) {
            }
            Iterator it = sVar.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).m();
            }
            return false;
        }

        private final boolean r(s sVar) {
            Iterator it = sVar.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                Iterator<String> it2 = graphRequest.s().keySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (t(graphRequest.s().get(it2.next()))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private final boolean s(String str) {
            Matcher matcher = GraphRequest.f19539r.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                m.e(str, "matcher.group(1)");
            }
            if (j.F(str, "me/", false, 2, (Object) null) || j.F(str, "/me/", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean t(Object obj) {
            if ((obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean u(Object obj) {
            if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final String y(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (obj instanceof Date) {
                String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj);
                m.e(format, "iso8601DateFormat.format(value)");
                return format;
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void z(org.json.JSONObject r10, java.lang.String r11, com.facebook.GraphRequest.e r12) {
            /*
                r9 = this;
                boolean r0 = r9.s(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0023
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r5 = 0
                r6 = 0
                r3 = r11
                int r0 = kotlin.text.j.V(r3, r4, r5, r6, r7, r8)
                java.lang.String r4 = "?"
                int r11 = kotlin.text.j.V(r3, r4, r5, r6, r7, r8)
                r3 = 3
                if (r0 <= r3) goto L_0x0023
                r3 = -1
                if (r11 == r3) goto L_0x0021
                if (r0 >= r11) goto L_0x0023
            L_0x0021:
                r11 = r1
                goto L_0x0024
            L_0x0023:
                r11 = r2
            L_0x0024:
                java.util.Iterator r0 = r10.keys()
            L_0x0028:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0053
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L_0x0044
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.j.q(r3, r5, r1)
                if (r5 == 0) goto L_0x0044
                r5 = r1
                goto L_0x0045
            L_0x0044:
                r5 = r2
            L_0x0045:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.m.e(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.m.e(r4, r6)
                r9.A(r3, r4, r12, r5)
                goto L_0x0028
            L_0x0053:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.c.z(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$e):void");
        }

        public final void C(s sVar, List list) {
            m.f(sVar, "requests");
            m.f(list, "responses");
            int size = sVar.size();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < size; i10++) {
                GraphRequest k10 = sVar.get(i10);
                if (k10.m() != null) {
                    arrayList.add(new Pair(k10.m(), list.get(i10)));
                }
            }
            if (arrayList.size() > 0) {
                b bVar = new b(arrayList, sVar);
                Handler m10 = sVar.m();
                if (m10 != null) {
                    m10.post(bVar);
                } else {
                    bVar.run();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: com.facebook.b0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: com.facebook.b0} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.facebook.b0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ed  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void G(com.facebook.s r14, java.net.HttpURLConnection r15) {
            /*
                r13 = this;
                java.lang.String r0 = "requests"
                kotlin.jvm.internal.m.f(r14, r0)
                java.lang.String r0 = "connection"
                kotlin.jvm.internal.m.f(r15, r0)
                q5.d0 r0 = new q5.d0
                com.facebook.w r1 = com.facebook.w.REQUESTS
                java.lang.String r2 = "Request"
                r0.<init>(r1, r2)
                int r10 = r14.size()
                boolean r11 = r13.r(r14)
                r1 = 0
                r2 = 1
                if (r10 != r2) goto L_0x0029
                r3 = 0
                com.facebook.GraphRequest r3 = r14.get(r3)
                com.facebook.u r3 = r3.r()
                goto L_0x002a
            L_0x0029:
                r3 = r1
            L_0x002a:
                if (r3 == 0) goto L_0x002d
                goto L_0x002f
            L_0x002d:
                com.facebook.u r3 = com.facebook.u.POST
            L_0x002f:
                java.lang.String r4 = r3.name()
                r15.setRequestMethod(r4)
                r13.H(r15, r11)
                java.net.URL r12 = r15.getURL()
                java.lang.String r4 = "Request:\n"
                r0.b(r4)
                java.lang.String r4 = "Id"
                java.lang.String r5 = r14.o()
                r0.d(r4, r5)
                java.lang.String r4 = "url"
                kotlin.jvm.internal.m.e(r12, r4)
                java.lang.String r4 = "URL"
                r0.d(r4, r12)
                java.lang.String r4 = r15.getRequestMethod()
                java.lang.String r5 = "connection.requestMethod"
                kotlin.jvm.internal.m.e(r4, r5)
                java.lang.String r5 = "Method"
                r0.d(r5, r4)
                java.lang.String r4 = "User-Agent"
                java.lang.String r5 = r15.getRequestProperty(r4)
                java.lang.String r6 = "connection.getRequestProperty(\"User-Agent\")"
                kotlin.jvm.internal.m.e(r5, r6)
                r0.d(r4, r5)
                java.lang.String r4 = "Content-Type"
                java.lang.String r5 = r15.getRequestProperty(r4)
                java.lang.String r6 = "connection.getRequestProperty(\"Content-Type\")"
                kotlin.jvm.internal.m.e(r5, r6)
                r0.d(r4, r5)
                int r4 = r14.r()
                r15.setConnectTimeout(r4)
                int r4 = r14.r()
                r15.setReadTimeout(r4)
                com.facebook.u r4 = com.facebook.u.POST
                if (r3 != r4) goto L_0x00f1
                r15.setDoOutput(r2)
                java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00d5 }
                java.io.OutputStream r15 = r15.getOutputStream()     // Catch:{ all -> 0x00d5 }
                r2.<init>(r15)     // Catch:{ all -> 0x00d5 }
                if (r11 == 0) goto L_0x00a9
                java.util.zip.GZIPOutputStream r15 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x00a6 }
                r15.<init>(r2)     // Catch:{ all -> 0x00a6 }
                r1 = r15
                goto L_0x00aa
            L_0x00a6:
                r14 = move-exception
                r1 = r2
                goto L_0x00eb
            L_0x00a9:
                r1 = r2
            L_0x00aa:
                boolean r15 = r13.q(r14)     // Catch:{ all -> 0x00d5 }
                if (r15 == 0) goto L_0x00d7
                com.facebook.a0 r15 = new com.facebook.a0     // Catch:{ all -> 0x00d5 }
                android.os.Handler r2 = r14.m()     // Catch:{ all -> 0x00d5 }
                r15.<init>(r2)     // Catch:{ all -> 0x00d5 }
                r5 = 0
                r3 = r13
                r4 = r14
                r6 = r10
                r7 = r12
                r8 = r15
                r9 = r11
                r3.B(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00d5 }
                int r2 = r15.h()     // Catch:{ all -> 0x00d5 }
                java.util.Map r6 = r15.j()     // Catch:{ all -> 0x00d5 }
                com.facebook.b0 r15 = new com.facebook.b0     // Catch:{ all -> 0x00d5 }
                long r7 = (long) r2     // Catch:{ all -> 0x00d5 }
                r3 = r15
                r4 = r1
                r5 = r14
                r3.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x00d5 }
                goto L_0x00d8
            L_0x00d5:
                r14 = move-exception
                goto L_0x00eb
            L_0x00d7:
                r15 = r1
            L_0x00d8:
                r1 = r13
                r2 = r14
                r3 = r0
                r4 = r10
                r5 = r12
                r6 = r15
                r7 = r11
                r1.B(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00e9 }
                r15.close()
                r0.e()
                return
            L_0x00e9:
                r14 = move-exception
                r1 = r15
            L_0x00eb:
                if (r1 == 0) goto L_0x00f0
                r1.close()
            L_0x00f0:
                throw r14
            L_0x00f1:
                r0.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.c.G(com.facebook.s, java.net.HttpURLConnection):void");
        }

        public final HttpURLConnection I(s sVar) {
            URL url;
            m.f(sVar, "requests");
            J(sVar);
            try {
                if (sVar.size() == 1) {
                    url = new URL(sVar.get(0).v());
                } else {
                    url = new URL(i0.g());
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = e(url);
                    G(sVar, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e10) {
                    p0.q(httpURLConnection);
                    throw new l("could not construct request body", (Throwable) e10);
                } catch (JSONException e11) {
                    p0.q(httpURLConnection);
                    throw new l("could not construct request body", (Throwable) e11);
                }
            } catch (MalformedURLException e12) {
                throw new l("could not construct URL for request", (Throwable) e12);
            }
        }

        public final void J(s sVar) {
            m.f(sVar, "requests");
            Iterator it = sVar.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                if (u.GET == graphRequest.r() && p0.Y(graphRequest.s().getString("fields"))) {
                    d0.a aVar = d0.f23283f;
                    w wVar = w.DEVELOPER_ERRORS;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("GET requests for /");
                    String p10 = graphRequest.p();
                    if (p10 == null) {
                        p10 = "";
                    }
                    sb2.append(p10);
                    sb2.append(" should contain an explicit \"fields\" parameter.");
                    aVar.a(wVar, 5, "Request", sb2.toString());
                }
            }
        }

        public final t f(GraphRequest graphRequest) {
            m.f(graphRequest, "request");
            List i10 = i(graphRequest);
            if (i10.size() == 1) {
                return (t) i10.get(0);
            }
            throw new l("invalid state: expected a single response");
        }

        public final List g(s sVar) {
            Exception exc;
            HttpURLConnection httpURLConnection;
            List list;
            m.f(sVar, "requests");
            q0.l(sVar, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = I(sVar);
                exc = null;
            } catch (Exception e10) {
                exc = e10;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                p0.q(httpURLConnection2);
                throw th;
            }
            if (httpURLConnection != null) {
                try {
                    list = m(httpURLConnection, sVar);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    p0.q(httpURLConnection2);
                    throw th;
                }
            } else {
                List a10 = t.f20947j.a(sVar.p(), (HttpURLConnection) null, new l((Throwable) exc));
                C(sVar, a10);
                list = a10;
            }
            p0.q(httpURLConnection);
            return list;
        }

        public final List h(Collection collection) {
            m.f(collection, "requests");
            return g(new s(collection));
        }

        public final List i(GraphRequest... graphRequestArr) {
            m.f(graphRequestArr, "requests");
            return h(kotlin.collections.j.W(graphRequestArr));
        }

        public final r j(s sVar) {
            m.f(sVar, "requests");
            q0.l(sVar, "requests");
            r rVar = new r(sVar);
            rVar.executeOnExecutor(o.p(), new Void[0]);
            return rVar;
        }

        public final r k(Collection collection) {
            m.f(collection, "requests");
            return j(new s(collection));
        }

        public final r l(GraphRequest... graphRequestArr) {
            m.f(graphRequestArr, "requests");
            return k(kotlin.collections.j.W(graphRequestArr));
        }

        public final List m(HttpURLConnection httpURLConnection, s sVar) {
            m.f(httpURLConnection, "connection");
            m.f(sVar, "requests");
            List f10 = t.f20947j.f(httpURLConnection, sVar);
            p0.q(httpURLConnection);
            int size = sVar.size();
            if (size == f10.size()) {
                C(sVar, f10);
                c.f19600g.e().f();
                return f10;
            }
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(f10.size()), Integer.valueOf(size)}, 2));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            throw new l(format);
        }

        public final GraphRequest v(AccessToken accessToken, String str, b bVar) {
            return new GraphRequest(accessToken, str, (Bundle) null, (u) null, bVar, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest w(AccessToken accessToken, d dVar) {
            return new GraphRequest(accessToken, "me", (Bundle) null, (u) null, new a(dVar), (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest x(AccessToken accessToken, String str, JSONObject jSONObject, b bVar) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, (Bundle) null, u.POST, bVar, (String) null, 32, (DefaultConstructorMarker) null);
            graphRequest.D(jSONObject);
            return graphRequest;
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface d {
        void a(JSONObject jSONObject, t tVar);
    }

    private interface e {
        void a(String str, String str2);
    }

    private static final class f implements e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19564a = true;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f19565b;

        /* renamed from: c  reason: collision with root package name */
        private final OutputStream f19566c;

        /* renamed from: d  reason: collision with root package name */
        private final d0 f19567d;

        public f(OutputStream outputStream, d0 d0Var, boolean z10) {
            m.f(outputStream, "outputStream");
            this.f19566c = outputStream;
            this.f19567d = d0Var;
            this.f19565b = z10;
        }

        private final RuntimeException b() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void a(String str, String str2) {
            m.f(str, "key");
            m.f(str2, "value");
            f(str, (String) null, (String) null);
            i("%s", str2);
            k();
            d0 d0Var = this.f19567d;
            if (d0Var != null) {
                d0Var.d("    " + str, str2);
            }
        }

        public final void c(String str, Object... objArr) {
            m.f(str, "format");
            m.f(objArr, "args");
            if (!this.f19565b) {
                if (this.f19564a) {
                    OutputStream outputStream = this.f19566c;
                    Charset charset = kotlin.text.d.f797b;
                    byte[] bytes = "--".getBytes(charset);
                    m.e(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream.write(bytes);
                    OutputStream outputStream2 = this.f19566c;
                    String b10 = GraphRequest.f19537p;
                    if (b10 != null) {
                        byte[] bytes2 = b10.getBytes(charset);
                        m.e(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream2.write(bytes2);
                        OutputStream outputStream3 = this.f19566c;
                        byte[] bytes3 = "\r\n".getBytes(charset);
                        m.e(bytes3, "(this as java.lang.String).getBytes(charset)");
                        outputStream3.write(bytes3);
                        this.f19564a = false;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                OutputStream outputStream4 = this.f19566c;
                b0 b0Var = b0.f709a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                m.e(format, "java.lang.String.format(format, *args)");
                byte[] bytes4 = format.getBytes(kotlin.text.d.f797b);
                m.e(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                return;
            }
            OutputStream outputStream5 = this.f19566c;
            b0 b0Var2 = b0.f709a;
            Locale locale = Locale.US;
            Object[] copyOf2 = Arrays.copyOf(objArr, objArr.length);
            String format2 = String.format(locale, str, Arrays.copyOf(copyOf2, copyOf2.length));
            m.e(format2, "java.lang.String.format(locale, format, *args)");
            String encode = URLEncoder.encode(format2, "UTF-8");
            m.e(encode, "URLEncoder.encode(String… format, *args), \"UTF-8\")");
            Charset charset2 = kotlin.text.d.f797b;
            if (encode != null) {
                byte[] bytes5 = encode.getBytes(charset2);
                m.e(bytes5, "(this as java.lang.String).getBytes(charset)");
                outputStream5.write(bytes5);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public final void d(String str, Bitmap bitmap) {
            m.f(str, "key");
            m.f(bitmap, "bitmap");
            f(str, str, ClipboardModule.MIMETYPE_PNG);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f19566c);
            i("", new Object[0]);
            k();
            d0 d0Var = this.f19567d;
            if (d0Var != null) {
                d0Var.d("    " + str, "<Image>");
            }
        }

        public final void e(String str, byte[] bArr) {
            m.f(str, "key");
            m.f(bArr, "bytes");
            f(str, str, "content/unknown");
            this.f19566c.write(bArr);
            i("", new Object[0]);
            k();
            d0 d0Var = this.f19567d;
            if (d0Var != null) {
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                d0Var.d("    " + str, format);
            }
        }

        public final void f(String str, String str2, String str3) {
            if (!this.f19565b) {
                c("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    c("; filename=\"%s\"", str2);
                }
                i("", new Object[0]);
                if (str3 != null) {
                    i("%s: %s", "Content-Type", str3);
                }
                i("", new Object[0]);
                return;
            }
            OutputStream outputStream = this.f19566c;
            b0 b0Var = b0.f709a;
            String format = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            m.e(format, "java.lang.String.format(format, *args)");
            byte[] bytes = format.getBytes(kotlin.text.d.f797b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void g(String str, Uri uri, String str2) {
            int i10;
            m.f(str, "key");
            m.f(uri, "contentUri");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            if (this.f19566c instanceof a0) {
                ((a0) this.f19566c).b(p0.x(uri));
                i10 = 0;
            } else {
                i10 = p0.o(o.f().getContentResolver().openInputStream(uri), this.f19566c);
            }
            i("", new Object[0]);
            k();
            d0 d0Var = this.f19567d;
            if (d0Var != null) {
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                d0Var.d("    " + str, format);
            }
        }

        public final void h(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i10;
            m.f(str, "key");
            m.f(parcelFileDescriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            f(str, str, str2);
            OutputStream outputStream = this.f19566c;
            if (outputStream instanceof a0) {
                ((a0) outputStream).b(parcelFileDescriptor.getStatSize());
                i10 = 0;
            } else {
                i10 = p0.o(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.f19566c);
            }
            i("", new Object[0]);
            k();
            d0 d0Var = this.f19567d;
            if (d0Var != null) {
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                d0Var.d("    " + str, format);
            }
        }

        public final void i(String str, Object... objArr) {
            m.f(str, "format");
            m.f(objArr, "args");
            c(str, Arrays.copyOf(objArr, objArr.length));
            if (!this.f19565b) {
                c("\r\n", new Object[0]);
            }
        }

        public final void j(String str, Object obj, GraphRequest graphRequest) {
            m.f(str, "key");
            OutputStream outputStream = this.f19566c;
            if (outputStream instanceof c0) {
                if (outputStream != null) {
                    ((c0) outputStream).a(graphRequest);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.RequestOutputStream");
                }
            }
            c cVar = GraphRequest.f19541t;
            if (cVar.u(obj)) {
                a(str, cVar.y(obj));
            } else if (obj instanceof Bitmap) {
                d(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                e(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                g(str, (Uri) obj, (String) null);
            } else if (obj instanceof ParcelFileDescriptor) {
                h(str, (ParcelFileDescriptor) obj, (String) null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable b10 = parcelableResourceWithMimeType.b();
                String a10 = parcelableResourceWithMimeType.a();
                if (b10 instanceof ParcelFileDescriptor) {
                    h(str, (ParcelFileDescriptor) b10, a10);
                } else if (b10 instanceof Uri) {
                    g(str, (Uri) b10, a10);
                } else {
                    throw b();
                }
            } else {
                throw b();
            }
        }

        public final void k() {
            if (!this.f19565b) {
                i("--%s", GraphRequest.f19537p);
                return;
            }
            OutputStream outputStream = this.f19566c;
            byte[] bytes = "&".getBytes(kotlin.text.d.f797b);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void l(String str, JSONArray jSONArray, Collection collection) {
            m.f(str, "key");
            m.f(jSONArray, "requestJsonArray");
            m.f(collection, "requests");
            OutputStream outputStream = this.f19566c;
            if (!(outputStream instanceof c0)) {
                String jSONArray2 = jSONArray.toString();
                m.e(jSONArray2, "requestJsonArray.toString()");
                a(str, jSONArray2);
            } else if (outputStream != null) {
                c0 c0Var = (c0) outputStream;
                f(str, (String) null, (String) null);
                c("[", new Object[0]);
                Iterator it = collection.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    c0Var.a((GraphRequest) it.next());
                    if (i10 > 0) {
                        c(",%s", jSONObject.toString());
                    } else {
                        c("%s", jSONObject.toString());
                    }
                    i10++;
                }
                c("]", new Object[0]);
                d0 d0Var = this.f19567d;
                if (d0Var != null) {
                    String jSONArray3 = jSONArray.toString();
                    m.e(jSONArray3, "requestJsonArray.toString()");
                    d0Var.d("    " + str, jSONArray3);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.RequestOutputStream");
            }
        }
    }

    static final class g implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19568a;

        g(b bVar) {
            this.f19568a = bVar;
        }

        public final void a(t tVar) {
            JSONObject jSONObject;
            JSONArray jSONArray;
            String str;
            String str2;
            String str3;
            m.f(tVar, "response");
            JSONObject c10 = tVar.c();
            if (c10 != null) {
                jSONObject = c10.optJSONObject("__debug__");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray("messages");
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("message");
                    } else {
                        str = null;
                    }
                    if (optJSONObject != null) {
                        str2 = optJSONObject.optString("type");
                    } else {
                        str2 = null;
                    }
                    if (optJSONObject != null) {
                        str3 = optJSONObject.optString("link");
                    } else {
                        str3 = null;
                    }
                    if (!(str == null || str2 == null)) {
                        w wVar = w.GRAPH_API_DEBUG_INFO;
                        if (m.b(str2, "warning")) {
                            wVar = w.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!p0.Y(str3)) {
                            str = str + " Link: " + str3;
                        }
                        d0.f23283f.b(wVar, GraphRequest.f19536o, str);
                    }
                }
            }
            b bVar = this.f19568a;
            if (bVar != null) {
                bVar.a(tVar);
            }
        }
    }

    public static final class h implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f19569a;

        h(ArrayList arrayList) {
            this.f19569a = arrayList;
        }

        public void a(String str, String str2) {
            m.f(str, "key");
            m.f(str2, "value");
            ArrayList arrayList = this.f19569a;
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{str, URLEncoder.encode(str2, "UTF-8")}, 2));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            arrayList.add(format);
        }
    }

    static {
        String simpleName = GraphRequest.class.getSimpleName();
        m.e(simpleName, "GraphRequest::class.java.simpleName");
        f19536o = simpleName;
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        m.e(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i10 = 0; i10 < nextInt; i10++) {
            sb2.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        String sb3 = sb2.toString();
        m.e(sb3, "buffer.toString()");
        f19537p = sb3;
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, u uVar) {
        this(accessToken, str, bundle, uVar, (b) null, (String) null, 48, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final void A(JSONArray jSONArray, Map map) {
        JSONObject jSONObject = new JSONObject();
        String str = this.f19545d;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.f19547f);
        }
        String str2 = this.f19546e;
        if (str2 != null) {
            jSONObject.put("depends_on", str2);
        }
        String t10 = t();
        jSONObject.put("relative_url", t10);
        jSONObject.put(FirebaseAnalytics.Param.METHOD, this.f19552k);
        AccessToken accessToken = this.f19542a;
        if (accessToken != null) {
            d0.f23283f.d(accessToken.m());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.f19548g.keySet()) {
            Object obj = this.f19548g.get(str3);
            if (f19541t.t(obj)) {
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                arrayList.add(format);
                map.put(format, new a(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.f19544c;
        if (jSONObject2 != null) {
            ArrayList arrayList2 = new ArrayList();
            f19541t.z(jSONObject2, t10, new h(arrayList2));
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private final boolean J() {
        boolean z10;
        String l10 = l();
        if (l10 != null) {
            z10 = j.K(l10, "|", false, 2, (Object) null);
        } else {
            z10 = false;
        }
        if (l10 != null && j.F(l10, "IG", false, 2, (Object) null) && !z10 && x()) {
            return true;
        }
        if (y() || z10) {
            return false;
        }
        return true;
    }

    private final void g() {
        Bundle bundle = this.f19548g;
        if (this.f19553l || !J()) {
            String l10 = l();
            if (l10 != null) {
                bundle.putString("access_token", l10);
            }
        } else {
            bundle.putString("access_token", n());
        }
        if (!bundle.containsKey("access_token") && p0.Y(o.n())) {
            Log.w(f19536o, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
        }
        bundle.putString("sdk", com.alibaba.pdns.f.f17924q);
        bundle.putString("format", "json");
        if (o.C(w.GRAPH_API_DEBUG_INFO)) {
            bundle.putString("debug", "info");
        } else if (o.C(w.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString("debug", "warning");
        }
    }

    private final String h(String str, boolean z10) {
        if (!z10 && this.f19552k == u.POST) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : this.f19548g.keySet()) {
            Object obj = this.f19548g.get(next);
            if (obj == null) {
                obj = "";
            }
            c cVar = f19541t;
            if (cVar.u(obj)) {
                buildUpon.appendQueryParameter(next, cVar.y(obj).toString());
            } else if (this.f19552k != u.GET) {
                b0 b0Var = b0.f709a;
                String format = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                m.e(format, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format);
            }
        }
        String builder = buildUpon.toString();
        m.e(builder, "uriBuilder.toString()");
        return builder;
    }

    private final String l() {
        AccessToken accessToken = this.f19542a;
        if (accessToken != null) {
            if (!this.f19548g.containsKey("access_token")) {
                String m10 = accessToken.m();
                d0.f23283f.d(m10);
                return m10;
            }
        } else if (!this.f19553l && !this.f19548g.containsKey("access_token")) {
            return n();
        }
        return this.f19548g.getString("access_token");
    }

    private final String n() {
        String g10 = o.g();
        String n10 = o.n();
        if (p0.Y(g10) || p0.Y(n10)) {
            p0.f0(f19536o, "Warning: Request without access token missing application ID or client token.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (g10 != null) {
            sb2.append(g10);
            sb2.append("|");
            if (n10 != null) {
                sb2.append(n10);
                return sb2.toString();
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final String q() {
        if (f19539r.matcher(this.f19543b).matches()) {
            return this.f19543b;
        }
        b0 b0Var = b0.f709a;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{this.f19550i, this.f19543b}, 2));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String w(String str) {
        if (!y()) {
            str = i0.f();
        }
        b0 b0Var = b0.f709a;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{str, q()}, 2));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final boolean x() {
        if (this.f19543b == null) {
            return false;
        }
        String str = "^/?" + o.g() + "/?.*";
        if (this.f19554m || Pattern.matches(str, this.f19543b) || Pattern.matches("^/?app/?.*", this.f19543b)) {
            return true;
        }
        return false;
    }

    private final boolean y() {
        if (!m.b(o.s(), "instagram.com")) {
            return true;
        }
        return !x();
    }

    public static final GraphRequest z(AccessToken accessToken, d dVar) {
        return f19541t.w(accessToken, dVar);
    }

    public final void B(b bVar) {
        if (o.C(w.GRAPH_API_DEBUG_INFO) || o.C(w.GRAPH_API_DEBUG_WARNING)) {
            this.f19551j = new g(bVar);
        } else {
            this.f19551j = bVar;
        }
    }

    public final void C(boolean z10) {
        this.f19554m = z10;
    }

    public final void D(JSONObject jSONObject) {
        this.f19544c = jSONObject;
    }

    public final void E(u uVar) {
        if (this.f19555n == null || uVar == u.GET) {
            if (uVar == null) {
                uVar = u.GET;
            }
            this.f19552k = uVar;
            return;
        }
        throw new l("Can't change HTTP method on request with overridden URL.");
    }

    public final void F(Bundle bundle) {
        m.f(bundle, "<set-?>");
        this.f19548g = bundle;
    }

    public final void G(boolean z10) {
        this.f19553l = z10;
    }

    public final void H(Object obj) {
        this.f19549h = obj;
    }

    public final void I(String str) {
        this.f19550i = str;
    }

    public final t i() {
        return f19541t.f(this);
    }

    public final r j() {
        return f19541t.l(this);
    }

    public final AccessToken k() {
        return this.f19542a;
    }

    public final b m() {
        return this.f19551j;
    }

    public final JSONObject o() {
        return this.f19544c;
    }

    public final String p() {
        return this.f19543b;
    }

    public final u r() {
        return this.f19552k;
    }

    public final Bundle s() {
        return this.f19548g;
    }

    public final String t() {
        if (this.f19555n == null) {
            String w10 = w(i0.g());
            g();
            Uri parse = Uri.parse(h(w10, true));
            b0 b0Var = b0.f709a;
            m.e(parse, "uri");
            String format = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
            m.e(format, "java.lang.String.format(format, *args)");
            return format;
        }
        throw new l("Can't override URL for a batch request");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{Request: ");
        sb2.append(" accessToken: ");
        Object obj = this.f19542a;
        if (obj == null) {
            obj = "null";
        }
        sb2.append(obj);
        sb2.append(", graphPath: ");
        sb2.append(this.f19543b);
        sb2.append(", graphObject: ");
        sb2.append(this.f19544c);
        sb2.append(", httpMethod: ");
        sb2.append(this.f19552k);
        sb2.append(", parameters: ");
        sb2.append(this.f19548g);
        sb2.append("}");
        String sb3 = sb2.toString();
        m.e(sb3, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return sb3;
    }

    public final Object u() {
        return this.f19549h;
    }

    public final String v() {
        String str;
        String str2 = this.f19555n;
        if (str2 != null) {
            return String.valueOf(str2);
        }
        String str3 = this.f19543b;
        if (this.f19552k != u.POST || str3 == null || !j.p(str3, "/videos", false, 2, (Object) null)) {
            str = i0.h(o.s());
        } else {
            str = i0.i();
        }
        String w10 = w(str);
        g();
        return h(w10, false);
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, u uVar, b bVar) {
        this(accessToken, str, bundle, uVar, bVar, (String) null, 32, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GraphRequest(com.facebook.AccessToken r6, java.lang.String r7, android.os.Bundle r8, com.facebook.u r9, com.facebook.GraphRequest.b r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.<init>(com.facebook.AccessToken, java.lang.String, android.os.Bundle, com.facebook.u, com.facebook.GraphRequest$b, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, u uVar, b bVar, String str2) {
        this.f19547f = true;
        this.f19542a = accessToken;
        this.f19543b = str;
        this.f19550i = str2;
        B(bVar);
        E(uVar);
        if (bundle != null) {
            this.f19548g = new Bundle(bundle);
        } else {
            this.f19548g = new Bundle();
        }
        if (this.f19550i == null) {
            this.f19550i = o.r();
        }
    }
}
