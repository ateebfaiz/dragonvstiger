package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.m;

@SuppressLint({"ViewConstructor"})
public final class CustomSearchView extends SearchView {

    /* renamed from: a  reason: collision with root package name */
    private SearchView.OnCloseListener f11465a;

    /* renamed from: b  reason: collision with root package name */
    private View.OnClickListener f11466b;

    /* renamed from: c  reason: collision with root package name */
    private OnBackPressedCallback f11467c;

    /* renamed from: d  reason: collision with root package name */
    private final c f11468d;

    public static final class a extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CustomSearchView f11469a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CustomSearchView customSearchView) {
            super(true);
            this.f11469a = customSearchView;
        }

        public void handleOnBackPressed() {
            this.f11469a.setIconified(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomSearchView(Context context, Fragment fragment) {
        super(context);
        m.f(context, "context");
        m.f(fragment, "fragment");
        a aVar = new a(this);
        this.f11467c = aVar;
        this.f11468d = new c(fragment, aVar);
        super.setOnSearchClickListener(new a(this));
        super.setOnCloseListener(new b(this));
        setMaxWidth(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: private */
    public static final void c(CustomSearchView customSearchView, View view) {
        m.f(customSearchView, "this$0");
        View.OnClickListener onClickListener = customSearchView.f11466b;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        customSearchView.f11468d.b();
    }

    /* access modifiers changed from: private */
    public static final boolean d(CustomSearchView customSearchView) {
        boolean z10;
        m.f(customSearchView, "this$0");
        SearchView.OnCloseListener onCloseListener = customSearchView.f11465a;
        if (onCloseListener != null) {
            z10 = onCloseListener.onClose();
        } else {
            z10 = false;
        }
        customSearchView.f11468d.c();
        return z10;
    }

    public final void e() {
        setQuery("", false);
    }

    public final void f() {
        setIconified(false);
        requestFocusFromTouch();
    }

    public final boolean getOverrideBackAction() {
        return this.f11468d.a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isIconified()) {
            this.f11468d.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11468d.c();
    }

    public void setOnCloseListener(SearchView.OnCloseListener onCloseListener) {
        this.f11465a = onCloseListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f11466b = onClickListener;
    }

    public final void setOverrideBackAction(boolean z10) {
        this.f11468d.d(z10);
    }

    public final void setText(String str) {
        m.f(str, "text");
        setQuery(str, false);
    }
}
