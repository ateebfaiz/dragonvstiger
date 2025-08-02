package androidx.webkit;

import androidx.webkit.Profile;

@Profile.ExperimentalUrlPrefetch
public class PrefetchNetworkException extends PrefetchException {
    public static final int NO_HTTP_RESPONSE_STATUS_CODE = 0;
    public final int httpResponseStatusCode;

    public PrefetchNetworkException(String str) {
        this(str, 0);
    }

    public PrefetchNetworkException(String str, int i10) {
        super(str);
        this.httpResponseStatusCode = i10;
    }

    public PrefetchNetworkException(int i10) {
        this.httpResponseStatusCode = i10;
    }

    public PrefetchNetworkException() {
        this(0);
    }
}
