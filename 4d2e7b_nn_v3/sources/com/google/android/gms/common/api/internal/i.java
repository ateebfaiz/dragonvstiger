package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class i implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f6703a;

    /* renamed from: b  reason: collision with root package name */
    private final Api f6704b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6705c;

    public i(zaaw zaaw, Api api, boolean z10) {
        this.f6703a = new WeakReference(zaaw);
        this.f6704b = api;
        this.f6705c = z10;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        boolean z10;
        Lock zap;
        zaaw zaaw = (zaaw) this.f6703a.get();
        if (zaaw != null) {
            if (Looper.myLooper() == zaaw.zaa.zag.getLooper()) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaaw.zab.lock();
            try {
                if (!zaaw.zaG(0)) {
                    zap = zaaw.zab;
                } else {
                    if (!connectionResult.isSuccess()) {
                        zaaw.zaE(connectionResult, this.f6704b, this.f6705c);
                    }
                    if (zaaw.zaH()) {
                        zaaw.zaF();
                    }
                    zap = zaaw.zab;
                }
                zap.unlock();
            } catch (Throwable th) {
                zaaw.zab.unlock();
                throw th;
            }
        }
    }
}
