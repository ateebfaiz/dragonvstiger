package com.adjust.sdk.webbridge;

import android.content.Context;
import android.content.pm.PackageManager;
import android.webkit.JavascriptInterface;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSDKJSInterface {
    private static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String PROTOCOL = "fbmq-0.1";
    private String fbPixelDefaultEventToken;
    private Map<String, String> fbPixelMapping = new HashMap();

    public static String getApplicationId(Context context) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(APPLICATION_ID_PROPERTY);
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                    str = str.substring(2);
                }
                return str;
            } else if (obj instanceof Integer) {
                AdjustFactory.getLogger().error("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.", new Object[0]);
                return null;
            } else {
                AdjustFactory.getLogger().error("App Ids is not a string or integer", new Object[0]);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            AdjustFactory.getLogger().error("Error loading fb ApplicationInfo: %s", e10.getMessage());
            return null;
        }
    }

    private static Map<String, String> jsonStringToMap(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap hashMap = new HashMap(jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public void addFbPixelEventTokenMapping(String str, String str2) {
        this.fbPixelMapping.put(str, str2);
    }

    @JavascriptInterface
    public String getProtocol() {
        return PROTOCOL;
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (str == null) {
            AdjustFactory.getLogger().error("Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration", new Object[0]);
            return;
        }
        String str4 = this.fbPixelMapping.get(str2);
        if (str4 == null) {
            AdjustFactory.getLogger().debug("No mapping found for the fb pixel event %s, trying to fall back to the default event token", str2);
            str4 = this.fbPixelDefaultEventToken;
        }
        if (str4 == null) {
            AdjustFactory.getLogger().warn("There is not a default event token configured or a mapping found for event named: '%s'. It won't be tracked as an adjust event", str2);
            return;
        }
        AdjustEvent adjustEvent = new AdjustEvent(str4);
        if (adjustEvent.isValid()) {
            Map<String, String> jsonStringToMap = jsonStringToMap(str3);
            jsonStringToMap.put(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
            AdjustFactory.getLogger().debug("FB pixel event received, eventName: %s, payload: %s", str2, jsonStringToMap);
            for (Map.Entry next : jsonStringToMap.entrySet()) {
                adjustEvent.addPartnerParameter((String) next.getKey(), (String) next.getValue());
            }
            Adjust.trackEvent(adjustEvent);
        }
    }

    public void setDefaultEventToken(String str) {
        this.fbPixelDefaultEventToken = str;
    }
}
