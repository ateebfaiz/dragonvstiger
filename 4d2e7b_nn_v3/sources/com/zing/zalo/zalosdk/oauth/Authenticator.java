package com.zing.zalo.zalosdk.oauth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.content.ContextCompat;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.ZTaskExecutor;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.core.type.EventType;
import com.zing.zalo.zalosdk.core.type.FromSourceType;
import com.zing.zalo.zalosdk.core.type.PlatformType;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;
import com.zing.zalo.zalosdk.payment.direct.Utils;
import com.zing.zalo.zalosdk.service.client.ZaloService;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Authenticator {
    static boolean isGetZaloOAuth;
    /* access modifiers changed from: private */
    public JSONObject appExtInfo;
    /* access modifiers changed from: private */
    public boolean bIsZaloLoginSuccessful = false;
    private boolean bIsZaloOutOfDate = false;
    private String codeChallenge;
    private boolean isIgnoredBrowserResult = false;
    private OAuthCompleteListener listener;
    private OAuthCompleteListener loginFormListener;
    protected Context mContext;
    private LocalizedString mLocalizedString;
    private final OauthStorage mStorage;
    public String nameActivtyCheckAuthen = "";
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Constant.AUTHORIZATION_LOGIN_SUCCESSFUL_ACTION.equals(intent.getAction())) {
                boolean unused = Authenticator.this.bIsZaloLoginSuccessful = intent.getBooleanExtra(Constant.EXTRA_AUTHORIZATION_LOGIN_SUCCESSFUL, false);
            }
        }
    };
    private String state;
    private boolean useWeakReferenceCallback = true;
    private WeakReference<OAuthCompleteListener> wListener;
    private WeakReference<OAuthCompleteListener> wLoginFormListener;
    private boolean zaloPluginLogin = false;

    /* renamed from: com.zing.zalo.zalosdk.oauth.Authenticator$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$zing$zalo$zalosdk$oauth$LoginVia;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.zing.zalo.zalosdk.oauth.LoginVia[] r0 = com.zing.zalo.zalosdk.oauth.LoginVia.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zing$zalo$zalosdk$oauth$LoginVia = r0
                com.zing.zalo.zalosdk.oauth.LoginVia r1 = com.zing.zalo.zalosdk.oauth.LoginVia.APP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zing$zalo$zalosdk$oauth$LoginVia     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zing.zalo.zalosdk.oauth.LoginVia r1 = com.zing.zalo.zalosdk.oauth.LoginVia.WEB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zing$zalo$zalosdk$oauth$LoginVia     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zing.zalo.zalosdk.oauth.LoginVia r1 = com.zing.zalo.zalosdk.oauth.LoginVia.APP_OR_WEB     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.Authenticator.AnonymousClass4.<clinit>():void");
        }
    }

    private class ValidateGuestSessionTask extends AuthenExtTask {
        private final String AUTH_VALIDATE_GUEST_SESSION_PATH = "/v4/mobile/validate_guest_session";
        private String authorization_code;
        private ValidateCallback callback;

        protected ValidateGuestSessionTask(Context context, String str, ValidateCallback validateCallback) {
            super(context, Authenticator.this.appExtInfo, (EventType) null);
            this.authorization_code = str;
            this.callback = validateCallback;
            if (validateCallback == null) {
                throw new IllegalArgumentException("callback can't be null");
            }
        }

        /* access modifiers changed from: protected */
        public void customizeEventLog(Map<String, String> map) {
        }

        /* access modifiers changed from: protected */
        public void customizeParam(HttpClientRequest httpClientRequest) {
            String str = this.authorization_code;
            if (str == null) {
                str = "";
            }
            httpClientRequest.addParams("authorization_code", str);
        }

        /* access modifiers changed from: protected */
        public String requestUrl() {
            return ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, "/v4/mobile/validate_guest_session");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
            OauthResponse oauthResponse = new OauthResponse();
            oauthResponse.setOauthCode(this.authorization_code);
            try {
                int i10 = jSONObject.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                if (i10 == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    oauthResponse.setuId(jSONObject2.optLong("userId"));
                    oauthResponse.setZcert(jSONObject2.optInt("zcert"));
                    this.callback.onValidateComplete(true, 0, oauthResponse);
                    return;
                }
                this.callback.onValidateComplete(false, i10, oauthResponse);
            } catch (Exception unused) {
                this.callback.onValidateComplete(false, ZaloOAuthResultCode.ERR_UNKNOWN_ERROR, oauthResponse);
            }
        }
    }

    private class ValidateRefreshTokenTask extends AuthenExtTask {
        private final String AUTH_VALIDATE_REFRESHTOKEN_PATH = "/v4/mobile/validate_refresh_token";
        private ValidateCallback callback;
        private String refreshToken;

        protected ValidateRefreshTokenTask(Context context, String str, ValidateCallback validateCallback) {
            super(context, Authenticator.this.appExtInfo, (EventType) null);
            this.refreshToken = str;
            this.callback = validateCallback;
            if (validateCallback == null) {
                throw new IllegalArgumentException("callback can't be null");
            }
        }

        /* access modifiers changed from: protected */
        public void customizeEventLog(Map<String, String> map) {
        }

        /* access modifiers changed from: protected */
        public void customizeParam(HttpClientRequest httpClientRequest) {
            httpClientRequest.addParams("refresh_token", this.refreshToken);
        }

        /* access modifiers changed from: protected */
        public String requestUrl() {
            return ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, "/v4/mobile/validate_refresh_token");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
            OauthResponse oauthResponse = new OauthResponse();
            oauthResponse.setRefreshToken(this.refreshToken);
            try {
                int i10 = jSONObject.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                if (i10 == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    oauthResponse.setuId(jSONObject2.optLong("userId"));
                    oauthResponse.setExpireTime(jSONObject2.optLong("expires_in"));
                    int optInt = jSONObject2.optInt("zcert");
                    jSONObject2.optInt("zprotect");
                    oauthResponse.setZcert(optInt);
                    this.callback.onValidateComplete(true, 0, oauthResponse);
                    return;
                }
                this.callback.onValidateComplete(false, i10, oauthResponse);
            } catch (Exception unused) {
                this.callback.onValidateComplete(false, ZaloOAuthResultCode.ERR_UNKNOWN_ERROR, oauthResponse);
            }
        }
    }

    Authenticator(Context context, OauthStorage oauthStorage, LocalizedString localizedString) {
        this.mContext = context;
        this.mStorage = oauthStorage;
        this.mLocalizedString = localizedString;
        this.state = String.valueOf(System.currentTimeMillis());
    }

    private boolean checkCookieManagerSupport() {
        try {
            CookieManager.getInstance();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void loginViaApp(Activity activity) {
        try {
            activity.unregisterReceiver(this.receiver);
        } catch (Exception e10) {
            try {
                Log.v(e10.toString());
            } catch (ActivityNotFoundException e11) {
                e11.printStackTrace();
                this.bIsZaloOutOfDate = true;
                getOAuthCompleteListener().onZaloOutOfDate(activity);
                return;
            } catch (SecurityException e12) {
                e12.printStackTrace();
                this.bIsZaloOutOfDate = true;
                getOAuthCompleteListener().onZaloOutOfDate(activity);
                return;
            }
        }
        ContextCompat.registerReceiver(activity, this.receiver, new IntentFilter(Constant.AUTHORIZATION_LOGIN_SUCCESSFUL_ACTION), 2);
        this.state = String.valueOf(System.currentTimeMillis());
        Intent intent = new Intent("com.zing.zalo.intent.action.THIRD_PARTY_APP_AUTHORIZATION");
        intent.putExtra("android.intent.extra.UID", AppInfo.getAppIdLong(this.mContext));
        intent.putExtra(Constant.PARAM_APP_ID, AppInfo.getAppIdLong(this.mContext));
        intent.putExtra("code_challenge", this.codeChallenge);
        intent.putExtra("state", this.state);
        intent.putExtra("ext_info", ZaloSDK.Instance.getBaseAppInfo().prepareExtraInfo(FromSourceType.ZALO_APP.getCode()).toString());
        activity.startActivityForResult(intent, Constant.ZALO_AUTHENTICATE_REQUEST_CODE);
    }

    private void loginViaAppOrWebIfNotLogin(final Activity activity) {
        getZaloLoginStatus(new GetZaloLoginStatus() {
            public void onGetZaloLoginStatusCompleted(int i10) {
                if (i10 == 1) {
                    Authenticator.this.loginViaApp(activity);
                } else {
                    Authenticator.this.loginViaWeb(activity);
                }
            }
        });
    }

    private void loginViaBrowser(Activity activity) throws JSONException, UnsupportedEncodingException {
        this.state = System.currentTimeMillis() + "";
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, "/v4/permission?app_id=") + ZaloSDK.Instance.getAppID() + "&sign_key=" + URLEncoder.encode(AppInfo.getApplicationHashKey(activity), "UTF-8") + "&pkg_name=" + URLEncoder.encode(AppInfo.getPackageName(activity), "UTF-8") + "&os=" + PlatformType.ANDROID.getCode() + "&state=" + this.state + "&lang=" + Utils.getLanguage(activity) + "&ref=zsdk" + "&ext_info=" + Utils.getExtInfo(this.appExtInfo) + "&code_challenge=" + this.codeChallenge));
        activity.startActivityForResult(intent, Constant.BROWSER_AUTHENTICATE_REQUEST_CODE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loginViaWeb(android.app.Activity r10) {
        /*
            r9 = this;
            boolean r0 = com.zing.zalo.zalosdk.oauth.Utilities.canUseBrowserLogin(r10)
            boolean r1 = com.zing.zalo.zalosdk.oauth.Utilities.isOnline(r10)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0010
            r1 = -8001(0xffffffffffffe0bf, float:NaN)
        L_0x000e:
            r4 = r1
            goto L_0x0026
        L_0x0010:
            if (r0 == 0) goto L_0x001a
            r9.loginViaBrowser(r10)     // Catch:{ UnsupportedEncodingException -> 0x0018, JSONException -> 0x0016 }
            goto L_0x001d
        L_0x0016:
            r1 = move-exception
            goto L_0x001f
        L_0x0018:
            r1 = move-exception
            goto L_0x001f
        L_0x001a:
            r9.loginViaWebView(r10)     // Catch:{ UnsupportedEncodingException -> 0x0018, JSONException -> 0x0016 }
        L_0x001d:
            r1 = 0
            goto L_0x000e
        L_0x001f:
            java.lang.String r2 = r1.getMessage()
            r1 = -7010(0xffffffffffffe49e, float:NaN)
            goto L_0x000e
        L_0x0026:
            if (r4 == 0) goto L_0x004f
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0034
            java.lang.String r10 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findErrorMessageByID(r10, r4)
            r5 = r10
            goto L_0x0035
        L_0x0034:
            r5 = r2
        L_0x0035:
            if (r0 == 0) goto L_0x003b
            java.lang.String r10 = "browser"
        L_0x0039:
            r8 = r10
            goto L_0x003e
        L_0x003b:
            java.lang.String r10 = "web_view"
            goto L_0x0039
        L_0x003e:
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r10 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r9.getOAuthCompleteListener()
            r0.onAuthenError(r10)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.Authenticator.loginViaWeb(android.app.Activity):void");
    }

    private void loginViaWebView(Activity activity) throws UnsupportedEncodingException, JSONException {
        if (!checkCookieManagerSupport()) {
            getOAuthCompleteListener().onAuthenError(new ErrorResponse(ZaloOAuthResultCode.ERR_ZALO_WEBVIEW_COOKIE_ERROR, "Webview does not support login!"));
            return;
        }
        this.state = System.currentTimeMillis() + "";
        activity.startActivityForResult(WebLoginActivity.newIntent(activity, false, this.codeChallenge, Utils.getExtInfo(this.appExtInfo), this.state), Constant.ZALO_AUTHENTICATE_REQUEST_CODE);
    }

    private void sendOAuthRequest(Activity activity, LoginVia loginVia) {
        boolean isPackageExists = AppInfo.isPackageExists(activity, Constant.ZALO_PACKAGE_NAME);
        int i10 = AnonymousClass4.$SwitchMap$com$zing$zalo$zalosdk$oauth$LoginVia[loginVia.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                loginViaWeb(activity);
            } else if (i10 == 3) {
                if (!isPackageExists) {
                    loginViaWeb(activity);
                } else if (SettingsManager.getInstance().isUseWebViewUnLoginZalo(this.mContext)) {
                    loginViaAppOrWebIfNotLogin(activity);
                } else {
                    loginViaApp(activity);
                }
            }
        } else if (isPackageExists) {
            loginViaApp(activity);
        } else {
            getOAuthCompleteListener().onZaloNotInstalled(activity);
        }
    }

    private void submitEventLoginFail(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DbParams.KEY_CHANNEL_RESULT, "0");
        hashMap.put("type", str);
        com.zing.zalo.zalosdk.core.helper.Utils.addEventZingAnalytics(EventType.AUTHEN, (Map<String, String>) hashMap);
    }

    private void submitEventLoginSuccess(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DbParams.KEY_CHANNEL_RESULT, "1");
        hashMap.put("type", str);
        com.zing.zalo.zalosdk.core.helper.Utils.addEventZingAnalytics(EventType.AUTHEN, (Map<String, String>) hashMap);
    }

    private boolean validateOauthCode(String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean validateState(boolean z10, String str) {
        if (!z10) {
            return "".equals(str);
        }
        String str2 = this.state;
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void authenticate(Activity activity, LoginVia loginVia, String str, boolean z10, JSONObject jSONObject, OAuthCompleteListener oAuthCompleteListener) {
        if (oAuthCompleteListener != null) {
            this.nameActivtyCheckAuthen = activity.getClass().getSimpleName();
            setOAuthCompleteListener(oAuthCompleteListener);
            this.zaloPluginLogin = z10;
            this.codeChallenge = str;
            this.appExtInfo = jSONObject;
            sendOAuthRequest(activity, loginVia);
            return;
        }
        throw new IllegalArgumentException("OAuthCompleteListener must be set.");
    }

    /* access modifiers changed from: protected */
    public OAuthCompleteListener getLoginFormOAuthCompleteListener() {
        if (this.useWeakReferenceCallback) {
            WeakReference<OAuthCompleteListener> weakReference = this.wLoginFormListener;
            if (!(weakReference == null || weakReference.get() == null)) {
                return this.wLoginFormListener.get();
            }
        } else {
            OAuthCompleteListener oAuthCompleteListener = this.loginFormListener;
            if (oAuthCompleteListener != null) {
                return oAuthCompleteListener;
            }
        }
        return new OAuthCompleteListener();
    }

    public OAuthCompleteListener getOAuthCompleteListener() {
        if (this.useWeakReferenceCallback) {
            WeakReference<OAuthCompleteListener> weakReference = this.wListener;
            if (!(weakReference == null || weakReference.get() == null)) {
                return this.wListener.get();
            }
        } else {
            OAuthCompleteListener oAuthCompleteListener = this.listener;
            if (oAuthCompleteListener != null) {
                return oAuthCompleteListener;
            }
        }
        return new OAuthCompleteListener();
    }

    public OauthStorage getStorage() {
        return this.mStorage;
    }

    /* access modifiers changed from: package-private */
    public void getZaloLoginStatus(final GetZaloLoginStatus getZaloLoginStatus) {
        if (getZaloLoginStatus != null) {
            ZTaskExecutor.queueRunnable(new Runnable() {
                public void run() {
                    ZaloService zaloService = new ZaloService();
                    Handler handler = new Handler(Looper.getMainLooper());
                    try {
                        final int userLoggedStatus = zaloService.getUserLoggedStatus(Authenticator.this.mContext);
                        handler.post(new Runnable() {
                            public void run() {
                                getZaloLoginStatus.onGetZaloLoginStatusCompleted(userLoggedStatus);
                            }
                        });
                    } catch (Exception e10) {
                        Log.e(e10);
                        handler.post(new Runnable() {
                            public void run() {
                                getZaloLoginStatus.onGetZaloLoginStatusCompleted(-1);
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAuthenticate(String str, ValidateCallback validateCallback) {
        if (str == null || str.length() == 0) {
            if (validateCallback != null) {
                validateCallback.onValidateComplete(false, ZaloOAuthResultCode.ERR_INVALID_REFRESH_TOKEN, new OauthResponse().setRefreshToken(str));
            }
            return false;
        } else if (validateCallback == null) {
            return true;
        } else {
            new ValidateRefreshTokenTask(this.mContext, str, validateCallback).execute(new Void[0]);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isGuestSessionValid(String str, ValidateCallback validateCallback) {
        if (TextUtils.isEmpty(str)) {
            if (validateCallback != null) {
                validateCallback.onValidateComplete(false, ZaloOAuthResultCode.ERR_INVALID_OAUTHORIZED_CODE, new OauthResponse().setOauthCode(str));
            }
            return false;
        } else if (validateCallback == null) {
            return true;
        } else {
            new ValidateGuestSessionTask(this.mContext, str, validateCallback).execute(new Void[0]);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(Activity activity, int i10, int i11, Intent intent) {
        if (i10 == 64725) {
            receiveOAuthDataV4(activity, intent);
            return true;
        } else if (i10 != 64728) {
            return false;
        } else {
            if (intent != null) {
                this.isIgnoredBrowserResult = true;
                receiveOAuthDataV4(activity, intent);
            } else if (this.isIgnoredBrowserResult) {
                this.isIgnoredBrowserResult = false;
                return true;
            } else {
                receiveOAuthDataV4(activity, (Intent) null);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveOAuthDataV4(android.app.Activity r24, android.content.Intent r25) {
        /*
            r23 = this;
            r7 = r23
            r1 = r25
            java.lang.String r2 = " "
            r3 = 0
            isGetZaloOAuth = r3
            android.content.BroadcastReceiver r0 = r7.receiver     // Catch:{ Exception -> 0x0011 }
            r4 = r24
            r4.unregisterReceiver(r0)     // Catch:{ Exception -> 0x0013 }
            goto L_0x0013
        L_0x0011:
            r4 = r24
        L_0x0013:
            boolean r0 = r7.bIsZaloOutOfDate
            java.lang.String r5 = "1"
            if (r0 == 0) goto L_0x001d
            r7.submitEventLoginFail(r5)
            return
        L_0x001d:
            if (r1 != 0) goto L_0x003e
            android.content.Context r0 = r7.mContext
            r9 = -7008(0xffffffffffffe4a0, float:NaN)
            java.lang.String r10 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findErrorMessageByID(r0, r9)
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r0 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            java.lang.String r12 = ""
            java.lang.String r13 = "web_login"
            java.lang.String r11 = ""
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r1 = r23.getOAuthCompleteListener()
            r1.onAuthenError(r0)
            r7.submitEventLoginFail(r5)
            return
        L_0x003e:
            java.lang.String r0 = "error"
            int r0 = r1.getIntExtra(r0, r3)
            r6 = 203(0xcb, float:2.84E-43)
            java.lang.String r8 = "Không thể đăng nhập Zalo."
            java.lang.String r9 = "2"
            if (r0 != r6) goto L_0x005f
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r23.getOAuthCompleteListener()
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r1 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            r2 = -7007(0xffffffffffffe4a1, float:NaN)
            r1.<init>(r2, r8)
            r0.onAuthenError(r1)
            r7.submitEventLoginFail(r9)
            goto L_0x025a
        L_0x005f:
            java.lang.String r6 = "isWebview"
            java.lang.String r10 = ""
            java.lang.String r11 = "data"
            if (r0 != 0) goto L_0x0164
            java.lang.String r0 = "uid"
            r12 = 0
            long r12 = r1.getLongExtra(r0, r12)
            java.lang.String r0 = "code"
            java.lang.String r2 = r1.getStringExtra(r0)
            java.lang.String r0 = "isRegister"
            boolean r4 = r1.getBooleanExtra(r0, r3)
            java.lang.String r14 = r1.getStringExtra(r11)
            boolean r6 = r1.getBooleanExtra(r6, r3)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r0.<init>(r14)     // Catch:{ Exception -> 0x00b7 }
            org.json.JSONObject r0 = r0.getJSONObject(r11)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r15 = "ext_info"
            org.json.JSONObject r15 = r0.optJSONObject(r15)     // Catch:{ Exception -> 0x00b7 }
            if (r15 == 0) goto L_0x0095
            r3 = 1
        L_0x0095:
            r16 = r9
            java.lang.String r9 = "state"
            r17 = r5
            java.lang.String r5 = "viewer"
            if (r3 == 0) goto L_0x00ad
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x00aa }
            java.lang.String r0 = r0.optString(r9, r10)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00c1
        L_0x00a8:
            r0 = move-exception
            goto L_0x00bd
        L_0x00aa:
            r0 = move-exception
        L_0x00ab:
            r5 = r10
            goto L_0x00bd
        L_0x00ad:
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Exception -> 0x00aa }
            r15 = 0
            java.lang.String r0 = r0.optString(r9, r15)     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00c1
        L_0x00b7:
            r0 = move-exception
            r17 = r5
            r16 = r9
            goto L_0x00ab
        L_0x00bd:
            r0.printStackTrace()
            r0 = r10
        L_0x00c1:
            boolean r0 = r7.validateState(r3, r0)
            if (r0 != 0) goto L_0x00e5
            java.lang.String r0 = "State invalid"
            com.zing.zalo.zalosdk.core.log.Log.e((java.lang.String) r0)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r23.getOAuthCompleteListener()
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r1 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            r2 = -5018(0xffffffffffffec66, float:NaN)
            r1.<init>(r2, r8)
            r0.onAuthenError(r1)
            if (r6 == 0) goto L_0x00df
            r5 = r16
            goto L_0x00e1
        L_0x00df:
            r5 = r17
        L_0x00e1:
            r7.submitEventLoginFail(r5)
            return
        L_0x00e5:
            boolean r0 = r7.validateOauthCode(r2)
            if (r0 != 0) goto L_0x0109
            java.lang.String r0 = "Oauth code invalid"
            com.zing.zalo.zalosdk.core.log.Log.e((java.lang.String) r0)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r23.getOAuthCompleteListener()
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r1 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            r2 = -5020(0xffffffffffffec64, float:NaN)
            r1.<init>(r2, r8)
            r0.onAuthenError(r1)
            if (r6 == 0) goto L_0x0103
            r5 = r16
            goto L_0x0105
        L_0x0103:
            r5 = r17
        L_0x0105:
            r7.submitEventLoginFail(r5)
            return
        L_0x0109:
            boolean r0 = r7.zaloPluginLogin
            if (r0 != 0) goto L_0x0145
            com.zing.zalo.zalosdk.oauth.OauthStorage r0 = r7.mStorage
            r0.setViewer(r5)
            com.zing.zalo.zalosdk.oauth.OauthStorage r0 = r7.mStorage
            com.zing.zalo.zalosdk.oauth.LoginChannel r3 = com.zing.zalo.zalosdk.oauth.LoginChannel.ZALO
            java.lang.String r3 = r3.toString()
            r0.setLoginChannel(r3)
            java.lang.String r0 = r1.getStringExtra(r11)     // Catch:{ Exception -> 0x0141 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0141 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0141 }
            org.json.JSONObject r0 = r1.getJSONObject(r11)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r1 = "display_name"
            java.lang.String r1 = r0.optString(r1, r10)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r3 = "zprotect"
            int r0 = r0.optInt(r3)     // Catch:{ Exception -> 0x0141 }
            com.zing.zalo.zalosdk.oauth.OauthStorage r3 = r7.mStorage     // Catch:{ Exception -> 0x0141 }
            r3.setIsProtected(r0)     // Catch:{ Exception -> 0x0141 }
            com.zing.zalo.zalosdk.oauth.OauthStorage r0 = r7.mStorage     // Catch:{ Exception -> 0x0141 }
            r0.setZaloDisplayName(r1)     // Catch:{ Exception -> 0x0141 }
            goto L_0x0145
        L_0x0141:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0145:
            com.zing.zalo.zalosdk.oauth.OauthResponse r0 = new com.zing.zalo.zalosdk.oauth.OauthResponse
            com.zing.zalo.zalosdk.oauth.LoginChannel r1 = com.zing.zalo.zalosdk.oauth.LoginChannel.ZALO
            r0.<init>(r12, r2, r1)
            r0.raw = r14
            r0.setRegister(r4)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r1 = r23.getOAuthCompleteListener()
            r1.onGetOAuthComplete(r0)
            if (r6 == 0) goto L_0x015d
            r5 = r16
            goto L_0x015f
        L_0x015d:
            r5 = r17
        L_0x015f:
            r7.submitEventLoginSuccess(r5)
            goto L_0x025a
        L_0x0164:
            r17 = r5
            r16 = r9
            r5 = 4
            if (r0 != r5) goto L_0x0198
            boolean r0 = r7.bIsZaloLoginSuccessful
            if (r0 == 0) goto L_0x0183
            com.zing.zalo.zalosdk.oauth.LoginVia r3 = com.zing.zalo.zalosdk.oauth.LoginVia.APP
            java.lang.String r0 = r7.codeChallenge
            boolean r5 = r7.zaloPluginLogin
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r6 = r23.getOAuthCompleteListener()
            r1 = r23
            r2 = r24
            r4 = r0
            r1.authenticate(r2, r3, r4, r5, r6)
            goto L_0x025a
        L_0x0183:
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r23.getOAuthCompleteListener()
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r1 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            r2 = -7008(0xffffffffffffe4a0, float:NaN)
            r1.<init>(r2, r10)
            r0.onAuthenError(r1)
            r4 = r17
            r7.submitEventLoginFail(r4)
            goto L_0x025a
        L_0x0198:
            r4 = r17
            r5 = 3
            if (r0 == r5) goto L_0x023d
            r5 = 2
            if (r0 != r5) goto L_0x01a2
            goto L_0x023d
        L_0x01a2:
            int r5 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findById(r0)
            android.content.Context r0 = r7.mContext
            java.lang.String r8 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findErrorMessageByID(r0, r5)
            java.lang.String r0 = r1.getStringExtra(r11)     // Catch:{ Exception -> 0x01e3 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01e3 }
            if (r9 != 0) goto L_0x0223
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x01e3 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x01e3 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r9 = r9.optString(r11)     // Catch:{ Exception -> 0x01e3 }
            r0.<init>(r9)     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r9 = "errorMsg"
            java.lang.String r9 = r0.optString(r9)     // Catch:{ Exception -> 0x01e3 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01e3 }
            if (r10 != 0) goto L_0x01e5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e3 }
            r10.<init>()     // Catch:{ Exception -> 0x01e3 }
            r10.append(r8)     // Catch:{ Exception -> 0x01e3 }
            r10.append(r2)     // Catch:{ Exception -> 0x01e3 }
            r10.append(r9)     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x01e3 }
            goto L_0x01e5
        L_0x01e3:
            r0 = move-exception
            goto L_0x020a
        L_0x01e5:
            java.lang.String r9 = "error_description"
            java.lang.String r21 = r0.optString(r9)     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r9 = "error_reason"
            java.lang.String r20 = r0.optString(r9)     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r9 = "from_source"
            java.lang.String r22 = r0.optString(r9)     // Catch:{ Exception -> 0x01e3 }
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r0 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse     // Catch:{ Exception -> 0x01e3 }
            r17 = r0
            r18 = r5
            r19 = r8
            r17.<init>(r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x01e3 }
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r9 = r23.getOAuthCompleteListener()     // Catch:{ Exception -> 0x01e3 }
            r9.onAuthenError(r0)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0223
        L_0x020a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r2)
            java.lang.String r0 = r0.toString()
            r9.append(r0)
            java.lang.String r8 = r9.toString()
            com.zing.zalo.zalosdk.core.log.Log.v(r8)
        L_0x0223:
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r0 = r23.getOAuthCompleteListener()
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r2 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            r2.<init>(r5, r8)
            r0.onAuthenError(r2)
            boolean r0 = r1.getBooleanExtra(r6, r3)
            if (r0 == 0) goto L_0x0238
            r5 = r16
            goto L_0x0239
        L_0x0238:
            r5 = r4
        L_0x0239:
            r7.submitEventLoginFail(r5)
            goto L_0x025a
        L_0x023d:
            int r9 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findById(r0)
            android.content.Context r1 = r7.mContext
            java.lang.String r10 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findErrorMessageByID(r1, r0)
            com.zing.zalo.zalosdk.oauth.model.ErrorResponse r0 = new com.zing.zalo.zalosdk.oauth.model.ErrorResponse
            java.lang.String r12 = ""
            java.lang.String r13 = "app"
            java.lang.String r11 = ""
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            com.zing.zalo.zalosdk.oauth.OAuthCompleteListener r1 = r23.getOAuthCompleteListener()
            r1.onAuthenError(r0)
        L_0x025a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.Authenticator.receiveOAuthDataV4(android.app.Activity, android.content.Intent):void");
    }

    /* access modifiers changed from: package-private */
    public void registerZalo(Activity activity, OAuthCompleteListener oAuthCompleteListener) {
        if (oAuthCompleteListener != null) {
            this.nameActivtyCheckAuthen = activity.getClass().getSimpleName();
            setOAuthCompleteListener(oAuthCompleteListener);
            try {
                this.state = System.currentTimeMillis() + "";
                activity.startActivityForResult(WebLoginActivity.newIntent(activity, true, this.codeChallenge, Utils.getExtInfo(this.appExtInfo), this.state), Constant.ZALO_AUTHENTICATE_REQUEST_CODE);
            } catch (Exception e10) {
                getOAuthCompleteListener().onAuthenError(new ErrorResponse(ZaloOAuthResultCode.ERR_UNKNOWN_ERROR, e10.getMessage(), "", "", ""));
            }
        } else {
            throw new IllegalArgumentException("OAuthCompleteListener must be set.");
        }
    }

    public void resetListener() {
        this.wListener = null;
    }

    /* access modifiers changed from: protected */
    public void setLoginFormOAuthCompleteListener(OAuthCompleteListener oAuthCompleteListener) {
        if (this.useWeakReferenceCallback) {
            this.wLoginFormListener = new WeakReference<>(oAuthCompleteListener);
        } else {
            this.loginFormListener = oAuthCompleteListener;
        }
    }

    public void setOAuthCompleteListener(OAuthCompleteListener oAuthCompleteListener) {
        if (this.useWeakReferenceCallback) {
            this.wListener = new WeakReference<>(oAuthCompleteListener);
        } else {
            this.listener = oAuthCompleteListener;
        }
    }

    public void setUseWeakReferenceCallback(boolean z10) {
        this.useWeakReferenceCallback = z10;
    }

    /* access modifiers changed from: protected */
    public void unauthenticate() {
        try {
            this.mStorage.setLoginChannel("");
            this.mStorage.setZaloDisplayName("");
            this.mStorage.setSocialId("");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void authenticate(Activity activity, LoginVia loginVia, String str, boolean z10, OAuthCompleteListener oAuthCompleteListener) {
        authenticate(activity, loginVia, str, z10, (JSONObject) null, oAuthCompleteListener);
    }
}
