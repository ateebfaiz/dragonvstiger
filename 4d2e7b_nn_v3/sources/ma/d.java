package ma;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.onesignal.c2;
import com.onesignal.g3;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import na.a;
import na.b;
import na.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar, c2 c2Var, g3 g3Var) {
        super(cVar, c2Var, g3Var);
        m.f(cVar, "dataRepository");
        m.f(c2Var, "logger");
        m.f(g3Var, "timeProvider");
    }

    public void a(JSONObject jSONObject, a aVar) {
        m.f(jSONObject, "jsonObject");
        m.f(aVar, "influence");
        if (aVar.d().b()) {
            try {
                jSONObject.put(DevicePublicKeyStringDef.DIRECT, aVar.d().c());
                jSONObject.put("notification_ids", aVar.b());
            } catch (JSONException e10) {
                o().a("Generating notification tracker addSessionData JSONObject ", e10);
            }
        }
    }

    public void b() {
        c f10 = f();
        c k10 = k();
        if (k10 == null) {
            k10 = c.UNATTRIBUTED;
        }
        f10.b(k10);
        f().c(g());
    }

    public int c() {
        return f().l();
    }

    public b d() {
        return b.NOTIFICATION;
    }

    public String h() {
        return "notification_id";
    }

    public int i() {
        return f().k();
    }

    public JSONArray l() {
        return f().i();
    }

    public JSONArray m(String str) {
        try {
            return l();
        } catch (JSONException e10) {
            o().a("Generating Notification tracker getLastChannelObjects JSONObject ", e10);
            return new JSONArray();
        }
    }

    public void p() {
        c j10 = f().j();
        if (j10.e()) {
            x(n());
        } else if (j10.c()) {
            w(f().d());
        }
        Unit unit = Unit.f12577a;
        y(j10);
        o().b(m.n("OneSignal NotificationTracker initInfluencedTypeFromCache: ", this));
    }

    public void u(JSONArray jSONArray) {
        m.f(jSONArray, "channelObjects");
        f().r(jSONArray);
    }
}
