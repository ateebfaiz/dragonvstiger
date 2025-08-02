package androidx.webkit.internal;

import android.webkit.WebResourceError;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;

public class WebResourceErrorImpl extends WebResourceErrorCompat {
    private WebResourceErrorBoundaryInterface mBoundaryInterface;
    private WebResourceError mFrameworksImpl;

    public WebResourceErrorImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    private WebResourceErrorBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebResourceErrorBoundaryInterface) a.a(WebResourceErrorBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(23)
    private WebResourceError getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebResourceError(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    public CharSequence getDescription() {
        ApiFeature.M m10 = WebViewFeatureInternal.WEB_RESOURCE_ERROR_GET_DESCRIPTION;
        if (m10.isSupportedByFramework()) {
            return ApiHelperForM.getDescription(getFrameworksImpl());
        }
        if (m10.isSupportedByWebView()) {
            return getBoundaryInterface().getDescription();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public int getErrorCode() {
        ApiFeature.M m10 = WebViewFeatureInternal.WEB_RESOURCE_ERROR_GET_CODE;
        if (m10.isSupportedByFramework()) {
            return ApiHelperForM.getErrorCode(getFrameworksImpl());
        }
        if (m10.isSupportedByWebView()) {
            return getBoundaryInterface().getErrorCode();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebResourceErrorImpl(WebResourceError webResourceError) {
        this.mFrameworksImpl = webResourceError;
    }
}
