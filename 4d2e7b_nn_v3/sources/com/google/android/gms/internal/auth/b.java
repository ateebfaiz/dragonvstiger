package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.zzd;
import com.google.android.gms.auth.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class b extends GoogleApi implements zzg {

    /* renamed from: b  reason: collision with root package name */
    private static final Api.ClientKey f6895b;

    /* renamed from: c  reason: collision with root package name */
    private static final Api.AbstractClientBuilder f6896c;

    /* renamed from: d  reason: collision with root package name */
    private static final Api f6897d;

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f6898e = zzd.zza("GoogleAuthServiceClient");

    /* renamed from: a  reason: collision with root package name */
    private final Context f6899a;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f6895b = clientKey;
        w2 w2Var = new w2();
        f6896c = w2Var;
        f6897d = new Api("GoogleAuthService.API", w2Var, clientKey);
    }

    b(Context context) {
        super(context, f6897d, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f6899a = context;
    }

    static /* bridge */ /* synthetic */ void a(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (!TaskUtil.trySetResultOrApiException(status, obj, taskCompletionSource)) {
            f6898e.w("The task is already complete.", new Object[0]);
        }
    }

    public final Task zza(zzbw zzbw) {
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzj).run(new zzt(this, zzbw)).setMethodKey(1513).build());
    }

    public final Task zzb(AccountChangeEventsRequest accountChangeEventsRequest) {
        Preconditions.checkNotNull(accountChangeEventsRequest, "request cannot be null.");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzi).run(new zzu(this, accountChangeEventsRequest)).setMethodKey(1515).build());
    }

    public final Task zzc(Account account, String str, Bundle bundle) {
        Preconditions.checkNotNull(account, "Account name cannot be null!");
        Preconditions.checkNotEmpty(str, "Scope cannot be null!");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzj).run(new zzs(this, account, str, bundle)).setMethodKey(1512).build());
    }

    public final Task zzd(Account account) {
        Preconditions.checkNotNull(account, "account cannot be null.");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzi).run(new zzr(this, account)).setMethodKey(1517).build());
    }

    public final Task zze(String str) {
        Preconditions.checkNotNull(str, "Client package name cannot be null!");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzi).run(new zzq(this, str)).setMethodKey(1514).build());
    }
}
