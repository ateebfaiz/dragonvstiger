package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

final class e extends BaseImplementation.ApiMethodImpl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6913a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(zzal zzal, Api api, GoogleApiClient googleApiClient, String str) {
        super((Api<?>) api, googleApiClient);
        this.f6913a = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new i(status, (Account) null);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zze) ((zzam) anyClient).getService()).zzd(new d(this), this.f6913a);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
