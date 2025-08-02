package androidx.webkit.internal;

import androidx.annotation.RequiresApi;
import androidx.webkit.TracingConfig;
import androidx.webkit.TracingController;
import androidx.webkit.internal.ApiFeature;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

public class TracingControllerImpl extends TracingController {
    private TracingControllerBoundaryInterface mBoundaryInterface;
    private android.webkit.TracingController mFrameworksImpl;

    public TracingControllerImpl() {
        ApiFeature.P p10 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (p10.isSupportedByFramework()) {
            this.mFrameworksImpl = ApiHelperForP.getTracingControllerInstance();
            this.mBoundaryInterface = null;
        } else if (p10.isSupportedByWebView()) {
            this.mFrameworksImpl = null;
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private TracingControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(28)
    private android.webkit.TracingController getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = ApiHelperForP.getTracingControllerInstance();
        }
        return this.mFrameworksImpl;
    }

    public boolean isTracing() {
        ApiFeature.P p10 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (p10.isSupportedByFramework()) {
            return ApiHelperForP.isTracing(getFrameworksImpl());
        }
        if (p10.isSupportedByWebView()) {
            return getBoundaryInterface().isTracing();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void start(TracingConfig tracingConfig) {
        if (tracingConfig != null) {
            ApiFeature.P p10 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
            if (p10.isSupportedByFramework()) {
                ApiHelperForP.start(getFrameworksImpl(), tracingConfig);
            } else if (p10.isSupportedByWebView()) {
                getBoundaryInterface().start(tracingConfig.getPredefinedCategories(), tracingConfig.getCustomIncludedCategories(), tracingConfig.getTracingMode());
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        } else {
            throw new IllegalArgumentException("Tracing config must be non null");
        }
    }

    public boolean stop(OutputStream outputStream, Executor executor) {
        ApiFeature.P p10 = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (p10.isSupportedByFramework()) {
            return ApiHelperForP.stop(getFrameworksImpl(), outputStream, executor);
        }
        if (p10.isSupportedByWebView()) {
            return getBoundaryInterface().stop(outputStream, executor);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
