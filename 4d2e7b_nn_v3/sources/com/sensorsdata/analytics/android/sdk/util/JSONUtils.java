package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    private static void addIndentBlank(StringBuilder sb2, int i10) {
        int i11 = 0;
        while (i11 < i10) {
            try {
                sb2.append(9);
                i11++;
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return;
            }
        }
    }

    public static JSONObject cloneJsonObject(JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            SADataHelper.assertPropertyTypes(jSONObject);
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    jSONObject2.put(next, new Date(((Date) obj).getTime()));
                }
            }
            return jSONObject2;
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    public static String formatJson(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    int i10 = 0;
                    char c10 = 0;
                    boolean z10 = false;
                    int i11 = 0;
                    while (i10 < str.length()) {
                        char charAt = str.charAt(i10);
                        if (charAt == '\"') {
                            if (c10 != '\\') {
                                z10 = !z10;
                            }
                            sb2.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    switch (charAt) {
                                        case '[':
                                            break;
                                        case '\\':
                                            break;
                                        case ']':
                                            break;
                                        default:
                                            sb2.append(charAt);
                                            break;
                                    }
                                }
                                if (!z10) {
                                    sb2.append(10);
                                    i11--;
                                    addIndentBlank(sb2, i11);
                                }
                                sb2.append(charAt);
                            }
                            sb2.append(charAt);
                            if (!z10) {
                                sb2.append(10);
                                i11++;
                                addIndentBlank(sb2, i11);
                            }
                        } else {
                            sb2.append(charAt);
                            if (c10 != '\\' && !z10) {
                                sb2.append(10);
                                addIndentBlank(sb2, i11);
                            }
                        }
                        i10++;
                        c10 = charAt;
                    }
                    return sb2.toString();
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
        return "";
    }

    public static boolean isJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith("}")) {
                return true;
            }
            if (!trim.startsWith("[") || !trim.endsWith("]")) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static Map<String, String> json2Map(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        return hashMap;
    }

    public static void mergeDistinctProperty(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject2.has(next)) {
                        Object obj = jSONObject.get(next);
                        if (!(obj instanceof Date) || "$time".equals(next)) {
                            jSONObject2.put(next, obj);
                        } else {
                            jSONObject2.put(next, TimeUtils.formatDate((Date) obj, TimeUtils.SDK_LOCALE));
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void mergeDuplicateProperty(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (jSONObject2.has(next)) {
                        Object obj = jSONObject.get(next);
                        if (!(obj instanceof Date) || "$time".equals(next)) {
                            jSONObject2.put(next, obj);
                        } else {
                            jSONObject2.put(next, TimeUtils.formatDate((Date) obj, TimeUtils.SDK_LOCALE));
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void mergeJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            if (jSONObject2 == null) {
                try {
                    jSONObject2 = new JSONObject();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                    return;
                }
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (!(obj instanceof Date) || "$time".equals(next)) {
                    jSONObject2.put(next, obj);
                } else {
                    jSONObject2.put(next, TimeUtils.formatDate((Date) obj, TimeUtils.SDK_LOCALE));
                }
            }
        }
    }

    public static JSONObject mergeSuperJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!TextUtils.isEmpty(next) && next.equalsIgnoreCase(next2)) {
                        keys2.remove();
                    }
                }
            }
            mergeJSONObject(jSONObject, jSONObject2);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject2;
    }

    public static String optionalStringKey(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
