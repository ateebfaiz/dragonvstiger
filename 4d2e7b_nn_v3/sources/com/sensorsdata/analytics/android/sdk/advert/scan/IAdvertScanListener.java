package com.sensorsdata.analytics.android.sdk.advert.scan;

import android.app.Activity;
import android.net.Uri;

interface IAdvertScanListener {
    void handlerScanUri(Activity activity, Uri uri);
}
