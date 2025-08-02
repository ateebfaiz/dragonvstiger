package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class h implements PendingResultUtil.ResultConverter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Response f6792a;

    h(Response response) {
        this.f6792a = response;
    }

    public final /* bridge */ /* synthetic */ Object convert(Result result) {
        this.f6792a.setResult(result);
        return this.f6792a;
    }
}
