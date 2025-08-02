package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static class a {
        @DoNotInline
        static void a(String str, int i10) {
            Trace.beginAsyncSection(str, i10);
        }

        @DoNotInline
        static void b(String str, int i10) {
            Trace.endAsyncSection(str, i10);
        }

        @DoNotInline
        static boolean c() {
            return Trace.isEnabled();
        }

        @DoNotInline
        static void d(String str, long j10) {
            Trace.setCounter(str, j10);
        }
    }

    static {
        Class<String> cls = String.class;
        Class<Trace> cls2 = Trace.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = cls2.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls3 = Long.TYPE;
                sIsTagEnabledMethod = cls2.getMethod("isTagEnabled", new Class[]{cls3});
                Class cls4 = Integer.TYPE;
                sAsyncTraceBeginMethod = cls2.getMethod("asyncTraceBegin", new Class[]{cls3, cls, cls4});
                sAsyncTraceEndMethod = cls2.getMethod("asyncTraceEnd", new Class[]{cls3, cls, cls4});
                sTraceCounterMethod = cls2.getMethod("traceCounter", new Class[]{cls3, cls, cls4});
            } catch (Exception e10) {
                Log.i(TAG, "Unable to initialize via reflection.", e10);
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.a(str, i10);
            return;
        }
        try {
            sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10)});
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
        }
    }

    public static void beginSection(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void endAsyncSection(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(str, i10);
            return;
        }
        try {
            sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10)});
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return a.c();
        }
        try {
            return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.d(str, (long) i10);
            return;
        }
        try {
            sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i10)});
        } catch (Exception unused) {
            Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
        }
    }
}
