package com.shopify.reactnative.flash_list;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import p7.i;
import p7.j;

@s6.a(name = "AutoLayoutView")
public final class AutoLayoutViewManager extends ViewGroupManager<AutoLayoutView> implements j {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "AutoLayoutView";
    private final i mDelegate = new i(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final int convertToPixelLayout(double d10, double d11) {
        return xb.a.a(d10 * d11);
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return i0.j(t.a("onBlankAreaEvent", i0.j(t.a("registrationName", "onBlankAreaEvent"))));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public AutoLayoutView createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        AutoLayoutView autoLayoutView = new AutoLayoutView(e1Var);
        autoLayoutView.setPixelDensity((double) e1Var.getResources().getDisplayMetrics().density);
        return autoLayoutView;
    }

    @h7.a(name = "disableAutoLayout")
    public void setDisableAutoLayout(AutoLayoutView autoLayoutView, boolean z10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.setDisableAutoLayout(z10);
    }

    @h7.a(name = "enableInstrumentation")
    public void setEnableInstrumentation(AutoLayoutView autoLayoutView, boolean z10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.setEnableInstrumentation(z10);
    }

    @h7.a(name = "horizontal")
    public void setHorizontal(AutoLayoutView autoLayoutView, boolean z10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.getAlShadow().h(z10);
    }

    @h7.a(name = "renderAheadOffset")
    public void setRenderAheadOffset(AutoLayoutView autoLayoutView, double d10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.getAlShadow().k(convertToPixelLayout(d10, autoLayoutView.getPixelDensity()));
    }

    @h7.a(name = "scrollOffset")
    public void setScrollOffset(AutoLayoutView autoLayoutView, double d10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.getAlShadow().l(convertToPixelLayout(d10, autoLayoutView.getPixelDensity()));
    }

    @h7.a(name = "windowSize")
    public void setWindowSize(AutoLayoutView autoLayoutView, double d10) {
        m.f(autoLayoutView, "view");
        autoLayoutView.getAlShadow().m(convertToPixelLayout(d10, autoLayoutView.getPixelDensity()));
    }
}
