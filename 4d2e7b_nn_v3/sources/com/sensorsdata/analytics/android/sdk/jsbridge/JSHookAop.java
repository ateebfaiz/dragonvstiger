package com.sensorsdata.analytics.android.sdk.jsbridge;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import java.util.Map;
import org.json.JSONObject;

public class JSHookAop {
    private static final String TAG = "SA.JSHookAop";

    private static boolean isSupportJellyBean() {
        return true;
    }

    public static void loadData(View view, String str, String str2, String str3) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void loadUrl(View view, String str) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    public static void postUrl(View view, String str, byte[] bArr) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }

    private static void setupH5Bridge(View view) {
        if (isSupportJellyBean() && AbstractSensorsDataAPI.getConfigOptions() != null && AbstractSensorsDataAPI.getConfigOptions().isAutoTrackWebView()) {
            setupWebView(view);
        }
        if (isSupportJellyBean()) {
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, view);
        }
    }

    private static void setupWebView(View view) {
        if (view != null && view.getTag(R.id.sensors_analytics_tag_view_webview) == null) {
            view.setTag(R.id.sensors_analytics_tag_view_webview, new Object());
            H5Helper.addJavascriptInterface(view, new AppWebViewInterface(view.getContext().getApplicationContext(), (JSONObject) null, false, view), "SensorsData_APP_New_H5_Bridge");
        }
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        if (view == null) {
            SALog.i(TAG, "WebView has not initialized.");
        } else {
            setupH5Bridge(view);
        }
    }
}
