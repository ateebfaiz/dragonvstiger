package com.google.android.gms.auth.account;

import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class b implements PendingResultUtil.ResultConverter {
    b(WorkAccountClient workAccountClient) {
    }

    public final /* synthetic */ Object convert(Result result) {
        return ((WorkAccountApi.AddAccountResult) result).getAccount();
    }
}
