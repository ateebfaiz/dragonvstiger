package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.internal.ApiFeature;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;

public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(WebMessagePort webMessagePort) {
        this.mFrameworksImpl = webMessagePort;
    }

    @RequiresApi(23)
    public static WebMessage compatToFrameworkMessage(WebMessageCompat webMessageCompat) {
        return ApiHelperForM.createWebMessage(webMessageCompat);
    }

    @RequiresApi(23)
    public static WebMessagePort[] compatToPorts(WebMessagePortCompat[] webMessagePortCompatArr) {
        if (webMessagePortCompatArr == null) {
            return null;
        }
        int length = webMessagePortCompatArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i10 = 0; i10 < length; i10++) {
            webMessagePortArr[i10] = webMessagePortCompatArr[i10].getFrameworkPort();
        }
        return webMessagePortArr;
    }

    @RequiresApi(23)
    public static WebMessageCompat frameworkMessageToCompat(WebMessage webMessage) {
        return ApiHelperForM.createWebMessageCompat(webMessage);
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebMessagePortBoundaryInterface) a.a(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    @RequiresApi(23)
    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    public static WebMessagePortCompat[] portsToCompat(WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i10 = 0; i10 < webMessagePortArr.length; i10++) {
            webMessagePortCompatArr[i10] = new WebMessagePortImpl(webMessagePortArr[i10]);
        }
        return webMessagePortCompatArr;
    }

    public void close() {
        ApiFeature.M m10 = WebViewFeatureInternal.WEB_MESSAGE_PORT_CLOSE;
        if (m10.isSupportedByFramework()) {
            ApiHelperForM.close(getFrameworksImpl());
        } else if (m10.isSupportedByWebView()) {
            getBoundaryInterface().close();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @RequiresApi(23)
    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    public void postMessage(WebMessageCompat webMessageCompat) {
        ApiFeature.M m10 = WebViewFeatureInternal.WEB_MESSAGE_PORT_POST_MESSAGE;
        if (m10.isSupportedByFramework() && webMessageCompat.getType() == 0) {
            ApiHelperForM.postMessage(getFrameworksImpl(), compatToFrameworkMessage(webMessageCompat));
        } else if (!m10.isSupportedByWebView() || !WebMessageAdapter.isMessagePayloadTypeSupportedByWebView(webMessageCompat.getType())) {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        } else {
            getBoundaryInterface().postMessage(a.c(new WebMessageAdapter(webMessageCompat)));
        }
    }

    public void setWebMessageCallback(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m10 = WebViewFeatureInternal.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
        if (m10.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(a.c(new WebMessageCallbackAdapter(webMessageCallbackCompat)));
        } else if (m10.isSupportedByFramework()) {
            ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) a.a(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    public void setWebMessageCallback(Handler handler, WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        ApiFeature.M m10 = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (m10.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(a.c(new WebMessageCallbackAdapter(webMessageCallbackCompat)), handler);
        } else if (m10.isSupportedByFramework()) {
            ApiHelperForM.setWebMessageCallback(getFrameworksImpl(), webMessageCallbackCompat, handler);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
