package com.cocos.lib;

import java.net.HttpURLConnection;
import java.net.URL;
import org.cocos2dx.okhttp3.Dispatcher;

public interface CocosMahAgent {
    HttpURLConnection createProxyConnection(URL url);

    boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher);
}
