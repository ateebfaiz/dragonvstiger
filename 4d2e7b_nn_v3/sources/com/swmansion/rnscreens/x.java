package com.swmansion.rnscreens;

import android.view.View;

public final /* synthetic */ class x implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBarView f11689a;

    public /* synthetic */ x(SearchBarView searchBarView) {
        this.f11689a = searchBarView;
    }

    public final void onFocusChange(View view, boolean z10) {
        SearchBarView.K(this.f11689a, view, z10);
    }
}
