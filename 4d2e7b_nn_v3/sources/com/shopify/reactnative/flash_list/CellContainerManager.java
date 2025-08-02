package com.shopify.reactnative.flash_list;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.k;
import p7.l;

@s6.a(name = "AutoLayoutView")
public final class CellContainerManager extends ViewGroupManager<CellContainerImpl> implements l {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "CellContainer";
    private final k mDelegate = new k(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public CellContainerImpl createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new CellContainerImpl(e1Var);
    }

    @h7.a(name = "index")
    public void setIndex(CellContainerImpl cellContainerImpl, int i10) {
        m.f(cellContainerImpl, "view");
        cellContainerImpl.setIndex(i10);
    }
}
