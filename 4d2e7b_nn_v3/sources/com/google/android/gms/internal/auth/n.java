package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class n extends zzbd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6951a;

    n(zzbo zzbo, TaskCompletionSource taskCompletionSource) {
        this.f6951a = taskCompletionSource;
    }

    public final void zzb(ProxyResponse proxyResponse) {
        TaskUtil.setResultOrApiException(new Status(proxyResponse.googlePlayServicesStatusCode), proxyResponse, this.f6951a);
    }
}
