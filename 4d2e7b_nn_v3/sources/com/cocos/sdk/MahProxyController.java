package com.cocos.sdk;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import androidx.webkit.ProxyController;
import androidx.webkit.WebViewFeature;
import com.cocos.lib.CocosDownloader;
import com.mah.sdk.MahProxy;
import com.mah.sdk.MahProxyAddress;
import com.mah.sdk.MahProxyOptions;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import org.cocos2dx.okhttp3.Dispatcher;
import org.cocos2dx.okhttp3.OkHttpClient;
import org.cocos2dx.okhttp3.Protocol;

public class MahProxyController {
    private static final String TAG = "MahProxyController";
    private boolean setProxySuccessFlag = false;

    public interface ProxySetupListener {
        void onProxyApplyCompleted(boolean z10);
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final MahProxyController f19406a = new MahProxyController();
    }

    public static MahProxyController getInstance() {
        return a.f19406a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setWebviewProxy$0(ProxySetupListener proxySetupListener) {
        Log.d(TAG, "Proxy apply success");
        this.setProxySuccessFlag = true;
        proxySetupListener.onProxyApplyCompleted(true);
    }

    public HttpURLConnection createProxyConnection(URL url) {
        MahProxyAddress httpsProxyAddress = MahProxy.getHttpsProxyAddress();
        if (httpsProxyAddress == null) {
            return null;
        }
        try {
            Log.i(TAG, "useMah: " + url.getHost());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(httpsProxyAddress.getHttpProxy());
            if (!(httpURLConnection instanceof HttpsURLConnection)) {
                return null;
            }
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setHostnameVerifier(MahProxy.getHostnameVerifier());
            httpsURLConnection.setSSLSocketFactory(MahProxy.getSslSocketFactory());
            return httpURLConnection;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher) {
        OkHttpClient okHttpClient;
        MahProxyAddress httpsProxyAddress = MahProxy.getHttpsProxyAddress();
        if (httpsProxyAddress == null) {
            return false;
        }
        if (i10 > 0) {
            okHttpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).connectTimeout((long) i10, TimeUnit.SECONDS).protocols(Collections.singletonList(Protocol.HTTP_1_1)).proxy(httpsProxyAddress.getHttpProxy()).sslSocketFactory(MahProxy.getSslSocketFactory(), MahProxy.getTrustManager()).hostnameVerifier(MahProxy.getHostnameVerifier()).build();
        } else {
            okHttpClient = new OkHttpClient().newBuilder().dispatcher(dispatcher).followRedirects(true).followSslRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1)).proxy(httpsProxyAddress.getHttpProxy()).sslSocketFactory(MahProxy.getSslSocketFactory(), MahProxy.getTrustManager()).hostnameVerifier(MahProxy.getHostnameVerifier()).build();
        }
        cocosDownloader.setHttpClient(okHttpClient);
        return true;
    }

    public void setWebviewProxy(ProxySetupListener proxySetupListener) {
        MahProxyAddress httpsProxyAddress = MahProxy.getHttpsProxyAddress();
        if (httpsProxyAddress == null) {
            Log.d(TAG, "httpsProxyAddress is null");
            proxySetupListener.onProxyApplyCompleted(false);
        } else if (this.setProxySuccessFlag) {
            proxySetupListener.onProxyApplyCompleted(true);
        } else {
            String host = httpsProxyAddress.getHost();
            int port = httpsProxyAddress.getPort();
            if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
                Log.i(TAG, "use AndroidX set proxy");
                ProxyConfig.Builder builder = new ProxyConfig.Builder();
                ProxyController.getInstance().setProxyOverride(builder.addProxyRule(host + ":" + port).addDirect().build(), Executors.newSingleThreadExecutor(), new c(this, proxySetupListener));
                return;
            }
            Log.i(TAG, "current webview does not support setting proxy");
            proxySetupListener.onProxyApplyCompleted(false);
        }
    }

    public void startSdk(@NonNull Context context) {
        MahProxy.start(context, new MahProxyOptions.Builder().setUserID("9527").setProxyListener(new b()).build());
    }
}
