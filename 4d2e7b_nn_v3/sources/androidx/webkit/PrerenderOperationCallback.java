package androidx.webkit;

import androidx.webkit.WebViewCompat;

@WebViewCompat.ExperimentalUrlPrerender
public interface PrerenderOperationCallback {
    void onError(PrerenderException prerenderException);

    void onPrerenderActivated();
}
