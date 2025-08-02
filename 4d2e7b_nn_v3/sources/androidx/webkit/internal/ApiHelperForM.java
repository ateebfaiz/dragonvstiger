package androidx.webkit.internal;

import android.net.Uri;
import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

@RequiresApi(23)
public class ApiHelperForM {

    class a extends WebMessagePort.WebMessageCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat f16934a;

        a(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
            this.f16934a = webMessageCallbackCompat;
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f16934a.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
        }
    }

    class b extends WebMessagePort.WebMessageCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat f16935a;

        b(WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
            this.f16935a = webMessageCallbackCompat;
        }

        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f16935a.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
        }
    }

    class c extends WebView.VisualStateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebViewCompat.VisualStateCallback f16936a;

        c(WebViewCompat.VisualStateCallback visualStateCallback) {
            this.f16936a = visualStateCallback;
        }

        public void onComplete(long j10) {
            this.f16936a.onComplete(j10);
        }
    }

    private ApiHelperForM() {
    }

    public static void close(WebMessagePort webMessagePort) {
        webMessagePort.close();
    }

    public static WebMessage createWebMessage(WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.getData(), WebMessagePortImpl.compatToPorts(webMessageCompat.getPorts()));
    }

    public static WebMessagePort[] createWebMessageChannel(WebView webView) {
        return webView.createWebMessageChannel();
    }

    public static WebMessageCompat createWebMessageCompat(WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.portsToCompat(webMessage.getPorts()));
    }

    public static CharSequence getDescription(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int getErrorCode(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }

    public static boolean getOffscreenPreRaster(WebSettings webSettings) {
        return webSettings.getOffscreenPreRaster();
    }

    public static void postMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }

    public static void postVisualStateCallback(WebView webView, long j10, WebViewCompat.VisualStateCallback visualStateCallback) {
        webView.postVisualStateCallback(j10, new c(visualStateCallback));
    }

    public static void postWebMessage(WebView webView, WebMessage webMessage, Uri uri) {
        webView.postWebMessage(webMessage, uri);
    }

    public static void setOffscreenPreRaster(WebSettings webSettings, boolean z10) {
        webSettings.setOffscreenPreRaster(z10);
    }

    public static void setWebMessageCallback(WebMessagePort webMessagePort, WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        webMessagePort.setWebMessageCallback(new a(webMessageCallbackCompat));
    }

    public static void setWebMessageCallback(WebMessagePort webMessagePort, WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat, Handler handler) {
        webMessagePort.setWebMessageCallback(new b(webMessageCallbackCompat), handler);
    }
}
