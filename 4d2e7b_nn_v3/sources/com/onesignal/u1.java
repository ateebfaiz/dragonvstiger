package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f11074a = new u1();

    private u1() {
    }

    public static final String a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        m.f(jSONObject, "payload");
        try {
            JSONObject b10 = l0.b(jSONObject);
            m.e(b10, "{\n            Notificati…Object(payload)\n        }");
            if (b10.has("a") && (optJSONObject = b10.optJSONObject("a")) != null && optJSONObject.has("os_in_app_message_preview_id")) {
                return optJSONObject.optString("os_in_app_message_preview_id");
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final boolean b(Activity activity, JSONObject jSONObject) {
        m.f(activity, "activity");
        m.f(jSONObject, "jsonData");
        String a10 = a(jSONObject);
        if (a10 == null) {
            return false;
        }
        o3.e1(activity, new JSONArray().put(jSONObject));
        o3.c0().J(a10);
        return true;
    }

    public static final boolean c(Context context, Bundle bundle) {
        JSONObject a10 = l0.a(bundle);
        m.e(a10, "bundleAsJSONObject(bundle)");
        String a11 = a(a10);
        if (a11 == null) {
            return false;
        }
        if (o3.N0()) {
            o3.c0().J(a11);
            return true;
        } else if (!f11074a.d()) {
            return true;
        } else {
            v.m(new i2(context, a10));
            return true;
        }
    }

    private final boolean d() {
        return true;
    }
}
