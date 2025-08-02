package androidx.webkit.internal;

import android.webkit.ServiceWorkerWebSettings;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Set;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;

public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {
    private ServiceWorkerWebSettingsBoundaryInterface mBoundaryInterface;
    private ServiceWorkerWebSettings mFrameworksImpl;

    public ServiceWorkerWebSettingsImpl(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        this.mFrameworksImpl = serviceWorkerWebSettings;
    }

    private ServiceWorkerWebSettingsBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) a.a(ServiceWorkerWebSettingsBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(24)
    private ServiceWorkerWebSettings getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertServiceWorkerSettings(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    public boolean getAllowContentAccess() {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (n10.isSupportedByFramework()) {
            return ApiHelperForN.getAllowContentAccess(getFrameworksImpl());
        }
        if (n10.isSupportedByWebView()) {
            return getBoundaryInterface().getAllowContentAccess();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean getAllowFileAccess() {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (n10.isSupportedByFramework()) {
            return ApiHelperForN.getAllowFileAccess(getFrameworksImpl());
        }
        if (n10.isSupportedByWebView()) {
            return getBoundaryInterface().getAllowFileAccess();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean getBlockNetworkLoads() {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (n10.isSupportedByFramework()) {
            return ApiHelperForN.getBlockNetworkLoads(getFrameworksImpl());
        }
        if (n10.isSupportedByWebView()) {
            return getBoundaryInterface().getBlockNetworkLoads();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public int getCacheMode() {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (n10.isSupportedByFramework()) {
            return ApiHelperForN.getCacheMode(getFrameworksImpl());
        }
        if (n10.isSupportedByWebView()) {
            return getBoundaryInterface().getCacheMode();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public Set<String> getRequestedWithHeaderOriginAllowList() {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            return getBoundaryInterface().getRequestedWithHeaderOriginAllowList();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setAllowContentAccess(boolean z10) {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_CONTENT_ACCESS;
        if (n10.isSupportedByFramework()) {
            ApiHelperForN.setAllowContentAccess(getFrameworksImpl(), z10);
        } else if (n10.isSupportedByWebView()) {
            getBoundaryInterface().setAllowContentAccess(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setAllowFileAccess(boolean z10) {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_FILE_ACCESS;
        if (n10.isSupportedByFramework()) {
            ApiHelperForN.setAllowFileAccess(getFrameworksImpl(), z10);
        } else if (n10.isSupportedByWebView()) {
            getBoundaryInterface().setAllowFileAccess(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setBlockNetworkLoads(boolean z10) {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_BLOCK_NETWORK_LOADS;
        if (n10.isSupportedByFramework()) {
            ApiHelperForN.setBlockNetworkLoads(getFrameworksImpl(), z10);
        } else if (n10.isSupportedByWebView()) {
            getBoundaryInterface().setBlockNetworkLoads(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setCacheMode(int i10) {
        ApiFeature.N n10 = WebViewFeatureInternal.SERVICE_WORKER_CACHE_MODE;
        if (n10.isSupportedByFramework()) {
            ApiHelperForN.setCacheMode(getFrameworksImpl(), i10);
        } else if (n10.isSupportedByWebView()) {
            getBoundaryInterface().setCacheMode(i10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setRequestedWithHeaderOriginAllowList(Set<String> set) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            getBoundaryInterface().setRequestedWithHeaderOriginAllowList(set);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public ServiceWorkerWebSettingsImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (ServiceWorkerWebSettingsBoundaryInterface) a.a(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
