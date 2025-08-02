package androidx.webkit.internal;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.webkit.ServiceWorkerClientCompat;
import androidx.webkit.WebViewFeature;
import org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface;

public class ServiceWorkerClientAdapter implements ServiceWorkerClientBoundaryInterface {
    private final ServiceWorkerClientCompat mClient;

    public ServiceWorkerClientAdapter(ServiceWorkerClientCompat serviceWorkerClientCompat) {
        this.mClient = serviceWorkerClientCompat;
    }

    public String[] getSupportedFeatures() {
        return new String[]{WebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST};
    }

    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.mClient.shouldInterceptRequest(webResourceRequest);
    }
}
