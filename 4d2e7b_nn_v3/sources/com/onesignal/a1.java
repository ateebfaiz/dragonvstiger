package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class a1 {
    private static JSONObject a(Intent intent) {
        if (!h2.e(intent)) {
            return null;
        }
        JSONObject a10 = l0.a(intent.getExtras());
        d(a10);
        return a10;
    }

    static void b(Activity activity, Intent intent) {
        JSONObject a10;
        o3.L0(activity.getApplicationContext());
        if (intent != null && (a10 = a(intent)) != null) {
            c(activity, a10);
        }
    }

    private static void c(Activity activity, JSONObject jSONObject) {
        if (!u1.b(activity, jSONObject)) {
            o3.E0(activity, new JSONArray().put(jSONObject), h2.b(jSONObject));
        }
    }

    private static void d(JSONObject jSONObject) {
        try {
            String str = (String) l0.b(jSONObject).remove("actionId");
            if (str != null) {
                jSONObject.put("actionId", str);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
