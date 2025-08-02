package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import e6.f;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.v;
import p7.w;

@s6.a(name = "RNSScreenStackHeaderConfig")
public final class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> implements w {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";
    private final c2 delegate = new v(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void logNotAvailable(String str) {
        Log.w("[RNScreens]", str + " prop is not available on Android");
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return f.e("topAttached", f.d("registrationName", "onAttached"), "topDetached", f.d("registrationName", "onDetached"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderConfig createViewInstance(e1 e1Var) {
        m.f(e1Var, "reactContext");
        return new ScreenStackHeaderConfig(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ScreenStackHeaderConfig screenStackHeaderConfig) {
        m.f(screenStackHeaderConfig, "parent");
        super.onAfterUpdateTransaction(screenStackHeaderConfig);
        screenStackHeaderConfig.h();
    }

    public void onDropViewInstance(ScreenStackHeaderConfig screenStackHeaderConfig) {
        m.f(screenStackHeaderConfig, "view");
        screenStackHeaderConfig.d();
    }

    public void removeAllViews(ScreenStackHeaderConfig screenStackHeaderConfig) {
        m.f(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.i();
    }

    public void setBackButtonDisplayMode(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("backButtonDisplayMode");
    }

    @h7.a(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackButtonInCustomView(z10);
    }

    public void setBackTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("backTitle");
    }

    public void setBackTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("backTitleFontFamily");
    }

    public void setBackTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i10) {
        logNotAvailable("backTitleFontSize");
    }

    public void setBackTitleVisible(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        logNotAvailable("backTitleVisible");
    }

    @h7.a(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackgroundColor(num);
    }

    public void setBlurEffect(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("blurEffect");
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTintColor(num != null ? num.intValue() : 0);
    }

    @h7.a(name = "direction")
    public void setDirection(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setDirection(str);
    }

    public void setDisableBackButtonMenu(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        logNotAvailable("disableBackButtonMenu");
    }

    @h7.a(name = "hidden")
    public void setHidden(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHidden(z10);
    }

    @h7.a(name = "hideBackButton")
    public void setHideBackButton(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideBackButton(z10);
    }

    @h7.a(name = "hideShadow")
    public void setHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideShadow(z10);
    }

    public void setLargeTitle(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        logNotAvailable("largeTitle");
    }

    public void setLargeTitleBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        logNotAvailable("largeTitleBackgroundColor");
    }

    public void setLargeTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        logNotAvailable("largeTitleColor");
    }

    public void setLargeTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("largeTitleFontFamily");
    }

    public void setLargeTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i10) {
        logNotAvailable("largeTitleFontSize");
    }

    public void setLargeTitleFontWeight(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("largeTitleFontWeight");
    }

    public void setLargeTitleHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        logNotAvailable("largeTitleHideShadow");
    }

    @h7.a(name = "title")
    public void setTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitle(str);
    }

    @h7.a(customType = "Color", name = "titleColor")
    public void setTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        m.f(screenStackHeaderConfig, "config");
        if (num != null) {
            screenStackHeaderConfig.setTitleColor(num.intValue());
        }
    }

    @h7.a(name = "titleFontFamily")
    public void setTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontFamily(str);
    }

    @h7.a(name = "titleFontSize")
    public void setTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontSize((float) i10);
    }

    @h7.a(name = "titleFontWeight")
    public void setTitleFontWeight(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontWeight(str);
    }

    @h7.a(name = "topInsetEnabled")
    public void setTopInsetEnabled(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTopInsetEnabled(z10);
    }

    @h7.a(name = "translucent")
    public void setTranslucent(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z10) {
        m.f(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTranslucent(z10);
    }

    public void addView(ScreenStackHeaderConfig screenStackHeaderConfig, View view, int i10) {
        m.f(screenStackHeaderConfig, "parent");
        m.f(view, "child");
        if (view instanceof ScreenStackHeaderSubview) {
            screenStackHeaderConfig.b((ScreenStackHeaderSubview) view, i10);
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    public View getChildAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i10) {
        m.f(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.e(i10);
    }

    public int getChildCount(ScreenStackHeaderConfig screenStackHeaderConfig) {
        m.f(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.getConfigSubviewsCount();
    }

    public void removeViewAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i10) {
        m.f(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.j(i10);
    }
}
