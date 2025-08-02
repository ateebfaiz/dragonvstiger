package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.e1;
import s6.a;

@a(name = "RCTVirtualText")
public class ReactVirtualTextViewManager extends BaseViewManager<View, o> {
    public static final String REACT_CLASS = "RCTVirtualText";

    public View createViewInstance(e1 e1Var) {
        throw new IllegalStateException("Attempt to create a native view for RCTVirtualText");
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<o> getShadowNodeClass() {
        return o.class;
    }

    public void updateExtraData(View view, Object obj) {
    }

    public o createShadowNodeInstance() {
        return new o();
    }
}
