package com.adjust.sdk.webbridge;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustEventFailure;
import com.adjust.sdk.AdjustEventSuccess;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.AdjustSessionFailure;
import com.adjust.sdk.AdjustSessionSuccess;
import com.adjust.sdk.AdjustThirdPartySharing;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.LogLevel;
import com.adjust.sdk.OnAttributionChangedListener;
import com.adjust.sdk.OnDeeplinkResponseListener;
import com.adjust.sdk.OnDeviceIdsRead;
import com.adjust.sdk.OnEventTrackingFailedListener;
import com.adjust.sdk.OnEventTrackingSucceededListener;
import com.adjust.sdk.OnSessionTrackingFailedListener;
import com.adjust.sdk.OnSessionTrackingSucceededListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdjustBridgeInstance {
    private static final String FB_JAVASCRIPT_INTERFACE_NAME_PREFIX = "fbmq_";
    private static final String JAVASCRIPT_INTERFACE_NAME = "AdjustBridge";
    private static final String LOG_LEVEL_ASSERT = "ASSERT";
    private static final String LOG_LEVEL_DEBUG = "DEBUG";
    private static final String LOG_LEVEL_ERROR = "ERROR";
    private static final String LOG_LEVEL_INFO = "INFO";
    private static final String LOG_LEVEL_SUPPRESS = "SUPPRESS";
    private static final String LOG_LEVEL_VERBOSE = "VERBOSE";
    private static final String LOG_LEVEL_WARN = "WARN";
    private Application application;
    private FacebookSDKJSInterface facebookSDKJSInterface = null;
    private boolean isInitialized = false;
    /* access modifiers changed from: private */
    public boolean shouldDeferredDeeplinkBeLaunched = true;
    /* access modifiers changed from: private */
    public WebView webView;

    class a implements OnAttributionChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17518a;

        a(String str) {
            this.f17518a = str;
        }

        public void onAttributionChanged(AdjustAttribution adjustAttribution) {
            AdjustBridgeUtil.execAttributionCallbackCommand(AdjustBridgeInstance.this.webView, this.f17518a, adjustAttribution);
        }
    }

    class b implements OnEventTrackingSucceededListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17520a;

        b(String str) {
            this.f17520a = str;
        }

        public void onFinishedEventTrackingSucceeded(AdjustEventSuccess adjustEventSuccess) {
            AdjustBridgeUtil.execEventSuccessCallbackCommand(AdjustBridgeInstance.this.webView, this.f17520a, adjustEventSuccess);
        }
    }

    class c implements OnEventTrackingFailedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17522a;

        c(String str) {
            this.f17522a = str;
        }

        public void onFinishedEventTrackingFailed(AdjustEventFailure adjustEventFailure) {
            AdjustBridgeUtil.execEventFailureCallbackCommand(AdjustBridgeInstance.this.webView, this.f17522a, adjustEventFailure);
        }
    }

    class d implements OnSessionTrackingSucceededListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17524a;

        d(String str) {
            this.f17524a = str;
        }

        public void onFinishedSessionTrackingSucceeded(AdjustSessionSuccess adjustSessionSuccess) {
            AdjustBridgeUtil.execSessionSuccessCallbackCommand(AdjustBridgeInstance.this.webView, this.f17524a, adjustSessionSuccess);
        }
    }

    class e implements OnSessionTrackingFailedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17526a;

        e(String str) {
            this.f17526a = str;
        }

        public void onFinishedSessionTrackingFailed(AdjustSessionFailure adjustSessionFailure) {
            AdjustBridgeUtil.execSessionFailureCallbackCommand(AdjustBridgeInstance.this.webView, this.f17526a, adjustSessionFailure);
        }
    }

    class f implements OnDeeplinkResponseListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17528a;

        f(String str) {
            this.f17528a = str;
        }

        public boolean launchReceivedDeeplink(Uri uri) {
            AdjustBridgeUtil.execSingleValueCallback(AdjustBridgeInstance.this.webView, this.f17528a, uri.toString());
            return AdjustBridgeInstance.this.shouldDeferredDeeplinkBeLaunched;
        }
    }

    class g implements OnDeviceIdsRead {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17530a;

        g(String str) {
            this.f17530a = str;
        }

        public void onGoogleAdIdRead(String str) {
            AdjustBridgeUtil.execSingleValueCallback(AdjustBridgeInstance.this.webView, this.f17530a, str);
        }
    }

    private static final class h implements Application.ActivityLifecycleCallbacks {
        private h() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    AdjustBridgeInstance() {
    }

    private boolean isInitialized() {
        if (this.webView == null) {
            AdjustBridgeUtil.getLogger().error("Webview missing. Call AdjustBridge.setWebView before", new Object[0]);
            return false;
        } else if (this.application != null) {
            return true;
        } else {
            AdjustBridgeUtil.getLogger().error("Application context missing. Call AdjustBridge.setApplicationContext before", new Object[0]);
            return false;
        }
    }

    @JavascriptInterface
    public void addSessionCallbackParameter(String str, String str2) {
        if (isInitialized()) {
            Adjust.addSessionCallbackParameter(str, str2);
        }
    }

    @JavascriptInterface
    public void addSessionPartnerParameter(String str, String str2) {
        if (isInitialized()) {
            Adjust.addSessionPartnerParameter(str, str2);
        }
    }

    @JavascriptInterface
    public void appWillOpenUrl(String str) {
        Uri uri;
        if (isInitialized()) {
            if (str != null) {
                uri = Uri.parse(str);
            } else {
                uri = null;
            }
            Adjust.appWillOpenUrl(uri, this.application.getApplicationContext());
        }
    }

    @JavascriptInterface
    public void disableThirdPartySharing() {
        if (isInitialized()) {
            Adjust.disableThirdPartySharing(this.application.getApplicationContext());
        }
    }

    @JavascriptInterface
    public void fbPixelEvent(String str, String str2, String str3) {
        this.facebookSDKJSInterface.sendEvent(str, str2, str3);
    }

    @JavascriptInterface
    public void gdprForgetMe() {
        if (isInitialized()) {
            Adjust.gdprForgetMe(this.application.getApplicationContext());
        }
    }

    @JavascriptInterface
    public String getAdid() {
        if (!isInitialized()) {
            return null;
        }
        return Adjust.getAdid();
    }

    @JavascriptInterface
    public String getAmazonAdId() {
        if (!isInitialized()) {
            return null;
        }
        return Adjust.getAmazonAdId(this.application.getApplicationContext());
    }

    @JavascriptInterface
    public void getAttribution(String str) {
        if (isInitialized()) {
            AdjustBridgeUtil.execAttributionCallbackCommand(this.webView, str, Adjust.getAttribution());
        }
    }

    @JavascriptInterface
    public void getGoogleAdId(String str) {
        if (isInitialized()) {
            Adjust.getGoogleAdId(this.application.getApplicationContext(), new g(str));
        }
    }

    @JavascriptInterface
    public String getSdkVersion() {
        return Adjust.getSdkVersion();
    }

    @JavascriptInterface
    public void isEnabled(String str) {
        if (isInitialized()) {
            AdjustBridgeUtil.execSingleValueCallback(this.webView, str, String.valueOf(Adjust.isEnabled()));
        }
    }

    @JavascriptInterface
    public void onCreate(String str) {
        Object obj;
        AdjustConfig adjustConfig;
        FacebookSDKJSInterface facebookSDKJSInterface2;
        String str2 = str;
        if (this.isInitialized) {
            AdjustBridgeUtil.getLogger().warn("Adjust bridge is already initialized. Ignoring further attempts", new Object[0]);
        } else if (isInitialized()) {
            try {
                ILogger logger = AdjustBridgeUtil.getLogger();
                logger.verbose("Web bridge onCreate adjustConfigString: " + str2, new Object[0]);
                JSONObject jSONObject = new JSONObject(str2);
                Object obj2 = jSONObject.get("appToken");
                Object obj3 = jSONObject.get("environment");
                Object obj4 = jSONObject.get("allowSuppressLogLevel");
                Object obj5 = jSONObject.get("eventBufferingEnabled");
                Object obj6 = jSONObject.get("sendInBackground");
                Object obj7 = jSONObject.get("logLevel");
                Object obj8 = jSONObject.get("sdkPrefix");
                Object obj9 = jSONObject.get("processName");
                Object obj10 = jSONObject.get("defaultTracker");
                Object obj11 = jSONObject.get("externalDeviceId");
                Object obj12 = jSONObject.get("attributionCallbackName");
                Object obj13 = jSONObject.get("deviceKnown");
                Object obj14 = jSONObject.get("needsCost");
                Object obj15 = jSONObject.get("eventSuccessCallbackName");
                Object obj16 = jSONObject.get("eventFailureCallbackName");
                Object obj17 = jSONObject.get("sessionSuccessCallbackName");
                Object obj18 = jSONObject.get("sessionFailureCallbackName");
                Object obj19 = jSONObject.get("openDeferredDeeplink");
                Object obj20 = jSONObject.get("deferredDeeplinkCallbackName");
                Object obj21 = jSONObject.get("delayStart");
                Object obj22 = jSONObject.get("userAgent");
                Object obj23 = jSONObject.get("secretId");
                Object obj24 = jSONObject.get("info1");
                Object obj25 = jSONObject.get("info2");
                Object obj26 = jSONObject.get("info3");
                Object obj27 = jSONObject.get("info4");
                Object obj28 = jSONObject.get("fbPixelDefaultEventToken");
                Object obj29 = jSONObject.get("fbPixelMapping");
                Object obj30 = jSONObject.get("urlStrategy");
                Object obj31 = jSONObject.get("preinstallTrackingEnabled");
                Object obj32 = jSONObject.get("preinstallFilePath");
                Object obj33 = jSONObject.get("playStoreKidsAppEnabled");
                Object obj34 = jSONObject.get("coppaCompliantEnabled");
                String fieldToString = AdjustBridgeUtil.fieldToString(obj2);
                String fieldToString2 = AdjustBridgeUtil.fieldToString(obj3);
                Boolean fieldToBoolean = AdjustBridgeUtil.fieldToBoolean(obj4);
                if (fieldToBoolean == null) {
                    adjustConfig = new AdjustConfig(this.application.getApplicationContext(), fieldToString, fieldToString2);
                    obj = obj34;
                } else {
                    obj = obj34;
                    adjustConfig = new AdjustConfig(this.application.getApplicationContext(), fieldToString, fieldToString2, fieldToBoolean.booleanValue());
                }
                if (adjustConfig.isValid()) {
                    Boolean fieldToBoolean2 = AdjustBridgeUtil.fieldToBoolean(obj5);
                    if (fieldToBoolean2 != null) {
                        adjustConfig.setEventBufferingEnabled(fieldToBoolean2);
                    }
                    Boolean fieldToBoolean3 = AdjustBridgeUtil.fieldToBoolean(obj6);
                    if (fieldToBoolean3 != null) {
                        adjustConfig.setSendInBackground(fieldToBoolean3.booleanValue());
                    }
                    String fieldToString3 = AdjustBridgeUtil.fieldToString(obj7);
                    if (fieldToString3 != null) {
                        if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_VERBOSE)) {
                            adjustConfig.setLogLevel(LogLevel.VERBOSE);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_DEBUG)) {
                            adjustConfig.setLogLevel(LogLevel.DEBUG);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_INFO)) {
                            adjustConfig.setLogLevel(LogLevel.INFO);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_WARN)) {
                            adjustConfig.setLogLevel(LogLevel.WARN);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_ERROR)) {
                            adjustConfig.setLogLevel(LogLevel.ERROR);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_ASSERT)) {
                            adjustConfig.setLogLevel(LogLevel.ASSERT);
                        } else if (fieldToString3.equalsIgnoreCase(LOG_LEVEL_SUPPRESS)) {
                            adjustConfig.setLogLevel(LogLevel.SUPRESS);
                        }
                    }
                    String fieldToString4 = AdjustBridgeUtil.fieldToString(obj8);
                    if (fieldToString4 != null) {
                        adjustConfig.setSdkPrefix(fieldToString4);
                    }
                    String fieldToString5 = AdjustBridgeUtil.fieldToString(obj9);
                    if (fieldToString5 != null) {
                        adjustConfig.setProcessName(fieldToString5);
                    }
                    String fieldToString6 = AdjustBridgeUtil.fieldToString(obj10);
                    if (fieldToString6 != null) {
                        adjustConfig.setDefaultTracker(fieldToString6);
                    }
                    String fieldToString7 = AdjustBridgeUtil.fieldToString(obj11);
                    if (fieldToString7 != null) {
                        adjustConfig.setExternalDeviceId(fieldToString7);
                    }
                    String fieldToString8 = AdjustBridgeUtil.fieldToString(obj12);
                    if (fieldToString8 != null) {
                        adjustConfig.setOnAttributionChangedListener(new a(fieldToString8));
                    }
                    Boolean fieldToBoolean4 = AdjustBridgeUtil.fieldToBoolean(obj13);
                    if (fieldToBoolean4 != null) {
                        adjustConfig.setDeviceKnown(fieldToBoolean4.booleanValue());
                    }
                    Boolean fieldToBoolean5 = AdjustBridgeUtil.fieldToBoolean(obj14);
                    if (fieldToBoolean5 != null) {
                        adjustConfig.setNeedsCost(fieldToBoolean5.booleanValue());
                    }
                    String fieldToString9 = AdjustBridgeUtil.fieldToString(obj15);
                    if (fieldToString9 != null) {
                        adjustConfig.setOnEventTrackingSucceededListener(new b(fieldToString9));
                    }
                    String fieldToString10 = AdjustBridgeUtil.fieldToString(obj16);
                    if (fieldToString10 != null) {
                        adjustConfig.setOnEventTrackingFailedListener(new c(fieldToString10));
                    }
                    String fieldToString11 = AdjustBridgeUtil.fieldToString(obj17);
                    if (fieldToString11 != null) {
                        adjustConfig.setOnSessionTrackingSucceededListener(new d(fieldToString11));
                    }
                    String fieldToString12 = AdjustBridgeUtil.fieldToString(obj18);
                    if (fieldToString12 != null) {
                        adjustConfig.setOnSessionTrackingFailedListener(new e(fieldToString12));
                    }
                    Boolean fieldToBoolean6 = AdjustBridgeUtil.fieldToBoolean(obj19);
                    if (fieldToBoolean6 != null) {
                        this.shouldDeferredDeeplinkBeLaunched = fieldToBoolean6.booleanValue();
                    }
                    String fieldToString13 = AdjustBridgeUtil.fieldToString(obj20);
                    if (fieldToString13 != null) {
                        adjustConfig.setOnDeeplinkResponseListener(new f(fieldToString13));
                    }
                    Double fieldToDouble = AdjustBridgeUtil.fieldToDouble(obj21);
                    if (fieldToDouble != null) {
                        adjustConfig.setDelayStart(fieldToDouble.doubleValue());
                    }
                    String fieldToString14 = AdjustBridgeUtil.fieldToString(obj22);
                    if (fieldToString14 != null) {
                        adjustConfig.setUserAgent(fieldToString14);
                    }
                    Long fieldToLong = AdjustBridgeUtil.fieldToLong(obj23);
                    Long fieldToLong2 = AdjustBridgeUtil.fieldToLong(obj24);
                    Long fieldToLong3 = AdjustBridgeUtil.fieldToLong(obj25);
                    Long fieldToLong4 = AdjustBridgeUtil.fieldToLong(obj26);
                    Long fieldToLong5 = AdjustBridgeUtil.fieldToLong(obj27);
                    if (!(fieldToLong == null || fieldToLong2 == null || fieldToLong3 == null || fieldToLong4 == null || fieldToLong5 == null)) {
                        adjustConfig.setAppSecret(fieldToLong.longValue(), fieldToLong2.longValue(), fieldToLong3.longValue(), fieldToLong4.longValue(), fieldToLong5.longValue());
                    }
                    String fieldToString15 = AdjustBridgeUtil.fieldToString(obj28);
                    if (!(fieldToString15 == null || (facebookSDKJSInterface2 = this.facebookSDKJSInterface) == null)) {
                        facebookSDKJSInterface2.setDefaultEventToken(fieldToString15);
                    }
                    try {
                        String[] jsonArrayToArray = AdjustBridgeUtil.jsonArrayToArray((JSONArray) obj29);
                        if (!(jsonArrayToArray == null || this.facebookSDKJSInterface == null)) {
                            for (int i10 = 0; i10 < jsonArrayToArray.length; i10 += 2) {
                                this.facebookSDKJSInterface.addFbPixelEventTokenMapping(jsonArrayToArray[i10], jsonArrayToArray[i10 + 1]);
                            }
                        }
                    } catch (Exception e10) {
                        AdjustFactory.getLogger().error("AdjustBridgeInstance.configureFbPixel: %s", e10.getMessage());
                    }
                    String fieldToString16 = AdjustBridgeUtil.fieldToString(obj30);
                    if (fieldToString16 != null) {
                        adjustConfig.setUrlStrategy(fieldToString16);
                    }
                    Boolean fieldToBoolean7 = AdjustBridgeUtil.fieldToBoolean(obj31);
                    if (fieldToBoolean7 != null) {
                        adjustConfig.setPreinstallTrackingEnabled(fieldToBoolean7.booleanValue());
                    }
                    String fieldToString17 = AdjustBridgeUtil.fieldToString(obj32);
                    if (fieldToString17 != null) {
                        adjustConfig.setPreinstallFilePath(fieldToString17);
                    }
                    Boolean fieldToBoolean8 = AdjustBridgeUtil.fieldToBoolean(obj33);
                    if (fieldToBoolean8 != null) {
                        adjustConfig.setPlayStoreKidsAppEnabled(fieldToBoolean8.booleanValue());
                    }
                    Boolean fieldToBoolean9 = AdjustBridgeUtil.fieldToBoolean(obj);
                    if (fieldToBoolean9 != null) {
                        adjustConfig.setCoppaCompliantEnabled(fieldToBoolean9.booleanValue());
                    }
                    Adjust.onCreate(adjustConfig);
                    Adjust.onResume();
                    this.isInitialized = true;
                    this.application.registerActivityLifecycleCallbacks(new h((a) null));
                }
            } catch (Exception e11) {
                AdjustFactory.getLogger().error("AdjustBridgeInstance onCreate: %s", e11.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void onPause() {
        if (isInitialized()) {
            Adjust.onPause();
        }
    }

    @JavascriptInterface
    public void onResume() {
        if (isInitialized()) {
            Adjust.onResume();
        }
    }

    public void registerFacebookSDKJSInterface() {
        String applicationId = FacebookSDKJSInterface.getApplicationId(this.application.getApplicationContext());
        AdjustFactory.getLogger().info("AdjustBridgeInstance fbApplicationId: %s", applicationId);
        if (applicationId != null) {
            FacebookSDKJSInterface facebookSDKJSInterface2 = new FacebookSDKJSInterface();
            this.facebookSDKJSInterface = facebookSDKJSInterface2;
            WebView webView2 = this.webView;
            webView2.addJavascriptInterface(facebookSDKJSInterface2, FB_JAVASCRIPT_INTERFACE_NAME_PREFIX + applicationId);
        }
    }

    @JavascriptInterface
    public void removeSessionCallbackParameter(String str) {
        if (isInitialized()) {
            Adjust.removeSessionCallbackParameter(str);
        }
    }

    @JavascriptInterface
    public void removeSessionPartnerParameter(String str) {
        if (isInitialized()) {
            Adjust.removeSessionPartnerParameter(str);
        }
    }

    @JavascriptInterface
    public void resetSessionCallbackParameters() {
        if (isInitialized()) {
            Adjust.resetSessionCallbackParameters();
        }
    }

    @JavascriptInterface
    public void resetSessionPartnerParameters() {
        if (isInitialized()) {
            Adjust.resetSessionPartnerParameters();
        }
    }

    @JavascriptInterface
    public void sendFirstPackages() {
        if (isInitialized()) {
            Adjust.sendFirstPackages();
        }
    }

    public void setApplicationContext(Application application2) {
        this.application = application2;
    }

    @JavascriptInterface
    public void setEnabled(String str) {
        Boolean fieldToBoolean;
        if (isInitialized() && (fieldToBoolean = AdjustBridgeUtil.fieldToBoolean(str)) != null) {
            Adjust.setEnabled(fieldToBoolean.booleanValue());
        }
    }

    @JavascriptInterface
    public void setOfflineMode(String str) {
        Boolean fieldToBoolean;
        if (isInitialized() && (fieldToBoolean = AdjustBridgeUtil.fieldToBoolean(str)) != null) {
            Adjust.setOfflineMode(fieldToBoolean.booleanValue());
        }
    }

    @JavascriptInterface
    public void setPushToken(String str) {
        if (isInitialized()) {
            Adjust.setPushToken(str, this.application.getApplicationContext());
        }
    }

    @JavascriptInterface
    public void setReferrer(String str) {
        if (isInitialized()) {
            Adjust.setReferrer(str, this.application.getApplicationContext());
        }
    }

    public void setWebView(WebView webView2) {
        this.webView = webView2;
        webView2.addJavascriptInterface(this, JAVASCRIPT_INTERFACE_NAME);
    }

    @JavascriptInterface
    public void teardown() {
        this.isInitialized = false;
        this.shouldDeferredDeeplinkBeLaunched = true;
    }

    @JavascriptInterface
    public void trackAdRevenue(String str, String str2) {
        try {
            Adjust.trackAdRevenue(str, new JSONObject(URLDecoder.decode(str2, "UTF-8")));
        } catch (JSONException unused) {
            AdjustFactory.getLogger().debug("Ad revenue payload does not seem to be a valid JSON string", new Object[0]);
        } catch (UnsupportedEncodingException unused2) {
            AdjustFactory.getLogger().debug("Unable to URL decode given JSON string", new Object[0]);
        }
    }

    @JavascriptInterface
    public void trackEvent(String str) {
        if (isInitialized()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object obj = jSONObject.get("eventToken");
                Object obj2 = jSONObject.get("revenue");
                Object obj3 = jSONObject.get(FirebaseAnalytics.Param.CURRENCY);
                Object obj4 = jSONObject.get("callbackParameters");
                Object obj5 = jSONObject.get("partnerParameters");
                Object obj6 = jSONObject.get("orderId");
                Object obj7 = jSONObject.get("callbackId");
                AdjustEvent adjustEvent = new AdjustEvent(AdjustBridgeUtil.fieldToString(obj));
                if (adjustEvent.isValid()) {
                    Double fieldToDouble = AdjustBridgeUtil.fieldToDouble(obj2);
                    String fieldToString = AdjustBridgeUtil.fieldToString(obj3);
                    if (!(fieldToDouble == null || fieldToString == null)) {
                        adjustEvent.setRevenue(fieldToDouble.doubleValue(), fieldToString);
                    }
                    String[] jsonArrayToArray = AdjustBridgeUtil.jsonArrayToArray((JSONArray) obj4);
                    if (jsonArrayToArray != null) {
                        for (int i10 = 0; i10 < jsonArrayToArray.length; i10 += 2) {
                            adjustEvent.addCallbackParameter(jsonArrayToArray[i10], jsonArrayToArray[i10 + 1]);
                        }
                    }
                    String[] jsonArrayToArray2 = AdjustBridgeUtil.jsonArrayToArray((JSONArray) obj5);
                    if (jsonArrayToArray2 != null) {
                        for (int i11 = 0; i11 < jsonArrayToArray2.length; i11 += 2) {
                            adjustEvent.addPartnerParameter(jsonArrayToArray2[i11], jsonArrayToArray2[i11 + 1]);
                        }
                    }
                    String fieldToString2 = AdjustBridgeUtil.fieldToString(obj6);
                    if (fieldToString2 != null) {
                        adjustEvent.setOrderId(fieldToString2);
                    }
                    String fieldToString3 = AdjustBridgeUtil.fieldToString(obj7);
                    if (fieldToString3 != null) {
                        adjustEvent.setCallbackId(fieldToString3);
                    }
                    Adjust.trackEvent(adjustEvent);
                }
            } catch (Exception e10) {
                AdjustFactory.getLogger().error("AdjustBridgeInstance trackEvent: %s", e10.getMessage());
            }
        }
    }

    @JavascriptInterface
    public void trackMeasurementConsent(String str) {
        Boolean fieldToBoolean;
        if (isInitialized() && (fieldToBoolean = AdjustBridgeUtil.fieldToBoolean(str)) != null) {
            Adjust.trackMeasurementConsent(fieldToBoolean.booleanValue());
        }
    }

    @JavascriptInterface
    public void trackThirdPartySharing(String str) {
        if (isInitialized()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object obj = jSONObject.get("isEnabled");
                Object obj2 = jSONObject.get("granularOptions");
                Object obj3 = jSONObject.get("partnerSharingSettings");
                AdjustThirdPartySharing adjustThirdPartySharing = new AdjustThirdPartySharing(AdjustBridgeUtil.fieldToBoolean(obj));
                String[] jsonArrayToArray = AdjustBridgeUtil.jsonArrayToArray((JSONArray) obj2);
                if (jsonArrayToArray != null) {
                    for (int i10 = 0; i10 < jsonArrayToArray.length; i10 += 3) {
                        adjustThirdPartySharing.addGranularOption(jsonArrayToArray[i10], jsonArrayToArray[i10 + 1], jsonArrayToArray[i10 + 2]);
                    }
                }
                String[] jsonArrayToArray2 = AdjustBridgeUtil.jsonArrayToArray((JSONArray) obj3);
                if (jsonArrayToArray2 != null) {
                    for (int i11 = 0; i11 < jsonArrayToArray2.length; i11 += 3) {
                        String str2 = jsonArrayToArray2[i11];
                        String str3 = jsonArrayToArray2[i11 + 1];
                        Boolean fieldToBoolean = AdjustBridgeUtil.fieldToBoolean(jsonArrayToArray2[i11 + 2]);
                        if (fieldToBoolean != null) {
                            adjustThirdPartySharing.addPartnerSharingSetting(str2, str3, fieldToBoolean.booleanValue());
                        } else {
                            AdjustFactory.getLogger().error("Cannot add partner sharing setting with non boolean value", new Object[0]);
                        }
                    }
                }
                Adjust.trackThirdPartySharing(adjustThirdPartySharing);
            } catch (Exception e10) {
                AdjustFactory.getLogger().error("AdjustBridgeInstance trackThirdPartySharing: %s", e10.getMessage());
            }
        }
    }

    public void unregister() {
        if (isInitialized()) {
            this.webView.removeJavascriptInterface(JAVASCRIPT_INTERFACE_NAME);
            unregisterFacebookSDKJSInterface();
            this.application = null;
            this.webView = null;
            this.isInitialized = false;
        }
    }

    public void unregisterFacebookSDKJSInterface() {
        String applicationId;
        if (isInitialized() && this.facebookSDKJSInterface != null && (applicationId = FacebookSDKJSInterface.getApplicationId(this.application.getApplicationContext())) != null) {
            WebView webView2 = this.webView;
            webView2.removeJavascriptInterface(FB_JAVASCRIPT_INTERFACE_NAME_PREFIX + applicationId);
            this.facebookSDKJSInterface = null;
        }
    }

    @JavascriptInterface
    public boolean isEnabled() {
        if (!isInitialized()) {
            return false;
        }
        return Adjust.isEnabled();
    }

    AdjustBridgeInstance(Application application2, WebView webView2) {
        this.application = application2;
        setWebView(webView2);
    }
}
