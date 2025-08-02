package com.zing.zalo.zalosdk.oauth;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.adjust.sdk.Constants;
import com.zing.zalo.zalosdk.R;
import com.zing.zalo.zalosdk.oauth.dialog.PaymentProcessingDialog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    private static final int BACKGROUND_WHITE = 16777215;
    public static final int DEFAULT_THEME = 16973840;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    public static final String EXTRA_OAUTH_CODE = "oauthCodeaa";
    public static final String EXTRA_QUERY = "querystring";
    public static final String EXTRA_REQUEST_BODY = "bodyrequest";
    private static final String LOG_TAG = "WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static final String UTF8 = "UTF-8";
    private static final Pattern WZUIN = Pattern.compile("(wzuin=[\\d\\w]*)");
    private String code;
    /* access modifiers changed from: private */
    public FrameLayout contentFrameLayout;
    CookieManager cookieManager;
    CookieSyncManager cookieSyncManager;
    /* access modifiers changed from: private */
    public ImageView crossImageView;
    /* access modifiers changed from: private */
    public boolean isDetached;
    private boolean isDismissed;
    private boolean listenerCalled;
    OrientationEventListener myOrientationEventListener;
    int oldWidth;
    private OnCompleteListener onCompleteListener;
    private String query;
    private String queryBody;
    /* access modifiers changed from: private */
    public PaymentProcessingDialog spinner;
    private String url;
    /* access modifiers changed from: private */
    public WebView webView;
    ZaloPluginCallback zFeedCallback;

    public static class Builder extends BuilderBase<Builder> {
        public Builder(Context context, String str) {
            super(context, str);
        }

        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        public /* bridge */ /* synthetic */ BuilderBase setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        public /* bridge */ /* synthetic */ BuilderBase setTheme(int i10) {
            return super.setTheme(i10);
        }

        public Builder(Context context, String str, Bundle bundle) {
            super(context, str, bundle);
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            super(context, str, str2, bundle);
        }
    }

    private class DialogWebViewClient extends WebViewClient {
        private DialogWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPageStarted(android.webkit.WebView r3, java.lang.String r4, android.graphics.Bitmap r5) {
            /*
                r2 = this;
                super.onPageStarted(r3, r4, r5)
                com.zing.zalo.zalosdk.oauth.WebDialog r5 = com.zing.zalo.zalosdk.oauth.WebDialog.this
                boolean r5 = r5.isDetached
                if (r5 != 0) goto L_0x0014
                com.zing.zalo.zalosdk.oauth.WebDialog r5 = com.zing.zalo.zalosdk.oauth.WebDialog.this
                com.zing.zalo.zalosdk.oauth.dialog.PaymentProcessingDialog r5 = r5.spinner
                r5.show()
            L_0x0014:
                java.lang.String r5 = "plugin.zaloapp.com/webview/callback"
                boolean r5 = r4.contains(r5)
                if (r5 == 0) goto L_0x005a
                r3.stopLoading()
                com.zing.zalo.zalosdk.oauth.WebDialog r3 = com.zing.zalo.zalosdk.oauth.WebDialog.this
                com.zing.zalo.zalosdk.oauth.ZaloPluginCallback r3 = r3.zFeedCallback
                if (r3 == 0) goto L_0x005a
                android.net.Uri r3 = android.net.Uri.parse(r4)
                java.lang.String r3 = r3.getQuery()
                android.os.Bundle r3 = r2.parseUrlQueryString(r3)
                java.lang.String r4 = "error_code"
                java.lang.String r4 = r3.getString(r4)
                boolean r5 = android.text.TextUtils.isEmpty(r4)
                r0 = 0
                if (r5 != 0) goto L_0x0043
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0043 }
                goto L_0x0044
            L_0x0043:
                r4 = r0
            L_0x0044:
                if (r4 != 0) goto L_0x0047
                r0 = 1
            L_0x0047:
                java.lang.String r5 = "error_message"
                java.lang.String r5 = r3.getString(r5)
                java.lang.String r1 = "result_data"
                java.lang.String r3 = r3.getString(r1)
                com.zing.zalo.zalosdk.oauth.WebDialog r1 = com.zing.zalo.zalosdk.oauth.WebDialog.this
                com.zing.zalo.zalosdk.oauth.ZaloPluginCallback r1 = r1.zFeedCallback
                r1.onResult(r0, r4, r5, r3)
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.zalosdk.oauth.WebDialog.DialogWebViewClient.onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap):void");
        }

        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            WebDialog.this.sendErrorToListener((Throwable) null);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.sendErrorToListener((Throwable) null);
        }

        public Bundle parseUrlQueryString(String str) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    try {
                        if (split2.length == 2) {
                            bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                        } else if (split2.length == 1) {
                            bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                        }
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
            }
            return bundle;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public static class FeedDialogBuilder extends BuilderBase<FeedDialogBuilder> {
        private static final String CAPTION_PARAM = "caption";
        private static final String DESCRIPTION_PARAM = "description";
        private static final String FEED_DIALOG = "feed";
        private static final String FROM_PARAM = "from";
        private static final String LINK_PARAM = "link";
        private static final String NAME_PARAM = "name";
        private static final String PICTURE_PARAM = "picture";
        private static final String SOURCE_PARAM = "source";
        private static final String TO_PARAM = "to";

        public FeedDialogBuilder(Context context) {
            super(context, FEED_DIALOG);
        }

        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        public FeedDialogBuilder setCaption(String str) {
            getParameters().putString(CAPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setDescription(String str) {
            getParameters().putString(DESCRIPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setFrom(String str) {
            getParameters().putString("from", str);
            return this;
        }

        public FeedDialogBuilder setLink(String str) {
            getParameters().putString(LINK_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setName(String str) {
            getParameters().putString("name", str);
            return this;
        }

        public /* bridge */ /* synthetic */ BuilderBase setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        public FeedDialogBuilder setPicture(String str) {
            getParameters().putString(PICTURE_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setSource(String str) {
            getParameters().putString("source", str);
            return this;
        }

        public /* bridge */ /* synthetic */ BuilderBase setTheme(int i10) {
            return super.setTheme(i10);
        }

        public FeedDialogBuilder setTo(String str) {
            getParameters().putString(TO_PARAM, str);
            return this;
        }

        public FeedDialogBuilder(Context context, Bundle bundle) {
            super(context, FEED_DIALOG, bundle);
        }

        public FeedDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, FEED_DIALOG, bundle);
        }
    }

    public interface OnCompleteListener {
        void onComplete(Bundle bundle);
    }

    public static class RequestsDialogBuilder extends BuilderBase<RequestsDialogBuilder> {
        private static final String APPREQUESTS_DIALOG = "apprequests";
        private static final String DATA_PARAM = "data";
        private static final String MESSAGE_PARAM = "message";
        private static final String TITLE_PARAM = "title";
        private static final String TO_PARAM = "to";

        public RequestsDialogBuilder(Context context) {
            super(context, APPREQUESTS_DIALOG);
        }

        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        public RequestsDialogBuilder setData(String str) {
            getParameters().putString("data", str);
            return this;
        }

        public RequestsDialogBuilder setMessage(String str) {
            getParameters().putString(MESSAGE_PARAM, str);
            return this;
        }

        public /* bridge */ /* synthetic */ BuilderBase setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        public /* bridge */ /* synthetic */ BuilderBase setTheme(int i10) {
            return super.setTheme(i10);
        }

        public RequestsDialogBuilder setTitle(String str) {
            getParameters().putString(TITLE_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder setTo(String str) {
            getParameters().putString(TO_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, APPREQUESTS_DIALOG, bundle);
        }
    }

    public WebDialog(Context context, String str) {
        this(context, str, DEFAULT_THEME);
    }

    private void calculateSize() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        if (Utilities.isTablet(getContext())) {
            int i12 = (i11 * 2) / 3;
            boolean isPortait = Utilities.isPortait(getContext());
            int i13 = Constants.MINIMAL_ERROR_STATUS_CODE;
            int i14 = 300;
            if (isPortait) {
                int i15 = (i10 * 2) / 3;
                if (i15 >= 300) {
                    i14 = i15;
                }
                if (i12 < 400) {
                    i12 = 400;
                }
            } else {
                int i16 = i10 / 2;
                if (i16 >= 400) {
                    i13 = i16;
                }
                if (i12 < 300) {
                    i12 = 300;
                }
                i14 = i13;
            }
            getWindow().setLayout(i14, i12);
            return;
        }
        getWindow().setLayout(i10, i11 - 80);
    }

    public static int convertDpToPixel(float f10, Context context) {
        return (int) (f10 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebDialog.this.dismiss();
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_close_web));
        this.crossImageView.setVisibility(4);
        this.crossImageView.setPadding(convertDpToPixel(7.0f, getContext()), convertDpToPixel(7.0f, getContext()), 0, 0);
    }

    private int getScaledSize(int i10, float f10, int i11, int i12) {
        int i13 = (int) (((float) i10) / f10);
        return (int) (((double) i10) * (i13 <= i11 ? 1.0d : i13 >= i12 ? 0.5d : ((((double) (i12 - i13)) / ((double) (i12 - i11))) * 0.5d) + 0.5d));
    }

    private int getScreenWidth() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void setUpWebView(int i10) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        AnonymousClass6 r12 = new WebView(getContext()) {
            public void onWindowFocusChanged(boolean z10) {
                try {
                    super.onWindowFocusChanged(z10);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.webView = r12;
        r12.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new DialogWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        setupCookie();
        this.webView.postUrl(this.url, this.queryBody.getBytes());
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setSaveFormData(false);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setDatabaseEnabled(true);
        linearLayout.setPadding(i10, i10, i10, i10);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(16777215);
        this.contentFrameLayout.addView(linearLayout);
    }

    private void setupCookie() {
        this.cookieSyncManager = CookieSyncManager.createInstance(getContext());
        CookieManager instance = CookieManager.getInstance();
        this.cookieManager = instance;
        instance.setAcceptThirdPartyCookies(this.webView, true);
        String cookie = this.cookieManager.getCookie("https://plugin.zaloapp.com");
        Log.i("debuglog", "cookie: " + cookie);
        this.cookieManager.removeAllCookie();
        CookieManager cookieManager2 = this.cookieManager;
        cookieManager2.setCookie("https://plugin.zaloapp.com", "code=" + this.code);
        this.cookieManager.flush();
        Log.i("debuglog", "set cookie: code=" + this.code);
        String cookie2 = this.cookieManager.getCookie("https://plugin.zaloapp.com");
        Log.i("debuglog", "cookies: " + cookie2);
    }

    /* access modifiers changed from: private */
    public void updateLayout() {
        if (this.oldWidth != getScreenWidth()) {
            calculateSize();
            this.oldWidth = getScreenWidth();
        }
    }

    public void dismiss() {
        if (!this.isDismissed) {
            this.isDismissed = true;
            OrientationEventListener orientationEventListener = this.myOrientationEventListener;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
            if (!this.listenerCalled) {
                sendCancelToListener();
            }
            WebView webView2 = this.webView;
            if (webView2 != null) {
                webView2.stopLoading();
            }
            if (!this.isDetached) {
                if (this.spinner.isShowing()) {
                    this.spinner.dismiss();
                }
                super.dismiss();
            }
        }
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    /* access modifiers changed from: protected */
    public WebView getWebView() {
        return this.webView;
    }

    /* access modifiers changed from: protected */
    public boolean isListenerCalled() {
        return this.listenerCalled;
    }

    public void onAttachedToWindow() {
        this.isDetached = false;
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentProcessingDialog paymentProcessingDialog = new PaymentProcessingDialog(getContext(), new PaymentProcessingDialog.OnCloseListener() {
            public void onClose() {
            }
        });
        this.spinner = paymentProcessingDialog;
        paymentProcessingDialog.requestWindowFeature(1);
        this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.dismiss();
            }
        });
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        calculateSize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        createCrossImage();
        this.crossImageView.getDrawable().getIntrinsicWidth();
        setUpWebView(0);
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.contentFrameLayout);
        this.crossImageView.bringToFront();
        AnonymousClass3 r32 = new OrientationEventListener(getContext(), 3) {
            public void onOrientationChanged(int i10) {
                if (i10 > 350 || i10 < 10) {
                    WebDialog.this.updateLayout();
                } else if (i10 < 100 && i10 > 80) {
                    WebDialog.this.updateLayout();
                } else if (i10 > 170 && i10 < 190) {
                    WebDialog.this.updateLayout();
                } else if (i10 > 260 && i10 < 280) {
                    WebDialog.this.updateLayout();
                }
            }
        };
        this.myOrientationEventListener = r32;
        if (r32.canDetectOrientation()) {
            this.myOrientationEventListener.enable();
        } else {
            this.myOrientationEventListener = null;
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        getWindow().addFlags(2);
        getWindow().getAttributes().dimAmount = 0.7f;
    }

    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void sendCancelToListener() {
        sendErrorToListener((Throwable) null);
    }

    /* access modifiers changed from: protected */
    public void sendErrorToListener(Throwable th) {
        OnCompleteListener onCompleteListener2 = this.onCompleteListener;
        if (onCompleteListener2 != null && !this.listenerCalled) {
            this.listenerCalled = true;
            onCompleteListener2.onComplete((Bundle) null);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener2 = this.onCompleteListener;
        if (onCompleteListener2 != null && !this.listenerCalled) {
            this.listenerCalled = true;
            onCompleteListener2.onComplete(bundle);
            dismiss();
        }
    }

    public void setFeedCallBackListener(ZaloPluginCallback zaloPluginCallback) {
        this.zFeedCallback = zaloPluginCallback;
    }

    public WebDialog(Context context, String str, int i10) {
        super(context, i10);
        this.listenerCalled = false;
        this.isDetached = false;
        this.isDismissed = false;
        this.oldWidth = 0;
        this.url = str;
    }

    private static class BuilderBase<CONCRETE extends BuilderBase<?>> {
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme = WebDialog.DEFAULT_THEME;

        protected BuilderBase(Context context2, String str) {
            finishInit(context2, str, (Bundle) null);
        }

        private void finishInit(Context context2, String str, Bundle bundle) {
            this.context = context2;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        public WebDialog build() {
            return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
        }

        /* access modifiers changed from: protected */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* access modifiers changed from: protected */
        public Context getContext() {
            return this.context;
        }

        /* access modifiers changed from: protected */
        public OnCompleteListener getListener() {
            return this.listener;
        }

        /* access modifiers changed from: protected */
        public Bundle getParameters() {
            return this.parameters;
        }

        /* access modifiers changed from: protected */
        public int getTheme() {
            return this.theme;
        }

        public CONCRETE setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public CONCRETE setTheme(int i10) {
            this.theme = i10;
            return this;
        }

        protected BuilderBase(Context context2, String str, Bundle bundle) {
            finishInit(context2, str, bundle);
        }

        protected BuilderBase(Context context2, String str, String str2, Bundle bundle) {
            finishInit(context2, str2, bundle);
        }
    }

    public WebDialog(Context context, String str, Bundle bundle, int i10, OnCompleteListener onCompleteListener2) {
        super(context, i10);
        this.listenerCalled = false;
        this.isDetached = false;
        this.isDismissed = false;
        this.oldWidth = 0;
        bundle = bundle == null ? new Bundle() : bundle;
        this.query = bundle.getString(EXTRA_QUERY);
        this.queryBody = bundle.getString(EXTRA_REQUEST_BODY);
        String str2 = this.query;
        this.query = str2 == null ? "" : str2;
        this.code = bundle.getString(EXTRA_OAUTH_CODE);
        this.url = "https://plugin.zaloapp.com/mobile-sharing?" + this.query;
        this.onCompleteListener = onCompleteListener2;
    }
}
