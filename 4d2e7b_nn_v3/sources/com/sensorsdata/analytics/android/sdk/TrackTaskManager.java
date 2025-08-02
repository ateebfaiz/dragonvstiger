package com.sensorsdata.analytics.android.sdk;

import java.util.concurrent.LinkedBlockingQueue;

public class TrackTaskManager {
    private static TrackTaskManager trackTaskManager;
    private final LinkedBlockingQueue<Runnable> mTrackEventTasks = new LinkedBlockingQueue<>();

    private TrackTaskManager() {
    }

    public static synchronized TrackTaskManager getInstance() {
        TrackTaskManager trackTaskManager2;
        synchronized (TrackTaskManager.class) {
            try {
                if (trackTaskManager == null) {
                    trackTaskManager = new TrackTaskManager();
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
            trackTaskManager2 = trackTaskManager;
        }
        return trackTaskManager2;
    }

    public void addTrackEventTask(Runnable runnable) {
        try {
            this.mTrackEventTasks.put(runnable);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public boolean isEmpty() {
        return this.mTrackEventTasks.isEmpty();
    }

    public Runnable pollTrackEventTask() {
        try {
            return this.mTrackEventTasks.poll();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public Runnable takeTrackEventTask() {
        try {
            return this.mTrackEventTasks.take();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }
}
