package na;

import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private c f12831a;

    /* renamed from: b  reason: collision with root package name */
    private b f12832b;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f12833c;

    public a(String str) {
        m.f(str, "jsonString");
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("influence_channel");
        String string2 = jSONObject.getString("influence_type");
        String string3 = jSONObject.getString("influence_ids");
        this.f12832b = b.f12834b.a(string);
        this.f12831a = c.f12839a.a(string2);
        m.e(string3, "ids");
        this.f12833c = string3.length() == 0 ? null : new JSONArray(string3);
    }

    public final a a() {
        return new a(this.f12832b, this.f12831a, this.f12833c);
    }

    public final JSONArray b() {
        return this.f12833c;
    }

    public final b c() {
        return this.f12832b;
    }

    public final c d() {
        return this.f12831a;
    }

    public final void e(JSONArray jSONArray) {
        this.f12833c = jSONArray;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (m.b(a.class, obj.getClass())) {
                a aVar = (a) obj;
                if (this.f12832b == aVar.f12832b && this.f12831a == aVar.f12831a) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void f(c cVar) {
        m.f(cVar, "<set-?>");
        this.f12831a = cVar;
    }

    public final String g() {
        String str;
        JSONObject put = new JSONObject().put("influence_channel", this.f12832b.toString()).put("influence_type", this.f12831a.toString());
        JSONArray jSONArray = this.f12833c;
        if (jSONArray != null) {
            str = String.valueOf(jSONArray);
        } else {
            str = "";
        }
        String jSONObject = put.put("influence_ids", str).toString();
        m.e(jSONObject, "JSONObject()\n        .pu…e \"\")\n        .toString()");
        return jSONObject;
    }

    public int hashCode() {
        return (this.f12832b.hashCode() * 31) + this.f12831a.hashCode();
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.f12832b + ", influenceType=" + this.f12831a + ", ids=" + this.f12833c + '}';
    }

    public a(b bVar, c cVar, JSONArray jSONArray) {
        m.f(bVar, "influenceChannel");
        m.f(cVar, "influenceType");
        this.f12832b = bVar;
        this.f12831a = cVar;
        this.f12833c = jSONArray;
    }
}
