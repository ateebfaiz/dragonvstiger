package com.sensorsdata.analytics.android.sdk.visual.property;

import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import com.sensorsdata.analytics.android.sdk.visual.utils.FlutterUtils;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualPropertiesCache {
    private static final String TAG = "SA.VP.VisualPropertiesCache";

    private void doOnSaveCache(String str) {
        try {
            List<View> currentWebView = ViewTreeStatusObservable.getInstance().getCurrentWebView();
            if (currentWebView == null) {
                return;
            }
            if (currentWebView.size() != 0) {
                for (View sendToWeb : currentWebView) {
                    VisualPropertiesManager.getInstance().getVisualPropertiesH5Helper().sendToWeb(sendToWeb, "updateH5VisualConfig", str);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public JSONArray getH5JsonArrayFromCache(String str, String str2) {
        String str3 = (String) PersistentLoader.getInstance().getVisualConfigPst().get();
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray = jSONObject.optJSONArray(DbParams.TABLE_EVENTS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new VisualConfig.VisualPropertiesConfig();
                        String optString = optJSONObject.optString(DbParams.KEY_CHANNEL_EVENT_NAME);
                        visualPropertiesConfig.eventName = optString;
                        if (TextUtils.equals(optString, str)) {
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(SAPropertyFilter.PROPERTIES);
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i11);
                                    VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                    String optString2 = optJSONObject2.optString("webview_element_path");
                                    visualProperty.webViewElementPath = optString2;
                                    if (TextUtils.equals(optString2, str2)) {
                                        jSONArray.put(optJSONObject2);
                                    }
                                }
                            }
                        }
                    }
                }
                return jSONArray;
            }
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return null;
    }

    public String getVisualCache() {
        return (String) PersistentLoader.getInstance().getVisualConfigPst().get();
    }

    public VisualConfig getVisualConfig() {
        String str = (String) PersistentLoader.getInstance().getVisualConfigPst().get();
        SALog.i(TAG, "local visual config is :" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            VisualConfig visualConfig = new VisualConfig();
            JSONObject jSONObject = new JSONObject(str);
            visualConfig.appId = jSONObject.optString(Constant.PARAM_APP_ID);
            visualConfig.os = jSONObject.optString("os");
            visualConfig.project = jSONObject.optString("project");
            visualConfig.version = jSONObject.optString("version");
            JSONArray optJSONArray = jSONObject.optJSONArray(DbParams.TABLE_EVENTS);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                    if (optJSONObject != null) {
                        VisualConfig.VisualPropertiesConfig visualPropertiesConfig = new VisualConfig.VisualPropertiesConfig();
                        visualPropertiesConfig.eventName = optJSONObject.optString(DbParams.KEY_CHANNEL_EVENT_NAME);
                        visualPropertiesConfig.eventType = optJSONObject.optString("event_type");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT);
                        if (optJSONObject2 != null) {
                            VisualConfig.VisualEvent visualEvent = new VisualConfig.VisualEvent();
                            visualEvent.elementPath = optJSONObject2.optString("element_path");
                            visualEvent.elementPosition = optJSONObject2.optString("element_position");
                            visualEvent.elementContent = optJSONObject2.optString("element_content");
                            visualEvent.screenName = optJSONObject2.optString(FirebaseAnalytics.Param.SCREEN_NAME);
                            visualEvent.limitElementPosition = optJSONObject2.optBoolean("limit_element_position");
                            visualEvent.limitElementContent = optJSONObject2.optBoolean("limit_element_content");
                            visualEvent.isH5 = optJSONObject2.optBoolean("h5");
                            visualPropertiesConfig.event = visualEvent;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(SAPropertyFilter.PROPERTIES);
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i11);
                                VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                visualProperty.elementPath = optJSONObject3.optString("element_path");
                                visualProperty.elementPosition = optJSONObject3.optString("element_position");
                                visualProperty.screenName = optJSONObject3.optString(FirebaseAnalytics.Param.SCREEN_NAME);
                                visualProperty.name = optJSONObject3.optString("name");
                                visualProperty.regular = optJSONObject3.optString("regular");
                                visualProperty.isH5 = optJSONObject3.optBoolean("h5");
                                visualProperty.type = optJSONObject3.optString("type");
                                visualProperty.webViewElementPath = optJSONObject3.optString("webview_element_path");
                                arrayList2.add(visualProperty);
                            }
                            visualPropertiesConfig.properties = arrayList2;
                        }
                        arrayList.add(visualPropertiesConfig);
                    }
                }
                visualConfig.events = arrayList;
            }
            return visualConfig;
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public void save2Cache(String str) {
        SALog.i(TAG, "save2Cache config is:" + str);
        PersistentLoader.getInstance().getVisualConfigPst().commit(str);
        doOnSaveCache(str);
        FlutterUtils.visualizedPropertiesConfigChanged();
    }
}
