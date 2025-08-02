package q;

import com.mah.sdk.OooO00o;
import d.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r.d;
import r.f;
import w.d;

public class g {

    /* renamed from: f  reason: collision with root package name */
    public static final String f23156f = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final c f23157a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23158b;

    /* renamed from: c  reason: collision with root package name */
    public final String f23159c = OooO00o.OooO0O0();

    /* renamed from: d  reason: collision with root package name */
    public final String f23160d = OooO00o.OooO0Oo();

    /* renamed from: e  reason: collision with root package name */
    public final String f23161e;

    public class a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f23162a;

        public a(File file) {
            this.f23162a = file;
        }

        public void OooO00o() {
            this.f23162a.delete();
            String unused = g.f23156f;
            this.f23162a.getAbsolutePath();
        }

        public void e() {
            String unused = g.f23156f;
            this.f23162a.getAbsolutePath();
        }
    }

    public static class b extends r.a {

        /* renamed from: i  reason: collision with root package name */
        public final String f23164i;

        /* renamed from: j  reason: collision with root package name */
        public final String f23165j;

        /* renamed from: k  reason: collision with root package name */
        public final String f23166k;

        /* renamed from: l  reason: collision with root package name */
        public final String f23167l;

        /* renamed from: m  reason: collision with root package name */
        public final c f23168m;

        public b(r.g gVar, String str, String str2, String str3, String str4, c cVar) {
            super("mah-event", "eventlog.gzip", gVar, 1, cVar.f().a());
            this.f23164i = str;
            this.f23165j = str2;
            this.f23166k = str3;
            this.f23167l = str4;
            this.f23168m = cVar;
        }

        public void a(JSONObject jSONObject) {
            r.a.b(jSONObject, this.f23168m.j());
        }

        public Map c() {
            HashMap hashMap = new HashMap(8);
            hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            hashMap.put("packageName", this.f23164i);
            hashMap.put("imei", OooO00o.OooO0OO(this.f23165j));
            hashMap.put("model", this.f23166k);
            hashMap.put("platform", this.f23167l);
            String unused = g.f23156f;
            hashMap.toString();
            return hashMap;
        }
    }

    public g(c cVar) {
        this.f23157a = cVar;
        this.f23158b = cVar.j().h();
        this.f23161e = cVar.b();
    }

    public void b(File file) {
        f.c().m(new r.d(new b(new r.c(file), this.f23158b, this.f23161e, this.f23159c, this.f23160d, this.f23157a), new a(file)));
    }
}
