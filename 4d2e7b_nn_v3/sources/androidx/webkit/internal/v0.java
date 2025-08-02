package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

public final /* synthetic */ class v0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsReplyProxyBoundaryInterface f16953a;

    public /* synthetic */ v0(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f16953a = jsReplyProxyBoundaryInterface;
    }

    public final Object call() {
        return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0(this.f16953a);
    }
}
