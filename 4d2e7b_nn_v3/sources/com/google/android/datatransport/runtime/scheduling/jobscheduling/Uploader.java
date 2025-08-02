package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class Uploader {
    private static final String CLIENT_HEALTH_METRICS_LOG_SOURCE = "GDT_CLIENT_METRICS";
    private static final String LOG_TAG = "Uploader";
    private final BackendRegistry backendRegistry;
    private final ClientHealthMetricsStore clientHealthMetricsStore;
    private final Clock clock;
    private final Context context;
    private final EventStore eventStore;
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final Clock uptimeClock;
    private final WorkScheduler workScheduler;

    public Uploader(Context context2, BackendRegistry backendRegistry2, EventStore eventStore2, WorkScheduler workScheduler2, Executor executor2, SynchronizationGuard synchronizationGuard, @WallTime Clock clock2, @Monotonic Clock clock3, ClientHealthMetricsStore clientHealthMetricsStore2) {
        this.context = context2;
        this.backendRegistry = backendRegistry2;
        this.eventStore = eventStore2;
        this.workScheduler = workScheduler2;
        this.executor = executor2;
        this.guard = synchronizationGuard;
        this.clock = clock2;
        this.uptimeClock = clock3;
        this.clientHealthMetricsStore = clientHealthMetricsStore2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$logAndUpdateState$2(TransportContext transportContext) {
        return Boolean.valueOf(this.eventStore.hasPendingEventsFor(transportContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterable lambda$logAndUpdateState$3(TransportContext transportContext) {
        return this.eventStore.loadBatch(transportContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$4(Iterable iterable, TransportContext transportContext, long j10) {
        this.eventStore.recordFailure(iterable);
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j10);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$5(Iterable iterable) {
        this.eventStore.recordSuccess(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$6() {
        this.clientHealthMetricsStore.resetClientMetrics();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$7(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.clientHealthMetricsStore.recordLogEventDropped((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$logAndUpdateState$8(TransportContext transportContext, long j10) {
        this.eventStore.recordNextCallTime(transportContext, this.clock.getTime() + j10);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$upload$0(TransportContext transportContext, int i10) {
        this.workScheduler.schedule(transportContext, i10 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r3.workScheduler.schedule(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$upload$1(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.eventStore     // Catch:{ SynchronizationException -> 0x0029 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.e r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.e     // Catch:{ SynchronizationException -> 0x0029 }
            r2.<init>(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            r0.runCriticalSection(r2)     // Catch:{ SynchronizationException -> 0x0029 }
            boolean r0 = r3.isNetworkAvailable()     // Catch:{ SynchronizationException -> 0x0029 }
            if (r0 != 0) goto L_0x0022
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.guard     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.g r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.g     // Catch:{ SynchronizationException -> 0x0029 }
            r1.<init>(r3, r4, r5)     // Catch:{ SynchronizationException -> 0x0029 }
            r0.runCriticalSection(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            goto L_0x0025
        L_0x0020:
            r4 = move-exception
            goto L_0x0032
        L_0x0022:
            r3.logAndUpdateState(r4, r5)     // Catch:{ SynchronizationException -> 0x0029 }
        L_0x0025:
            r6.run()
            goto L_0x0031
        L_0x0029:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.workScheduler     // Catch:{ all -> 0x0020 }
            int r5 = r5 + 1
            r0.schedule(r4, r5)     // Catch:{ all -> 0x0020 }
            goto L_0x0025
        L_0x0031:
            return
        L_0x0032:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.lambda$upload$1(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    @VisibleForTesting
    public EventInternal createMetricsEvent(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.guard;
        ClientHealthMetricsStore clientHealthMetricsStore2 = this.clientHealthMetricsStore;
        Objects.requireNonNull(clientHealthMetricsStore2);
        return transportBackend.decorate(EventInternal.builder().setEventMillis(this.clock.getTime()).setUptimeMillis(this.uptimeClock.getTime()).setTransportName(CLIENT_HEALTH_METRICS_LOG_SOURCE).setEncodedPayload(new EncodedPayload(Encoding.of("proto"), ((ClientMetrics) synchronizationGuard.runCriticalSection(new i(clientHealthMetricsStore2))).toByteArray())).build());
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BackendResponse logAndUpdateState(TransportContext transportContext, int i10) {
        BackendResponse send;
        TransportBackend transportBackend = this.backendRegistry.get(transportContext.getBackendName());
        long j10 = 0;
        BackendResponse ok = BackendResponse.ok(0);
        while (true) {
            long j11 = j10;
            while (((Boolean) this.guard.runCriticalSection(new j(this, transportContext))).booleanValue()) {
                Iterable<PersistedEvent> iterable = (Iterable) this.guard.runCriticalSection(new k(this, transportContext));
                if (!iterable.iterator().hasNext()) {
                    return ok;
                }
                if (transportBackend == null) {
                    Logging.d(LOG_TAG, "Unknown backend for %s, deleting event batch for it...", (Object) transportContext);
                    send = BackendResponse.fatalError();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent event : iterable) {
                        arrayList.add(event.getEvent());
                    }
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        arrayList.add(createMetricsEvent(transportBackend));
                    }
                    send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
                }
                ok = send;
                if (ok.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.guard.runCriticalSection(new l(this, iterable, transportContext, j11));
                    this.workScheduler.schedule(transportContext, i10 + 1, true);
                    return ok;
                }
                this.guard.runCriticalSection(new m(this, iterable));
                if (ok.getStatus() == BackendResponse.Status.OK) {
                    j10 = Math.max(j11, ok.getNextRequestWaitMillis());
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        this.guard.runCriticalSection(new n(this));
                    }
                } else if (ok.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (PersistedEvent event2 : iterable) {
                        String transportName = event2.getEvent().getTransportName();
                        if (!hashMap.containsKey(transportName)) {
                            hashMap.put(transportName, 1);
                        } else {
                            hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                        }
                    }
                    this.guard.runCriticalSection(new o(this, hashMap));
                }
            }
            this.guard.runCriticalSection(new f(this, transportContext, j11));
            return ok;
        }
    }

    public void upload(TransportContext transportContext, int i10, Runnable runnable) {
        this.executor.execute(new h(this, transportContext, i10, runnable));
    }
}
