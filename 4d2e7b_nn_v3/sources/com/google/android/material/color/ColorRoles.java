package com.google.android.material.color;

import androidx.annotation.ColorInt;

public final class ColorRoles {
    private final int accent;
    private final int accentContainer;
    private final int onAccent;
    private final int onAccentContainer;

    ColorRoles(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12, @ColorInt int i13) {
        this.accent = i10;
        this.onAccent = i11;
        this.accentContainer = i12;
        this.onAccentContainer = i13;
    }

    @ColorInt
    public int getAccent() {
        return this.accent;
    }

    @ColorInt
    public int getAccentContainer() {
        return this.accentContainer;
    }

    @ColorInt
    public int getOnAccent() {
        return this.onAccent;
    }

    @ColorInt
    public int getOnAccentContainer() {
        return this.onAccentContainer;
    }
}
