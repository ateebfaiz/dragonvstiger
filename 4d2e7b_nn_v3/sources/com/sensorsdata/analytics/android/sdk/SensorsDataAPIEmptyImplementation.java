package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class SensorsDataAPIEmptyImplementation extends SensorsDataAPI {

    static class EmptySAContext extends SAContextManager {
        public void addEventListener(SAEventListener sAEventListener) {
        }

        public AnalyticsMessages getAnalyticsMessages() {
            return null;
        }

        public Context getContext() {
            return null;
        }

        public List<SAEventListener> getEventListenerList() {
            return new ArrayList();
        }

        public InternalConfigOptions getInternalConfigs() {
            return new InternalConfigOptions();
        }

        public SensorsDataScreenOrientationDetector getOrientationDetector() {
            return null;
        }

        public PropertyPluginManager getPluginManager() {
            return null;
        }

        public BaseSensorsDataSDKRemoteManager getRemoteManager() {
            return null;
        }

        public SensorsDataAPI getSensorsDataAPI() {
            return new SensorsDataAPIEmptyImplementation();
        }

        public synchronized UserIdentityAPI getUserIdentityAPI() {
            return new UserIdentityAPI(this);
        }

        public boolean isFirstDay(long j10) {
            return false;
        }

        public void removeEventListener(SAEventListener sAEventListener) {
        }

        public void setOrientationDetector(SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector) {
        }

        public void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        }

        public void trackEvent(InputData inputData) {
        }
    }

    SensorsDataAPIEmptyImplementation() {
        this.mSAContextManager = new EmptySAContext();
    }

    public void addEventListener(SAEventListener sAEventListener) {
    }

    public void addExposureView(View view, SAExposureData sAExposureData) {
    }

    public void addFunctionListener(SAFunctionListener sAFunctionListener) {
    }

    public void addHeatMapActivities(List<Class<?>> list) {
    }

    public void addHeatMapActivity(Class<?> cls) {
    }

    public void addSAJSListener(SAJSListener sAJSListener) {
    }

    public void addVisualizedAutoTrackActivities(List<Class<?>> list) {
    }

    public void addVisualizedAutoTrackActivity(Class<?> cls) {
    }

    public void clearGPSLocation() {
    }

    public void clearLastScreenUrl() {
    }

    public void clearReferrerWhenAppEnd() {
    }

    public void clearSuperProperties() {
    }

    public void clearTrackTimer() {
    }

    public void deleteAll() {
    }

    public void disableAutoTrack(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
    }

    public void enableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
    }

    public void enableAutoTrackFragment(Class<?> cls) {
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
    }

    public void enableDeepLinkInstallSource(boolean z10) {
    }

    public void enableLog(boolean z10) {
    }

    public void enableNetworkRequest(boolean z10) {
    }

    public void enableRemoteConfig(boolean z10) {
    }

    public void enableTrackScreenOrientation(boolean z10) {
    }

    public void flush() {
    }

    public void flushScheduled() {
    }

    public void flushSync() {
    }

    public String getAnonymousId() {
        return null;
    }

    public String getCookie(boolean z10) {
        return null;
    }

    public String getDistinctId() {
        return null;
    }

    public int getFlushBulkSize() {
        return 100;
    }

    public int getFlushInterval() {
        return 15000;
    }

    public JSONObject getIdentities() {
        return new JSONObject();
    }

    public List<Class<?>> getIgnoredViewTypeList() {
        return new ArrayList();
    }

    public JSONObject getLastScreenTrackProperties() {
        return new JSONObject();
    }

    public String getLastScreenUrl() {
        return null;
    }

    public String getLoginId() {
        return null;
    }

    public long getMaxCacheSize() {
        return 33554432;
    }

    public JSONObject getPresetProperties() {
        return new JSONObject();
    }

    public String getScreenOrientation() {
        return "";
    }

    public String getServerUrl() {
        return null;
    }

    public int getSessionIntervalTime() {
        return 30000;
    }

    public JSONObject getSuperProperties() {
        return new JSONObject();
    }

    public void identify(String str) {
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
    }

    public void ignoreView(View view) {
    }

    public void ignoreViewType(Class cls) {
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        return true;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        return true;
    }

    public boolean isAutoTrackEnabled() {
        return false;
    }

    public boolean isAutoTrackEventTypeIgnored(int i10) {
        return true;
    }

    public boolean isDebugMode() {
        return false;
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        return false;
    }

    public boolean isHeatMapActivity(Class<?> cls) {
        return false;
    }

    public boolean isHeatMapEnabled() {
        return false;
    }

    public boolean isNetworkRequestEnable() {
        return false;
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return false;
    }

    public boolean isVisualizedAutoTrackActivity(Class<?> cls) {
        return false;
    }

    public boolean isVisualizedAutoTrackEnabled() {
        return false;
    }

    public void itemDelete(String str, String str2) {
    }

    public void itemSet(String str, String str2, JSONObject jSONObject) {
    }

    public void login(String str) {
    }

    public void loginWithKey(String str, String str2) {
    }

    public void logout() {
    }

    public void profileAppend(String str, String str2) {
    }

    public void profileDelete() {
    }

    public void profileIncrement(String str, Number number) {
    }

    public void profilePushId(String str, String str2) {
    }

    public void profileSet(String str, Object obj) {
    }

    public void profileSetOnce(String str, Object obj) {
    }

    public void profileUnset(String str) {
    }

    public void profileUnsetPushId(String str) {
    }

    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
    }

    public void registerLimitKeys(Map<String, String> map) {
    }

    public void registerPropertyPlugin(SAPropertyPlugin sAPropertyPlugin) {
    }

    public void registerSuperProperties(JSONObject jSONObject) {
    }

    public void removeEventListener(SAEventListener sAEventListener) {
    }

    public void removeExposureView(View view) {
    }

    public void removeFunctionListener(SAFunctionListener sAFunctionListener) {
    }

    public void removeTimer(String str) {
    }

    public void requestDeferredDeepLink(JSONObject jSONObject) {
    }

    public void resetAnonymousId() {
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
    }

    public void resumeTrackScreenOrientation() {
    }

    public void setCookie(String str, boolean z10) {
    }

    public void setDebugMode(SensorsDataAPI.DebugMode debugMode) {
    }

    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
    }

    public void setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
    }

    public void setExposureIdentifier(View view, String str) {
    }

    public void setFlushBulkSize(int i10) {
    }

    public void setFlushInterval(int i10) {
    }

    public void setFlushNetworkPolicy(int i10) {
    }

    public void setGPSLocation(double d10, double d11) {
    }

    public void setMaxCacheSize(long j10) {
    }

    public void setServerUrl(String str) {
    }

    public void setSessionIntervalTime(int i10) {
    }

    public void setTrackEventCallBack(SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
    }

    public void setViewActivity(View view, Activity activity) {
    }

    public void setViewFragmentName(View view, String str) {
    }

    public void setViewID(Dialog dialog, String str) {
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
    }

    @Deprecated
    public void showUpWebView(WebView webView, JSONObject jSONObject, boolean z10, boolean z11) {
    }

    public void showUpX5WebView(Object obj) {
    }

    public void startTrackThread() {
    }

    public void stopTrackScreenOrientation() {
    }

    public void stopTrackThread() {
    }

    public void track(String str) {
    }

    public void trackAppInstall() {
    }

    public void trackChannelEvent(String str) {
    }

    public void trackDeepLinkLaunch(String str) {
    }

    public void trackFragmentAppViewScreen() {
    }

    public void trackInstallation(String str) {
    }

    @Deprecated
    public void trackTimer(String str, TimeUnit timeUnit) {
    }

    public void trackTimerEnd(String str) {
    }

    public void trackTimerPause(String str) {
    }

    public void trackTimerResume(String str) {
    }

    public String trackTimerStart(String str) {
        return "";
    }

    public void trackViewAppClick(View view) {
    }

    public void trackViewScreen(Activity activity) {
    }

    public void unregisterPropertyPlugin(SAPropertyPlugin sAPropertyPlugin) {
    }

    public void unregisterSuperProperty(String str) {
    }

    public void disableAutoTrack(List<SensorsDataAPI.AutoTrackEventType> list) {
    }

    public void ignoreView(View view, boolean z10) {
    }

    public boolean isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        return true;
    }

    public void login(String str, JSONObject jSONObject) {
    }

    public void loginWithKey(String str, String str2, JSONObject jSONObject) {
    }

    public void profileAppend(String str, Set<String> set) {
    }

    public void profileIncrement(Map<String, ? extends Number> map) {
    }

    public void profileSet(JSONObject jSONObject) {
    }

    public void profileSetOnce(JSONObject jSONObject) {
    }

    public void removeExposureView(View view, String str) {
    }

    public void setGPSLocation(double d10, double d11, String str) {
    }

    public void setServerUrl(String str, boolean z10) {
    }

    public void setViewID(View view, String str) {
    }

    public void showUpWebView(WebView webView, boolean z10) {
    }

    @Deprecated
    public void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z10, boolean z11) {
    }

    public void track(String str, JSONObject jSONObject) {
    }

    public void trackAppInstall(JSONObject jSONObject) {
    }

    public void trackChannelEvent(String str, JSONObject jSONObject) {
    }

    public void trackDeepLinkLaunch(String str, String str2) {
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
    }

    public void trackTimerEnd(String str, JSONObject jSONObject) {
    }

    public void trackViewAppClick(View view, JSONObject jSONObject) {
    }

    public void trackViewScreen(Object obj) {
    }

    public void setViewID(Object obj, String str) {
    }

    @Deprecated
    public void showUpWebView(WebView webView, boolean z10, JSONObject jSONObject) {
    }

    public void showUpX5WebView(Object obj, boolean z10) {
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z10) {
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z10) {
    }

    public void trackViewScreen(String str, JSONObject jSONObject) {
    }

    public void showUpWebView(WebView webView, boolean z10, boolean z11) {
    }
}
