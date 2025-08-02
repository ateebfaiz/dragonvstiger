package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class u implements ResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f6741a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f6742b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GoogleApiClient f6743c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zabe f6744d;

    u(zabe zabe, StatusPendingResult statusPendingResult, boolean z10, GoogleApiClient googleApiClient) {
        this.f6744d = zabe;
        this.f6741a = statusPendingResult;
        this.f6742b = z10;
        this.f6743c = googleApiClient;
    }

    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.f6744d.zan).zac();
        if (status.isSuccess() && this.f6744d.isConnected()) {
            zabe zabe = this.f6744d;
            zabe.disconnect();
            zabe.connect();
        }
        this.f6741a.setResult(status);
        if (this.f6742b) {
            this.f6743c.disconnect();
        }
    }
}
