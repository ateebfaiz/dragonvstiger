package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.o3;
import org.json.JSONException;
import org.json.JSONObject;

abstract class h2 {
    private static String a(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString("custom", (String) null);
            if (string != null) {
                return c(string);
            }
            o3.a(o3.v.DEBUG, "Not a OneSignal formatted Bundle. No 'custom' field in the bundle.");
        }
        return null;
    }

    static String b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return c(jSONObject.optString("custom", (String) null));
    }

    private static String c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("i")) {
                return jSONObject.optString("i", (String) null);
            }
            o3.a(o3.v.DEBUG, "Not a OneSignal formatted JSON string. No 'i' field in custom.");
            return null;
        } catch (JSONException unused) {
            o3.a(o3.v.DEBUG, "Not a OneSignal formatted JSON String, error parsing string as JSON.");
        }
    }

    static boolean d(Bundle bundle) {
        if (a(bundle) != null) {
            return true;
        }
        return false;
    }

    static boolean e(Intent intent) {
        if (intent == null) {
            return false;
        }
        return d(intent.getExtras());
    }
}
