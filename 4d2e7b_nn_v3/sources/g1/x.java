package g1;

import android.text.TextUtils;
import d2.i;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class x implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f21614a;

    /* renamed from: b  reason: collision with root package name */
    public String f21615b;

    public x(String str, String str2) {
        this.f21614a = str;
        this.f21615b = str2;
    }

    public static x a(JSONObject jSONObject) {
        return new x(i.j(jSONObject), jSONObject.optString("override_msg_id"));
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", this.f21614a);
            jSONObject.put("override_msg_id", this.f21615b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (TextUtils.isEmpty(this.f21614a) || TextUtils.isEmpty(xVar.f21614a) || !TextUtils.equals(this.f21614a, xVar.f21614a)) {
            return false;
        }
        if (TextUtils.isEmpty(this.f21615b) && TextUtils.isEmpty(xVar.f21615b)) {
            return true;
        }
        if (TextUtils.isEmpty(this.f21615b) || TextUtils.isEmpty(xVar.f21615b) || !TextUtils.equals(this.f21615b, xVar.f21615b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "msg_id = " + this.f21614a + ",  override_msg_id = " + this.f21615b;
    }
}
