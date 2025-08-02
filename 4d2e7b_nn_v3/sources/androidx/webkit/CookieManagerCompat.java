package androidx.webkit;

import android.webkit.CookieManager;
import androidx.annotation.AnyThread;
import androidx.webkit.internal.CookieManagerAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.util.List;

@AnyThread
public class CookieManagerCompat {
    private CookieManagerCompat() {
    }

    private static CookieManagerAdapter getAdapter(CookieManager cookieManager) {
        return WebViewGlueCommunicator.getCompatConverter().convertCookieManager(cookieManager);
    }

    public static List<String> getCookieInfo(CookieManager cookieManager, String str) {
        if (WebViewFeatureInternal.GET_COOKIE_INFO.isSupportedByWebView()) {
            return getAdapter(cookieManager).getCookieInfo(str);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
