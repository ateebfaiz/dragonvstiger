package com.sensorsdata.analytics.android.sdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.AnalyticsMessages;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector;
import com.sensorsdata.analytics.android.sdk.core.event.EventProcessor;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.event.TrackEventProcessor;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SAContextManager {
    private Context mContext;
    private List<SAEventListener> mEventListenerList;
    private PersistentFirstDay mFirstDay;
    /* access modifiers changed from: private */
    public InternalConfigOptions mInternalConfigs;
    private AnalyticsMessages mMessages;
    private SensorsDataScreenOrientationDetector mOrientationDetector;
    private PropertyPluginManager mPluginManager;
    BaseSensorsDataSDKRemoteManager mRemoteManager;
    private SensorsDataAPI mSensorsDataAPI;
    private EventProcessor mTrackEventProcessor;
    UserIdentityAPI mUserIdentityAPI;

    public SAContextManager() {
    }

    private void checkAppStart() {
        if (SAStoreManager.getInstance().isExists(DbParams.APP_START_DATA) && SensorsDataAPI.sharedInstance().isAutoTrackEnabled() && !SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_START)) {
            SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    try {
                        String string = SAStoreManager.getInstance().getString(DbParams.APP_START_DATA, "");
                        if (!TextUtils.isEmpty(string)) {
                            SAContextManager.this.trackEvent(new InputData().setEventName("$AppStart").setProperties(SADataHelper.appendLibMethodAutoTrack(new JSONObject(string))).setEventType(EventType.TRACK));
                            SAStoreManager.getInstance().remove(DbParams.APP_START_DATA);
                        }
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        }
    }

    private void executeDelayTask() {
        SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                String anonymousId = SAContextManager.this.mInternalConfigs.saConfigOptions.getAnonymousId();
                if (!TextUtils.isEmpty(anonymousId)) {
                    SAContextManager.this.getUserIdentityAPI().identify(anonymousId);
                }
            }
        });
    }

    public void addEventListener(SAEventListener sAEventListener) {
        try {
            if (this.mEventListenerList == null) {
                this.mEventListenerList = new ArrayList();
            }
            this.mEventListenerList.add(sAEventListener);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public AnalyticsMessages getAnalyticsMessages() {
        return this.mMessages;
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<SAEventListener> getEventListenerList() {
        return this.mEventListenerList;
    }

    public InternalConfigOptions getInternalConfigs() {
        return this.mInternalConfigs;
    }

    public SensorsDataScreenOrientationDetector getOrientationDetector() {
        return this.mOrientationDetector;
    }

    public PropertyPluginManager getPluginManager() {
        return this.mPluginManager;
    }

    public BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return this.mRemoteManager;
    }

    public SensorsDataAPI getSensorsDataAPI() {
        return this.mSensorsDataAPI;
    }

    public synchronized UserIdentityAPI getUserIdentityAPI() {
        try {
            if (this.mUserIdentityAPI == null) {
                this.mUserIdentityAPI = new UserIdentityAPI(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.mUserIdentityAPI;
    }

    public boolean isFirstDay(long j10) {
        String str = (String) this.mFirstDay.get();
        if (str == null) {
            this.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD));
            return true;
        }
        try {
            return str.equals(TimeUtils.formatTime(j10, TimeUtils.YYYY_MM_DD));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    public void removeEventListener(SAEventListener sAEventListener) {
        try {
            List<SAEventListener> list = this.mEventListenerList;
            if (list != null && list.contains(sAEventListener)) {
                this.mEventListenerList.remove(sAEventListener);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void setOrientationDetector(SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector) {
        this.mOrientationDetector = sensorsDataScreenOrientationDetector;
    }

    public void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        this.mRemoteManager = baseSensorsDataSDKRemoteManager;
    }

    public void trackEvent(InputData inputData) {
        try {
            checkAppStart();
            this.mTrackEventProcessor.trackEvent(inputData);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public SAContextManager(SensorsDataAPI sensorsDataAPI, InternalConfigOptions internalConfigOptions) {
        try {
            this.mSensorsDataAPI = sensorsDataAPI;
            this.mInternalConfigs = internalConfigOptions;
            this.mContext = internalConfigOptions.context.getApplicationContext();
            DbAdapter.getInstance(this);
            this.mMessages = AnalyticsMessages.getInstance(this.mContext, sensorsDataAPI, this.mInternalConfigs);
            this.mTrackEventProcessor = new TrackEventProcessor(this);
            this.mFirstDay = PersistentLoader.getInstance().getFirstDayPst();
            this.mPluginManager = new PropertyPluginManager(sensorsDataAPI, this);
            SAStoreManager.getInstance().registerPlugins(this.mInternalConfigs.saConfigOptions.getStorePlugins(), this.mContext);
            SAStoreManager.getInstance().upgrade();
            executeDelayTask();
            SAModuleManager.getInstance().installService(this);
            SensorsDataRemoteManager sensorsDataRemoteManager = new SensorsDataRemoteManager(sensorsDataAPI, this);
            this.mRemoteManager = sensorsDataRemoteManager;
            sensorsDataRemoteManager.applySDKConfigFromCache();
            internalConfigOptions.context = this.mContext;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
