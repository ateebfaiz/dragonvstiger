package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

final class p0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Result f6727a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zada f6728b;

    p0(zada zada, Result result) {
        this.f6728b = zada;
        this.f6727a = result;
    }

    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            ThreadLocal<Boolean> threadLocal = BasePendingResult.zaa;
            threadLocal.set(Boolean.TRUE);
            PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(this.f6728b.zaa)).onSuccess(this.f6727a);
            zada zada = this.f6728b;
            zada.zah.sendMessage(zada.zah.obtainMessage(0, onSuccess));
            threadLocal.set(Boolean.FALSE);
            zada.zan(this.f6727a);
            googleApiClient = (GoogleApiClient) this.f6728b.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (RuntimeException e10) {
            zada zada2 = this.f6728b;
            zada2.zah.sendMessage(zada2.zah.obtainMessage(1, e10));
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(this.f6727a);
            googleApiClient = (GoogleApiClient) this.f6728b.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada.zan(this.f6727a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f6728b.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.f6728b);
            }
            throw th;
        }
        googleApiClient.zap(this.f6728b);
    }
}
