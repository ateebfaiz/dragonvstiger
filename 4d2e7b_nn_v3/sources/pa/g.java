package pa;

import androidx.core.app.NotificationCompat;
import com.onesignal.c2;
import com.onesignal.r3;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import qa.b;

public final class g extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(c2 c2Var, a aVar, j jVar) {
        super(c2Var, aVar, jVar);
        m.f(c2Var, "logger");
        m.f(aVar, "outcomeEventsCache");
        m.f(jVar, "outcomeEventsService");
    }

    public void f(String str, int i10, b bVar, r3 r3Var) {
        m.f(str, "appId");
        m.f(bVar, NotificationCompat.CATEGORY_EVENT);
        m.f(r3Var, "responseHandler");
        try {
            JSONObject put = bVar.g().put(Constant.PARAM_APP_ID, str).put("device_type", i10);
            j k10 = k();
            m.e(put, "jsonObject");
            k10.a(put, r3Var);
        } catch (JSONException e10) {
            j().a("Generating indirect outcome:JSON Failed.", e10);
        }
    }
}
