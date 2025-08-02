package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

final class k0 extends UnregisterListenerMethod {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f6714a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k0(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.f6714a = builder;
    }

    /* access modifiers changed from: protected */
    public final void unregisterListener(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f6714a.zab.accept(anyClient, taskCompletionSource);
    }
}
