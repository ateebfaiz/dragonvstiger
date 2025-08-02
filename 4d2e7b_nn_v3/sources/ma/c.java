package ma;

import com.onesignal.a4;
import com.onesignal.y2;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import org.json.JSONArray;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final y2 f12820a;

    public c(y2 y2Var) {
        m.f(y2Var, "preferences");
        this.f12820a = y2Var;
    }

    public final void a(na.c cVar) {
        m.f(cVar, "influenceType");
        y2 y2Var = this.f12820a;
        y2Var.i(y2Var.f(), "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", cVar.toString());
    }

    public final void b(na.c cVar) {
        m.f(cVar, "influenceType");
        y2 y2Var = this.f12820a;
        y2Var.i(y2Var.f(), "PREFS_OS_OUTCOMES_CURRENT_SESSION", cVar.toString());
    }

    public final void c(String str) {
        y2 y2Var = this.f12820a;
        y2Var.i(y2Var.f(), "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", str);
    }

    public final String d() {
        y2 y2Var = this.f12820a;
        return y2Var.e(y2Var.f(), "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", (String) null);
    }

    public final na.c e() {
        String obj = na.c.UNATTRIBUTED.toString();
        y2 y2Var = this.f12820a;
        return na.c.f12839a.a(y2Var.e(y2Var.f(), "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", obj));
    }

    public final int f() {
        y2 y2Var = this.f12820a;
        return y2Var.d(y2Var.f(), "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW", 1440);
    }

    public final int g() {
        y2 y2Var = this.f12820a;
        return y2Var.d(y2Var.f(), "PREFS_OS_IAM_LIMIT", 10);
    }

    public final JSONArray h() {
        JSONArray jSONArray;
        y2 y2Var = this.f12820a;
        String e10 = y2Var.e(y2Var.f(), "PREFS_OS_LAST_IAMS_RECEIVED", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (e10 == null) {
            jSONArray = null;
        } else {
            jSONArray = new JSONArray(e10);
        }
        if (jSONArray == null) {
            return new JSONArray();
        }
        return jSONArray;
    }

    public final JSONArray i() {
        JSONArray jSONArray;
        y2 y2Var = this.f12820a;
        String e10 = y2Var.e(y2Var.f(), "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (e10 == null) {
            jSONArray = null;
        } else {
            jSONArray = new JSONArray(e10);
        }
        if (jSONArray == null) {
            return new JSONArray();
        }
        return jSONArray;
    }

    public final na.c j() {
        y2 y2Var = this.f12820a;
        return na.c.f12839a.a(y2Var.e(y2Var.f(), "PREFS_OS_OUTCOMES_CURRENT_SESSION", na.c.UNATTRIBUTED.toString()));
    }

    public final int k() {
        y2 y2Var = this.f12820a;
        return y2Var.d(y2Var.f(), "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", 1440);
    }

    public final int l() {
        y2 y2Var = this.f12820a;
        return y2Var.d(y2Var.f(), "PREFS_OS_NOTIFICATION_LIMIT", 10);
    }

    public final boolean m() {
        y2 y2Var = this.f12820a;
        return y2Var.j(y2Var.f(), "PREFS_OS_DIRECT_ENABLED", false);
    }

    public final boolean n() {
        y2 y2Var = this.f12820a;
        return y2Var.j(y2Var.f(), "PREFS_OS_INDIRECT_ENABLED", false);
    }

    public final boolean o() {
        y2 y2Var = this.f12820a;
        return y2Var.j(y2Var.f(), "PREFS_OS_UNATTRIBUTED_ENABLED", false);
    }

    public final void p(JSONArray jSONArray) {
        m.f(jSONArray, "iams");
        y2 y2Var = this.f12820a;
        y2Var.i(y2Var.f(), "PREFS_OS_LAST_IAMS_RECEIVED", jSONArray.toString());
    }

    public final void q(a4.e eVar) {
        m.f(eVar, "influenceParams");
        y2 y2Var = this.f12820a;
        y2Var.b(y2Var.f(), "PREFS_OS_DIRECT_ENABLED", eVar.e());
        y2 y2Var2 = this.f12820a;
        y2Var2.b(y2Var2.f(), "PREFS_OS_INDIRECT_ENABLED", eVar.f());
        y2 y2Var3 = this.f12820a;
        y2Var3.b(y2Var3.f(), "PREFS_OS_UNATTRIBUTED_ENABLED", eVar.g());
        y2 y2Var4 = this.f12820a;
        y2Var4.a(y2Var4.f(), "PREFS_OS_NOTIFICATION_LIMIT", eVar.d());
        y2 y2Var5 = this.f12820a;
        y2Var5.a(y2Var5.f(), "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW", eVar.c());
        y2 y2Var6 = this.f12820a;
        y2Var6.a(y2Var6.f(), "PREFS_OS_IAM_LIMIT", eVar.a());
        y2 y2Var7 = this.f12820a;
        y2Var7.a(y2Var7.f(), "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW", eVar.b());
    }

    public final void r(JSONArray jSONArray) {
        m.f(jSONArray, "notifications");
        y2 y2Var = this.f12820a;
        y2Var.i(y2Var.f(), "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", jSONArray.toString());
    }
}
