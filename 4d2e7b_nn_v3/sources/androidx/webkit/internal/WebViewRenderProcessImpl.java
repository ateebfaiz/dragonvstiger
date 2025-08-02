package androidx.webkit.internal;

import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

public class WebViewRenderProcessImpl extends WebViewRenderProcess {
    private static final WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> sFrameworkMap = new WeakHashMap<>();
    private WebViewRendererBoundaryInterface mBoundaryInterface;
    private WeakReference<android.webkit.WebViewRenderProcess> mFrameworkObject;

    public WebViewRenderProcessImpl(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.mBoundaryInterface = webViewRendererBoundaryInterface;
    }

    public static WebViewRenderProcessImpl forFrameworkObject(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> weakHashMap = sFrameworkMap;
        WebViewRenderProcessImpl webViewRenderProcessImpl = weakHashMap.get(webViewRenderProcess);
        if (webViewRenderProcessImpl != null) {
            return webViewRenderProcessImpl;
        }
        WebViewRenderProcessImpl webViewRenderProcessImpl2 = new WebViewRenderProcessImpl(webViewRenderProcess);
        weakHashMap.put(webViewRenderProcess, webViewRenderProcessImpl2);
        return webViewRenderProcessImpl2;
    }

    public static WebViewRenderProcessImpl forInvocationHandler(InvocationHandler invocationHandler) {
        WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) a.a(WebViewRendererBoundaryInterface.class, invocationHandler);
        return (WebViewRenderProcessImpl) webViewRendererBoundaryInterface.getOrCreatePeer(new e1(webViewRendererBoundaryInterface));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$forInvocationHandler$0(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) throws Exception {
        return new WebViewRenderProcessImpl(webViewRendererBoundaryInterface);
    }

    public boolean terminate() {
        ApiFeature.Q q10 = WebViewFeatureInternal.WEB_VIEW_RENDERER_TERMINATE;
        if (q10.isSupportedByFramework()) {
            android.webkit.WebViewRenderProcess a10 = d1.a(this.mFrameworkObject.get());
            if (a10 == null || !ApiHelperForQ.terminate(a10)) {
                return false;
            }
            return true;
        } else if (q10.isSupportedByWebView()) {
            return this.mBoundaryInterface.terminate();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public WebViewRenderProcessImpl(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        this.mFrameworkObject = new WeakReference<>(webViewRenderProcess);
    }
}
