package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTReporter;
import com.engagelab.privates.push.api.CustomMessage;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import d2.i;
import org.json.JSONObject;
import s1.a;

public class t extends s {

    /* renamed from: b  reason: collision with root package name */
    public static volatile t f21611b;

    public static t e() {
        if (f21611b == null) {
            synchronized (t.class) {
                f21611b = new t();
            }
        }
        return f21611b;
    }

    public void c(Context context, Bundle bundle) {
        try {
            String string = bundle.getString("message");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("ad_id");
                if (TextUtils.isEmpty(optString)) {
                    a.a("MTCustomBusiness", "customMessage's messageId is null, can't callback this custom");
                    return;
                }
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString3)) {
                    a.a("MTCustomBusiness", "customMessage's content is null, can't callback this custom");
                    return;
                }
                String optString4 = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE);
                CustomMessage f10 = new CustomMessage().g(optString).j(optString2).d(optString3).e(optString4).f(i.b(jSONObject.optJSONObject("extras")));
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("message", f10);
                h1.a.i(context, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, bundle2);
            }
        } catch (Throwable th) {
            a.h("MTCustomBusiness", "onMessage failed " + th.getMessage());
        }
    }

    public void d(Context context, int i10, Bundle bundle) {
        MTCommonReceiver f10;
        try {
            bundle.setClassLoader(CustomMessage.class.getClassLoader());
            CustomMessage customMessage = (CustomMessage) bundle.getParcelable("message");
            if (customMessage != null && (f10 = p1.a.f(context)) != null) {
                f10.onCustomMessage(context, customMessage);
                h1.a.j(context, 3999, bundle);
            }
        } catch (Throwable th) {
            a.h("MTCustomBusiness", "processMainMessage failed " + th.getMessage());
        }
    }

    public void f(Context context, int i10, Bundle bundle) {
        String str;
        int i11;
        try {
            bundle.setClassLoader(CustomMessage.class.getClassLoader());
            CustomMessage customMessage = (CustomMessage) bundle.getParcelable("message");
            if (customMessage != null) {
                a.a("MTCustomBusiness", "onCustomMessage");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg_id", customMessage.a());
                if (customMessage.b() != 0) {
                    jSONObject.put("sdk_type", customMessage.b());
                    jSONObject.put("tmsg_id", customMessage.c());
                    str = "third_msg_status";
                    i11 = 3202;
                } else {
                    str = "msg_status";
                    i11 = 3201;
                }
                jSONObject.put(DbParams.KEY_CHANNEL_RESULT, PointerIconCompat.TYPE_ZOOM_IN);
                MTReporter c10 = new MTReporter().d(str).c(jSONObject.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("protocol", c10);
                h1.a.j(context, 2233, bundle2);
                Bundle bundle3 = new Bundle();
                bundle3.putString("json", jSONObject.toString());
                h1.a.i(context, i11, bundle3);
            }
        } catch (Throwable th) {
            a.h("MTCustomBusiness", "processRemoteMessage failed " + th.getMessage());
        }
    }
}
