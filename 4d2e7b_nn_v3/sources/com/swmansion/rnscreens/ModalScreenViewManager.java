package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.uimanager.p;
import kotlin.jvm.internal.DefaultConstructorMarker;

@s6.a(name = "RNSModalScreen")
public final class ModalScreenViewManager extends ScreenViewManager {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSModalScreen";

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

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }
}
