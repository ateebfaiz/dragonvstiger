package com.sensorsdata.analytics.android.sdk.core.business.session;

import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionRelatedManager {
    private static volatile SessionRelatedManager mSessionRelatedManager;
    public final String EVENT_SESSION_ID = "$event_session_id";
    private final String KEY_LAST_EVENT_TIME = "lastEventTime";
    private final String KEY_SESSION_ID = "sessionID";
    private final String KEY_START_TIME = "startTime";
    private long SESSION_LAST_INTERVAL_TIME = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    private final long SESSION_START_INTERVAL_TIME = 43200000;
    private final String SHARED_PREF_SESSION_CUTDATA = "sensorsdata.session.cutdata";
    private long mLastEventTime;
    private String mSessionID;
    private long mStartTime;

    private SessionRelatedManager() {
        try {
            setSessionLastIntervalTime(AbstractSensorsDataAPI.getConfigOptions().getEventSessionTimeout());
            if (!AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                deleteSessionData();
            } else {
                readSessionData();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private synchronized void createSessionData(long j10, boolean z10) {
        try {
            this.mSessionID = UUID.randomUUID().toString();
            if (z10) {
                this.mStartTime = j10;
            }
            this.mLastEventTime = Math.max(j10, this.mLastEventTime);
            SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
        } catch (Throwable th) {
            throw th;
        }
    }

    private void deleteSessionData() {
        this.mSessionID = null;
        this.mStartTime = -1;
        this.mLastEventTime = -1;
        SAStoreManager.getInstance().remove("sensorsdata.session.cutdata");
    }

    public static SessionRelatedManager getInstance() {
        if (mSessionRelatedManager == null) {
            synchronized (SessionRelatedManager.class) {
                try {
                    if (mSessionRelatedManager == null) {
                        mSessionRelatedManager = new SessionRelatedManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mSessionRelatedManager;
    }

    private String getSessionDataPack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sessionID", this.mSessionID);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("lastEventTime", this.mLastEventTime);
            return jSONObject.toString();
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void handleSessionState(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.lang.String r0 = r4.mSessionID     // Catch:{ all -> 0x002b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x002d
            long r0 = r4.mLastEventTime     // Catch:{ all -> 0x002b }
            long r0 = r5 - r0
            long r2 = r4.SESSION_LAST_INTERVAL_TIME     // Catch:{ all -> 0x002b }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002d
            long r0 = r4.mStartTime     // Catch:{ all -> 0x002b }
            long r0 = r5 - r0
            r2 = 43200000(0x2932e00, double:2.1343636E-316)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            goto L_0x002d
        L_0x0027:
            r4.updateSessionLastTime(r5)     // Catch:{ all -> 0x002b }
            goto L_0x0031
        L_0x002b:
            r5 = move-exception
            goto L_0x0033
        L_0x002d:
            r0 = 1
            r4.createSessionData(r5, r0)     // Catch:{ all -> 0x002b }
        L_0x0031:
            monitor-exit(r4)
            return
        L_0x0033:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.handleSessionState(long):void");
    }

    private void readSessionData() {
        String string = SAStoreManager.getInstance().getString("sensorsdata.session.cutdata", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("sessionID")) {
                    this.mSessionID = jSONObject.optString("sessionID");
                }
                if (jSONObject.has("startTime")) {
                    this.mStartTime = jSONObject.optLong("startTime");
                }
                if (jSONObject.has("lastEventTime")) {
                    this.mLastEventTime = jSONObject.optLong("lastEventTime");
                }
            } catch (JSONException e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private void setSessionLastIntervalTime(int i10) {
        if (i10 > 0) {
            this.SESSION_LAST_INTERVAL_TIME = ((long) i10) * 1000;
        }
    }

    private void updateSessionLastTime(long j10) {
        this.mLastEventTime = j10;
        SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
    }

    public String getSessionID() {
        return this.mSessionID;
    }

    public void handleEventOfSession(String str, JSONObject jSONObject, long j10) {
        if (AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
            try {
                if (!"$AppEnd".equals(str)) {
                    handleSessionState(j10);
                    jSONObject.put("$event_session_id", this.mSessionID);
                } else if (j10 > this.mLastEventTime) {
                    this.mLastEventTime = j10;
                }
            } catch (JSONException e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void refreshSessionByTimer(long j10) {
        if (j10 - this.mLastEventTime > this.SESSION_LAST_INTERVAL_TIME) {
            createSessionData(j10, TextUtils.isEmpty(this.mSessionID));
        }
    }
}
