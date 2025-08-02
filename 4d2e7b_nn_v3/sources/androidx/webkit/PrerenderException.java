package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewCompat;

@WebViewCompat.ExperimentalUrlPrerender
public class PrerenderException extends Exception {
    public PrerenderException(@NonNull String str, @Nullable Throwable th) {
        super(str, th);
    }
}
