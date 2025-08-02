package org.cocos2dx.javascript;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.webkit.WebView;
import com.bugsnag.android.r;
import com.cocos.sdk.AliProxyController;
import com.cocos.sdk.MahProxyController;
import com.facebook.react.defaults.b;
import com.facebook.react.k;
import com.facebook.react.k0;
import com.facebook.react.m0;
import com.facebook.react.u;
import com.facebook.react.x;
import com.facebook.soloader.SoLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zing.zalo.zalosdk.oauth.ZaloSDKApplication;
import java.util.List;
import org.cocos2dx.javascript.connection.ConnectionCreator;
import org.cocos2dx.javascript.rn.RNPackage;

public class GameApplication extends Application implements u {
    List<m0> mReactPackages;

    class a extends b {
        a(Application application) {
            super(application);
        }

        /* access modifiers changed from: protected */
        public boolean A() {
            return false;
        }

        /* access modifiers changed from: protected */
        public String h() {
            return com.microsoft.codepush.react.a.j();
        }

        /* access modifiers changed from: protected */
        public String k() {
            return FirebaseAnalytics.Param.INDEX;
        }

        /* access modifiers changed from: protected */
        public List n() {
            GameApplication gameApplication = GameApplication.this;
            if (gameApplication.mReactPackages == null) {
                gameApplication.mReactPackages = new k(this).c();
                GameApplication.this.mReactPackages.add(new RNPackage());
            }
            return GameApplication.this.mReactPackages;
        }

        public boolean v() {
            return false;
        }

        /* access modifiers changed from: protected */
        public Boolean z() {
            return Boolean.TRUE;
        }
    }

    public x getReactHost() {
        return com.facebook.react.defaults.a.a(getApplicationContext(), getReactNativeHost());
    }

    public k0 getReactNativeHost() {
        return new a(this);
    }

    public String getSystemMeta(String str) {
        try {
            Object obj = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return String.valueOf(obj);
            }
            return "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x019e A[Catch:{ Exception -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x01aa A[Catch:{ Exception -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01bc A[Catch:{ Exception -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01c6 A[Catch:{ Exception -> 0x0189 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initSDKParams() {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "isAbroad"
            java.lang.String r2 = "configData"
            java.lang.String r3 = "isPlayPkg"
            java.lang.String r4 = "skinRtl"
            java.lang.String r5 = "rnver"
            java.lang.String r6 = "isrn"
            java.lang.String r7 = "isSpeedPack"
            java.lang.String r8 = "loginImage"
            java.lang.String r9 = "backgroundColor"
            java.lang.String r10 = "skinTypeValue"
            java.lang.String r11 = "skinType"
            java.lang.String r12 = "cid"
            java.lang.String r13 = "language"
            java.lang.String r14 = "siteCode"
            java.lang.String r15 = "bucketServers"
            r16 = r0
            java.lang.String r0 = "serverCfg"
            r17 = r2
            java.lang.String r2 = "versionCode"
            r18 = r3
            java.lang.String r3 = "tiktokBaseCode"
            r19 = r3
            java.lang.String r3 = "kwaiPixelBaseCode"
            r20 = r3
            java.lang.String r3 = "pixelId"
            r21 = r3
            java.util.HashMap r3 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r22 = r4
            java.lang.String r4 = r1.getSystemMeta(r2)     // Catch:{ Exception -> 0x0189 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r2 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r3 = r1.getSystemMeta(r0)     // Catch:{ Exception -> 0x0189 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r15)     // Catch:{ Exception -> 0x0189 }
            r0.put(r15, r2)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r0 = r1.getSystemMeta(r14)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r2 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r3 = 1
            java.lang.String r0 = r0.substring(r3)     // Catch:{ Exception -> 0x0189 }
            r2.put(r14, r0)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r13)     // Catch:{ Exception -> 0x0189 }
            r0.put(r13, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r12)     // Catch:{ Exception -> 0x0189 }
            r0.put(r12, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r11)     // Catch:{ Exception -> 0x0189 }
            r0.put(r11, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r10)     // Catch:{ Exception -> 0x0189 }
            r0.put(r10, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r9)     // Catch:{ Exception -> 0x0189 }
            r0.put(r9, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r8)     // Catch:{ Exception -> 0x0189 }
            r0.put(r8, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r7)     // Catch:{ Exception -> 0x0189 }
            r0.put(r7, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r6)     // Catch:{ Exception -> 0x0189 }
            r0.put(r6, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r1.getSystemMeta(r5)     // Catch:{ Exception -> 0x0189 }
            r0.put(r5, r2)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2 = r22
            java.lang.String r4 = r1.getSystemMeta(r2)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2 = r18
            java.lang.String r4 = r1.getSystemMeta(r2)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2 = r17
            java.lang.String r4 = r1.getSystemMeta(r2)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2 = r16
            java.lang.String r4 = r1.getSystemMeta(r2)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "mobilesdk_app_id"
            java.lang.String r4 = "mobilesdk_app_id"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "appsFlyerKey"
            java.lang.String r4 = "appsFlyerKey"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "adjustToken"
            java.lang.String r4 = "adjustToken"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "adjustEventCode"
            java.lang.String r4 = "adjustEventCode"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "facebook_client_token"
            java.lang.String r4 = "facebook_client_token"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "oneSignal"
            java.lang.String r4 = "oneSignal"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "adjustId"
            java.lang.String r4 = "adjustId"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "appsFlyerAuth"
            java.lang.String r4 = "appsFlyerAuth"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "adjustLogType"
            java.lang.String r4 = "adjustLogType"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "appsFlyerLogType"
            java.lang.String r4 = "appsFlyerLogType"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "fbToken"
            java.lang.String r4 = "fbToken"
            java.lang.String r4 = r1.getSystemMeta(r4)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r4)     // Catch:{ Exception -> 0x0189 }
            r0 = r21
            java.lang.String r2 = r1.getSystemMeta(r0)     // Catch:{ Exception -> 0x0189 }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x018c
            int r5 = r2.length()     // Catch:{ Exception -> 0x0189 }
            if (r5 <= r3) goto L_0x018c
            java.util.HashMap r5 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r2.substring(r3)     // Catch:{ Exception -> 0x0189 }
            r5.put(r0, r2)     // Catch:{ Exception -> 0x0189 }
        L_0x0186:
            r0 = r20
            goto L_0x0192
        L_0x0189:
            r0 = move-exception
            goto L_0x0200
        L_0x018c:
            java.util.HashMap r2 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0186
        L_0x0192:
            java.lang.String r2 = r1.getSystemMeta(r0)     // Catch:{ Exception -> 0x0189 }
            if (r2 == 0) goto L_0x01aa
            int r5 = r2.length()     // Catch:{ Exception -> 0x0189 }
            if (r5 <= r3) goto L_0x01aa
            java.util.HashMap r5 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r2.substring(r3)     // Catch:{ Exception -> 0x0189 }
            r5.put(r0, r2)     // Catch:{ Exception -> 0x0189 }
        L_0x01a7:
            r0 = r19
            goto L_0x01b0
        L_0x01aa:
            java.util.HashMap r2 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0189 }
            goto L_0x01a7
        L_0x01b0:
            java.lang.String r2 = r1.getSystemMeta(r0)     // Catch:{ Exception -> 0x0189 }
            if (r2 == 0) goto L_0x01c6
            int r5 = r2.length()     // Catch:{ Exception -> 0x0189 }
            if (r5 <= r3) goto L_0x01c6
            java.util.HashMap r4 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = r2.substring(r3)     // Catch:{ Exception -> 0x0189 }
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0189 }
            goto L_0x01cb
        L_0x01c6:
            java.util.HashMap r2 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x0189 }
        L_0x01cb:
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "clubId"
            java.lang.String r3 = "clubId"
            java.lang.String r3 = r1.getSystemMeta(r3)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "isdns"
            java.lang.String r3 = "isdns"
            java.lang.String r3 = r1.getSystemMeta(r3)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "evntype"
            java.lang.String r3 = "evntype"
            java.lang.String r3 = r1.getSystemMeta(r3)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0189 }
            java.util.HashMap r0 = org.cocos2dx.javascript.PlatformUtils.mInfoDic     // Catch:{ Exception -> 0x0189 }
            java.lang.String r2 = "useMah"
            java.lang.String r3 = "useMah"
            java.lang.String r3 = r1.getSystemMeta(r3)     // Catch:{ Exception -> 0x0189 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0189 }
            goto L_0x0203
        L_0x0200:
            r0.printStackTrace()
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.GameApplication.initSDKParams():void");
    }

    public boolean isMainProcess() {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return getApplicationInfo().packageName.equals(next.processName);
            }
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        initSDKParams();
        if (isMainProcess()) {
            SoLoader.m(this, false);
        } else if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix("webH5");
        }
        String infoValue = PlatformUtils.getInfoValue("isAbroad");
        Log.i("PushInit", infoValue);
        if (infoValue.equals("1")) {
            Log.i("PushInit", "MTPush");
            w1.a.a(this, false);
            z1.a.a(this);
            p1.a.B("US");
        }
        boolean initProxy = AliProxyController.getInstance().initProxy(getSystemMeta("isdns"), getSystemMeta("evntype"), PlatformUtils.getInfoValue("siteCode"), this);
        ConnectionCreator.getInstance().setUseDnsSdk(initProxy);
        if (initProxy) {
            PlatformUtils.mInfoDic.put("useDnsSdk", "1");
        }
        if ("1".equals(getSystemMeta("useMah"))) {
            MahProxyController.getInstance().startSdk(this);
        }
        ZaloSDKApplication.wrap(this);
        r.d(this);
    }
}
