package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private static final String[] sFeatures = {WebViewFeature.WEB_MESSAGE_ARRAY_BUFFER};
    private final WebMessageCompat mWebMessageCompat;

    public WebMessageAdapter(WebMessageCompat webMessageCompat) {
        this.mWebMessageCompat = webMessageCompat;
    }

    public static boolean isMessagePayloadTypeSupportedByWebView(int i10) {
        if (i10 == 0) {
            return true;
        }
        if (i10 != 1 || !WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            return false;
        }
        return true;
    }

    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i10 = 0; i10 < invocationHandlerArr.length; i10++) {
            webMessagePortCompatArr[i10] = new WebMessagePortImpl(invocationHandlerArr[i10]);
        }
        return webMessagePortCompatArr;
    }

    public static WebMessageCompat webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] webMessagePortCompats = toWebMessagePortCompats(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), webMessagePortCompats);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) a.a(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), webMessagePortCompats);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), webMessagePortCompats);
    }

    @Deprecated
    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    public InvocationHandler getMessagePayload() {
        WebMessagePayloadAdapter webMessagePayloadAdapter;
        int type = this.mWebMessageCompat.getType();
        if (type == 0) {
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(this.mWebMessageCompat.getData());
        } else if (type == 1) {
            byte[] arrayBuffer = this.mWebMessageCompat.getArrayBuffer();
            Objects.requireNonNull(arrayBuffer);
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(arrayBuffer);
        } else {
            throw new IllegalStateException("Unknown web message payload type: " + this.mWebMessageCompat.getType());
        }
        return a.c(webMessagePayloadAdapter);
    }

    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[ports.length];
        for (int i10 = 0; i10 < ports.length; i10++) {
            invocationHandlerArr[i10] = ports[i10].getInvocationHandler();
        }
        return invocationHandlerArr;
    }

    public String[] getSupportedFeatures() {
        return sFeatures;
    }
}
