package com.sensorsdata.analytics.android.sdk.exceptions;

import android.os.Process;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SACoreHelper;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class SensorsDataExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int SLEEP_TIMEOUT_MS = 400;
    private static boolean isTrackCrash = false;
    private static final ArrayList<SAExceptionListener> sExceptionListeners = new ArrayList<>();
    private static SensorsDataExceptionHandler sInstance;
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public interface SAExceptionListener {
        void uncaughtException(Thread thread, Throwable th);
    }

    private SensorsDataExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void addExceptionListener(SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            ArrayList<SAExceptionListener> arrayList = sExceptionListeners;
            if (!arrayList.contains(sAExceptionListener)) {
                arrayList.add(sAExceptionListener);
            }
        }
    }

    public static void enableAppCrash() {
        isTrackCrash = true;
    }

    public static synchronized void init() {
        synchronized (SensorsDataExceptionHandler.class) {
            if (sInstance == null) {
                sInstance = new SensorsDataExceptionHandler();
            }
        }
    }

    private void killProcessAndExit() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Exception unused) {
        }
    }

    public static void removeExceptionListener(SAExceptionListener sAExceptionListener) {
        if (sAExceptionListener != null) {
            ArrayList<SAExceptionListener> arrayList = sExceptionListeners;
            if (arrayList.contains(sAExceptionListener)) {
                arrayList.remove(sAExceptionListener);
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (isTrackCrash) {
                try {
                    final JSONObject jSONObject = new JSONObject();
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                            cause.printStackTrace(printWriter);
                        }
                        printWriter.close();
                        jSONObject.put("app_crashed_reason", stringWriter.toString());
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                    SACoreHelper.getInstance().trackQueueEvent(new Runnable() {
                        public void run() {
                            SACoreHelper.getInstance().trackEvent(new InputData().setEventName("AppCrashed").setProperties(jSONObject).setEventType(EventType.TRACK));
                        }
                    });
                    SensorsDataAPI.sharedInstance().flush();
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e11) {
                        SALog.printStackTrace(e11);
                    }
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
            Iterator<SAExceptionListener> it = sExceptionListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Exception e13) {
                    SALog.printStackTrace(e13);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                killProcessAndExit();
            }
        } catch (Exception unused) {
        }
    }
}
