package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sensorsdata.analytics.android.sdk.util.ThreadUtils;
import java.util.concurrent.LinkedBlockingQueue;

class OAIDService implements ServiceConnection {
    public static final LinkedBlockingQueue<IBinder> BINDER_QUEUE = new LinkedBlockingQueue<>(1);

    class Task implements Runnable {
        final IBinder binder;

        Task(IBinder iBinder) {
            this.binder = iBinder;
        }

        public void run() {
            try {
                LinkedBlockingQueue<IBinder> linkedBlockingQueue = OAIDService.BINDER_QUEUE;
                if (linkedBlockingQueue.size() > 0) {
                    linkedBlockingQueue.clear();
                }
                linkedBlockingQueue.put(this.binder);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    OAIDService() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ThreadUtils.getSinglePool().execute(new Task(iBinder));
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
