package com.onesignal;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class f0 {
    static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        int i10 = 0;
        while (i10 < jSONArray.length()) {
            try {
                int i11 = 0;
                while (i11 < jSONArray2.length()) {
                    if (e(jSONArray.get(i10)).equals(e(jSONArray2.get(i11)))) {
                        i10++;
                    } else {
                        i11++;
                    }
                }
                return false;
            } catch (JSONException e10) {
                e10.printStackTrace();
                return false;
            }
        }
        return true;
    }

    static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject2 == null) {
            return jSONObject3;
        }
        Iterator<String> keys = jSONObject2.keys();
        if (jSONObject3 != null) {
            jSONObject4 = jSONObject3;
        } else {
            jSONObject4 = new JSONObject();
        }
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.has(next)) {
                    if (obj instanceof JSONObject) {
                        JSONObject jSONObject6 = jSONObject.getJSONObject(next);
                        if (jSONObject3 == null || !jSONObject3.has(next)) {
                            jSONObject5 = null;
                        } else {
                            jSONObject5 = jSONObject3.getJSONObject(next);
                        }
                        String jSONObject7 = b(jSONObject6, (JSONObject) obj, jSONObject5, set).toString();
                        if (!jSONObject7.equals("{}")) {
                            jSONObject4.put(next, new JSONObject(jSONObject7));
                        }
                    } else if (obj instanceof JSONArray) {
                        d(next, (JSONArray) obj, jSONObject.getJSONArray(next), jSONObject4);
                    } else if (set == null || !set.contains(next)) {
                        Object obj2 = jSONObject.get(next);
                        if (!obj.equals(obj2)) {
                            if (!(obj2 instanceof Number) || !(obj instanceof Number)) {
                                jSONObject4.put(next, obj);
                            } else if (((Number) obj2).doubleValue() != ((Number) obj).doubleValue()) {
                                jSONObject4.put(next, obj);
                            }
                        }
                    } else {
                        jSONObject4.put(next, obj);
                    }
                } else if (obj instanceof JSONObject) {
                    jSONObject4.put(next, new JSONObject(obj.toString()));
                } else if (obj instanceof JSONArray) {
                    d(next, (JSONArray) obj, (JSONArray) null, jSONObject4);
                } else {
                    jSONObject4.put(next, obj);
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return jSONObject4;
    }

    static JSONObject c(c0 c0Var, String str) {
        if (!c0Var.a(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject e10 = c0Var.e(str);
        Iterator<String> keys = e10.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = e10.get(next);
                if (!"".equals(obj)) {
                    jSONObject.put(next, obj);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static void d(String str, JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject) {
        String str2;
        if (str.endsWith("_a") || str.endsWith("_d")) {
            jSONObject.put(str, jSONArray);
            return;
        }
        String f10 = f(jSONArray);
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        if (jSONArray2 == null) {
            str2 = null;
        } else {
            str2 = f(jSONArray2);
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String str3 = (String) jSONArray.get(i10);
            if (jSONArray2 == null || !str2.contains(str3)) {
                jSONArray3.put(str3);
            }
        }
        if (jSONArray2 != null) {
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                String string = jSONArray2.getString(i11);
                if (!f10.contains(string)) {
                    jSONArray4.put(string);
                }
            }
        }
        if (!jSONArray3.toString().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            jSONObject.put(str + "_a", jSONArray3);
        }
        if (!jSONArray4.toString().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            jSONObject.put(str + "_d", jSONArray4);
        }
    }

    public static Object e(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.equals(Integer.class)) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (cls.equals(Float.class)) {
            return Double.valueOf((double) ((Float) obj).floatValue());
        }
        return obj;
    }

    static String f(JSONArray jSONArray) {
        String str = "[";
        int i10 = 0;
        while (i10 < jSONArray.length()) {
            try {
                str = str + "\"" + jSONArray.getString(i10) + "\"";
                i10++;
            } catch (JSONException unused) {
            }
        }
        return str + "]";
    }

    static String g(JSONObject jSONObject) {
        String group;
        String jSONObject2 = jSONObject.toString();
        if (!jSONObject.has("external_user_id")) {
            return jSONObject2;
        }
        Matcher matcher = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(jSONObject2);
        if (!matcher.find() || (group = matcher.group(0)) == null) {
            return jSONObject2;
        }
        return matcher.replaceAll(Matcher.quoteReplacement(group.replace("\\/", DomExceptionUtils.SEPARATOR)));
    }
}
