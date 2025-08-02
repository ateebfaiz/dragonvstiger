package com.sensorsdata.analytics.android.sdk.core.tasks;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.TrackTaskManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TrackTaskManagerThread implements Runnable {
    private static final int POOL_SIZE = 1;
    private boolean isStop = false;
    private ExecutorService mPool;
    private TrackTaskManager mTrackTaskManager;

    public TrackTaskManagerThread() {
        try {
            this.mTrackTaskManager = TrackTaskManager.getInstance();
            this.mPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    return new Thread(runnable, ThreadNameConstants.THREAD_TASK_EXECUTE);
                }
            });
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public boolean isStopped() {
        return this.isStop;
    }

    public void run() {
        while (!this.isStop) {
            try {
                this.mPool.execute(this.mTrackTaskManager.takeTrackEventTask());
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return;
            }
        }
        while (true) {
            Runnable pollTrackEventTask = this.mTrackTaskManager.pollTrackEventTask();
            if (pollTrackEventTask == null) {
                this.mPool.shutdown();
                return;
            }
            this.mPool.execute(pollTrackEventTask);
        }
    }

    public void stop() {
        this.isStop = true;
        if (this.mTrackTaskManager.isEmpty()) {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                }
            });
        }
    }
}
