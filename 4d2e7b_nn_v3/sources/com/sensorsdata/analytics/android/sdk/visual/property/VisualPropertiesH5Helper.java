package com.sensorsdata.analytics.android.sdk.visual.property;

import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewNode;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable;
import com.sensorsdata.analytics.android.sdk.visual.bridge.JSBridgeHelper;
import com.sensorsdata.analytics.android.sdk.visual.bridge.OnBridgeCallback;
import com.sensorsdata.analytics.android.sdk.visual.bridge.WebViewJavascriptBridge;
import com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualPropertiesH5Helper implements WebViewJavascriptBridge {
    private JSBridgeHelper mJSBridgeHelper = new JSBridgeHelper();
    private SAEventListener mSAEventListener;
    /* access modifiers changed from: private */
    public SparseArray<JSONArray> mSparseArray = new SparseArray<>();

    private static String Base642string(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    private void addSAEventListener() {
        if (this.mSAEventListener == null) {
            this.mSAEventListener = new SAEventListener() {
                public void identify() {
                }

                public void login() {
                }

                public void logout() {
                }

                public void resetAnonymousId() {
                }

                public void trackEvent(JSONObject jSONObject) {
                    JSONObject optJSONObject;
                    try {
                        if (TextUtils.equals(VisualConstants.WEB_CLICK_EVENT_NAME, jSONObject.optString(NotificationCompat.CATEGORY_EVENT)) && (optJSONObject = jSONObject.optJSONObject(SAPropertyFilter.PROPERTIES)) != null) {
                            if (optJSONObject.has("sensorsdata_web_visual_eventName")) {
                                VisualPropertiesH5Helper.this.mSparseArray.put(jSONObject.hashCode(), optJSONObject.optJSONArray("sensorsdata_web_visual_eventName"));
                                optJSONObject.remove("sensorsdata_web_visual_eventName");
                            }
                            String optString = optJSONObject.optString("sensorsdata_app_visual_properties");
                            optJSONObject.remove("sensorsdata_app_visual_properties");
                            if (TextUtils.isEmpty(optString)) {
                                return;
                            }
                            if (AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                                String decodeString = Base64Coder.decodeString(optString);
                                if (!TextUtils.isEmpty(decodeString)) {
                                    try {
                                        JSONArray jSONArray = new JSONArray(decodeString);
                                        ViewTreeStatusObservable.getInstance().clearViewNodeCache();
                                        if (jSONArray.length() > 0) {
                                            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                                                VisualConfig.VisualProperty visualProperty = new VisualConfig.VisualProperty();
                                                visualProperty.elementPath = jSONObject2.optString("element_path");
                                                visualProperty.elementPosition = jSONObject2.optString("element_position");
                                                visualProperty.screenName = jSONObject2.optString(FirebaseAnalytics.Param.SCREEN_NAME);
                                                visualProperty.name = jSONObject2.optString("name");
                                                visualProperty.regular = jSONObject2.optString("regular");
                                                visualProperty.isH5 = jSONObject2.optBoolean("h5");
                                                visualProperty.type = jSONObject2.optString("type");
                                                visualProperty.webViewElementPath = jSONObject2.optString("webview_element_path");
                                                VisualPropertiesManager.getInstance().mergeAppVisualProperty(visualProperty, (VisualConfig.VisualEvent) null, optJSONObject, (ViewNode) null);
                                            }
                                        }
                                    } catch (JSONException e10) {
                                        SALog.printStackTrace(e10);
                                    }
                                }
                            }
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            };
            SensorsDataAPI.sharedInstance().addEventListener(this.mSAEventListener);
        }
    }

    private void getJSVisualProperties(View view, String str, String str2, OnBridgeCallback onBridgeCallback) {
        try {
            JSONArray h5JsonArrayFromCache = VisualPropertiesManager.getInstance().getVisualPropertiesCache().getH5JsonArrayFromCache(str2, str);
            if (h5JsonArrayFromCache != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sensorsdata_js_visual_properties", h5JsonArrayFromCache);
                } catch (JSONException e10) {
                    SALog.printStackTrace(e10);
                }
                sendToWeb(view, "getJSVisualProperties", jSONObject, onBridgeCallback);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void clearCache(int i10) {
        try {
            this.mSparseArray.remove(i10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public JSONArray getEventName(int i10) {
        try {
            return this.mSparseArray.get(i10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void mergeJSVisualProperties(final JSONObject jSONObject, HashSet<String> hashSet, String str) {
        View view;
        if (hashSet != null) {
            try {
                if (hashSet.size() != 0) {
                    Iterator<String> it = hashSet.iterator();
                    final CountDownLatch countDownLatch = new CountDownLatch(hashSet.size());
                    while (it.hasNext()) {
                        ViewNode viewNode = ViewTreeStatusObservable.getInstance().getViewNode(it.next());
                        if (!(viewNode == null || viewNode.getView() == null || (view = viewNode.getView().get()) == null)) {
                            getJSVisualProperties(view, viewNode.getViewPath(), str, new OnBridgeCallback() {
                                public void onCallBack(String str) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(str);
                                        Iterator<String> keys = jSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            String optString = jSONObject.optString(next);
                                            if (!TextUtils.isEmpty(next)) {
                                                jSONObject.put(next, optString);
                                            }
                                        }
                                    } catch (JSONException e10) {
                                        SALog.printStackTrace(e10);
                                    } catch (Throwable th) {
                                        countDownLatch.countDown();
                                        throw th;
                                    }
                                    countDownLatch.countDown();
                                }
                            });
                        }
                    }
                    try {
                        countDownLatch.await(500, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void registerListeners() {
        try {
            this.mJSBridgeHelper.addSAJSListener();
            addSAEventListener();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void sendToWeb(View view, String str, Object obj, OnBridgeCallback onBridgeCallback) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj, onBridgeCallback);
    }

    public void sendToWeb(View view, String str, Object obj) {
        this.mJSBridgeHelper.sendToWeb(view, str, obj);
    }
}
