package com.sensorsdata.analytics.android.sdk.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sensorsdata.analytics.android.sdk.SALog;

public class Dispatcher {
    private static final String TAG = "Dispatcher";
    private final Handler mHandler;
    private Handler mUiThreadHandler;

    private static class DispatchHolder {
        /* access modifiers changed from: private */
        public static final Dispatcher INSTANCE = new Dispatcher();

        private DispatchHolder() {
        }
    }

    public static Dispatcher getInstance() {
        return DispatchHolder.INSTANCE;
    }

    public synchronized Handler getUiThreadHandler() {
        try {
            if (this.mUiThreadHandler == null) {
                this.mUiThreadHandler = new Handler(Looper.getMainLooper());
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        } catch (Throwable th) {
            throw th;
        }
        return this.mUiThreadHandler;
    }

    public void post(Runnable runnable) {
        postDelayed(runnable, 0);
    }

    public void postDelayed(Runnable runnable, long j10) {
        this.mHandler.removeCallbacks(runnable);
        this.mHandler.postDelayed(runnable, j10);
    }

    public void removeCallbacksAndMessages() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private Dispatcher() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }
}
