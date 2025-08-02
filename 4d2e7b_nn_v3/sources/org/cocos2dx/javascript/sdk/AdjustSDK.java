package org.cocos2dx.javascript.sdk;

import android.util.Log;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import org.cocos2dx.javascript.PlatformUtils;

public class AdjustSDK {
    public static final String ADJUST_SDK_LOG = "AdjustSDKLog";
    public static final Map<String, String> eventCodeMap = new HashMap();

    public static void EventBurialPoint(String str, String str2) {
        String str3 = eventCodeMap.get(str);
        if (str3 == null || str3.isEmpty()) {
            Log.d(ADJUST_SDK_LOG, "event(" + str + ") hasn't code");
            return;
        }
        AdjustEvent adjustEvent = new AdjustEvent(str3);
        if (str.equals(Constant.FIRST_RECHARGE) || str.equals(Constant.RECHARGE) || str.equals(Constant.WITHDRAW_SUCCESS)) {
            JSONObject parseObject = JSON.parseObject(str2);
            Log.d(ADJUST_SDK_LOG, "Start Parse");
            double doubleValue = parseObject.getDouble("amount").doubleValue();
            if (str.equals(Constant.WITHDRAW_SUCCESS) && doubleValue > 0.0d) {
                doubleValue *= -1.0d;
            }
            String string = parseObject.getString(FirebaseAnalytics.Param.CURRENCY);
            Log.d(ADJUST_SDK_LOG, doubleValue + " " + string);
            adjustEvent.setRevenue(doubleValue, string);
        }
        Adjust.trackEvent(adjustEvent);
    }

    public static String getAdid() {
        String adid = Adjust.getAdid();
        if (adid == null) {
            return "";
        }
        return adid;
    }

    public static void init() {
        String infoValue = PlatformUtils.getInfoValue("adjustToken");
        if (!infoValue.isEmpty()) {
            parseEventCode();
            PlatformUtils.sdkResume = new a();
            PlatformUtils.sdkPause = new b();
            AdjustConfig adjustConfig = new AdjustConfig(PlatformUtils.context, infoValue, AdjustConfig.ENVIRONMENT_PRODUCTION);
            adjustConfig.setLogLevel(LogLevel.INFO);
            Adjust.onCreate(adjustConfig);
        }
    }

    private static void parseEventCode() {
        String infoValue = PlatformUtils.getInfoValue("adjustEventCode");
        if (!infoValue.isEmpty()) {
            String[] split = infoValue.split(",");
            if (split.length >= 1) {
                for (String split2 : split) {
                    String[] split3 = split2.split(":");
                    if (split3.length == 2) {
                        eventCodeMap.put(split3[0], split3[1]);
                    }
                }
            }
        }
    }
}
