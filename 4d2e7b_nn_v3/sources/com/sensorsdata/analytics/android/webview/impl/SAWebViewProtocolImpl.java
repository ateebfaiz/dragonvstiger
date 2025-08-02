package com.sensorsdata.analytics.android.webview.impl;

import android.content.Context;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.jsbridge.AppWebViewInterface;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class SAWebViewProtocolImpl {
    private static final String TAG = "SA.WebViewProtocolImpl";
    private final String JS_BRIDGE = "SensorsData_APP_JS_Bridge";
    private final Context mContext;

    public SAWebViewProtocolImpl(SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
    }

    private void showUpWebView(WebView webView, JSONObject jSONObject, boolean z10, boolean z11) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new AppWebViewInterface(this.mContext, jSONObject, z11, webView), "SensorsData_APP_JS_Bridge");
            SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, webView);
        }
    }

    private void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z10, boolean z11) {
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod("addJavascriptInterface", new Class[]{Object.class, String.class});
                if (method != null) {
                    method.invoke(obj, new Object[]{new AppWebViewInterface(this.mContext, jSONObject, z11), "SensorsData_APP_JS_Bridge"});
                    SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE, obj);
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public <T> T invokeModuleFunction(String str, Object... objArr) {
        str.hashCode();
        if (str.equals(Modules.WebView.METHOD_SHOWUP_X5WEBVIEW)) {
            showUpX5WebView(objArr[0], objArr[1], objArr[2].booleanValue(), objArr[3].booleanValue());
            return null;
        } else if (!str.equals(Modules.WebView.METHOD_SHOWUP_WEBVIEW)) {
            return null;
        } else {
            showUpWebView(objArr[0], objArr[1], objArr[2].booleanValue(), objArr[3].booleanValue());
            return null;
        }
    }
}
