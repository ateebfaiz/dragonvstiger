package androidx.webkit;

import android.os.CancellationSignal;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresOptIn;
import androidx.annotation.UiThread;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.Executor;

public interface Profile {
    public static final String DEFAULT_PROFILE_NAME = "Default";

    @RequiresOptIn(level = RequiresOptIn.Level.ERROR)
    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.CLASS)
    public @interface ExperimentalUrlPrefetch {
    }

    @ExperimentalUrlPrefetch
    @UiThread
    void clearPrefetchAsync(String str, Executor executor, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat);

    @AnyThread
    CookieManager getCookieManager();

    @AnyThread
    GeolocationPermissions getGeolocationPermissions();

    @AnyThread
    String getName();

    @AnyThread
    ServiceWorkerController getServiceWorkerController();

    @AnyThread
    WebStorage getWebStorage();

    @ExperimentalUrlPrefetch
    @UiThread
    void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat);

    @ExperimentalUrlPrefetch
    @UiThread
    void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, SpeculativeLoadingParameters speculativeLoadingParameters, OutcomeReceiverCompat<Void, PrefetchException> outcomeReceiverCompat);

    @ExperimentalUrlPrefetch
    @UiThread
    void setSpeculativeLoadingConfig(SpeculativeLoadingConfig speculativeLoadingConfig);
}
