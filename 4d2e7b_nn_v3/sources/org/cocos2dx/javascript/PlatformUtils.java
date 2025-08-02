package org.cocos2dx.javascript;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.webkit.internal.AssetHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.botion.captcha.BOCaptchaClient;
import com.botion.captcha.BOCaptchaConfig;
import com.bugsnag.android.h3;
import com.bugsnag.android.o1;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cocos.lib.CocosEditBoxActivity;
import com.cocos.lib.CocosHelper;
import com.cocos.lib.CocosJavascriptJavaBridge;
import com.cocos.lib.GlobalObject;
import com.cocos.lib.JsbBridgeWrapper;
import com.cocos.sdk.AliProxyController;
import com.cocos.sdk.WgProxyController;
import com.cocos.sdk.ZolozController;
import com.facebook.GraphRequest;
import com.facebook.g;
import com.facebook.react.bridge.Callback;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.GTCaptcha4Config;
import com.geetest.core.GeeGuard;
import com.geetest.core.GeeGuardReceipt;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.livechatinc.inappchat.ChatWindowActivity;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import com.zing.zalo.zalosdk.oauth.LoginVia;
import com.zing.zalo.zalosdk.oauth.OAuthCompleteListener;
import com.zing.zalo.zalosdk.oauth.OauthResponse;
import com.zing.zalo.zalosdk.oauth.ZaloOpenAPICallback;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;
import com.zing.zalo.zalosdk.oauth.model.ErrorResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cocos2dx.javascript.rn.RNCtrl;
import org.cocos2dx.javascript.rn.RNDelegateManager;
import org.cocos2dx.javascript.rn.ThirdLoginModule;
import org.cocos2dx.javascript.sdk.LiveChatSDK;

public class PlatformUtils {
    private static final int GOOGLE_LOGIN_IN = 9001;
    private static final int LINE_LOGIN_CODE = 9002;
    public static final int LOCATION_CODE = 301;
    public static final int POST_CODE = 100;
    private static final int REQUEST_CODE_ALBUM = 1001;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_INSTALL = 101;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_RECORD_AUDIO = 104;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_SAVE_IMG = 102;
    public static final int SYSTEM_SETTING_CODE = 500;
    static final String TAG = "PlatformUtils";
    private static Boolean bDidJSInit = Boolean.FALSE;
    /* access modifiers changed from: private */
    public static BOCaptchaClient boCaptchaClient;
    public static Context context = null;
    /* access modifiers changed from: private */
    public static List<String> facebookPermissions = Arrays.asList(new String[]{"email"});
    /* access modifiers changed from: private */
    public static com.facebook.g fbCallbackManager;
    /* access modifiers changed from: private */
    public static GTCaptcha4Client gtCaptcha4Client;
    /* access modifiers changed from: private */
    public static boolean isOpenKeyboard = true;
    private static int isPreloadRnEnd = 0;
    public static boolean isVisiableForLast = false;
    public static int keyboardHeight = 0;
    private static LocationManager locationManager;
    private static String locationProvider = null;
    public static AppActivity mActivity;
    @SuppressLint({"HandlerLeak"})
    private static Handler mAlipeyHandler = new k();
    private static GoogleSignInClient mGoogleSignInClient;
    private static JSONObject mI18nCfgDef = null;
    private static JSONObject mI18nCfgJs = null;
    public static HashMap mInfoDic = new HashMap();
    private static String mLang = null;
    private static NetworkChangedReceiver mNetworkChangedReceiver = null;
    public static String mNetworkType = "NONE";
    public static int mSignalStrengthLevel = 4;
    public static int mWifiStrengthLevel = 4;
    public static int mWindowHeight = 0;
    public static List<String> mahDomains = null;
    public static ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;
    private static OrientationEventListener orientListener;
    /* access modifiers changed from: private */
    public static int orientType = 0;
    public static IAction sdkPause;
    public static IAction sdkResume;
    private static DialogFragment serviceDlg = null;
    /* access modifiers changed from: private */
    public static int statusBarState = 1;

    public interface IAction {
        void invoke();
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Log.d(PlatformUtils.TAG, "removeSplashView 1");
            PlatformUtils.mActivity.removeSplashView();
        }
    }

    class a0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1403a;

        a0(String str) {
            this.f1403a = str;
        }

        public void run() {
            CocosJavascriptJavaBridge.evalString(this.f1403a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1404a;

        b(String str) {
            this.f1404a = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.FileOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.FileOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.FileOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.io.FileOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.io.FileOutputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00c2 A[SYNTHETIC, Splitter:B:25:0x00c2] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8 A[SYNTHETIC, Splitter:B:28:0x00c8] */
        /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                java.io.File r0 = new java.io.File
                java.lang.String r1 = r11.f1404a
                r0.<init>(r1)
                boolean r0 = r0.exists()
                if (r0 != 0) goto L_0x000e
                return
            L_0x000e:
                java.lang.String r0 = r11.f1404a
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
                r1.append(r2)
                java.lang.String r2 = java.io.File.separator
                r1.append(r2)
                java.lang.String r3 = android.os.Environment.DIRECTORY_DCIM
                r1.append(r3)
                r1.append(r2)
                java.lang.String r3 = "Camera"
                r1.append(r3)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.io.File r2 = new java.io.File
                r2.<init>(r1)
                boolean r3 = r2.exists()
                if (r3 != 0) goto L_0x0047
                r2.mkdir()
            L_0x0047:
                java.lang.String r2 = r11.f1404a
                java.lang.String r3 = "/"
                int r3 = r2.lastIndexOf(r3)
                int r3 = r3 + 1
                java.lang.String r4 = r11.f1404a
                java.lang.String r5 = "."
                int r4 = r4.lastIndexOf(r5)
                java.lang.String r2 = r2.substring(r3, r4)
                int r3 = android.os.Build.VERSION.SDK_INT
                r4 = 29
                java.lang.String r5 = "window['G']?.PlatformUtils?.onSavedImage();"
                r6 = 90
                java.lang.String r7 = ".jpg"
                r8 = 0
                if (r3 >= r4) goto L_0x00d1
                java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bc }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
                r4.<init>()     // Catch:{ Exception -> 0x00bc }
                r4.append(r2)     // Catch:{ Exception -> 0x00bc }
                r4.append(r7)     // Catch:{ Exception -> 0x00bc }
                java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00bc }
                r3.<init>(r1, r2)     // Catch:{ Exception -> 0x00bc }
                java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00bc }
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00bc }
                r2.<init>(r1)     // Catch:{ Exception -> 0x00bc }
                android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                r0.compress(r4, r6, r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                org.cocos2dx.javascript.AppActivity r4 = org.cocos2dx.javascript.PlatformUtils.mActivity     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                android.provider.MediaStore.Images.Media.insertImage(r4, r0, r1, r8)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                java.lang.String r1 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
                r0.<init>(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                android.net.Uri r1 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                r0.setData(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                org.cocos2dx.javascript.AppActivity r1 = org.cocos2dx.javascript.PlatformUtils.mActivity     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                r1.sendBroadcast(r0)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                org.cocos2dx.javascript.PlatformUtils.callJSMethod(r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b4 }
                r2.close()     // Catch:{ IOException -> 0x00af }
                goto L_0x00c5
            L_0x00af:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00c5
            L_0x00b4:
                r0 = move-exception
                r8 = r2
                goto L_0x00c6
            L_0x00b7:
                r0 = move-exception
                r8 = r2
                goto L_0x00bd
            L_0x00ba:
                r0 = move-exception
                goto L_0x00c6
            L_0x00bc:
                r0 = move-exception
            L_0x00bd:
                r0.getStackTrace()     // Catch:{ all -> 0x00ba }
                if (r8 == 0) goto L_0x00c5
                r8.close()     // Catch:{ IOException -> 0x00af }
            L_0x00c5:
                return
            L_0x00c6:
                if (r8 == 0) goto L_0x00d0
                r8.close()     // Catch:{ IOException -> 0x00cc }
                goto L_0x00d0
            L_0x00cc:
                r1 = move-exception
                r1.printStackTrace()
            L_0x00d0:
                throw r0
            L_0x00d1:
                android.content.ContentValues r1 = new android.content.ContentValues
                r1.<init>()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                long r9 = java.lang.System.currentTimeMillis()
                r3.append(r9)
                r3.append(r7)
                java.lang.String r2 = r3.toString()
                java.lang.String r3 = "_display_name"
                r1.put(r3, r2)
                java.lang.String r2 = "mime_type"
                java.lang.String r3 = "image/jpeg"
                r1.put(r2, r3)
                java.lang.String r2 = "relative_path"
                java.lang.String r3 = "DCIM/Camera"
                r1.put(r2, r3)
                android.net.Uri r2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                org.cocos2dx.javascript.AppActivity r3 = org.cocos2dx.javascript.PlatformUtils.mActivity
                android.content.ContentResolver r3 = r3.getContentResolver()
                android.net.Uri r1 = r3.insert(r2, r1)
                if (r1 == 0) goto L_0x013b
                java.io.OutputStream r8 = r3.openOutputStream(r1)     // Catch:{ IOException -> 0x0126 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x0126 }
                r0.compress(r1, r6, r8)     // Catch:{ IOException -> 0x0126 }
                org.cocos2dx.javascript.PlatformUtils.callJSMethod(r5)     // Catch:{ IOException -> 0x0126 }
                if (r8 == 0) goto L_0x013b
                r8.close()     // Catch:{ IOException -> 0x011f }
                goto L_0x013b
            L_0x011f:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x013b
            L_0x0124:
                r0 = move-exception
                goto L_0x0130
            L_0x0126:
                r0 = move-exception
                r0.printStackTrace()     // Catch:{ all -> 0x0124 }
                if (r8 == 0) goto L_0x013b
                r8.close()     // Catch:{ IOException -> 0x011f }
                goto L_0x013b
            L_0x0130:
                if (r8 == 0) goto L_0x013a
                r8.close()     // Catch:{ IOException -> 0x0136 }
                goto L_0x013a
            L_0x0136:
                r1 = move-exception
                r1.printStackTrace()
            L_0x013a:
                throw r0
            L_0x013b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PlatformUtils.b.run():void");
        }
    }

    class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1405a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1406b;

        b0(String str, String str2) {
            this.f1405a = str;
            this.f1406b = str2;
        }

        public void run() {
            JsbBridgeWrapper instance = JsbBridgeWrapper.getInstance();
            Log.d(PlatformUtils.TAG, "run: callJsbBridgeWrapper " + this.f1405a);
            instance.dispatchEventToScript(this.f1405a, this.f1406b);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1407a;

        c(String str) {
            this.f1407a = str;
        }

        public void run() {
            try {
                PlatformUtils.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f1407a)));
            } catch (Exception unused) {
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp"));
            intent.setFlags(268468224);
            if (intent.resolveActivity(PlatformUtils.mActivity.getPackageManager()) != null) {
                PlatformUtils.mActivity.startActivity(intent);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1408a;

        e(String str) {
            this.f1408a = str;
        }

        public void run() {
            JSONObject parseObject = JSON.parseObject(this.f1408a);
            String string = parseObject.getString("title");
            String string2 = parseObject.getString(FirebaseAnalytics.Param.CONTENT);
            String string3 = parseObject.getString("path");
            Log.d(PlatformUtils.TAG, "sysShare: title=" + string + ",content=" + string2 + "path=" + string3);
            if (string2 == null || string2.length() <= 0 || !((string == null || string.length() == 0) && (string3 == null || string3.length() == 0))) {
                LocalShareUtil.shareImg(PlatformUtils.mActivity, string3, string2, string, (String) null);
            } else {
                LocalShareUtil.shareText(PlatformUtils.mActivity, string2, (String) null);
            }
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1410b;

        f(String str, String str2) {
            this.f1409a = str;
            this.f1410b = str2;
        }

        public void run() {
            try {
                PlatformUtils.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f1409a + this.f1410b)));
            } catch (Exception unused) {
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1411a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1412b;

        g(String str, String str2) {
            this.f1411a = str;
            this.f1412b = str2;
        }

        public void run() {
            LiveChatSDK.getIns().initSDK(PlatformUtils.mActivity, this.f1411a, this.f1412b);
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            Intent intent = new Intent(PlatformUtils.context, ChatWindowActivity.class);
            intent.putExtras(LiveChatSDK.getIns().configuration.a());
            PlatformUtils.mActivity.startActivity(intent);
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            LiveChatSDK.getIns().clearSession();
        }
    }

    class j implements Runnable {
        j() {
        }

        public void run() {
            try {
                Intent launchIntentForPackage = PlatformUtils.mActivity.getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new Intent();
                    launchIntentForPackage.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity"));
                }
                launchIntentForPackage.setFlags(337641472);
                PlatformUtils.mActivity.startActivity(launchIntentForPackage);
            } catch (Exception unused) {
            }
        }
    }

    class k extends Handler {
        k() {
        }

        public void handleMessage(Message message) {
            String jSONString = JSON.toJSONString((Map) message.obj);
            Log.d(PlatformUtils.TAG, jSONString);
            String encodeToString = Base64.encodeToString(jSONString.getBytes(), 2);
            Log.d(PlatformUtils.TAG, encodeToString);
            PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.onPayFinished(\"%s\");", new Object[]{encodeToString}));
        }
    }

    class l implements Runnable {
        l() {
        }

        public void run() {
            int o10 = PlatformUtils.statusBarState;
            if (o10 == 1) {
                e9.h.e0(PlatformUtils.mActivity).B(e9.b.FLAG_SHOW_BAR).B(e9.b.FLAG_HIDE_NAVIGATION_BAR).Z(true).C();
            } else if (o10 == 2) {
                e9.h.e0(PlatformUtils.mActivity).B(e9.b.FLAG_SHOW_BAR).B(e9.b.FLAG_HIDE_NAVIGATION_BAR).Z(false).C();
            } else if (o10 == 3) {
                e9.h.e0(PlatformUtils.mActivity).B(e9.b.FLAG_HIDE_BAR).C();
            }
        }
    }

    class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1414b;

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i10) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PlatformUtils.mActivity.getPackageName(), (String) null));
                PlatformUtils.mActivity.startActivityForResult(intent, m.this.f1414b);
                dialogInterface.dismiss();
            }
        }

        m(String str, int i10) {
            this.f1413a = str;
            this.f1414b = i10;
        }

        public void run() {
            new AlertDialog.Builder(PlatformUtils.mActivity).setTitle(PlatformUtils.getI18nStr("tip_title")).setMessage(this.f1413a).setPositiveButton(PlatformUtils.getI18nStr("ok"), new a()).create().show();
        }
    }

    class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f1417b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1418c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Callback f1419d;

        class a implements GTCaptcha4Client.OnWebViewShowListener {
            a() {
            }

            public void onWebViewShow() {
                if (n.this.f1419d == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestShow();", new Object[0]));
                }
            }
        }

        class b implements GTCaptcha4Client.OnFailureListener {
            b() {
            }

            public void onFailure(String str) {
                Log.d(PlatformUtils.TAG, "onFailure: " + str);
                Callback callback = n.this.f1419d;
                if (callback == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestFailure(`%s`);", new Object[]{str}));
                    return;
                }
                try {
                    callback.invoke(Boolean.FALSE, str);
                } catch (Exception unused) {
                    Log.d(PlatformUtils.TAG, "geetest: Exception");
                }
            }
        }

        class c implements GTCaptcha4Client.OnSuccessListener {
            c() {
            }

            public void onSuccess(boolean z10, String str) {
                Log.d(PlatformUtils.TAG, "onSuccess: " + z10 + ", " + str);
                Callback callback = n.this.f1419d;
                if (callback == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestSuccess(%b,`%s`);", new Object[]{Boolean.valueOf(z10), str}));
                } else if (z10) {
                    try {
                        callback.invoke(Boolean.TRUE, str);
                    } catch (Exception unused) {
                        Log.d(PlatformUtils.TAG, "geetest: Exception");
                    }
                }
            }
        }

        n(String str, Activity activity, String str2, Callback callback) {
            this.f1416a = str;
            this.f1417b = activity;
            this.f1418c = str2;
            this.f1419d = callback;
        }

        public void run() {
            PlatformUtils.gtCaptcha4Client = GTCaptcha4Client.getClient(this.f1417b).init(this.f1418c, new GTCaptcha4Config.Builder().setLanguage(this.f1416a).build());
            PlatformUtils.gtCaptcha4Client.addOnSuccessListener(new c()).addOnFailureListener(new b()).addOnWebViewShowListener(new a()).verifyWithCaptcha();
        }
    }

    class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1424b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1425c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Callback f1426d;

        class a implements BOCaptchaClient.OnWebViewShowListener {
            a() {
            }

            public void onWebViewShow() {
                if (o.this.f1426d == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestShow();", new Object[0]));
                }
            }
        }

        class b implements BOCaptchaClient.OnFailureListener {
            b() {
            }

            public void onFailure(String str) {
                Log.d(PlatformUtils.TAG, "onFailure: " + str);
                Callback callback = o.this.f1426d;
                if (callback == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestFailure(`%s`);", new Object[]{str}));
                    return;
                }
                try {
                    callback.invoke(Boolean.FALSE, str);
                } catch (Exception unused) {
                    Log.d(PlatformUtils.TAG, "geetest: Exception");
                }
            }
        }

        class c implements BOCaptchaClient.OnSuccessListener {
            c() {
            }

            public void onSuccess(boolean z10, String str) {
                Log.d(PlatformUtils.TAG, "onSuccess: " + z10 + ", " + str);
                Callback callback = o.this.f1426d;
                if (callback == null) {
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.geetestSuccess(%b,`%s`);", new Object[]{Boolean.valueOf(z10), str}));
                } else if (z10) {
                    try {
                        callback.invoke(Boolean.TRUE, str);
                    } catch (Exception unused) {
                        Log.d(PlatformUtils.TAG, "geetest: Exception");
                    }
                }
            }
        }

        o(String str, String str2, String str3, Callback callback) {
            this.f1423a = str;
            this.f1424b = str2;
            this.f1425c = str3;
            this.f1426d = callback;
        }

        public void run() {
            JSONObject jSONObject;
            try {
                jSONObject = JSON.parseObject(this.f1423a);
            } catch (Exception e10) {
                e10.printStackTrace();
                jSONObject = null;
            }
            BOCaptchaConfig.Builder language = new BOCaptchaConfig.Builder().setLanguage(this.f1424b);
            if (jSONObject != null) {
                String[] w10 = PlatformUtils.jsonArrayToStringArray(jSONObject, "apiServers");
                if (w10 != null) {
                    language.setApiServers(w10);
                }
                String[] w11 = PlatformUtils.jsonArrayToStringArray(jSONObject, "staticServers");
                if (w11 != null) {
                    language.setStaticServers(w11);
                }
            }
            PlatformUtils.boCaptchaClient = BOCaptchaClient.getClient(PlatformUtils.mActivity).init(this.f1425c, language.build());
            PlatformUtils.boCaptchaClient.addOnSuccessListener(new c()).addOnFailureListener(new b()).addOnWebViewShowListener(new a()).verifyWithCaptcha();
        }
    }

    class p implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1430a;

        p(View view) {
            this.f1430a = view;
        }

        public void onGlobalLayout() {
            boolean z10;
            int i10;
            Rect rect = new Rect();
            this.f1430a.getWindowVisibleDisplayFrame(rect);
            int i11 = rect.bottom - rect.top;
            int height = this.f1430a.getHeight();
            if (((double) i11) / ((double) height) < 0.8d) {
                z10 = true;
            } else {
                z10 = false;
            }
            try {
                i10 = DeviceUtils.getStatusBarHeight(PlatformUtils.mActivity);
            } catch (Exception e10) {
                e10.printStackTrace();
                i10 = 0;
            }
            if (z10) {
                if (PlatformUtils.isOpenKeyboard) {
                    int i12 = (height - i11) - i10;
                    PlatformUtils.keyboardHeight = i12;
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.GetKeyBoardHeight(%d);", new Object[]{Integer.valueOf(i12)}));
                    Log.d("打开键盘:", String.valueOf(PlatformUtils.keyboardHeight));
                    PlatformUtils.isOpenKeyboard = false;
                } else {
                    return;
                }
            } else if (!PlatformUtils.isOpenKeyboard) {
                PlatformUtils.isOpenKeyboard = true;
                Log.d("关闭键盘:", "0");
                PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.GetKeyBoardHeight(%d);", new Object[]{0}));
                PlatformUtils.changeStatusBarUI();
            } else {
                return;
            }
            PlatformUtils.isVisiableForLast = z10;
        }
    }

    class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1431a;

        q(String str) {
            this.f1431a = str;
        }

        public void run() {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.f1431a));
                PlatformUtils.mActivity.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    class r implements RequestListener {
        r() {
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
            try {
                String str = (String) obj;
                String substring = str.substring(str.lastIndexOf(47) + 1, str.length());
                PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.loadGifOver(%b,`%s`);", new Object[]{Boolean.FALSE, substring.substring(0, substring.lastIndexOf(46))}));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return false;
        }

        public boolean onResourceReady(Object obj, Object obj2, Target target, DataSource dataSource, boolean z10) {
            try {
                String str = (String) obj2;
                String substring = str.substring(str.lastIndexOf(47) + 1, str.length());
                String substring2 = substring.substring(0, substring.lastIndexOf(46));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(CocosHelper.getWritablePath());
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append("gif");
                sb2.append(str2);
                sb2.append(substring2);
                String sb3 = sb2.toString();
                File file = new File(sb3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                hashMap.put("delay", arrayList);
                Drawable.ConstantState constantState = ((GifDrawable) obj).getConstantState();
                Field declaredField = constantState.getClass().getDeclaredField("frameLoader");
                declaredField.setAccessible(true);
                Object obj3 = declaredField.get(constantState);
                Field declaredField2 = obj3.getClass().getDeclaredField("gifDecoder");
                declaredField2.setAccessible(true);
                StandardGifDecoder standardGifDecoder = (StandardGifDecoder) declaredField2.get(obj3);
                for (int i10 = 0; i10 < standardGifDecoder.getFrameCount(); i10++) {
                    standardGifDecoder.advance();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(sb3 + File.separator + substring2 + "_" + i10 + ".png"));
                    standardGifDecoder.getNextFrame().compress(Bitmap.CompressFormat.PNG, 1, fileOutputStream);
                    arrayList.add(Float.valueOf(Integer.valueOf(standardGifDecoder.getNextDelay()).floatValue() / 1000.0f));
                    fileOutputStream.close();
                }
                hashMap.put("frameCount", Integer.valueOf(standardGifDecoder.getFrameCount()));
                hashMap.put("frameName", substring2);
                hashMap.put("loop", Integer.valueOf(standardGifDecoder.getNetscapeLoopCount()));
                String jSONString = JSON.toJSONString(hashMap);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File(sb3 + File.separator + "gifInfo.json")), StandardCharsets.UTF_8);
                outputStreamWriter.write(jSONString);
                outputStreamWriter.close();
                PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.loadGifOver(%b,`%s`);", new Object[]{Boolean.TRUE, substring2}));
            } catch (Exception e10) {
                String str3 = (String) obj2;
                String substring3 = str3.substring(str3.lastIndexOf(47) + 1, str3.length());
                PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.loadGifOver(%b,`%s`);", new Object[]{Boolean.FALSE, substring3.substring(0, substring3.lastIndexOf(46))}));
                e10.printStackTrace();
            }
            return false;
        }
    }

    class s implements h3 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1432a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1433b;

        s(String str, String str2) {
            this.f1432a = str;
            this.f1433b = str2;
        }

        public boolean a(o1 o1Var) {
            o1Var.r(this.f1432a);
            PlatformUtils.setEventCustomData(o1Var, this.f1433b);
            return true;
        }
    }

    static /* synthetic */ class t {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1434a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                i9.d[] r0 = i9.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1434a = r0
                i9.d r1 = i9.d.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1434a     // Catch:{ NoSuchFieldError -> 0x001d }
                i9.d r1 = i9.d.CANCEL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PlatformUtils.t.<clinit>():void");
        }
    }

    class u extends OrientationEventListener {
        u(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i10) {
            if (i10 != -1) {
                if (i10 > 80 && i10 < 100 && PlatformUtils.orientType != 1) {
                    PlatformUtils.orientType = 1;
                } else if (i10 > 260 && i10 < 280 && PlatformUtils.orientType != 0) {
                    PlatformUtils.orientType = 0;
                } else if (i10 > 350 && PlatformUtils.orientType != 3) {
                    PlatformUtils.orientType = 3;
                } else if (i10 > 170 && i10 < 190 && PlatformUtils.orientType != 4) {
                    PlatformUtils.orientType = 4;
                } else {
                    return;
                }
                PlatformUtils.onRotate(PlatformUtils.orientType);
            }
        }
    }

    class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1435a;

        v(String str) {
            this.f1435a = str;
        }

        public void run() {
            try {
                RNCtrl.receiveDataFromCocos(PlatformUtils.mActivity, this.f1435a);
            } catch (Exception e10) {
                e10.printStackTrace();
                Log.d(PlatformUtils.TAG, "receiveDataFromCocos异常");
            }
        }
    }

    class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1436a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1438c;

        w(String str, String str2, String str3) {
            this.f1436a = str;
            this.f1437b = str2;
            this.f1438c = str3;
        }

        public void run() {
            Log.e(PlatformUtils.TAG, "share to");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", this.f1436a);
            intent.putExtra("android.intent.extra.EMAIL", new String[]{this.f1437b});
            intent.putExtra("android.intent.extra.TEXT", this.f1438c);
            try {
                PlatformUtils.mActivity.startActivity(Intent.createChooser(intent, "Share To"));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    class x implements Runnable {

        class a implements com.facebook.j {
            a() {
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void c(com.facebook.login.j jVar, org.json.JSONObject jSONObject, com.facebook.t tVar) {
                if (jSONObject != null) {
                    jSONObject.optString("name");
                    String optString = jSONObject.optString("email");
                    String m10 = jVar.a().m();
                    PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.onFacebookLoginResult({id_token:\"%s\",email:\"%s\"});", new Object[]{m10, optString}));
                    if (PlatformUtils.isRn() && ThirdLoginModule.getInstance() != null) {
                        ThirdLoginModule.getInstance().facebookLoginResult(m10, optString);
                    }
                }
            }

            public void a(com.facebook.l lVar) {
                Log.e("facebook", "facebook error = " + lVar);
            }

            /* renamed from: d */
            public void onSuccess(com.facebook.login.j jVar) {
                GraphRequest z10 = GraphRequest.z(jVar.a(), new v(jVar));
                Bundle bundle = new Bundle();
                bundle.putString("fields", "id,name,email");
                z10.F(bundle);
                z10.j();
            }

            public void onCancel() {
            }
        }

        x() {
        }

        public void run() {
            PlatformUtils.fbCallbackManager = g.a.a();
            com.facebook.login.i.e().t(PlatformUtils.fbCallbackManager, new a());
            com.facebook.login.i.e().o(PlatformUtils.mActivity, PlatformUtils.facebookPermissions);
        }
    }

    class y implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1440a;

        y(String str) {
            this.f1440a = str;
        }

        public void run() {
            try {
                PlatformUtils.mActivity.startActivityForResult(com.linecorp.linesdk.auth.a.b(PlatformUtils.mActivity, this.f1440a, new LineAuthenticationParams.c().f(Arrays.asList(new i9.k[]{i9.k.f12368c, i9.k.f12372g, i9.k.f12373h})).e()), PlatformUtils.LINE_LOGIN_CODE);
            } catch (Exception e10) {
                Log.e("ERROR", e10.toString());
            }
        }
    }

    class z implements Runnable {

        class a extends OAuthCompleteListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f1441a;

            /* renamed from: org.cocos2dx.javascript.PlatformUtils$z$a$a  reason: collision with other inner class name */
            class C0024a implements ZaloOpenAPICallback {
                C0024a() {
                }

                public void onResult(org.json.JSONObject jSONObject) {
                    int optInt = jSONObject.optInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                    Log.d("ZALO", "Zalo onResult:" + optInt);
                    if (optInt == 0) {
                        String optString = jSONObject.optString("access_token");
                        jSONObject.optString("refresh_token");
                        Long.parseLong(jSONObject.optString("expires_in"));
                        PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.onZaloLoginResult({id_token:\"%s\"});", new Object[]{optString}));
                    }
                }
            }

            a(String str) {
                this.f1441a = str;
            }

            public void onAuthenError(ErrorResponse errorResponse) {
                Log.d("ZALO", "Zalo onAuthenError:" + errorResponse.getErrorMsg());
            }

            public void onGetOAuthComplete(OauthResponse oauthResponse) {
                String oauthCode = oauthResponse.getOauthCode();
                Log.d("ZALO", "Zalo onGetOAuthComplete:" + oauthCode);
                ZaloSDK.Instance.getAccessTokenByOAuthCode(PlatformUtils.mActivity, oauthCode, this.f1441a, new C0024a());
            }
        }

        z() {
        }

        public void run() {
            try {
                String v10 = PlatformUtils.generateCodeVerifier();
                String u10 = PlatformUtils.generateCodeChallenge(v10);
                PlatformUtils.zaloLogout();
                ZaloSDK.Instance.getAuthenticator().setUseWeakReferenceCallback(false);
                ZaloSDK.Instance.authenticateZaloWithAuthenType(PlatformUtils.mActivity, LoginVia.APP_OR_WEB, u10, new a(v10));
            } catch (Exception e10) {
                Log.e("ZALO", e10.toString());
            }
        }
    }

    private static void CheckGPSPermission() {
    }

    public static void CheckPostNotificationsPermission() {
        if (mActivity.checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            ActivityCompat.requestPermissions(mActivity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
        }
    }

    public static void CheckSysSettingPermission() {
        try {
            if (mActivity.checkSelfPermission("android.permission.WRITE_SETTINGS") != 0) {
                mActivity.requestPermissions(new String[]{"android.permission.WRITE_SETTINGS"}, 500);
            }
        } catch (Exception unused) {
        }
    }

    public static String GetDeviceResolution() {
        Display defaultDisplay = mActivity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        String str = String.valueOf(point.x) + "&" + String.valueOf(point.y);
        Log.d("分辨率01：", str);
        return str;
    }

    public static void GetLocation() {
        callJSMethod(String.format("window['G']?.PlatformUtils?.getLocationCallback(\"0,0\");", new Object[0]));
    }

    public static int GetSettingRotation() {
        try {
            return Settings.System.getInt(mActivity.getContentResolver(), "accelerometer_rotation", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void addOnSoftKeyBoardVisibleListener() {
        View decorView = mActivity.getWindow().getDecorView();
        onGlobalLayoutListener = new p(decorView);
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void alipayOpen() {
        Log.d(TAG, "alipayOpen()");
        mActivity.runOnUiThread(new d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[SYNTHETIC, Splitter:B:16:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A[SYNTHETIC, Splitter:B:21:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String bitmapToBase64(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0049
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0028, all -> 0x0026 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0024 }
            r3 = 30
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x0024 }
            r1.flush()     // Catch:{ Exception -> 0x0024 }
            r1.close()     // Catch:{ Exception -> 0x0024 }
            byte[] r4 = r1.toByteArray()     // Catch:{ Exception -> 0x0024 }
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x0024 }
            r4 = r0
            r0 = r1
            goto L_0x004a
        L_0x0021:
            r4 = move-exception
            r0 = r1
            goto L_0x003b
        L_0x0024:
            r4 = move-exception
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            goto L_0x003b
        L_0x0028:
            r4 = move-exception
            r1 = r0
        L_0x002a:
            r4.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0058
            r1.flush()     // Catch:{ Exception -> 0x0036 }
            r1.close()     // Catch:{ Exception -> 0x0036 }
            goto L_0x0058
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0058
        L_0x003b:
            if (r0 == 0) goto L_0x0048
            r0.flush()     // Catch:{ Exception -> 0x0044 }
            r0.close()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0048:
            throw r4
        L_0x0049:
            r4 = r0
        L_0x004a:
            if (r0 == 0) goto L_0x0057
            r0.flush()     // Catch:{ Exception -> 0x0053 }
            r0.close()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0057:
            r0 = r4
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.PlatformUtils.bitmapToBase64(android.graphics.Bitmap):java.lang.String");
    }

    private static String buildTransaction(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public static void callJSMethod(String str) {
        if (!bDidJSInit.booleanValue()) {
            Log.d(TAG, "JS not ready");
        } else {
            CocosHelper.runOnGameThread(new a0(str));
        }
    }

    public static void callJsbBridgeWrapper(String str, String str2) {
        CocosHelper.runOnGameThread(new b0(str, str2));
    }

    public static void changeStatusBarState(int i10) {
        statusBarState = i10;
        changeStatusBarUI();
        CocosEditBoxActivity.statusBarState = i10;
    }

    public static void changeStatusBarUI() {
        try {
            mActivity.runOnUiThread(new l());
        } catch (Exception unused) {
        }
    }

    public static String changeUriToPath(Uri uri) {
        if (DocumentsContract.isDocumentUri(mActivity, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String str = documentId.split(":")[1];
                return getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + str);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return getImagePath(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null);
            } else {
                return null;
            }
        } else if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            return getImagePath(uri, (String) null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
    }

    public static void clearClipboard() {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            } catch (Exception e10) {
                Log.d("clearError:", e10.getMessage());
            }
        }
    }

    public static void clearSession() {
        mActivity.runOnUiThread(new i());
    }

    public static void contact(String str, String str2, String str3) {
        DialogFragment dialogFragment = serviceDlg;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public static void contactQQ(String str, String str2) {
        mActivity.runOnUiThread(new f(str2, str));
    }

    public static void copy(String str) {
        CocosHelper.copyTextToClipboard(str);
    }

    public static void copyHallCfg2WritablePath() {
        mActivity.copyHallCfg2WritablePath();
    }

    public static void destroyBotion() {
        BOCaptchaClient bOCaptchaClient = boCaptchaClient;
        if (bOCaptchaClient != null) {
            bOCaptchaClient.destroy();
        }
    }

    public static void destroyGeetest() {
        GTCaptcha4Client gTCaptcha4Client = gtCaptcha4Client;
        if (gTCaptcha4Client != null) {
            gTCaptcha4Client.destroy();
        }
    }

    public static void exitGame() {
        Log.d(TAG, "exitGame()");
        mActivity.runOnUiThread(new t());
    }

    public static void facebookLogin() {
        mActivity.runOnUiThread(new x());
    }

    public static void facebookLogout() {
        com.facebook.login.i e10 = com.facebook.login.i.e();
        if (e10 != null) {
            e10.p();
        }
    }

    public static void facebookShare(String str) {
        FaceBookShare.doShare(str);
    }

    public static boolean findInt(String str) {
        if (str.replaceAll("[^\\d]", " ").trim().replaceAll(" +", " ").equals("")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static String generateCodeChallenge(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytes = str.getBytes("US-ASCII");
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        if (Build.VERSION.SDK_INT >= 26) {
            return java.util.Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
        }
        return "";
    }

    /* access modifiers changed from: private */
    public static String generateCodeVerifier() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        if (Build.VERSION.SDK_INT >= 26) {
            return java.util.Base64.getUrlEncoder().withoutPadding().encodeToString(bArr);
        }
        return "";
    }

    public static AppActivity getActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", (Class[]) null).invoke((Object) null, (Object[]) null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object next : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = next.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(next)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (AppActivity) ((Activity) declaredField3.get(next));
                }
            }
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        } catch (NoSuchFieldException e14) {
            e14.printStackTrace();
        }
        return null;
    }

    public static int getBottomNotchHeight() {
        return DeviceUtils.getBottomNotchHeight(mActivity);
    }

    public static String getBundleName() {
        return mActivity.getPackageName();
    }

    public static String getClip() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null && clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
                String valueOf = String.valueOf(clipboardManager.getPrimaryClip().getItemAt(0).getText());
                if (!TextUtils.isEmpty(valueOf)) {
                    Log.d("getclip:", valueOf);
                    return valueOf;
                }
            }
            Log.d("getclip:", "clip is null");
            return "";
        } catch (Exception e10) {
            Log.d("getclip:", e10.getMessage());
            return "";
        }
    }

    public static String getCpuInfo() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e10) {
            e10.getStackTrace();
        }
        Log.d("getCpuInfo", str);
        return str;
    }

    public static String getDeviceBrand() {
        return String.format("%s %s", new Object[]{Build.BRAND, Build.MODEL});
    }

    public static String getGateServers() {
        return getInfoValue("serverCfg");
    }

    public static String getGpuInfo() {
        String str;
        try {
            str = Build.SUPPORTED_ABIS[0];
        } catch (Exception e10) {
            e10.getStackTrace();
            str = "";
        }
        Log.d("getGpuInfo", str);
        return str;
    }

    public static String getHallVersion() {
        try {
            return JSON.parseObject(getString(mActivity.getAssets().open("project.manifest"))).getString("version");
        } catch (IOException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getI18nStr(String str) {
        String string;
        try {
            JSONObject jSONObject = mI18nCfgJs;
            if (jSONObject != null) {
                if (jSONObject.getString(str) != null) {
                    return mI18nCfgJs.getString(str);
                }
            }
            String str2 = mLang;
            if (str2 == null) {
                str2 = "en";
            }
            JSONObject jSONObject2 = mI18nCfgDef.getJSONObject(str2);
            if (jSONObject2 == null || (string = jSONObject2.getString(str)) == null) {
                return "";
            }
            return string;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"Range"})
    public static String getImagePath(Uri uri, String str) {
        Cursor query = mActivity.getContentResolver().query(uri, (String[]) null, str, (String[]) null, (String) null);
        String str2 = null;
        if (query != null) {
            if (query.moveToFirst()) {
                str2 = query.getString(query.getColumnIndex("_data"));
            }
            query.close();
        }
        return str2;
    }

    public static String getInfoValue(String str) {
        Object obj = mInfoDic.get(str);
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    public static String getMTPushID() {
        String str;
        if (getInfoValue("isAbroad").equals("1")) {
            str = w1.a.b(mActivity);
        } else {
            str = "";
        }
        Log.d(TAG, "getMTPushID id = " + str);
        return str;
    }

    public static int getMemorySize() {
        return DeviceUtils.getMemorySize(mActivity);
    }

    public static String getNetworkType() {
        updateNetworkInfo();
        return mNetworkType + "#" + mSignalStrengthLevel;
    }

    public static int getOrientation() {
        return orientType;
    }

    public static String getPackageName() {
        try {
            return String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int getRestMemorySize() {
        return DeviceUtils.getRestMemorySize(mActivity);
    }

    public static int getStatusBarState() {
        return statusBarState;
    }

    public static String getString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            inputStreamReader = null;
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer("");
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getTopNotchHeight() {
        return DeviceUtils.getTopNotchHeight(mActivity);
    }

    public static String getUniq() {
        return DeviceUtils.getUniq(mActivity);
    }

    public static String getUniqueDeviceId() {
        return UniqueIdManager.INSTANCE.getUniqueId(mActivity);
    }

    public static String getVersionCode() {
        return getInfoValue("versionCode");
    }

    public static int getWifiSignalLevel() {
        return netDbmToLevel(((WifiManager) mActivity.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getRssi());
    }

    public static String getZlzMetaInfo() {
        return ZolozController.getInstance().getZlzMetaInfo(mActivity);
    }

    public static String getgeeGuardToken(String str, String str2) {
        GeeGuardReceipt fetchReceipt = GeeGuard.fetchReceipt(context, str, str2);
        if (fetchReceipt != null) {
            Log.d("PlatformUtils GeeGuard", "GeeToken: " + fetchReceipt.geeToken);
            return fetchReceipt.geeToken;
        }
        Log.d("PlatformUtils GeeGuard", "GeeToken: receipt is null");
        return "";
    }

    public static void goPhotoAlbum() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            mActivity.startActivityForResult(intent, 1001);
        } catch (Exception e10) {
            e10.getStackTrace();
        }
    }

    public static void googleLogin(String str) {
        Log.d(TAG, "googleLogin: " + str);
        GoogleSignInClient client = GoogleSignIn.getClient((Activity) mActivity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(str).requestEmail().build());
        mGoogleSignInClient = client;
        mActivity.startActivityForResult(client.getSignInIntent(), GOOGLE_LOGIN_IN);
    }

    public static void googleLogout() {
        GoogleSignInClient googleSignInClient = mGoogleSignInClient;
        if (googleSignInClient != null) {
            googleSignInClient.signOut();
        }
    }

    public static void handleGoogleSignInResult(@Nullable Task<GoogleSignInAccount> task) {
        Log.d(TAG, "handleGoogleSignInResult:" + task.isSuccessful());
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            String email = result.getEmail();
            String idToken = result.getIdToken();
            callJSMethod(String.format("window['G']?.PlatformUtils?.onGoogleLoginResult({id_token:\"%s\",email:\"%s\"});", new Object[]{idToken, email}));
            if (isRn() && ThirdLoginModule.getInstance() != null) {
                ThirdLoginModule.getInstance().googleLoginResult(idToken, email);
            }
        } catch (ApiException e10) {
            Log.w(TAG, "handleGoogleSignInResult:error", e10);
        }
    }

    public static String handleImageBeforeKitkat(Intent intent) {
        return getImagePath(intent.getData(), (String) null);
    }

    public static String handleImageOnKitkat(Intent intent) {
        return changeUriToPath(intent.getData());
    }

    private static void handleLineSignInResult(Intent intent) {
        LineLoginResult d10 = com.linecorp.linesdk.auth.a.d(intent);
        int i10 = t.f1434a[d10.g().ordinal()];
        if (i10 == 1) {
            String f10 = d10.f().f();
            callJSMethod(String.format("window['G']?.PlatformUtils?.onLineLoginResult({id_token:\"%s\"});", new Object[]{f10}));
            if (isRn() && ThirdLoginModule.getInstance() != null) {
                ThirdLoginModule.getInstance().lineLoginResult(f10);
            }
        } else if (i10 != 2) {
            Log.e("ERROR", "Login FAILED!");
            Log.e("ERROR", d10.e().toString());
        } else {
            Log.e("ERROR", "LINE Login Canceled by user.");
        }
    }

    public static boolean hasNotch() {
        return DeviceUtils.hasNotchInScreen(mActivity);
    }

    public static void init() {
        bDidJSInit = Boolean.TRUE;
    }

    public static void initImmersionBar() {
        e9.h.e0(mActivity).C();
        e9.h.e0(mActivity).B(e9.b.FLAG_HIDE_NAVIGATION_BAR).C();
    }

    public static void initLiveChat(String str, String str2) {
        mActivity.runOnUiThread(new g(str, str2));
    }

    public static void initLoginUser(String str, String str2) {
        WgProxyController.getInstance().initLoginUser(wrapUserInfo(context, str, str2, true));
    }

    private static void initSDK(String str) {
        try {
            Class.forName(str).getMethod("init", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            Log.d(TAG, "not exist " + str);
        }
    }

    public static void initZlz(String str, String str2, String str3) {
        ZolozController.getInstance().initZlz(mActivity, str, str2, str3);
    }

    public static boolean isAliPayInstalled() {
        Log.d(TAG, "isAliPayInstalled()");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("alipayqr://platformapi/startapp"));
        intent.setFlags(268468224);
        if (intent.resolveActivity(mActivity.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    public static int isPreloadRnEnd() {
        Log.d(TAG, "isPreloadRnEnd: " + isPreloadRnEnd);
        return isPreloadRnEnd;
    }

    public static boolean isRn() {
        return "1".equals(getInfoValue("isrn"));
    }

    /* access modifiers changed from: private */
    public static String[] jsonArrayToStringArray(JSONObject jSONObject, String str) {
        if (!jSONObject.containsKey(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        String[] strArr = new String[jSONArray.size()];
        for (int i10 = 0; i10 < jSONArray.size(); i10++) {
            strArr[i10] = jSONArray.getString(i10);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$exitGame$1(DialogInterface dialogInterface, int i10) {
        mActivity.finish();
        System.exit(0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$exitGame$2(DialogInterface dialogInterface, int i10) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$exitGame$3() {
        if (!isRn() || !RNDelegateManager.getInstance().isVisible()) {
            new AlertDialog.Builder(mActivity).setTitle(getI18nStr("quit_game_title")).setMessage(getI18nStr("quit_game_content")).setPositiveButton(getI18nStr("quit_game_ok"), new n()).setNeutralButton(getI18nStr("quit_game_cancel"), new o()).show();
        } else {
            RNDelegateManager.getInstance().getReactDelegate().l();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$selectLang$4() {
        Log.d(TAG, "selectLang: RNDelegateManager init");
        RNDelegateManager.getInstance().init(mActivity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startHCaptcha$6(Callback callback, boolean z10, String str) {
        String str2;
        Log.d(TAG, "startHCaptcha：" + z10 + " " + str);
        if (callback == null) {
            if (z10) {
                str2 = String.format("window['G']?.PlatformUtils?.hCaptchaSuccess(\"%s\");", new Object[]{str});
            } else {
                str2 = String.format("window['G']?.PlatformUtils?.hCaptchaFail();", new Object[0]);
            }
            callJSMethod(str2);
            return;
        }
        try {
            callback.invoke(Boolean.valueOf(z10), str);
        } catch (Exception unused) {
            Log.d(TAG, "startHCaptcha：Exception");
        }
    }

    public static void lineLogin(String str) {
        mActivity.runOnUiThread(new y(str));
    }

    public static void loadDefI18nCfg() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open("i18nKey.json"), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    mI18nCfgDef = JSON.parseObject(sb2.toString());
                    return;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void loadGif(String str) {
        Glide.with(context).asGif().load(str).listener(new r()).submit();
    }

    private static void loadSDK() {
        initSDK("org.cocos2dx.javascript.sdk.AdjustSDK");
        initSDK("org.cocos2dx.javascript.sdk.OneSignalSDK");
        initSDK("org.cocos2dx.javascript.sdk.AppsFlyerSDK");
    }

    public static void logException(String str, String str2, String str3, String str4) {
        Exception exc = new Exception(str2);
        exc.setStackTrace(new StackTraceElement[]{new StackTraceElement("", str3, str, 0)});
        com.bugsnag.android.r.c(exc, new s(str2, str4));
    }

    public static int netDbmToLevel(int i10) {
        if (i10 < -85) {
            return 1;
        }
        if (i10 < -70) {
            return 2;
        }
        return i10 < -55 ? 3 : 4;
    }

    public static void onActivityResult(int i10, int i11, Intent intent) {
        ZaloSDK.Instance.onActivityResult(mActivity, i10, i11, intent);
        if (i10 == 1 && intent != null) {
            String stringExtra = intent.getStringExtra(DbParams.KEY_CHANNEL_RESULT);
            Log.d("GameResult:", "Code:" + stringExtra);
            callJSMethod(String.format("window['G']?.PlatformUtils?.onExitThirdGame();", new Object[0]));
        } else if (i10 == GOOGLE_LOGIN_IN) {
            handleGoogleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(intent));
        } else if (i10 == LINE_LOGIN_CODE) {
            handleLineSignInResult(intent);
        } else {
            com.facebook.g gVar = fbCallbackManager;
            if (gVar != null) {
                gVar.a(i10, i11, intent);
            }
            if (i10 == 1001) {
                Log.i("pickImg ", "调用相册回调");
                if (intent != null) {
                    try {
                        callJSMethod(String.format("window['G']?.PlatformUtils?.onPickedImage(\"%s\");", new Object[]{handleImageOnKitkat(intent)}));
                    } catch (Exception e10) {
                        e10.getStackTrace();
                    }
                }
            }
        }
    }

    public static void onCreate(AppActivity appActivity) {
        mActivity = appActivity;
        isPreloadRnEnd = 0;
        mNetworkChangedReceiver = new NetworkChangedReceiver();
        u uVar = new u(mActivity);
        orientListener = uVar;
        if (uVar.canDetectOrientation()) {
            Log.d(TAG, "Can detect orientation");
            orientListener.enable();
        } else {
            Log.d(TAG, "Cannot detect orientation");
            orientListener.disable();
        }
        com.facebook.o.G(mActivity.getApplicationContext());
        context = appActivity.getApplicationContext();
        loadDefI18nCfg();
        LoginImage.CopyLoginImageToWritablePath();
        LoginImage.CopyDataFileToWritablePath();
        initImmersionBar();
        addOnSoftKeyBoardVisibleListener();
        loadSDK();
        if (getInfoValue("oneSignal").isEmpty()) {
            CheckPostNotificationsPermission();
        }
        CheckSysSettingPermission();
        if (isRn()) {
            JsbBridgeWrapper.getInstance().addScriptEventListener("openrn", new m());
        }
    }

    public static void onDestroy() {
        OrientationEventListener orientationEventListener = orientListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        AppActivity appActivity = mActivity;
        if (appActivity != null) {
            appActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void onNetworkChanged() {
        int i10;
        if (mNetworkType.equals("WIFI")) {
            i10 = mWifiStrengthLevel;
        } else {
            i10 = mSignalStrengthLevel;
        }
        callJSMethod(String.format("window['G']?.PlatformUtils?.onNetworkChanged(\"%s\",%d);", new Object[]{mNetworkType, Integer.valueOf(Math.max(0, Math.min(4, i10)))}));
        Log.d(TAG, "当前为" + mNetworkType + ",信号强度为" + i10);
    }

    public static void onPause() {
        IAction iAction = sdkPause;
        if (iAction != null) {
            iAction.invoke();
        }
    }

    public static void onPickedImage(String str, String str2) {
        callJSMethod(String.format("window['G']?.PlatformUtils?.onPickedImage(\"%s\",\"%s\");", new Object[]{str, str2}));
    }

    public static void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 301) {
            Log.d("GPS", "设置权限回来");
        } else if (i10 == 1001) {
            try {
                int indexOf = Arrays.asList(strArr).indexOf("android.permission.READ_MEDIA_IMAGES");
                if (indexOf != -1 && iArr[indexOf] != -1) {
                    goPhotoAlbum();
                }
            } catch (Exception e10) {
                Log.e(TAG, "onRequestPermissionsResult: " + e10);
            }
        }
    }

    public static void onResume() {
        IAction iAction = sdkResume;
        if (iAction != null) {
            iAction.invoke();
        }
    }

    public static void onRotate(int i10) {
        Log.d(TAG, "旋转屏幕1");
        callJSMethod(String.format("if (window['G'] && window['G']?.PlatformUtils && window['G']?.PlatformUtils?.onRotate) { window['G']?.PlatformUtils?.onRotate(%d);}", new Object[]{Integer.valueOf(i10)}));
        Log.d(TAG, "旋转屏幕2");
    }

    public static void onWindowFocusChanged(boolean z10) {
        changeStatusBarUI();
    }

    public static void openAPP(String str, String str2, String str3) {
        String str4;
        if (str.equals("1")) {
            contactQQ(str2, str3);
        } else if (str.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
            wxOpen(str3);
        } else {
            if (str.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                if (str2.length() > 0) {
                    str4 = str3 + str2;
                } else {
                    whatsAppOpen(str3);
                    return;
                }
            } else if (str.equals("4")) {
                str4 = str3 + str2;
            } else if (str.equals("5")) {
                str4 = str3 + str2;
            } else {
                str4 = "";
            }
            if (!str.equals("-1")) {
                str3 = str4;
            }
            mActivity.runOnUiThread(new q(str3));
        }
    }

    public static void openCloudflareBehavior(String str) {
        GlobalObject.runOnUiThread(new u(str));
    }

    private static void openSetting(int i10, String str) {
        mActivity.runOnUiThread(new m(str, i10));
    }

    public static void openWebGame(String str) {
        int i10;
        String str2;
        JSONObject parseObject = JSON.parseObject(str);
        String string = parseObject.getString(ImagesContract.URL);
        int intValue = parseObject.getInteger("gameScreenType").intValue();
        String string2 = parseObject.getString("tip");
        int intValue2 = parseObject.getInteger("showTipTime").intValue();
        if (parseObject.containsKey("retryDealyTime")) {
            i10 = parseObject.getInteger("retryDealyTime").intValue();
        } else {
            i10 = 15;
        }
        String string3 = parseObject.getString("isHtmlWay");
        String string4 = parseObject.getString("hallReturnType");
        String string5 = parseObject.getString("webUrl");
        String str3 = "hideTime";
        int intValue3 = parseObject.getInteger("hideTime").intValue();
        String str4 = "isHtmlWay";
        String string6 = parseObject.getString("isGameSecondaryPop");
        String str5 = "isGameSecondaryPop";
        StringBuilder sb2 = new StringBuilder();
        String str6 = "webUrl";
        sb2.append("url:");
        sb2.append(string);
        sb2.append(" gameScreenType: ");
        sb2.append(intValue);
        Log.d("openWebGame url:", sb2.toString());
        Log.d("openWebGame :", "showTipTime:" + intValue2 + " tip: " + string2 + ", isHtmlWay: " + string3 + ", isGameSecondaryPop: " + string6);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("retryDealyTime:");
        sb3.append(i10);
        Log.d("retryDealyTime :", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("hideTime:");
        sb4.append(intValue3);
        Log.d("hideTime :", sb4.toString());
        if (string != "") {
            if (intValue == 1) {
                str2 = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            } else {
                str2 = "H";
            }
            setOrientation(str2);
            Intent intent = new Intent(mActivity, WebGameActivity.class);
            intent.putExtra("retryTitle", getI18nStr("retry_title"));
            intent.putExtra("retryBtnSureText", getI18nStr("retry_btn_sure_text"));
            intent.putExtra("netErrorContentText", getI18nStr("net_error_content_text"));
            intent.putExtra(ImagesContract.URL, string);
            intent.putExtra("tip_title", getI18nStr("tip_title"));
            intent.putExtra("back_home_tip", getI18nStr("back_home_tip"));
            intent.putExtra("back_home", getI18nStr("back_home"));
            intent.putExtra("continue_game", getI18nStr("continue_game"));
            intent.putExtra("exit", getI18nStr("exit"));
            intent.putExtra("screen_type", Integer.toString(intValue));
            intent.putExtra("showTipTime", Integer.toString(intValue2));
            intent.putExtra("retryDealyTime", Integer.toString(i10));
            intent.putExtra("tip", string2);
            intent.putExtra("homePage", getI18nStr("home_page"));
            intent.putExtra("hallreturntype", string4);
            intent.putExtra(str6, string5);
            intent.putExtra(str5, string6);
            intent.putExtra(str4, string3);
            String str7 = str3;
            intent.putExtra(str7, Integer.toString(intValue3));
            intent.putExtra("isRtl", "ar".equals(mLang));
            if (hasNotch()) {
                Log.d(TAG, "hasNotch");
                intent.putExtra("has_notch", "1");
            } else {
                Log.d(TAG, "no Notch");
                intent.putExtra("has_notch", "0");
            }
            mActivity.startActivityForResult(intent, 1);
        }
    }

    public static void passkeyRegister(String str, String str2, String str3, String str4) {
        PasskeyManager.INSTANCE.register(str, str2, str3, str4);
    }

    public static void passkeySignIn(String str, String str2, String str3) {
        PasskeyManager.INSTANCE.signIn(str, str2);
    }

    public static void pickImage() {
        Log.d(TAG, "pickImage()");
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        String[] strArr2 = {"android.permission.READ_MEDIA_IMAGES", "android.permission.CAMERA"};
        try {
            int i10 = 0;
            if (Build.VERSION.SDK_INT > 32) {
                boolean z10 = false;
                while (i10 < 2) {
                    String str = strArr2[i10];
                    boolean equals = str.equals("android.permission.READ_MEDIA_IMAGES");
                    if (mActivity.checkSelfPermission(str) != 0) {
                        boolean shouldShowRequestPermissionRationale = mActivity.shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_IMAGES");
                        if (!equals || !shouldShowRequestPermissionRationale) {
                            mActivity.requestPermissions(strArr2, 1001);
                            return;
                        } else {
                            openSetting(1001, getI18nStr("read_img_tip"));
                            return;
                        }
                    } else {
                        if (equals) {
                            z10 = true;
                        }
                        i10++;
                    }
                }
                if (z10) {
                    goPhotoAlbum();
                    return;
                }
                return;
            }
            if (mActivity.checkSelfPermission(strArr[0]) != 0) {
                if (mActivity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    openSetting(1001, getI18nStr("read_img_tip"));
                } else {
                    mActivity.requestPermissions(strArr, 1001);
                }
            }
            goPhotoAlbum();
        } catch (Exception e10) {
            e10.getStackTrace();
        }
    }

    public static void preLoadDomains(String str) {
        AliProxyController.getInstance().preLoadDomains(str);
    }

    public static void preloadRnEnd() {
        Log.d(TAG, "preloadRnEnd");
        isPreloadRnEnd++;
    }

    public static void qqOpen() {
        Log.d(TAG, "qqOpen()");
        mActivity.runOnUiThread(new j());
    }

    public static void removeSplashView() {
        mActivity.runOnUiThread(new a());
    }

    public static void saveImageToAlbum(String str) {
        Log.d(TAG, "saveImageToAlbum:" + str);
        if (Build.VERSION.SDK_INT <= 29 && mActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
            if (mActivity.checkSelfPermission(strArr[0]) != 0) {
                if (mActivity.shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    openSetting(102, getI18nStr("save_img_tip"));
                    return;
                } else {
                    mActivity.requestPermissions(strArr, 102);
                    return;
                }
            }
        }
        mActivity.runOnUiThread(new b(str));
    }

    public static void selectLang(String str, String str2) {
        boolean z10;
        mLang = str;
        mI18nCfgJs = JSON.parseObject(str2);
        if (isRn()) {
            com.facebook.react.modules.i18nmanager.a f10 = com.facebook.react.modules.i18nmanager.a.f();
            if (mI18nCfgJs.containsKey("isUserAcion") && mI18nCfgJs.getBoolean("isUserAcion").booleanValue()) {
                if (!mI18nCfgJs.containsKey("isRTL") || !mI18nCfgJs.getBoolean("isRTL").booleanValue()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                Log.d(TAG, "isRTL " + z10);
                AppActivity appActivity = mActivity;
                if (appActivity.isRTL != z10) {
                    appActivity.isRTL = z10;
                    f10.e(appActivity, z10);
                    f10.b(mActivity, z10);
                    GlobalObject.runOnUiThread(new s());
                    return;
                }
                Log.d(TAG, "selectLang: RNDelegateManager not init");
            }
        }
    }

    public static void sendEmail(String str, String str2, String str3) {
        mActivity.runOnUiThread(new w(str, str3, str2));
    }

    public static void serviceChat() {
        mActivity.runOnUiThread(new h());
    }

    /* access modifiers changed from: private */
    public static void setEventCustomData(o1 o1Var, String str) {
        o1Var.b("CustomMetadata", "siteCode", getInfoValue("siteCode"));
        if (str != null && !str.equals("")) {
            String[] split = str.split(",");
            if (split.length >= 1) {
                for (String split2 : split) {
                    String[] split3 = split2.split(":");
                    if (split3.length >= 2) {
                        o1Var.b("CustomMetadata", split3[0].replace("\"", ""), split3[1].replace("\"", ""));
                    }
                }
            }
        }
    }

    public static void setFrontDomains(String str) {
        JSONArray parseArray = JSON.parseArray(str);
        List<String> list = mahDomains;
        if (list == null) {
            mahDomains = new ArrayList();
        } else {
            list.clear();
        }
        for (int i10 = 0; i10 < parseArray.size(); i10++) {
            mahDomains.add(parseArray.getString(i10));
        }
    }

    public static void setOrientation(String str) {
        if (str.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            mActivity.setRequestedOrientation(1);
        } else {
            mActivity.setRequestedOrientation(6);
        }
    }

    public static void startBotion(String str, String str2, String str3) {
        startBotion(str, str2, str3, (Callback) null);
    }

    public static void startGeetest(String str, String str2) {
        startGeetest(str, str2, (Callback) null);
    }

    public static void startHCaptcha(String str, String str2) {
        startHCaptcha(str, str2, (Callback) null);
    }

    public static void startListenNetwork() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
        mActivity.registerReceiver(mNetworkChangedReceiver, intentFilter);
    }

    public static void stopListenNetwork() {
        mActivity.unregisterReceiver(mNetworkChangedReceiver);
    }

    public static void sysShare(String str) {
        Log.d(TAG, "share: " + str);
        mActivity.runOnUiThread(new e(str));
    }

    public static void unzipSubGames() {
        try {
            List asList = Arrays.asList(mActivity.getAssets().list("subGames"));
            mActivity.gameFileList = new ArrayList<>(asList);
            mActivity.finishedGameList = new ArrayList<>();
            mActivity.copySubGame();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void updateNetworkInfo() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) mActivity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            mNetworkType = "NONE";
            mSignalStrengthLevel = 0;
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            mNetworkType = "4G";
            mSignalStrengthLevel = 4;
        } else if (type == 1) {
            mNetworkType = "WIFI";
            mWifiStrengthLevel = getWifiSignalLevel();
        }
    }

    public static void whatsAppOpen(String str) {
        Log.d(TAG, "whatsAppOpen()");
        mActivity.getPackageManager();
        try {
            if (findInt(str)) {
                mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "#");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.setPackage("com.whatsapp");
            mActivity.startActivity(intent);
        } catch (NullPointerException unused) {
        }
    }

    public static String wrapUserInfo(Context context2, String str, String str2, boolean z10) {
        String infoValue = getInfoValue("siteCode");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", (Object) "Android");
        jSONObject.put("os_version", (Object) Build.VERSION.SDK_INT + "");
        jSONObject.put(Constant.PARAM_APP_ID, (Object) DeviceUtils.getUniq(context2));
        jSONObject.put("app_name", (Object) com.blankj.utilcode.util.c.a());
        jSONObject.put("url_host", (Object) "");
        jSONObject.put("app_version", (Object) com.blankj.utilcode.util.c.c());
        jSONObject.put("userid", (Object) str);
        jSONObject.put("user_name", (Object) str2);
        jSONObject.put("site_code", (Object) infoValue);
        jSONObject.put("is_login", (Object) Boolean.valueOf(z10));
        return jSONObject.toString();
    }

    public static void wxOpen(String str) {
        Log.d(TAG, "wxOpen()");
        mActivity.runOnUiThread(new c(str));
    }

    public static void zaloLogin(String str) {
        mActivity.runOnUiThread(new z());
    }

    public static void zaloLogout() {
        ZaloSDK.Instance.unauthenticate();
    }

    public static void initZlz(String str, String str2, String str3, Callback callback) {
        ZolozController.getInstance().initZlz(mActivity, str, str2, str3, callback);
    }

    public static void startBotion(String str, String str2, String str3, Callback callback) {
        Log.d(TAG, "startBotion: " + str2);
        mActivity.runOnUiThread(new o(str3, str2, str, callback));
    }

    public static void startGeetest(String str, String str2, Callback callback) {
        Log.d(TAG, "startGeetest: " + str2);
        AppActivity activity = getActivity();
        activity.runOnUiThread(new n(str2, activity, str, callback));
    }

    public static void startHCaptcha(String str, String str2, Callback callback) {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new p(str, str2, callback));
    }
}
