package com.adjust.sdk.webbridge;

import android.app.Application;
import android.webkit.WebView;

public class AdjustBridge {
    private static AdjustBridgeInstance defaultInstance;

    public static synchronized AdjustBridgeInstance getDefaultInstance() {
        AdjustBridgeInstance adjustBridgeInstance;
        synchronized (AdjustBridge.class) {
            try {
                if (defaultInstance == null) {
                    defaultInstance = new AdjustBridgeInstance();
                }
                adjustBridgeInstance = defaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adjustBridgeInstance;
    }

    public static synchronized AdjustBridgeInstance registerAndGetInstance(Application application, WebView webView) {
        AdjustBridgeInstance adjustBridgeInstance;
        synchronized (AdjustBridge.class) {
            try {
                if (defaultInstance == null) {
                    defaultInstance = new AdjustBridgeInstance(application, webView);
                }
                adjustBridgeInstance = defaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adjustBridgeInstance;
    }

    public static void setApplicationContext(Application application) {
        getDefaultInstance().setApplicationContext(application);
    }

    public static void setWebView(WebView webView) {
        getDefaultInstance().setWebView(webView);
    }

    public static synchronized void unregister() {
        synchronized (AdjustBridge.class) {
            try {
                AdjustBridgeInstance adjustBridgeInstance = defaultInstance;
                if (adjustBridgeInstance != null) {
                    adjustBridgeInstance.unregister();
                }
                defaultInstance = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
