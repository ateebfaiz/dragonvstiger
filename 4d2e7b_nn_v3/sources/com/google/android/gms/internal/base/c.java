package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

final class c extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f7025a;

    /* renamed from: b  reason: collision with root package name */
    int f7026b;

    c(c cVar) {
        if (cVar != null) {
            this.f7025a = cVar.f7025a;
            this.f7026b = cVar.f7026b;
        }
    }

    public final int getChangingConfigurations() {
        return this.f7025a;
    }

    public final Drawable newDrawable() {
        return new zai(this);
    }
}
