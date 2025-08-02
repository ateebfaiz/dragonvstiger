package com.reactnativepagerview;

import androidx.viewpager2.widget.ViewPager2;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f11335a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PagerViewViewManager f11336b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NestedScrollableHost f11337c;

    public /* synthetic */ b(ViewPager2 viewPager2, PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
        this.f11335a = viewPager2;
        this.f11336b = pagerViewViewManager;
        this.f11337c = nestedScrollableHost;
    }

    public final void run() {
        PagerViewViewManager.createViewInstance$lambda$0(this.f11335a, this.f11336b, this.f11337c);
    }
}
