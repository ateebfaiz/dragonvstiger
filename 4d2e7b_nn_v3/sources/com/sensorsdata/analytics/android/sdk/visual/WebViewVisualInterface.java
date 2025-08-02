package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import java.lang.ref.WeakReference;

public class WebViewVisualInterface {
    private static final String TAG = "SA.Visual.WebViewVisualInterface";
    /* access modifiers changed from: private */
    public WeakReference<View> mWebView;

    public WebViewVisualInterface(View view) {
        this.mWebView = new WeakReference<>(view);
    }

    @JavascriptInterface
    public void sensorsdata_hover_web_nodes(String str) {
        try {
            NodesProcess.getInstance().getWebNodesManager().handlerMessage(str);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    @JavascriptInterface
    public void sensorsdata_visualized_alert_info(final String str) {
        try {
            SALog.i(TAG, "sensorsdata_visualized_alert_info msg: " + str);
            if (this.mWebView.get() != null) {
                this.mWebView.get().post(new Runnable() {
                    public void run() {
                        String str = (String) ReflectUtil.callMethod(WebViewVisualInterface.this.mWebView.get(), "getUrl", new Object[0]);
                        if (!TextUtils.isEmpty(str)) {
                            SALog.i(WebViewVisualInterface.TAG, "sensorsdata_visualized_alert_info url: " + str);
                            NodesProcess.getInstance().getWebNodesManager().handlerFailure(str, str);
                        }
                    }
                });
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    @JavascriptInterface
    public boolean sensorsdata_visualized_mode() {
        if (VisualizedAutoTrackService.getInstance().isServiceRunning() || HeatMapService.getInstance().isServiceRunning()) {
            return true;
        }
        return false;
    }
}
