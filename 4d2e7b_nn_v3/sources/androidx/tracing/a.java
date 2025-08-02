package androidx.tracing;

import android.os.Trace;

abstract class a {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
