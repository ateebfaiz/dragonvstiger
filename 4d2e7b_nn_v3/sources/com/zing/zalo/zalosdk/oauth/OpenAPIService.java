package com.zing.zalo.zalosdk.oauth;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.internal.AssetHelper;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.core.type.EventType;
import com.zing.zalo.zalosdk.oauth.WebDialog;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenAPIService {
    private static final String AUTH_MOBILE_ACCESS_TOKEN_PATH = "/v3/mobile/access_token";
    private static final String AUTH_MOBILE_ACCESS_TOKEN_PATH_V4 = "/v4/access_token";
    private static final String GRAPH_APP_REQUESTS_PATH = "/v2.0/apprequests";
    private static final String GRAPH_ME_FEED_PATH = "/v2.0/me/feed";
    private static final String GRAPH_ME_FRIENDS_PATH = "/v2.0/me/friends";
    private static final String GRAPH_ME_INVITABLE_FRIENDS_PATH = "/v2.0/me/invitable_friends";
    private static final String GRAPH_ME_MESSAGE_PATH = "/v2.0/me/message";
    private static final String GRAPH_OA_MESSAGE_PATH = "/v2.0/oa/message";
    private static final String GRAPH_V2_ME_PATH = "/v2.0/me";
    private static OpenAPIService Instance = null;
    private static final String UTF8 = "UTF-8";
    private static final String ZALO_PARAM_BACK_TO_SOURCE = "backToSource";
    private static final String ZALO_PARAM_POST_FEED = "postFeed";
    public boolean _autoBack;
    public String _shareTo;
    private BroadcastReceiver feedCallbackReceiver;
    private boolean isRegister;
    protected WeakReference<ZaloPluginCallback> mCallback;
    /* access modifiers changed from: private */
    public WeakReference<ZaloPluginCallback> mCallbackZaloClient;
    protected FeedData mFeedOb;
    private OauthStorage mStorage;
    protected WeakReference<Context> mWeakContext;
    private boolean shareMessageChatOnly;
    private ShareVia shareVia;
    /* access modifiers changed from: private */
    public String tokenShareZalo;
    /* access modifiers changed from: private */
    public boolean unableShareWebView;

    private class GetTokenTask extends AsyncTask<HttpClientRequest, Void, JSONObject> {
        Context ctx;
        WeakReference<ZaloOpenAPICallback> mOpenAPICallbackAsync;

        GetTokenTask(Context context, WeakReference<ZaloOpenAPICallback> weakReference) {
            this.ctx = context;
            this.mOpenAPICallbackAsync = weakReference;
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
            if (jSONObject != null) {
                try {
                    WeakReference<ZaloOpenAPICallback> weakReference = this.mOpenAPICallbackAsync;
                    if (weakReference != null && weakReference.get() != null) {
                        this.mOpenAPICallbackAsync.get().onResult(jSONObject);
                    }
                } catch (Exception unused) {
                }
            } else {
                WeakReference<ZaloOpenAPICallback> weakReference2 = this.mOpenAPICallbackAsync;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.mOpenAPICallbackAsync.get().onResult(new JSONObject("{\"error\":-8000}"));
                }
            }
        }
    }

    private class RequestAPITask extends AsyncTask<HttpClientRequest, Void, JSONObject> {
        EventType eventType;
        ZaloOpenAPICallback mOpenAPICallbackNewAPI;

        RequestAPITask(Context context, ZaloOpenAPICallback zaloOpenAPICallback, EventType eventType2) {
            this.mOpenAPICallbackNewAPI = zaloOpenAPICallback;
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
            int i10;
            int i11 = 0;
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject("{\"error\":-8000}");
                    i10 = 0;
                } catch (Exception unused) {
                    ZaloOpenAPICallback zaloOpenAPICallback = this.mOpenAPICallbackNewAPI;
                    if (zaloOpenAPICallback != null) {
                        zaloOpenAPICallback.onResult(new JSONObject());
                    }
                }
            } else {
                i10 = 1;
            }
            ZaloOpenAPICallback zaloOpenAPICallback2 = this.mOpenAPICallbackNewAPI;
            if (zaloOpenAPICallback2 != null) {
                zaloOpenAPICallback2.onResult(jSONObject);
            }
            i11 = i10;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(DbParams.KEY_CHANNEL_RESULT, i11 + "");
                Utils.addEventZingAnalytics(this.eventType, (Map<String, String>) hashMap);
            } catch (Exception unused2) {
            }
        }
    }

    public OpenAPIService() {
        this.mStorage = null;
        this.unableShareWebView = true;
        this._shareTo = "";
        this._autoBack = false;
        this.tokenShareZalo = "";
        this.isRegister = false;
        this.shareVia = ShareVia.AppThenWeb;
        this.shareMessageChatOnly = false;
        this.mStorage = ZaloSDK.Instance.getOauthStorage();
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

    @Deprecated
    public static OpenAPIService getInstance() {
        if (Instance == null) {
            Instance = new OpenAPIService();
        }
        return Instance;
    }

    private Intent getShareIntentZalo(Context context, FeedData feedData, String str, boolean z10) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.setComponent(new ComponentName(Constant.ZALO_PACKAGE_NAME, "com.zing.zalo.ui.TempShareViaActivity"));
        intent.putExtra("android.intent.extra.SUBJECT", feedData.getMsg());
        intent.putExtra("android.intent.extra.TEXT", feedData.getLink());
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.tokenShareZalo = valueOf;
        intent.putExtra("token", valueOf);
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("feed")) {
                intent.putExtra(ZALO_PARAM_POST_FEED, true);
            } else if (str.equals("message") && this.shareMessageChatOnly) {
                intent.putExtra("hidePostFeed", true);
            }
        }
        if (z10) {
            intent.putExtra("autoBack2S", true);
        }
        intent.putExtra(ZALO_PARAM_BACK_TO_SOURCE, true);
        return intent;
    }

    private void loginThenShare(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, String str, boolean z10) {
        doShare(context, feedData, zaloPluginCallback, str, z10);
    }

    /* access modifiers changed from: private */
    public void loginZalo(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, String str, boolean z10) {
        this.mFeedOb = feedData;
        this.mCallback = new WeakReference<>(zaloPluginCallback);
        this.mWeakContext = new WeakReference<>(context);
        context.startActivity(newShareFeedLoginIntent(context, str, z10));
    }

    private Intent newIntent(Context context) {
        return new Intent(context, OpenAPIActivity.class);
    }

    private Intent newShareFeedLoginIntent(Context context, String str, boolean z10) {
        Intent newIntent = newIntent(context);
        newIntent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        newIntent.putExtra("login_from_share_feed", true);
        newIntent.putExtra("share_to", str);
        newIntent.putExtra("autoBack", z10);
        return newIntent;
    }

    private void registerBroadCast(Context context) {
        ZaloPluginCallback zaloPluginCallback;
        if (!Utilities.isZaloSupportCallBack(context)) {
            WeakReference<ZaloPluginCallback> weakReference = this.mCallbackZaloClient;
            if (weakReference != null && (zaloPluginCallback = weakReference.get()) != null) {
                zaloPluginCallback.onResult(true, 0, (String) null, (String) null);
            }
        } else if (!this.isRegister) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.zing.zalo.shareFeedResultInfo");
            AnonymousClass3 r22 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    boolean z10;
                    try {
                        JSONObject jSONObject = new JSONObject(intent.getExtras().getString(DbParams.KEY_CHANNEL_RESULT));
                        if (jSONObject.has("token") && jSONObject.getString("token").equals(OpenAPIService.this.tokenShareZalo)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", OpenAPIService.this._shareTo);
                            hashMap.put(ImagesContract.URL, OpenAPIService.this.mFeedOb.getLink());
                            hashMap.put("message", OpenAPIService.this.mFeedOb.getMsg());
                            hashMap.put("appName", OpenAPIService.this.mFeedOb.getAppName());
                            hashMap.put("sent", String.valueOf(jSONObject.getInt("send_action")));
                            int i10 = jSONObject.getInt("error_code");
                            hashMap.put("error_code", String.valueOf(i10));
                            Utils.addEventZingAnalytics(EventType.SHARE, (Map<String, String>) hashMap);
                            OpenAPIService.this.unRegisterReceiver(context);
                            if (OpenAPIService.this.mCallbackZaloClient != null) {
                                ZaloPluginCallback zaloPluginCallback = (ZaloPluginCallback) OpenAPIService.this.mCallbackZaloClient.get();
                                if (i10 == 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (zaloPluginCallback != null) {
                                    zaloPluginCallback.onResult(z10, jSONObject.getInt("error_code"), (String) null, (String) null);
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            };
            this.feedCallbackReceiver = r22;
            if (Build.VERSION.SDK_INT >= 33) {
                Intent unused = context.registerReceiver(r22, intentFilter, 4);
            } else {
                context.registerReceiver(r22, intentFilter);
            }
            this.isRegister = true;
        }
    }

    private void shareWebView(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, String str, boolean z10) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("msg=");
            stringBuffer.append(URLEncoder.encode(feedData.getMsg(), "UTF-8"));
            stringBuffer.append("&");
            stringBuffer.append("link=");
            stringBuffer.append(URLEncoder.encode(feedData.getLink(), "UTF-8"));
            stringBuffer.append("&");
            stringBuffer.append("app_name=");
            stringBuffer.append(URLEncoder.encode(feedData.getAppName(), "UTF-8"));
            stringBuffer.append("&");
            stringBuffer.append("app_id=");
            stringBuffer.append(String.valueOf(ZaloSDK.Instance.getAppID()));
            stringBuffer.append("&");
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("share_to=");
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            stringBuffer.append("app_version=");
            stringBuffer.append(str2);
            stringBuffer.append("&");
            stringBuffer.append("sdk_version=");
            stringBuffer.append(String.valueOf(ZaloSDK.Instance.getVersion()));
            stringBuffer.append("&");
            stringBuffer.append("device_id=");
            stringBuffer.append(ZaloSDK.Instance.getDeviceId());
            stringBuffer.append("&");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("link_title=");
            stringBuffer2.append(URLEncoder.encode(feedData.getLinkTitle(), "UTF-8"));
            stringBuffer2.append("&");
            stringBuffer2.append("link_desc=");
            stringBuffer2.append(URLEncoder.encode(feedData.getLinkDesc(), "UTF-8"));
            stringBuffer2.append("&");
            stringBuffer2.append("link_source=");
            stringBuffer2.append(URLEncoder.encode(feedData.getLinkSource(), "UTF-8"));
            stringBuffer2.append("&");
            if (feedData.getLinkThumb() != null) {
                for (String encode : feedData.getLinkThumb()) {
                    stringBuffer2.append("link_thumb=");
                    stringBuffer2.append(URLEncoder.encode(encode, "UTF-8"));
                    stringBuffer2.append("&");
                }
            }
            if (feedData.getParams() != null) {
                for (Map.Entry next : feedData.getParams().entrySet()) {
                    stringBuffer.append(((String) next.getKey()) + "=");
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(WebDialog.EXTRA_QUERY, stringBuffer.toString());
            bundle.putString(WebDialog.EXTRA_REQUEST_BODY, stringBuffer2.toString());
            WebDialog build = new WebDialog.FeedDialogBuilder(context, bundle).build();
            final WebDialog webDialog = build;
            final Context context2 = context;
            final FeedData feedData2 = feedData;
            final ZaloPluginCallback zaloPluginCallback2 = zaloPluginCallback;
            final String str3 = str;
            final boolean z11 = z10;
            build.setFeedCallBackListener(new ZaloPluginCallback() {
                public void onResult(boolean z10, int i10, String str, String str2) {
                    webDialog.dismiss();
                    if (i10 == -10) {
                        boolean unused = OpenAPIService.this.unableShareWebView = true;
                        OpenAPIService.this.doShare(context2, feedData2, zaloPluginCallback2, str3, z11);
                    } else if (i10 == -1) {
                        OpenAPIService.this.loginZalo(context2, feedData2, zaloPluginCallback2, str3, z11);
                    } else {
                        boolean unused2 = OpenAPIService.this.unableShareWebView = false;
                        ZaloPluginCallback zaloPluginCallback = zaloPluginCallback2;
                        if (zaloPluginCallback != null) {
                            zaloPluginCallback.onResult(z10, i10, str, str2);
                        }
                    }
                }
            });
            build.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void shareZalo(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            showOptionShare(context, feedData, zaloPluginCallback, z10);
            return;
        }
        Intent shareIntentZalo = getShareIntentZalo(context, feedData, str, z10);
        if (shareIntentZalo.resolveActivityInfo(context.getPackageManager(), 0) != null) {
            registerBroadCast(context);
            this.mCallbackZaloClient = new WeakReference<>(zaloPluginCallback);
            context.startActivity(shareIntentZalo);
            return;
        }
        Utilities.invokeMarketApp(context, Constant.ZALO_PACKAGE_NAME);
    }

    private void showOptionShare(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, boolean z10) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Chọn");
        final Context context2 = context;
        final FeedData feedData2 = feedData;
        final ZaloPluginCallback zaloPluginCallback2 = zaloPluginCallback;
        final boolean z11 = z10;
        builder.setItems(new CharSequence[]{"Gửi tin nhắn Zalo", "Đăng lên Zalo"}, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (i10 == 0) {
                    OpenAPIService.this.doShare(context2, feedData2, zaloPluginCallback2, "message", z11);
                } else {
                    OpenAPIService.this.doShare(context2, feedData2, zaloPluginCallback2, "feed", z11);
                }
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public void unRegisterReceiver(Context context) {
        BroadcastReceiver broadcastReceiver = this.feedCallbackReceiver;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.isRegister = false;
        }
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

    /* access modifiers changed from: protected */
    public void doShare(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, String str, boolean z10) {
        this.mFeedOb = feedData;
        this._shareTo = str;
        this._autoBack = z10;
        if (this.unableShareWebView) {
            shareZalo(context, feedData, zaloPluginCallback, str, z10);
        } else if (this.shareVia != ShareVia.AppThenWeb) {
            shareWebView(context, feedData, zaloPluginCallback, str, z10);
        } else if (Utilities.isZaloInstalled(context)) {
            shareZalo(context, feedData, zaloPluginCallback, str, z10);
        } else {
            shareWebView(context, feedData, zaloPluginCallback, str, z10);
        }
    }

    public void getAccessTokenByOAuthCode(Context context, String str, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "oauthCode must be set.");
        validateField(str2, "codeVerifier must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, AUTH_MOBILE_ACCESS_TOKEN_PATH_V4));
        httpClientRequest.addParams(Constant.PARAM_OAUTH_CODE, str);
        httpClientRequest.addParams(Constant.PARAM_APP_ID, ZaloSDK.Instance.getAppID() + "");
        httpClientRequest.addParams("grant_type", ZaloSDK.Instance.getGrantType(true));
        httpClientRequest.addParams("code_verifier", str2);
        new GetTokenTask(context, new WeakReference(zaloOpenAPICallback)).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getAccessTokenByRefreshToken(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "refresh_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, AUTH_MOBILE_ACCESS_TOKEN_PATH_V4));
        httpClientRequest.addParams("refresh_token", str);
        httpClientRequest.addParams(Constant.PARAM_APP_ID, ZaloSDK.Instance.getAppID() + "");
        httpClientRequest.addParams("grant_type", ZaloSDK.Instance.getGrantType(false));
        new GetTokenTask(context, new WeakReference(zaloOpenAPICallback)).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getFriendListInvitable(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_INVITABLE_FRIENDS_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addParams("offset", i10 + "");
        httpClientRequest.addParams("limit", i11 + "");
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_INVITABLE_FRIEND).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getFriendListUsedApp(Context context, String str, int i10, int i11, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_FRIENDS_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addParams("offset", i10 + "");
        httpClientRequest.addParams("limit", i11 + "");
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_FRIEND).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void getProfile(Context context, String str, ZaloOpenAPICallback zaloOpenAPICallback, String[] strArr) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.GET, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_V2_ME_PATH));
        httpClientRequest.addParams("fields", buildFieldsParam(strArr));
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.GET_PROFILE).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public ShareVia getShareZaloUsing() {
        return this.shareVia;
    }

    public void inviteFriendUseApp(Context context, String str, String[] strArr, String str2, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_APP_REQUESTS_PATH));
        httpClientRequest.addParams("to", buildFieldsParam(strArr));
        httpClientRequest.addParams("message", str2);
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.SEND_APP_REQUEST).execute(new HttpClientRequest[]{httpClientRequest});
    }

    public void postToWall(Context context, String str, String str2, String str3, ZaloOpenAPICallback zaloOpenAPICallback) {
        validateField(str, "access_token must be set.");
        HttpClientRequest httpClientRequest = new HttpClientRequest(HttpClientRequest.Type.POST, ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_GRAPH, GRAPH_ME_FEED_PATH));
        httpClientRequest.addParams("link", str2);
        httpClientRequest.addParams("message", str3);
        httpClientRequest.addHeader("access_token", str);
        new RequestAPITask(context, zaloOpenAPICallback, EventType.POST_FEED).execute(new HttpClientRequest[]{httpClientRequest});
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

    public void setShareZaloChatOnly(boolean z10) {
        this.shareMessageChatOnly = z10;
    }

    public void setShareZaloUsing(ShareVia shareVia2) {
        this.shareVia = shareVia2;
    }

    public void share(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback) {
        loginThenShare(context, feedData, zaloPluginCallback, (String) null, false);
    }

    public void shareFeed(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback) {
        loginThenShare(context, feedData, zaloPluginCallback, "feed", false);
    }

    public void shareMessage(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback) {
        loginThenShare(context, feedData, zaloPluginCallback, "message", false);
    }

    public void share(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, boolean z10) {
        loginThenShare(context, feedData, zaloPluginCallback, (String) null, z10);
    }

    public void shareFeed(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, boolean z10) {
        loginThenShare(context, feedData, zaloPluginCallback, "feed", z10);
    }

    public void shareMessage(Context context, FeedData feedData, ZaloPluginCallback zaloPluginCallback, boolean z10) {
        loginThenShare(context, feedData, zaloPluginCallback, "message", z10);
    }
}
