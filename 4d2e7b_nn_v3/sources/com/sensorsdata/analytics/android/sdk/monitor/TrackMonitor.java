package com.sensorsdata.analytics.android.sdk.monitor;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TrackMonitor {
    /* access modifiers changed from: private */
    public JSONObject cacheData;
    private List<SAFunctionListener> mFunctionListener;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final TrackMonitor INSTANCE = new TrackMonitor();

        private SingletonHolder() {
        }
    }

    private void call(String str, JSONObject jSONObject) {
        List<SAFunctionListener> list;
        if (!TextUtils.isEmpty(str) && (list = this.mFunctionListener) != null) {
            for (SAFunctionListener call : list) {
                call.call(str, jSONObject);
            }
        }
    }

    public static TrackMonitor getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addFunctionListener(SAFunctionListener sAFunctionListener) {
        try {
            if (this.mFunctionListener == null) {
                this.mFunctionListener = new ArrayList();
            }
            if (sAFunctionListener != null && !this.mFunctionListener.contains(sAFunctionListener)) {
                this.mFunctionListener.add(sAFunctionListener);
            }
            JSONObject jSONObject = this.cacheData;
            if (jSONObject != null) {
                call("trackEvent", jSONObject);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void callEnableDataCollect() {
        call("enableDataCollect", (JSONObject) null);
    }

    public void callIdentify(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("distinctId", str);
            call("identify", jSONObject);
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void callLogin(String str) {
        if (this.mFunctionListener != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("distinctId", str);
                call(FirebaseAnalytics.Event.LOGIN, jSONObject);
            } catch (JSONException e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void callLogout() {
        call("logout", (JSONObject) null);
    }

    public void callResetAnonymousId(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("distinctId", str);
            call("resetAnonymousId", jSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void callSetServerUrl() {
        call("setServerUrl", (JSONObject) null);
    }

    public void callTrack(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("eventJSON", jSONObject);
            if (!"$AppStart".equals(jSONObject.optString(NotificationCompat.CATEGORY_EVENT)) || this.mFunctionListener != null) {
                call("trackEvent", jSONObject2);
                return;
            }
            this.cacheData = jSONObject2;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    JSONObject unused = TrackMonitor.this.cacheData = null;
                }
            }, 2000);
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void removeFunctionListener(SAFunctionListener sAFunctionListener) {
        List<SAFunctionListener> list = this.mFunctionListener;
        if (list != null && sAFunctionListener != null) {
            list.remove(sAFunctionListener);
        }
    }

    private TrackMonitor() {
    }
}
