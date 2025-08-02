package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.pdns.f;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.DeviceHelper;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class GetPreloadSettingAsyncTask extends AsyncTask<Context, Void, Boolean> {
    Callback callback;
    String deviceId;
    WeakReference<Context> weakContext;

    public interface Callback {
        void onFailed(int i10, String str);

        void onSuccess();
    }

    public GetPreloadSettingAsyncTask(Context context, Callback callback2, String str) {
        this.weakContext = new WeakReference<>(context);
        this.callback = callback2;
        this.deviceId = str;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(Context... contextArr) {
        try {
            Context context = this.weakContext.get();
            if (context == null) {
                this.callback.onFailed(-1, "Error message: GetPreloadSettingAsyncTask has empty context!");
                return Boolean.FALSE;
            }
            SettingsManager instance = SettingsManager.getInstance();
            HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_CENTRALIZED, Constant.API_GET_PRELOAD_SETTING));
            httpClientRequest.addParams("pl", f.f17924q);
            httpClientRequest.addParams("appId", AppInfo.getAppId(context));
            httpClientRequest.addParams("sdkv", DeviceTracking.getInstance().getVersion());
            httpClientRequest.addParams("pkg", context.getPackageName());
            httpClientRequest.addParams("adid", DeviceHelper.getAdvertiseID(context));
            httpClientRequest.addParams("zdId", this.deviceId);
            try {
                JSONObject json = httpClientRequest.getJSON();
                int i10 = json.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                if (i10 == 0) {
                    JSONObject jSONObject = json.getJSONObject("data");
                    if (jSONObject != null) {
                        if (jSONObject.has("setting")) {
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
                            if (jSONObject2.has("expiredTime")) {
                                instance.saveExpiredTimePreloadSetting(context, jSONObject2.getLong("expiredTime") + System.currentTimeMillis());
                            }
                            if (jSONObject2.has("token_resubmit_age")) {
                                instance.saveResubmitIntervalPreloadSetting(context, jSONObject2.getInt("token_resubmit_age"));
                            }
                        }
                    }
                    Callback callback2 = this.callback;
                    if (callback2 != null) {
                        callback2.onFailed(i10, "");
                    }
                } else {
                    Callback callback3 = this.callback;
                    if (callback3 != null) {
                        callback3.onFailed(i10, "");
                    }
                }
            } catch (Exception e10) {
                Callback callback4 = this.callback;
                if (callback4 != null) {
                    callback4.onFailed(-108, "Exception error " + e10.getMessage());
                }
            }
            Callback callback5 = this.callback;
            if (callback5 != null) {
                callback5.onSuccess();
            }
            return Boolean.TRUE;
        } catch (Exception e11) {
            Callback callback6 = this.callback;
            if (callback6 != null) {
                callback6.onFailed(-1, "Exception error " + e11.getMessage());
            }
        }
    }
}
