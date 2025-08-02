package com.reactnativecommunity.webview;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import e6.f;
import h7.a;
import java.util.Map;

public class RNCWebViewManager extends ViewGroupManager<RNCWebViewWrapper> {
    private final RNCWebViewManagerImpl mRNCWebViewManagerImpl = new RNCWebViewManagerImpl();

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return this.mRNCWebViewManagerImpl.g();
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = f.b();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingStart", f.d("registrationName", "onLoadingStart"));
        exportedCustomDirectEventTypeConstants.put("topLoadingFinish", f.d("registrationName", "onLoadingFinish"));
        exportedCustomDirectEventTypeConstants.put("topLoadingError", f.d("registrationName", "onLoadingError"));
        exportedCustomDirectEventTypeConstants.put("topMessage", f.d("registrationName", "onMessage"));
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", f.d("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", f.d("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(com.facebook.react.views.scroll.f.b(com.facebook.react.views.scroll.f.SCROLL), f.d("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", f.d("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put("topRenderProcessGone", f.d("registrationName", "onRenderProcessGone"));
        exportedCustomDirectEventTypeConstants.put("topCustomMenuSelection", f.d("registrationName", "onCustomMenuSelection"));
        exportedCustomDirectEventTypeConstants.put("topOpenWindow", f.d("registrationName", "onOpenWindow"));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return "RNCWebView";
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @a(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.o(rNCWebViewWrapper, z10);
    }

    @a(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.p(rNCWebViewWrapper, z10);
    }

    @a(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.q(rNCWebViewWrapper, z10);
    }

    @a(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.r(rNCWebViewWrapper, z10);
    }

    @a(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.s(rNCWebViewWrapper, z10);
    }

    @a(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.t(rNCWebViewWrapper, str);
    }

    @a(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.u(rNCWebViewWrapper, str);
    }

    @a(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.v(rNCWebViewWrapper, readableMap);
    }

    @a(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.w(rNCWebViewWrapper, z10);
    }

    @a(name = "cacheMode")
    public void setCacheMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.x(rNCWebViewWrapper, str);
    }

    @a(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.y(rNCWebViewWrapper, z10);
    }

    @a(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.z(str);
    }

    @a(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.A(rNCWebViewWrapper, z10);
    }

    @a(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.B(rNCWebViewWrapper, z10);
    }

    @a(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.C(rNCWebViewWrapper, z10);
    }

    @a(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.D(rNCWebViewWrapper, z10);
    }

    @a(name = "incognito")
    public void setIncognito(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.E(rNCWebViewWrapper, z10);
    }

    @a(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.F(rNCWebViewWrapper, str);
    }

    @a(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.G(rNCWebViewWrapper, str);
    }

    @a(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.H(rNCWebViewWrapper, z10);
    }

    @a(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.I(rNCWebViewWrapper, z10);
    }

    @a(name = "injectedJavaScriptObject")
    public void setInjectedJavaScriptObject(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.J(rNCWebViewWrapper, str);
    }

    @a(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.K(rNCWebViewWrapper, z10);
    }

    @a(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.L(rNCWebViewWrapper, z10);
    }

    @a(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.M(str);
    }

    @a(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.N(rNCWebViewWrapper, z10);
    }

    @a(name = "menuItems")
    public void setMenuCustomItems(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableArray readableArray) {
        this.mRNCWebViewManagerImpl.O(rNCWebViewWrapper, readableArray);
    }

    @a(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.P(rNCWebViewWrapper, z10);
    }

    @a(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.Q(rNCWebViewWrapper, str);
    }

    @a(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebViewWrapper rNCWebViewWrapper, int i10) {
        this.mRNCWebViewManagerImpl.R(rNCWebViewWrapper, i10);
    }

    @a(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.S(rNCWebViewWrapper, str);
    }

    @a(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.T(rNCWebViewWrapper, z10);
    }

    @a(name = "overScrollMode")
    public void setOverScrollMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.U(rNCWebViewWrapper, str);
    }

    @a(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.V(rNCWebViewWrapper, z10);
    }

    @a(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.W(rNCWebViewWrapper, z10);
    }

    @a(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.X(rNCWebViewWrapper, z10);
    }

    @a(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.Y(rNCWebViewWrapper, z10);
    }

    @a(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.Z(rNCWebViewWrapper, z10);
    }

    @a(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.a0(rNCWebViewWrapper, z10);
    }

    @a(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.b0(rNCWebViewWrapper, z10);
    }

    @a(name = "source")
    public void setSource(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.c0(rNCWebViewWrapper, readableMap);
    }

    @a(name = "textZoom")
    public void setTextZoom(RNCWebViewWrapper rNCWebViewWrapper, int i10) {
        this.mRNCWebViewManagerImpl.d0(rNCWebViewWrapper, i10);
    }

    @a(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.e0(rNCWebViewWrapper, z10);
    }

    @a(name = "userAgent")
    public void setUserAgent(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.f0(rNCWebViewWrapper, str);
    }

    @a(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z10) {
        this.mRNCWebViewManagerImpl.h0(rNCWebViewWrapper, z10);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@NonNull e1 e1Var, RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().setWebViewClient(new d());
    }

    public RNCWebViewWrapper createViewInstance(e1 e1Var) {
        return this.mRNCWebViewManagerImpl.d(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@NonNull RNCWebViewWrapper rNCWebViewWrapper) {
        super.onAfterUpdateTransaction(rNCWebViewWrapper);
        this.mRNCWebViewManagerImpl.l(rNCWebViewWrapper);
    }

    public void onDropViewInstance(@NonNull RNCWebViewWrapper rNCWebViewWrapper) {
        this.mRNCWebViewManagerImpl.m(rNCWebViewWrapper);
        super.onDropViewInstance(rNCWebViewWrapper);
    }

    public void receiveCommand(@NonNull RNCWebViewWrapper rNCWebViewWrapper, String str, @Nullable ReadableArray readableArray) {
        this.mRNCWebViewManagerImpl.n(rNCWebViewWrapper, str, readableArray);
        super.receiveCommand(rNCWebViewWrapper, str, readableArray);
    }

    public RNCWebViewWrapper createViewInstance(e1 e1Var, RNCWebView rNCWebView) {
        return this.mRNCWebViewManagerImpl.e(e1Var, rNCWebView);
    }
}
