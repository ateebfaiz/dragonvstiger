package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class w extends zabw {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f6750a;

    w(zabe zabe) {
        this.f6750a = new WeakReference(zabe);
    }

    public final void zaa() {
        zabe zabe = (zabe) this.f6750a.get();
        if (zabe != null) {
            zabe.zai(zabe);
        }
    }
}
