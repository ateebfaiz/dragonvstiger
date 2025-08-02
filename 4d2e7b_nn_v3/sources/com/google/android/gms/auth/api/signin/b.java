package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class b implements PendingResultUtil.ResultConverter {
    /* synthetic */ b(zba zba) {
    }

    public final /* synthetic */ Object convert(Result result) {
        return ((GoogleSignInResult) result).getSignInAccount();
    }
}
