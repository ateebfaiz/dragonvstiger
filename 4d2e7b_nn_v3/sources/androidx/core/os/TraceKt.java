package androidx.core.os;

import android.os.Trace;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;

public final class TraceKt {
    public static final <T> T trace(String str, Function0<? extends T> function0) {
        Trace.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            k.b(1);
            Trace.endSection();
            k.a(1);
        }
    }
}
