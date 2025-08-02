package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class g extends BaseImplementation.ApiMethodImpl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Account f6925a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(zzal zzal, Api api, GoogleApiClient googleApiClient, Account account) {
        super((Api<?>) api, googleApiClient);
        this.f6925a = account;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        return new k(status);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zze) ((zzam) anyClient).getService()).zze(new f(this), this.f6925a);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
