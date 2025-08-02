package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f6844a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LayoutInflater f6845b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f6846c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f6847d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f6848e;

    d(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6848e = deferredLifecycleHelper;
        this.f6844a = frameLayout;
        this.f6845b = layoutInflater;
        this.f6846c = viewGroup;
        this.f6847d = bundle;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f6844a.removeAllViews();
        this.f6844a.addView(this.f6848e.zaa.onCreateView(this.f6845b, this.f6846c, this.f6847d));
    }

    public final int zaa() {
        return 2;
    }
}
