package d2;

import android.os.Bundle;
import com.engagelab.privates.push.api.NotificationMessage;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b {
    private static JSONArray a(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (String put : strArr) {
                jSONArray.put(put);
            }
        }
        return jSONArray;
    }

    private static JSONObject b(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                jSONObject.put(next, bundle.get(next));
            }
        }
        return jSONObject;
    }

    public static String c(NotificationMessage notificationMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("badge", notificationMessage.a());
            jSONObject.put("bigPicture", notificationMessage.b());
            jSONObject.put("bigText", notificationMessage.c());
            jSONObject.put("builderId", notificationMessage.d());
            jSONObject.put("category", notificationMessage.e());
            jSONObject.put("channelId", notificationMessage.f());
            jSONObject.put(FirebaseAnalytics.Param.CONTENT, notificationMessage.g());
            jSONObject.put("defaults", notificationMessage.h());
            jSONObject.put("extras", b(notificationMessage.i()));
            jSONObject.put("inbox", a(notificationMessage.j()));
            jSONObject.put("intentSsl", notificationMessage.k());
            jSONObject.put("intentUri", notificationMessage.l());
            jSONObject.put("largeIcon", notificationMessage.m());
            jSONObject.put("messageId", notificationMessage.n());
            jSONObject.put("notificationId", notificationMessage.o());
            jSONObject.put("overrideMessageId", notificationMessage.p());
            jSONObject.put("platform", notificationMessage.q());
            jSONObject.put("platformMessageId", notificationMessage.r());
            jSONObject.put("priority", notificationMessage.s());
            jSONObject.put("smallIcon", notificationMessage.t());
            jSONObject.put("sound", notificationMessage.u());
            jSONObject.put("style", notificationMessage.v());
            jSONObject.put("title", notificationMessage.w());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }
}
