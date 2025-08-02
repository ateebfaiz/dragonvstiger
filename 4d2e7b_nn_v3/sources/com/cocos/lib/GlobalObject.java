package com.cocos.lib;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class GlobalObject {
    private static Activity sActivity;
    private static Context sContext;
    private static Handler sHandler;
    private static Thread sUiThread;

    public static void destroy() {
        sContext = null;
        sActivity = null;
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        sHandler = null;
    }

    public static Activity getActivity() {
        return sActivity;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void init(Context context, Activity activity) {
        sContext = context;
        sActivity = activity;
        sHandler = new Handler(Looper.getMainLooper());
        Thread currentThread = Thread.currentThread();
        sUiThread = currentThread;
        if (currentThread != Looper.getMainLooper().getThread()) {
            throw new RuntimeException("GlobalObject.init should be invoked in UI thread");
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != sUiThread) {
            sHandler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
