package com.sensorsdata.analytics.android.sdk;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.DefaultAppState;
import com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager;
import com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants;
import com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread;
import com.sensorsdata.analytics.android.sdk.data.SAProviderHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.exceptions.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.jsbridge.H5Helper;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

abstract class AbstractSensorsDataAPI implements ISensorsDataAPI {
    protected static final String TAG = "SA.SensorsDataAPI";
    static final String VERSION = "6.8.0";
    protected static SAConfigOptions mSAConfigOptions;
    protected static final Map<Context, SensorsDataAPI> sInstanceMap = new ConcurrentHashMap();
    protected SensorsDataDynamicSuperProperties mDynamicSuperPropertiesCallBack;
    protected List<Integer> mHeatMapActivities;
    protected InternalConfigOptions mInternalConfigs;
    protected final Object mLoginIdLock = new Object();
    protected String mOriginServerUrl;
    protected SAContextManager mSAContextManager;
    protected boolean mSDKConfigInit;
    protected String mServerUrl;
    protected TrackTaskManager mTrackTaskManager;
    protected TrackTaskManagerThread mTrackTaskManagerThread;
    protected List<Integer> mVisualizedAutoTrackActivities;

    public AbstractSensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, SensorsDataAPI.DebugMode debugMode) {
        InternalConfigOptions internalConfigOptions = new InternalConfigOptions();
        this.mInternalConfigs = internalConfigOptions;
        internalConfigOptions.context = context;
        setDebugMode(debugMode);
        this.mHeatMapActivities = new ArrayList();
        this.mVisualizedAutoTrackActivities = new ArrayList();
        try {
            mSAConfigOptions = sAConfigOptions.clone();
            PersistentLoader.preInit(context);
            this.mTrackTaskManager = TrackTaskManager.getInstance();
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread, ThreadNameConstants.THREAD_TASK_QUEUE).start();
            SensorsDataExceptionHandler.init();
            initSAConfig(mSAConfigOptions.mServerUrl);
            this.mSAContextManager = new SAContextManager((SensorsDataAPI) this, this.mInternalConfigs);
            registerLifecycleCallbacks((SensorsDataAPI) this, context);
            delayInitTask(context.getApplicationContext());
            SAProviderHelper.getInstance(context).migratingDB(context.getApplicationContext());
            enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, String.format(TimeUtils.SDK_LOCALE, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", new Object[]{this.mServerUrl, Integer.valueOf(mSAConfigOptions.mFlushInterval), debugMode}));
            }
            SensorsDataUtils.initUniAppStatus();
        } catch (Throwable th) {
            SALog.i(TAG, th.getMessage());
        }
    }

    public static SAConfigOptions getConfigOptions() {
        return mSAConfigOptions;
    }

    private static boolean isSDKDisableByLocal() {
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions != null) {
            return sAConfigOptions.isDisableSDK;
        }
        SALog.i(TAG, "SAConfigOptions is null");
        return true;
    }

    public static boolean isSDKDisabled() {
        if (isSDKDisableByLocal() || isSDKDisabledByRemote()) {
            return true;
        }
        return false;
    }

    private static boolean isSDKDisabledByRemote() {
        boolean isSDKDisabledByRemote = BaseSensorsDataSDKRemoteManager.isSDKDisabledByRemote();
        if (isSDKDisabledByRemote) {
            SALog.i(TAG, "remote config: SDK is disabled");
        }
        return isSDKDisabledByRemote;
    }

    private void registerLifecycleCallbacks(SensorsDataAPI sensorsDataAPI, Context context) {
        try {
            SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(AppStateTools.getInstance());
            AppStateTools.getInstance().addAppStateListener(new DefaultAppState(sensorsDataAPI));
            AppStateTools.getInstance().delayInit(context);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(SensorsDataLifecycleMonitorManager.getInstance().getCallback());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: private */
    public void registerObserver(Context context) {
        SensorsDataContentObserver sensorsDataContentObserver = new SensorsDataContentObserver();
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.registerContentObserver(DbParams.getInstance().getSessionTimeUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getLoginIdUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getDisableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getEnableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getUserIdentities(), false, sensorsDataContentObserver);
    }

    public void addEventListener(SAEventListener sAEventListener) {
        this.mSAContextManager.addEventListener(sAEventListener);
    }

    public void addFunctionListener(final SAFunctionListener sAFunctionListener) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                TrackMonitor.getInstance().addFunctionListener(sAFunctionListener);
            }
        });
    }

    public void addSAJSListener(SAJSListener sAJSListener) {
        H5Helper.addSAJSListener(sAJSListener);
    }

    /* access modifiers changed from: protected */
    public void applySAConfigOptions() {
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mInvokeLog) {
            enableLog(sAConfigOptions.mLogEnabled);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (!sAConfigOptions2.mVisualizedEnabled && sAConfigOptions2.mVisualizedPropertiesEnabled) {
            SALog.i(TAG, "The VisualizedProperties is enabled, and visualizedEnable is false");
            mSAConfigOptions.enableVisualizedAutoTrack(true);
        }
    }

    /* access modifiers changed from: protected */
    public void delayInitTask(final Context context) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    AbstractSensorsDataAPI.this.registerObserver(context);
                    AbstractSensorsDataAPI.this.registerNetworkListener(context);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        });
    }

    public SensorsDataAPI.DebugMode getDebugMode() {
        return this.mInternalConfigs.debugMode;
    }

    public JSONObject getDynamicProperty() {
        try {
            SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties = this.mDynamicSuperPropertiesCallBack;
            if (sensorsDataDynamicSuperProperties == null) {
                return null;
            }
            JSONObject dynamicSuperProperties = sensorsDataDynamicSuperProperties.getDynamicSuperProperties();
            SADataHelper.assertPropertyTypes(dynamicSuperProperties);
            return dynamicSuperProperties;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public SAContextManager getSAContextManager() {
        return this.mSAContextManager;
    }

    /* access modifiers changed from: protected */
    public void initSAConfig(String str) {
        boolean z10;
        Bundle appInfoBundle = AppInfoUtils.getAppInfoBundle(this.mInternalConfigs.context);
        if (mSAConfigOptions == null) {
            this.mSDKConfigInit = false;
            mSAConfigOptions = new SAConfigOptions(str);
        } else {
            this.mSDKConfigInit = true;
        }
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mInvokeLog) {
            enableLog(sAConfigOptions.mLogEnabled);
        } else {
            if (this.mInternalConfigs.debugMode != SensorsDataAPI.DebugMode.DEBUG_OFF) {
                z10 = true;
            } else {
                z10 = false;
            }
            enableLog(appInfoBundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", z10));
        }
        SALog.setDisableSDK(mSAConfigOptions.isDisableSDK);
        setServerUrl(str);
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (sAConfigOptions2.mFlushInterval == 0) {
            sAConfigOptions2.setFlushInterval(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushInterval", 15000));
        }
        SAConfigOptions sAConfigOptions3 = mSAConfigOptions;
        if (sAConfigOptions3.mFlushBulkSize == 0) {
            sAConfigOptions3.setFlushBulkSize(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100));
        }
        SAConfigOptions sAConfigOptions4 = mSAConfigOptions;
        if (sAConfigOptions4.mMaxCacheSize == 0) {
            sAConfigOptions4.setMaxCacheSize(33554432);
        }
        SAConfigOptions sAConfigOptions5 = mSAConfigOptions;
        if (!sAConfigOptions5.mInvokeHeatMapEnabled) {
            sAConfigOptions5.mHeatMapEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.HeatMap", false);
        }
        SAConfigOptions sAConfigOptions6 = mSAConfigOptions;
        if (!sAConfigOptions6.mInvokeVisualizedEnabled) {
            sAConfigOptions6.mVisualizedEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.VisualizedAutoTrack", false);
        }
        InternalConfigOptions internalConfigOptions = this.mInternalConfigs;
        internalConfigOptions.saConfigOptions = mSAConfigOptions;
        internalConfigOptions.isShowDebugView = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.ShowDebugInfoView", true);
        this.mInternalConfigs.isDefaultRemoteConfigEnable = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableDefaultRemoteConfig", false);
        InternalConfigOptions internalConfigOptions2 = this.mInternalConfigs;
        internalConfigOptions2.isMainProcess = AppInfoUtils.isMainProcess(internalConfigOptions2.context, appInfoBundle);
        this.mInternalConfigs.isTrackDeviceId = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableTrackDeviceId", false);
        if (mSAConfigOptions.getLimitKeys() != null) {
            SAPropertyManager.getInstance().registerLimitKeys(mSAConfigOptions.getLimitKeys());
        }
    }

    public boolean isDisableDefaultRemoteConfig() {
        return this.mInternalConfigs.isDefaultRemoteConfigEnable;
    }

    /* access modifiers changed from: package-private */
    public void registerNetworkListener(final Context context) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.registerNetworkListener(context);
            }
        });
    }

    public void removeEventListener(SAEventListener sAEventListener) {
        this.mSAContextManager.removeEventListener(sAEventListener);
    }

    public void removeFunctionListener(final SAFunctionListener sAFunctionListener) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    TrackMonitor.getInstance().removeFunctionListener(sAFunctionListener);
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void removeSAJSListener(SAJSListener sAJSListener) {
        H5Helper.removeSAJSListener(sAJSListener);
    }

    public void setDebugMode(SensorsDataAPI.DebugMode debugMode) {
        this.mInternalConfigs.debugMode = debugMode;
        if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
            enableLog(false);
            SALog.setDebug(false);
            this.mServerUrl = this.mOriginServerUrl;
            return;
        }
        enableLog(true);
        SALog.setDebug(true);
        setServerUrl(this.mOriginServerUrl);
    }

    /* access modifiers changed from: package-private */
    public void unregisterNetworkListener(final Context context) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.unregisterNetworkListener(context);
            }
        });
    }

    protected AbstractSensorsDataAPI() {
    }
}
