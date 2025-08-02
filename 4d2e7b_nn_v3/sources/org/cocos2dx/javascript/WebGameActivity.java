package org.cocos2dx.javascript;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.cocos2dx.javascript.DragFloatActionButton;

public class WebGameActivity extends Activity implements Runnable, DialogInterface.OnClickListener, DragFloatActionButton.OnClickListener, View.OnClickListener {
    public static final int RESULT_CODE_WEB_GAME = 1;
    private static final int TIMEOUT_SECONDS = 15;
    private Map<String, Call> callMap;
    private OkHttpClient client;
    private ExitDialog dialog;
    private String exitText;
    /* access modifiers changed from: private */
    public String fastestDomain;
    private String hallreturntype;
    /* access modifiers changed from: private */
    public int hideTime;
    private String homePage;
    /* access modifiers changed from: private */
    public boolean isDomainFailure = false;
    private String isGameSecondaryPop;
    private String isHtmlWay;
    private boolean isRtl;
    private ImageView iv_exit;
    private ImageView iv_switch;
    private LinearLayout ll_exit;
    private LinearLayout ll_exit_close;
    private LinearLayout ll_exit_open;
    private LinearLayout ll_layout_five;
    private LinearLayout ll_layout_four;
    private LinearLayout ll_layout_seven;
    private LinearLayout ll_layout_six;
    private LinearLayout ll_layout_three;
    private LinearLayout ll_layout_two;
    private String mBackHome;
    private String mBackHomeTip;
    private DragFloatActionButton mBtn;
    private String mContinueGame;
    private boolean mHasNotch = false;
    private j mOrientoin;
    private int mResult;
    private int mShowTipTime;
    private TextView mTextView;
    /* access modifiers changed from: private */
    public String mTip;
    private String mTipTitle;
    /* access modifiers changed from: private */
    public String mUrl;
    /* access modifiers changed from: private */
    public WebView mWebView;
    /* access modifiers changed from: private */
    public String mainDomain;
    private AlertDialog.Builder mbuilder;
    private String netErrorContentText;
    private String retryBtnSureText;
    private int retryDealyTime;
    private String retryTitle;
    public Timer timer;
    private TextView tv_exit;
    private TextView tv_exit_five;
    private TextView tv_exit_four;
    private TextView tv_exit_one;
    private TextView tv_exit_seven;
    private TextView tv_exit_six;
    private TextView tv_exit_three;
    private TextView tv_exit_two;
    private String webUrl;

    public interface DomainCallback {
        void onFailure(String str, IOException iOException);

        void onResponse(String str, Response response);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1444a;

        a(String str) {
            this.f1444a = str;
        }

        public void run() {
            Log.d("WebGameActivity", "找到最快的域名替换:" + this.f1444a);
            WebGameActivity webGameActivity = WebGameActivity.this;
            String o10 = webGameActivity.replaceDomainInUrl(webGameActivity.mUrl, this.f1444a);
            Log.d("WebGameActivity", "run: " + o10);
            WebGameActivity.this.mWebView.loadUrl(o10);
        }
    }

    class b implements DomainCallback {
        b() {
        }

        public void onFailure(String str, IOException iOException) {
            if (WebGameActivity.this.mainDomain.equals(str)) {
                WebGameActivity.this.isDomainFailure = true;
                if (WebGameActivity.this.fastestDomain != null) {
                    WebGameActivity webGameActivity = WebGameActivity.this;
                    webGameActivity.reloadUrl(webGameActivity.fastestDomain);
                }
            }
        }

        public void onResponse(String str, Response response) {
            Log.d("WebGameActivity", "请求返回最快的域名:" + str);
            WebGameActivity.this.fastestDomain = str;
            if (WebGameActivity.this.isDomainFailure) {
                WebGameActivity.this.reloadUrl(str);
            }
        }
    }

    class c implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DomainCallback f1448b;

        c(String str, DomainCallback domainCallback) {
            this.f1447a = str;
            this.f1448b = domainCallback;
        }

        public void onFailure(Call call, IOException iOException) {
            Log.d("WebGameActivity", "请求失败: " + this.f1447a + ", 错误: " + iOException.getMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("请求失败: ");
            sb2.append(this.f1447a);
            Log.d("WebGameActivity", sb2.toString());
            this.f1448b.onFailure(this.f1447a, iOException);
        }

        public void onResponse(Call call, Response response) {
            String string = response.body().string();
            if (response.isSuccessful() && WebGameActivity.this.fastestDomain == null && string.equalsIgnoreCase("OK")) {
                Log.d("WebGameActivity", "请求返回成功: " + this.f1447a);
                Log.d("WebGameActivity", "数据: " + string);
                this.f1448b.onResponse(this.f1447a, response);
            }
            response.close();
        }
    }

    class d extends TimerTask {

        class a implements Runnable {
            a() {
            }

            public void run() {
                Log.d("WebGameActivity", "找到最快的域名替换:" + WebGameActivity.this.fastestDomain);
                WebGameActivity webGameActivity = WebGameActivity.this;
                String o10 = webGameActivity.replaceDomainInUrl(webGameActivity.mUrl, WebGameActivity.this.fastestDomain);
                Log.d("WebGameActivity", "run: " + o10);
                WebGameActivity.this.mWebView.loadUrl(o10);
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                WebGameActivity.this.showEnterGameError();
            }
        }

        d() {
        }

        public void run() {
            if (WebGameActivity.this.fastestDomain != null) {
                WebGameActivity.this.runOnUiThread(new a());
                return;
            }
            Log.d("WebGameActivity", "加载不到可用的域名...");
            WebGameActivity.this.runOnUiThread(new b());
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View view) {
            WebGameActivity.this.closeActivity(0);
        }
    }

    class f implements DialogInterface.OnClickListener {
        f() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }

    class g extends i {
        g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (WebGameActivity.this.mWebView != null) {
                WebGameActivity.this.mWebView.setVisibility(0);
            } else {
                Log.e("TAG", "mWebView is null, check your initialization.");
            }
        }

        public void onPageFinished(WebView webView, String str) {
            Log.d("打开webview延时多少秒 ", Integer.toString(WebGameActivity.this.hideTime));
            new Handler().postDelayed(new a0(this), (long) (WebGameActivity.this.hideTime * 1000));
        }
    }

    class h implements Runnable {

        class a implements Runnable {
            a() {
            }

            public void run() {
                WebGameActivity.this.closeActivity(0);
            }
        }

        h() {
        }

        public void run() {
            Log.d("关闭提示框,关闭webview,返回大厅 ", "=======");
            WebGameActivity.this.runOnUiThread(new a());
        }
    }

    class i extends TimerTask {
        i() {
        }

        public void run() {
            Log.d("开启提示框  ", "tip:" + WebGameActivity.this.mTip);
            WebGameActivity.this.openTipToast();
        }
    }

    private class j extends OrientationEventListener {

        /* renamed from: a  reason: collision with root package name */
        Activity f1459a;

        public j(Context context) {
            super(context);
            this.f1459a = (Activity) context;
            if (Settings.System.getInt(WebGameActivity.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                enable();
            }
        }

        public void onOrientationChanged(int i10) {
            int i11 = WebGameActivity.this.getResources().getConfiguration().orientation;
            if ((i10 < 0 || i10 >= 45) && i10 <= 315) {
                if (i10 <= 225 || i10 >= 315) {
                    if (i10 <= 45 || i10 >= 135) {
                        if (i10 > 135 && i10 < 225 && i11 != 9) {
                            this.f1459a.setRequestedOrientation(9);
                        }
                    } else if (i11 != 8) {
                        this.f1459a.setRequestedOrientation(8);
                    }
                } else if (i11 != 0) {
                    this.f1459a.setRequestedOrientation(0);
                }
            } else if (i11 != 1 && i11 != 9) {
                this.f1459a.setRequestedOrientation(1);
            }
        }
    }

    private void checkTimeout() {
        Log.d("WebGameActivity", "checkTimeout...");
        this.timer.schedule(new d(), (long) (this.retryDealyTime * 1000));
    }

    private void executeGameWithRetry(String str) {
        Log.d("WebGameActivity", "executeGameWithRetry:" + str);
        if (isValidURL(str)) {
            this.mWebView.loadUrl(str);
            Uri parse = Uri.parse(str);
            this.mainDomain = parse.getScheme() + "://" + parse.getHost();
            String queryParameter = parse.getQueryParameter("other");
            if (queryParameter != null) {
                checkTimeout();
            }
            if (queryParameter != null && queryParameter.length() > 4) {
                Log.d("WebGameActivity", "otherParam:" + queryParameter);
                Log.d("WebGameActivity", "mainDomain:" + this.mainDomain);
                ArrayList arrayList = new ArrayList();
                arrayList.add(0, this.mainDomain);
                for (String str2 : queryParameter.split(";")) {
                    if (str2 != null && !str2.trim().isEmpty()) {
                        arrayList.add(str2.trim());
                    }
                }
                Log.d("WebGameActivity", "domainsUrls:" + arrayList.toString());
                if (arrayList.size() > 0) {
                    checkTimeout();
                    this.fastestDomain = null;
                    this.isDomainFailure = false;
                    Log.d("WebGameActivity", "开始查找最快的域名...");
                    findFastestDomain(arrayList, new b());
                }
            }
        }
    }

    private String getTestDomainUrl(String str) {
        return str + "/agespeed.txt";
    }

    /* access modifiers changed from: private */
    public void goClose() {
        closeActivity(0);
    }

    private void initShowStyle(String str) {
        if (str == null || "".equals(str)) {
            this.ll_exit_open.setVisibility(0);
        } else if (str.equals("1")) {
            this.ll_exit_open.setVisibility(0);
        } else if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            this.ll_layout_two.setVisibility(0);
        } else if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
            this.ll_layout_three.setVisibility(0);
        } else if (str.equals("4")) {
            this.ll_layout_four.setVisibility(0);
        } else if (str.equals("5")) {
            this.ll_layout_five.setVisibility(0);
        } else if (str.equals("6")) {
            this.ll_layout_six.setVisibility(0);
        } else if (str.equals("7")) {
            this.ll_layout_seven.setVisibility(0);
        } else {
            this.ll_exit_open.setVisibility(0);
        }
    }

    private void initWebView() {
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        this.hideTime = Integer.parseInt(getIntent().getStringExtra("hideTime"));
        g gVar = new g();
        WebView webView = this.mWebView;
        gVar.f1469a = webView;
        gVar.f1470b = this.mTextView;
        gVar.f1471c = this;
        gVar.f1472d = this.webUrl;
        webView.setVisibility(8);
        this.mWebView.setWebViewClient(gVar);
        this.mWebView.setWebChromeClient(new WebChromeClient());
    }

    private void isExit() {
        if ("1".equals(this.isGameSecondaryPop)) {
            Log.d("WebGameActivity", "开启二次弹窗: " + this.isGameSecondaryPop);
            ExitDialog exitDialog = this.dialog;
            if (exitDialog != null) {
                exitDialog.show();
                return;
            }
            ExitDialog exitDialog2 = new ExitDialog(this, this.mTipTitle, this.mBackHomeTip, this.mContinueGame, this.mBackHome, this.isRtl);
            this.dialog = exitDialog2;
            exitDialog2.setNoOnClickListener(new y(this));
            this.dialog.setExitOnClickListener(new z(this));
            this.dialog.show();
            return;
        }
        Log.d("WebGameActivity", "未开启二次弹窗: " + this.isGameSecondaryPop);
        goClose();
    }

    private boolean isValidURL(String str) {
        if (str == null || (!str.startsWith(com.alibaba.pdns.s.e.c.f18246k) && !str.startsWith(com.alibaba.pdns.s.e.c.f18247l))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isExit$0() {
        this.dialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat lambda$setSafeArea$1(View view, WindowInsetsCompat windowInsetsCompat) {
        int i10 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout()).top;
        int i11 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout()).bottom;
        int max = Math.max(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout()).left, windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout()).right);
        int max2 = Math.max(i10, i11);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
        layoutParams.setMargins(max, max2, max, max2);
        view.setLayoutParams(layoutParams);
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public void openTipToast() {
        Looper.prepare();
        try {
            Toast toast = new Toast(this);
            toast.setDuration(1);
            View inflate = LayoutInflater.from(this).inflate(R.layout.layout_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.toast_tv)).setText(this.mTip);
            toast.setGravity(17, 0, 0);
            toast.setView(inflate);
            toast.show();
            new Handler().postDelayed(new h(), 4000);
        } catch (Exception e10) {
            Log.e("openTipToast", e10.getMessage());
            e10.getStackTrace();
        }
        Looper.loop();
    }

    /* access modifiers changed from: private */
    public void reloadUrl(String str) {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
        cancelAllOtherCalls((String) null, true);
        runOnUiThread(new a(str));
    }

    /* access modifiers changed from: private */
    public String replaceDomainInUrl(String str, String str2) {
        try {
            String file = new URL(str).getFile();
            return str2 + file;
        } catch (Exception unused) {
            return str;
        }
    }

    private List<String> replaceDomainsInUrls(String str, String str2) {
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String replaceDomainInUrl : split) {
            arrayList.add(replaceDomainInUrl(str, replaceDomainInUrl));
        }
        return arrayList;
    }

    private void setInit() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26 && DeviceUtils.isTranslucentOrFloating(this)) {
            boolean fixOrientation = DeviceUtils.fixOrientation(this);
            Log.i("WebGameActivity", "onCreate fixOrientation when Oreo, result = " + fixOrientation);
        }
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().addFlags(Integer.MIN_VALUE);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.systemUiVisibility = 2050;
        if (i10 >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        getWindow().setAttributes(attributes);
        getWindow().setFlags(1024, 1024);
    }

    private void setSafeArea() {
        ViewCompat.setOnApplyWindowInsetsListener(this.mWebView, new x());
    }

    private void setTipTimer() {
        int i10 = this.mShowTipTime * 1000;
        Log.d("setTipTimer    ", " delay:" + i10);
        try {
            new Timer().schedule(new i(), (long) i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void showEnterGameError() {
        Log.d("TAG", "showEnterGameError");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.game_webview_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_exit);
        ((TextView) inflate.findViewById(R.id.tv_title)).setText(this.retryTitle);
        ((TextView) inflate.findViewById(R.id.tv_contect)).setText(this.netErrorContentText);
        textView.setText(this.retryBtnSureText);
        textView.setOnClickListener(new e());
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCancelable(false);
        create.show();
    }

    public void cancelAllOtherCalls(String str, boolean z10) {
        for (Map.Entry next : this.callMap.entrySet()) {
            if (z10 || !((String) next.getKey()).equals(str)) {
                ((Call) next.getValue()).cancel();
            }
        }
        this.callMap.clear();
    }

    public void closeActivity(int i10) {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
        }
        if (i10 > 0) {
            WebView webView2 = this.mWebView;
            if (webView2 != null) {
                webView2.clearCache(true);
                this.mWebView.clearHistory();
                this.mWebView.clearFormData();
            }
            this.mResult = i10;
        }
        Intent intent = getIntent();
        intent.putExtra(DbParams.KEY_CHANNEL_RESULT, "" + i10);
        setResult(1, intent);
        finish();
    }

    public void findFastestDomain(ArrayList<String> arrayList, DomainCallback domainCallback) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String testDomainUrl = getTestDomainUrl(next);
            Log.d("WebGameActivity", "开始发送请求: " + testDomainUrl);
            Call newCall = this.client.newCall(new Request.Builder().url(testDomainUrl).build());
            this.callMap.put(next, newCall);
            newCall.enqueue(new c(next, domainCallback));
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ll_layout_one || view.getId() == R.id.ll_layout_two || view.getId() == R.id.ll_layout_three || view.getId() == R.id.ll_layout_four || view.getId() == R.id.ll_layout_five || view.getId() == R.id.ll_layout_six || view.getId() == R.id.ll_layout_seven) {
            isExit();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.timer = new Timer();
        setInit();
        setContentView(R.layout.webgame_layout);
        Intent intent = getIntent();
        this.mTipTitle = intent.getStringExtra("tip_title");
        this.mBackHomeTip = intent.getStringExtra("back_home_tip");
        this.mBackHome = intent.getStringExtra("back_home");
        this.mContinueGame = intent.getStringExtra("continue_game");
        this.mHasNotch = intent.getStringExtra("has_notch").equals("1");
        this.mShowTipTime = Integer.parseInt(intent.getStringExtra("showTipTime"));
        this.retryDealyTime = Integer.parseInt(intent.getStringExtra("retryDealyTime"));
        this.mTip = intent.getStringExtra("tip");
        this.exitText = intent.getStringExtra("exit");
        this.homePage = intent.getStringExtra("homePage");
        this.hallreturntype = intent.getStringExtra("hallreturntype");
        this.isHtmlWay = intent.getStringExtra("isHtmlWay");
        this.retryTitle = intent.getStringExtra("retryTitle");
        this.retryBtnSureText = intent.getStringExtra("retryBtnSureText");
        this.netErrorContentText = intent.getStringExtra("netErrorContentText");
        this.webUrl = intent.getStringExtra("webUrl");
        this.isGameSecondaryPop = intent.getStringExtra("isGameSecondaryPop");
        this.isRtl = intent.getBooleanExtra("isRtl", false);
        String stringExtra = intent.getStringExtra("screen_type");
        if (stringExtra == null) {
            stringExtra = "0";
        }
        this.hideTime = 0;
        runOnUiThread(this);
        int i10 = getResources().getConfiguration().orientation;
        if (stringExtra.equals("0")) {
            setRequestedOrientation(6);
        } else if (stringExtra.equals("1")) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
            this.mOrientoin = new j(this);
        }
        this.mUrl = intent.getStringExtra(ImagesContract.URL);
        this.mTextView = (TextView) findViewById(R.id.textView);
        this.ll_exit_open = (LinearLayout) findViewById(R.id.ll_layout_one);
        this.ll_exit_close = (LinearLayout) findViewById(R.id.rl_exit_close);
        this.tv_exit_one = (TextView) findViewById(R.id.tv_exit_one);
        this.ll_exit = (LinearLayout) findViewById(R.id.rl_exit);
        this.tv_exit = (TextView) findViewById(R.id.tv_exit);
        this.iv_exit = (ImageView) findViewById(R.id.iv_exit);
        this.ll_layout_two = (LinearLayout) findViewById(R.id.ll_layout_two);
        this.tv_exit_two = (TextView) findViewById(R.id.tv_exit_two);
        this.ll_layout_three = (LinearLayout) findViewById(R.id.ll_layout_three);
        this.tv_exit_three = (TextView) findViewById(R.id.tv_exit_three);
        this.ll_layout_four = (LinearLayout) findViewById(R.id.ll_layout_four);
        this.tv_exit_four = (TextView) findViewById(R.id.tv_exit_four);
        this.ll_layout_five = (LinearLayout) findViewById(R.id.ll_layout_five);
        this.tv_exit_five = (TextView) findViewById(R.id.tv_exit_five);
        this.ll_layout_six = (LinearLayout) findViewById(R.id.ll_layout_six);
        this.tv_exit_six = (TextView) findViewById(R.id.tv_exit_six);
        this.ll_layout_seven = (LinearLayout) findViewById(R.id.ll_layout_seven);
        this.tv_exit_seven = (TextView) findViewById(R.id.tv_exit_seven);
        this.tv_exit.setText(this.exitText);
        this.tv_exit_one.setText(this.homePage);
        this.tv_exit_two.setText(this.homePage);
        this.tv_exit_three.setText(this.homePage);
        this.tv_exit_four.setText(this.homePage);
        this.tv_exit_five.setText(this.homePage);
        this.tv_exit_six.setText(this.homePage);
        this.tv_exit_seven.setText(this.homePage);
        this.ll_exit_open.setOnClickListener(this);
        this.ll_exit_close.setOnClickListener(this);
        this.ll_exit.setOnClickListener(this);
        this.ll_layout_two.setOnClickListener(this);
        this.ll_layout_three.setOnClickListener(this);
        this.ll_layout_four.setOnClickListener(this);
        this.ll_layout_five.setOnClickListener(this);
        this.ll_layout_six.setOnClickListener(this);
        this.ll_layout_seven.setOnClickListener(this);
        this.mTextView.setVisibility(4);
        initShowStyle(this.hallreturntype);
        WebView webView = new WebView(this);
        this.mWebView = webView;
        webView.setVisibility(0);
        ((ViewGroup) findViewById(R.id.h5gameWebView)).addView(this.mWebView);
        setSafeArea();
        initWebView();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        long j10 = (long) this.retryDealyTime;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.client = builder.connectTimeout(j10, timeUnit).readTimeout((long) this.retryDealyTime, timeUnit).build();
        this.callMap = new HashMap();
        Log.d("WebGameActivity", "isHtmlWay: " + this.isHtmlWay);
        if ("1".equals(this.isHtmlWay)) {
            Log.d("WebGameActivity", "使用pg的打开方式");
            this.mWebView.loadDataWithBaseURL((String) null, this.mUrl, (String) null, (String) null, (String) null);
        } else {
            executeGameWithRetry(this.mUrl);
        }
        this.mResult = 0;
        if (this.mShowTipTime > 0) {
            setTipTimer();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.mWebView != null) {
            Log.d(" WebView onDestroy", " resCode:" + this.mResult);
            try {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
                this.mWebView.removeAllViews();
                this.mWebView.destroy();
                this.mWebView = null;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        super.onDestroy();
        j jVar = this.mOrientoin;
        if (jVar != null) {
            jVar.disable();
        }
        ExitDialog exitDialog = this.dialog;
        if (exitDialog != null) {
            exitDialog.dismiss();
        }
        System.gc();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        isExit();
        return true;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    public void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        this.mbuilder = builder;
        builder.setTitle(this.mTipTitle);
        this.mbuilder.setMessage(this.mBackHomeTip);
        this.mbuilder.setPositiveButton(this.mContinueGame, new f());
        this.mbuilder.setNeutralButton(this.mBackHome, this);
    }

    public void setRequestedOrientation(int i10) {
        if (Build.VERSION.SDK_INT != 26 || !DeviceUtils.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(i10);
        } else {
            Log.i("WebGameActivity", "avoid calling setRequestedOrientation when Oreo.");
        }
    }

    public void onClick() {
        AlertDialog.Builder builder = this.mbuilder;
        if (builder != null) {
            builder.show();
        }
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        closeActivity(0);
    }
}
