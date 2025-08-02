package n;

import android.content.Context;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import i.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r.d;
import r.f;
import r.g;
import r.j;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f22643a;

    /* renamed from: b  reason: collision with root package name */
    public String f22644b;

    /* renamed from: c  reason: collision with root package name */
    public String f22645c;

    /* renamed from: d  reason: collision with root package name */
    public String f22646d;

    /* renamed from: e  reason: collision with root package name */
    public String f22647e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c f22648f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f22649g;

    public class a implements d.a {
        public a() {
        }

        public void OooO00o() {
            String str = m.b.f22462j;
        }

        public void e() {
            String str = m.b.f22462j;
        }
    }

    public static class b extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final d.c f22651i;

        /* renamed from: j  reason: collision with root package name */
        public final String f22652j;

        /* renamed from: k  reason: collision with root package name */
        public final String f22653k;

        /* renamed from: l  reason: collision with root package name */
        public final String f22654l;

        /* renamed from: m  reason: collision with root package name */
        public final String f22655m;

        /* renamed from: n  reason: collision with root package name */
        public final String f22656n;

        public b(g gVar, d.c cVar, boolean z10, String str, String str2, String str3, String str4, String str5) {
            super("mah-abnormal-ndk-access", "ndk-abnormal-access.log", gVar, 2, e(cVar, z10));
            this.f22651i = cVar;
            this.f22652j = str;
            this.f22653k = str2;
            this.f22654l = str3;
            this.f22655m = str4;
            this.f22656n = str5;
        }

        public static String e(d.c cVar, boolean z10) {
            e f10 = cVar.f();
            if (z10) {
                return f10.a();
            }
            return f10.b();
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f22651i.j());
        }

        public Map c() {
            HashMap hashMap = new HashMap(8);
            hashMap.put("packageName", this.f22651i.j().h());
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("platform", this.f22652j);
            hashMap.put("model", this.f22653k);
            hashMap.put("appVersion", this.f22654l);
            hashMap.put("sdkVersion", this.f22655m);
            hashMap.put("imei", this.f22656n);
            return hashMap;
        }
    }

    public c(Context context, d.c cVar) {
        this.f22649g = context;
        this.f22648f = cVar;
        a();
    }

    public final void a() {
        this.f22643a = OooO00o.OooO0Oo();
        this.f22644b = OooO00o.OooO0O0();
        this.f22645c = OooO00o.OooO00o(this.f22649g);
        this.f22646d = MahProxy.getVersion();
        this.f22647e = this.f22648f.b();
    }

    public void b(String str, boolean z10) {
        String str2 = b.f22628m;
        f.c().m(new d(new b(new j(str), this.f22648f, z10, this.f22643a, this.f22644b, this.f22645c, this.f22646d, this.f22647e), new a()));
    }
}
