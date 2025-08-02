package com.geetest.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class n6 extends m6<String> {
    public n6(Context context, String str) {
        super(str);
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public boolean b() {
        return false;
    }

    public void a(String str, s6<String> s6Var) {
        if (TextUtils.isEmpty(str)) {
            s6Var.a("-1", "The response result is empty.");
            return;
        }
        try {
            String optString = new JSONObject(str).optString("authurl");
            if (TextUtils.isEmpty(optString)) {
                s6Var.a("-1", str);
            } else {
                s6Var.a("1", optString);
            }
        } catch (JSONException unused) {
            s6Var.a("-1", str);
        }
    }
}
