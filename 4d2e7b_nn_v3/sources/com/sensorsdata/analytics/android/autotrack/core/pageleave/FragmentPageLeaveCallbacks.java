package com.sensorsdata.analytics.android.autotrack.core.pageleave;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class FragmentPageLeaveCallbacks implements SAFragmentLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String START_TIME = "sa_start_time";
    private List<Class<?>> mIgnoreList;
    private final boolean mIsEmpty;
    /* access modifiers changed from: private */
    public final HashMap<Integer, JSONObject> mResumedFragments = new HashMap<>();

    public FragmentPageLeaveCallbacks(List<Class<?>> list) {
        if (list == null || list.isEmpty()) {
            this.mIsEmpty = true;
            return;
        }
        this.mIgnoreList = list;
        this.mIsEmpty = false;
    }

    private boolean ignorePage(Object obj) {
        if (!this.mIsEmpty) {
            return this.mIgnoreList.contains(obj.getClass());
        }
        return false;
    }

    private void trackAppPageLeave(Object obj) {
        try {
            int hashCode = obj.hashCode();
            if (this.mResumedFragments.containsKey(Integer.valueOf(hashCode))) {
                this.mResumedFragments.remove(Integer.valueOf(hashCode));
                trackPageLeaveEvent(this.mResumedFragments.get(Integer.valueOf(hashCode)));
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void trackFragmentStart(Object obj) {
        try {
            final String screenUrl = SAPageTools.getScreenUrl(obj);
            final int hashCode = obj.hashCode();
            final JSONObject fragmentPageInfo = SAPageInfoUtils.getFragmentPageInfo((Activity) null, obj);
            Dispatcher.getInstance().postDelayed(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[Catch:{ JSONException -> 0x002c }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r4 = this;
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002c }
                        r0.<init>()     // Catch:{ JSONException -> 0x002c }
                        java.lang.String r1 = "sa_start_time"
                        long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ JSONException -> 0x002c }
                        r0.put(r1, r2)     // Catch:{ JSONException -> 0x002c }
                        java.lang.String r1 = "$url"
                        java.lang.String r2 = r0     // Catch:{ JSONException -> 0x002c }
                        r0.put(r1, r2)     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN     // Catch:{ JSONException -> 0x002c }
                        boolean r1 = r1.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r2)     // Catch:{ JSONException -> 0x002c }
                        if (r1 != 0) goto L_0x002e
                        com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ JSONException -> 0x002c }
                        boolean r1 = r1.isTrackFragmentAppViewScreenEnabled()     // Catch:{ JSONException -> 0x002c }
                        if (r1 != 0) goto L_0x0033
                        goto L_0x002e
                    L_0x002c:
                        r0 = move-exception
                        goto L_0x0076
                    L_0x002e:
                        java.lang.String r1 = r0     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.setCurrentScreenUrl(r1)     // Catch:{ JSONException -> 0x002c }
                    L_0x0033:
                        java.lang.String r1 = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrer()     // Catch:{ JSONException -> 0x002c }
                        boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x002c }
                        if (r2 != 0) goto L_0x0042
                        java.lang.String r2 = "$referrer"
                        r0.put(r2, r1)     // Catch:{ JSONException -> 0x002c }
                    L_0x0042:
                        java.lang.String r1 = "$referrer_title"
                        java.lang.String r2 = com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getReferrerTitle()     // Catch:{ JSONException -> 0x002c }
                        r0.put(r1, r2)     // Catch:{ JSONException -> 0x002c }
                        org.json.JSONObject r1 = r5     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r1, r0)     // Catch:{ JSONException -> 0x002c }
                        java.lang.String r1 = "SA.FragmentPageLeave"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x002c }
                        r2.<init>()     // Catch:{ JSONException -> 0x002c }
                        java.lang.String r3 = "trackFragmentStart = "
                        r2.append(r3)     // Catch:{ JSONException -> 0x002c }
                        r2.append(r0)     // Catch:{ JSONException -> 0x002c }
                        java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ JSONException -> 0x002c }
                        com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks r1 = com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.this     // Catch:{ JSONException -> 0x002c }
                        java.util.HashMap r1 = r1.mResumedFragments     // Catch:{ JSONException -> 0x002c }
                        int r2 = r1     // Catch:{ JSONException -> 0x002c }
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x002c }
                        r1.put(r2, r0)     // Catch:{ JSONException -> 0x002c }
                        goto L_0x0079
                    L_0x0076:
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                    L_0x0079:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.pageleave.FragmentPageLeaveCallbacks.AnonymousClass1.run():void");
                }
            }, 300);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void trackPageLeaveEvent(final JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(START_TIME);
            jSONObject.remove(START_TIME);
            Float duration = TimeUtils.duration(optLong, SystemClock.elapsedRealtime());
            if (((double) duration.floatValue()) >= 0.05d) {
                jSONObject.put("event_duration", duration);
                SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                    public void run() {
                        SensorsDataAPI.sharedInstance().getSAContextManager().trackEvent(new InputData().setEventName("$AppPageLeave").setProperties(jSONObject).setEventType(EventType.TRACK));
                    }
                });
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onCreate(Object obj) {
    }

    public void onHiddenChanged(Object obj, boolean z10) {
        if (ignorePage(obj)) {
            return;
        }
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    public void onPause(Object obj) {
        try {
            if (this.mResumedFragments.containsKey(Integer.valueOf(obj.hashCode()))) {
                trackAppPageLeave(obj);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void onResume(Object obj) {
        if (!ignorePage(obj) && SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        }
    }

    public void onStart(Object obj) {
    }

    public void onStop(Object obj) {
    }

    public void onViewCreated(Object obj, View view, Bundle bundle) {
    }

    public void setUserVisibleHint(Object obj, boolean z10) {
        if (ignorePage(obj)) {
            return;
        }
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Iterator<Integer> it = this.mResumedFragments.keySet().iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                next.intValue();
                JSONObject jSONObject = this.mResumedFragments.get(next);
                if (jSONObject != null) {
                    trackPageLeaveEvent(jSONObject);
                    it.remove();
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
