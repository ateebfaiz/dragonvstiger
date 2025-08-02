package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.zing.zalo.zalosdk.core.http.HttpClientFactory;
import com.zing.zalo.zalosdk.core.log.Log;
import java.util.List;

public class AppTracker {
    private String appId;
    private Context context;
    private DeviceTracking deviceTracker;
    long expiredTime;
    private Handler handler;
    List<String> installedPackagedNames;
    private Listener listener;
    HttpClientFactory mHttpClientFactory = new HttpClientFactory();
    List<String> packageNames;
    String scanId;
    private BaseAppInfoStorage storage;
    int submitRetry = 0;
    private HandlerThread thread;
    private boolean waitDeviceIdToSubmitInstallApps = false;

    public interface Listener {
        void onAppTrackerCompleted(boolean z10, long j10, String str, List<String> list, List<String> list2);
    }

    public AppTracker(Context context2, BaseAppInfoStorage baseAppInfoStorage, String str, DeviceTracking deviceTracking) {
        this.storage = baseAppInfoStorage;
        this.context = context2.getApplicationContext();
        this.deviceTracker = deviceTracking;
        this.appId = str;
        Log.d("AppTracker", "AppTracker has been disable");
    }

    private void cleanUp() {
        boolean z10;
        HandlerThread handlerThread = this.thread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.thread = null;
            this.handler = null;
            Listener listener2 = this.listener;
            if (listener2 != null) {
                List<String> list = this.installedPackagedNames;
                if (list != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                listener2.onAppTrackerCompleted(z10, this.expiredTime, this.scanId, this.packageNames, list);
            }
        }
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
