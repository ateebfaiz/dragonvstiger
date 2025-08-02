package com.zing.zalo.zalosdk.oauth.register;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.alibaba.pdns.s.e.c;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.core.type.PlatformType;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;
import com.zing.zalo.zalosdk.oauth.model.LoginResponse;
import com.zing.zalo.zalosdk.payment.direct.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZaloWebLoginFragment extends ZaloWebLoginBaseFragment {
    public static final boolean USE_V3 = true;
    private static final String WEB_LOGIN_PATH = "/v4/permission?app_id=";
    private static final Pattern WZUIN = Pattern.compile("(wzuin=[\\d\\w]*)");
    String codeChallenge;
    CookieManager cookieManager;
    CookieSyncManager cookieSyncManager;
    String extInfo;
    ProgressBar progressBar;
    String state;
    WebView webView;

    private static class LoginEventDispacher extends WebViewClient {
        private String callbackUrl;
        private Context context;
        private WeakReference<ZaloWebLoginFragment> that;

        public LoginEventDispacher(Context context2, WeakReference<ZaloWebLoginFragment> weakReference, String str) {
            this.that = weakReference;
            this.callbackUrl = str;
            this.context = context2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x0091 A[Catch:{ Exception -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9 A[Catch:{ Exception -> 0x00b5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00b9  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean processCallbackUrl(java.lang.String r19) {
            /*
                r18 = this;
                r1 = r18
                r2 = 1
                java.lang.String r0 = "error"
                java.lang.String r3 = ""
                java.lang.String r4 = r1.callbackUrl
                r5 = r19
                int r4 = r5.indexOf(r4)
                r6 = 0
                if (r4 == 0) goto L_0x0013
                return r6
            L_0x0013:
                android.net.Uri r4 = android.net.Uri.parse(r19)
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                r7 = 0
                r9 = 0
                java.lang.String r10 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0052 }
                if (r10 == 0) goto L_0x0057
                java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0052 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0052 }
                java.lang.String r5 = "error_reason"
                java.lang.String r5 = r4.getQueryParameter(r5)     // Catch:{ Exception -> 0x0052 }
                java.lang.String r10 = "error_description"
                java.lang.String r4 = r4.getQueryParameter(r10)     // Catch:{ Exception -> 0x004e }
                android.content.Context r10 = r1.context     // Catch:{ Exception -> 0x0048 }
                java.lang.String r10 = com.zing.zalo.zalosdk.ZaloOAuthResultCode.findErrorMessageByID(r10, r0)     // Catch:{ Exception -> 0x0048 }
                java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0048 }
                r12 = r3
                r13 = r12
                r14 = r7
                r7 = r10
                r8 = r11
                r10 = r13
                r11 = r10
                r3 = r6
                goto L_0x00e0
            L_0x0048:
                r0 = move-exception
                r11 = r3
            L_0x004a:
                r12 = r11
                r13 = r12
                goto L_0x00c6
            L_0x004e:
                r0 = move-exception
                r4 = r3
                r11 = r4
                goto L_0x004a
            L_0x0052:
                r0 = move-exception
                r4 = r3
                r5 = r4
                r11 = r5
                goto L_0x004a
            L_0x0057:
                java.lang.String r0 = "code"
                java.lang.String r10 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0052 }
                java.lang.String r0 = "state"
                java.lang.String r11 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x00c0 }
                java.lang.String r0 = "ext_info"
                java.lang.String r9 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0081 }
                boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0081 }
                if (r0 != 0) goto L_0x0088
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x007c }
                r0.<init>(r9)     // Catch:{ Exception -> 0x007c }
                java.lang.String r12 = "viewer"
                java.lang.String r0 = r0.getString(r12)     // Catch:{ Exception -> 0x007c }
                r12 = r0
                goto L_0x0089
            L_0x007c:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ Exception -> 0x0081 }
                goto L_0x0088
            L_0x0081:
                r0 = move-exception
                r4 = r3
                r5 = r4
                r12 = r5
            L_0x0085:
                r13 = r12
            L_0x0086:
                r3 = r10
                goto L_0x00c6
            L_0x0088:
                r12 = r3
            L_0x0089:
                java.lang.String r0 = "uid"
                java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0096 }
                if (r0 == 0) goto L_0x009b
                long r7 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0096 }
                goto L_0x009b
            L_0x0096:
                r0 = move-exception
                r4 = r3
                r5 = r4
                r13 = r5
                goto L_0x0086
            L_0x009b:
                java.lang.String r0 = "display_name"
                java.lang.String r13 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0096 }
                java.lang.String r0 = "zprotect"
                java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x00b5 }
                if (r0 == 0) goto L_0x00b9
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00b5 }
                r4 = r3
                r14 = r7
                r3 = r0
                r7 = r4
                r8 = r5
                r0 = r6
            L_0x00b3:
                r5 = r7
                goto L_0x00e0
            L_0x00b5:
                r0 = move-exception
                r4 = r3
                r5 = r4
                goto L_0x0086
            L_0x00b9:
                r4 = r3
                r0 = r6
                r14 = r7
                r7 = r4
                r8 = r5
                r3 = r0
                goto L_0x00b3
            L_0x00c0:
                r0 = move-exception
                r4 = r3
                r5 = r4
                r11 = r5
                r12 = r11
                goto L_0x0085
            L_0x00c6:
                java.lang.String r10 = "processCallbackUrl"
                java.lang.Object[] r14 = new java.lang.Object[r2]
                r14[r6] = r0
                com.zing.zalo.zalosdk.core.log.Log.w((java.lang.String) r10, (java.lang.Object[]) r14)
                java.lang.String r0 = r0.toString()
                java.lang.Boolean r10 = java.lang.Boolean.TRUE
                r14 = -8000(0xffffffffffffe0c0, float:NaN)
                r16 = r7
                r7 = r0
                r8 = r10
                r0 = r14
                r10 = r3
                r3 = r6
                r14 = r16
            L_0x00e0:
                java.lang.ref.WeakReference<com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment> r2 = r1.that
                java.lang.Object r2 = r2.get()
                if (r2 == 0) goto L_0x0113
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r2 = new com.zing.zalo.zalosdk.oauth.model.LoginResponse
                r2.<init>()
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L_0x0115
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r2.setError(r0)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setErrorMsg(r7)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setErrorReason(r5)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setErrorDescription(r4)
                java.lang.String r3 = "web_login"
                r0.setFromSource(r3)
                java.lang.ref.WeakReference<com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment> r0 = r1.that
                java.lang.Object r0 = r0.get()
                com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment r0 = (com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment) r0
                r0.onLoginFailed(r2)
            L_0x0113:
                r2 = 1
                goto L_0x0149
            L_0x0115:
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r2.setError(r0)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setUid(r14)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setOauth(r10)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setViewer(r12)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setState(r11)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setZprotect(r3)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r0 = r0.setName(r13)
                r0.setRegister(r6)
                boolean r0 = android.text.TextUtils.isEmpty(r9)
                if (r0 != 0) goto L_0x013d
                r2.setExtInfo(r9)
            L_0x013d:
                java.lang.ref.WeakReference<com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment> r0 = r1.that
                java.lang.Object r0 = r0.get()
                com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment r0 = (com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment) r0
                r0.onLoginCompleted(r2)
                goto L_0x0113
            L_0x0149:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.register.ZaloWebLoginFragment.LoginEventDispacher.processCallbackUrl(java.lang.String):boolean");
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.that.get() != null) {
                this.that.get().progressBar.setVisibility(8);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.that.get() != null) {
                this.that.get().progressBar.setVisibility(0);
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            if (this.that.get() != null) {
                this.that.get().progressBar.setVisibility(8);
            }
            if (this.that.get() != null) {
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setError(-1).setUid(0).setOauth("").setViewer("").setZprotect(0).setName("").setRegister(false);
                this.that.get().onLoginCompleted(loginResponse);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (processCallbackUrl(str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private String generateLoginUrl(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, WEB_LOGIN_PATH));
        try {
            sb2.append(ZaloSDK.Instance.getAppID());
            sb2.append("&sign_key=");
            sb2.append(URLEncoder.encode(AppInfo.getApplicationHashKey(context), "UTF-8"));
            sb2.append("&pkg_name=");
            sb2.append(URLEncoder.encode(AppInfo.getPackageName(context), "UTF-8"));
            sb2.append("&os=");
            sb2.append(PlatformType.ANDROID.getCode());
            sb2.append("&state=");
            sb2.append(this.state);
            sb2.append("&lang=");
            sb2.append(Utils.getLanguage(context));
            sb2.append("&ext_info=");
            sb2.append(this.extInfo);
            sb2.append("&code_challenge=");
            sb2.append(this.codeChallenge);
        } catch (UnsupportedEncodingException e10) {
            Log.e((Exception) e10);
        }
        return sb2.toString();
    }

    public static ZaloWebLoginFragment newInstance(String str, String str2, String str3) {
        ZaloWebLoginFragment zaloWebLoginFragment = new ZaloWebLoginFragment();
        zaloWebLoginFragment.codeChallenge = str;
        zaloWebLoginFragment.state = str2;
        zaloWebLoginFragment.extInfo = str3;
        zaloWebLoginFragment.setArguments(new Bundle());
        return zaloWebLoginFragment;
    }

    private void setupCookie() {
        this.cookieManager.setAcceptThirdPartyCookies(this.webView, true);
        String[] strArr = {"id.zaloapp.com", "id.zalo.me"};
        int i10 = 0;
        while (true) {
            if (i10 >= 2) {
                this.cookieManager.removeAllCookie();
                break;
            }
            String str = strArr[i10];
            String cookie = this.cookieManager.getCookie(str);
            if (!(cookie == null || cookie.length() == 0)) {
                Matcher matcher = WZUIN.matcher(cookie);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    this.cookieManager.removeAllCookie();
                    this.cookieManager.setCookie(str, group);
                    Log.i(">> wzuin: " + group);
                    break;
                }
            }
            i10++;
        }
        this.cookieManager.flush();
    }

    private void setupWebView(View view) {
        Context context = getContext();
        this.webView = (WebView) view.findViewById(com.zing.zalo.zalosdk.core.helper.Utils.getResourceId(context, "zalosdk_login_webview", "id"));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setCacheMode(2);
        this.webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.webView.getSettings().setAllowContentAccess(true);
        this.webView.setWebViewClient(new LoginEventDispacher(getContext(), new WeakReference(this), c.f18246k + AppInfo.getPackageName(context)));
        try {
            String userAgentString = this.webView.getSettings().getUserAgentString();
            String str = "ZaloSDK";
            if (userAgentString != null) {
                if (!TextUtils.isEmpty(userAgentString)) {
                    str = userAgentString + str;
                }
            }
            this.webView.getSettings().setUserAgentString(str + " 4.24.1101");
        } catch (Exception e10) {
            Log.w(e10.getMessage());
        }
        this.webView.setLayerType(2, (Paint) null);
        this.webView.loadUrl(generateLoginUrl(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cookieSyncManager = CookieSyncManager.createInstance(getActivity());
        this.cookieManager = CookieManager.getInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(com.zing.zalo.zalosdk.core.helper.Utils.getResourceId(getContext(), "zalosdk_fragment_zalo_web_login", "layout"), viewGroup, false);
        setupWebView(inflate);
        ProgressBar progressBar2 = (ProgressBar) inflate.findViewById(com.zing.zalo.zalosdk.core.helper.Utils.getResourceId(getContext(), "zalosdk_progress", "id"));
        this.progressBar = progressBar2;
        progressBar2.setVisibility(0);
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(18);
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onLoginCompleted(LoginResponse loginResponse) {
        super.onLoginCompleted(loginResponse);
        this.cookieManager.removeSessionCookies((ValueCallback) null);
    }

    /* access modifiers changed from: protected */
    public void onLoginFailed(LoginResponse loginResponse) {
        super.onLoginFailed(loginResponse);
        this.cookieManager.removeSessionCookies((ValueCallback) null);
    }

    public void onResume() {
        super.onResume();
        setTitle(getString(com.zing.zalo.zalosdk.core.helper.Utils.getResourceId(getActivity(), "txt_title_login_zalo", "string")));
        showBackButton();
    }
}
