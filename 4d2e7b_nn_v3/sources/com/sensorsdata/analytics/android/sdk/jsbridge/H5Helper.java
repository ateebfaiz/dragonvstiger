package com.sensorsdata.analytics.android.sdk.jsbridge;

import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class H5Helper {
    private static CopyOnWriteArrayList<SAJSListener> mSAJSListeners;

    public static void addJavascriptInterface(View view, Object obj, String str) {
        try {
            Class<?> cls = view.getClass();
            try {
                Object invoke = cls.getMethod("getSettings", (Class[]) null).invoke(view, (Object[]) null);
                if (invoke != null) {
                    invoke.getClass().getMethod("setJavaScriptEnabled", new Class[]{Boolean.TYPE}).invoke(invoke, new Object[]{Boolean.TRUE});
                }
            } catch (Exception unused) {
            }
            cls.getMethod("addJavascriptInterface", new Class[]{Object.class, String.class}).invoke(view, new Object[]{obj, str});
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void addSAJSListener(SAJSListener sAJSListener) {
        try {
            if (mSAJSListeners == null) {
                mSAJSListeners = new CopyOnWriteArrayList<>();
            }
            if (!mSAJSListeners.contains(sAJSListener)) {
                mSAJSListeners.add(sAJSListener);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void handleJsMessage(WeakReference<View> weakReference, String str) {
        CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = mSAJSListeners;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<SAJSListener> it = mSAJSListeners.iterator();
            while (it.hasNext()) {
                SAJSListener next = it.next();
                if (next != null) {
                    try {
                        next.onReceiveJSMessage(weakReference, str);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
        }
    }

    public static void removeSAJSListener(SAJSListener sAJSListener) {
        try {
            CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = mSAJSListeners;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(sAJSListener)) {
                mSAJSListeners.remove(sAJSListener);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private static void trackEvent(final String str) {
        if (SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) {
            SALog.i("SA.AppWebViewInterface", "trackEvent SensorsDataAPIEmptyImplementation");
        } else {
            SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    SACoreHelper.getInstance().trackEvent(new InputData().setExtras(str));
                }
            });
        }
    }

    public static void trackEventFromH5(String str, boolean z10) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                SALog.i("SA.AppWebViewInterface", "trackEventFromH5 h5 enableVerify = " + z10);
                if (z10) {
                    String optString = jSONObject.optString("server_url");
                    SALog.i("SA.AppWebViewInterface", "trackEventFromH5 h5 serverUrl = " + optString);
                    if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(AbstractSensorsDataAPI.getConfigOptions().getServerUrl()))) {
                        return;
                    }
                }
                trackEvent(str);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static boolean verifyEventFromH5(String str) {
        try {
            SALog.i("SA.AppWebViewInterface", "verifyEventFromH5 h5 eventInfo = " + str);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String optString = new JSONObject(str).optString("server_url");
            SALog.i("SA.AppWebViewInterface", "verifyEventFromH5 h5 serverUrl = " + optString);
            if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(AbstractSensorsDataAPI.getConfigOptions().getServerUrl()))) {
                return false;
            }
            trackEvent(str);
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return false;
    }
}
