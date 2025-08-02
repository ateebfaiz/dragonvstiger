package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.annotation.RequiresApi;
import androidx.webkit.SafeBrowsingResponseCompat;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;

public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {
    private SafeBrowsingResponseBoundaryInterface mBoundaryInterface;
    private SafeBrowsingResponse mFrameworksImpl;

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) a.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    private SafeBrowsingResponseBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) a.a(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(27)
    private SafeBrowsingResponse getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    public void backToSafety(boolean z10) {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY;
        if (o_mr1.isSupportedByFramework()) {
            ApiHelperForOMR1.backToSafety(getFrameworksImpl(), z10);
        } else if (o_mr1.isSupportedByWebView()) {
            getBoundaryInterface().backToSafety(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void proceed(boolean z10) {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_PROCEED;
        if (o_mr1.isSupportedByFramework()) {
            ApiHelperForOMR1.proceed(getFrameworksImpl(), z10);
        } else if (o_mr1.isSupportedByWebView()) {
            getBoundaryInterface().proceed(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void showInterstitial(boolean z10) {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL;
        if (o_mr1.isSupportedByFramework()) {
            ApiHelperForOMR1.showInterstitial(getFrameworksImpl(), z10);
        } else if (o_mr1.isSupportedByWebView()) {
            getBoundaryInterface().showInterstitial(z10);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        this.mFrameworksImpl = safeBrowsingResponse;
    }
}
