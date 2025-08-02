package com.swmansion.reanimated;

import android.view.View;
import com.facebook.react.views.scroll.ReactScrollView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11434b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11435c;

    public /* synthetic */ b(View view, int i10, int i11) {
        this.f11433a = view;
        this.f11434b = i10;
        this.f11435c = i11;
    }

    public final void run() {
        ((ReactScrollView) this.f11433a).smoothScrollTo(this.f11434b, this.f11435c);
    }
}
