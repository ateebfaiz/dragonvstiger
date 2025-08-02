package o;

import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import i.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r.d;
import r.f;
import r.j;
import w.d;

public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final String f22843g = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final c f22844a;

    /* renamed from: b  reason: collision with root package name */
    public String f22845b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f22846c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f22847d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f22848e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f22849f = "";

    public class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22850a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22851b;

        public a(c cVar, a aVar) {
            this.f22850a = cVar;
            this.f22851b = aVar;
        }

        public void OooO00o() {
            String unused = b.f22843g;
            this.f22850a.a(this.f22851b);
        }

        public void e() {
            String unused = b.f22843g;
        }
    }

    /* renamed from: o.b$b  reason: collision with other inner class name */
    public static class C0314b extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final a f22853i;

        /* renamed from: j  reason: collision with root package name */
        public final String f22854j;

        /* renamed from: k  reason: collision with root package name */
        public final String f22855k;

        /* renamed from: l  reason: collision with root package name */
        public final String f22856l;

        /* renamed from: m  reason: collision with root package name */
        public final String f22857m;

        /* renamed from: n  reason: collision with root package name */
        public final String f22858n;

        /* renamed from: o  reason: collision with root package name */
        public final c f22859o;

        public C0314b(a aVar, String str, String str2, String str3, String str4, String str5, String str6, c cVar) {
            super("mahx-crash", "crash.gzip", new j(b.e(aVar.f22838d, aVar.f22840f)), 2, str);
            this.f22853i = aVar;
            this.f22858n = str6;
            this.f22857m = str5;
            this.f22856l = str4;
            this.f22855k = str3;
            this.f22854j = str2;
            this.f22859o = cVar;
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f22859o.j());
        }

        public Map c() {
            HashMap hashMap = new HashMap(12);
            hashMap.put("fromSDK", String.valueOf(this.f22853i.f22837c));
            hashMap.put("summary", this.f22853i.f22838d.f22875a);
            hashMap.put("packageName", this.f22854j);
            hashMap.put("timestamp", String.valueOf(this.f22853i.f22836b));
            hashMap.put("platform", this.f22855k);
            hashMap.put("model", this.f22856l);
            hashMap.put("appVersion", this.f22853i.f22842h);
            hashMap.put("sdkVersion", this.f22853i.f22841g);
            hashMap.put("isNative", String.valueOf(this.f22853i.f22839e));
            hashMap.put("isUncaught", String.valueOf(!this.f22853i.f22840f));
            hashMap.put("imei", this.f22857m);
            hashMap.put("abi", this.f22858n);
            return hashMap;
        }
    }

    public b(c cVar) {
        this.f22844a = cVar;
        f();
    }

    public static String e(h hVar, boolean z10) {
        String str = hVar.f22876b;
        if (z10) {
            str = str + "\nmahextra:";
        }
        if (TextUtils.isEmpty(hVar.f22877c)) {
            return str;
        }
        return str + hVar.f22877c;
    }

    public final String c(boolean z10) {
        if (z10) {
            return this.f22844a.f().a();
        }
        return this.f22844a.f().b();
    }

    public void d(a aVar, c cVar, boolean z10) {
        f.c().m(new r.d(new C0314b(aVar, c(z10), this.f22845b, this.f22846c, this.f22847d, this.f22848e, this.f22849f, this.f22844a), new a(cVar, aVar)));
    }

    public final void f() {
        this.f22845b = this.f22844a.j().h();
        this.f22848e = OooO00o.OooO0OO(this.f22844a.b());
        this.f22846c = OooO00o.OooO0Oo();
        this.f22847d = OooO00o.OooO0O0();
        this.f22849f = v.c();
    }
}
