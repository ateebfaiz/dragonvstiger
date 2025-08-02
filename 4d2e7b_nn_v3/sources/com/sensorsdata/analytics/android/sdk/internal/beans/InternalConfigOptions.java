package com.sensorsdata.analytics.android.sdk.internal.beans;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation;
import com.sensorsdata.analytics.android.sdk.SensorsDataTrackEventCallBack;

public class InternalConfigOptions {
    public Context context;
    public String cookie;
    public SensorsDataAPI.DebugMode debugMode = SensorsDataAPI.DebugMode.DEBUG_OFF;
    public SensorsDataGPSLocation gpsLocation;
    public boolean isDefaultRemoteConfigEnable = false;
    public boolean isMainProcess = false;
    public boolean isNetworkRequestEnable = true;
    public boolean isRemoteConfigEnabled = false;
    public boolean isShowDebugView = true;
    public boolean isTrackDeviceId = false;
    public SAConfigOptions saConfigOptions;
    public SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack;
    public int sessionTime = 30000;
}
