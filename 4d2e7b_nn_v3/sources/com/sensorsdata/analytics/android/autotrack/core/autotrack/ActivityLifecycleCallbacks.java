package com.sensorsdata.analytics.android.autotrack.core.autotrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.pdns.DNSResolver;
import com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools;
import com.sensorsdata.analytics.android.autotrack.utils.AopUtil;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants;
import com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class ActivityLifecycleCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String EVENT_DURATION = "event_duration";
    private static final String EVENT_TIME = "event_time";
    private static final String TAG = "SA.ActivityLifecycleCallbacks";
    private static final int TIME_INTERVAL = 2000;
    private final String APP_END_DATA = DbParams.PersistentName.APP_END_DATA;
    private final String APP_RESET_STATE = "app_reset_state";
    private final String APP_START_TIME = DbParams.TABLE_APP_START_TIME;
    private final String ELAPSE_TIME = "elapse_time";
    private final int MESSAGE_CODE_APP_END = 0;
    private final int MESSAGE_CODE_START = 100;
    private final int MESSAGE_CODE_START_DELAY = DNSResolver.GOBACK_LOCAL;
    private final int MESSAGE_CODE_STOP = 200;
    private final int MESSAGE_CODE_TIMER = 300;
    private final String TIME = "time";
    private JSONObject activityProperty = new JSONObject();
    /* access modifiers changed from: private */
    public final JSONObject endDataProperty = new JSONObject();
    private final Set<Integer> hashSet = new HashSet();
    /* access modifiers changed from: private */
    public final SAContextManager mContextManager;
    private final DbAdapter mDbAdapter;
    private JSONObject mDeepLinkProperty = new JSONObject();
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public final SensorsDataAPI mSensorsDataInstance;
    private int mStartActivityCount;
    private long mStartTime;
    /* access modifiers changed from: private */
    public int mStartTimerCount;
    /* access modifiers changed from: private */
    public long messageReceiveTime = 0;
    /* access modifiers changed from: private */
    public boolean resumeFromBackground = false;

    public ActivityLifecycleCallbacks(SAContextManager sAContextManager) {
        this.mSensorsDataInstance = sAContextManager.getSensorsDataAPI();
        this.mDbAdapter = DbAdapter.getInstance();
        this.mContextManager = sAContextManager;
        initHandler();
        registerAdvertObserver();
    }

    private void buildScreenProperties(Activity activity) {
        JSONObject buildTitleNoAutoTrackerProperties = AopUtil.buildTitleNoAutoTrackerProperties(activity);
        this.activityProperty = buildTitleNoAutoTrackerProperties;
        JSONUtils.mergeJSONObject(buildTitleNoAutoTrackerProperties, this.endDataProperty);
    }

    /* access modifiers changed from: private */
    public void generateAppEndData(long j10, long j11) {
        try {
            if (this.mStartTime == 0) {
                this.mStartTime = DbAdapter.getInstance().getAppStartTime();
            }
            this.endDataProperty.put(EVENT_DURATION, TimeUtils.duration(this.mStartTime, j11));
            this.endDataProperty.put(DbParams.TABLE_APP_START_TIME, this.mStartTime);
            long j12 = j10 + 2000;
            this.endDataProperty.put(EVENT_TIME, j12);
            if (AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                SessionRelatedManager.getInstance().refreshSessionByTimer(j12);
                JSONObject jSONObject = this.endDataProperty;
                SessionRelatedManager.getInstance().getClass();
                jSONObject.put("$event_session_id", SessionRelatedManager.getInstance().getSessionID());
            }
            this.endDataProperty.put("$app_version", AppInfoUtils.getAppVersionName(this.mContextManager.getContext()));
            this.endDataProperty.put("$lib_version", SensorsDataAPI.sharedInstance().getSDKVersion());
            if (!this.endDataProperty.has("$is_first_day")) {
                this.endDataProperty.put("$is_first_day", this.mContextManager.isFirstDay(System.currentTimeMillis()));
            }
            this.mDbAdapter.commitAppExitData(this.endDataProperty.toString());
        } catch (Throwable th) {
            SALog.i(TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r10.what == 101) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleStartedMessage(android.os.Message r10) {
        /*
            r9 = this;
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = r9.mDbAdapter     // Catch:{ Exception -> 0x0034 }
            int r0 = r0.getActivityCount()     // Catch:{ Exception -> 0x0034 }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r1 = r9.mDbAdapter     // Catch:{ Exception -> 0x0034 }
            r2 = 1
            int r0 = r0 + r2
            r9.mStartActivityCount = r0     // Catch:{ Exception -> 0x0034 }
            r1.commitActivityCount(r0)     // Catch:{ Exception -> 0x0034 }
            int r0 = r9.mStartActivityCount     // Catch:{ Exception -> 0x0034 }
            if (r0 != r2) goto L_0x0102
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0034 }
            boolean r0 = r0.isSaveDeepLinkInfo()     // Catch:{ Exception -> 0x0034 }
            r1 = 0
            if (r0 == 0) goto L_0x0037
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager r0 = com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "sensors_analytics_module_advertisement"
            java.lang.String r4 = "getLatestUtmProperties"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r0.invokeModuleFunction(r3, r4, r5)     // Catch:{ Exception -> 0x0034 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x0034 }
            org.json.JSONObject r3 = r9.endDataProperty     // Catch:{ Exception -> 0x0034 }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r0, r3)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            r10 = move-exception
            goto L_0x00f8
        L_0x0037:
            android.os.Handler r0 = r9.mHandler     // Catch:{ Exception -> 0x0034 }
            r0.removeMessages(r1)     // Catch:{ Exception -> 0x0034 }
            boolean r0 = r9.isSessionTimeOut()     // Catch:{ Exception -> 0x0034 }
            if (r0 == 0) goto L_0x0102
            android.os.Handler r0 = r9.mHandler     // Catch:{ Exception -> 0x0034 }
            android.os.Message r1 = r9.obtainAppEndMessage(r1)     // Catch:{ Exception -> 0x0034 }
            r0.sendMessage(r1)     // Catch:{ Exception -> 0x0034 }
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader r0 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance()     // Catch:{ Exception -> 0x0034 }
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart r0 = r0.getFirstStartPst()     // Catch:{ Exception -> 0x0034 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0034 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0034 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0034 }
            android.os.Bundle r1 = r10.getData()     // Catch:{ Exception -> 0x0034 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = r9.mSensorsDataInstance     // Catch:{ Exception -> 0x0076 }
            boolean r3 = r3.isAutoTrackEnabled()     // Catch:{ Exception -> 0x0076 }
            r4 = 101(0x65, float:1.42E-43)
            if (r3 == 0) goto L_0x0078
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = r9.mSensorsDataInstance     // Catch:{ Exception -> 0x0076 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r5 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_START     // Catch:{ Exception -> 0x0076 }
            boolean r3 = r3.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r5)     // Catch:{ Exception -> 0x0076 }
            if (r3 != 0) goto L_0x0078
            goto L_0x007c
        L_0x0076:
            r10 = move-exception
            goto L_0x00e7
        L_0x0078:
            int r3 = r10.what     // Catch:{ Exception -> 0x0076 }
            if (r3 != r4) goto L_0x00ec
        L_0x007c:
            if (r0 == 0) goto L_0x008b
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader r3 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance()     // Catch:{ Exception -> 0x0076 }
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart r3 = r3.getFirstStartPst()     // Catch:{ Exception -> 0x0076 }
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0076 }
            r3.commit(r5)     // Catch:{ Exception -> 0x0076 }
        L_0x008b:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0076 }
            r3.<init>()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = "$resume_from_background"
            boolean r6 = r9.resumeFromBackground     // Catch:{ Exception -> 0x0076 }
            r3.put(r5, r6)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = "$is_first_time"
            r3.put(r5, r0)     // Catch:{ Exception -> 0x0076 }
            org.json.JSONObject r0 = r9.activityProperty     // Catch:{ Exception -> 0x0076 }
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r0, r3)     // Catch:{ Exception -> 0x0076 }
            org.json.JSONObject r0 = r9.mDeepLinkProperty     // Catch:{ Exception -> 0x0076 }
            if (r0 == 0) goto L_0x00ab
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(r0, r3)     // Catch:{ Exception -> 0x0076 }
            r0 = 0
            r9.mDeepLinkProperty = r0     // Catch:{ Exception -> 0x0076 }
        L_0x00ab:
            java.lang.String r0 = "time"
            long r5 = r1.getLong(r0)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = "event_time"
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00ba
            goto L_0x00be
        L_0x00ba:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0076 }
        L_0x00be:
            r3.put(r0, r5)     // Catch:{ Exception -> 0x0076 }
            int r10 = r10.what     // Catch:{ Exception -> 0x0076 }
            if (r10 != r4) goto L_0x00d3
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager r10 = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance()     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = "app_start_data"
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0076 }
            r10.setString(r0, r3)     // Catch:{ Exception -> 0x0076 }
            goto L_0x00ec
        L_0x00d3:
            com.sensorsdata.analytics.android.sdk.core.SACoreHelper r10 = com.sensorsdata.analytics.android.sdk.core.SACoreHelper.getInstance()     // Catch:{ Exception -> 0x0076 }
            com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$3 r0 = new com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks$3     // Catch:{ Exception -> 0x0076 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0076 }
            r10.trackQueueEvent(r0)     // Catch:{ Exception -> 0x0076 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r10 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x0076 }
            r10.flush()     // Catch:{ Exception -> 0x0076 }
            goto L_0x00ec
        L_0x00e7:
            java.lang.String r0 = "SA.ActivityLifecycleCallbacks"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ Exception -> 0x0034 }
        L_0x00ec:
            java.lang.String r10 = "elapse_time"
            long r0 = r1.getLong(r10)     // Catch:{ Exception -> 0x0034 }
            r9.updateStartTime(r0)     // Catch:{ Exception -> 0x0034 }
            r9.resumeFromBackground = r2     // Catch:{ Exception -> 0x0034 }
            goto L_0x0102
        L_0x00f8:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r10)
            long r0 = android.os.SystemClock.elapsedRealtime()
            r9.updateStartTime(r0)
        L_0x0102:
            int r10 = r9.mStartTimerCount     // Catch:{ Exception -> 0x0120 }
            int r0 = r10 + 1
            r9.mStartTimerCount = r0     // Catch:{ Exception -> 0x0120 }
            if (r10 != 0) goto L_0x0124
            com.sensorsdata.analytics.android.sdk.core.SAContextManager r10 = r9.mContextManager     // Catch:{ Exception -> 0x0120 }
            com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions r10 = r10.getInternalConfigs()     // Catch:{ Exception -> 0x0120 }
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r10 = r10.saConfigOptions     // Catch:{ Exception -> 0x0120 }
            boolean r10 = r10.isDisableAppEndTimer()     // Catch:{ Exception -> 0x0120 }
            if (r10 != 0) goto L_0x0124
            android.os.Handler r10 = r9.mHandler     // Catch:{ Exception -> 0x0120 }
            r0 = 300(0x12c, float:4.2E-43)
            r10.sendEmptyMessage(r0)     // Catch:{ Exception -> 0x0120 }
            goto L_0x0124
        L_0x0120:
            r10 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r10)
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.handleStartedMessage(android.os.Message):void");
    }

    /* access modifiers changed from: private */
    public void handleStoppedMessage(Message message) {
        try {
            int i10 = this.mStartTimerCount - 1;
            this.mStartTimerCount = i10;
            int i11 = 0;
            if (i10 <= 0) {
                this.mHandler.removeMessages(300);
                this.mStartTimerCount = 0;
            }
            int activityCount = this.mDbAdapter.getActivityCount();
            this.mStartActivityCount = activityCount;
            if (activityCount > 0) {
                i11 = activityCount - 1;
                this.mStartActivityCount = i11;
            }
            this.mStartActivityCount = i11;
            this.mDbAdapter.commitActivityCount(i11);
            if (this.mStartActivityCount <= 0) {
                this.mSensorsDataInstance.flush();
                Bundle data = message.getData();
                generateAppEndData(data.getLong("time"), data.getLong("elapse_time"));
                this.mHandler.sendMessageDelayed(obtainAppEndMessage(true), (long) this.mSensorsDataInstance.getSessionIntervalTime());
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void initHandler() {
        try {
            HandlerThread handlerThread = new HandlerThread("SENSORS_DATA_THREAD");
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i10 = message.what;
                    if (i10 != 0) {
                        if (i10 == 200) {
                            ActivityLifecycleCallbacks.this.handleStoppedMessage(message);
                        } else if (i10 == 300) {
                            if (ActivityLifecycleCallbacks.this.mSensorsDataInstance.isAutoTrackEnabled() && ActivityLifecycleCallbacks.this.isAutoTrackAppEnd()) {
                                ActivityLifecycleCallbacks.this.generateAppEndData(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                            }
                            if (ActivityLifecycleCallbacks.this.mStartTimerCount > 0 && !ActivityLifecycleCallbacks.this.mContextManager.getInternalConfigs().saConfigOptions.isDisableAppEndTimer()) {
                                ActivityLifecycleCallbacks.this.mHandler.sendEmptyMessageDelayed(300, 2000);
                            }
                        } else if (i10 == 100 || i10 == 101) {
                            ActivityLifecycleCallbacks.this.handleStartedMessage(message);
                        }
                    } else if (ActivityLifecycleCallbacks.this.messageReceiveTime == 0 || SystemClock.elapsedRealtime() - ActivityLifecycleCallbacks.this.messageReceiveTime >= ((long) ActivityLifecycleCallbacks.this.mSensorsDataInstance.getSessionIntervalTime())) {
                        long unused = ActivityLifecycleCallbacks.this.messageReceiveTime = SystemClock.elapsedRealtime();
                        Bundle data = message.getData();
                        String string = data.getString(DbParams.PersistentName.APP_END_DATA);
                        boolean z10 = data.getBoolean("app_reset_state");
                        boolean unused2 = ActivityLifecycleCallbacks.this.resumeFromBackground = true;
                        if (z10) {
                            SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_COMMIT_REQUEST_DEFERRED_DEEPLINK, Boolean.FALSE);
                            if (DbAdapter.getInstance().getActivityCount() <= 0) {
                                ActivityLifecycleCallbacks.this.trackAppEnd(string);
                                return;
                            }
                            return;
                        }
                        ActivityLifecycleCallbacks.this.trackAppEnd(string);
                    } else {
                        SALog.i(ActivityLifecycleCallbacks.TAG, "$AppEnd in time");
                    }
                }
            };
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: private */
    public boolean isAutoTrackAppEnd() {
        return !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_END);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isSessionTimeOut() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 946656000000(0xdc69183800, double:4.677102080295E-312)
            long r0 = java.lang.Math.max(r0, r2)
            r2 = 0
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = r4.getAppExitData()     // Catch:{ Exception -> 0x003d }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003d }
            if (r5 != 0) goto L_0x0044
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x003d }
            r5.<init>(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = "event_time"
            long r6 = r5.optLong(r4)     // Catch:{ Exception -> 0x003d }
            r8 = 2000(0x7d0, double:9.88E-321)
            long r6 = r6 - r8
            long r8 = r10.mStartTime     // Catch:{ Exception -> 0x003b }
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0043
            java.lang.String r2 = "app_start_time"
            long r2 = r5.optLong(r2)     // Catch:{ Exception -> 0x003b }
            r10.updateStartTime(r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r2 = move-exception
            goto L_0x0040
        L_0x003d:
            r4 = move-exception
            r6 = r2
            r2 = r4
        L_0x0040:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)
        L_0x0043:
            r2 = r6
        L_0x0044:
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r10.mSensorsDataInstance
            int r2 = r2.getSessionIntervalTime()
            long r2 = (long) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0056
            r0 = 1
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.isSessionTimeOut():boolean");
    }

    private Message obtainAppEndMessage(boolean z10) {
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString(DbParams.PersistentName.APP_END_DATA, DbAdapter.getInstance().getAppExitData());
        bundle.putBoolean("app_reset_state", z10);
        obtain.setData(bundle);
        return obtain;
    }

    private void registerAdvertObserver() {
        if (SAModuleManager.getInstance().hasModuleByName(Modules.Advert.MODULE_NAME)) {
            SAEventBus.getInstance().register(SAEventBusConstants.Tag.DEEPLINK_LAUNCH, new Subscription<JSONObject>() {
                public void notify(JSONObject jSONObject) {
                    SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_REMOVE_DEEPLINK_INFO, ActivityLifecycleCallbacks.this.endDataProperty);
                    JSONUtils.mergeJSONObject(jSONObject, ActivityLifecycleCallbacks.this.endDataProperty);
                }
            });
        }
    }

    private void sendActivityHandleMessage(int i10) {
        Message obtainMessage = this.mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putLong("time", System.currentTimeMillis());
        bundle.putLong("elapse_time", SystemClock.elapsedRealtime());
        obtainMessage.what = i10;
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    public void trackAppEnd(String str) {
        try {
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && isAutoTrackAppEnd() && !TextUtils.isEmpty(str)) {
                final JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("track_timer")) {
                    jSONObject.put(EVENT_TIME, jSONObject.optLong("track_timer") + 2000);
                    jSONObject.remove("event_timer");
                    jSONObject.remove("track_timer");
                }
                jSONObject.remove(DbParams.TABLE_APP_START_TIME);
                if (DbAdapter.getInstance().getAppStartTime() == 0) {
                    jSONObject.remove(EVENT_DURATION);
                }
                SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                    public void run() {
                        ActivityLifecycleCallbacks.this.mContextManager.trackEvent(new InputData().setEventName("$AppEnd").setProperties(SADataHelper.appendLibMethodAutoTrack(jSONObject)).setEventType(EventType.TRACK));
                    }
                });
                this.mDbAdapter.commitAppExitData("");
                this.mSensorsDataInstance.flush();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(1:10)(1:11)|12|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r6 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r2.commitAppStartTime(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = r5.mDbAdapter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r6 > 0) goto L_0x001a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateStartTime(long r6) {
        /*
            r5 = this;
            r0 = 0
            r5.mStartTime = r6     // Catch:{ Exception -> 0x0014 }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r5.mDbAdapter     // Catch:{ Exception -> 0x0014 }
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x000c
            r3 = r6
            goto L_0x0010
        L_0x000c:
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0014 }
        L_0x0010:
            r2.commitAppStartTime(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0022
        L_0x0014:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r5.mDbAdapter     // Catch:{ Exception -> 0x0022 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0022 }
        L_0x001f:
            r2.commitAppStartTime(r6)     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.autotrack.core.autotrack.ActivityLifecycleCallbacks.updateStartTime(long):void");
    }

    /* access modifiers changed from: package-private */
    public void addActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.add(Integer.valueOf(activity.hashCode()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasActivity(Activity activity) {
        if (activity != null) {
            return this.hashSet.contains(Integer.valueOf(activity.hashCode()));
        }
        return false;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        JSONObject trackProperties;
        try {
            if (!SensorsDataDialogUtils.isSchemeActivity(activity)) {
                buildScreenProperties(activity);
                if (this.mSensorsDataInstance.isAutoTrackEnabled() && !this.mSensorsDataInstance.isActivityAutoTrackAppViewScreenIgnored(activity.getClass()) && !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                    JSONObject jSONObject = new JSONObject();
                    JSONUtils.mergeJSONObject(this.activityProperty, jSONObject);
                    if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                        JSONUtils.mergeJSONObject(trackProperties, jSONObject);
                    }
                    this.mSensorsDataInstance.trackViewScreen(SAPageTools.getScreenUrl(activity), SADataHelper.appendLibMethodAutoTrack(jSONObject));
                }
            }
        } catch (Throwable th) {
            SALog.i(TAG, th);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && !hasActivity(activity)) {
            if (this.mStartActivityCount == 0) {
                buildScreenProperties(activity);
            }
            sendActivityHandleMessage(100);
            addActivity(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && hasActivity(activity)) {
            sendActivityHandleMessage(200);
            removeActivity(activity);
        }
    }

    public void onDelayInitStarted(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && !hasActivity(activity)) {
            if (this.mStartActivityCount == 0) {
                buildScreenProperties(activity);
            }
            sendActivityHandleMessage(DNSResolver.GOBACK_LOCAL);
            addActivity(activity);
        }
    }

    public void onNewIntent(Intent intent) {
    }

    /* access modifiers changed from: package-private */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (TextUtils.isEmpty(DbAdapter.getInstance().getAppExitData())) {
            DbAdapter.getInstance().commitAppStartTime(SystemClock.elapsedRealtime());
        }
        if (AbstractSensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
            DbAdapter.getInstance().commitSubProcessFlushState(false);
        }
        DbAdapter.getInstance().commitActivityCount(0);
    }
}
