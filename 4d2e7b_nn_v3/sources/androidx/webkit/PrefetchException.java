package androidx.webkit;

import androidx.webkit.Profile;

@Profile.ExperimentalUrlPrefetch
public class PrefetchException extends Exception {
    public PrefetchException(String str) {
        super(str);
    }

    public PrefetchException() {
    }
}
