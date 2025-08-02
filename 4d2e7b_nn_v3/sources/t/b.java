package t;

import android.text.TextUtils;
import com.mah.sdk.OooO00o;
import d.c;
import d.k;
import i.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r.d;
import r.f;
import r.g;
import r.j;
import w.d;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f23922c = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final k f23923a;

    /* renamed from: b  reason: collision with root package name */
    public final c f23924b;

    public class a implements d.a {
        public a() {
        }

        public void OooO00o() {
            String unused = b.f23922c;
        }

        public void e() {
            String unused = b.f23922c;
        }
    }

    /* renamed from: t.b$b  reason: collision with other inner class name */
    public static class C0335b extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final k f23926i;

        /* renamed from: j  reason: collision with root package name */
        public final c f23927j;

        public C0335b(g gVar, k kVar, c cVar) {
            super("mah-dns", "dns.gzip", gVar, 2, cVar.f().b());
            this.f23926i = kVar;
            this.f23927j = cVar;
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f23927j.j());
        }

        public Map c() {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String h10 = this.f23927j.j().h();
            String a10 = this.f23926i.f().a();
            String OooO0Oo = OooO00o.OooO0Oo(this.f23926i.OooO00o());
            HashMap hashMap = new HashMap(8);
            hashMap.put("platform", OooO00o.OooO0Oo());
            hashMap.put("imei", w.f(this.f23927j.b(), OooO00o.OooO0OO()));
            hashMap.put("imsi", w.f(OooO0Oo, OooO00o.OooO0OO()));
            hashMap.put("packageName", h10);
            hashMap.put("timestamp", valueOf);
            hashMap.put("networkType", a10);
            String unused = b.f23922c;
            hashMap.toString();
            return hashMap;
        }
    }

    public b(k kVar, c cVar) {
        this.f23923a = kVar;
        this.f23924b = cVar;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            f.c().m(new r.d(new C0335b(new j(str), this.f23923a, this.f23924b), new a()));
        }
    }
}
