package e;

import android.text.TextUtils;
import com.zing.zalo.zalosdk.common.Constant;
import i.p;
import org.json.JSONException;
import org.json.JSONObject;
import w.d;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f21079a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f21080b;

    /* renamed from: c  reason: collision with root package name */
    public final String f21081c;

    /* renamed from: d  reason: collision with root package name */
    public final String f21082d;

    public enum a {
        SUCCESS(0),
        DATA_NO_CHANGE(1),
        SERVER_ERROR(2),
        APPLICATION_NOT_REGISTERED(3),
        FINGERPRINT_ERROR(4),
        PARAMETER_ERROR(5),
        UNKNOWN_SERVER_ERROR(100),
        NOT_FOUND(-1);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f21092a;

        /* access modifiers changed from: public */
        a(int i10) {
            this.f21092a = i10;
        }
    }

    public j(int i10, JSONObject jSONObject, String str, String str2) {
        this.f21079a = i10;
        this.f21080b = jSONObject;
        this.f21081c = str;
        this.f21082d = str2;
    }

    public static j b(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt(Constant.PARAM_OAUTH_CODE, a.NOT_FOUND.f21092a);
        JSONObject optJSONObject = jSONObject.optJSONObject("configuration");
        String optString = jSONObject.optString("errorMsg", "");
        if (optJSONObject != null) {
            c(optJSONObject);
        }
        return new j(optInt, optJSONObject, optString, str2);
    }

    public static void c(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("contentMD5", ""))) {
            jSONObject.remove("contentMD5");
            String b10 = p.b(jSONObject.toString());
            if (!TextUtils.isEmpty(b10)) {
                try {
                    jSONObject.putOpt("contentMD5", b10);
                    d.j();
                } catch (JSONException e10) {
                    e10.getMessage();
                }
            }
        }
    }

    public static String d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("contentMD5", "");
        }
        return "";
    }

    public a a() {
        for (a aVar : a.values()) {
            if (aVar.f21092a == this.f21079a) {
                return aVar;
            }
        }
        return a.NOT_FOUND;
    }

    public JSONObject e() {
        return this.f21080b;
    }

    public String f() {
        return d(this.f21080b);
    }

    public void g(JSONObject jSONObject) {
        this.f21080b = jSONObject;
    }

    public String h() {
        return this.f21081c;
    }
}
