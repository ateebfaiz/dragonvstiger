package com.cocos.sdk;

import android.util.Log;
import com.cocos.lib.CocosDownloader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.cocos2dx.okhttp3.Dispatcher;

public class WgProxyController {
    private static final String TAG = "WgProxyController";
    private static final WgProxyController instance = new WgProxyController();

    private WgProxyController() {
    }

    public static WgProxyController getInstance() {
        return instance;
    }

    public HttpURLConnection createProxyConnection(URL url) {
        return null;
    }

    public void initLoginUser(String str) {
    }

    public boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher) {
        return false;
    }

    public void shutdown() {
    }

    public boolean startUp(String str, String[] strArr) {
        Log.d(TAG, "nozoloz project, fail to start up");
        return false;
    }
}
