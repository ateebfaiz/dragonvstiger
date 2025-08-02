package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static Logger sLogger;

    public static class LogcatLogger extends Logger {
        private int mLoggingLevel;

        public LogcatLogger(int i10) {
            super(i10);
            this.mLoggingLevel = i10;
        }

        public void debug(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        public void error(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }

        public void info(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        public void verbose(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        public void warning(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }
    }

    public Logger(int i10) {
    }

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            try {
                if (sLogger == null) {
                    sLogger = new LogcatLogger(3);
                }
                logger = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static synchronized void setLogger(Logger logger) {
        synchronized (Logger.class) {
            sLogger = logger;
        }
    }

    public static String tagWithPrefix(@NonNull String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append(TAG_PREFIX);
        int i10 = MAX_PREFIXED_TAG_LENGTH;
        if (length >= i10) {
            sb2.append(str.substring(0, i10));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void debug(String str, String str2, Throwable... thArr);

    public abstract void error(String str, String str2, Throwable... thArr);

    public abstract void info(String str, String str2, Throwable... thArr);

    public abstract void verbose(String str, String str2, Throwable... thArr);

    public abstract void warning(String str, String str2, Throwable... thArr);
}
