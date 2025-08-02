package com.facebook.react.views.text.frescosupport;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.e1;
import p3.c;
import s6.a;
import t3.b;

@a(name = "RCTTextInlineImage")
public class FrescoBasedReactTextInlineImageViewManager extends BaseViewManager<View, a> {
    public static final String REACT_CLASS = "RCTTextInlineImage";
    @Nullable
    private final Object mCallerContext;
    @Nullable
    private final b mDraweeControllerBuilder;

    public FrescoBasedReactTextInlineImageViewManager() {
        this((b) null, (Object) null);
    }

    public View createViewInstance(e1 e1Var) {
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<a> getShadowNodeClass() {
        return a.class;
    }

    public void updateExtraData(View view, Object obj) {
    }

    public FrescoBasedReactTextInlineImageViewManager(@Nullable b bVar, @Nullable Object obj) {
        this.mDraweeControllerBuilder = bVar;
        this.mCallerContext = obj;
    }

    public a createShadowNodeInstance() {
        b bVar = this.mDraweeControllerBuilder;
        if (bVar == null) {
            bVar = c.g();
        }
        return new a(bVar, this.mCallerContext);
    }
}
