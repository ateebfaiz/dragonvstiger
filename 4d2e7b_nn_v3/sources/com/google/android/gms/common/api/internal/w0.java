package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

final class w0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final u0 f6751a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zap f6752b;

    w0(zap zap, u0 u0Var) {
        this.f6752b = zap;
        this.f6751a = u0Var;
    }

    public final void run() {
        if (this.f6752b.zaa) {
            ConnectionResult b10 = this.f6751a.b();
            if (b10.hasResolution()) {
                zap zap = this.f6752b;
                zap.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zap.getActivity(), (PendingIntent) Preconditions.checkNotNull(b10.getResolution()), this.f6751a.a(), false), 1);
                return;
            }
            zap zap2 = this.f6752b;
            if (zap2.zac.getErrorResolutionIntent(zap2.getActivity(), b10.getErrorCode(), (String) null) != null) {
                zap zap3 = this.f6752b;
                zap3.zac.zag(zap3.getActivity(), this.f6752b.mLifecycleFragment, b10.getErrorCode(), 2, this.f6752b);
            } else if (b10.getErrorCode() == 18) {
                zap zap4 = this.f6752b;
                Dialog zab = zap4.zac.zab(zap4.getActivity(), this.f6752b);
                zap zap5 = this.f6752b;
                zap5.zac.zac(zap5.getActivity().getApplicationContext(), new v0(this, zab));
            } else {
                this.f6752b.zaa(b10, this.f6751a.a());
            }
        }
    }
}
