package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccount;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzal implements WorkAccountApi {
    /* access modifiers changed from: private */
    public static final Status zza = new Status(13);

    public final PendingResult<WorkAccountApi.AddAccountResult> addWorkAccount(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new e(this, WorkAccount.API, googleApiClient, str));
    }

    public final PendingResult<Result> removeWorkAccount(GoogleApiClient googleApiClient, Account account) {
        return googleApiClient.execute(new g(this, WorkAccount.API, googleApiClient, account));
    }

    public final void setWorkAuthenticatorEnabled(GoogleApiClient googleApiClient, boolean z10) {
        setWorkAuthenticatorEnabledWithResult(googleApiClient, z10);
    }

    public final PendingResult<Result> setWorkAuthenticatorEnabledWithResult(GoogleApiClient googleApiClient, boolean z10) {
        return googleApiClient.execute(new c(this, WorkAccount.API, googleApiClient, z10));
    }
}
