package androidx.tracing;

import android.os.Trace;
import androidx.annotation.DoNotInline;

abstract class b {
    public static void a(String str, int i10) {
        Trace.beginAsyncSection(str, i10);
    }

    public static void b(String str, int i10) {
        Trace.endAsyncSection(str, i10);
    }

    @DoNotInline
    public static boolean c() {
        return Trace.isEnabled();
    }

    public static void d(String str, int i10) {
        Trace.setCounter(str, (long) i10);
    }
}
