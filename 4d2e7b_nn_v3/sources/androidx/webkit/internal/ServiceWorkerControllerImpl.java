package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;

public class ServiceWorkerControllerImpl extends ServiceWorkerControllerCompat {
    private ServiceWorkerControllerBoundaryInterface mBoundaryInterface;
    private ServiceWorkerController mFrameworksImpl;
    private final ServiceWorkerWebSettingsCompat mWebSettings;

    public ServiceWorkerControllerImpl() {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_BASIC_USAGE;
        if (n10.isSupportedByFramework()) {
            this.mFrameworksImpl = ApiHelperForN.getServiceWorkerControllerInstance();
            this.mBoundaryInterface = null;
            this.mWebSettings = ApiHelperForN.getServiceWorkerWebSettingsImpl(getFrameworksImpl());
        } else if (n10.isSupportedByWebView()) {
            this.mFrameworksImpl = null;
            ServiceWorkerControllerBoundaryInterface serviceWorkerController = WebViewGlueCommunicator.getFactory().getServiceWorkerController();
            this.mBoundaryInterface = serviceWorkerController;
            this.mWebSettings = new ServiceWorkerWebSettingsImpl(serviceWorkerController.getServiceWorkerWebSettings());
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private ServiceWorkerControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getServiceWorkerController();
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(24)
    private ServiceWorkerController getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = ApiHelperForN.getServiceWorkerControllerInstance();
        }
        return this.mFrameworksImpl;
    }

    public ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings() {
        return this.mWebSettings;
    }

    public void setServiceWorkerClient(ServiceWorkerClientCompat serviceWorkerClientCompat) {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_BASIC_USAGE;
        if (n10.isSupportedByFramework()) {
            if (serviceWorkerClientCompat == null) {
                ApiHelperForN.setServiceWorkerClient(getFrameworksImpl(), (ServiceWorkerClient) null);
            } else {
                ApiHelperForN.setServiceWorkerClientCompat(getFrameworksImpl(), serviceWorkerClientCompat);
            }
        } else if (!n10.isSupportedByWebView()) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        } else if (serviceWorkerClientCompat == null) {
            getBoundaryInterface().setServiceWorkerClient((InvocationHandler) null);
        } else {
            getBoundaryInterface().setServiceWorkerClient(a.c(new ServiceWorkerClientAdapter(serviceWorkerClientCompat)));
        }
    }
}
