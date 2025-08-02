package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w f8984a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f8985b;

    public /* synthetic */ l(w wVar, Provider provider) {
        this.f8984a = wVar;
        this.f8985b = provider;
    }

    public final void run() {
        this.f8984a.i(this.f8985b);
    }
}
