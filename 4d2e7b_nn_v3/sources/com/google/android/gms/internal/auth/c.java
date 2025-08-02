package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.account.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class c extends BaseImplementation.ApiMethodImpl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f6903a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(zzal zzal, Api api, GoogleApiClient googleApiClient, boolean z10) {
        super((Api<?>) api, googleApiClient);
        this.f6903a = z10;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        return new j(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zze) ((zzam) anyClient).getService()).zzf(this.f6903a);
        setResult(new j(Status.RESULT_SUCCESS));
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
