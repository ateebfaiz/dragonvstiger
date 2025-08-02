package com.sensorsdata.analytics.android.sdk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.core.business.visual.SAVisualTools;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManagerDebug;

public class SASchemeHelper {
    private static final String TAG = "SA.SASchemeUtil";

    public static void handleSchemeUrl(Activity activity, Intent intent) {
        Uri uri;
        if (AbstractSensorsDataAPI.isSDKDisabled()) {
            SALog.i(TAG, "SDK is disabled,scan code function has been turned off");
        } else if (SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) {
            SALog.i(TAG, "SDK is not init");
        } else {
            if (activity == null || intent == null) {
                uri = null;
            } else {
                try {
                    uri = intent.getData();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                    return;
                }
            }
            SALog.i(TAG, "handleSchemeUrl uri = " + uri + ", intent = " + intent);
            if (uri != null) {
                SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
                String host = uri.getHost();
                if (!"channeldebug".equals(host)) {
                    if (!"adsScanDeviceInfo".equals(host)) {
                        if ("heatmap".equals(host)) {
                            SAVisualTools.showOpenHeatMapDialog(activity, uri.getQueryParameter("feature_code"), uri.getQueryParameter(ImagesContract.URL));
                            intent.setData((Uri) null);
                            return;
                        } else if ("debugmode".equals(host)) {
                            SensorsDataDialogUtils.showDebugModeSelectDialog(activity, uri.getQueryParameter("info_id"), uri.getQueryParameter("sf_push_distinct_id"), uri.getQueryParameter("project"));
                            intent.setData((Uri) null);
                            return;
                        } else if ("visualized".equals(host)) {
                            SAVisualTools.showOpenVisualizedAutoTrackDialog(activity, uri.getQueryParameter("feature_code"), uri.getQueryParameter(ImagesContract.URL));
                            intent.setData((Uri) null);
                            return;
                        } else if ("popupwindow".equals(host)) {
                            SensorsDataDialogUtils.showPopupWindowDialog(activity, uri);
                            intent.setData((Uri) null);
                            return;
                        } else if ("encrypt".equals(host)) {
                            String str = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_VERIFY_SECRET_KEY, uri);
                            if (TextUtils.isEmpty(str)) {
                                str = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_encrypt_sdk_fail);
                            }
                            ToastUtil.showLong(activity, str);
                            SensorsDataDialogUtils.startLaunchActivity(activity);
                            intent.setData((Uri) null);
                            return;
                        } else if ("abtest".equals(host)) {
                            try {
                                ReflectUtil.callStaticMethod(Class.forName("com.sensorsdata.abtest.core.SensorsABTestSchemeHandler"), "handleSchemeUrl", uri.toString());
                            } catch (Exception e11) {
                                SALog.printStackTrace(e11);
                            }
                            SensorsDataDialogUtils.startLaunchActivity(activity);
                            intent.setData((Uri) null);
                            return;
                        } else if ("sensorsdataremoteconfig".equals(host)) {
                            SensorsDataAPI.sharedInstance().enableLog(true);
                            BaseSensorsDataSDKRemoteManager remoteManager = sharedInstance.getSAContextManager().getRemoteManager();
                            if (remoteManager != null) {
                                remoteManager.resetPullSDKConfigTimer();
                            }
                            SensorsDataRemoteManagerDebug sensorsDataRemoteManagerDebug = new SensorsDataRemoteManagerDebug(sharedInstance, activity.getBaseContext());
                            sharedInstance.getSAContextManager().setRemoteManager(sensorsDataRemoteManagerDebug);
                            SALog.i(TAG, "Start debugging remote config");
                            sensorsDataRemoteManagerDebug.checkRemoteConfig(uri, activity);
                            intent.setData((Uri) null);
                            return;
                        } else if ("assistant".equals(host)) {
                            SAConfigOptions configOptions = AbstractSensorsDataAPI.getConfigOptions();
                            if ((configOptions == null || !configOptions.isDisableDebugAssistant()) && "pairingCode".equals(uri.getQueryParameter(NotificationCompat.CATEGORY_SERVICE))) {
                                SAVisualTools.showPairingCodeInputDialog(activity);
                                return;
                            }
                            return;
                        } else {
                            SensorsDataDialogUtils.startLaunchActivity(activity);
                            return;
                        }
                    }
                }
                SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_HANDLER_SCAN_URI, activity, uri);
                intent.setData((Uri) null);
            }
        }
    }
}
