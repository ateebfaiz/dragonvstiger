package org.cocos2dx.javascript.sdk;

import android.os.Bundle;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.cocos2dx.javascript.PlatformUtils;

public class FireBaseSDK {
    private static FirebaseAnalytics mFirebaseAnalytics;

    public static void EventBurialPoint(String str, String str2) {
        Log.v("FireBaseSDKBurialPoint", str + " " + str2);
        init();
        Bundle bundle = new Bundle();
        JSONObject parseObject = JSON.parseObject(str2);
        for (String next : parseObject.keySet()) {
            bundle.putString(next, parseObject.getString(next));
        }
        mFirebaseAnalytics.logEvent(str, bundle);
    }

    private static void init() {
        if (mFirebaseAnalytics == null) {
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(PlatformUtils.context);
        }
    }
}
