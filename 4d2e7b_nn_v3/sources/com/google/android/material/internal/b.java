package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class b implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f8357a;

    b(View view) {
        this.f8357a = view.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f8357a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f8357a.remove(drawable);
    }
}
