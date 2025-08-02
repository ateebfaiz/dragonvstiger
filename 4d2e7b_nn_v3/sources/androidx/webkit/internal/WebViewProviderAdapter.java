package androidx.webkit.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.CancellationSignal;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.webkit.PrerenderOperationCallback;
import androidx.webkit.Profile;
import androidx.webkit.SpeculativeLoadingParameters;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public class WebViewProviderAdapter {
    final WebViewProviderBoundaryInterface mImpl;

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.mImpl = webViewProviderBoundaryInterface;
    }

    public ScriptHandlerImpl addDocumentStartJavaScript(String str, String[] strArr) {
        return ScriptHandlerImpl.toScriptHandler(this.mImpl.addDocumentStartJavaScript(str, strArr));
    }

    public void addWebMessageListener(String str, String[] strArr, WebViewCompat.WebMessageListener webMessageListener) {
        this.mImpl.addWebMessageListener(str, strArr, a.c(new WebMessageListenerAdapter(webMessageListener)));
    }

    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] createWebMessageChannel = this.mImpl.createWebMessageChannel();
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[createWebMessageChannel.length];
        for (int i10 = 0; i10 < createWebMessageChannel.length; i10++) {
            webMessagePortCompatArr[i10] = new WebMessagePortImpl(createWebMessageChannel[i10]);
        }
        return webMessagePortCompatArr;
    }

    public Profile getProfile() {
        return new ProfileImpl((ProfileBoundaryInterface) a.a(ProfileBoundaryInterface.class, this.mImpl.getProfile()));
    }

    public WebChromeClient getWebChromeClient() {
        return this.mImpl.getWebChromeClient();
    }

    public WebViewClient getWebViewClient() {
        return this.mImpl.getWebViewClient();
    }

    public WebViewRenderProcess getWebViewRenderProcess() {
        return WebViewRenderProcessImpl.forInvocationHandler(this.mImpl.getWebViewRenderer());
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InvocationHandler webViewRendererClient = this.mImpl.getWebViewRendererClient();
        if (webViewRendererClient == null) {
            return null;
        }
        return ((WebViewRenderProcessClientAdapter) a.e(webViewRendererClient)).getWebViewRenderProcessClient();
    }

    public void insertVisualStateCallback(long j10, WebViewCompat.VisualStateCallback visualStateCallback) {
        this.mImpl.insertVisualStateCallback(j10, a.c(new VisualStateCallbackAdapter(visualStateCallback)));
    }

    public boolean isAudioMuted() {
        return this.mImpl.isAudioMuted();
    }

    public void postWebMessage(WebMessageCompat webMessageCompat, Uri uri) {
        this.mImpl.postMessageToMainFrame(a.c(new WebMessageAdapter(webMessageCompat)), uri);
    }

    public void prerenderUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, PrerenderOperationCallback prerenderOperationCallback) {
        this.mImpl.prerenderUrl(str, cancellationSignal, executor, new z0(prerenderOperationCallback), new a1(prerenderOperationCallback));
    }

    public void removeWebMessageListener(String str) {
        this.mImpl.removeWebMessageListener(str);
    }

    public void setAudioMuted(boolean z10) {
        this.mImpl.setAudioMuted(z10);
    }

    public void setProfileWithName(String str) {
        this.mImpl.setProfile(str);
    }

    @SuppressLint({"LambdaLast"})
    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        InvocationHandler invocationHandler;
        if (webViewRenderProcessClient != null) {
            invocationHandler = a.c(new WebViewRenderProcessClientAdapter(executor, webViewRenderProcessClient));
        } else {
            invocationHandler = null;
        }
        this.mImpl.setWebViewRendererClient(invocationHandler);
    }

    public void prerenderUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, SpeculativeLoadingParameters speculativeLoadingParameters, PrerenderOperationCallback prerenderOperationCallback) {
        this.mImpl.prerenderUrl(str, cancellationSignal, executor, a.c(new SpeculativeLoadingParametersAdapter(speculativeLoadingParameters)), new x0(prerenderOperationCallback), new y0(prerenderOperationCallback));
    }
}
