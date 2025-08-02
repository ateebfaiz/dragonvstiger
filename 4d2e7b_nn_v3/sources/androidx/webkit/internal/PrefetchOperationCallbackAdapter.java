package androidx.webkit.internal;

import androidx.webkit.OutcomeReceiverCompat;
import androidx.webkit.PrefetchException;
import androidx.webkit.PrefetchNetworkException;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.PrefetchExceptionBoundaryInterface;
import org.chromium.support_lib_boundary.PrefetchNetworkExceptionBoundaryInterface;
import org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface;

public class PrefetchOperationCallbackAdapter {

    class a implements PrefetchOperationCallbackBoundaryInterface {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OutcomeReceiverCompat f16937a;

        a(OutcomeReceiverCompat outcomeReceiverCompat) {
            this.f16937a = outcomeReceiverCompat;
        }

        public void onFailure(InvocationHandler invocationHandler) {
            if (gc.a.f(invocationHandler, PrefetchNetworkExceptionBoundaryInterface.class.getName())) {
                this.f16937a.onError(PrefetchOperationCallbackAdapter.getNetworkException(invocationHandler));
            } else {
                this.f16937a.onError(PrefetchOperationCallbackAdapter.getPrefetchException(invocationHandler));
            }
        }

        public void onSuccess() {
            this.f16937a.onResult(null);
        }
    }

    public static InvocationHandler buildInvocationHandler(OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat) {
        return gc.a.c(new a(outcomeReceiverCompat));
    }

    /* access modifiers changed from: private */
    public static PrefetchNetworkException getNetworkException(InvocationHandler invocationHandler) {
        PrefetchNetworkExceptionBoundaryInterface prefetchNetworkExceptionBoundaryInterface = (PrefetchNetworkExceptionBoundaryInterface) gc.a.a(PrefetchNetworkExceptionBoundaryInterface.class, invocationHandler);
        if (prefetchNetworkExceptionBoundaryInterface.getMessage() != null) {
            return new PrefetchNetworkException(prefetchNetworkExceptionBoundaryInterface.getMessage(), prefetchNetworkExceptionBoundaryInterface.getHttpResponseStatusCode());
        }
        return new PrefetchNetworkException(prefetchNetworkExceptionBoundaryInterface.getHttpResponseStatusCode());
    }

    /* access modifiers changed from: private */
    public static PrefetchException getPrefetchException(InvocationHandler invocationHandler) {
        PrefetchExceptionBoundaryInterface prefetchExceptionBoundaryInterface = (PrefetchExceptionBoundaryInterface) gc.a.a(PrefetchExceptionBoundaryInterface.class, invocationHandler);
        if (prefetchExceptionBoundaryInterface.getMessage() != null) {
            return new PrefetchException(prefetchExceptionBoundaryInterface.getMessage());
        }
        return new PrefetchException();
    }
}
