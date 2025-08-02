package com.zing.zalo.zalosdk.core.log;

import android.content.Context;
import android.os.Environment;
import com.zing.zalo.zalosdk.ZaloSDKContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class Log {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String LOG_FILE_NAME = "zalosdk-log-trace.txt";
    private static final String LOG_TAG = "ZDK";
    public static Boolean LOG_WRITABLE = Boolean.FALSE;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static int logLevel = 5;

    public static void d(String str) {
        d("ZDK", str);
    }

    public static void e(String str) {
        e("ZDK", str);
    }

    public static int getLogLevel() {
        return logLevel;
    }

    public static void i(String str) {
        i("ZDK", str);
    }

    private static void log(int i10, String str, String str2, Object... objArr) {
        if (str2 != null) {
            String format = String.format(Locale.getDefault(), str2, objArr);
            log(i10, str, format);
            writeLogFile(i10, str, format);
        }
    }

    private static File prepareFileInExternalStore() {
        Context applicationContext = ZaloSDKContext.getInstance().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        File file = new File(applicationContext.getExternalFilesDir((String) null) + LOG_FILE_NAME);
        file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return file;
    }

    private static void removeLogFileInDevice() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.google.android.zdt.data/" + LOG_FILE_NAME);
        file.getParentFile().mkdirs();
        if (file.exists()) {
            file.delete();
        }
    }

    public static void setLogLevel(int i10) {
        logLevel = i10;
    }

    public static void v(String str) {
        v("ZDK", str);
    }

    public static void w(String str) {
        w("ZDK", str);
    }

    private static void writeFileData(String str, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(str);
        outputStreamWriter.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private static void writeLogFile(int i10, String str, String str2) {
        if (!LOG_WRITABLE.booleanValue()) {
            removeLogFileInDevice();
        } else if (i10 == 6 || i10 == 5) {
            writeToFile(str + "\n\t" + str2 + "\n\n");
        }
    }

    private static void writeToFile(String str) {
        try {
            writeFileData(str, prepareFileInExternalStore());
        } catch (Exception unused) {
        }
    }

    public static void d(String str, Object... objArr) {
        d("ZDK", str, objArr);
    }

    public static void e(String str, Object... objArr) {
        e("ZDK", str, objArr);
    }

    public static void i(String str, Object... objArr) {
        i("ZDK", str, objArr);
    }

    public static void v(String str, Object... objArr) {
        v("ZDK", str, objArr);
    }

    public static void w(String str, Object... objArr) {
        w("ZDK", str, objArr);
    }

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }

    public static void d(Class<?> cls, String str) {
        log(3, cls.getSimpleName(), str);
    }

    public static void e(Class<?> cls, String str) {
        log(6, cls.getSimpleName(), str);
    }

    public static void i(Class<?> cls, String str) {
        log(4, cls.getSimpleName(), str);
    }

    private static void log(int i10, String str, String str2) {
        if (i10 >= logLevel) {
            android.util.Log.println(i10, str, str2);
            writeLogFile(i10, str, str2);
        }
    }

    public static void v(Class<?> cls, String str) {
        log(2, cls.getSimpleName(), str);
    }

    public static void w(Class<?> cls, String str) {
        log(5, cls.getSimpleName(), str);
    }

    public static void d(String str, String str2, Object... objArr) {
        log(3, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        log(6, str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        log(4, str, str2, objArr);
    }

    public static void v(String str, String str2, Object... objArr) {
        log(2, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        log(5, str, str2, objArr);
    }

    public static void d(Class<?> cls, String str, Object... objArr) {
        log(3, cls.getSimpleName(), str, objArr);
    }

    public static void e(Class<?> cls, String str, Object... objArr) {
        log(6, cls.getSimpleName(), str, objArr);
    }

    public static void i(Class<?> cls, String str, Object... objArr) {
        log(4, cls.getSimpleName(), str, objArr);
    }

    public static void v(Class<?> cls, String str, Object... objArr) {
        log(2, cls.getSimpleName(), str, objArr);
    }

    public static void w(Class<?> cls, String str, Object... objArr) {
        log(5, cls.getSimpleName(), str, objArr);
    }

    public static void e(Exception exc) {
        e("ZDK", exc);
    }

    public static void e(String str, Exception exc) {
        log(6, str, android.util.Log.getStackTraceString(exc));
    }

    public static void e(Class<?> cls, Exception exc) {
        log(6, cls.getSimpleName(), android.util.Log.getStackTraceString(exc));
    }
}
