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
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.alibaba.pdns.s.e.c;
import com.zing.zalo.zalosdk.ZaloOAuthResultCode;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;
import com.zing.zalo.zalosdk.oauth.model.LoginResponse;
import com.zing.zalo.zalosdk.payment.direct.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZaloWebRegisterFragment extends ZaloWebLoginBaseFragment {
    public static final boolean USE_V3 = true;
    private static final String WEB_REGISTER_PATH = "/v3/auth?app_id=";
    private static final Pattern WZUIN = Pattern.compile("(wzuin=[\\d\\w]*)");
    CookieManager cookieManager;
    CookieSyncManager cookieSyncManager;
    ProgressBar progressBar;
    WebView webView;

    private static class LoginEventDispacher extends WebViewClient {
        private String callbackUrl;
        private WeakReference<ZaloWebRegisterFragment> that;

        public LoginEventDispacher(WeakReference<ZaloWebRegisterFragment> weakReference, String str) {
            this.that = weakReference;
            this.callbackUrl = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean processCallbackUrl(java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "error"
                java.lang.String r1 = ""
                java.lang.String r2 = r8.callbackUrl
                int r2 = r9.indexOf(r2)
                r3 = 0
                if (r2 == 0) goto L_0x000e
                return r3
            L_0x000e:
                android.net.Uri r9 = android.net.Uri.parse(r9)
                r4 = 0
                java.lang.String r2 = r9.getQueryParameter(r0)     // Catch:{ Exception -> 0x0025 }
                if (r2 == 0) goto L_0x0028
                java.lang.String r9 = r9.getQueryParameter(r0)     // Catch:{ Exception -> 0x0025 }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0025 }
                r2 = r1
                r0 = r3
                goto L_0x005e
            L_0x0025:
                r9 = move-exception
                r0 = r1
                goto L_0x0058
            L_0x0028:
                java.lang.String r0 = "uid"
                java.lang.String r0 = r9.getQueryParameter(r0)     // Catch:{ Exception -> 0x0025 }
                long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0025 }
                java.lang.String r0 = "code"
                java.lang.String r0 = r9.getQueryParameter(r0)     // Catch:{ Exception -> 0x0025 }
                java.lang.String r2 = "display_name"
                java.lang.String r1 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x004f }
                java.lang.String r2 = "zprotect"
                java.lang.String r9 = r9.getQueryParameter(r2)     // Catch:{ Exception -> 0x004f }
                if (r9 == 0) goto L_0x0054
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x004f }
                r2 = r1
                r1 = r0
                r0 = r9
                r9 = r3
                goto L_0x005e
            L_0x004f:
                r9 = move-exception
                r7 = r1
                r1 = r0
                r0 = r7
                goto L_0x0058
            L_0x0054:
                r2 = r1
                r9 = r3
                r1 = r0
                goto L_0x005d
            L_0x0058:
                com.zing.zalo.zalosdk.core.log.Log.e((java.lang.Exception) r9)
                r2 = r0
                r9 = r3
            L_0x005d:
                r0 = r9
            L_0x005e:
                java.lang.ref.WeakReference<com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment> r6 = r8.that
                java.lang.Object r6 = r6.get()
                if (r6 == 0) goto L_0x008d
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r6 = new com.zing.zalo.zalosdk.oauth.model.LoginResponse
                r6.<init>()
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r9 = r6.setError(r9)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r9 = r9.setUid(r4)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r9 = r9.setOauth(r1)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r9 = r9.setZprotect(r0)
                com.zing.zalo.zalosdk.oauth.model.LoginResponse r9 = r9.setName(r2)
                r9.setRegister(r3)
                java.lang.ref.WeakReference<com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment> r9 = r8.that
                java.lang.Object r9 = r9.get()
                com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment r9 = (com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment) r9
                r9.onLoginCompleted(r6)
            L_0x008d:
                r9 = 1
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.register.ZaloWebRegisterFragment.LoginEventDispacher.processCallbackUrl(java.lang.String):boolean");
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

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            int i10;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (this.that.get() != null) {
                this.that.get().progressBar.setVisibility(8);
                if (webResourceError.getErrorCode() == -2) {
                    i10 = ZaloOAuthResultCode.ERR_NO_NETWORK;
                } else {
                    i10 = webResourceError.getErrorCode();
                }
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setError(i10).setErrorMsg("").setErrorReason("").setErrorDescription("").setFromSource("web_view");
                this.that.get().onLoginFailed(loginResponse);
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
        sb2.append(ServiceMapManager.getInstance().urlFor(ServiceMapManager.KEY_URL_OAUTH, WEB_REGISTER_PATH));
        try {
            sb2.append(ZaloSDK.Instance.getAppID());
            sb2.append("&sign_key=");
            sb2.append(URLEncoder.encode(AppInfo.getApplicationHashKey(context), "UTF-8"));
            sb2.append("&pkg_name=");
            sb2.append(URLEncoder.encode(AppInfo.getPackageName(context), "UTF-8"));
            sb2.append("&orientation=");
            sb2.append(context.getResources().getConfiguration().orientation);
            sb2.append("&zregister=true");
            sb2.append("&ts=" + System.currentTimeMillis());
            sb2.append("&lang=" + Utils.getLanguage(context));
            sb2.append("#register");
        } catch (UnsupportedEncodingException e10) {
            Log.w(e10.getMessage());
        }
        return sb2.toString();
    }

    public static ZaloWebRegisterFragment newIstance() {
        ZaloWebRegisterFragment zaloWebRegisterFragment = new ZaloWebRegisterFragment();
        zaloWebRegisterFragment.setArguments(new Bundle());
        return zaloWebRegisterFragment;
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
                    Log.i("debuglog", "found set cookie: " + group);
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
        this.webView.setWebViewClient(new LoginEventDispacher(new WeakReference(this), c.f18246k + AppInfo.getPackageName(context)));
        try {
            String userAgentString = this.webView.getSettings().getUserAgentString();
            String str = "ZaloSDK";
            if (userAgentString != null) {
                if (!TextUtils.isEmpty(userAgentString)) {
                    str = userAgentString + str;
                }
            }
            this.webView.getSettings().setUserAgentString(str);
        } catch (Exception e10) {
            Log.w(e10.toString());
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
        progressBar2.setVisibility(8);
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

    public void onResume() {
        super.onResume();
        setTitle(getString(com.zing.zalo.zalosdk.core.helper.Utils.getResourceId(getActivity(), "txt_regis_acc", "string")));
        showBackButton();
    }
}
