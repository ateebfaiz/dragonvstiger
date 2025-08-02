package com.swmansion.reanimated;

import android.view.View;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11431b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11432c;

    public /* synthetic */ a(View view, int i10, int i11) {
        this.f11430a = view;
        this.f11431b = i10;
        this.f11432c = i11;
    }

    public final void run() {
        ((ReactHorizontalScrollView) this.f11430a).smoothScrollTo(this.f11431b, this.f11432c);
    }
}
