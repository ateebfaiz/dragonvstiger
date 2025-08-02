package com.zing.zalo.zalosdk.oauth;

import android.content.Context;
import android.os.AsyncTask;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.type.EventType;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;
import com.zing.zalo.zalosdk.payment.direct.Utils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AuthenExtTask extends AsyncTask<Void, Void, JSONObject> {
    private JSONObject appExtInfo;
    protected Context context;
    private EventType eventType;

    protected AuthenExtTask(Context context2, JSONObject jSONObject, EventType eventType2) {
        this.context = context2.getApplicationContext();
        this.appExtInfo = jSONObject;
        this.eventType = eventType2;
    }

    /* access modifiers changed from: protected */
    public abstract void customizeEventLog(Map<String, String> map);

    /* access modifiers changed from: protected */
    public abstract void customizeParam(HttpClientRequest httpClientRequest);

    /* access modifiers changed from: protected */
    public HttpClientRequest genRequest() {
        HttpClientRequest httpClientRequest = new HttpClientRequest(requestType(), requestUrl());
        httpClientRequest.addParams(Constant.PARAM_APP_ID, String.valueOf(ZaloSDKApplication.appID));
        httpClientRequest.addParams("sign_key", AppInfo.getApplicationHashKey(this.context));
        httpClientRequest.addParams("pkg_name", AppInfo.getPackageName(this.context));
        try {
            httpClientRequest.addParams("ext_info", Utils.getExtInfo(this.appExtInfo, false));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return httpClientRequest;
    }

    /* access modifiers changed from: protected */
    public HttpClientRequest.Type requestType() {
        return HttpClientRequest.Type.POST;
    }

    /* access modifiers changed from: protected */
    public abstract String requestUrl();

    /* access modifiers changed from: protected */
    public void submitEventLog(int i10) {
        try {
            if (this.eventType != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(DbParams.KEY_CHANNEL_RESULT, i10 + "");
                customizeEventLog(hashMap);
                com.zing.zalo.zalosdk.core.helper.Utils.addEventZingAnalytics(this.eventType, (Map<String, String>) hashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject doInBackground(Void... voidArr) {
        HttpClientRequest genRequest = genRequest();
        customizeParam(genRequest);
        Log.i("debuglog", "link: " + requestUrl());
        try {
            Log.i("debuglog", getClass().getSimpleName() + ": " + genRequest.getJSONString());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return genRequest.getJSON();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(JSONObject jSONObject) {
        Log.i("debuglog", getClass().getSimpleName() + "--onPostResult-----: " + jSONObject);
        try {
            ZaloSDK.Instance.getAuthenticator().getOAuthCompleteListener().onFinishLoading();
        } catch (Exception unused) {
        }
        int i10 = 0;
        try {
            int i11 = jSONObject.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            String str = jSONObject.getString("errorMsg") + " " + getClass().getSimpleName();
            if (i11 == 0) {
                ZaloSDK.Instance.getAuthenticator().getLoginFormOAuthCompleteListener().onRequestAccountProtect(i11, str);
                i10 = 1;
            } else {
                ZaloSDK.Instance.getAuthenticator().getLoginFormOAuthCompleteListener().onAuthenError(new ErrorResponse(i11, str));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            ZaloSDK.Instance.getAuthenticator().getLoginFormOAuthCompleteListener().onAuthenError(new ErrorResponse(ZaloOAuthResultCode.ERR_UNKNOWN_ERROR, ZaloOAuthResultCode.findErrorMessageByID(this.context, ZaloOAuthResultCode.ERR_UNKNOWN_ERROR)));
        }
        submitEventLog(i10);
    }
}
