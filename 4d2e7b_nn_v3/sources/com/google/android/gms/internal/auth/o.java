package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class o extends zzbd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f6972a;

    o(zzbo zzbo, TaskCompletionSource taskCompletionSource) {
        this.f6972a = taskCompletionSource;
    }

    public final void zzc(String str) {
        Status status;
        if (str != null) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR);
        }
        TaskUtil.setResultOrApiException(status, str, this.f6972a);
    }
}
