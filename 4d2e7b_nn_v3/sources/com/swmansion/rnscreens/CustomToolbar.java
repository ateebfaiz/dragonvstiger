package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.appcompat.widget.Toolbar;
import kotlin.jvm.internal.m;

@SuppressLint({"ViewConstructor"})
public class CustomToolbar extends Toolbar {

    /* renamed from: a  reason: collision with root package name */
    private final ScreenStackHeaderConfig f11470a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, ScreenStackHeaderConfig screenStackHeaderConfig) {
        super(context);
        m.f(context, "context");
        m.f(screenStackHeaderConfig, "config");
        this.f11470a = screenStackHeaderConfig;
    }

    public final ScreenStackHeaderConfig getConfig() {
        return this.f11470a;
    }
}
