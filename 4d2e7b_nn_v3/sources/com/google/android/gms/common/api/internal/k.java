package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class k extends x {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f6713b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(l lVar, zabf zabf, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabf);
        this.f6713b = connectionProgressReportCallbacks;
    }

    public final void a() {
        this.f6713b.onReportServiceBinding(new ConnectionResult(16, (PendingIntent) null));
    }
}
