package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.alibaba.pdns.DNSResolver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class h0 implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final GoogleApiManager f6698a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6699b;

    /* renamed from: c  reason: collision with root package name */
    private final ApiKey f6700c;

    /* renamed from: d  reason: collision with root package name */
    private final long f6701d;

    /* renamed from: e  reason: collision with root package name */
    private final long f6702e;

    h0(GoogleApiManager googleApiManager, int i10, ApiKey apiKey, long j10, long j11, String str, String str2) {
        this.f6698a = googleApiManager;
        this.f6699b = i10;
        this.f6700c = apiKey;
        this.f6701d = j10;
        this.f6702e = j11;
    }

    static h0 a(GoogleApiManager googleApiManager, int i10, ApiKey apiKey) {
        boolean z10;
        long j10;
        long j11;
        if (!googleApiManager.zaF()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z10 = true;
        } else if (!config.getMethodInvocationTelemetryEnabled()) {
            return null;
        } else {
            z10 = config.getMethodTimingTelemetryEnabled();
            zabq zak = googleApiManager.zak(apiKey);
            if (zak != null) {
                if (!(zak.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration b10 = b(zak, baseGmsClient, i10);
                    if (b10 == null) {
                        return null;
                    }
                    zak.zaq();
                    z10 = b10.getMethodTimingTelemetryEnabled();
                }
            }
        }
        if (z10) {
            j10 = System.currentTimeMillis();
        } else {
            j10 = 0;
        }
        if (z10) {
            j11 = SystemClock.elapsedRealtime();
        } else {
            j11 = 0;
        }
        return new h0(googleApiManager, i10, apiKey, j10, j11, (String) null, (String) null);
    }

    private static ConnectionTelemetryConfiguration b(zabq zabq, BaseGmsClient baseGmsClient, int i10) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i10) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i10))) || zabq.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    public final void onComplete(Task task) {
        zabq zak;
        boolean z10;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j10;
        long j11;
        int i15;
        if (this.f6698a.zaF()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zak = this.f6698a.zak(this.f6700c)) != null && (zak.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zak.zaf();
                boolean z11 = true;
                int i16 = 0;
                if (this.f6701d > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                if (config != null) {
                    boolean methodTimingTelemetryEnabled = z10 & config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i12 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration b10 = b(zak, baseGmsClient, this.f6699b);
                        if (b10 != null) {
                            if (!b10.getMethodTimingTelemetryEnabled() || this.f6701d <= 0) {
                                z11 = false;
                            }
                            maxMethodInvocationsInBatch = b10.getMaxMethodInvocationsLogged();
                            methodTimingTelemetryEnabled = z11;
                        } else {
                            return;
                        }
                    }
                    i11 = batchPeriodMillis;
                    i10 = maxMethodInvocationsInBatch;
                } else {
                    i12 = 0;
                    i10 = 100;
                    i11 = 5000;
                }
                GoogleApiManager googleApiManager = this.f6698a;
                if (task.isSuccessful()) {
                    i13 = 0;
                } else {
                    if (task.isCanceled()) {
                        i16 = 100;
                    } else {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            int statusCode = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult == null) {
                                i15 = -1;
                            } else {
                                i15 = connectionResult.getErrorCode();
                            }
                            i13 = i15;
                            i16 = statusCode;
                        } else {
                            i16 = DNSResolver.GOBACK_LOCAL;
                        }
                    }
                    i13 = -1;
                }
                if (z10) {
                    long j12 = this.f6701d;
                    long currentTimeMillis = System.currentTimeMillis();
                    i14 = (int) (SystemClock.elapsedRealtime() - this.f6702e);
                    j11 = j12;
                    j10 = currentTimeMillis;
                } else {
                    j11 = 0;
                    j10 = 0;
                    i14 = -1;
                }
                googleApiManager.zay(new MethodInvocation(this.f6699b, i16, i13, j11, j10, (String) null, (String) null, gCoreServiceId, i14), i12, (long) i11, i10);
            }
        }
    }
}
