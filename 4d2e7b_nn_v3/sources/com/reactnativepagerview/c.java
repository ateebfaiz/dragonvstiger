package com.reactnativepagerview;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public final /* synthetic */ class c implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11338a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f11339b;

    public /* synthetic */ c(int i10, ViewPager2 viewPager2) {
        this.f11338a = i10;
        this.f11339b = viewPager2;
    }

    public final void transformPage(View view, float f10) {
        f.v(this.f11338a, this.f11339b, view, f10);
    }
}
