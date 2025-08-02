package com.facebook.react.bridge;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONArguments {
    public static ReadableArray fromJSONArray(JSONArray jSONArray) throws JSONException {
        WritableArray createArray = Arguments.createArray();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object obj = jSONArray.get(i10);
            if (obj instanceof JSONObject) {
                createArray.pushMap(fromJSONObject((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                createArray.pushArray(fromJSONArray((JSONArray) obj));
            } else if (obj instanceof String) {
                createArray.pushString((String) obj);
            } else if (obj instanceof Boolean) {
                createArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                createArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                createArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                createArray.pushInt(((Long) obj).intValue());
            } else if (jSONArray.isNull(i10)) {
                createArray.pushNull();
            } else {
                throw new JSONException("Unexpected value when parsing JSON array. index: " + i10);
            }
        }
        return createArray;
    }

    public static ReadableArray fromJSONArrayString(String str) throws JSONException {
        return fromJSONArray(new JSONArray(str));
    }

    public static ReadableMap fromJSONObject(JSONObject jSONObject) throws JSONException {
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                createMap.putMap(next, fromJSONObject((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                createMap.putArray(next, fromJSONArray((JSONArray) obj));
            } else if (obj instanceof String) {
                createMap.putString(next, (String) obj);
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                createMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                createMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                createMap.putInt(next, ((Long) obj).intValue());
            } else if (jSONObject.isNull(next)) {
                createMap.putNull(next);
            } else {
                throw new JSONException("Unexpected value when parsing JSON object. key: " + next);
            }
        }
        return createMap;
    }

    public static ReadableMap fromJSONObjectString(String str) throws JSONException {
        return fromJSONObject(new JSONObject(str));
    }
}
