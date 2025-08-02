package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpConfig;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public interface WebViewProviderFactory {
    WebViewProviderBoundaryInterface createWebView(WebView webView);

    DropDataContentProviderBoundaryInterface getDropDataProvider();

    ProfileStoreBoundaryInterface getProfileStore();

    ProxyControllerBoundaryInterface getProxyController();

    ServiceWorkerControllerBoundaryInterface getServiceWorkerController();

    StaticsBoundaryInterface getStatics();

    TracingControllerBoundaryInterface getTracingController();

    String[] getWebViewFeatures();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();

    void startUpWebView(WebViewStartUpConfig webViewStartUpConfig, WebViewCompat.WebViewStartUpCallback webViewStartUpCallback);
}
