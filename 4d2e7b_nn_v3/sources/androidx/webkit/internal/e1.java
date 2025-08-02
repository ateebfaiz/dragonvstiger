package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;

public final /* synthetic */ class e1 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewRendererBoundaryInterface f16952a;

    public /* synthetic */ e1(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.f16952a = webViewRendererBoundaryInterface;
    }

    public final Object call() {
        return WebViewRenderProcessImpl.lambda$forInvocationHandler$0(this.f16952a);
    }
}
