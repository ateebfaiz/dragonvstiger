package com.swmansion.rnscreens;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f11613a;

    /* renamed from: b  reason: collision with root package name */
    private final OnBackPressedCallback f11614b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11615c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11616d = true;

    public c(Fragment fragment, OnBackPressedCallback onBackPressedCallback) {
        m.f(fragment, "fragment");
        m.f(onBackPressedCallback, "onBackPressedCallback");
        this.f11613a = fragment;
        this.f11614b = onBackPressedCallback;
    }

    public final boolean a() {
        return this.f11616d;
    }

    public final void b() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        if (!this.f11615c && this.f11616d) {
            FragmentActivity activity = this.f11613a.getActivity();
            if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
                onBackPressedDispatcher.addCallback(this.f11613a, this.f11614b);
            }
            this.f11615c = true;
        }
    }

    public final void c() {
        if (this.f11615c) {
            this.f11614b.remove();
            this.f11615c = false;
        }
    }

    public final void d(boolean z10) {
        this.f11616d = z10;
    }
}
