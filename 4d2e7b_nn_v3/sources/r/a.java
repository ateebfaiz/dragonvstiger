package r;

import android.text.TextUtils;
import d.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f23552a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23553b = "gzip";

    /* renamed from: c  reason: collision with root package name */
    public final String f23554c = "filename";

    /* renamed from: d  reason: collision with root package name */
    public final g f23555d;

    /* renamed from: e  reason: collision with root package name */
    public final String f23556e = "application/octet-stream";

    /* renamed from: f  reason: collision with root package name */
    public final String f23557f;

    /* renamed from: g  reason: collision with root package name */
    public final int f23558g;

    /* renamed from: h  reason: collision with root package name */
    public final String f23559h;

    public a(String str, String str2, g gVar, int i10, String str3) {
        this.f23552a = str;
        this.f23557f = str2;
        this.f23555d = gVar;
        this.f23558g = i10;
        this.f23559h = str3;
    }

    public static void b(JSONObject jSONObject, g gVar) {
        try {
            if (!TextUtils.isEmpty(gVar.f())) {
                jSONObject.put("appPackageName", gVar.b());
            }
        } catch (JSONException unused) {
        }
    }

    public abstract void a(JSONObject jSONObject);

    public abstract Map c();

    public h d() {
        byte[] b10 = this.f23555d.b(this.f23553b);
        if (b10 == null || b10.length == 0) {
            String str = f.f23569h;
            return null;
        }
        HashMap hashMap = new HashMap(c());
        hashMap.put("sessionId", this.f23559h);
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        hashMap.put("extension", jSONObject.toString());
        return new h(this.f23552a, this.f23553b, this.f23554c, this.f23557f, b10, this.f23556e, hashMap, this.f23558g);
    }
}
