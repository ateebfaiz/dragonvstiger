package com.swmansion.rnscreens;

import androidx.appcompat.widget.SearchView;

public final /* synthetic */ class b implements SearchView.OnCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomSearchView f11612a;

    public /* synthetic */ b(CustomSearchView customSearchView) {
        this.f11612a = customSearchView;
    }

    public final boolean onClose() {
        return CustomSearchView.d(this.f11612a);
    }
}
