package com.google.android.gms.common.api.internal;

final class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d0 f6673a;

    c0(d0 d0Var) {
        this.f6673a = d0Var;
    }

    public final void run() {
        zabq zabq = this.f6673a.f6679a;
        zabq.zac.disconnect(zabq.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
