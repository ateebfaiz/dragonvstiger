package org.cocos2dx.javascript.connection;

import com.cocos.lib.CocosDownloader;
import com.cocos.sdk.AliProxyController;
import com.cocos.sdk.MahProxyController;
import com.cocos.sdk.WgProxyController;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.cocos2dx.javascript.PlatformUtils;
import org.cocos2dx.okhttp3.Dispatcher;

public class ConnectionCreator {
    private static final String TAG = "ConnectionCreator";
    private static final ConnectionCreator instance = new ConnectionCreator();
    private boolean useDnsSdk = false;
    private boolean useWgMah = false;
    private boolean useWsMah = false;

    private ConnectionCreator() {
    }

    private HttpURLConnection createAliProxyConnection(URL url) {
        if (!this.useDnsSdk) {
            return null;
        }
        return AliProxyController.getInstance().createProxyConnection(url);
    }

    private HttpURLConnection createMahProxyConnection(URL url) {
        if (this.useWsMah && isMahDomain(url)) {
            return MahProxyController.getInstance().createProxyConnection(url);
        }
        return null;
    }

    private HttpURLConnection createWgProxyConnection(URL url) {
        if (!this.useWgMah) {
            return null;
        }
        return WgProxyController.getInstance().createProxyConnection(url);
    }

    public static ConnectionCreator getInstance() {
        return instance;
    }

    private boolean isMahDomain(URL url) {
        List<String> list = PlatformUtils.mahDomains;
        if (list == null) {
            return false;
        }
        for (String equals : list) {
            if (equals.equals(url.getHost())) {
                return true;
            }
        }
        return false;
    }

    public HttpURLConnection createProxyConnection(URL url) {
        HttpURLConnection createWgProxyConnection = createWgProxyConnection(url);
        if (createWgProxyConnection != null) {
            return createWgProxyConnection;
        }
        HttpURLConnection createMahProxyConnection = createMahProxyConnection(url);
        if (createMahProxyConnection != null) {
            return createMahProxyConnection;
        }
        return createAliProxyConnection(url);
    }

    public boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher) {
        if (this.useWgMah) {
            return WgProxyController.getInstance().setDownloadClient(cocosDownloader, i10, dispatcher);
        }
        if (this.useDnsSdk) {
            return AliProxyController.getInstance().setDownloadClient(cocosDownloader, i10, dispatcher);
        }
        return false;
    }

    public void setUseDnsSdk(boolean z10) {
        this.useDnsSdk = z10;
    }

    public void setUseWgMah(boolean z10) {
        this.useWgMah = z10;
    }

    public void setUseWsMah(boolean z10) {
        this.useWsMah = z10;
    }
}
