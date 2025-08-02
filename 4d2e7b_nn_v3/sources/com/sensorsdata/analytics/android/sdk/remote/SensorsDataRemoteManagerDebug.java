package com.sensorsdata.analytics.android.sdk.remote;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataLoadingDialog;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.zing.zalo.zalosdk.common.Constant;
import org.json.JSONObject;

public class SensorsDataRemoteManagerDebug extends BaseSensorsDataSDKRemoteManager {
    private static final String TAG = "SA.SensorsDataRemoteManagerDebug";
    private String errorMsg = "";

    public SensorsDataRemoteManagerDebug(SensorsDataAPI sensorsDataAPI, Context context) {
        super(sensorsDataAPI, sensorsDataAPI.getSAContextManager());
        SALog.i(TAG, "remote config: Construct a SensorsDataRemoteManagerDebug");
    }

    private boolean verifyRemoteRequestParameter(Uri uri, Activity activity) {
        String str;
        boolean z10;
        String queryParameter = uri.getQueryParameter(Constant.PARAM_APP_ID);
        String queryParameter2 = uri.getQueryParameter("os");
        String queryParameter3 = uri.getQueryParameter("project");
        String queryParameter4 = uri.getQueryParameter("nv");
        String serverUrl = this.mSensorsDataAPI.getServerUrl();
        if (!TextUtils.isEmpty(serverUrl)) {
            str = new ServerUrl(serverUrl).getProject();
        } else {
            str = "";
        }
        SALog.i(TAG, "remote config: ServerUrl is " + serverUrl);
        if (!NetworkUtils.isNetworkAvailable(this.mContextManager.getContext())) {
            this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_network);
        } else {
            SensorsDataAPI sensorsDataAPI = this.mSensorsDataAPI;
            if (sensorsDataAPI != null && !sensorsDataAPI.isNetworkRequestEnable()) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_disable_network);
                SALog.i(TAG, "enableNetworkRequest is false");
            } else if (this.mDisableDefaultRemoteConfig) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_disable_remote);
                SALog.i(TAG, "disableDefaultRemoteConfig is true");
            } else if (!str.equals(queryParameter3)) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_project);
            } else if (!"Android".equals(queryParameter2)) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_os);
            } else if (!AppInfoUtils.getProcessName(activity).equals(queryParameter)) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_appid);
            } else if (TextUtils.isEmpty(queryParameter4)) {
                this.errorMsg = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_tip_error_qrcode);
            } else {
                z10 = true;
                SALog.i(TAG, "remote config: Uri is " + uri.toString());
                SALog.i(TAG, "remote config: The verification result is " + z10);
                return z10;
            }
        }
        z10 = false;
        SALog.i(TAG, "remote config: Uri is " + uri.toString());
        SALog.i(TAG, "remote config: The verification result is " + z10);
        return z10;
    }

    public void applySDKConfigFromCache() {
        SALog.i(TAG, "remote config: Running applySDKConfigFromCache");
    }

    public void checkRemoteConfig(final Uri uri, final Activity activity) {
        if (verifyRemoteRequestParameter(uri, activity)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_title), SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_config), SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_continue), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i10) {
                    final SensorsDataLoadingDialog sensorsDataLoadingDialog = new SensorsDataLoadingDialog(activity);
                    SensorsDataDialogUtils.dialogShowDismissOld(sensorsDataLoadingDialog);
                    SensorsDataRemoteManagerDebug.this.requestRemoteConfig(false, (HttpCallback.StringCallback) new HttpCallback.StringCallback() {
                        public void onAfter() {
                        }

                        public void onFailure(int i10, String str) {
                            sensorsDataLoadingDialog.dismiss();
                            Activity activity = activity;
                            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_fail));
                            SALog.i(SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was failed,code is " + i10 + ",errorMessage is" + str);
                        }

                        public void onResponse(String str) {
                            sensorsDataLoadingDialog.dismiss();
                            if (!TextUtils.isEmpty(str)) {
                                SensorsDataSDKRemoteConfig sDKRemoteConfig = SensorsDataRemoteManagerDebug.this.toSDKRemoteConfig(str);
                                String queryParameter = uri.getQueryParameter("nv");
                                if (!sDKRemoteConfig.getNewVersion().equals(queryParameter)) {
                                    Activity activity = activity;
                                    SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_version_error), String.format(SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_remote_version_tip), new Object[]{sDKRemoteConfig.getNewVersion(), queryParameter}), SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_ok), new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogInterface, int i10) {
                                            SensorsDataDialogUtils.startLaunchActivity(activity);
                                        }
                                    }, (String) null, (DialogInterface.OnClickListener) null);
                                } else {
                                    Activity activity2 = activity;
                                    SensorsDataDialogUtils.showDialog(activity2, SADisplayUtil.getStringResource(activity2, R.string.sensors_analytics_remote_succeed));
                                    SensorsDataRemoteManagerDebug.this.setSDKRemoteConfig(sDKRemoteConfig);
                                }
                            } else {
                                Activity activity3 = activity;
                                SensorsDataDialogUtils.showDialog(activity3, SADisplayUtil.getStringResource(activity3, R.string.sensors_analytics_remote_other_error));
                            }
                            SALog.i(SensorsDataRemoteManagerDebug.TAG, "remote config: Remote request was successful,response data is " + str);
                        }
                    });
                }
            }, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i10) {
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            });
            return;
        }
        SensorsDataDialogUtils.showDialog(activity, this.errorMsg);
    }

    public void pullSDKConfigFromServer() {
        SALog.i(TAG, "remote config: Running pullSDKConfigFromServer");
    }

    public void requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z10) {
        SALog.i(TAG, "remote config: Running requestRemoteConfig");
    }

    public void resetPullSDKConfigTimer() {
        SALog.i(TAG, "remote config: Running resetPullSDKConfigTimer");
    }

    public void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("$app_remote_config", sensorsDataSDKRemoteConfig.toJson().put("debug", true).toString());
            SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(new InputData().setEventName("$AppRemoteConfigChanged").setProperties(jSONObject).setEventType(EventType.TRACK));
                }
            });
            this.mSensorsDataAPI.flush();
            BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sensorsDataSDKRemoteConfig;
            SALog.i(TAG, "remote config: The remote configuration takes effect immediately");
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
