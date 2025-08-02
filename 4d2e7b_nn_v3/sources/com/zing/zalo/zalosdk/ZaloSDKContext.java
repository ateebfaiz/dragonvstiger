package com.zing.zalo.zalosdk;

import android.app.Application;
import android.content.Context;

public class ZaloSDKContext {
    private static Application application;
    private static ZaloSDKContext instance;
    private static final Object lock = new Object();

    private ZaloSDKContext() {
    }

    public static ZaloSDKContext getInstance() {
        ZaloSDKContext zaloSDKContext;
        synchronized (lock) {
            try {
                if (instance == null) {
                    instance = new ZaloSDKContext();
                }
                zaloSDKContext = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zaloSDKContext;
    }

    public static void init(Application application2) {
        application = application2;
    }

    public Context getApplicationContext() {
        return application.getApplicationContext();
    }
}
