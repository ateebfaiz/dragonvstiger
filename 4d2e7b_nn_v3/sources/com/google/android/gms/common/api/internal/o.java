package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

final class o extends zac {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f6725a;

    o(zaaw zaaw) {
        this.f6725a = new WeakReference(zaaw);
    }

    public final void zab(zak zak) {
        zaaw zaaw = (zaaw) this.f6725a.get();
        if (zaaw != null) {
            zaaw.zaa.zal(new n(this, zaaw, zaaw, zak));
        }
    }
}
