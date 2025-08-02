package l2;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.facebook.w;
import e2.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import org.json.JSONObject;
import q5.b;
import q5.d0;
import q5.p0;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f22413a = i0.g(t.a(a.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), t.a(a.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));

    /* renamed from: b  reason: collision with root package name */
    public static final c f22414b = new c();

    public enum a {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    private c() {
    }

    public static final JSONObject a(a aVar, b bVar, String str, boolean z10, Context context) {
        m.f(aVar, "activityType");
        m.f(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, f22413a.get(aVar));
        String d10 = g.f21166c.d();
        if (d10 != null) {
            jSONObject.put("app_user_id", d10);
        }
        p0.z0(jSONObject, bVar, str, z10, context);
        try {
            p0.A0(jSONObject, context);
        } catch (Exception e10) {
            d0.f23283f.c(w.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e10.toString());
        }
        JSONObject A = p0.A();
        if (A != null) {
            Iterator<String> keys = A.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, A.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
