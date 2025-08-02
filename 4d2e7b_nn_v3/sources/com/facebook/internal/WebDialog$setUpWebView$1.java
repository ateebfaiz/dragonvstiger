package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;

public final class WebDialog$setUpWebView$1 extends WebView {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebDialog f20368a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebDialog$setUpWebView$1(WebDialog webDialog, Context context) {
        super(context);
        this.f20368a = webDialog;
    }

    public void onWindowFocusChanged(boolean z10) {
        try {
            super.onWindowFocusChanged(z10);
        } catch (NullPointerException unused) {
        }
    }
}
