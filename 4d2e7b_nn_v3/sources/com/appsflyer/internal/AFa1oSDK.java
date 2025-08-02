package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1oSDK {
    public String AFInAppEventParameterName;
    public String AFInAppEventType;
    private byte[] AFKeystoreWrapper;
    @Nullable
    public AFd1rSDK valueOf;
    public String values;

    public AFa1oSDK() {
    }

    @Nullable
    public static JSONObject AFInAppEventParameterName(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Map<String, Object> AFInAppEventType(@NonNull JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = AFKeystoreWrapper((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static JSONObject AFKeystoreWrapper(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), valueOf(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static Object valueOf(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object valueOf2 : (Collection) obj) {
                    jSONArray.put(valueOf(valueOf2));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i10 = 0; i10 < length; i10++) {
                    jSONArray2.put(valueOf(Array.get(obj, i10)));
                }
                return jSONArray2;
            } else if (obj instanceof Map) {
                return AFKeystoreWrapper((Map<String, ?>) (Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AFa1oSDK.class == obj.getClass()) {
            AFa1oSDK aFa1oSDK = (AFa1oSDK) obj;
            String str = this.AFInAppEventParameterName;
            if (str == null ? aFa1oSDK.AFInAppEventParameterName != null : !str.equals(aFa1oSDK.AFInAppEventParameterName)) {
                return false;
            }
            if (!Arrays.equals(this.AFKeystoreWrapper, aFa1oSDK.AFKeystoreWrapper)) {
                return false;
            }
            String str2 = this.values;
            if (str2 == null ? aFa1oSDK.values != null : !str2.equals(aFa1oSDK.values)) {
                return false;
            }
            String str3 = this.AFInAppEventType;
            if (str3 == null ? aFa1oSDK.AFInAppEventType != null : !str3.equals(aFa1oSDK.AFInAppEventType)) {
                return false;
            }
            if (this.valueOf == aFa1oSDK.valueOf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int i11;
        int i12;
        String str = this.AFInAppEventParameterName;
        int i13 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int hashCode = ((i10 * 31) + Arrays.hashCode(this.AFKeystoreWrapper)) * 31;
        String str2 = this.values;
        if (str2 != null) {
            i11 = str2.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (hashCode + i11) * 31;
        String str3 = this.AFInAppEventType;
        if (str3 != null) {
            i12 = str3.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        AFd1rSDK aFd1rSDK = this.valueOf;
        if (aFd1rSDK != null) {
            i13 = aFd1rSDK.hashCode();
        }
        return i15 + i13;
    }

    public AFa1oSDK(String str, byte[] bArr, String str2, AFd1rSDK aFd1rSDK) {
        this.values = str;
        this.AFKeystoreWrapper = bArr;
        this.AFInAppEventParameterName = str2;
        this.valueOf = aFd1rSDK;
    }

    static AFe1fSDK AFInAppEventParameterName(Context context) {
        if (context instanceof Activity) {
            return AFe1fSDK.activity;
        }
        if (context instanceof Application) {
            return AFe1fSDK.application;
        }
        return AFe1fSDK.other;
    }

    private static List<Object> AFKeystoreWrapper(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object obj = jSONArray.get(i10);
            if (obj instanceof JSONArray) {
                obj = AFKeystoreWrapper((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public AFa1oSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i10 = 0;
        int i11 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.values = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFInAppEventParameterName = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventParameterName);
                if (matcher.matches()) {
                    i10 = Integer.parseInt(matcher.group(1));
                    i11 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.AFKeystoreWrapper = (i10 > 4 || i11 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            } else if (nextLine.startsWith("type=")) {
                String trim2 = nextLine.substring(5).trim();
                try {
                    this.valueOf = AFd1rSDK.valueOf(trim2);
                } catch (Exception e10) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(trim2)), e10);
                }
            }
        }
        scanner.close();
    }

    public final byte[] valueOf() {
        return this.AFKeystoreWrapper;
    }
}
