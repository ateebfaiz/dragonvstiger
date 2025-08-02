package androidx.webkit.internal;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

@RequiresApi(29)
public class ApiHelperForQ {
    private ApiHelperForQ() {
    }

    @Deprecated
    public static int getForceDark(WebSettings webSettings) {
        return webSettings.getForceDark();
    }

    public static WebViewRenderProcess getWebViewRenderProcess(WebView webView) {
        return webView.getWebViewRenderProcess();
    }

    public static WebViewRenderProcessClient getWebViewRenderProcessClient(WebView webView) {
        return webView.getWebViewRenderProcessClient();
    }

    @Deprecated
    public static void setForceDark(WebSettings webSettings, int i10) {
        webSettings.setForceDark(i10);
    }

    public static void setWebViewRenderProcessClient(WebView webView, Executor executor, androidx.webkit.WebViewRenderProcessClient webViewRenderProcessClient) {
        webView.setWebViewRenderProcessClient(executor, webViewRenderProcessClient != null ? new WebViewRenderProcessClientFrameworkAdapter(webViewRenderProcessClient) : null);
    }

    public static boolean terminate(WebViewRenderProcess webViewRenderProcess) {
        return webViewRenderProcess.terminate();
    }

    public static void setWebViewRenderProcessClient(WebView webView, androidx.webkit.WebViewRenderProcessClient webViewRenderProcessClient) {
        webView.setWebViewRenderProcessClient(webViewRenderProcessClient != null ? new WebViewRenderProcessClientFrameworkAdapter(webViewRenderProcessClient) : null);
    }
}
