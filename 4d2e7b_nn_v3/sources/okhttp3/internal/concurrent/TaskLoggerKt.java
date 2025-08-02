package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import okhttp3.internal.http2.Http2Connection;

public final class TaskLoggerKt {
    public static final String formatDuration(long j10) {
        String str;
        if (j10 <= ((long) -999500000)) {
            str = ((j10 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j10 <= ((long) -999500)) {
            str = ((j10 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < ((long) 999500)) {
            str = ((j10 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < ((long) 999500000)) {
            str = ((j10 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j10 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        b0 b0Var = b0.f709a;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(taskQueue.getName$okhttp());
        sb2.append(' ');
        b0 b0Var = b0.f709a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        m.e(format, "java.lang.String.format(format, *args)");
        sb2.append(format);
        sb2.append(": ");
        sb2.append(task.getName());
        logger.fine(sb2.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, Function0<? extends T> function0) {
        long j10;
        m.f(task, "task");
        m.f(taskQueue, "queue");
        m.f(function0, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j10 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j10 = -1;
        }
        try {
            T invoke = function0.invoke();
            k.b(1);
            if (isLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j10));
            }
            k.a(1);
            return invoke;
        } catch (Throwable th) {
            k.b(1);
            if (isLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j10));
            }
            k.a(1);
            throw th;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, Function0<String> function0) {
        m.f(task, "task");
        m.f(taskQueue, "queue");
        m.f(function0, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) function0.invoke());
        }
    }
}
