package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;

final class r extends zzbd {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f6991a;

    r(s sVar) {
        this.f6991a = sVar;
    }

    public final void zzc(String str) {
        if (str != null) {
            this.f6991a.setResult(new zzbv(str));
        } else {
            this.f6991a.setResult(new zzbv(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
