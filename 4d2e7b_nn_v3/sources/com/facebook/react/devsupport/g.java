package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.a;
import d7.e;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final x6.a f3081a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d7.d f3082b;

    /* renamed from: c  reason: collision with root package name */
    private final OkHttpClient f3083c;

    /* renamed from: d  reason: collision with root package name */
    private final a f3084d;

    /* renamed from: e  reason: collision with root package name */
    private final r0 f3085e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f3086f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f3087g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public d7.b f3088h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public i0 f3089i;

    class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f3090a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3091b;

        /* renamed from: com.facebook.react.devsupport.g$a$a  reason: collision with other inner class name */
        class C0049a extends d7.c {
            C0049a() {
            }

            public void a(Object obj) {
                a.this.f3090a.d();
            }
        }

        class b extends d7.c {
            b() {
            }

            public void a(Object obj) {
                a.this.f3090a.c();
            }
        }

        class c extends d7.g {
            c() {
            }

            public void b(Object obj, d7.h hVar) {
                a.this.f3090a.b(hVar);
            }
        }

        class d implements e.b {
            d() {
            }

            public void a() {
                a.this.f3090a.a();
            }

            public void b() {
                a.this.f3090a.e();
            }
        }

        a(h hVar, String str) {
            this.f3090a = hVar;
            this.f3091b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            HashMap hashMap = new HashMap();
            hashMap.put("reload", new C0049a());
            hashMap.put("devMenu", new b());
            hashMap.put("captureHeap", new c());
            Map f10 = this.f3090a.f();
            if (f10 != null) {
                hashMap.putAll(f10);
            }
            hashMap.putAll(new d7.a().d());
            g.this.f3088h = new d7.b(this.f3091b, g.this.f3082b, hashMap, new d());
            g.this.f3088h.f();
            return null;
        }
    }

    class b extends AsyncTask {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            if (g.this.f3088h != null) {
                g.this.f3088h.e();
                g.this.f3088h = null;
            }
            return null;
        }
    }

    class c extends AsyncTask {
        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            if (InspectorFlags.getFuseboxEnabled()) {
                g.this.f3089i = new CxxInspectorPackagerConnection(g.this.s(), g.this.f3087g);
            } else {
                g gVar = g.this;
                gVar.f3089i = new j0(gVar.s(), g.this.f3087g);
            }
            g.this.f3089i.connect();
            return null;
        }
    }

    class d extends AsyncTask {
        d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            if (g.this.f3089i != null) {
                g.this.f3089i.closeQuietly();
                g.this.f3089i = null;
            }
            return null;
        }
    }

    class e implements Callback {
        e() {
        }

        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) {
        }
    }

    class f implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactContext f3101a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3102b;

        f(ReactContext reactContext, String str) {
            this.f3101a = reactContext;
            this.f3102b = str;
        }

        public void onFailure(Call call, IOException iOException) {
            o7.c.d(this.f3101a, this.f3102b);
        }

        public void onResponse(Call call, Response response) {
        }
    }

    /* renamed from: com.facebook.react.devsupport.g$g  reason: collision with other inner class name */
    private enum C0050g {
        BUNDLE("bundle"),
        MAP("map");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3107a;

        private C0050g(String str) {
            this.f3107a = str;
        }

        public String b() {
            return this.f3107a;
        }
    }

    public interface h {
        void a();

        void b(d7.h hVar);

        void c();

        void d();

        void e();

        Map f();
    }

    public g(x6.a aVar, Context context, d7.d dVar) {
        this.f3081a = aVar;
        this.f3082b = dVar;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient build = builder.connectTimeout(5000, timeUnit).readTimeout(0, timeUnit).writeTimeout(0, timeUnit).build();
        this.f3083c = build;
        this.f3084d = new a(build);
        this.f3085e = new r0(build);
        this.f3086f = context;
        this.f3087g = context.getPackageName();
    }

    private String j(String str, C0050g gVar) {
        return k(str, gVar, this.f3082b.a());
    }

    private String k(String str, C0050g gVar, String str2) {
        return l(str, gVar, str2, false, true);
    }

    private String l(String str, C0050g gVar, String str2, boolean z10, boolean z11) {
        String str3;
        String str4;
        boolean p10 = p();
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        String b10 = gVar.b();
        Boolean valueOf = Boolean.valueOf(p10);
        Boolean valueOf2 = Boolean.valueOf(p10);
        Boolean valueOf3 = Boolean.valueOf(t());
        String str5 = this.f3087g;
        String str6 = "false";
        if (z10) {
            str3 = "true";
        } else {
            str3 = str6;
        }
        if (z11) {
            str6 = "true";
        }
        sb2.append(String.format(locale, "http://%s/%s.%s?platform=android&dev=%s&lazy=%s&minify=%s&app=%s&modulesOnly=%s&runModule=%s", new Object[]{str2, str, b10, valueOf, valueOf2, valueOf3, str5, str3, str6}));
        if (InspectorFlags.getFuseboxEnabled()) {
            str4 = "&excludeSource=true&sourcePaths=url-server";
        } else {
            str4 = "";
        }
        sb2.append(str4);
        return sb2.toString();
    }

    private String m() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", new Object[]{this.f3082b.a()});
    }

    private boolean p() {
        return this.f3081a.h();
    }

    private String r() {
        String str;
        String str2 = this.f3087g;
        String string = Settings.Secure.getString(this.f3086f.getContentResolver(), "android_id");
        Locale locale = Locale.US;
        if (InspectorFlags.getFuseboxEnabled()) {
            str = "fusebox";
        } else {
            str = "legacy";
        }
        return u(String.format(locale, "android-%s-%s-%s", new Object[]{str2, string, str}));
    }

    /* access modifiers changed from: private */
    public String s() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s&device=%s", new Object[]{this.f3082b.a(), Uri.encode(a7.a.d()), Uri.encode(this.f3087g), Uri.encode(r())});
    }

    private boolean t() {
        return this.f3081a.d();
    }

    private static String u(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.reset();
            try {
                byte[] digest = instance.digest(str.getBytes("UTF-8"));
                return String.format("%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x", new Object[]{Byte.valueOf(digest[0]), Byte.valueOf(digest[1]), Byte.valueOf(digest[2]), Byte.valueOf(digest[3]), Byte.valueOf(digest[4]), Byte.valueOf(digest[5]), Byte.valueOf(digest[6]), Byte.valueOf(digest[7]), Byte.valueOf(digest[8]), Byte.valueOf(digest[9]), Byte.valueOf(digest[10]), Byte.valueOf(digest[11]), Byte.valueOf(digest[12]), Byte.valueOf(digest[13]), Byte.valueOf(digest[14]), Byte.valueOf(digest[15]), Byte.valueOf(digest[16]), Byte.valueOf(digest[17]), Byte.valueOf(digest[18]), Byte.valueOf(digest[19])});
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError("This environment doesn't support UTF-8 encoding", e10);
            }
        } catch (NoSuchAlgorithmException e11) {
            throw new AssertionError("Could not get standard SHA-256 algorithm", e11);
        }
    }

    public void A(String str, h hVar) {
        if (this.f3088h != null) {
            z2.a.G("ReactNative", "Packager connection already open, nooping.");
        } else {
            new a(hVar, str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void h() {
        new d().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void i() {
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void n() {
        i0 i0Var = this.f3089i;
        if (i0Var != null) {
            i0Var.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
        }
    }

    public void o(k6.b bVar, File file, String str, a.c cVar) {
        this.f3084d.e(bVar, file, str, cVar);
    }

    public String q(String str) {
        return k(str, C0050g.BUNDLE, this.f3082b.a());
    }

    public String v(String str) {
        return j(str, C0050g.BUNDLE);
    }

    public void w(k6.g gVar) {
        String a10 = this.f3082b.a();
        if (a10 == null) {
            z2.a.G("ReactNative", "No packager host configured.");
            gVar.a(false);
            return;
        }
        this.f3085e.b(a10, gVar);
    }

    public void x() {
        this.f3083c.newCall(new Request.Builder().url(m()).build()).enqueue(new e());
    }

    public void y(ReactContext reactContext, String str) {
        this.f3083c.newCall(new Request.Builder().url(String.format(Locale.US, "http://%s/open-debugger?appId=%s&device=%s", new Object[]{this.f3082b.a(), Uri.encode(this.f3087g), Uri.encode(r())})).method("POST", RequestBody.create((MediaType) null, "")).build()).enqueue(new f(reactContext, str));
    }

    public void z() {
        if (this.f3089i != null) {
            z2.a.G("ReactNative", "Inspector connection already open, nooping.");
        } else {
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }
}
