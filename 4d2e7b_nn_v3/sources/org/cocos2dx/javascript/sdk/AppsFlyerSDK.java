package org.cocos2dx.javascript.sdk;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import org.cocos2dx.javascript.PlatformUtils;

public class AppsFlyerSDK {
    public static final String APPS_FLYER_SDK_LOG = "AppsFlyerSDKBurialPoint";

    class a implements AppsFlyerRequestListener {
        a() {
        }

        public void onError(int i10, String str) {
            Log.d(AppsFlyerSDK.APPS_FLYER_SDK_LOG, "Event failed to be sent:\nError code: " + i10 + "\nError description: " + str);
        }

        public void onSuccess() {
            Log.d(AppsFlyerSDK.APPS_FLYER_SDK_LOG, "Event sent successfully");
        }
    }

    public static void EventBurialPoint(String str, String str2) {
        Log.v(APPS_FLYER_SDK_LOG, str + " " + str2);
        HashMap hashMap = new HashMap();
        JSONObject parseObject = JSON.parseObject(str2);
        if (str.equals(Constant.FIRST_RECHARGE) || str.equals(Constant.RECHARGE) || str.equals(Constant.WITHDRAW_SUCCESS)) {
            double doubleValue = parseObject.getDouble("amount").doubleValue();
            String string = parseObject.getString(FirebaseAnalytics.Param.CURRENCY);
            if (str.equals(Constant.WITHDRAW_SUCCESS) && doubleValue > 0.0d) {
                doubleValue *= -1.0d;
            }
            Log.v(APPS_FLYER_SDK_LOG, doubleValue + "--" + string);
            hashMap.put(AFInAppEventParameterName.CONTENT_TYPE, string);
            hashMap.put(AFInAppEventParameterName.REVENUE, Double.valueOf(doubleValue));
        } else {
            for (String next : parseObject.keySet()) {
                hashMap.put(next, parseObject.getString(next));
            }
        }
        pushEvent(str, hashMap);
    }

    public static String getUid() {
        try {
            return AppsFlyerLib.getInstance().getAppsFlyerUID(PlatformUtils.context);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void init() {
        String infoValue = PlatformUtils.getInfoValue("appsFlyerKey");
        if (!infoValue.isEmpty()) {
            AppsFlyerLib.getInstance().init(infoValue, (AppsFlyerConversionListener) null, PlatformUtils.context);
            AppsFlyerLib.getInstance().start(PlatformUtils.context);
        }
    }

    private static void pushEvent(String str, Map<String, Object> map) {
        Log.v(APPS_FLYER_SDK_LOG, "send --> " + str);
        AppsFlyerLib.getInstance().logEvent(PlatformUtils.context, str, map, new a());
    }
}
