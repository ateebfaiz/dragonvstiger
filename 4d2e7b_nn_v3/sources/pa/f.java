package pa;

import com.onesignal.p3;
import com.onesignal.r3;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class f extends b {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(p3 p3Var) {
        super(p3Var);
        m.f(p3Var, "client");
    }

    public void a(JSONObject jSONObject, r3 r3Var) {
        m.f(jSONObject, "jsonObject");
        m.f(r3Var, "responseHandler");
        b().a("outcomes/measure", jSONObject, r3Var);
    }
}
