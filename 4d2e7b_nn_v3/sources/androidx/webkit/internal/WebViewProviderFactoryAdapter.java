package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpConfig;
import gc.a;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {
    final WebViewProviderFactoryBoundaryInterface mImpl;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.mImpl = webViewProviderFactoryBoundaryInterface;
    }

    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) a.a(WebViewProviderBoundaryInterface.class, this.mImpl.createWebView(webView));
    }

    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) a.a(DropDataContentProviderBoundaryInterface.class, this.mImpl.getDropDataProvider());
    }

    public ProfileStoreBoundaryInterface getProfileStore() {
        return (ProfileStoreBoundaryInterface) a.a(ProfileStoreBoundaryInterface.class, this.mImpl.getProfileStore());
    }

    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) a.a(ProxyControllerBoundaryInterface.class, this.mImpl.getProxyController());
    }

    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        return (ServiceWorkerControllerBoundaryInterface) a.a(ServiceWorkerControllerBoundaryInterface.class, this.mImpl.getServiceWorkerController());
    }

    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) a.a(StaticsBoundaryInterface.class, this.mImpl.getStatics());
    }

    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) a.a(TracingControllerBoundaryInterface.class, this.mImpl.getTracingController());
    }

    public String[] getWebViewFeatures() {
        return this.mImpl.getSupportedFeatures();
    }

    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) a.a(WebkitToCompatConverterBoundaryInterface.class, this.mImpl.getWebkitToCompatConverter());
    }

    public void startUpWebView(WebViewStartUpConfig webViewStartUpConfig, WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.mImpl.startUpWebView(a.c(new WebViewStartUpConfigAdapter(webViewStartUpConfig)), a.c(new WebViewStartUpCallbackAdapter(webViewStartUpCallback)));
    }
}
