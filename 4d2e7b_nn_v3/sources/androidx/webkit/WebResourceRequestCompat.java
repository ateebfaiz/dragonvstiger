package androidx.webkit;

import android.webkit.WebResourceRequest;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForN;
import androidx.webkit.internal.WebResourceRequestAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;

public class WebResourceRequestCompat {
    private WebResourceRequestCompat() {
    }

    private static WebResourceRequestAdapter getAdapter(WebResourceRequest webResourceRequest) {
        return WebViewGlueCommunicator.getCompatConverter().convertWebResourceRequest(webResourceRequest);
    }

    public static boolean isRedirect(WebResourceRequest webResourceRequest) {
        ApiFeature.N n10 = WebViewFeatureInternal.WEB_RESOURCE_REQUEST_IS_REDIRECT;
        if (n10.isSupportedByFramework()) {
            return ApiHelperForN.isRedirect(webResourceRequest);
        }
        if (n10.isSupportedByWebView()) {
            return getAdapter(webResourceRequest).isRedirect();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
