package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.e1;
import s6.a;

@a(name = "RCTRawText")
public class ReactRawTextManager extends ViewManager<View, e> {
    public static final String REACT_CLASS = "RCTRawText";

    public String getName() {
        return REACT_CLASS;
    }

    public Class<e> getShadowNodeClass() {
        return e.class;
    }

    public void updateExtraData(View view, Object obj) {
    }

    public e createShadowNodeInstance() {
        return new e();
    }

    public ReactTextView createViewInstance(e1 e1Var) {
        throw new IllegalStateException("Attempt to create a native view for RCTRawText");
    }
}
