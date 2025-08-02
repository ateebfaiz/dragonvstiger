package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.Util;
import java.text.DecimalFormat;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimerCycle {
    /* access modifiers changed from: private */
    public Runnable command;
    private long cycleDelay;
    private long initialDelay;
    private boolean isPaused = true;
    /* access modifiers changed from: private */
    public ILogger logger = AdjustFactory.getLogger();
    /* access modifiers changed from: private */
    public String name;
    private FutureScheduler scheduler;
    private ScheduledFuture waitingTask;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            TimerCycle.this.logger.verbose("%s fired", TimerCycle.this.name);
            TimerCycle.this.command.run();
        }
    }

    public TimerCycle(Runnable runnable, long j10, long j11, String str) {
        this.scheduler = new SingleThreadFutureScheduler(str, true);
        this.name = str;
        this.command = runnable;
        this.initialDelay = j10;
        this.cycleDelay = j11;
        DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
        String format = decimalFormat.format(((double) j11) / 1000.0d);
        String format2 = decimalFormat.format(((double) j10) / 1000.0d);
        this.logger.verbose("%s configured to fire after %s seconds of starting and cycles every %s seconds", str, format2, format);
    }

    private void cancel(boolean z10) {
        ScheduledFuture scheduledFuture = this.waitingTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(z10);
        }
        this.waitingTask = null;
    }

    public void start() {
        if (!this.isPaused) {
            this.logger.verbose("%s is already started", this.name);
            return;
        }
        this.logger.verbose("%s starting", this.name);
        this.waitingTask = this.scheduler.scheduleFutureWithFixedDelay(new a(), this.initialDelay, this.cycleDelay);
        this.isPaused = false;
    }

    public void suspend() {
        if (this.isPaused) {
            this.logger.verbose("%s is already suspended", this.name);
            return;
        }
        this.initialDelay = this.waitingTask.getDelay(TimeUnit.MILLISECONDS);
        this.waitingTask.cancel(false);
        String format = Util.SecondsDisplayFormat.format(((double) this.initialDelay) / 1000.0d);
        this.logger.verbose("%s suspended with %s seconds left", this.name, format);
        this.isPaused = true;
    }

    public void teardown() {
        cancel(true);
        FutureScheduler futureScheduler = this.scheduler;
        if (futureScheduler != null) {
            futureScheduler.teardown();
        }
        this.scheduler = null;
    }
}
