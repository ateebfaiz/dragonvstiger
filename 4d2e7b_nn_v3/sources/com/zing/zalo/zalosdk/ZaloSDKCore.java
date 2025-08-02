package com.zing.zalo.zalosdk;

import android.app.Application;
import com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage;
import com.zing.zalo.devicetrackingsdk.DeviceTracking;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.core.servicemap.ServiceMapManager;

public class ZaloSDKCore {
    public static void enableWriteLogFile(boolean z10) {
        Log.LOG_WRITABLE = Boolean.valueOf(z10);
    }

    public static void init(Application application) {
        ZaloSDKContext.init(application);
        initServices(application);
    }

    private static void initServices(final Application application) {
        ServiceMapManager.getInstance().load(application);
        String appId = AppInfo.getAppId(application);
        BaseAppInfoStorage baseAppInfoStorage = new BaseAppInfoStorage(application);
        DeviceTracking instance = DeviceTracking.getInstance();
        instance.initDeviceTracking(application, baseAppInfoStorage, appId);
        instance.getDeviceId(new DeviceTracking.GetInfoListener() {
            public void onGetDeviceIdComplete(String str) {
                SettingsManager.getInstance().init(application, str);
            }
        });
    }
}
