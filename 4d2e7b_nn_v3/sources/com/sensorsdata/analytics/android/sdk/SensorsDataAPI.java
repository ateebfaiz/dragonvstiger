package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer;
import com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI;
import com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataAPI extends AbstractSensorsDataAPI {
    public static String ANDROID_PLUGIN_VERSION = "";
    static final String MIN_PLUGIN_VERSION = "3.5.2";
    static final String VERSION = "6.8.0";
    public static final int VTRACK_SUPPORTED_MIN_API = 16;

    public enum AutoTrackEventType {
        APP_START(1),
        APP_END(2),
        APP_CLICK(4),
        APP_VIEW_SCREEN(8);
        
        public final int eventValue;

        private AutoTrackEventType(int i10) {
            this.eventValue = i10;
        }

        public static String autoTrackEventName(int i10) {
            if (i10 == 1) {
                return "$AppStart";
            }
            if (i10 == 2) {
                return "$AppEnd";
            }
            if (i10 == 4) {
                return "$AppClick";
            }
            if (i10 != 8) {
                return "";
            }
            return "$AppViewScreen";
        }

        /* access modifiers changed from: package-private */
        public int getEventValue() {
            return this.eventValue;
        }
    }

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);
        
        private final boolean debugMode;
        private final boolean debugWriteData;

        private DebugMode(boolean z10, boolean z11) {
            this.debugMode = z10;
            this.debugWriteData = z11;
        }

        public boolean isDebugMode() {
            return this.debugMode;
        }

        /* access modifiers changed from: package-private */
        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 16;
        public static final int TYPE_ALL = 255;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
        }
    }

    SensorsDataAPI() {
    }

    public static void disableSDK() {
        SALog.i("SA.SensorsDataAPI", "call static function disableSDK");
        try {
            SensorsDataAPI sDKInstance = getSDKInstance();
            if (sDKInstance instanceof SensorsDataAPIEmptyImplementation) {
                return;
            }
            if (AbstractSensorsDataAPI.getConfigOptions() != null) {
                SensorsDataContentObserver.State state = SensorsDataContentObserver.State.DISABLE_SDK;
                if (!state.isObserverCalled) {
                    sDKInstance.track("$AppDataTrackingClose");
                    sDKInstance.flush();
                }
                sDKInstance.unregisterNetworkListener(sDKInstance.getSAContextManager().getContext());
                sDKInstance.clearTrackTimer();
                SAModuleManager.getInstance().setModuleState(false);
                DbAdapter.getInstance().commitAppStartTime(0);
                AbstractSensorsDataAPI.getConfigOptions().disableSDK(true);
                SALog.setDisableSDK(true);
                if (!state.isObserverCalled) {
                    sDKInstance.getSAContextManager().getContext().getContentResolver().notifyChange(DbParams.getInstance().getDisableSDKUri(), (ContentObserver) null);
                }
                state.isObserverCalled = false;
                state.isDid = true;
                SensorsDataContentObserver.State.ENABLE_SDK.isDid = false;
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void enableSDK() {
        SALog.i("SA.SensorsDataAPI", "call static function enableSDK");
        try {
            SensorsDataAPI sDKInstance = getSDKInstance();
            if (sDKInstance instanceof SensorsDataAPIEmptyImplementation) {
                return;
            }
            if (AbstractSensorsDataAPI.getConfigOptions() != null) {
                AbstractSensorsDataAPI.getConfigOptions().disableSDK(false);
                SAModuleManager.getInstance().setModuleState(true);
                try {
                    SALog.setDisableSDK(false);
                    sDKInstance.enableLog(SALog.isLogEnabled());
                    SALog.i("SA.SensorsDataAPI", "enableSDK, enable log");
                    if (PersistentLoader.getInstance().getFirstDayPst().get() == null) {
                        PersistentLoader.getInstance().getFirstDayPst().commit(TimeUtils.formatTime(System.currentTimeMillis(), TimeUtils.YYYY_MM_DD));
                    }
                    sDKInstance.mSAContextManager.getRemoteManager().pullSDKConfigFromServer();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
                SensorsDataContentObserver.State state = SensorsDataContentObserver.State.ENABLE_SDK;
                if (!state.isObserverCalled) {
                    sDKInstance.getSAContextManager().getContext().getContentResolver().notifyChange(DbParams.getInstance().getEnableSDKUri(), (ContentObserver) null);
                }
                state.isObserverCalled = false;
                state.isDid = true;
                SensorsDataContentObserver.State.DISABLE_SDK.isDid = false;
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized com.sensorsdata.analytics.android.sdk.SensorsDataAPI getInstance(android.content.Context r4, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode r5, com.sensorsdata.analytics.android.sdk.SAConfigOptions r6) {
        /*
            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataAPI> r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.class
            monitor-enter(r0)
            if (r4 != 0) goto L_0x000e
            com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation r4 = new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation     // Catch:{ all -> 0x000c }
            r4.<init>()     // Catch:{ all -> 0x000c }
            monitor-exit(r0)
            return r4
        L_0x000c:
            r4 = move-exception
            goto L_0x0026
        L_0x000e:
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ all -> 0x000c }
            java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI> r2 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.sInstanceMap     // Catch:{ all -> 0x000c }
            java.lang.Object r3 = r2.get(r1)     // Catch:{ all -> 0x000c }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = (com.sensorsdata.analytics.android.sdk.SensorsDataAPI) r3     // Catch:{ all -> 0x000c }
            if (r3 != 0) goto L_0x0024
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r3 = new com.sensorsdata.analytics.android.sdk.SensorsDataAPI     // Catch:{ all -> 0x000c }
            r3.<init>(r4, r6, r5)     // Catch:{ all -> 0x000c }
            r2.put(r1, r3)     // Catch:{ all -> 0x000c }
        L_0x0024:
            monitor-exit(r0)
            return r3
        L_0x0026:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getInstance(android.content.Context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode, com.sensorsdata.analytics.android.sdk.SAConfigOptions):com.sensorsdata.analytics.android.sdk.SensorsDataAPI");
    }

    private static SensorsDataAPI getSDKInstance() {
        Map<Context, SensorsDataAPI> map = AbstractSensorsDataAPI.sInstanceMap;
        if (map.size() > 0) {
            Iterator<SensorsDataAPI> it = map.values().iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return new SensorsDataAPIEmptyImplementation();
    }

    public static SensorsDataAPI sharedInstance(Context context) {
        try {
            if (AbstractSensorsDataAPI.isSDKDisabled()) {
                return new SensorsDataAPIEmptyImplementation();
            }
            if (context == null) {
                return new SensorsDataAPIEmptyImplementation();
            }
            SensorsDataAPI sensorsDataAPI = AbstractSensorsDataAPI.sInstanceMap.get(context.getApplicationContext());
            if (sensorsDataAPI != null) {
                return sensorsDataAPI;
            }
            SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
            return new SensorsDataAPIEmptyImplementation();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new SensorsDataAPIEmptyImplementation();
        }
    }

    public static void startWithConfigOptions(Context context, SAConfigOptions sAConfigOptions) {
        if (context == null || sAConfigOptions == null) {
            throw new NullPointerException("Context、SAConfigOptions can not be null");
        }
        try {
            SensorsDataAPI instance = getInstance(context, DebugMode.DEBUG_OFF, sAConfigOptions);
            if (!instance.mSDKConfigInit) {
                instance.applySAConfigOptions();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public /* bridge */ /* synthetic */ void addEventListener(SAEventListener sAEventListener) {
        super.addEventListener(sAEventListener);
    }

    public void addExposureView(View view, SAExposureData sAExposureData) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Exposure.MODULE_NAME, Modules.Exposure.METHOD_ADD_EXPOSURE_VIEW, view, sAExposureData);
    }

    public /* bridge */ /* synthetic */ void addFunctionListener(SAFunctionListener sAFunctionListener) {
        super.addFunctionListener(sAFunctionListener);
    }

    public void addHeatMapActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mHeatMapActivities.contains(Integer.valueOf(hashCode))) {
                                this.mHeatMapActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void addHeatMapActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mHeatMapActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public /* bridge */ /* synthetic */ void addSAJSListener(SAJSListener sAJSListener) {
        super.addSAJSListener(sAJSListener);
    }

    public void addVisualizedAutoTrackActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(hashCode))) {
                                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void addVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void bind(final String str, final String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().bindBack(str, str2)) {
                            SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventName(IUserIdentityAPI.BIND_ID).setEventType(EventType.TRACK_ID_BIND));
                        }
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void clearGPSLocation() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mInternalConfigs.gpsLocation = null;
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void clearLastScreenUrl() {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_CLEAR_LAST_SCREENURL, new Object[0]);
    }

    public void clearReferrerWhenAppEnd() {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_CLEAR_REFERRER_WHEN_APPEND, new Object[0]);
    }

    public void clearSuperProperties() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                PersistentLoader.getInstance().getSuperPropertiesPst().commit(new JSONObject());
            }
        });
    }

    public void clearTrackTimer() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                EventTimerManager.getInstance().clearTimers();
            }
        });
    }

    public void deleteAll() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.mSAContextManager.getAnalyticsMessages().deleteAll();
            }
        });
    }

    public void disableAutoTrack(List<AutoTrackEventType> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK, list);
    }

    public void enableAutoTrack(List<AutoTrackEventType> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_ENABLE_AUTO_TRACK, list);
    }

    public void enableAutoTrackFragment(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENT, cls);
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENTS, list);
    }

    public void enableDeepLinkInstallSource(boolean z10) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_ENABLE_DEEPLINK_INSTALL_SOURCE, Boolean.valueOf(z10));
    }

    public void enableLog(boolean z10) {
        SALog.setEnableLog(z10);
    }

    public void enableNetworkRequest(boolean z10) {
        this.mInternalConfigs.isNetworkRequestEnable = z10;
    }

    public void enableRemoteConfig(boolean z10) {
        try {
            SAContextManager sAContextManager = this.mSAContextManager;
            if (sAContextManager != null) {
                this.mInternalConfigs.isRemoteConfigEnabled = z10;
                if (sAContextManager.getRemoteManager() != null) {
                    this.mSAContextManager.getRemoteManager().pullSDKConfigFromServer();
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void enableTrackScreenOrientation(boolean z10) {
        if (z10) {
            try {
                if (this.mSAContextManager.getOrientationDetector() == null) {
                    this.mSAContextManager.setOrientationDetector(new SensorsDataScreenOrientationDetector(this.mInternalConfigs.context, 3));
                }
                this.mSAContextManager.getOrientationDetector().enable();
                this.mSAContextManager.getOrientationDetector().setState(true);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        } else if (this.mSAContextManager.getOrientationDetector() != null) {
            this.mSAContextManager.getOrientationDetector().disable();
            this.mSAContextManager.getOrientationDetector().setState(false);
            this.mSAContextManager.setOrientationDetector((SensorsDataScreenOrientationDetector) null);
        }
    }

    public void flush() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.getAnalyticsMessages().flush();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void flushScheduled() {
        try {
            this.mSAContextManager.getAnalyticsMessages().flushScheduled();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void flushSync() {
        flush();
    }

    public String getAnonymousId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getAnonymousId();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public String getCookie(boolean z10) {
        if (!z10) {
            return this.mInternalConfigs.cookie;
        }
        try {
            return URLDecoder.decode(this.mInternalConfigs.cookie, "UTF-8");
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ DebugMode getDebugMode() {
        return super.getDebugMode();
    }

    public String getDistinctId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getDistinctId();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public /* bridge */ /* synthetic */ JSONObject getDynamicProperty() {
        return super.getDynamicProperty();
    }

    public int getFlushBulkSize() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mFlushBulkSize;
    }

    public int getFlushInterval() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mFlushInterval;
    }

    public JSONObject getIdentities() {
        try {
            JSONObject identities = this.mSAContextManager.getUserIdentityAPI().getIdentities();
            if (identities != null) {
                return new JSONObject(identities.toString());
            }
            return null;
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public List<Class<?>> getIgnoredViewTypeList() {
        try {
            return (List) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_GET_IGNORED_VIEW_TYPE_LIST, new Object[0]);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public JSONObject getLastScreenTrackProperties() {
        return (JSONObject) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_GET_LAST_SCREEN_TRACK_PROPERTIES, new Object[0]);
    }

    public String getLastScreenUrl() {
        return (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_GET_LAST_SCREENURL, new Object[0]);
    }

    public String getLoginId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getLoginId();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public long getMaxCacheSize() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mMaxCacheSize;
    }

    public JSONObject getPresetProperties() {
        JSONObject jSONObject = new JSONObject();
        try {
            SAPropertyPlugin propertyPlugin = this.mSAContextManager.getPluginManager().getPropertyPlugin(SAPresetPropertyPlugin.class.getName());
            if (propertyPlugin instanceof SAPresetPropertyPlugin) {
                jSONObject = ((SAPresetPropertyPlugin) propertyPlugin).getPresetProperties();
            }
            jSONObject.put("$is_first_day", getSAContextManager().isFirstDay(System.currentTimeMillis()));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }

    public /* bridge */ /* synthetic */ SAContextManager getSAContextManager() {
        return super.getSAContextManager();
    }

    public String getSDKVersion() {
        return "6.8.0";
    }

    public String getScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                return this.mSAContextManager.getOrientationDetector().getOrientation();
            }
            return null;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public int getSessionIntervalTime() {
        return this.mInternalConfigs.sessionTime;
    }

    public JSONObject getSuperProperties() {
        JSONObject jSONObject;
        synchronized (PersistentSuperProperties.class) {
            try {
                jSONObject = new JSONObject(JSONUtils.cloneJsonObject((JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get()).toString());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return new JSONObject();
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    public void identify(final String str) {
        try {
            SADataHelper.assertDistinctId(str);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().identify(str);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITIES, list);
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITY, cls);
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENT, cls);
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENTS, list);
    }

    public void ignoreView(View view) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_VIEW, view);
    }

    public void ignoreViewType(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_VIEW_TYPE, cls);
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPCLICK_IGNORED, cls);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPVIEWSCREEN_IGNORED, cls);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean isAutoTrackEnabled() {
        Boolean bool;
        try {
            if (!AbstractSensorsDataAPI.isSDKDisabled() && (bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_AUTOTRACK_ENABLED, new Object[0])) != null && bool.booleanValue()) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public boolean isAutoTrackEventTypeIgnored(AutoTrackEventType autoTrackEventType) {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED, autoTrackEventType);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean isDebugMode() {
        return this.mInternalConfigs.debugMode.isDebugMode();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDefaultRemoteConfig() {
        return super.isDisableDefaultRemoteConfig();
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_FRAGMENT_AUTOTRACK_APPVIEWSCREEN, cls);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean isHeatMapActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            if (this.mHeatMapActivities.size() != 0 && !this.mHeatMapActivities.contains(Integer.valueOf(cls.hashCode()))) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public boolean isHeatMapEnabled() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mHeatMapEnabled;
    }

    public boolean isNetworkRequestEnable() {
        return this.mInternalConfigs.isNetworkRequestEnable;
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_TRACK_FRAGMENT_APPVIEWSCREEN_ENABLED, new Object[0]);
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public boolean isVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            if (this.mVisualizedAutoTrackActivities.size() != 0 && !this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(cls.hashCode()))) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public boolean isVisualizedAutoTrackEnabled() {
        SAConfigOptions sAConfigOptions = AbstractSensorsDataAPI.mSAConfigOptions;
        if (sAConfigOptions.mVisualizedEnabled || sAConfigOptions.mVisualizedPropertiesEnabled) {
            return true;
        }
        return false;
    }

    public void itemDelete(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setItemId(str2).setItemType(str).setEventType(EventType.ITEM_DELETE));
            }
        });
    }

    public void itemSet(final String str, final String str2, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setItemId(str2).setItemType(str).setEventType(EventType.ITEM_SET).setProperties(cloneJsonObject));
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void login(String str) {
        login(str, (JSONObject) null);
    }

    public void loginWithKey(String str, String str2) {
        loginWithKey(str, str2, (JSONObject) null);
    }

    public void logout() {
        synchronized (this.mLoginIdLock) {
            this.mSAContextManager.getUserIdentityAPI().updateLoginId((String) null, (String) null);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().logout();
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        }
    }

    public void profileAppend(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_APPEND).setProperties(jSONObject));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileDelete() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_DELETE));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileIncrement(final Map<String, ? extends Number> map) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_INCREMENT).setProperties(new JSONObject(map)));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profilePushId(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (SADataHelper.assertPropertyKey(str)) {
                        String str = SensorsDataAPI.this.getDistinctId() + str2;
                        if (!TextUtils.equals(DbAdapter.getInstance().getPushId("distinctId_" + str), str)) {
                            SensorsDataAPI.this.profileSet(str, str2);
                            DbAdapter.getInstance().commitPushID("distinctId_" + str, str);
                        }
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileSet(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_SET).setProperties(cloneJsonObject));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void profileSetOnce(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_SET_ONCE).setProperties(cloneJsonObject));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void profileUnset(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_UNSET).setProperties(new JSONObject().put(str, true)));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileUnsetPushId(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (SADataHelper.assertPropertyKey(str)) {
                        String distinctId = SensorsDataAPI.this.getDistinctId();
                        String str = "distinctId_" + str;
                        String pushId = DbAdapter.getInstance().getPushId(str);
                        if (!TextUtils.isEmpty(pushId) && pushId.startsWith(distinctId)) {
                            SensorsDataAPI.this.profileUnset(str);
                            DbAdapter.getInstance().removePushId(str);
                        }
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
        this.mDynamicSuperPropertiesCallBack = sensorsDataDynamicSuperProperties;
    }

    public void registerLimitKeys(Map<String, String> map) {
        SAPropertyManager.getInstance().registerLimitKeys(map);
    }

    public void registerPropertyPlugin(final SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mSAContextManager.getPluginManager().registerPropertyPlugin(sAPropertyPlugin);
                }
            });
        }
    }

    public void registerSuperProperties(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (cloneJsonObject != null) {
                            PersistentLoader.getInstance().getSuperPropertiesPst().commit(JSONUtils.mergeSuperJSONObject(cloneJsonObject, JSONUtils.cloneJsonObject((JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get())));
                        }
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public /* bridge */ /* synthetic */ void removeEventListener(SAEventListener sAEventListener) {
        super.removeEventListener(sAEventListener);
    }

    public void removeExposureView(View view, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Exposure.MODULE_NAME, Modules.Exposure.METHOD_REMOVE_EXPOSURE_VIEW, view, str);
    }

    public /* bridge */ /* synthetic */ void removeFunctionListener(SAFunctionListener sAFunctionListener) {
        super.removeFunctionListener(sAFunctionListener);
    }

    public /* bridge */ /* synthetic */ void removeSAJSListener(SAJSListener sAJSListener) {
        super.removeSAJSListener(sAJSListener);
    }

    public void removeTimer(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertEventName(str);
                    EventTimerManager.getInstance().removeTimer(str);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void requestDeferredDeepLink(JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_REQUEST_DEFERRED_DEEPLINK, jSONObject);
    }

    public void resetAnonymousId() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().resetAnonymousId();
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void resetAnonymousIdentity(final String str) {
        TrackTaskManager trackTaskManager = this.mTrackTaskManager;
        if (trackTaskManager != null) {
            trackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().resetAnonymousIdentity(str);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        }
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITIES, list);
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITY, cls);
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENT, cls);
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENTS, list);
    }

    public void resumeTrackScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                this.mSAContextManager.getOrientationDetector().enable();
                this.mSAContextManager.getOrientationDetector().setState(true);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void setCookie(String str, boolean z10) {
        if (z10) {
            try {
                this.mInternalConfigs.cookie = URLEncoder.encode(str, "UTF-8");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        } else {
            this.mInternalConfigs.cookie = str;
        }
    }

    public /* bridge */ /* synthetic */ void setDebugMode(DebugMode debugMode) {
        super.setDebugMode(debugMode);
    }

    @Deprecated
    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_SET_DEEPLINK_CALLBACK, sensorsDataDeepLinkCallback);
    }

    public void setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_SET_DEEPLINK_COMPLETION, sensorsDataDeferredDeepLinkCallback);
    }

    public void setExposureIdentifier(View view, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Exposure.MODULE_NAME, Modules.Exposure.METHOD_SET_EXPOSURE_IDENTIFIER, view, str);
    }

    public void setFlushBulkSize(int i10) {
        if (i10 < 0) {
            SALog.i("SA.SensorsDataAPI", "The value of flushBulkSize is invalid");
        }
        AbstractSensorsDataAPI.mSAConfigOptions.setFlushBulkSize(i10);
    }

    public void setFlushInterval(int i10) {
        AbstractSensorsDataAPI.mSAConfigOptions.setFlushInterval(i10);
    }

    public void setFlushNetworkPolicy(int i10) {
        AbstractSensorsDataAPI.mSAConfigOptions.setNetworkTypePolicy(i10);
    }

    public void setGPSLocation(double d10, double d11) {
        setGPSLocation(d10, d11, (String) null);
    }

    public void setMaxCacheSize(long j10) {
        AbstractSensorsDataAPI.mSAConfigOptions.setMaxCacheSize(j10);
    }

    public void setServerUrl(String str) {
        setServerUrl(str, false);
    }

    public void setSessionIntervalTime(int i10) {
        if (DbAdapter.getInstance() == null) {
            SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
        } else if (i10 < 10000 || i10 > 300000) {
            SALog.i("SA.SensorsDataAPI", "SessionIntervalTime:" + i10 + " is invalid, session interval time is between 10s and 300s.");
        } else {
            InternalConfigOptions internalConfigOptions = this.mInternalConfigs;
            if (i10 != internalConfigOptions.sessionTime) {
                internalConfigOptions.sessionTime = i10;
                DbAdapter.getInstance().commitSessionIntervalTime(i10);
            }
        }
    }

    public void setTrackEventCallBack(SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
        this.mInternalConfigs.sensorsDataTrackEventCallBack = sensorsDataTrackEventCallBack;
    }

    public void setViewActivity(View view, Activity activity) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_ACTIVITY, view, activity);
    }

    public void setViewFragmentName(View view, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_FRAGMENT_NAME, view, str);
    }

    public void setViewID(View view, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_ID, view, str);
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_PROPERTIES, view, jSONObject);
    }

    public void showUpWebView(WebView webView, boolean z10) {
        showUpWebView(webView, z10, (JSONObject) null);
    }

    @Deprecated
    public void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z10, boolean z11) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.WebView.MODULE_NAME, Modules.WebView.METHOD_SHOWUP_X5WEBVIEW, obj, jSONObject, Boolean.valueOf(z10), Boolean.valueOf(z11));
    }

    public void startTrackThread() {
        TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread == null || trackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread).start();
            SALog.i("SA.SensorsDataAPI", "Data collection thread has been started");
        }
    }

    public void stopTrackScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                this.mSAContextManager.getOrientationDetector().disable();
                this.mSAContextManager.getOrientationDetector().setState(false);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void stopTrackThread() {
        TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread != null && !trackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread.stop();
            SALog.i("SA.SensorsDataAPI", "Data collection thread has been stopped");
        }
    }

    public void track(final String str, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            JSONUtils.mergeDistinctProperty(JSONUtils.cloneJsonObject(getDynamicProperty()), cloneJsonObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        JSONObject jSONObject = (JSONObject) SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_MERGE_CHANNEL_EVENT_PROPERTIES, str, cloneJsonObject);
                        if (jSONObject == null) {
                            jSONObject = cloneJsonObject;
                        }
                        SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventName(str).setEventType(EventType.TRACK).setProperties(jSONObject));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z10) {
        trackInstallation("$AppInstall", jSONObject, z10);
    }

    public void trackChannelEvent(String str) {
        trackChannelEvent(str, (JSONObject) null);
    }

    public void trackDeepLinkLaunch(String str) {
        trackDeepLinkLaunch(str, (String) null);
    }

    public void trackFragmentAppViewScreen() {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_FRAGMENT_APPVIEWSCREEN, new Object[0]);
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z10) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_TRACK_INSTALLATION, str, jSONObject, Boolean.valueOf(z10));
    }

    @Deprecated
    public void trackTimer(String str, TimeUnit timeUnit) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final TimeUnit timeUnit2 = timeUnit;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertEventName(str2);
                    EventTimerManager.getInstance().addEventTimer(str2, new EventTimer(timeUnit2, elapsedRealtime));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void trackTimerEnd(String str, JSONObject jSONObject) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            final String str2 = str;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    if (str2 != null) {
                        EventTimerManager.getInstance().updateEndTime(str2, elapsedRealtime);
                    }
                    try {
                        JSONObject jSONObject = (JSONObject) SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_MERGE_CHANNEL_EVENT_PROPERTIES, str2, cloneJsonObject);
                        if (jSONObject == null) {
                            jSONObject = cloneJsonObject;
                        }
                        SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventName(str2).setEventType(EventType.TRACK).setProperties(jSONObject));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void trackTimerPause(final String str) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                EventTimerManager.getInstance().updateTimerState(str, elapsedRealtime, true);
            }
        });
    }

    public void trackTimerResume(final String str) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                EventTimerManager.getInstance().updateTimerState(str, elapsedRealtime, false);
            }
        });
    }

    public String trackTimerStart(String str) {
        try {
            String format = String.format("%s_%s_%s", new Object[]{str, UUID.randomUUID().toString().replace("-", "_"), "SATimer"});
            TimeUnit timeUnit = TimeUnit.SECONDS;
            trackTimer(format, timeUnit);
            trackTimer(str, timeUnit);
            return format;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public void trackViewAppClick(View view) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK, view);
    }

    @Deprecated
    public void trackViewScreen(String str, JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, str, jSONObject);
    }

    public void unbind(final String str, final String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().unbindBack(str, str2)) {
                            SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventName(IUserIdentityAPI.UNBIND_ID).setEventType(EventType.TRACK_ID_UNBIND));
                        }
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void unregisterPropertyPlugin(final SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(sAPropertyPlugin);
                }
            });
        }
    }

    public void unregisterSuperProperty(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONObject cloneJsonObject = JSONUtils.cloneJsonObject((JSONObject) PersistentLoader.getInstance().getSuperPropertiesPst().get());
                    cloneJsonObject.remove(str);
                    PersistentLoader.getInstance().getSuperPropertiesPst().commit(cloneJsonObject);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void updateExposureProperties(View view, JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Exposure.MODULE_NAME, Modules.Exposure.METHOD_UPDATE_EXPOSURE_PROPERTIES, view, jSONObject);
    }

    SensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, DebugMode debugMode) {
        super(context, sAConfigOptions, debugMode);
    }

    public void disableAutoTrack(AutoTrackEventType autoTrackEventType) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK, autoTrackEventType);
    }

    public void ignoreView(View view, boolean z10) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IGNORE_VIEW, view, Boolean.valueOf(z10));
    }

    public void login(String str, JSONObject jSONObject) {
        loginWithKey(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str, jSONObject);
    }

    public void loginWithKey(final String str, final String str2, JSONObject jSONObject) {
        try {
            SensorsDataContentObserver.State.LOGIN.isDid = true;
            SensorsDataContentObserver.State.LOGOUT.isDid = false;
            synchronized (this.mLoginIdLock) {
                final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
                if (!LoginIDAndKey.isInValidLogin(str, str2, this.mSAContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), this.mSAContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginId(), getAnonymousId())) {
                    this.mSAContextManager.getUserIdentityAPI().updateLoginId(str, str2);
                }
                this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                    public void run() {
                        try {
                            if (SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().loginWithKeyBack(str, str2)) {
                                SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventName("$SignUp").setEventType(EventType.TRACK_SIGNUP).setProperties(cloneJsonObject));
                            }
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }
                });
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void profileAppend(final String str, final Set<String> set) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : set) {
                        jSONArray.put(put);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_APPEND).setProperties(jSONObject));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileIncrement(final String str, final Number number) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_INCREMENT).setProperties(new JSONObject().put(str, number)));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void removeExposureView(View view) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Exposure.MODULE_NAME, Modules.Exposure.METHOD_REMOVE_EXPOSURE_VIEW, view);
    }

    public void setGPSLocation(double d10, double d11, String str) {
        try {
            final double d12 = d10;
            final double d13 = d11;
            final String str2 = str;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        InternalConfigOptions internalConfigOptions = SensorsDataAPI.this.mInternalConfigs;
                        if (internalConfigOptions.gpsLocation == null) {
                            internalConfigOptions.gpsLocation = new SensorsDataGPSLocation();
                        }
                        SensorsDataAPI.this.mInternalConfigs.gpsLocation.setLatitude((long) (d12 * Math.pow(10.0d, 6.0d)));
                        SensorsDataAPI.this.mInternalConfigs.gpsLocation.setLongitude((long) (d13 * Math.pow(10.0d, 6.0d)));
                        SensorsDataAPI.this.mInternalConfigs.gpsLocation.setCoordinate(SADataHelper.assertPropertyValue(str2));
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void setServerUrl(final String str, boolean z10) {
        if (z10) {
            try {
                if (this.mSAContextManager.getRemoteManager() != null) {
                    try {
                        this.mSAContextManager.getRemoteManager().requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return;
            }
        }
        if (!TextUtils.equals(str, this.mOriginServerUrl)) {
            try {
                SAModuleManager.getInstance().invokeModuleFunction(Modules.Visual.MODULE_NAME, Modules.Visual.METHOD_REQUEST_VISUAL_CONFIG, new Object[0]);
            } catch (Exception e12) {
                SALog.printStackTrace(e12);
            }
        }
        this.mOriginServerUrl = str;
        if (TextUtils.isEmpty(str)) {
            this.mServerUrl = str;
            AbstractSensorsDataAPI.mSAConfigOptions.mServerUrl = str;
            SALog.i("SA.SensorsDataAPI", "Server url is null or empty.");
            return;
        }
        final Uri parse = Uri.parse(str);
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && host.contains("_")) {
                    SALog.i("SA.SensorsDataAPI", "Server url " + str + " contains '_' is not recommend，see details: https://en.wikipedia.org/wiki/Hostname");
                }
            }
        });
        if (this.mInternalConfigs.debugMode != DebugMode.DEBUG_OFF) {
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path)) {
                int lastIndexOf = path.lastIndexOf(47);
                if (lastIndexOf != -1) {
                    this.mServerUrl = parse.buildUpon().path(path.substring(0, lastIndexOf) + "/debug").build().toString();
                }
            } else {
                return;
            }
        } else {
            this.mServerUrl = str;
        }
        AbstractSensorsDataAPI.mSAConfigOptions.mServerUrl = this.mServerUrl;
        TrackMonitor.getInstance().callSetServerUrl();
    }

    public void setViewID(Dialog dialog, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_ID, dialog, str);
    }

    public void showUpWebView(WebView webView, boolean z10, boolean z11) {
        showUpWebView(webView, (JSONObject) null, z10, z11);
    }

    public void trackAppInstall(JSONObject jSONObject) {
        trackAppInstall(jSONObject, false);
    }

    public void trackChannelEvent(String str, JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_TRACK_CHANNEL_EVENT, str, jSONObject);
    }

    public void trackDeepLinkLaunch(String str, String str2) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.Advert.MODULE_NAME, Modules.Advert.METHOD_TRACK_DEEPLINK_LAUNCH, str, str2);
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
        trackInstallation(str, jSONObject, false);
    }

    public void trackViewAppClick(View view, JSONObject jSONObject) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK, view, jSONObject);
    }

    public void trackViewScreen(Activity activity) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, activity);
    }

    public boolean isAutoTrackEventTypeIgnored(int i10) {
        Boolean bool = (Boolean) SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED, Integer.valueOf(i10));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public void setViewID(Object obj, String str) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_SET_VIEW_ID, obj, str);
    }

    @Deprecated
    public void showUpWebView(WebView webView, JSONObject jSONObject, boolean z10, boolean z11) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.WebView.MODULE_NAME, Modules.WebView.METHOD_SHOWUP_WEBVIEW, webView, jSONObject, Boolean.valueOf(z10), Boolean.valueOf(z11));
    }

    public void trackAppInstall() {
        trackAppInstall((JSONObject) null, false);
    }

    public void trackInstallation(String str) {
        trackInstallation(str, (JSONObject) null, false);
    }

    public void trackViewScreen(Object obj) {
        SAModuleManager.getInstance().invokeModuleFunction(Modules.AutoTrack.MODULE_NAME, Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, obj);
    }

    public void profileSet(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_SET).setProperties(new JSONObject().put(str, obj)));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void profileSetOnce(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mSAContextManager.trackEvent(new InputData().setEventType(EventType.PROFILE_SET_ONCE).setProperties(new JSONObject().put(str, obj)));
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public void showUpX5WebView(Object obj, boolean z10) {
        showUpX5WebView(obj, (JSONObject) null, true, z10);
    }

    public void showUpX5WebView(Object obj) {
        showUpX5WebView(obj, false);
    }

    public void track(String str) {
        track(str, (JSONObject) null);
    }

    public void trackTimerEnd(String str) {
        trackTimerEnd(str, (JSONObject) null);
    }

    @Deprecated
    public void showUpWebView(WebView webView, boolean z10, JSONObject jSONObject) {
        showUpWebView(webView, jSONObject, z10, false);
    }

    public static SensorsDataAPI sharedInstance() {
        try {
            if (AbstractSensorsDataAPI.isSDKDisabled()) {
                return new SensorsDataAPIEmptyImplementation();
            }
            return getSDKInstance();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return new SensorsDataAPIEmptyImplementation();
        }
    }
}
