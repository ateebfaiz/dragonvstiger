package com.sensorsdata.analytics.android.sdk.core.business.visual;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;

public class SAVisualTools {
    private static boolean checkProjectIsValid(String str) {
        String str2;
        Uri parse;
        Uri parse2;
        String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
        String str3 = null;
        if (TextUtils.isEmpty(str) || (parse2 = Uri.parse(str)) == null) {
            str2 = null;
        } else {
            str2 = parse2.getQueryParameter("project");
        }
        if (!TextUtils.isEmpty(serverUrl) && (parse = Uri.parse(serverUrl)) != null) {
            str3 = parse.getQueryParameter("project");
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !TextUtils.equals(str2, str3)) {
            return false;
        }
        return true;
    }

    public static void showOpenHeatMapDialog(Activity activity, String str, String str2) {
        if (!checkProjectIsValid(str2)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_visual_dialog_error));
        } else if (!SAModuleManager.getInstance().hasModuleByName(Modules.Visual.MODULE_NAME)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_heatmap_sdk_fail));
        } else if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_heatmap_network_fail));
        } else if (!SensorsDataAPI.sharedInstance().isHeatMapEnabled()) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_heatmap_sdk_fail));
        } else {
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_SHOW_OPEN_HEATMAP_DIALOG, activity, str, str2);
        }
    }

    public static void showOpenVisualizedAutoTrackDialog(Activity activity, String str, String str2) {
        if (!checkProjectIsValid(str2)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_visual_dialog_error));
        } else if (!SAModuleManager.getInstance().hasModuleByName(Modules.Visual.MODULE_NAME)) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_visual_sdk_fail));
        } else if (!SensorsDataAPI.sharedInstance().isNetworkRequestEnable()) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_visual_network_fail));
        } else if (!SensorsDataAPI.sharedInstance().isVisualizedAutoTrackEnabled()) {
            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_visual_sdk_fail));
        } else {
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_SHOW_OPEN_VISUALIZED_AUTOTRACK_DIALOG, activity, str, str2);
        }
    }

    public static void showPairingCodeInputDialog(Context context) {
        if (SAModuleManager.getInstance().hasModuleByName(Modules.Visual.MODULE_NAME)) {
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_SHOW_PAIRING_CODE_INPUTDIALOG, context);
            return;
        }
        SensorsDataDialogUtils.showDialog(context, SADisplayUtil.getStringResource(context, R.string.sensors_analytics_visual_heatmap_sdk_fail));
    }
}
