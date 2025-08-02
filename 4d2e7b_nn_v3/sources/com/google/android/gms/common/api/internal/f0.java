package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;

final class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f6688a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g0 f6689b;

    f0(g0 g0Var, ConnectionResult connectionResult) {
        this.f6689b = g0Var;
        this.f6688a = connectionResult;
    }

    public final void run() {
        g0 g0Var = this.f6689b;
        zabq zabq = (zabq) g0Var.f6696f.zap.get(g0Var.f6692b);
        if (zabq != null) {
            if (this.f6688a.isSuccess()) {
                this.f6689b.f6695e = true;
                if (this.f6689b.f6691a.requiresSignIn()) {
                    this.f6689b.e();
                    return;
                }
                try {
                    g0 g0Var2 = this.f6689b;
                    g0Var2.f6691a.getRemoteService((IAccountAccessor) null, g0Var2.f6691a.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException e10) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
                    this.f6689b.f6691a.disconnect("Failed to get service from broker.");
                    zabq.zar(new ConnectionResult(10), (Exception) null);
                }
            } else {
                zabq.zar(this.f6688a, (Exception) null);
            }
        }
    }
}
