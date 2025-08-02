package com.sensorsdata.analytics.android.sdk;

import android.text.TextUtils;
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

public final class SAConfigOptions extends AbstractSAConfigOptions implements Cloneable {
    boolean mInvokeHeatMapEnabled;
    boolean mInvokeLog;
    boolean mInvokeVisualizedEnabled;

    private SAConfigOptions() {
    }

    public SAConfigOptions disableAppEndTimer() {
        this.mDisableAppEndTimer = true;
        return this;
    }

    public SAConfigOptions disableDebugAssistant() {
        this.mDisableDebugAssistant = true;
        return this;
    }

    public SAConfigOptions disableDeviceId() {
        this.mDisableDeviceId = true;
        return this;
    }

    public SAConfigOptions disableRandomTimeRequestRemoteConfig() {
        this.mDisableRandomTimeRequestRemoteConfig = true;
        return this;
    }

    public SAConfigOptions disableSDK(boolean z10) {
        this.isDisableSDK = z10;
        return this;
    }

    public SAConfigOptions enableAutoAddChannelCallbackEvent(boolean z10) {
        this.isAutoAddChannelCallbackEvent = z10;
        return this;
    }

    public SAConfigOptions enableEncrypt(boolean z10) {
        this.mEnableEncrypt = z10;
        return this;
    }

    public SAConfigOptions enableHeatMap(boolean z10) {
        this.mHeatMapEnabled = z10;
        this.mInvokeHeatMapEnabled = true;
        return this;
    }

    public SAConfigOptions enableJavaScriptBridge(boolean z10) {
        this.isAutoTrackWebView = true;
        this.isWebViewSupportJellyBean = z10;
        return this;
    }

    public SAConfigOptions enableLog(boolean z10) {
        this.mLogEnabled = z10;
        this.mInvokeLog = true;
        return this;
    }

    public SAConfigOptions enableSaveDeepLinkInfo(boolean z10) {
        this.mEnableSaveDeepLinkInfo = z10;
        return this;
    }

    public SAConfigOptions enableSession(boolean z10) {
        this.mEnableSession = z10;
        return this;
    }

    public SAConfigOptions enableSubProcessFlushData() {
        this.isSubProcessFlushData = true;
        return this;
    }

    public SAConfigOptions enableTrackAppCrash() {
        this.mEnableTrackAppCrash = true;
        return this;
    }

    @Deprecated
    public SAConfigOptions enableTrackPageLeave(boolean z10) {
        return enableTrackPageLeave(z10, false);
    }

    public SAConfigOptions enableTrackPush(boolean z10) {
        this.mEnableTrackPush = z10;
        return this;
    }

    public SAConfigOptions enableTrackScreenOrientation(boolean z10) {
        this.mTrackScreenOrientationEnabled = z10;
        return this;
    }

    public SAConfigOptions enableTransportEncrypt() {
        this.mTransportEncrypt = true;
        return this;
    }

    public SAConfigOptions enableVisualizedAutoTrack(boolean z10) {
        this.mVisualizedEnabled = z10;
        this.mInvokeVisualizedEnabled = true;
        return this;
    }

    public SAConfigOptions enableVisualizedProperties(boolean z10) {
        this.mVisualizedPropertiesEnabled = z10;
        return this;
    }

    public /* bridge */ /* synthetic */ SAAdvertisingConfig getAdvertConfig() {
        return super.getAdvertConfig();
    }

    public /* bridge */ /* synthetic */ String getAnonymousId() {
        return super.getAnonymousId();
    }

    public /* bridge */ /* synthetic */ int getAutoTrackEventType() {
        return super.getAutoTrackEventType();
    }

    public /* bridge */ /* synthetic */ String getCustomADChannelUrl() {
        return super.getCustomADChannelUrl();
    }

    public /* bridge */ /* synthetic */ SensorsDataDeferredDeepLinkCallback getDeeplinkCallback() {
        return super.getDeeplinkCallback();
    }

    public /* bridge */ /* synthetic */ List getEncryptors() {
        return super.getEncryptors();
    }

    public /* bridge */ /* synthetic */ int getEventSessionTimeout() {
        return super.getEventSessionTimeout();
    }

    public SAExposureConfig getExposureConfig() {
        return this.mExposureConfig;
    }

    public /* bridge */ /* synthetic */ int getFlushBulkSize() {
        return super.getFlushBulkSize();
    }

    public /* bridge */ /* synthetic */ List getIgnorePageLeave() {
        return super.getIgnorePageLeave();
    }

    public /* bridge */ /* synthetic */ List getInstantEvents() {
        return super.getInstantEvents();
    }

    public /* bridge */ /* synthetic */ Map getLimitKeys() {
        return super.getLimitKeys();
    }

    public /* bridge */ /* synthetic */ int getMaxRequestInterval() {
        return super.getMaxRequestInterval();
    }

    public /* bridge */ /* synthetic */ int getMinRequestInterval() {
        return super.getMinRequestInterval();
    }

    public /* bridge */ /* synthetic */ IPersistentSecretKey getPersistentSecretKey() {
        return super.getPersistentSecretKey();
    }

    public /* bridge */ /* synthetic */ List getPropertyPlugins() {
        return super.getPropertyPlugins();
    }

    public /* bridge */ /* synthetic */ String getRemoteConfigUrl() {
        return super.getRemoteConfigUrl();
    }

    public /* bridge */ /* synthetic */ SSLSocketFactory getSSLSocketFactory() {
        return super.getSSLSocketFactory();
    }

    public /* bridge */ /* synthetic */ String getServerUrl() {
        return super.getServerUrl();
    }

    public /* bridge */ /* synthetic */ List getStorePlugins() {
        return super.getStorePlugins();
    }

    public SAConfigOptions ignorePageLeave(List<Class<?>> list) {
        this.mIgnorePageLeave = list;
        return this;
    }

    public /* bridge */ /* synthetic */ boolean isAutoAddChannelCallbackEvent() {
        return super.isAutoAddChannelCallbackEvent();
    }

    public /* bridge */ /* synthetic */ boolean isAutoTrackWebView() {
        return super.isAutoTrackWebView();
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean isDataCollectEnable() {
        return super.isDataCollectEnable();
    }

    public /* bridge */ /* synthetic */ boolean isDisableAppEndTimer() {
        return super.isDisableAppEndTimer();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDebugAssistant() {
        return super.isDisableDebugAssistant();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDeviceId() {
        return super.isDisableDeviceId();
    }

    public /* bridge */ /* synthetic */ boolean isDisableRandomTimeRequestRemoteConfig() {
        return super.isDisableRandomTimeRequestRemoteConfig();
    }

    public /* bridge */ /* synthetic */ boolean isDisableSDK() {
        return super.isDisableSDK();
    }

    public /* bridge */ /* synthetic */ boolean isEnableEncrypt() {
        return super.isEnableEncrypt();
    }

    public /* bridge */ /* synthetic */ boolean isEnableSession() {
        return super.isEnableSession();
    }

    public /* bridge */ /* synthetic */ boolean isEnableTrackPush() {
        return super.isEnableTrackPush();
    }

    public /* bridge */ /* synthetic */ boolean isMultiProcessFlush() {
        return super.isMultiProcessFlush();
    }

    public /* bridge */ /* synthetic */ boolean isSaveDeepLinkInfo() {
        return super.isSaveDeepLinkInfo();
    }

    public /* bridge */ /* synthetic */ boolean isTrackFragmentPageLeave() {
        return super.isTrackFragmentPageLeave();
    }

    public /* bridge */ /* synthetic */ boolean isTrackPageLeave() {
        return super.isTrackPageLeave();
    }

    public /* bridge */ /* synthetic */ boolean isTransportEncrypt() {
        return super.isTransportEncrypt();
    }

    public /* bridge */ /* synthetic */ boolean isVisualizedPropertiesEnabled() {
        return super.isVisualizedPropertiesEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isWebViewSupportJellyBean() {
        return super.isWebViewSupportJellyBean();
    }

    public SAConfigOptions persistentSecretKey(IPersistentSecretKey iPersistentSecretKey) {
        this.mPersistentSecretKey = iPersistentSecretKey;
        return this;
    }

    public SAConfigOptions registerEncryptor(SAEncryptListener sAEncryptListener) {
        if (sAEncryptListener != null && !TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) && !TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType()) && !this.mEncryptors.contains(sAEncryptListener)) {
            this.mEncryptors.add(0, sAEncryptListener);
        }
        return this;
    }

    public SAConfigOptions registerLimitKeys(Map<String, String> map) {
        this.mLimitKeys = map;
        return this;
    }

    public SAConfigOptions registerPropertyPlugin(SAPropertyPlugin sAPropertyPlugin) {
        if (this.mPropertyPlugins == null) {
            this.mPropertyPlugins = new ArrayList();
        }
        this.mPropertyPlugins.add(sAPropertyPlugin);
        return this;
    }

    public SAConfigOptions registerStorePlugin(StorePlugin storePlugin) {
        if (this.mStorePlugins == null) {
            this.mStorePlugins = new ArrayList();
        }
        this.mStorePlugins.add(storePlugin);
        return this;
    }

    public SAConfigOptions setAdvertConfig(SAAdvertisingConfig sAAdvertisingConfig) {
        this.mSATConfig = sAAdvertisingConfig;
        return this;
    }

    public SAConfigOptions setAnonymousId(String str) {
        this.mAnonymousId = str;
        return this;
    }

    public SAConfigOptions setAutoTrackEventType(int i10) {
        this.mAutoTrackEventType = i10;
        return this;
    }

    public SAConfigOptions setCustomAdChannelUrl(String str) {
        this.mCustomADChannelUrl = str;
        return this;
    }

    public SAConfigOptions setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        this.mDeeplinkCallback = sensorsDataDeferredDeepLinkCallback;
        return this;
    }

    public SAConfigOptions setEventSessionTimeout(int i10) {
        this.mEventSessionTimeout = i10;
        return this;
    }

    public SAConfigOptions setExposureConfig(SAExposureConfig sAExposureConfig) {
        this.mExposureConfig = sAExposureConfig;
        return this;
    }

    public SAConfigOptions setFlushBulkSize(int i10) {
        this.mFlushBulkSize = Math.max(50, i10);
        return this;
    }

    public SAConfigOptions setFlushInterval(int i10) {
        this.mFlushInterval = Math.max(5000, i10);
        return this;
    }

    public SAConfigOptions setInstantEvents(List<String> list) {
        this.mListInstantEvents = list;
        return this;
    }

    public SAConfigOptions setMaxCacheSize(long j10) {
        this.mMaxCacheSize = Math.max(16777216, j10);
        return this;
    }

    public SAConfigOptions setMaxRequestInterval(int i10) {
        if (i10 > 0) {
            this.mMaxRequestInterval = Math.min(i10, 168);
        }
        return this;
    }

    public SAConfigOptions setMinRequestInterval(int i10) {
        if (i10 > 0) {
            this.mMinRequestInterval = Math.min(i10, 168);
        }
        return this;
    }

    public SAConfigOptions setNetworkTypePolicy(int i10) {
        this.mNetworkTypePolicy = i10;
        return this;
    }

    public SAConfigOptions setRemoteConfigUrl(String str) {
        this.mRemoteConfigUrl = str;
        return this;
    }

    public SAConfigOptions setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
        return this;
    }

    public SAConfigOptions setServerUrl(String str) {
        this.mServerUrl = str;
        return this;
    }

    public SAConfigOptions setSourceChannels(String... strArr) {
        this.channelSourceKeys = strArr;
        return this;
    }

    public SAConfigOptions(String str) {
        this.mServerUrl = str;
    }

    public SAConfigOptions clone() {
        try {
            return (SAConfigOptions) super.clone();
        } catch (CloneNotSupportedException e10) {
            SALog.printStackTrace(e10);
            return this;
        }
    }

    public SAConfigOptions enableTrackPageLeave(boolean z10, boolean z11) {
        this.mIsTrackPageLeave = z10;
        this.mIsTrackFragmentPageLeave = z11;
        return this;
    }
}
