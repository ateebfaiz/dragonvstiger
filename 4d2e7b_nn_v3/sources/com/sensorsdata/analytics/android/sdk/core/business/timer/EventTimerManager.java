package com.sensorsdata.analytics.android.sdk.core.business.timer;

import android.os.SystemClock;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import java.util.HashMap;
import java.util.Map;

public class EventTimerManager {
    private final Map<String, EventTimer> mTrackTimer;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final EventTimerManager mInstance = new EventTimerManager();

        private SingletonHolder() {
        }
    }

    public static synchronized EventTimerManager getInstance() {
        EventTimerManager access$000;
        synchronized (EventTimerManager.class) {
            access$000 = SingletonHolder.mInstance;
        }
        return access$000;
    }

    public void addEventTimer(String str, EventTimer eventTimer) {
        synchronized (this.mTrackTimer) {
            this.mTrackTimer.put(str, eventTimer);
        }
    }

    public void appBecomeActive() {
        EventTimer eventTimer;
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (!(next == null || (eventTimer = (EventTimer) next.getValue()) == null)) {
                        eventTimer.setStartTime(SystemClock.elapsedRealtime());
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void appEnterBackground() {
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (next != null) {
                        if (!"$AppEnd".equals(next.getKey())) {
                            EventTimer eventTimer = (EventTimer) next.getValue();
                            if (eventTimer != null && !eventTimer.isPaused()) {
                                eventTimer.setEventAccumulatedDuration((eventTimer.getEventAccumulatedDuration() + SystemClock.elapsedRealtime()) - eventTimer.getStartTime());
                                eventTimer.setStartTime(SystemClock.elapsedRealtime());
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    public void clearTimers() {
        try {
            synchronized (this.mTrackTimer) {
                this.mTrackTimer.clear();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public EventTimer getEventTimer(String str) {
        EventTimer eventTimer;
        synchronized (this.mTrackTimer) {
            eventTimer = this.mTrackTimer.get(str);
            this.mTrackTimer.remove(str);
        }
        return eventTimer;
    }

    public void removeTimer(String str) {
        synchronized (this.mTrackTimer) {
            this.mTrackTimer.remove(str);
        }
    }

    public void updateEndTime(String str, long j10) {
        synchronized (this.mTrackTimer) {
            try {
                EventTimer eventTimer = this.mTrackTimer.get(str);
                if (eventTimer != null) {
                    eventTimer.setEndTime(j10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void updateTimerState(String str, long j10, boolean z10) {
        try {
            SADataHelper.assertEventName(str);
            synchronized (this.mTrackTimer) {
                EventTimer eventTimer = this.mTrackTimer.get(str);
                if (!(eventTimer == null || eventTimer.isPaused() == z10)) {
                    eventTimer.setTimerState(z10, j10);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        } catch (Throwable th) {
            throw th;
        }
    }

    private EventTimerManager() {
        this.mTrackTimer = new HashMap();
    }
}
