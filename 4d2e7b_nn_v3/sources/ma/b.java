package ma;

import com.onesignal.c2;
import com.onesignal.g3;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import na.a;
import na.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, c2 c2Var, g3 g3Var) {
        super(cVar, c2Var, g3Var);
        m.f(cVar, "dataRepository");
        m.f(c2Var, "logger");
        m.f(g3Var, "timeProvider");
    }

    public void a(JSONObject jSONObject, a aVar) {
        m.f(jSONObject, "jsonObject");
        m.f(aVar, "influence");
    }

    public void b() {
        c k10 = k();
        if (k10 == null) {
            k10 = c.UNATTRIBUTED;
        }
        c f10 = f();
        if (k10 == c.DIRECT) {
            k10 = c.INDIRECT;
        }
        f10.a(k10);
    }

    public int c() {
        return f().g();
    }

    public na.b d() {
        return na.b.IAM;
    }

    public String h() {
        return "iam_id";
    }

    public int i() {
        return f().f();
    }

    public JSONArray l() {
        return f().h();
    }

    public JSONArray m(String str) {
        try {
            JSONArray l10 = l();
            try {
                JSONArray jSONArray = new JSONArray();
                int length = l10.length();
                if (length > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        if (!m.b(str, l10.getJSONObject(i10).getString(h()))) {
                            jSONArray.put(l10.getJSONObject(i10));
                        }
                        if (i11 >= length) {
                            break;
                        }
                        i10 = i11;
                    }
                }
                return jSONArray;
            } catch (JSONException e10) {
                o().a("Generating tracker lastChannelObjectReceived get JSONObject ", e10);
                return l10;
            }
        } catch (JSONException e11) {
            o().a("Generating IAM tracker getLastChannelObjects JSONObject ", e11);
            return new JSONArray();
        }
    }

    public void p() {
        c e10 = f().e();
        if (e10.e()) {
            x(n());
        }
        Unit unit = Unit.f12577a;
        y(e10);
        o().b(m.n("OneSignal InAppMessageTracker initInfluencedTypeFromCache: ", this));
    }

    public void u(JSONArray jSONArray) {
        m.f(jSONArray, "channelObjects");
        f().p(jSONArray);
    }
}
