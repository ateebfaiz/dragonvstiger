package androidx.webkit;

import androidx.webkit.internal.ProfileStoreImpl;
import androidx.webkit.internal.WebViewFeatureInternal;

public abstract /* synthetic */ class b {
    public static ProfileStore a() {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return ProfileStoreImpl.getInstance();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
