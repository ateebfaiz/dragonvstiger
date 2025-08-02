package com.facebook.react.bridge;

import d6.a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@a
public class ReactSoftExceptionLogger {
    private static final List<ReactSoftExceptionListener> sListeners = new CopyOnWriteArrayList();

    public interface ReactSoftExceptionListener {
        void logSoftException(String str, Throwable th);
    }

    @a
    public static void addListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        List<ReactSoftExceptionListener> list = sListeners;
        if (!list.contains(reactSoftExceptionListener)) {
            list.add(reactSoftExceptionListener);
        }
    }

    @a
    public static void clearListeners() {
        sListeners.clear();
    }

    @a
    private static void logNoThrowSoftExceptionWithMessage(String str, String str2) {
        logSoftException(str, new ReactNoCrashSoftException(str2));
    }

    @a
    public static void logSoftException(String str, Throwable th) {
        List<ReactSoftExceptionListener> list = sListeners;
        if (list.size() > 0) {
            for (ReactSoftExceptionListener logSoftException : list) {
                logSoftException.logSoftException(str, th);
            }
            return;
        }
        z2.a.k(str, "Unhandled SoftException", th);
    }

    @a
    public static void logSoftExceptionVerbose(String str, Throwable th) {
        logSoftException(str + "|" + th.getClass().getSimpleName() + ":" + th.getMessage(), th);
    }

    @a
    public static void removeListener(ReactSoftExceptionListener reactSoftExceptionListener) {
        sListeners.remove(reactSoftExceptionListener);
    }
}
