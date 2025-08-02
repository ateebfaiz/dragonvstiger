package com.swmansion.rnscreens;

import androidx.appcompat.widget.SearchView;

public final /* synthetic */ class y implements SearchView.OnCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBarView f11690a;

    public /* synthetic */ y(SearchBarView searchBarView) {
        this.f11690a = searchBarView;
    }

    public final boolean onClose() {
        return SearchBarView.L(this.f11690a);
    }
}
