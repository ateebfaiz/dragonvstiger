package com.sensorsdata.analytics.android.sdk.advert.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelUtils {
    private static final Map<String, String> LATEST_UTM_MAP = new HashMap<String, String>() {
        {
            put(ChannelUtils.UTM_SOURCE_KEY, "$latest_utm_source");
            put(ChannelUtils.UTM_MEDIUM_KEY, "$latest_utm_medium");
            put(ChannelUtils.UTM_TERM_KEY, "$latest_utm_term");
            put(ChannelUtils.UTM_CONTENT_KEY, "$latest_utm_content");
            put(ChannelUtils.UTM_CAMPAIGN_KEY, "$latest_utm_campaign");
        }
    };
    private static final String SHARED_PREF_CORRECT_TRACK_INSTALLATION = "sensorsdata.correct.track.installation";
    private static final String SHARED_PREF_UTM = "sensorsdata.utm";
    private static final String UTM_CAMPAIGN_KEY = "SENSORS_ANALYTICS_UTM_CAMPAIGN";
    private static final String UTM_CONTENT_KEY = "SENSORS_ANALYTICS_UTM_CONTENT";
    private static final HashMap<String, String> UTM_LINK_MAP = new HashMap<String, String>() {
        {
            put(ChannelUtils.UTM_SOURCE_KEY, "utm_source");
            put(ChannelUtils.UTM_MEDIUM_KEY, "utm_medium");
            put(ChannelUtils.UTM_TERM_KEY, "utm_term");
            put(ChannelUtils.UTM_CONTENT_KEY, "utm_content");
            put(ChannelUtils.UTM_CAMPAIGN_KEY, "utm_campaign");
        }
    };
    private static final HashMap<String, String> UTM_MAP = new HashMap<String, String>() {
        {
            put(ChannelUtils.UTM_SOURCE_KEY, "$utm_source");
            put(ChannelUtils.UTM_MEDIUM_KEY, "$utm_medium");
            put(ChannelUtils.UTM_TERM_KEY, "$utm_term");
            put(ChannelUtils.UTM_CONTENT_KEY, "$utm_content");
            put(ChannelUtils.UTM_CAMPAIGN_KEY, "$utm_campaign");
        }
    };
    private static final String UTM_MEDIUM_KEY = "SENSORS_ANALYTICS_UTM_MEDIUM";
    private static final String UTM_SOURCE_KEY = "SENSORS_ANALYTICS_UTM_SOURCE";
    private static final String UTM_TERM_KEY = "SENSORS_ANALYTICS_UTM_TERM";
    private static final List<String> mDeepLinkBlackList = new ArrayList() {
        {
            add("io.dcloud.PandoraEntryActivity");
        }
    };
    private static HashSet<String> sChannelSourceKeySet = new HashSet<>();
    private static Map<String, String> sLatestUtmProperties = new HashMap();
    private static Map<String, String> sUtmProperties = new HashMap();

    public static boolean checkDeviceInfo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("##");
        HashMap hashMap = new HashMap();
        if (split.length == 0) {
            return false;
        }
        for (String trim : split) {
            String[] split2 = trim.trim().split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        if (hashMap.isEmpty()) {
            return false;
        }
        if ((!hashMap.containsKey("oaid") || !TextUtils.equals((CharSequence) hashMap.get("oaid"), SAOaidHelper.getOpenAdIdentifier(context))) && (!hashMap.containsKey("android_id") || !TextUtils.equals((CharSequence) hashMap.get("android_id"), SensorsDataUtils.getIdentifier(context)))) {
            return false;
        }
        return true;
    }

    public static JSONObject checkOrSetChannelCallbackEvent(String str, JSONObject jSONObject, Context context) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("$is_channel_callback_event", isFirstChannelEvent(str));
            if (context != null && !hasUtmProperties(jSONObject)) {
                mergeUtmByMetaData(context, jSONObject);
            }
            jSONObject.put("$channel_device_info", "1");
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }

    public static void clearLocalUtm() {
        try {
            SAStoreManager.getInstance().setString(SHARED_PREF_UTM, "");
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void clearMemoryUtm() {
        sUtmProperties.clear();
        sLatestUtmProperties.clear();
    }

    public static void clearUtm() {
        clearMemoryUtm();
        clearLocalUtm();
    }

    public static void commitRequestDeferredDeeplink(boolean z10) {
        SAStoreManager.getInstance().setBool(DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK, z10);
    }

    private static String getApplicationMetaData(Context context, String str) {
        int i10;
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            String string = applicationInfo.metaData.getString(str);
            if (string == null) {
                i10 = applicationInfo.metaData.getInt(str, -1);
            } else {
                i10 = -1;
            }
            if (i10 != -1) {
                return String.valueOf(i10);
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDeviceInfo(Context context, String str, String str2, String str3) {
        return String.format("android_id=%s##imei=%s##imei_old=%s##imei_slot1=%s##imei_slot2=%s##imei_meid=%s##mac=%s##oaid=%s##oaid_reflection=%s", new Object[]{str, "", "", "", "", "", "", str2, str3});
    }

    public static JSONObject getLatestUtmProperties() {
        if (sLatestUtmProperties.size() > 0) {
            return new JSONObject(sLatestUtmProperties);
        }
        return new JSONObject();
    }

    public static JSONObject getUtmProperties() {
        if (sUtmProperties.size() > 0) {
            return new JSONObject(sUtmProperties);
        }
        return new JSONObject();
    }

    public static boolean hasLinkUtmProperties(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            for (Map.Entry next : UTM_LINK_MAP.entrySet()) {
                if (next != null && set.contains(next.getValue())) {
                    return true;
                }
            }
            Iterator<String> it = sChannelSourceKeySet.iterator();
            while (it.hasNext()) {
                String next2 = it.next();
                if (!TextUtils.isEmpty(next2) && sChannelSourceKeySet.contains(next2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUtmByMetaData(Context context) {
        if (context == null) {
            return false;
        }
        for (Map.Entry next : UTM_MAP.entrySet()) {
            if (next != null && !TextUtils.isEmpty(getApplicationMetaData(context, (String) next.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUtmProperties(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        for (Map.Entry next : UTM_MAP.entrySet()) {
            if (next != null && jSONObject.has((String) next.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCorrectTrackInstallation() {
        try {
            return SAStoreManager.getInstance().getBool(SHARED_PREF_CORRECT_TRACK_INSTALLATION, false);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static boolean isDeepLinkBlackList(Activity activity) {
        if (activity == null) {
            return false;
        }
        for (String cls : mDeepLinkBlackList) {
            try {
                if (Class.forName(cls).isAssignableFrom(activity.getClass())) {
                    return true;
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
        return false;
    }

    public static boolean isExistRequestDeferredDeeplink() {
        return SAStoreManager.getInstance().isExists(DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK);
    }

    public static boolean isFirstChannelEvent(String str) {
        String str2;
        if (AbstractSensorsDataAPI.getConfigOptions().getStorePlugins() == null || AbstractSensorsDataAPI.getConfigOptions().getStorePlugins().isEmpty()) {
            str2 = str;
        } else {
            str2 = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_ENCRYPT_AES, str);
        }
        boolean isFirstChannelEvent = DbAdapter.getInstance().isFirstChannelEvent(new String[]{str2, str});
        if (isFirstChannelEvent) {
            DbAdapter.getInstance().addChannelEvent(str2);
        }
        return isFirstChannelEvent;
    }

    public static boolean isGetDeviceInfo(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static boolean isRequestDeferredDeeplink() {
        return SAStoreManager.getInstance().getBool(DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK, true);
    }

    public static boolean isTrackInstallation() {
        try {
            return SAStoreManager.getInstance().isExists(SHARED_PREF_CORRECT_TRACK_INSTALLATION);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public static void loadUtmByLocal() {
        try {
            sLatestUtmProperties.clear();
            String string = SAStoreManager.getInstance().getString(SHARED_PREF_UTM, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                for (Map.Entry<String, String> value : LATEST_UTM_MAP.entrySet()) {
                    String str = (String) value.getValue();
                    if (jSONObject.has(str)) {
                        sLatestUtmProperties.put(str, jSONObject.optString(str));
                    }
                }
                Iterator<String> it = sChannelSourceKeySet.iterator();
                while (it.hasNext()) {
                    String str2 = "_latest_" + it.next();
                    if (jSONObject.has(str2)) {
                        sLatestUtmProperties.put(str2, jSONObject.optString(str2));
                    }
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void mergeUtmByMetaData(Context context, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            for (Map.Entry next : UTM_MAP.entrySet()) {
                if (next != null) {
                    String applicationMetaData = getApplicationMetaData(context, (String) next.getKey());
                    if (!TextUtils.isEmpty(applicationMetaData)) {
                        jSONObject.put((String) next.getValue(), applicationMetaData);
                    }
                }
            }
        }
    }

    public static void parseParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            for (Map.Entry next : UTM_LINK_MAP.entrySet()) {
                String str = map.get((String) next.getValue());
                if (!TextUtils.isEmpty(str)) {
                    sUtmProperties.put(UTM_MAP.get(next.getKey()), str);
                    sLatestUtmProperties.put(LATEST_UTM_MAP.get(next.getKey()), str);
                }
            }
            Iterator<String> it = sChannelSourceKeySet.iterator();
            while (it.hasNext()) {
                String next2 = it.next();
                try {
                    if (SADataHelper.assertPropertyKey(next2)) {
                        String str2 = map.get(next2);
                        if (!TextUtils.isEmpty(str2)) {
                            sUtmProperties.put(next2, str2);
                            Map<String, String> map2 = sLatestUtmProperties;
                            map2.put("_latest_" + next2, str2);
                        }
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        }
    }

    public static void removeDeepLinkInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.startsWith("$latest")) {
                        if (next.startsWith("_latest")) {
                        }
                    }
                    keys.remove();
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public static void saveCorrectTrackInstallation(boolean z10) {
        try {
            SAStoreManager.getInstance().setBool(SHARED_PREF_CORRECT_TRACK_INSTALLATION, z10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void saveDeepLinkInfo() {
        try {
            if (sLatestUtmProperties.size() > 0) {
                SAStoreManager.getInstance().setString(SHARED_PREF_UTM, sLatestUtmProperties.toString());
            } else {
                clearLocalUtm();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void setSourceChannelKeys(String... strArr) {
        sChannelSourceKeySet.clear();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    sChannelSourceKeySet.add(str);
                }
            }
        }
    }
}
