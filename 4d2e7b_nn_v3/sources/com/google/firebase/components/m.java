package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f8986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f8987b;

    public /* synthetic */ m(s sVar, Provider provider) {
        this.f8986a = sVar;
        this.f8987b = provider;
    }

    public final void run() {
        this.f8986a.a(this.f8987b);
    }
}
