package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.pdns.f;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.DeviceHelper;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class GetSDKSettingAsyncTask extends AsyncTask<Context, Void, String> {
    Callback callback;
    long expiredTime;
    long wakeup_interval;
    boolean wakeup_interval_enable;
    WeakReference<Context> weakContext;
    String zdId;

    public interface Callback {
        void onFailed(int i10, String str);

        void onSucc(long j10);
    }

    public GetSDKSettingAsyncTask(Context context, Callback callback2, String str) {
        this.weakContext = new WeakReference<>(context);
        this.callback = callback2;
        this.zdId = str;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Context... contextArr) {
        try {
            Context context = this.weakContext.get();
            if (context == null) {
                return "";
            }
            SettingsManager instance = SettingsManager.getInstance();
            HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_CENTRALIZED, Constant.API_GET_SETTING_URL));
            httpClientRequest.addParams("pl", f.f17924q);
            httpClientRequest.addParams("appId", AppInfo.getAppId(context));
            httpClientRequest.addParams("sdkv", DeviceTracking.getInstance().getVersion());
            httpClientRequest.addParams("pkg", context.getPackageName());
            httpClientRequest.addParams("adid", DeviceHelper.getAdvertiseID(context));
            httpClientRequest.addParams("zdId", this.zdId);
            try {
                JSONObject json = httpClientRequest.getJSON();
                int i10 = json.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                if (i10 == 0) {
                    JSONObject jSONObject = json.getJSONObject("data");
                    if (jSONObject != null) {
                        if (jSONObject.has("setting")) {
                            instance.setUseWebViewUnLoginZalo(context, Utils.getBoolean(jSONObject, "webview_login"));
                            instance.setLoginViaBrowser(context, Utils.getBoolean(jSONObject, "isOutAppLogin"));
                            JSONObject jSONObject2 = jSONObject.getJSONObject("setting");
                            if (jSONObject2.has("model_preload")) {
                                instance.setModelPreloadSetting(context, jSONObject2.getJSONArray("model_preload").toString());
                            }
                            if (jSONObject2.has("brand_preload")) {
                                instance.setBrandPreloadSetting(context, jSONObject2.getJSONArray("brand_preload").toString());
                            }
                            if (jSONObject2.has("preload_default")) {
                                instance.setPreloadDefaultSetting(context, jSONObject2.getJSONArray("preload_default").toString());
                            }
                            if (jSONObject2.has("wakeup_interval")) {
                                long j10 = jSONObject2.getLong("wakeup_interval");
                                this.wakeup_interval = j10;
                                instance.saveWakeUpInterval(context, j10);
                                if (jSONObject2.has("expiredTime")) {
                                    long j11 = jSONObject2.getLong("expiredTime");
                                    this.expiredTime = j11;
                                    instance.saveExpiredSetting(context, j11 + System.currentTimeMillis());
                                }
                                if (jSONObject2.has("wakeup_interval_enable")) {
                                    boolean z10 = jSONObject2.getBoolean("wakeup_interval_enable");
                                    this.wakeup_interval_enable = z10;
                                    instance.saveWakeUpSetting(context, z10);
                                }
                                Callback callback2 = this.callback;
                                if (callback2 != null) {
                                    callback2.onSucc(this.wakeup_interval);
                                }
                            } else {
                                Callback callback3 = this.callback;
                                if (callback3 != null) {
                                    callback3.onFailed(i10, "");
                                }
                            }
                        }
                    }
                    Callback callback4 = this.callback;
                    if (callback4 != null) {
                        callback4.onFailed(i10, "");
                    }
                } else {
                    Callback callback5 = this.callback;
                    if (callback5 != null) {
                        callback5.onFailed(i10, "");
                    }
                }
            } catch (Exception e10) {
                Callback callback6 = this.callback;
                if (callback6 != null) {
                    callback6.onFailed(-108, "Exception error " + e10.getMessage());
                }
            }
            return "";
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
