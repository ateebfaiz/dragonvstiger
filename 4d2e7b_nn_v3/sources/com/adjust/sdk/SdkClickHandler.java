package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class SdkClickHandler implements ISdkClickHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
    private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
    private static final String SOURCE_REFTAG = "reftag";
    /* access modifiers changed from: private */
    public WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
    /* access modifiers changed from: private */
    public ILogger logger = AdjustFactory.getLogger();
    /* access modifiers changed from: private */
    public List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f17458a;

        public a(ActivityPackage activityPackage) {
            this.f17458a = activityPackage;
        }

        public final void run() {
            SdkClickHandler.this.packageQueue.add(this.f17458a);
            SdkClickHandler.this.logger.debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.this.packageQueue.size()));
            SdkClickHandler.this.logger.verbose("%s", this.f17458a.getExtendedString());
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
            try {
                JSONArray rawReferrerArray = defaultInstance.getRawReferrerArray();
                boolean z10 = false;
                for (int i10 = 0; i10 < rawReferrerArray.length(); i10++) {
                    JSONArray jSONArray = rawReferrerArray.getJSONArray(i10);
                    if (jSONArray.optInt(2, -1) == 0) {
                        String optString = jSONArray.optString(0, (String) null);
                        long optLong = jSONArray.optLong(1, -1);
                        jSONArray.put(2, 1);
                        SdkClickHandler.this.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(optString, optLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
                        z10 = true;
                    }
                }
                if (z10) {
                    defaultInstance.saveRawReferrerArray(rawReferrerArray);
                }
            } catch (JSONException e10) {
                SdkClickHandler.this.logger.error("Send saved raw referrers error (%s)", e10.getMessage());
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17461a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17462b;

        public c(String str, String str2) {
            this.f17461a = str;
            this.f17462b = str2;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                SdkClickHandler.this.sendSdkClick(PackageFactory.buildPreinstallSdkClickPackage(this.f17461a, this.f17462b, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public final void run() {
            SdkClickHandler.this.sendNextSdkClickI();
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f17465a;

        public e(ActivityPackage activityPackage) {
            this.f17465a = activityPackage;
        }

        public final void run() {
            SdkClickHandler.this.sendSdkClickI(this.f17465a);
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    public SdkClickHandler(IActivityHandler iActivityHandler, boolean z10, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z10, iActivityPackageSender);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(hashMap, "queue_size", (long) size);
        }
        return hashMap;
    }

    private void logErrorMessageI(ActivityPackage activityPackage, String str, Throwable th) {
        this.logger.error(Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th)), new Object[0]);
    }

    private void retrySendingI(ActivityPackage activityPackage) {
        int increaseRetries = activityPackage.increaseRetries();
        this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(increaseRetries));
        sendSdkClick(activityPackage);
    }

    /* access modifiers changed from: private */
    public void sendNextSdkClick() {
        this.scheduler.submit(new d());
    }

    /* access modifiers changed from: private */
    public void sendNextSdkClickI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() != null && !iActivityHandler.getActivityState().isGdprForgotten && !this.paused && !this.packageQueue.isEmpty()) {
            ActivityPackage remove = this.packageQueue.remove(0);
            int retries = remove.getRetries();
            e eVar = new e(remove);
            if (retries <= 0) {
                eVar.run();
                return;
            }
            long waitingTime = Util.getWaitingTime(retries, this.backoffStrategy);
            String format = Util.SecondsDisplayFormat.format(((double) waitingTime) / MILLISECONDS_TO_SECONDS_DIVISOR);
            this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", format, Integer.valueOf(retries));
            this.scheduler.schedule(eVar, waitingTime);
        }
    }

    /* access modifiers changed from: private */
    public void sendSdkClickI(ActivityPackage activityPackage) {
        Boolean bool;
        String str;
        String str2;
        long j10;
        String str3;
        long j11;
        long j12;
        long j13;
        long j14;
        String str4;
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        String str5 = activityPackage.getParameters().get("source");
        boolean z10 = str5 != null && str5.equals("reftag");
        String str6 = activityPackage.getParameters().get("raw_referrer");
        if (!z10 || SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).getRawReferrer(str6, activityPackage.getClickTimeInMilliseconds()) != null) {
            boolean z11 = str5 != null && str5.equals("install_referrer");
            if (z11) {
                j12 = activityPackage.getClickTimeInSeconds();
                j11 = activityPackage.getInstallBeginTimeInSeconds();
                str3 = activityPackage.getParameters().get(Constants.REFERRER);
                j10 = activityPackage.getClickTimeServerInSeconds();
                long installBeginTimeServerInSeconds = activityPackage.getInstallBeginTimeServerInSeconds();
                String installVersion = activityPackage.getInstallVersion();
                bool = activityPackage.getGooglePlayInstant();
                str = activityPackage.getParameters().get("referrer_api");
                j13 = installBeginTimeServerInSeconds;
                str2 = installVersion;
            } else {
                str3 = null;
                j12 = -1;
                j13 = -1;
                j11 = -1;
                j10 = -1;
                str2 = null;
                str = null;
                bool = null;
            }
            String str7 = str2;
            boolean z12 = str5 != null && str5.equals(Constants.PREINSTALL);
            ResponseData sendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage, generateSendingParametersI());
            if (sendActivityPackageSync instanceof SdkClickResponseData) {
                SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) sendActivityPackageSync;
                if (sdkClickResponseData.willRetry) {
                    retrySendingI(activityPackage);
                } else if (iActivityHandler != null) {
                    if (sdkClickResponseData.trackingState == TrackingState.OPTED_OUT) {
                        iActivityHandler.gotOptOutResponse();
                        return;
                    }
                    if (z10) {
                        j14 = j13;
                        SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).removeRawReferrer(str6, activityPackage.getClickTimeInMilliseconds());
                    } else {
                        j14 = j13;
                    }
                    if (z11) {
                        sdkClickResponseData.clickTime = j12;
                        sdkClickResponseData.installBegin = j11;
                        sdkClickResponseData.installReferrer = str3;
                        sdkClickResponseData.clickTimeServer = j10;
                        sdkClickResponseData.installBeginServer = j14;
                        sdkClickResponseData.installVersion = str7;
                        sdkClickResponseData.googlePlayInstant = bool;
                        sdkClickResponseData.referrerApi = str;
                        sdkClickResponseData.isInstallReferrer = true;
                    }
                    if (z12 && (str4 = activityPackage.getParameters().get("found_location")) != null && !str4.isEmpty()) {
                        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
                        if (Constants.SYSTEM_INSTALLER_REFERRER.equalsIgnoreCase(str4)) {
                            defaultInstance.removePreinstallReferrer();
                        } else {
                            defaultInstance.setPreinstallPayloadReadStatus(PreinstallUtil.markAsRead(str4, defaultInstance.getPreinstallPayloadReadStatus()));
                        }
                    }
                    iActivityHandler.finishedTrackingActivity(sdkClickResponseData);
                }
            }
        }
    }

    public void init(IActivityHandler iActivityHandler, boolean z10, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z10;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
    }

    public void pauseSending() {
        this.paused = true;
    }

    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    public void sendPreinstallPayload(String str, String str2) {
        this.scheduler.submit(new c(str, str2));
    }

    public void sendReftagReferrers() {
        this.scheduler.submit(new b());
    }

    public void sendSdkClick(ActivityPackage activityPackage) {
        this.scheduler.submit(new a(activityPackage));
    }

    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }
}
