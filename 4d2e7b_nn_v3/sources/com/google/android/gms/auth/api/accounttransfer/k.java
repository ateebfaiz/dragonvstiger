package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class k extends TaskApiCall {

    /* renamed from: a  reason: collision with root package name */
    protected TaskCompletionSource f6624a;

    /* synthetic */ k(int i10, zzk zzk) {
        super((Feature[]) null, false, i10);
    }

    /* access modifiers changed from: protected */
    public abstract void a(zzau zzau);

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f6624a = taskCompletionSource;
        a((zzau) ((zzap) anyClient).getService());
    }
}
