package com.adjust.sdk;

import android.net.Uri;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import com.adjust.sdk.scheduler.TimerOnce;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AttributionHandler implements IAttributionHandler, IActivityPackageSender.ResponseDataCallbackSubscriber {
    private static final String ATTRIBUTION_TIMER_NAME = "Attribution timer";
    /* access modifiers changed from: private */
    public WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    /* access modifiers changed from: private */
    public String lastInitiatedBy;
    private ILogger logger = AdjustFactory.getLogger();
    private boolean paused;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("AttributionHandler");
    private TimerOnce timer = new TimerOnce(new a(), ATTRIBUTION_TIMER_NAME);

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            AttributionHandler.this.sendAttributionRequest();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            String unused = AttributionHandler.this.lastInitiatedBy = "sdk";
            AttributionHandler.this.getAttributionI(0);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f17423a;

        public c(SessionResponseData sessionResponseData) {
            this.f17423a = sessionResponseData;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                AttributionHandler.this.checkSessionResponseI(iActivityHandler, this.f17423a);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f17425a;

        public d(SdkClickResponseData sdkClickResponseData) {
            this.f17425a = sdkClickResponseData;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                AttributionHandler.this.checkSdkClickResponseI(iActivityHandler, this.f17425a);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f17427a;

        public e(AttributionResponseData attributionResponseData) {
            this.f17427a = attributionResponseData;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                AttributionHandler.this.checkAttributionResponseI(iActivityHandler, this.f17427a);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public final void run() {
            AttributionHandler.this.sendAttributionRequestI();
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ResponseData f17430a;

        public g(ResponseData responseData) {
            this.f17430a = responseData;
        }

        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) AttributionHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler != null) {
                ResponseData responseData = this.f17430a;
                if (responseData.trackingState == TrackingState.OPTED_OUT) {
                    iActivityHandler.gotOptOutResponse();
                } else if (responseData instanceof AttributionResponseData) {
                    AttributionHandler.this.checkAttributionResponseI(iActivityHandler, (AttributionResponseData) responseData);
                }
            }
        }
    }

    public AttributionHandler(IActivityHandler iActivityHandler, boolean z10, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z10, iActivityPackageSender);
    }

    private ActivityPackage buildAndGetAttributionPackage() {
        long currentTimeMillis = System.currentTimeMillis();
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ActivityPackage buildAttributionPackage = new PackageBuilder(iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getActivityState(), iActivityHandler.getSessionParameters(), currentTimeMillis).buildAttributionPackage(this.lastInitiatedBy);
        this.lastInitiatedBy = null;
        return buildAttributionPackage;
    }

    private void checkAttributionI(IActivityHandler iActivityHandler, ResponseData responseData) {
        if (responseData.jsonResponse != null) {
            Long l10 = responseData.askIn;
            if (l10 == null || l10.longValue() < 0) {
                iActivityHandler.setAskingAttribution(false);
                return;
            }
            iActivityHandler.setAskingAttribution(true);
            this.lastInitiatedBy = "backend";
            getAttributionI(l10.longValue());
        }
    }

    /* access modifiers changed from: private */
    public void checkAttributionResponseI(IActivityHandler iActivityHandler, AttributionResponseData attributionResponseData) {
        checkAttributionI(iActivityHandler, attributionResponseData);
        checkDeeplinkI(attributionResponseData);
        iActivityHandler.launchAttributionResponseTasks(attributionResponseData);
    }

    private void checkDeeplinkI(AttributionResponseData attributionResponseData) {
        JSONObject optJSONObject;
        String optString;
        JSONObject jSONObject = attributionResponseData.jsonResponse;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("attribution")) != null && (optString = optJSONObject.optString(Constants.DEEPLINK, (String) null)) != null) {
            attributionResponseData.deeplink = Uri.parse(optString);
        }
    }

    /* access modifiers changed from: private */
    public void checkSdkClickResponseI(IActivityHandler iActivityHandler, SdkClickResponseData sdkClickResponseData) {
        checkAttributionI(iActivityHandler, sdkClickResponseData);
        iActivityHandler.launchSdkClickResponseTasks(sdkClickResponseData);
    }

    /* access modifiers changed from: private */
    public void checkSessionResponseI(IActivityHandler iActivityHandler, SessionResponseData sessionResponseData) {
        checkAttributionI(iActivityHandler, sessionResponseData);
        iActivityHandler.launchSessionResponseTasks(sessionResponseData);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void getAttributionI(long j10) {
        if (this.timer.getFireIn() <= j10) {
            if (j10 != 0) {
                String format = Util.SecondsDisplayFormat.format(((double) j10) / 1000.0d);
                this.logger.debug("Waiting to query attribution in %s seconds", format);
            }
            this.timer.startIn(j10);
        }
    }

    /* access modifiers changed from: private */
    public void sendAttributionRequest() {
        this.scheduler.submit(new f());
    }

    /* access modifiers changed from: private */
    public void sendAttributionRequestI() {
        if (!this.activityHandlerWeakRef.get().getActivityState().isGdprForgotten) {
            if (this.paused) {
                this.logger.debug("Attribution handler is paused", new Object[0]);
                return;
            }
            ActivityPackage buildAndGetAttributionPackage = buildAndGetAttributionPackage();
            this.logger.verbose("%s", buildAndGetAttributionPackage.getExtendedString());
            this.activityPackageSender.sendActivityPackage(buildAndGetAttributionPackage, generateSendingParametersI(), this);
        }
    }

    public void checkAttributionResponse(AttributionResponseData attributionResponseData) {
        this.scheduler.submit(new e(attributionResponseData));
    }

    public void checkSdkClickResponse(SdkClickResponseData sdkClickResponseData) {
        this.scheduler.submit(new d(sdkClickResponseData));
    }

    public void checkSessionResponse(SessionResponseData sessionResponseData) {
        this.scheduler.submit(new c(sessionResponseData));
    }

    public void getAttribution() {
        this.scheduler.submit(new b());
    }

    public void init(IActivityHandler iActivityHandler, boolean z10, IActivityPackageSender iActivityPackageSender) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.paused = !z10;
        this.activityPackageSender = iActivityPackageSender;
    }

    public void onResponseDataCallback(ResponseData responseData) {
        this.scheduler.submit(new g(responseData));
    }

    public void pauseSending() {
        this.paused = true;
    }

    public void resumeSending() {
        this.paused = false;
    }

    public void teardown() {
        this.logger.verbose("AttributionHandler teardown", new Object[0]);
        TimerOnce timerOnce = this.timer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.timer = null;
        this.logger = null;
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
    }
}
