package com.zing.zalo.zalosdk.oauth;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.core.type.EventType;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ZaloAPIService {
    private static final String AUTH_MOBILE_ACCESS_TOKEN_PATH = "/v3/mobile/access_token";
    private static final String AUTH_MOBILE_ACCESS_TOKEN_PATH_V4 = "/v4/access_token";
    private static final String GRAPH_APP_REQUESTS_PATH = "/v2.0/apprequests";
    private static final String GRAPH_ME_FEED_PATH = "/v2.0/me/feed";
    private static final String GRAPH_ME_FRIENDS_PATH = "/v2.0/me/friends";
    private static final String GRAPH_ME_INVITABLE_FRIENDS_PATH = "/v2.0/me/invitable_friends";
    private static final String GRAPH_ME_MESSAGE_PATH = "/v2.0/me/message";
    private static final String GRAPH_OA_MESSAGE_PATH = "/v2.0/oa/message";
    private static final String GRAPH_V2_ME_PATH = "/v2.0/me";
    public static final String UTF8 = "UTF-8";
    private String mNewUrl = "https://graph.zaloapp.com/v2.0/me";
    private OauthStorage mStorage;

    private class GetTokenTask extends AsyncTask<HttpClientRequest, Void, JSONObject> {
        Context ctx;
        ZaloOpenAPICallback mOpenAPICallbackAsync;

        GetTokenTask(Context context, ZaloOpenAPICallback zaloOpenAPICallback) {
            this.ctx = context;
            this.mOpenAPICallbackAsync = zaloOpenAPICallback;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public JSONObject doInBackground(HttpClientRequest... httpClientRequestArr) {
            JSONObject json = httpClientRequestArr[0].getJSON();
            if (json != null) {
                return json;
            }
            try {
                return new JSONObject("{\"error\":-7001}");
            } catch (JSONException e10) {
                e10.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GetTokenTask: callback is Null?");
            sb2.append(this.mOpenAPICallbackAsync == null);
            Log.v(sb2.toString());
            if (jSONObject != null) {
                try {
                    ZaloOpenAPICallback zaloOpenAPICallback = this.mOpenAPICallbackAsync;
                    if (zaloOpenAPICallback != null) {
                        zaloOpenAPICallback.onResult(jSONObject);
                    }
                } catch (Exception unused) {
                }
            } else {
                ZaloOpenAPICallback zaloOpenAPICallback2 = this.mOpenAPICallbackAsync;
                if (zaloOpenAPICallback2 != null) {
                    zaloOpenAPICallback2.onResult(new JSONObject("{\"error\":-8000}"));
                }
            }
        }
    }

    private class RequestAPITask extends AsyncTask<HttpClientRequest, Void, JSONObject> {
        EventType eventType;
        ZaloOpenAPICallback mOpenAPICallbackAsync;

        RequestAPITask(Context context, ZaloOpenAPICallback zaloOpenAPICallback, EventType eventType2) {
            this.mOpenAPICallbackAsync = zaloOpenAPICallback;
            this.eventType = eventType2;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public JSONObject doInBackground(HttpClientRequest... httpClientRequestArr) {
            return httpClientRequestArr[0].getJSON();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RequestAPITask: callback is Null?");
            int i10 = 0;
            int i11 = 1;
            sb2.append(this.mOpenAPICallbackAsync == null);
            Log.v(sb2.toString());
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject("{\"error\":-8000}");
                    i11 = 0;
                } catch (Exception unused) {
                    ZaloOpenAPICallback zaloOpenAPICallback = this.mOpenAPICallbackAsync;
                    if (zaloOpenAPICallback != null) {
                        zaloOpenAPICallback.onResult(new JSONObject());
                    }
                }
            }
            ZaloOpenAPICallback zaloOpenAPICallback2 = this.mOpenAPICallbackAsync;
            if (zaloOpenAPICallback2 != null) {
                zaloOpenAPICallback2.onResult(jSONObject);
            }
            i10 = i11;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(DbParams.KEY_CHANNEL_RESULT, i10 + "");
                Utils.addEventZingAnalytics(this.eventType, (Map<String, String>) hashMap);
            } catch (Exception unused2) {
            }
        }
    }

    ZaloAPIService(OauthStorage oauthStorage) {
        this.mStorage = oauthStorage;
    }

    private String buildFieldsParam(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < strArr.length - 1; i10++) {
            stringBuffer.append(strArr[i10]);
            stringBuffer.append(",");
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        return stringBuffer.toString();
    }

    private void validateField(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public void broadcastViaOfficalAccount(Context context, String str, String str2, String str3, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_OA_MESSAGE_PATH));
        httpClientRequest.addParams("templateid", str2);
        httpClientRequest.addParams("templatedata", str3);
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.SEND_OA_MSG).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getAccessTokenByOAuthCode(Context context, String str, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "oauthCode must be set.");
        validateField(str2, "codeVerifier must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, AUTH_MOBILE_ACCESS_TOKEN_PATH_V4));
        httpClientRequest.addParams(Constant.PARAM_OAUTH_CODE, str);
        httpClientRequest.addParams(Constant.PARAM_APP_ID, ZaloSDK.Instance.getAppID() + "");
        httpClientRequest.addParams("grant_type", ZaloSDK.Instance.getGrantType(true));
        httpClientRequest.addParams("code_verifier", str2);
        new GetTokenTask(context, zaloOpenAPICallback).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getAccessTokenByRefreshToken(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "refresh_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, AUTH_MOBILE_ACCESS_TOKEN_PATH_V4));
        httpClientRequest.addParams("refresh_token", str);
        httpClientRequest.addParams(Constant.PARAM_APP_ID, ZaloSDK.Instance.getAppID() + "");
        httpClientRequest.addParams("grant_type", ZaloSDK.Instance.getGrantType(false));
        new GetTokenTask(context, zaloOpenAPICallback).execute(new HttpClientRequest[]{httpClientRequest});
    }

    /* access modifiers changed from: package-private */
    public void getFriendListInvitable(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_INVITABLE_FRIENDS_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addParams("offset", i10 + "");
        httpClientRequest.addParams("limit", i11 + "");
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_INVITABLE_FRIEND).execute(new HttpClientRequest[]{httpClientRequest});
    }

    /* access modifiers changed from: package-private */
    public void getFriendListUsedApp(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_FRIENDS_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addParams("offset", i10 + "");
        httpClientRequest.addParams("limit", i11 + "");
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_FRIEND).execute(new HttpClientRequest[]{httpClientRequest});
    }

    /* access modifiers changed from: package-private */
    public void getProfile(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_V2_ME_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_PROFILE).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void inviteFriendUseApp(Context context, String str, String[] strArr, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_APP_REQUESTS_PATH));
        httpClientRequest.addParams("to", buildFieldsParam(strArr));
        httpClientRequest.addParams("message", str2);
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.SEND_APP_REQUEST).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void sendMsgToFriend(Context context, String str, String str2, String str3, String str4, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_MESSAGE_PATH));
        httpClientRequest.addParams("to", str2);
        httpClientRequest.addParams("message", str3);
        httpClientRequest.addParams("link", str4);
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.SEND_MSG).execute(new HttpClientRequest[]{httpClientRequest});
    }

    private void validateField(String str, ErrorResponse errorResponse, ZaloOpenAPICallback zaloOpenAPICallback) {
        if (TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, errorResponse.getErrorCode());
                jSONObject.put("errorMsg", errorResponse.getErrorMsg());
                zaloOpenAPICallback.onResult(jSONObject);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
    }
}
