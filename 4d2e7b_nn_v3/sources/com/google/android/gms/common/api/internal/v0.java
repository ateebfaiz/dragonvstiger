package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class v0 extends zabw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f6748a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ w0 f6749b;

    v0(w0 w0Var, Dialog dialog) {
        this.f6749b = w0Var;
        this.f6748a = dialog;
    }

    public final void zaa() {
        this.f6749b.f6752b.zad();
        if (this.f6748a.isShowing()) {
            this.f6748a.dismiss();
        }
    }
}
