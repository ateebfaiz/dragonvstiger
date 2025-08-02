package androidx.webkit;

import android.app.PendingIntent;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.webkit.internal.SafeBrowsingResponseImpl;
import androidx.webkit.internal.WebResourceErrorImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {WebViewFeature.VISUAL_STATE_CALLBACK, WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR, WebViewFeature.RECEIVE_HTTP_ERROR, WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS, WebViewFeature.SAFE_BROWSING_HIT};

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SafeBrowsingThreat {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @UiThread
    public void onPageCommitVisible(WebView webView, String str) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(invocationHandler));
    }

    @UiThread
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i10, InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i10, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(invocationHandler));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean onWebAuthnIntent(WebView webView, PendingIntent pendingIntent, InvocationHandler invocationHandler) {
        return false;
    }

    @UiThread
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    @RequiresApi(23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(webResourceError));
    }

    @RequiresApi(27)
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i10, SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i10, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(safeBrowsingResponse));
    }

    @UiThread
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE) && WebViewFeature.isFeatureSupported(WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION) && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceErrorCompat.getErrorCode(), webResourceErrorCompat.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @UiThread
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i10, SafeBrowsingResponseCompat safeBrowsingResponseCompat) {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL)) {
            safeBrowsingResponseCompat.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
