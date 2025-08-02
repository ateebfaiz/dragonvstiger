package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import com.adjust.sdk.network.ActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

public class ActivityHandler implements IActivityHandler {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String SESSION_CALLBACK_PARAMETERS_NAME = "Session Callback parameters";
    private static long SESSION_INTERVAL = 0;
    private static final String SESSION_PARAMETERS_NAME = "Session parameters";
    private static final String SESSION_PARTNER_PARAMETERS_NAME = "Session Partner parameters";
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    private ActivityState activityState;
    /* access modifiers changed from: private */
    public AdjustConfig adjustConfig;
    /* access modifiers changed from: private */
    public AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private TimerOnce delayStartTimer;
    private a deviceInfo;
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityHandler");
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private InstallReferrer installReferrer;
    private InstallReferrerHuawei installReferrerHuawei;
    /* access modifiers changed from: private */
    public InternalState internalState;
    /* access modifiers changed from: private */
    public ILogger logger;
    private IPackageHandler packageHandler;
    private ISdkClickHandler sdkClickHandler;
    private SessionParameters sessionParameters;
    private String subscriptionPath;

    public class InternalState {
        public boolean background;
        public boolean delayStart;
        public boolean enabled;
        public boolean firstLaunch;
        public boolean firstSdkStart;
        public boolean offline;
        public boolean preinstallHasBeenRead;
        public boolean sessionResponseProcessed;
        public boolean updatePackages;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasPreinstallBeenRead() {
            return this.preinstallHasBeenRead;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            return this.background;
        }

        public boolean isInDelayedStart() {
            return this.delayStart;
        }

        public boolean isInForeground() {
            return !this.background;
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isNotInDelayedStart() {
            return !this.delayStart;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }

        public boolean itHasToUpdatePackages() {
            return this.updatePackages;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            ActivityHandler.this.sendPreinstallReferrerI();
        }
    }

    public class a0 implements IRunActivityHandler {
        public a0() {
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReferrerDetails f17335a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17336b;

        public b(ReferrerDetails referrerDetails, String str) {
            this.f17335a = referrerDetails;
            this.f17336b = str;
        }

        public final void run() {
            ActivityHandler.this.sendInstallReferrerI(this.f17335a, this.f17336b);
        }
    }

    public class b0 implements Runnable {
        public b0() {
        }

        public final void run() {
            ActivityHandler.this.foregroundTimerFired();
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f17339a;

        public c(EventResponseData eventResponseData) {
            this.f17339a = eventResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchEventResponseTasksI(this.f17339a);
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        public final void run() {
            ActivityHandler.this.backgroundTimerFired();
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f17342a;

        public d(SdkClickResponseData sdkClickResponseData) {
            this.f17342a = sdkClickResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchSdkClickResponseTasksI(this.f17342a);
        }
    }

    public class d0 implements Runnable {
        public d0() {
        }

        public final void run() {
            ActivityHandler.this.sendFirstPackages();
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f17345a;

        public e(SessionResponseData sessionResponseData) {
            this.f17345a = sessionResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchSessionResponseTasksI(this.f17345a);
        }
    }

    public class e0 implements InstallReferrerReadListener {
        public e0() {
        }

        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f17348a;

        public f(AttributionResponseData attributionResponseData) {
            this.f17348a = attributionResponseData;
        }

        public final void run() {
            ActivityHandler.this.launchAttributionResponseTasksI(this.f17348a);
        }
    }

    public class f0 implements InstallReferrerReadListener {
        public f0() {
        }

        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public final void run() {
            ActivityHandler.this.sendFirstPackagesI();
        }
    }

    public class g0 implements Runnable {
        public g0() {
        }

        public final void run() {
            ActivityHandler.this.stopForegroundTimerI();
            ActivityHandler.this.startBackgroundTimerI();
            ActivityHandler.this.logger.verbose("Subsession end", new Object[0]);
            ActivityHandler.this.endI();
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17353a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17354b;

        public h(String str, String str2) {
            this.f17353a = str;
            this.f17354b = str2;
        }

        public final void run() {
            ActivityHandler.this.addSessionCallbackParameterI(this.f17353a, this.f17354b);
        }
    }

    public class h0 implements Runnable {
        public h0() {
        }

        public final void run() {
            ReferrerDetails samsungReferrer = Reflection.getSamsungReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (samsungReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(samsungReferrer, Constants.REFERRER_API_SAMSUNG);
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17357a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17358b;

        public i(String str, String str2) {
            this.f17357a = str;
            this.f17358b = str2;
        }

        public final void run() {
            ActivityHandler.this.addSessionPartnerParameterI(this.f17357a, this.f17358b);
        }
    }

    public class i0 implements Runnable {
        public i0() {
        }

        public final void run() {
            ReferrerDetails xiaomiReferrer = Reflection.getXiaomiReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (xiaomiReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(xiaomiReferrer, Constants.REFERRER_API_XIAOMI);
            }
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17361a;

        public j(String str) {
            this.f17361a = str;
        }

        public final void run() {
            ActivityHandler.this.removeSessionCallbackParameterI(this.f17361a);
        }
    }

    public class j0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f17363a;

        public j0(EventResponseData eventResponseData) {
            this.f17363a = eventResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener != null) {
                ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(this.f17363a.getSuccessResponseData());
            }
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public final void run() {
            ActivityHandler.this.initI();
        }
    }

    public class k0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EventResponseData f17366a;

        public k0(EventResponseData eventResponseData) {
            this.f17366a = eventResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onEventTrackingFailedListener != null) {
                ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onFinishedEventTrackingFailed(this.f17366a.getFailureResponseData());
            }
        }
    }

    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17368a;

        public l(String str) {
            this.f17368a = str;
        }

        public final void run() {
            ActivityHandler.this.removeSessionPartnerParameterI(this.f17368a);
        }
    }

    public class l0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f17370a;

        public l0(SessionResponseData sessionResponseData) {
            this.f17370a = sessionResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener != null) {
                ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(this.f17370a.getSuccessResponseData());
            }
        }
    }

    public class m implements Runnable {
        public m() {
        }

        public final void run() {
            ActivityHandler.this.resetSessionCallbackParametersI();
        }
    }

    public class m0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f17373a;

        public m0(SessionResponseData sessionResponseData) {
            this.f17373a = sessionResponseData;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener != null) {
                ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(this.f17373a.getFailureResponseData());
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public final void run() {
            ActivityHandler.this.resetSessionPartnerParametersI();
        }
    }

    public class n0 implements Runnable {
        public n0() {
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null && ActivityHandler.this.adjustConfig.onAttributionChangedListener != null) {
                ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17377a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17378b;

        public o(boolean z10, String str) {
            this.f17377a = z10;
            this.f17378b = str;
        }

        public final void run() {
            if (!this.f17377a) {
                SharedPreferencesManager.getDefaultInstance(ActivityHandler.this.getContext()).savePushToken(this.f17378b);
            }
            if (!ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.setPushTokenI(this.f17378b);
            }
        }
    }

    public class o0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f17380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f17381b;

        public o0(Uri uri, Intent intent) {
            this.f17380a = uri;
            this.f17381b = intent;
        }

        public final void run() {
            if (ActivityHandler.this.adjustConfig != null) {
                if (ActivityHandler.this.adjustConfig.onDeeplinkResponseListener != null ? ActivityHandler.this.adjustConfig.onDeeplinkResponseListener.launchReceivedDeeplink(this.f17380a) : true) {
                    ActivityHandler.this.launchDeeplinkMain(this.f17381b, this.f17380a);
                }
            }
        }
    }

    public class p implements Runnable {
        public p() {
        }

        public final void run() {
            ActivityHandler.this.gdprForgetMeI();
        }
    }

    public class p0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f17384a;

        public p0(AdjustEvent adjustEvent) {
            this.f17384a = adjustEvent;
        }

        public final void run() {
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                ActivityHandler.this.startI();
            }
            ActivityHandler.this.trackEventI(this.f17384a);
        }
    }

    public class q implements Runnable {
        public q() {
        }

        public final void run() {
            ActivityHandler.this.disableThirdPartySharingI();
        }
    }

    public class q0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17387a;

        public q0(boolean z10) {
            this.f17387a = z10;
        }

        public final void run() {
            ActivityHandler.this.setEnabledI(this.f17387a);
        }
    }

    public class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustThirdPartySharing f17389a;

        public r(AdjustThirdPartySharing adjustThirdPartySharing) {
            this.f17389a = adjustThirdPartySharing;
        }

        public final void run() {
            ActivityHandler.this.trackThirdPartySharingI(this.f17389a);
        }
    }

    public class r0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17391a;

        public r0(boolean z10) {
            this.f17391a = z10;
        }

        public final void run() {
            ActivityHandler.this.setOfflineModeI(this.f17391a);
        }
    }

    public class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17393a;

        public s(boolean z10) {
            this.f17393a = z10;
        }

        public final void run() {
            ActivityHandler.this.trackMeasurementConsentI(this.f17393a);
        }
    }

    public class s0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f17395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f17396b;

        public s0(Uri uri, long j10) {
            this.f17395a = uri;
            this.f17396b = j10;
        }

        public final void run() {
            ActivityHandler.this.readOpenUrlI(this.f17395a, this.f17396b);
        }
    }

    public class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17398a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f17399b;

        public t(String str, JSONObject jSONObject) {
            this.f17398a = str;
            this.f17399b = jSONObject;
        }

        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f17398a, this.f17399b);
        }
    }

    public class t0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17401a;

        public t0(boolean z10) {
            this.f17401a = z10;
        }

        public final void run() {
            ActivityHandler.this.setAskingAttributionI(this.f17401a);
        }
    }

    public class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustAdRevenue f17403a;

        public u(AdjustAdRevenue adjustAdRevenue) {
            this.f17403a = adjustAdRevenue;
        }

        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f17403a);
        }
    }

    public class u0 implements Runnable {
        public u0() {
        }

        public final void run() {
            ActivityHandler.this.sendReftagReferrerI();
        }
    }

    public class v implements Runnable {
        public v() {
        }

        public final void run() {
            ActivityHandler.this.delayStartI();
            ActivityHandler.this.stopBackgroundTimerI();
            ActivityHandler.this.startForegroundTimerI();
            ActivityHandler.this.logger.verbose("Subsession start", new Object[0]);
            ActivityHandler.this.startI();
        }
    }

    public class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStoreSubscription f17407a;

        public w(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
            this.f17407a = adjustPlayStoreSubscription;
        }

        public final void run() {
            ActivityHandler.this.trackSubscriptionI(this.f17407a);
        }
    }

    public class x implements Runnable {
        public x() {
        }

        public final void run() {
            ActivityHandler.this.gotOptOutResponseI();
        }
    }

    public class y implements Runnable {
        public y() {
        }

        public final void run() {
            ActivityHandler.this.foregroundTimerFiredI();
        }
    }

    public class z implements Runnable {
        public z() {
        }

        public final void run() {
            ActivityHandler.this.backgroundTimerFiredI();
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig2) {
        init(adjustConfig2);
        ILogger logger2 = AdjustFactory.getLogger();
        this.logger = logger2;
        logger2.lockLogLevel();
        InternalState internalState2 = new InternalState();
        this.internalState = internalState2;
        Boolean bool = adjustConfig2.startEnabled;
        internalState2.enabled = bool != null ? bool.booleanValue() : true;
        InternalState internalState3 = this.internalState;
        internalState3.offline = adjustConfig2.startOffline;
        internalState3.background = true;
        internalState3.delayStart = false;
        internalState3.updatePackages = false;
        internalState3.sessionResponseProcessed = false;
        internalState3.firstSdkStart = false;
        internalState3.preinstallHasBeenRead = false;
        this.executor.submit(new k());
    }

    /* access modifiers changed from: private */
    public void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private boolean checkActivityStateI(ActivityState activityState2) {
        if (!this.internalState.hasFirstSdkStartNotOcurred()) {
            return true;
        }
        this.logger.error("Sdk did not yet start", new Object[0]);
        return false;
    }

    private boolean checkAdjustAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (adjustAdRevenue == null) {
            this.logger.error("Ad revenue object missing", new Object[0]);
            return false;
        } else if (adjustAdRevenue.isValid()) {
            return true;
        } else {
            this.logger.error("Ad revenue object not initialized correctly", new Object[0]);
            return false;
        }
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(SharedPreferencesManager.getDefaultInstance(getContext()));
    }

    private void checkAttributionStateI() {
        if (checkActivityStateI(this.activityState)) {
            if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
                return;
            }
            if (this.attribution == null || this.activityState.askingAttribution) {
                this.attributionHandler.getAttribution();
            }
        }
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        if (adjustEvent == null) {
            this.logger.error("Event missing", new Object[0]);
            return false;
        } else if (adjustEvent.isValid()) {
            return true;
        } else {
            this.logger.error("Event not initialized correctly", new Object[0]);
            return false;
        }
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (sdkClickResponseData.isInstallReferrer) {
            String str = sdkClickResponseData.referrerApi;
            if (str == null || !str.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_ADS)) {
                String str2 = sdkClickResponseData.referrerApi;
                if (str2 == null || !str2.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
                    String str3 = sdkClickResponseData.referrerApi;
                    if (str3 == null || !str3.equalsIgnoreCase(Constants.REFERRER_API_SAMSUNG)) {
                        String str4 = sdkClickResponseData.referrerApi;
                        if (str4 == null || !str4.equalsIgnoreCase(Constants.REFERRER_API_XIAOMI)) {
                            ActivityState activityState2 = this.activityState;
                            activityState2.clickTime = sdkClickResponseData.clickTime;
                            activityState2.installBegin = sdkClickResponseData.installBegin;
                            activityState2.installReferrer = sdkClickResponseData.installReferrer;
                            activityState2.clickTimeServer = sdkClickResponseData.clickTimeServer;
                            activityState2.installBeginServer = sdkClickResponseData.installBeginServer;
                            activityState2.installVersion = sdkClickResponseData.installVersion;
                            activityState2.googlePlayInstant = sdkClickResponseData.googlePlayInstant;
                        } else {
                            ActivityState activityState3 = this.activityState;
                            activityState3.clickTimeXiaomi = sdkClickResponseData.clickTime;
                            activityState3.installBeginXiaomi = sdkClickResponseData.installBegin;
                            activityState3.installReferrerXiaomi = sdkClickResponseData.installReferrer;
                            activityState3.clickTimeServerXiaomi = sdkClickResponseData.clickTimeServer;
                            activityState3.installBeginServerXiaomi = sdkClickResponseData.installBeginServer;
                            activityState3.installVersionXiaomi = sdkClickResponseData.installVersion;
                        }
                    } else {
                        ActivityState activityState4 = this.activityState;
                        activityState4.clickTimeSamsung = sdkClickResponseData.clickTime;
                        activityState4.installBeginSamsung = sdkClickResponseData.installBegin;
                        activityState4.installReferrerSamsung = sdkClickResponseData.installReferrer;
                    }
                } else {
                    ActivityState activityState5 = this.activityState;
                    activityState5.clickTimeHuawei = sdkClickResponseData.clickTime;
                    activityState5.installBeginHuawei = sdkClickResponseData.installBegin;
                    activityState5.installReferrerHuaweiAppGallery = sdkClickResponseData.installReferrer;
                }
            } else {
                ActivityState activityState6 = this.activityState;
                activityState6.clickTimeHuawei = sdkClickResponseData.clickTime;
                activityState6.installBeginHuawei = sdkClickResponseData.installBegin;
                activityState6.installReferrerHuawei = sdkClickResponseData.installReferrer;
            }
            writeActivityStateI();
        }
    }

    private void checkForPreinstallI() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null && activityState2.enabled && !activityState2.isGdprForgotten) {
            sendPreinstallReferrerI();
            if (this.adjustConfig.preinstallTrackingEnabled && !this.internalState.hasPreinstallBeenRead()) {
                String str = this.deviceInfo.f17481i;
                if (str == null || str.isEmpty()) {
                    this.logger.debug("Can't read preinstall payload, invalid package name", new Object[0]);
                    return;
                }
                SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                long preinstallPayloadReadStatus = defaultInstance.getPreinstallPayloadReadStatus();
                if (PreinstallUtil.hasAllLocationsBeenRead(preinstallPayloadReadStatus)) {
                    this.internalState.preinstallHasBeenRead = true;
                    return;
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus)) {
                    String payloadFromSystemProperty = PreinstallUtil.getPayloadFromSystemProperty(this.deviceInfo.f17481i, this.logger);
                    if (payloadFromSystemProperty == null || payloadFromSystemProperty.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemProperty, Constants.SYSTEM_PROPERTIES);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyReflection = PreinstallUtil.getPayloadFromSystemPropertyReflection(this.deviceInfo.f17481i, this.logger);
                    if (payloadFromSystemPropertyReflection == null || payloadFromSystemPropertyReflection.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyReflection, Constants.SYSTEM_PROPERTIES_REFLECTION);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyFilePath = PreinstallUtil.getPayloadFromSystemPropertyFilePath(this.deviceInfo.f17481i, this.logger);
                    if (payloadFromSystemPropertyFilePath == null || payloadFromSystemPropertyFilePath.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePath, Constants.SYSTEM_PROPERTIES_PATH);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus)) {
                    String payloadFromSystemPropertyFilePathReflection = PreinstallUtil.getPayloadFromSystemPropertyFilePathReflection(this.deviceInfo.f17481i, this.logger);
                    if (payloadFromSystemPropertyFilePathReflection == null || payloadFromSystemPropertyFilePathReflection.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePathReflection, Constants.SYSTEM_PROPERTIES_PATH_REFLECTION);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus)) {
                    String payloadFromContentProviderDefault = PreinstallUtil.getPayloadFromContentProviderDefault(this.adjustConfig.context, this.deviceInfo.f17481i, this.logger);
                    if (payloadFromContentProviderDefault == null || payloadFromContentProviderDefault.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromContentProviderDefault, Constants.CONTENT_PROVIDER);
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus)) {
                    List<String> payloadsFromContentProviderIntentAction = PreinstallUtil.getPayloadsFromContentProviderIntentAction(this.adjustConfig.context, this.deviceInfo.f17481i, this.logger);
                    if (payloadsFromContentProviderIntentAction == null || payloadsFromContentProviderIntentAction.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus);
                    } else {
                        for (String sendPreinstallPayload : payloadsFromContentProviderIntentAction) {
                            this.sdkClickHandler.sendPreinstallPayload(sendPreinstallPayload, Constants.CONTENT_PROVIDER_INTENT_ACTION);
                        }
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus)) {
                    List<String> payloadsFromContentProviderNoPermission = PreinstallUtil.getPayloadsFromContentProviderNoPermission(this.adjustConfig.context, this.deviceInfo.f17481i, this.logger);
                    if (payloadsFromContentProviderNoPermission == null || payloadsFromContentProviderNoPermission.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus);
                    } else {
                        for (String sendPreinstallPayload2 : payloadsFromContentProviderNoPermission) {
                            this.sdkClickHandler.sendPreinstallPayload(sendPreinstallPayload2, Constants.CONTENT_PROVIDER_NO_PERMISSION);
                        }
                    }
                }
                if (PreinstallUtil.hasNotBeenRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus)) {
                    String payloadFromFileSystem = PreinstallUtil.getPayloadFromFileSystem(this.deviceInfo.f17481i, this.adjustConfig.preinstallFilePath, this.logger);
                    if (payloadFromFileSystem == null || payloadFromFileSystem.isEmpty()) {
                        preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus);
                    } else {
                        this.sdkClickHandler.sendPreinstallPayload(payloadFromFileSystem, Constants.FILE_SYSTEM);
                    }
                }
                defaultInstance.setPreinstallPayloadReadStatus(preinstallPayloadReadStatus);
                this.internalState.preinstallHasBeenRead = true;
            }
        }
    }

    private boolean checkOrderIdI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.findOrderId(str)) {
                this.logger.info("Skipping duplicated order ID '%s'", str);
                return false;
            }
            this.activityState.addOrderId(str);
            this.logger.verbose("Added order ID '%s'", str);
        }
        return true;
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent;
        if (this.adjustConfig.deepLinkComponent == null) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            AdjustConfig adjustConfig2 = this.adjustConfig;
            intent = new Intent("android.intent.action.VIEW", uri, adjustConfig2.context, adjustConfig2.deepLinkComponent);
        }
        intent.setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    /* access modifiers changed from: private */
    public void delayStartI() {
        if (!this.internalState.isNotInDelayedStart() && !isToUpdatePackagesI()) {
            Double d10 = this.adjustConfig.delayStart;
            double doubleValue = d10 != null ? d10.doubleValue() : 0.0d;
            long maxDelayStart = AdjustFactory.getMaxDelayStart();
            long j10 = (long) (1000.0d * doubleValue);
            if (j10 > maxDelayStart) {
                double d11 = (double) (maxDelayStart / 1000);
                DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
                this.logger.warn("Delay start of %s seconds bigger than max allowed value of %s seconds", decimalFormat.format(doubleValue), decimalFormat.format(d11));
                doubleValue = d11;
            } else {
                maxDelayStart = j10;
            }
            this.logger.info("Waiting %s seconds before starting first session", Util.SecondsDisplayFormat.format(doubleValue));
            this.delayStartTimer.startIn(maxDelayStart);
            this.internalState.updatePackages = true;
            ActivityState activityState2 = this.activityState;
            if (activityState2 != null) {
                activityState2.updatePackages = true;
                writeActivityStateI();
            }
        }
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteSessionCallbackParameters(Context context) {
        return context.deleteFile(Constants.SESSION_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteSessionPartnerParameters(Context context) {
        return context.deleteFile(Constants.SESSION_PARTNER_PARAMETERS_FILENAME);
    }

    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteSessionCallbackParameters(context);
        deleteSessionPartnerParameters(context);
        SharedPreferencesManager.getDefaultInstance(context).clear();
    }

    private void disableThirdPartySharingForCoppaEnabledI() {
        if (shouldDisableThirdPartySharingWhenCoppaEnabled()) {
            this.activityState.isThirdPartySharingDisabledForCoppa = true;
            writeActivityStateI();
            ActivityPackage buildThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(new AdjustThirdPartySharing(Boolean.FALSE));
            this.packageHandler.addPackage(buildThirdPartySharingPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildThirdPartySharingPackage.getSuffix());
                return;
            }
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void disableThirdPartySharingI() {
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        defaultInstance.setDisableThirdPartySharing();
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState2 = this.activityState;
            if (activityState2.isGdprForgotten || activityState2.isThirdPartySharingDisabled) {
                return;
            }
            if (this.adjustConfig.coppaCompliantEnabled) {
                this.logger.warn("Call to disable third party sharing API ignored, already done when COPPA enabled", new Object[0]);
                return;
            }
            activityState2.isThirdPartySharingDisabled = true;
            writeActivityStateI();
            ActivityPackage buildDisableThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildDisableThirdPartySharingPackage();
            this.packageHandler.addPackage(buildDisableThirdPartySharingPackage);
            defaultInstance.removeDisableThirdPartySharing();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildDisableThirdPartySharingPackage.getSuffix());
                return;
            }
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState2 = this.activityState;
            if (!activityState2.isGdprForgotten) {
                activityState2.isGdprForgotten = true;
                writeActivityStateI();
                ActivityPackage buildGdprPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildGdprPackage();
                this.packageHandler.addPackage(buildGdprPackage);
                SharedPreferencesManager.getDefaultInstance(getContext()).removeGdprForgetMe();
                if (this.adjustConfig.eventBufferingEnabled) {
                    this.logger.info("Buffered event %s", buildGdprPackage.getSuffix());
                    return;
                }
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig2) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (adjustConfig2 == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        } else if (!adjustConfig2.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        } else {
            if (adjustConfig2.processName != null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) adjustConfig2.context.getSystemService("activity");
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            if (!next.processName.equalsIgnoreCase(adjustConfig2.processName)) {
                                AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", next.processName);
                                return null;
                            }
                        }
                    }
                } else {
                    return null;
                }
            }
            return new ActivityHandler(adjustConfig2);
        }
    }

    /* access modifiers changed from: private */
    public void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private boolean hasChangedStateI(boolean z10, boolean z11, String str, String str2) {
        if (z10 != z11) {
            return true;
        }
        if (z10) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void initI() {
        Double d10;
        String pushToken;
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.sessionParameters = new SessionParameters();
        readSessionCallbackParametersI(this.adjustConfig.context);
        readSessionPartnerParametersI(this.adjustConfig.context);
        AdjustConfig adjustConfig2 = this.adjustConfig;
        if (adjustConfig2.startEnabled != null) {
            adjustConfig2.preLaunchActions.preLaunchActionsArray.add(new a0());
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            InternalState internalState2 = this.internalState;
            ActivityState activityState2 = this.activityState;
            internalState2.enabled = activityState2.enabled;
            internalState2.updatePackages = activityState2.updatePackages;
            internalState2.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        AdjustConfig adjustConfig3 = this.adjustConfig;
        this.deviceInfo = new a(adjustConfig3.context, adjustConfig3.sdkPrefix);
        if (this.adjustConfig.eventBufferingEnabled) {
            this.logger.info("Event buffering is enabled", new Object[0]);
        }
        this.deviceInfo.b(this.adjustConfig);
        if (this.deviceInfo.f17473a == null) {
            if (!Util.canReadPlayIds(this.adjustConfig)) {
                if (this.adjustConfig.coppaCompliantEnabled) {
                    this.logger.info("Cannot read Google Play Services Advertising ID with COPPA enabled", new Object[0]);
                }
                if (this.adjustConfig.playStoreKidsAppEnabled) {
                    this.logger.info("Cannot read Google Play Services Advertising ID with play store kids app enabled", new Object[0]);
                }
            } else {
                this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            }
            if (this.deviceInfo.f17478f == null) {
                if (!Util.canReadNonPlayIds(this.adjustConfig)) {
                    if (this.adjustConfig.coppaCompliantEnabled) {
                        this.logger.info("Cannot read non Play IDs with COPPA enabled", new Object[0]);
                    }
                    if (this.adjustConfig.playStoreKidsAppEnabled) {
                        this.logger.info("Cannot read non Play IDs with play store kids app enabled", new Object[0]);
                    }
                } else {
                    this.logger.error("Unable to get any Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
                }
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.adjustConfig.defaultTracker;
        if (str != null) {
            this.logger.info("Default tracker: '%s'", str);
        }
        String str2 = this.adjustConfig.pushToken;
        if (str2 != null) {
            this.logger.info("Push token: '%s'", str2);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                SharedPreferencesManager.getDefaultInstance(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred() && (pushToken = SharedPreferencesManager.getDefaultInstance(getContext()).getPushToken()) != null) {
            setPushToken(pushToken, true);
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMe();
            } else {
                if (defaultInstance.getDisableThirdPartySharing()) {
                    disableThirdPartySharing();
                }
                for (AdjustThirdPartySharing trackThirdPartySharing : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharing(trackThirdPartySharing);
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsent(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
            }
        }
        this.foregroundTimer = new TimerCycle(new b0(), FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.sendInBackground) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new c0(), BACKGROUND_TIMER_NAME);
        }
        if (this.internalState.hasFirstSdkStartNotOcurred() && (d10 = this.adjustConfig.delayStart) != null && d10.doubleValue() > 0.0d) {
            this.logger.info("Delay start configured", new Object[0]);
            this.internalState.delayStart = true;
            this.delayStartTimer = new TimerOnce(new d0(), DELAY_START_TIMER_NAME);
        }
        UtilNetworking.setUserAgent(this.adjustConfig.userAgent);
        AdjustConfig adjustConfig4 = this.adjustConfig;
        this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false), new ActivityPackageSender(adjustConfig4.urlStrategy, adjustConfig4.basePath, adjustConfig4.gdprPath, adjustConfig4.subscriptionPath, this.deviceInfo.f17480h));
        AdjustConfig adjustConfig5 = this.adjustConfig;
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false), new ActivityPackageSender(adjustConfig5.urlStrategy, adjustConfig5.basePath, adjustConfig5.gdprPath, adjustConfig5.subscriptionPath, this.deviceInfo.f17480h));
        AdjustConfig adjustConfig6 = this.adjustConfig;
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig6.urlStrategy, adjustConfig6.basePath, adjustConfig6.gdprPath, adjustConfig6.subscriptionPath, this.deviceInfo.f17480h));
        if (isToUpdatePackagesI()) {
            updatePackagesI();
        }
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new e0());
        this.installReferrerHuawei = new InstallReferrerHuawei(this.adjustConfig.context, new f0());
        preLaunchActionsI(this.adjustConfig.preLaunchActions.preLaunchActionsArray);
        sendReftagReferrerI();
    }

    private boolean isEnabledI() {
        ActivityState activityState2 = this.activityState;
        return activityState2 != null ? activityState2.enabled : this.internalState.isEnabled();
    }

    private boolean isToUpdatePackagesI() {
        ActivityState activityState2 = this.activityState;
        return activityState2 != null ? activityState2.updatePackages : this.internalState.itHasToUpdatePackages();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.installReferrer;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isValidReferrerDetails(com.adjust.sdk.ReferrerDetails r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r2 = r2.installReferrer
            if (r2 != 0) goto L_0x0009
            return r0
        L_0x0009:
            int r2 = r2.length()
            if (r2 == 0) goto L_0x0010
            r0 = 1
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.ActivityHandler.isValidReferrerDetails(com.adjust.sdk.ReferrerDetails):boolean");
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener != null) {
            handler.post(new n0());
        }
    }

    /* access modifiers changed from: private */
    public void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    /* access modifiers changed from: private */
    public void launchDeeplinkMain(Intent intent, Uri uri) {
        if (this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            this.logger.info("Open deferred deep link (%s)", uri);
            this.adjustConfig.context.startActivity(intent);
            return;
        }
        this.logger.error("Unable to open deferred deep link (%s)", uri);
    }

    /* access modifiers changed from: private */
    public void launchEventResponseTasksI(EventResponseData eventResponseData) {
        Runnable k0Var;
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        boolean z10 = eventResponseData.success;
        if (z10 && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            k0Var = new j0(eventResponseData);
        } else if (!z10 && this.adjustConfig.onEventTrackingFailedListener != null) {
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            k0Var = new k0(eventResponseData);
        } else {
            return;
        }
        handler.post(k0Var);
    }

    /* access modifiers changed from: private */
    public void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
    }

    private void launchSessionResponseListenerI(SessionResponseData sessionResponseData, Handler handler) {
        Runnable m0Var;
        boolean z10 = sessionResponseData.success;
        if (z10 && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            m0Var = new l0(sessionResponseData);
        } else if (!z10 && this.adjustConfig.onSessionTrackingFailedListener != null) {
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            m0Var = new m0(sessionResponseData);
        } else {
            return;
        }
        handler.post(m0Var);
    }

    /* access modifiers changed from: private */
    public void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        this.logger.debug("Launching SessionResponse tasks", new Object[0]);
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            SharedPreferencesManager.getDefaultInstance(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (!toSendI(true)) {
            this.sdkClickHandler.pauseSending();
        } else {
            this.sdkClickHandler.resumeSending();
        }
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list != null) {
            for (IRunActivityHandler run : list) {
                run.run(this);
            }
        }
    }

    private void prepareDeeplinkI(Uri uri, Handler handler) {
        if (uri != null) {
            this.logger.info("Deferred deeplink received (%s)", uri);
            handler.post(new o0(uri, createDeeplinkIntentI(uri)));
        }
    }

    private void processCachedDeeplinkI() {
        if (checkActivityStateI(this.activityState)) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            String deeplinkUrl = defaultInstance.getDeeplinkUrl();
            long deeplinkClickTime = defaultInstance.getDeeplinkClickTime();
            if (deeplinkUrl != null && deeplinkClickTime != -1) {
                readOpenUrl(Uri.parse(deeplinkUrl), deeplinkClickTime);
                defaultInstance.removeDeeplink();
            }
        }
    }

    private void processCoppaComplianceI() {
        if (!this.adjustConfig.coppaCompliantEnabled) {
            resetThirdPartySharingCoppaActivityStateI();
        } else {
            disableThirdPartySharingForCoppaEnabledI();
        }
    }

    private void processSessionI() {
        if (!this.activityState.isGdprForgotten) {
            long currentTimeMillis = System.currentTimeMillis();
            ActivityState activityState2 = this.activityState;
            long j10 = currentTimeMillis - activityState2.lastActivity;
            if (j10 < 0) {
                this.logger.error(TIME_TRAVEL, new Object[0]);
                this.activityState.lastActivity = currentTimeMillis;
                writeActivityStateI();
            } else if (j10 > SESSION_INTERVAL) {
                trackNewSessionI(currentTimeMillis);
                checkAfterNewStartI();
            } else if (j10 > SUBSESSION_INTERVAL) {
                int i10 = activityState2.subsessionCount + 1;
                activityState2.subsessionCount = i10;
                activityState2.sessionLength += j10;
                activityState2.lastActivity = currentTimeMillis;
                this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(i10), Integer.valueOf(this.activityState.sessionCount));
                writeActivityStateI();
                checkForPreinstallI();
                this.installReferrer.startConnection();
                this.installReferrerHuawei.readReferrer();
                readInstallReferrerSamsung();
                readInstallReferrerXiaomi();
            } else {
                this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
            }
        }
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e10) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e10.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e10) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e10.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) {
        try {
            InputStream open = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.adjustConfig.defaultTracker = property;
            }
        } catch (Exception e10) {
            this.logger.debug("%s file not found in this app", e10.getMessage());
        }
    }

    private void readInstallReferrerSamsung() {
        this.executor.submit(new h0());
    }

    private void readInstallReferrerXiaomi() {
        this.executor.submit(new i0());
    }

    /* access modifiers changed from: private */
    public void readOpenUrlI(Uri uri, long j10) {
        if (isEnabledI()) {
            if (Util.isUrlFilteredOut(uri)) {
                ILogger iLogger = this.logger;
                iLogger.debug("Deep link (" + uri.toString() + ") processing skipped", new Object[0]);
                return;
            }
            ActivityPackage buildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j10, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
            if (buildDeeplinkSdkClickPackage != null) {
                this.sdkClickHandler.sendSdkClick(buildDeeplinkSdkClickPackage);
            }
        }
    }

    private void readSessionCallbackParametersI(Context context) {
        try {
            this.sessionParameters.callbackParameters = (Map) Util.readObject(context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e10) {
            this.logger.error("Failed to read %s file (%s)", SESSION_CALLBACK_PARAMETERS_NAME, e10.getMessage());
            this.sessionParameters.callbackParameters = null;
        }
    }

    private void readSessionPartnerParametersI(Context context) {
        try {
            this.sessionParameters.partnerParameters = (Map) Util.readObject(context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e10) {
            this.logger.error("Failed to read %s file (%s)", SESSION_PARTNER_PARAMETERS_NAME, e10.getMessage());
            this.sessionParameters.partnerParameters = null;
        }
    }

    private void resetThirdPartySharingCoppaActivityStateI() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null && activityState2.isThirdPartySharingDisabledForCoppa) {
            activityState2.isThirdPartySharingDisabledForCoppa = false;
            writeActivityStateI();
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
    }

    /* access modifiers changed from: private */
    public void sendFirstPackagesI() {
        if (this.internalState.isNotInDelayedStart()) {
            this.logger.info("Start delay expired or never configured", new Object[0]);
            return;
        }
        updatePackagesI();
        this.internalState.delayStart = false;
        this.delayStartTimer.cancel();
        this.delayStartTimer = null;
        updateHandlersStatusAndSendI();
    }

    /* access modifiers changed from: private */
    public void sendInstallReferrerI(ReferrerDetails referrerDetails, String str) {
        if (isEnabledI() && isValidReferrerDetails(referrerDetails) && !Util.isEqualReferrerDetails(referrerDetails, str, this.activityState)) {
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(referrerDetails, str, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters));
        }
    }

    /* access modifiers changed from: private */
    public void sendPreinstallReferrerI() {
        String preinstallReferrer;
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred() && (preinstallReferrer = SharedPreferencesManager.getDefaultInstance(getContext()).getPreinstallReferrer()) != null && !preinstallReferrer.isEmpty()) {
            this.sdkClickHandler.sendPreinstallPayload(preinstallReferrer, Constants.SYSTEM_INSTALLER_REFERRER);
        }
    }

    /* access modifiers changed from: private */
    public void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    /* access modifiers changed from: private */
    public void setAskingAttributionI(boolean z10) {
        this.activityState.askingAttribution = z10;
        writeActivityStateI();
    }

    /* access modifiers changed from: private */
    public void setEnabledI(boolean z10) {
        ActivityState activityState2;
        if (hasChangedStateI(isEnabledI(), z10, "Adjust already enabled", "Adjust already disabled")) {
            if (!z10 || (activityState2 = this.activityState) == null || !activityState2.isGdprForgotten) {
                InternalState internalState2 = this.internalState;
                internalState2.enabled = z10;
                if (internalState2.hasFirstSdkStartNotOcurred()) {
                    updateStatusI(!z10, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                    return;
                }
                this.activityState.enabled = z10;
                writeActivityStateI();
                if (z10) {
                    SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                    if (defaultInstance.getGdprForgetMe()) {
                        gdprForgetMeI();
                    } else {
                        processCoppaComplianceI();
                        if (defaultInstance.getDisableThirdPartySharing()) {
                            disableThirdPartySharingI();
                        }
                        for (AdjustThirdPartySharing trackThirdPartySharingI : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                            trackThirdPartySharingI(trackThirdPartySharingI);
                        }
                        Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                        if (bool != null) {
                            trackMeasurementConsentI(bool.booleanValue());
                        }
                        this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                        this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                    }
                    if (!defaultInstance.getInstallTracked()) {
                        this.logger.debug("Detected that install was not tracked at enable time", new Object[0]);
                        trackNewSessionI(System.currentTimeMillis());
                    }
                    checkAfterNewStartI(defaultInstance);
                }
                updateStatusI(!z10, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
                return;
            }
            this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public void setOfflineModeI(boolean z10) {
        String str;
        String str2;
        String str3;
        if (hasChangedStateI(this.internalState.isOffline(), z10, "Adjust already in offline mode", "Adjust already in online mode")) {
            InternalState internalState2 = this.internalState;
            internalState2.offline = z10;
            if (internalState2.hasFirstSdkStartNotOcurred()) {
                str = "Handlers will still start as paused";
                str2 = "Handlers will start as active due to SDK being online";
                str3 = "Handlers will start paused due to SDK being offline";
            } else {
                str = "Handlers remain paused";
                str2 = "Resuming handlers to put SDK in online mode";
                str3 = "Pausing handlers to put SDK offline mode";
            }
            updateStatusI(z10, str3, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState2 = this.activityState;
            if (!activityState2.isGdprForgotten && str != null && !str.equals(activityState2.pushToken)) {
                this.activityState.pushToken = str;
                writeActivityStateI();
                ActivityPackage buildInfoPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildInfoPackage(Constants.PUSH);
                this.packageHandler.addPackage(buildInfoPackage);
                SharedPreferencesManager.getDefaultInstance(getContext()).removePushToken();
                if (this.adjustConfig.eventBufferingEnabled) {
                    this.logger.info("Buffered event %s", buildInfoPackage.getSuffix());
                    return;
                }
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private boolean shouldDisableThirdPartySharingWhenCoppaEnabled() {
        if (this.activityState == null || !isEnabledI()) {
            return false;
        }
        ActivityState activityState2 = this.activityState;
        if (activityState2.isGdprForgotten) {
            return false;
        }
        return !activityState2.isThirdPartySharingDisabledForCoppa;
    }

    /* access modifiers changed from: private */
    public void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        this.activityState = new ActivityState();
        this.internalState.firstSdkStart = true;
        updateHandlersStatusAndSendI();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        this.activityState.pushToken = defaultInstance.getPushToken();
        if (this.internalState.isEnabled()) {
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                processCoppaComplianceI();
                if (defaultInstance.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                for (AdjustThirdPartySharing trackThirdPartySharingI : this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray) {
                    trackThirdPartySharingI(trackThirdPartySharingI);
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsentI(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                this.activityState.sessionCount = 1;
                transferSessionPackageI(currentTimeMillis);
                checkAfterNewStartI(defaultInstance);
            }
        }
        this.activityState.resetSessionAttributes(currentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        this.activityState.updatePackages = this.internalState.itHasToUpdatePackages();
        writeActivityStateI();
        defaultInstance.removePushToken();
        defaultInstance.removeGdprForgetMe();
        defaultInstance.removeDisableThirdPartySharing();
        processCachedDeeplinkI();
    }

    /* access modifiers changed from: private */
    public void startForegroundTimerI() {
        if (isEnabledI()) {
            this.foregroundTimer.start();
        }
    }

    /* access modifiers changed from: private */
    public void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
        } else if (this.activityState.enabled) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            updateHandlersStatusAndSendI();
            processCoppaComplianceI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    /* access modifiers changed from: private */
    public void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            try {
                if (this.activityState != null) {
                    this.activityState = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void teardownAllSessionParametersS() {
        synchronized (SessionParameters.class) {
            try {
                if (this.sessionParameters != null) {
                    this.sessionParameters = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            try {
                if (this.attribution != null) {
                    this.attribution = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    /* access modifiers changed from: private */
    public void trackAdRevenueI(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkAdjustAdRevenue(adjustAdRevenue) && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(adjustAdRevenue, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && checkOrderIdI(adjustEvent.orderId) && !this.activityState.isGdprForgotten) {
            long currentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(currentTimeMillis);
            ActivityPackage buildEventPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, currentTimeMillis).buildEventPackage(adjustEvent, this.internalState.isInDelayedStart());
            this.packageHandler.addPackage(buildEventPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildEventPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
            if (this.adjustConfig.sendInBackground && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    /* access modifiers changed from: private */
    public void trackMeasurementConsentI(boolean z10) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z10);
        } else if (isEnabledI() && !this.activityState.isGdprForgotten) {
            ActivityPackage buildMeasurementConsentPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildMeasurementConsentPackage(z10);
            this.packageHandler.addPackage(buildMeasurementConsentPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildMeasurementConsentPackage.getSuffix());
                return;
            }
            this.packageHandler.sendFirstPackage();
        }
    }

    private void trackNewSessionI(long j10) {
        ActivityState activityState2 = this.activityState;
        activityState2.sessionCount++;
        activityState2.lastInterval = j10 - activityState2.lastActivity;
        transferSessionPackageI(j10);
        this.activityState.resetSessionAttributes(j10);
        writeActivityStateI();
    }

    /* access modifiers changed from: private */
    public void trackSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildSubscriptionPackage(adjustPlayStoreSubscription, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* access modifiers changed from: private */
    public void trackThirdPartySharingI(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else if (!isEnabledI() || this.activityState.isGdprForgotten) {
        } else {
            if (this.adjustConfig.coppaCompliantEnabled) {
                this.logger.warn("Calling third party sharing API not allowed when COPPA enabled", new Object[0]);
                return;
            }
            ActivityPackage buildThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(adjustThirdPartySharing);
            this.packageHandler.addPackage(buildThirdPartySharingPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildThirdPartySharingPackage.getSuffix());
                return;
            }
            this.packageHandler.sendFirstPackage();
        }
    }

    private void transferSessionPackageI(long j10) {
        this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, j10).buildSessionPackage(this.internalState.isInDelayedStart()));
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j10) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        ActivityState activityState2 = this.activityState;
        long j11 = j10 - activityState2.lastActivity;
        if (j11 > SESSION_INTERVAL) {
            return false;
        }
        activityState2.lastActivity = j10;
        if (j11 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState2.sessionLength += j11;
        activityState2.timeSpent += j11;
        return true;
    }

    private void updateAdidI(String str) {
        if (str != null && !str.equals(this.activityState.adid)) {
            this.activityState.adid = str;
            writeActivityStateI();
        }
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
            return;
        }
        resumeSendingI();
        if (!this.adjustConfig.eventBufferingEnabled || (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed())) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private void updatePackagesI() {
        this.packageHandler.updatePackages(this.sessionParameters);
        this.internalState.updatePackages = false;
        ActivityState activityState2 = this.activityState;
        if (activityState2 != null) {
            activityState2.updatePackages = false;
            writeActivityStateI();
        }
    }

    private void updateStatusI(boolean z10, String str, String str2, String str3) {
        if (z10) {
            this.logger.info(str, new Object[0]);
        } else if (!pausedI(false)) {
            this.logger.info(str3, new Object[0]);
        } else if (pausedI(true)) {
            this.logger.info(str2, new Object[0]);
        } else {
            ILogger iLogger = this.logger;
            iLogger.info(str2 + ", except the Sdk Click Handler", new Object[0]);
        }
        updateHandlersStatusAndSendI();
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            try {
                ActivityState activityState2 = this.activityState;
                if (activityState2 != null) {
                    Util.writeObject(activityState2, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            try {
                AdjustAttribution adjustAttribution = this.attribution;
                if (adjustAttribution != null) {
                    Util.writeObject(adjustAttribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeSessionCallbackParametersI() {
        synchronized (SessionParameters.class) {
            try {
                SessionParameters sessionParameters2 = this.sessionParameters;
                if (sessionParameters2 != null) {
                    Util.writeObject(sessionParameters2.callbackParameters, this.adjustConfig.context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeSessionPartnerParametersI() {
        synchronized (SessionParameters.class) {
            try {
                SessionParameters sessionParameters2 = this.sessionParameters;
                if (sessionParameters2 != null) {
                    Util.writeObject(sessionParameters2.partnerParameters, this.adjustConfig.context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addSessionCallbackParameter(String str, String str2) {
        this.executor.submit(new h(str, str2));
    }

    public void addSessionCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Callback") && Util.isValidParameter(str2, "value", "Session Callback")) {
            SessionParameters sessionParameters2 = this.sessionParameters;
            if (sessionParameters2.callbackParameters == null) {
                sessionParameters2.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.callbackParameters.put(str, str2);
            writeSessionCallbackParametersI();
        }
    }

    public void addSessionPartnerParameter(String str, String str2) {
        this.executor.submit(new i(str, str2));
    }

    public void addSessionPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Partner") && Util.isValidParameter(str2, "value", "Session Partner")) {
            SessionParameters sessionParameters2 = this.sessionParameters;
            if (sessionParameters2.partnerParameters == null) {
                sessionParameters2.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.partnerParameters.put(str, str2);
            writeSessionPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new z());
    }

    public void disableThirdPartySharing() {
        this.executor.submit(new q());
    }

    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.logger.debug("Finished tracking session", new Object[0]);
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
        } else if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (responseData instanceof EventResponseData) {
            launchEventResponseTasks((EventResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new y());
    }

    public void gdprForgetMe() {
        this.executor.submit(new p());
    }

    public ActivityState getActivityState() {
        return this.activityState;
    }

    public String getAdid() {
        ActivityState activityState2 = this.activityState;
        if (activityState2 == null) {
            return null;
        }
        return activityState2.adid;
    }

    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    public AdjustAttribution getAttribution() {
        return this.attribution;
    }

    public Context getContext() {
        return this.adjustConfig.context;
    }

    public a getDeviceInfo() {
        return this.deviceInfo;
    }

    public InternalState getInternalState() {
        return this.internalState;
    }

    public SessionParameters getSessionParameters() {
        return this.sessionParameters;
    }

    public void gotOptOutResponse() {
        this.executor.submit(new x());
    }

    public void init(AdjustConfig adjustConfig2) {
        this.adjustConfig = adjustConfig2;
    }

    public boolean isEnabled() {
        return isEnabledI();
    }

    public void launchAttributionResponseTasks(AttributionResponseData attributionResponseData) {
        this.executor.submit(new f(attributionResponseData));
    }

    public void launchEventResponseTasks(EventResponseData eventResponseData) {
        this.executor.submit(new c(eventResponseData));
    }

    public void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new d(sdkClickResponseData));
    }

    public void launchSessionResponseTasks(SessionResponseData sessionResponseData) {
        this.executor.submit(new e(sessionResponseData));
    }

    public void onPause() {
        this.internalState.background = true;
        this.executor.submit(new g0());
    }

    public void onResume() {
        this.internalState.background = false;
        this.executor.submit(new v());
    }

    public void readOpenUrl(Uri uri, long j10) {
        this.executor.submit(new s0(uri, j10));
    }

    public void removeSessionCallbackParameter(String str) {
        this.executor.submit(new j(str));
    }

    public void removeSessionCallbackParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Callback")) {
            Map<String, String> map = this.sessionParameters.callbackParameters;
            if (map == null) {
                this.logger.warn("Session Callback parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionCallbackParametersI();
            }
        }
    }

    public void removeSessionPartnerParameter(String str) {
        this.executor.submit(new l(str));
    }

    public void removeSessionPartnerParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Partner")) {
            Map<String, String> map = this.sessionParameters.partnerParameters;
            if (map == null) {
                this.logger.warn("Session Partner parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionPartnerParametersI();
            }
        }
    }

    public void resetSessionCallbackParameters() {
        this.executor.submit(new m());
    }

    public void resetSessionCallbackParametersI() {
        if (this.sessionParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.sessionParameters.callbackParameters = null;
        writeSessionCallbackParametersI();
    }

    public void resetSessionPartnerParameters() {
        this.executor.submit(new n());
    }

    public void resetSessionPartnerParametersI() {
        if (this.sessionParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.sessionParameters.partnerParameters = null;
        writeSessionPartnerParametersI();
    }

    public void sendFirstPackages() {
        this.executor.submit(new g());
    }

    public void sendInstallReferrer(ReferrerDetails referrerDetails, String str) {
        this.executor.submit(new b(referrerDetails, str));
    }

    public void sendPreinstallReferrer() {
        this.executor.submit(new a());
    }

    public void sendReftagReferrer() {
        this.executor.submit(new u0());
    }

    public void setAskingAttribution(boolean z10) {
        this.executor.submit(new t0(z10));
    }

    public void setEnabled(boolean z10) {
        this.executor.submit(new q0(z10));
    }

    public void setOfflineMode(boolean z10) {
        this.executor.submit(new r0(z10));
    }

    public void setPushToken(String str, boolean z10) {
        this.executor.submit(new o(z10, str));
    }

    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        TimerOnce timerOnce2 = this.delayStartTimer;
        if (timerOnce2 != null) {
            timerOnce2.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        SessionParameters sessionParameters2 = this.sessionParameters;
        if (sessionParameters2 != null) {
            Map<String, String> map = sessionParameters2.callbackParameters;
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.sessionParameters.partnerParameters;
            if (map2 != null) {
                map2.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllSessionParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.delayStartTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.sessionParameters = null;
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        this.executor.submit(new u(adjustAdRevenue));
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        this.executor.submit(new p0(adjustEvent));
    }

    public void trackMeasurementConsent(boolean z10) {
        this.executor.submit(new s(z10));
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new w(adjustPlayStoreSubscription));
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        this.executor.submit(new r(adjustThirdPartySharing));
    }

    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null || adjustAttribution.equals(this.attribution)) {
            return false;
        }
        this.attribution = adjustAttribution;
        writeAttributionI();
        return true;
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        checkForPreinstallI();
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
    }

    private boolean pausedI(boolean z10) {
        return z10 ? this.internalState.isOffline() || !isEnabledI() : this.internalState.isOffline() || !isEnabledI() || this.internalState.isInDelayedStart();
    }

    private boolean toSendI(boolean z10) {
        if (pausedI(z10)) {
            return false;
        }
        if (this.adjustConfig.sendInBackground) {
            return true;
        }
        return this.internalState.isInForeground();
    }

    /* access modifiers changed from: private */
    public void trackAdRevenueI(String str, JSONObject jSONObject) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(str, jSONObject));
            this.packageHandler.sendFirstPackage();
        }
    }

    public void trackAdRevenue(String str, JSONObject jSONObject) {
        this.executor.submit(new t(str, jSONObject));
    }
}
