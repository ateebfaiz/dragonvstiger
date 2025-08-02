package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.appsflyer.internal.AFb1cSDK;
import com.appsflyer.internal.AFb1xSDK;

public class AFLogger {
    private static final long valueOf = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        private int AFInAppEventParameterName;

        private LogLevel(int i10) {
            this.AFInAppEventParameterName = i10;
        }

        public final int getLevel() {
            return this.AFInAppEventParameterName;
        }
    }

    public static void AFInAppEventParameterName(String str) {
        if (AFKeystoreWrapper(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf(ExifInterface.LONGITUDE_WEST, values(str, true));
    }

    private static boolean AFKeystoreWrapper(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void afDebugLog(String str) {
        if (AFKeystoreWrapper(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("D", values(str, true));
    }

    public static void afErrorLog(String str, Throwable th, boolean z10, boolean z11, boolean z12) {
        long j10;
        if (str == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(th.getClass().getSimpleName());
            sb2.append(" at ");
            sb2.append(th.getStackTrace()[0].toString());
            str = sb2.toString();
        }
        if (AFKeystoreWrapper(LogLevel.ERROR)) {
            String values = values(str, false);
            if (z11) {
                Log.e("AppsFlyer_6.10.2", values, th);
            } else if (z10) {
                Log.d("AppsFlyer_6.10.2", values);
            }
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().values(th);
        Application application = AFb1cSDK.AFKeystoreWrapper;
        if (application != null) {
            SharedPreferences.Editor edit = AFb1xSDK.AFKeystoreWrapper((Context) application).edit();
            Application application2 = AFb1cSDK.AFKeystoreWrapper;
            if (application2 == null) {
                j10 = -1;
            } else {
                j10 = AFb1xSDK.AFKeystoreWrapper((Context) application2).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j10 + 1).apply();
        }
        if (z12) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onConversionDataSuccess().valueOf(th, str);
        }
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th) {
        afErrorLogForExcManagerOnly(str, th, false);
    }

    public static void afInfoLog(String str, boolean z10) {
        if (AFKeystoreWrapper(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.10.2", values(str, false));
        }
        if (z10) {
            AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("I", values(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (AFKeystoreWrapper(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, values(str, true));
    }

    public static void afWarnLog(String str) {
        AFInAppEventParameterName(str);
    }

    @NonNull
    private static String values(String str, boolean z10) {
        if (str == null) {
            str = "null";
        }
        if (!z10 && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(System.currentTimeMillis() - valueOf);
        sb2.append(") [");
        sb2.append(Thread.currentThread().getName());
        sb2.append("] ");
        sb2.append(str);
        return sb2.toString();
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th, boolean z10) {
        afErrorLog(str, th, false, false, !z10);
    }

    private static boolean AFKeystoreWrapper() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void values(String str) {
        if (!AFKeystoreWrapper()) {
            Log.d("AppsFlyer_6.10.2", values(str, false));
        }
        AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf("F", str);
    }

    public static void afErrorLog(String str, Throwable th) {
        afErrorLog(str, th, true, false, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z10) {
        afErrorLog(str, th, true, z10, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z10, boolean z11) {
        afErrorLog(str, th, true, z10, z11);
    }

    @Deprecated
    public static void afErrorLog(Throwable th) {
        afErrorLogForExcManagerOnly("Unknown", th);
    }
}
