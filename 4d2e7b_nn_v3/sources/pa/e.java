package pa;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.onesignal.c2;
import com.onesignal.p2;
import com.onesignal.r3;
import com.zing.zalo.zalosdk.common.Constant;
import kotlin.jvm.internal.m;
import na.c;
import org.json.JSONException;
import org.json.JSONObject;
import qa.b;

public final class e extends d {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12907a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.DIRECT.ordinal()] = 1;
            iArr[c.INDIRECT.ordinal()] = 2;
            iArr[c.UNATTRIBUTED.ordinal()] = 3;
            f12907a = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(c2 c2Var, a aVar, j jVar) {
        super(c2Var, aVar, jVar);
        m.f(c2Var, "logger");
        m.f(aVar, "outcomeEventsCache");
        m.f(jVar, "outcomeEventsService");
    }

    private final void l(String str, int i10, p2 p2Var, r3 r3Var) {
        try {
            JSONObject put = p2Var.c().put(Constant.PARAM_APP_ID, str).put("device_type", i10).put(DevicePublicKeyStringDef.DIRECT, true);
            j k10 = k();
            m.e(put, "jsonObject");
            k10.a(put, r3Var);
        } catch (JSONException e10) {
            j().a("Generating direct outcome:JSON Failed.", e10);
        }
    }

    private final void m(String str, int i10, p2 p2Var, r3 r3Var) {
        try {
            JSONObject put = p2Var.c().put(Constant.PARAM_APP_ID, str).put("device_type", i10).put(DevicePublicKeyStringDef.DIRECT, false);
            j k10 = k();
            m.e(put, "jsonObject");
            k10.a(put, r3Var);
        } catch (JSONException e10) {
            j().a("Generating indirect outcome:JSON Failed.", e10);
        }
    }

    private final void n(String str, int i10, p2 p2Var, r3 r3Var) {
        try {
            JSONObject put = p2Var.c().put(Constant.PARAM_APP_ID, str).put("device_type", i10);
            j k10 = k();
            m.e(put, "jsonObject");
            k10.a(put, r3Var);
        } catch (JSONException e10) {
            j().a("Generating unattributed outcome:JSON Failed.", e10);
        }
    }

    public void f(String str, int i10, b bVar, r3 r3Var) {
        int i11;
        m.f(str, "appId");
        m.f(bVar, "eventParams");
        m.f(r3Var, "responseHandler");
        p2 a10 = p2.a(bVar);
        c b10 = a10.b();
        if (b10 == null) {
            i11 = -1;
        } else {
            i11 = a.f12907a[b10.ordinal()];
        }
        if (i11 == 1) {
            m.e(a10, NotificationCompat.CATEGORY_EVENT);
            l(str, i10, a10, r3Var);
        } else if (i11 == 2) {
            m.e(a10, NotificationCompat.CATEGORY_EVENT);
            m(str, i10, a10, r3Var);
        } else if (i11 == 3) {
            m.e(a10, NotificationCompat.CATEGORY_EVENT);
            n(str, i10, a10, r3Var);
        }
    }
}
