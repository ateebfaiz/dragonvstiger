package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

public class UiThreadUtil {
    @Nullable
    private static volatile Handler sMainHandler;

    public static void assertNotOnUiThread() {
    }

    public static void assertOnUiThread() {
    }

    public static Handler getUiThreadHandler() {
        if (sMainHandler == null) {
            synchronized (UiThreadUtil.class) {
                try {
                    if (sMainHandler == null) {
                        sMainHandler = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sMainHandler;
    }

    public static boolean isOnUiThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static void removeOnUiThread(Runnable runnable) {
        getUiThreadHandler().removeCallbacks(runnable);
    }

    public static boolean runOnUiThread(Runnable runnable) {
        return getUiThreadHandler().postDelayed(runnable, 0);
    }

    public static boolean runOnUiThread(Runnable runnable, long j10) {
        return getUiThreadHandler().postDelayed(runnable, j10);
    }
}
