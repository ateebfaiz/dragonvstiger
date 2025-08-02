package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class n0 extends TaskApiCall {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskApiCall.Builder f6724a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n0(TaskApiCall.Builder builder, Feature[] featureArr, boolean z10, int i10) {
        super(featureArr, z10, i10);
        this.f6724a = builder;
    }

    /* access modifiers changed from: protected */
    public final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f6724a.zaa.accept(anyClient, taskCompletionSource);
    }
}
