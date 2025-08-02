package com.facebook.react.views.scroll;

import com.facebook.react.uimanager.e1;
import com.facebook.react.views.view.ReactClippingViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "AndroidHorizontalScrollContentView")
public final class ReactHorizontalScrollContainerViewManager extends ReactClippingViewManager<ReactHorizontalScrollContainerView> {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public ReactHorizontalScrollContainerView createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new ReactHorizontalScrollContainerView(e1Var);
    }
}
