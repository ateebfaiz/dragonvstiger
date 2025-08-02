package androidx.webkit.internal;

import android.os.CancellationSignal;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import androidx.webkit.OutcomeReceiverCompat;
import androidx.webkit.PrefetchException;
import androidx.webkit.Profile;
import androidx.webkit.SpeculativeLoadingConfig;
import androidx.webkit.SpeculativeLoadingParameters;
import gc.a;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;

public class ProfileImpl implements Profile {
    private final ProfileBoundaryInterface mProfileImpl;

    ProfileImpl(ProfileBoundaryInterface profileBoundaryInterface) {
        this.mProfileImpl = profileBoundaryInterface;
    }

    public void clearPrefetchAsync(String str, Executor executor, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat) {
        if (WebViewFeatureInternal.PROFILE_URL_PREFETCH.isSupportedByWebView()) {
            this.mProfileImpl.clearPrefetch(str, executor, PrefetchOperationCallbackAdapter.buildInvocationHandler(outcomeReceiverCompat));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public CookieManager getCookieManager() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getCookieManager();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public GeolocationPermissions getGeolocationPermissions() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getGeoLocationPermissions();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public String getName() {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getName();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public ServiceWorkerController getServiceWorkerController() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getServiceWorkerController();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public WebStorage getWebStorage() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getWebStorage();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, SpeculativeLoadingParameters speculativeLoadingParameters, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat) {
        if (WebViewFeatureInternal.PROFILE_URL_PREFETCH.isSupportedByWebView()) {
            String str2 = str;
            CancellationSignal cancellationSignal2 = cancellationSignal;
            Executor executor2 = executor;
            this.mProfileImpl.prefetchUrl(str2, cancellationSignal2, executor2, a.c(new SpeculativeLoadingParametersAdapter(speculativeLoadingParameters)), PrefetchOperationCallbackAdapter.buildInvocationHandler(outcomeReceiverCompat));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setSpeculativeLoadingConfig(SpeculativeLoadingConfig speculativeLoadingConfig) {
        if (WebViewFeatureInternal.SPECULATIVE_LOADING_CONFIG.isSupportedByWebView()) {
            this.mProfileImpl.setSpeculativeLoadingConfig(a.c(new SpeculativeLoadingConfigAdapter(speculativeLoadingConfig)));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private ProfileImpl() {
        this.mProfileImpl = null;
    }

    public void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat) {
        if (WebViewFeatureInternal.PROFILE_URL_PREFETCH.isSupportedByWebView()) {
            this.mProfileImpl.prefetchUrl(str, cancellationSignal, executor, PrefetchOperationCallbackAdapter.buildInvocationHandler(outcomeReceiverCompat));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
