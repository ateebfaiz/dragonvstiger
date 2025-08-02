package com.zing.zalo.zalosdk.oauth;

import android.app.Application;
import android.content.Context;
import com.zing.zalo.devicetrackingsdk.AppTracker;
import com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage;
import com.zing.zalo.devicetrackingsdk.DeviceTracking;
import com.zing.zalo.zalosdk.ZaloSDKCore;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.Utils;

public class ZaloSDKApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f11862a = 0;
    protected static String appID = null;
    /* access modifiers changed from: private */
    public static AppTracker.Listener atListener = null;
    protected static String facebookAppID = "";

    private static void init(Application application) {
        appID = AppInfo.getAppId(application);
        facebookAppID = AppInfo.getFacebookAppId(application);
        ZaloSDKCore.init(application);
        initServices(application);
        Utils.initZingAnalytics(application, appID);
        ZaloSDK.Instance.initialize(application);
    }

    private static void initServices(final Context context) {
        final BaseAppInfoStorage baseAppInfoStorage = new BaseAppInfoStorage(context);
        final DeviceTracking instance = DeviceTracking.getInstance();
        instance.initDeviceTracking(context, baseAppInfoStorage, appID);
        instance.getDeviceId(new DeviceTracking.GetInfoListener() {
            public void onGetDeviceIdComplete(String str) {
                new AppTracker(context, baseAppInfoStorage, ZaloSDKApplication.appID, instance).setListener(ZaloSDKApplication.atListener);
                AppTracker.Listener unused = ZaloSDKApplication.atListener = null;
            }
        });
    }

    public static void setAppTrackerListener(AppTracker.Listener listener) {
        atListener = listener;
    }

    public static void wrap(Application application) {
        init(application);
    }

    public void onCreate() {
        super.onCreate();
        init(this);
    }
}
