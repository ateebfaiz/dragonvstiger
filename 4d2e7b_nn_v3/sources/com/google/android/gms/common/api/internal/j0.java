package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final class j0 extends RegisterListenerMethod {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f6712a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j0(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z10, int i10) {
        super(listenerHolder, featureArr, z10, i10);
        this.f6712a = builder;
    }

    /* access modifiers changed from: protected */
    public final void registerListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f6712a.zaa.accept(anyClient, taskCompletionSource);
    }
}
