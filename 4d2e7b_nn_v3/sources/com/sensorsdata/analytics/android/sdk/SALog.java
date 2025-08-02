package com.sensorsdata.analytics.android.sdk;

import android.util.Log;

public class SALog {
    private static final int CHUNK_SIZE = 4000;
    private static boolean debug;
    private static boolean disableSDK;
    private static boolean enableLog;

    public static void d(String str, String str2) {
        if (debug && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, String str2) {
        if (enableLog && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void info(String str, String str2, Throwable th) {
        if (str2 != null) {
            try {
                byte[] bytes = str2.getBytes();
                int length = bytes.length;
                if (length <= CHUNK_SIZE) {
                    Log.i(str, str2, th);
                    return;
                }
                int i10 = 0;
                while (i10 < length - 4000) {
                    int lastIndexOfLF = lastIndexOfLF(bytes, i10);
                    int i11 = lastIndexOfLF - i10;
                    Log.i(str, new String(bytes, i10, i11), (Throwable) null);
                    if (i11 < CHUNK_SIZE) {
                        lastIndexOfLF++;
                    }
                    i10 = lastIndexOfLF;
                }
                if (length > i10) {
                    Log.i(str, new String(bytes, i10, length - i10), th);
                }
            } catch (Exception e10) {
                printStackTrace(e10);
            }
        } else {
            Log.i(str, (String) null, th);
        }
    }

    public static boolean isDebug() {
        return debug;
    }

    public static boolean isLogEnabled() {
        return enableLog;
    }

    private static int lastIndexOfLF(byte[] bArr, int i10) {
        int min = Math.min(i10 + CHUNK_SIZE, bArr.length - 1);
        for (int i11 = min; i11 > min - 4000; i11--) {
            if (bArr[i11] == 10) {
                return i11;
            }
        }
        return min;
    }

    public static void printStackTrace(Exception exc) {
        if (enableLog && !disableSDK && exc != null) {
            Log.e("SA.Exception", "", exc);
        }
    }

    static void setDebug(boolean z10) {
        debug = z10;
    }

    public static void setDisableSDK(boolean z10) {
        disableSDK = z10;
    }

    public static void setEnableLog(boolean z10) {
        enableLog = z10;
    }

    public static void d(String str, String str2, Throwable th) {
        if (debug && !disableSDK) {
            info(str, str2, th);
        }
    }

    public static void i(String str, Throwable th) {
        if (enableLog && !disableSDK) {
            info(str, "", th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (enableLog && !disableSDK) {
            info(str, str2, th);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (enableLog && !disableSDK) {
            info(str, String.format(str2, objArr), (Throwable) null);
        }
    }
}
