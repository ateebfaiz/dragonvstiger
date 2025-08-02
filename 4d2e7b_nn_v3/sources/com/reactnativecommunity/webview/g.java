package com.reactnativecommunity.webview;

import android.webkit.DownloadListener;

public final /* synthetic */ class g implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RNCWebView f11302a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RNCWebViewManagerImpl f11303b;

    public /* synthetic */ g(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl) {
        this.f11302a = rNCWebView;
        this.f11303b = rNCWebViewManagerImpl;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        RNCWebViewManagerImpl.f(this.f11302a, this.f11303b, str, str2, str3, str4, j10);
    }
}
