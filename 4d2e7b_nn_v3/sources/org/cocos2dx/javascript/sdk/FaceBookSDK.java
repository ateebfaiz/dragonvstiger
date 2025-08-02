package org.cocos2dx.javascript.sdk;

import android.os.Bundle;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import e2.g;
import org.cocos2dx.javascript.PlatformUtils;

public class FaceBookSDK {
    private static g mEventsLogger;

    public static void EventBurialPoint(String str, String str2) {
        Log.v("FaceBookSDKBurialPoint", str + " " + str2);
        init();
        Bundle bundle = new Bundle();
        JSONObject parseObject = JSON.parseObject(str2);
        for (String next : parseObject.keySet()) {
            bundle.putString(next, parseObject.getString(next));
        }
        mEventsLogger.b(str, bundle);
    }

    private static void init() {
        if (mEventsLogger == null) {
            mEventsLogger = g.c(PlatformUtils.context);
        }
    }
}
