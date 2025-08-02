package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import com.swmansion.reanimated.layoutReanimation.TabNavigatorObserver;

public final /* synthetic */ class f implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TabNavigatorObserver.FragmentLifecycleCallbacks f11463a;

    public /* synthetic */ f(TabNavigatorObserver.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f11463a = fragmentLifecycleCallbacks;
    }

    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f11463a.lambda$addScreenListener$0(view, i10, i11, i12, i13, i14, i15, i16, i17);
    }
}
