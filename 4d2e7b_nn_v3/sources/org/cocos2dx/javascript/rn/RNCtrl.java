package org.cocos2dx.javascript.rn;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import org.cocos2dx.javascript.AppActivity;

public class RNCtrl {
    private static final String TAG = "RNCtrl";
    private static AppActivity mActivity;
    public static WritableMap nativeData = Arguments.createMap();

    private static WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i10 = 0; i10 < jSONArray.size(); i10++) {
            Object obj = jSONArray.get(i10);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    private static WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        for (String next : jSONObject.keySet()) {
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeMap.putString(next, (String) obj);
            } else if (obj != null) {
                writableNativeMap.putString(next, obj.toString());
            }
        }
        return writableNativeMap;
    }

    public static void receiveDataFromCocos(AppActivity appActivity, String str) {
        if (!str.isEmpty()) {
            if (mActivity == null) {
                mActivity = appActivity;
            }
            Log.i(TAG, "from cocos:" + str);
            JSONObject parseObject = JSON.parseObject(str);
            int intValue = parseObject.getInteger("pageType").intValue();
            if (intValue == -1) {
                if (parseObject.getJSONObject("data") != null) {
                    RNModule instance = RNModule.getInstance();
                    if (instance != null) {
                        instance.sendEventToRN(str);
                    } else {
                        Log.d(TAG, "receiveDataFromCocos, rn没初始化");
                    }
                }
            } else if (intValue == 0) {
                JSONObject jSONObject = parseObject.getJSONObject("data");
                if (jSONObject != null) {
                    nativeData.merge(convertJsonToMap(jSONObject));
                    Log.d(TAG, "receiveDataFromCocos, 保存数据, 大小: ");
                }
            } else {
                Log.d(TAG, "receiveDataFromCocos, 展示RN页面: " + intValue);
                if (!RNDelegateManager.getInstance().isVisible()) {
                    RNDelegateManager.getInstance().show(String.valueOf(intValue), JSON.toJSONString(parseObject.get("data")));
                    return;
                }
                RNModule instance2 = RNModule.getInstance();
                if (instance2 != null) {
                    instance2.sendEventToRN(str);
                } else {
                    Log.d(TAG, "receiveDataFromCocos, rn没初始化");
                }
            }
        }
    }
}
