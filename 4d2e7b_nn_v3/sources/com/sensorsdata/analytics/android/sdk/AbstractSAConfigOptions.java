package com.sensorsdata.analytics.android.sdk;

import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

abstract class AbstractSAConfigOptions {
    public String[] channelSourceKeys;
    boolean isAutoAddChannelCallbackEvent;
    boolean isAutoTrackWebView;
    boolean isDisableSDK = false;
    boolean isSubProcessFlushData = false;
    boolean isWebViewSupportJellyBean;
    String mAnonymousId;
    int mAutoTrackEventType;
    String mCustomADChannelUrl;
    SensorsDataDeferredDeepLinkCallback mDeeplinkCallback;
    boolean mDisableAppEndTimer = false;
    boolean mDisableDebugAssistant;
    boolean mDisableDeviceId = false;
    boolean mDisableRandomTimeRequestRemoteConfig;
    boolean mEnableEncrypt = false;
    boolean mEnableSaveDeepLinkInfo = false;
    boolean mEnableSession = false;
    boolean mEnableTrackAppCrash;
    boolean mEnableTrackPush;
    List<SAEncryptListener> mEncryptors = new ArrayList();
    int mEventSessionTimeout;
    public SAExposureConfig mExposureConfig;
    int mFlushBulkSize;
    int mFlushInterval;
    boolean mHeatMapEnabled;
    List<Class<?>> mIgnorePageLeave;
    protected boolean mIsTrackFragmentPageLeave = false;
    protected boolean mIsTrackPageLeave = false;
    Map<String, String> mLimitKeys;
    List<String> mListInstantEvents;
    boolean mLogEnabled;
    long mMaxCacheSize = 33554432;
    int mMaxRequestInterval = 48;
    int mMinRequestInterval = 24;
    int mNetworkTypePolicy = 31;
    IPersistentSecretKey mPersistentSecretKey;
    List<SAPropertyPlugin> mPropertyPlugins;
    String mRemoteConfigUrl;
    SAAdvertisingConfig mSATConfig;
    SSLSocketFactory mSSLSocketFactory;
    String mServerUrl;
    List<StorePlugin> mStorePlugins;
    boolean mTrackScreenOrientationEnabled;
    boolean mTransportEncrypt = false;
    boolean mVisualizedEnabled;
    boolean mVisualizedPropertiesEnabled;

    AbstractSAConfigOptions() {
    }

    public SAAdvertisingConfig getAdvertConfig() {
        return this.mSATConfig;
    }

    public String getAnonymousId() {
        return this.mAnonymousId;
    }

    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    public String getCustomADChannelUrl() {
        return this.mCustomADChannelUrl;
    }

    public SensorsDataDeferredDeepLinkCallback getDeeplinkCallback() {
        return this.mDeeplinkCallback;
    }

    public List<SAEncryptListener> getEncryptors() {
        return this.mEncryptors;
    }

    public int getEventSessionTimeout() {
        return this.mEventSessionTimeout;
    }

    public int getFlushBulkSize() {
        return this.mFlushBulkSize;
    }

    public List<Class<?>> getIgnorePageLeave() {
        return this.mIgnorePageLeave;
    }

    public List<String> getInstantEvents() {
        return this.mListInstantEvents;
    }

    public Map<String, String> getLimitKeys() {
        return this.mLimitKeys;
    }

    public int getMaxRequestInterval() {
        return this.mMaxRequestInterval;
    }

    public int getMinRequestInterval() {
        return this.mMinRequestInterval;
    }

    public IPersistentSecretKey getPersistentSecretKey() {
        return this.mPersistentSecretKey;
    }

    public List<SAPropertyPlugin> getPropertyPlugins() {
        return this.mPropertyPlugins;
    }

    public String getRemoteConfigUrl() {
        return this.mRemoteConfigUrl;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mSSLSocketFactory;
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public List<StorePlugin> getStorePlugins() {
        return this.mStorePlugins;
    }

    public boolean isAutoAddChannelCallbackEvent() {
        return this.isAutoAddChannelCallbackEvent;
    }

    public boolean isAutoTrackWebView() {
        return this.isAutoTrackWebView;
    }

    @Deprecated
    public boolean isDataCollectEnable() {
        return true;
    }

    public boolean isDisableAppEndTimer() {
        return this.mDisableAppEndTimer;
    }

    public boolean isDisableDebugAssistant() {
        return this.mDisableDebugAssistant;
    }

    public boolean isDisableDeviceId() {
        return this.mDisableDeviceId;
    }

    public boolean isDisableRandomTimeRequestRemoteConfig() {
        return this.mDisableRandomTimeRequestRemoteConfig;
    }

    public boolean isDisableSDK() {
        return this.isDisableSDK;
    }

    public boolean isEnableEncrypt() {
        return this.mEnableEncrypt;
    }

    public boolean isEnableSession() {
        return this.mEnableSession;
    }

    public boolean isEnableTrackPush() {
        return this.mEnableTrackPush;
    }

    public boolean isMultiProcessFlush() {
        return this.isSubProcessFlushData;
    }

    public boolean isSaveDeepLinkInfo() {
        return this.mEnableSaveDeepLinkInfo;
    }

    public boolean isTrackFragmentPageLeave() {
        if (!this.mIsTrackPageLeave || !this.mIsTrackFragmentPageLeave) {
            return false;
        }
        return true;
    }

    public boolean isTrackPageLeave() {
        return this.mIsTrackPageLeave;
    }

    public boolean isTransportEncrypt() {
        return this.mTransportEncrypt;
    }

    public boolean isVisualizedPropertiesEnabled() {
        return this.mVisualizedPropertiesEnabled;
    }

    public boolean isWebViewSupportJellyBean() {
        return this.isWebViewSupportJellyBean;
    }
}
