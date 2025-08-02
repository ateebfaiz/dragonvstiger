package org.cocos2dx.javascript;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangedReceiver extends BroadcastReceiver {
    static final String TAG = "PlatformUtils";

    public void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.RSSI_CHANGED".equals(intent.getAction())) {
            int wifiSignalLevel = PlatformUtils.getWifiSignalLevel();
            if (wifiSignalLevel != PlatformUtils.mWifiStrengthLevel) {
                PlatformUtils.mWifiStrengthLevel = wifiSignalLevel;
                if (PlatformUtils.mNetworkType == "WIFI") {
                    PlatformUtils.onNetworkChanged();
                    return;
                }
                return;
            }
            return;
        }
        PlatformUtils.updateNetworkInfo();
        PlatformUtils.onNetworkChanged();
    }
}
