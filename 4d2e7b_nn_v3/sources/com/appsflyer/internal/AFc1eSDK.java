package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFc1eSDK implements AFc1cSDK<Map<String, Object>> {
    public static Map<String, Object> values(String str) throws JSONException {
        Object obj;
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.isNull(next)) {
                    obj = null;
                } else {
                    obj = jSONObject.get(next);
                }
                hashMap.put(next, obj);
            }
            hashMap.remove("is_cache");
            return hashMap;
        } catch (JSONException e10) {
            AFLogger.afErrorLogForExcManagerOnly("error while paring GCD response", e10);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("string_response", str);
            return hashMap2;
        }
    }

    public final /* synthetic */ Object valueOf(String str) throws JSONException {
        return values(str);
    }
}
