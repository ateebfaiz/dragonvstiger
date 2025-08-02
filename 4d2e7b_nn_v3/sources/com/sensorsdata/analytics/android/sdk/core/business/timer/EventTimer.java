package com.sensorsdata.analytics.android.sdk.core.business.timer;

import java.util.concurrent.TimeUnit;

public class EventTimer {
    private long endTime;
    private long eventAccumulatedDuration;
    private boolean isPaused = false;
    private long startTime;
    private final TimeUnit timeUnit;

    public EventTimer(TimeUnit timeUnit2, long j10) {
        this.startTime = j10;
        this.timeUnit = timeUnit2;
        this.eventAccumulatedDuration = 0;
        this.endTime = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053 A[Catch:{ Exception -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054 A[Catch:{ Exception -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float duration() {
        /*
            r7 = this;
            boolean r0 = r7.isPaused
            r1 = 0
            if (r0 == 0) goto L_0x000b
            long r3 = r7.startTime
            r7.endTime = r3
            goto L_0x0017
        L_0x000b:
            long r3 = r7.endTime
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0015:
            r7.endTime = r3
        L_0x0017:
            long r3 = r7.endTime
            long r5 = r7.startTime
            long r3 = r3 - r5
            long r5 = r7.eventAccumulatedDuration
            long r3 = r3 + r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r1 = 0
            if (r0 < 0) goto L_0x0061
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x002c
            goto L_0x0061
        L_0x002c:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x005d }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x005d }
            r5 = 1148846080(0x447a0000, float:1000.0)
            if (r0 != r2) goto L_0x0036
        L_0x0034:
            float r0 = (float) r3     // Catch:{ Exception -> 0x005d }
            goto L_0x004f
        L_0x0036:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x005d }
            if (r0 != r2) goto L_0x003d
            float r0 = (float) r3     // Catch:{ Exception -> 0x005d }
            float r0 = r0 / r5
            goto L_0x004f
        L_0x003d:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x005d }
            r6 = 1114636288(0x42700000, float:60.0)
            if (r0 != r2) goto L_0x0047
            float r0 = (float) r3     // Catch:{ Exception -> 0x005d }
            float r0 = r0 / r5
        L_0x0045:
            float r0 = r0 / r6
            goto L_0x004f
        L_0x0047:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ Exception -> 0x005d }
            if (r0 != r2) goto L_0x0034
            float r0 = (float) r3     // Catch:{ Exception -> 0x005d }
            float r0 = r0 / r5
            float r0 = r0 / r6
            goto L_0x0045
        L_0x004f:
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x0054
            goto L_0x005c
        L_0x0054:
            float r0 = r0 * r5
            int r0 = java.lang.Math.round(r0)     // Catch:{ Exception -> 0x005d }
            float r0 = (float) r0
            float r1 = r0 / r5
        L_0x005c:
            return r1
        L_0x005d:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer.duration():float");
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getEventAccumulatedDuration() {
        return this.eventAccumulatedDuration;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public void setEventAccumulatedDuration(long j10) {
        this.eventAccumulatedDuration = j10;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setTimerState(boolean z10, long j10) {
        this.isPaused = z10;
        if (z10) {
            this.eventAccumulatedDuration = (this.eventAccumulatedDuration + j10) - this.startTime;
        }
        this.startTime = j10;
    }
}
