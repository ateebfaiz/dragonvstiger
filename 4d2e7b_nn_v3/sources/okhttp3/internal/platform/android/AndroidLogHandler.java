package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.m;

public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        m.f(logRecord, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = logRecord.getLoggerName();
        m.e(loggerName, "record.loggerName");
        int access$getAndroidLevel$p = AndroidLogKt.getAndroidLevel(logRecord);
        String message = logRecord.getMessage();
        m.e(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, access$getAndroidLevel$p, message, logRecord.getThrown());
    }
}
