package l;

import android.content.Context;
import android.text.TextUtils;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import d.k;
import i.v;
import i.w;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import r.d;
import r.f;
import r.g;
import r.j;
import w.d;

public class e implements b {

    /* renamed from: k  reason: collision with root package name */
    public static final String f22348k = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final StringBuilder f22349a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    public final k f22350b;

    /* renamed from: c  reason: collision with root package name */
    public final h.e f22351c;

    /* renamed from: d  reason: collision with root package name */
    public int f22352d;

    /* renamed from: e  reason: collision with root package name */
    public int f22353e;

    /* renamed from: f  reason: collision with root package name */
    public int f22354f;

    /* renamed from: g  reason: collision with root package name */
    public int f22355g;

    /* renamed from: h  reason: collision with root package name */
    public int f22356h;

    /* renamed from: i  reason: collision with root package name */
    public final d.c f22357i;

    /* renamed from: j  reason: collision with root package name */
    public c f22358j;

    public class a implements d.a {
        public a() {
        }

        public void OooO00o() {
            String unused = e.f22348k;
            OooO00o.OooO00o(e.this.f22350b, "accesslog report success");
        }

        public void e() {
            String unused = e.f22348k;
            OooO00o.OooO00o(e.this.f22350b, "accesslog report failure");
        }
    }

    public static class b extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final k f22360i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f22361j;

        /* renamed from: k  reason: collision with root package name */
        public final c f22362k;

        /* renamed from: l  reason: collision with root package name */
        public final d.c f22363l;

        public b(g gVar, k kVar, d.c cVar, boolean z10, c cVar2) {
            super("mahx-client", "access.gzip", gVar, 0, cVar.f().b());
            this.f22363l = cVar;
            this.f22361j = z10;
            this.f22360i = kVar;
            this.f22362k = cVar2;
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f22363l.j());
        }

        public Map c() {
            int i10 = this.f22360i.o().f21787m;
            String a10 = this.f22360i.f().a();
            List n10 = v.n(this.f22360i.OooO00o());
            String i11 = v.i();
            String str = this.f22362k.f22367d;
            HashMap hashMap = new HashMap(20);
            hashMap.put("version", String.valueOf(this.f22362k.f22364a));
            hashMap.put("imei", this.f22362k.f22365b);
            hashMap.put("imsi", this.f22362k.f22366c);
            hashMap.put("packageName", str);
            hashMap.put("networkType", a10);
            hashMap.put("viaProxy", String.valueOf(!this.f22360i.s()));
            hashMap.put("serviceType", String.valueOf(i10));
            hashMap.put("timestamp", i11);
            hashMap.put("platform", this.f22362k.f22368e);
            hashMap.put("appVersion", this.f22362k.f22369f);
            hashMap.put("resolution", this.f22362k.f22370g);
            hashMap.put("sdkVersion", this.f22362k.f22371h);
            hashMap.put("reportFirstTime", String.valueOf(this.f22361j));
            hashMap.put("model", this.f22362k.f22372i);
            hashMap.put("edgeChanged", "false");
            hashMap.put("dnsList", i.d.a(n10).toString());
            String unused = e.f22348k;
            hashMap.toString();
            return hashMap;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f22364a;

        /* renamed from: b  reason: collision with root package name */
        public String f22365b;

        /* renamed from: c  reason: collision with root package name */
        public String f22366c;

        /* renamed from: d  reason: collision with root package name */
        public String f22367d;

        /* renamed from: e  reason: collision with root package name */
        public String f22368e;

        /* renamed from: f  reason: collision with root package name */
        public String f22369f;

        /* renamed from: g  reason: collision with root package name */
        public String f22370g;

        /* renamed from: h  reason: collision with root package name */
        public String f22371h;

        /* renamed from: i  reason: collision with root package name */
        public String f22372i;
    }

    public e(h.e eVar, k kVar, d.c cVar) {
        this.f22351c = eVar;
        this.f22350b = kVar;
        this.f22357i = cVar;
        this.f22353e = g();
        this.f22352d = 0;
        this.f22354f = 0;
        this.f22356h = 0;
        this.f22355g = -1;
        h();
    }

    public static String c(Context context) {
        OooO00o.OooO0OO OooO0OO = OooO00o.OooO0OO(context);
        return String.format(Locale.US, "%d*%d", new Object[]{Integer.valueOf(OooO0OO.OooO00o), Integer.valueOf(OooO0OO.OooO0O0)});
    }

    public void a(c cVar) {
        String str = cVar.f22343a;
        if (!TextUtils.isEmpty(str) && this.f22353e > 0 && f()) {
            StringBuilder sb2 = this.f22349a;
            sb2.append(str);
            sb2.append("\n");
            int i10 = this.f22354f + 1;
            this.f22354f = i10;
            if (i10 == this.f22353e) {
                d(this.f22349a.toString(), this.f22353e);
                this.f22352d += this.f22353e;
                this.f22354f = 0;
                StringBuilder sb3 = this.f22349a;
                sb3.delete(0, sb3.length());
                int g10 = g();
                this.f22353e = g10;
                if (g10 == 0) {
                    a.a().e(this);
                }
            }
        }
    }

    public final void d(String str, int i10) {
        boolean z10;
        j jVar = new j(str);
        k kVar = this.f22350b;
        d.c cVar = this.f22357i;
        if (this.f22352d == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f.c().m(new r.d(new b(jVar, kVar, cVar, z10, this.f22358j), new a()));
    }

    public boolean e(h.e eVar) {
        return this.f22351c.b(eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean f() {
        /*
            r5 = this;
            monitor-enter(r5)
            h.e r0 = r5.f22351c     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.g()     // Catch:{ all -> 0x0026 }
            r1 = 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return r1
        L_0x000c:
            h.e r0 = r5.f22351c     // Catch:{ all -> 0x0026 }
            h.e$a r0 = r0.a()     // Catch:{ all -> 0x0026 }
            int r0 = r0.a()     // Catch:{ all -> 0x0026 }
            int r2 = r5.f22356h     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0028
            java.util.Random r2 = i.v.l()     // Catch:{ all -> 0x0026 }
            int r2 = r2.nextInt(r0)     // Catch:{ all -> 0x0026 }
            int r2 = r2 + r1
            r5.f22355g = r2     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x0041
        L_0x0028:
            int r2 = r5.f22356h     // Catch:{ all -> 0x0026 }
            int r2 = r2 + r1
            r5.f22356h = r2     // Catch:{ all -> 0x0026 }
            int r3 = r5.f22355g     // Catch:{ all -> 0x0026 }
            r4 = 0
            if (r2 >= r3) goto L_0x0033
            goto L_0x003e
        L_0x0033:
            if (r2 != r3) goto L_0x003a
            if (r2 != r0) goto L_0x003f
            r5.f22356h = r4     // Catch:{ all -> 0x0026 }
            goto L_0x003f
        L_0x003a:
            if (r2 != r0) goto L_0x003e
            r5.f22356h = r4     // Catch:{ all -> 0x0026 }
        L_0x003e:
            r1 = r4
        L_0x003f:
            monitor-exit(r5)
            return r1
        L_0x0041:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.e.f():boolean");
    }

    public final int g() {
        int i10;
        int c10 = this.f22351c.c();
        int f10 = this.f22351c.f();
        if (!this.f22351c.e() && (i10 = f10 - this.f22352d) <= c10) {
            return i10;
        }
        return c10;
    }

    public final void h() {
        Context OooO00o = this.f22350b.OooO00o();
        d.g j10 = this.f22357i.j();
        String OooO0OO = OooO00o.OooO0OO(this.f22357i.b());
        String f10 = w.f(OooO00o.OooO0OO(OooO00o, "unknown"), OooO00o.OooO0OO());
        c cVar = new c();
        this.f22358j = cVar;
        cVar.f22364a = 11;
        cVar.f22369f = OooO00o.OooO00o(OooO00o);
        this.f22358j.f22367d = j10.h();
        c cVar2 = this.f22358j;
        cVar2.f22365b = OooO0OO;
        cVar2.f22366c = f10;
        cVar2.f22372i = OooO00o.OooO0O0();
        this.f22358j.f22368e = OooO00o.OooO0Oo();
        this.f22358j.f22370g = c(OooO00o);
        this.f22358j.f22371h = MahProxy.getVersion();
    }
}
