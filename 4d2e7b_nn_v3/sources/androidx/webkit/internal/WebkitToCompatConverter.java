package androidx.webkit.internal;

import android.webkit.CookieManager;
import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import androidx.annotation.RequiresApi;
import gc.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebStorageBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class WebkitToCompatConverter {
    private final WebkitToCompatConverterBoundaryInterface mImpl;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.mImpl = webkitToCompatConverterBoundaryInterface;
    }

    public CookieManagerAdapter convertCookieManager(CookieManager cookieManager) {
        return new CookieManagerAdapter((WebViewCookieManagerBoundaryInterface) a.a(WebViewCookieManagerBoundaryInterface.class, this.mImpl.convertCookieManager(cookieManager)));
    }

    public InvocationHandler convertSafeBrowsingResponse(SafeBrowsingResponse safeBrowsingResponse) {
        return this.mImpl.convertSafeBrowsingResponse((Object) safeBrowsingResponse);
    }

    public InvocationHandler convertServiceWorkerSettings(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return this.mImpl.convertServiceWorkerSettings((Object) serviceWorkerWebSettings);
    }

    public WebSettingsAdapter convertSettings(WebSettings webSettings) {
        return new WebSettingsAdapter((WebSettingsBoundaryInterface) a.a(WebSettingsBoundaryInterface.class, this.mImpl.convertSettings(webSettings)));
    }

    public InvocationHandler convertWebMessagePort(WebMessagePort webMessagePort) {
        return this.mImpl.convertWebMessagePort((Object) webMessagePort);
    }

    public InvocationHandler convertWebResourceError(WebResourceError webResourceError) {
        return this.mImpl.convertWebResourceError((Object) webResourceError);
    }

    public WebResourceRequestAdapter convertWebResourceRequest(WebResourceRequest webResourceRequest) {
        return new WebResourceRequestAdapter((WebResourceRequestBoundaryInterface) a.a(WebResourceRequestBoundaryInterface.class, this.mImpl.convertWebResourceRequest(webResourceRequest)));
    }

    public WebStorageAdapter convertWebStorage(WebStorage webStorage) {
        return new WebStorageAdapter((WebStorageBoundaryInterface) a.a(WebStorageBoundaryInterface.class, this.mImpl.convertWebStorage(webStorage)));
    }

    @RequiresApi(27)
    public SafeBrowsingResponse convertSafeBrowsingResponse(InvocationHandler invocationHandler) {
        return f1.a(this.mImpl.convertSafeBrowsingResponse(invocationHandler));
    }

    @RequiresApi(24)
    public ServiceWorkerWebSettings convertServiceWorkerSettings(InvocationHandler invocationHandler) {
        return g1.a(this.mImpl.convertServiceWorkerSettings(invocationHandler));
    }

    @RequiresApi(23)
    public WebMessagePort convertWebMessagePort(InvocationHandler invocationHandler) {
        return (WebMessagePort) this.mImpl.convertWebMessagePort(invocationHandler);
    }

    @RequiresApi(23)
    public WebResourceError convertWebResourceError(InvocationHandler invocationHandler) {
        return (WebResourceError) this.mImpl.convertWebResourceError(invocationHandler);
    }
}
