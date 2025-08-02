package com.reactnativecommunity.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class RNCWebViewWrapper extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public static final a f11292b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final RNCWebView f11293a;

    public static final class a {
        private a() {
        }

        public final int a(WebView webView) {
            View view;
            m.f(webView, "webView");
            ViewParent parent = webView.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view != null) {
                return view.getId();
            }
            return -1;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RNCWebViewWrapper(Context context, RNCWebView rNCWebView) {
        super(context);
        m.f(context, "context");
        m.f(rNCWebView, "webView");
        rNCWebView.setBackgroundColor(0);
        addView(rNCWebView);
        View childAt = getChildAt(0);
        m.d(childAt, "null cannot be cast to non-null type com.reactnativecommunity.webview.RNCWebView");
        this.f11293a = (RNCWebView) childAt;
    }

    public static final int a(WebView webView) {
        return f11292b.a(webView);
    }

    public final RNCWebView getWebView() {
        return this.f11293a;
    }
}
