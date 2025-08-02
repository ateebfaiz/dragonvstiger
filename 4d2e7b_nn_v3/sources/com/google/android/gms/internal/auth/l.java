package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class l extends BaseImplementation.ApiMethodImpl {
    public l(GoogleApiClient googleApiClient) {
        super((Api<?>) AuthProxy.API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, zzbh zzbh);

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new t(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zzbe zzbe = (zzbe) anyClient;
        a(zzbe.getContext(), (zzbh) zzbe.getService());
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
