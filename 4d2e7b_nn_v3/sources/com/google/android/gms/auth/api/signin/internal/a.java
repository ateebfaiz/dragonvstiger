package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

final class a extends zba {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6627a;

    a(b bVar) {
        this.f6627a = bVar;
    }

    public final void zbd(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            zbn.zbc(this.f6627a.f6628a).zbe(this.f6627a.f6629b, googleSignInAccount);
        }
        this.f6627a.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
