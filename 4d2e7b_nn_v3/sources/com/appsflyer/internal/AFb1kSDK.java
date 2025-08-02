package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;

public final class AFb1kSDK {
    public final Application AFInAppEventParameterName;

    public AFb1kSDK(Context context) {
        this.AFInAppEventParameterName = (Application) context.getApplicationContext();
    }
}
