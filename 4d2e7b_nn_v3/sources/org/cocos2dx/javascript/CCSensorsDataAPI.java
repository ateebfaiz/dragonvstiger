package org.cocos2dx.javascript;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CCSensorsDataAPI {
    private static final String VERSION = "0.0.1";
    private static boolean isAddPluginVersion;
    private static AppActivity mActivity;

    private static JSONObject addPluginVersion(JSONObject jSONObject) {
        if (!isAddPluginVersion) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("$lib_plugin_version", new JSONArray().put("app_cocos_creator:0.0.1"));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            isAddPluginVersion = true;
        }
        return jSONObject;
    }

    public static void clearAppRegister(String str) {
        try {
            SensorsDataAPI.sharedInstance().unregisterSuperProperty(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void flush() {
        try {
            SensorsDataAPI.sharedInstance().flush();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String getAnonymousId() {
        try {
            return SensorsDataAPI.sharedInstance().getAnonymousId();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getDistinctId() {
        try {
            return SensorsDataAPI.sharedInstance().getDistinctId();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getLoginId() {
        try {
            return SensorsDataAPI.sharedInstance().getLoginId();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getPresetProperties() {
        try {
            JSONObject presetProperties = SensorsDataAPI.sharedInstance().getPresetProperties();
            if (presetProperties != null) {
                return presetProperties.toString();
            }
            return "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void identify(String str) {
        try {
            SensorsDataAPI.sharedInstance().identify(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initSA(java.lang.String r6) {
        /*
            org.json.JSONObject r6 = strToJson(r6)     // Catch:{ Exception -> 0x002e }
            if (r6 == 0) goto L_0x0085
            java.lang.String r0 = ""
            java.lang.String r1 = "serverUrl"
            java.lang.Object r1 = r6.opt(r1)     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "appStart"
            java.lang.Object r2 = r6.opt(r2)     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = "appEnd"
            java.lang.Object r3 = r6.opt(r3)     // Catch:{ Exception -> 0x002e }
            java.lang.String r4 = "enableLog"
            java.lang.Object r4 = r6.opt(r4)     // Catch:{ Exception -> 0x002e }
            java.lang.String r5 = "enableEncrypt"
            java.lang.Object r6 = r6.opt(r5)     // Catch:{ Exception -> 0x002e }
            boolean r5 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x002e }
            if (r5 == 0) goto L_0x0030
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r6 = move-exception
            goto L_0x0082
        L_0x0030:
            boolean r1 = r2 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x002e }
            r5 = 0
            if (r1 == 0) goto L_0x003c
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x002e }
            boolean r1 = r2.booleanValue()     // Catch:{ Exception -> 0x002e }
            goto L_0x003d
        L_0x003c:
            r1 = r5
        L_0x003d:
            boolean r2 = r3 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x002e }
            if (r2 == 0) goto L_0x0048
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x002e }
            boolean r2 = r3.booleanValue()     // Catch:{ Exception -> 0x002e }
            goto L_0x0049
        L_0x0048:
            r2 = r5
        L_0x0049:
            boolean r3 = r4 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x002e }
            if (r3 == 0) goto L_0x0054
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x002e }
            boolean r3 = r4.booleanValue()     // Catch:{ Exception -> 0x002e }
            goto L_0x0055
        L_0x0054:
            r3 = r5
        L_0x0055:
            boolean r4 = r6 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x002e }
            if (r4 == 0) goto L_0x005f
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ Exception -> 0x002e }
            boolean r5 = r6.booleanValue()     // Catch:{ Exception -> 0x002e }
        L_0x005f:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r6 = new com.sensorsdata.analytics.android.sdk.SAConfigOptions     // Catch:{ Exception -> 0x002e }
            r6.<init>(r0)     // Catch:{ Exception -> 0x002e }
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = r6.enableLog(r3)     // Catch:{ Exception -> 0x002e }
            r0.enableEncrypt(r5)     // Catch:{ Exception -> 0x002e }
            if (r2 == 0) goto L_0x006f
            r1 = r1 | 2
        L_0x006f:
            r6.setAutoTrackEventType(r1)     // Catch:{ Exception -> 0x002e }
            org.cocos2dx.javascript.AppActivity r0 = mActivity     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x007a
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.startWithConfigOptions(r0, r6)     // Catch:{ Exception -> 0x002e }
            goto L_0x0085
        L_0x007a:
            java.lang.String r6 = "SA.AnalyticsMessages"
            java.lang.String r0 = "initSA: mActivity is null"
            android.util.Log.w(r6, r0)     // Catch:{ Exception -> 0x002e }
            goto L_0x0085
        L_0x0082:
            r6.printStackTrace()
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.CCSensorsDataAPI.initSA(java.lang.String):void");
    }

    public static void login(String str) {
        try {
            SensorsDataAPI.sharedInstance().login(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void logout() {
        try {
            SensorsDataAPI.sharedInstance().logout();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void onCreate(AppActivity appActivity) {
        mActivity = appActivity;
    }

    public static void profileDelete() {
        try {
            SensorsDataAPI.sharedInstance().profileDelete();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void profileUnset(String str) {
        try {
            SensorsDataAPI.sharedInstance().profileUnset(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void registerApp(String str) {
        try {
            SensorsDataAPI.sharedInstance().registerSuperProperties(strToJson(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setAppendProfile(String str) {
        try {
            JSONObject strToJson = strToJson(str);
            if (strToJson != null) {
                String next = strToJson.keys().next();
                if (!TextUtils.isEmpty(next)) {
                    JSONArray optJSONArray = strToJson.optJSONArray(next);
                    int length = optJSONArray.length();
                    HashSet hashSet = new HashSet();
                    int i10 = 0;
                    while (i10 < length) {
                        if (optJSONArray.get(i10) instanceof CharSequence) {
                            hashSet.add(optJSONArray.optString(i10));
                            i10++;
                        } else {
                            throw new Exception("The array property value must be an instance of JSONArray only contains String. [key='" + next + "', value='" + optJSONArray.get(i10).toString() + "']");
                        }
                    }
                    SensorsDataAPI.sharedInstance().profileAppend(next, (Set<String>) hashSet);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setIncrementProfile(String str, float f10) {
        try {
            SensorsDataAPI.sharedInstance().profileIncrement(str, Float.valueOf(f10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setOnceProfile(String str) {
        try {
            JSONObject strToJson = strToJson(str);
            if (strToJson != null) {
                SensorsDataAPI.sharedInstance().profileSetOnce(strToJson);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setProfile(String str) {
        try {
            JSONObject strToJson = strToJson(str);
            if (strToJson != null) {
                SensorsDataAPI.sharedInstance().profileSet(strToJson);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static JSONObject strToJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void track(String str, String str2) {
        try {
            SensorsDataAPI.sharedInstance().track(str, addPluginVersion(strToJson(str2)));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void trackAppInstall(String str) {
        try {
            SensorsDataAPI.sharedInstance().trackAppInstall(strToJson(str));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void trackAppViewScreen(String str, String str2) {
        try {
            JSONObject strToJson = strToJson(str2);
            if (strToJson == null) {
                strToJson = new JSONObject();
            }
            SensorsDataAPI.sharedInstance().trackViewScreen(str, strToJson);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void trackTimerEnd(String str, String str2) {
        try {
            SensorsDataAPI.sharedInstance().trackTimerEnd(str, addPluginVersion(strToJson(str2)));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void trackTimerPause(String str) {
        try {
            SensorsDataAPI.sharedInstance().trackTimerPause(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void trackTimerResume(String str) {
        try {
            SensorsDataAPI.sharedInstance().trackTimerResume(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String trackTimerStart(String str) {
        try {
            return SensorsDataAPI.sharedInstance().trackTimerStart(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
