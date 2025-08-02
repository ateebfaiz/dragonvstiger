package m;

import android.content.Context;
import com.mah.sdk.MahProxy;
import com.mah.sdk.OooO00o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import r.a;
import r.g;

public abstract class c extends a {

    /* renamed from: i  reason: collision with root package name */
    public final String f22472i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f22473j;

    /* renamed from: k  reason: collision with root package name */
    public final d.c f22474k;

    public c(String str, String str2, g gVar, String str3, Context context, d.c cVar) {
        super(str, str2, gVar, 0, cVar.f().b());
        this.f22472i = str3;
        this.f22473j = context;
        this.f22474k = cVar;
    }

    public void a(JSONObject jSONObject) {
        a.b(jSONObject, this.f22474k.j());
    }

    public Map c() {
        String OooO0OO = OooO00o.OooO0OO(this.f22474k.b());
        HashMap hashMap = new HashMap(8);
        hashMap.put("packageName", this.f22474k.j().h());
        hashMap.put("timestamp", this.f22472i);
        hashMap.put("model", OooO00o.OooO0O0());
        hashMap.put("subType", String.valueOf(0));
        hashMap.put("appVersion", OooO00o.OooO00o(this.f22473j));
        hashMap.put("sdkVersion", MahProxy.getVersion());
        hashMap.put("imei", OooO0OO);
        hashMap.put("platform", OooO00o.OooO0Oo());
        String str = b.f22462j;
        hashMap.toString();
        return hashMap;
    }
}
