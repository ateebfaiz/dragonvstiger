package com.sensorsdata.analytics.android.sdk.advert.scan;

import android.app.Activity;
import android.net.Uri;

public class SAAdvertScanHelper {
    public static boolean scanHandler(Activity activity, Uri uri) {
        IAdvertScanListener iAdvertScanListener;
        String host = uri.getHost();
        if ("channeldebug".equals(host)) {
            iAdvertScanListener = new ChannelDebugScanHelper();
        } else if ("adsScanDeviceInfo".equals(host)) {
            iAdvertScanListener = new WhiteListScanHelper();
        } else {
            iAdvertScanListener = null;
        }
        if (iAdvertScanListener == null) {
            return false;
        }
        iAdvertScanListener.handlerScanUri(activity, uri);
        return true;
    }
}
