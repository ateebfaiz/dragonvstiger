package com.facebook.react.views.image;

import android.graphics.PorterDuff;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.yoga.e;
import e6.f;
import java.util.HashMap;
import java.util.Map;
import p3.c;
import s6.a;
import t3.b;

@a(name = "RCTImageView")
public class ReactImageManager extends SimpleViewManager<ReactImageView> {
    public static final String REACT_CLASS = "RCTImageView";
    @Nullable
    private final Object mCallerContext;
    @Nullable
    private final f mCallerContextFactory;
    @Nullable
    private b mDraweeControllerBuilder;
    @Nullable
    private a mGlobalImageLoadListener;

    @Deprecated
    public ReactImageManager(@Nullable b bVar, @Nullable Object obj) {
        this(bVar, (a) null, obj);
    }

    @Deprecated
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public b getDraweeControllerBuilder() {
        if (this.mDraweeControllerBuilder == null) {
            this.mDraweeControllerBuilder = c.g();
        }
        return this.mDraweeControllerBuilder;
    }

    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(f.h(b.g(4), f.d("registrationName", "onLoadStart"), b.g(5), f.d("registrationName", "onProgress"), b.g(2), f.d("registrationName", "onLoad"), b.g(1), f.d("registrationName", "onError"), b.g(3), f.d("registrationName", "onLoadEnd")));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    @h7.a(name = "accessible")
    public void setAccessible(ReactImageView reactImageView, boolean z10) {
        reactImageView.setFocusable(z10);
    }

    @h7.a(name = "blurRadius")
    public void setBlurRadius(ReactImageView reactImageView, float f10) {
        reactImageView.setBlurRadius(f10);
    }

    @h7.a(customType = "Color", name = "borderColor")
    public void setBorderColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.setBorderColor(0);
        } else {
            reactImageView.setBorderColor(num.intValue());
        }
    }

    @h7.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactImageView reactImageView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        if (i10 == 0) {
            reactImageView.setBorderRadius(f10);
        } else {
            reactImageView.q(f10, i10 - 1);
        }
    }

    @h7.a(name = "borderWidth")
    public void setBorderWidth(ReactImageView reactImageView, float f10) {
        reactImageView.setBorderWidth(f10);
    }

    @h7.a(name = "defaultSrc")
    public void setDefaultSource(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.setDefaultSource(str);
    }

    @h7.a(name = "fadeDuration")
    public void setFadeDuration(ReactImageView reactImageView, int i10) {
        reactImageView.setFadeDuration(i10);
    }

    @h7.a(name = "headers")
    public void setHeaders(ReactImageView reactImageView, ReadableMap readableMap) {
        reactImageView.setHeaders(readableMap);
    }

    @h7.a(name = "internal_analyticTag")
    public void setInternal_AnalyticsTag(ReactImageView reactImageView, @Nullable String str) {
    }

    @h7.a(name = "shouldNotifyLoadEvents")
    public void setLoadHandlersRegistered(ReactImageView reactImageView, boolean z10) {
        reactImageView.setShouldNotifyLoadEvents(z10);
    }

    @h7.a(name = "loadingIndicatorSrc")
    public void setLoadingIndicatorSource(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.setLoadingIndicatorSource(str);
    }

    @h7.a(customType = "Color", name = "overlayColor")
    public void setOverlayColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.setOverlayColor(0);
        } else {
            reactImageView.setOverlayColor(num.intValue());
        }
    }

    @h7.a(name = "progressiveRenderingEnabled")
    public void setProgressiveRenderingEnabled(ReactImageView reactImageView, boolean z10) {
        reactImageView.setProgressiveRenderingEnabled(z10);
    }

    @h7.a(name = "resizeMethod")
    public void setResizeMethod(ReactImageView reactImageView, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactImageView.setResizeMethod(c.AUTO);
        } else if ("resize".equals(str)) {
            reactImageView.setResizeMethod(c.RESIZE);
        } else if ("scale".equals(str)) {
            reactImageView.setResizeMethod(c.SCALE);
        } else {
            reactImageView.setResizeMethod(c.AUTO);
            z2.a.G("ReactNative", "Invalid resize method: '" + str + "'");
        }
    }

    @h7.a(name = "resizeMode")
    public void setResizeMode(ReactImageView reactImageView, @Nullable String str) {
        reactImageView.setScaleType(d.c(str));
        reactImageView.setTileMode(d.d(str));
    }

    @h7.a(name = "resizeMultiplier")
    public void setResizeMultiplier(ReactImageView reactImageView, float f10) {
        if (f10 < 0.01f) {
            z2.a.G("ReactNative", "Invalid resize multiplier: '" + f10 + "'");
        }
        reactImageView.setResizeMultiplier(f10);
    }

    @h7.a(name = "source")
    public void setSource(ReactImageView reactImageView, @Nullable ReadableArray readableArray) {
        reactImageView.setSource(readableArray);
    }

    @h7.a(name = "src")
    public void setSrc(ReactImageView reactImageView, @Nullable ReadableArray readableArray) {
        setSource(reactImageView, readableArray);
    }

    @h7.a(customType = "Color", name = "tintColor")
    public void setTintColor(ReactImageView reactImageView, @Nullable Integer num) {
        if (num == null) {
            reactImageView.clearColorFilter();
        } else {
            reactImageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @Deprecated
    public ReactImageManager(@Nullable b bVar, @Nullable a aVar, @Nullable Object obj) {
        this.mDraweeControllerBuilder = bVar;
        this.mCallerContext = obj;
    }

    public ReactImageView createViewInstance(e1 e1Var) {
        return new ReactImageView(e1Var, getDraweeControllerBuilder(), (a) null, getCallerContext());
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactImageView reactImageView) {
        super.onAfterUpdateTransaction(reactImageView);
        reactImageView.p();
    }

    public ReactImageManager(@Nullable b bVar, @Nullable f fVar) {
        this(bVar, (a) null, fVar);
    }

    public ReactImageManager(@Nullable b bVar, @Nullable a aVar, @Nullable f fVar) {
        this.mDraweeControllerBuilder = bVar;
        this.mCallerContext = null;
    }

    public ReactImageManager() {
        this.mDraweeControllerBuilder = null;
        this.mCallerContext = null;
    }
}
