package n2;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import n2.c;
import org.json.JSONArray;
import q5.p0;
import q5.s;
import v5.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22818a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f22819b = new b();

    static {
        String simpleName = c.class.getSimpleName();
        m.e(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        f22818a = simpleName;
    }

    private b() {
    }

    public static final Bundle a(c.a aVar, String str, List list) {
        Class<b> cls = b.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "eventType");
            m.f(str, "applicationId");
            m.f(list, "appEvents");
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_EVENT, aVar.toString());
            bundle.putString(Constant.PARAM_APP_ID, str);
            if (c.a.CUSTOM_APP_EVENTS == aVar) {
                JSONArray b10 = f22819b.b(list, str);
                if (b10.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", b10.toString());
            }
            return bundle;
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    private final JSONArray b(List list, String str) {
        if (a.d(this)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<e2.c> y02 = r.y0(list);
            i2.a.d(y02);
            boolean c10 = c(str);
            for (e2.c cVar : y02) {
                if (cVar.h()) {
                    if (!(!cVar.i())) {
                        if (cVar.i() && c10) {
                        }
                    }
                    jSONArray.put(cVar.e());
                } else {
                    String str2 = f22818a;
                    p0.f0(str2, "Event with invalid checksum: " + cVar);
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            a.b(th, this);
            return null;
        }
    }

    private final boolean c(String str) {
        if (a.d(this)) {
            return false;
        }
        try {
            q5.r o10 = s.o(str, false);
            if (o10 != null) {
                return o10.o();
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }
}
