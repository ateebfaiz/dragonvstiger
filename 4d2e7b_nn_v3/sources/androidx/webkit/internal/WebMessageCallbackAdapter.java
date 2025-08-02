package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;

public class WebMessageCallbackAdapter implements WebMessageCallbackBoundaryInterface {
    private final WebMessagePortCompat.WebMessageCallbackCompat mImpl;

    public WebMessageCallbackAdapter(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        this.mImpl = webMessageCallbackCompat;
    }

    public String[] getSupportedFeatures() {
        return new String[]{WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE};
    }

    public void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        WebMessageCompat webMessageCompatFromBoundaryInterface = WebMessageAdapter.webMessageCompatFromBoundaryInterface((WebMessageBoundaryInterface) a.a(WebMessageBoundaryInterface.class, invocationHandler2));
        if (webMessageCompatFromBoundaryInterface != null) {
            this.mImpl.onMessage(new WebMessagePortImpl(invocationHandler), webMessageCompatFromBoundaryInterface);
        }
    }
}
