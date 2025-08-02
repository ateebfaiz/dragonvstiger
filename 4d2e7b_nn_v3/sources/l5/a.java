package l5;

import android.os.Trace;
import kotlin.jvm.internal.m;
import l5.b;

public final class a implements b.c {
    public void a(String str) {
        m.f(str, "name");
        if (isTracing()) {
            Trace.beginSection(str);
        }
    }

    public void b() {
        if (isTracing()) {
            Trace.endSection();
        }
    }

    public boolean isTracing() {
        return false;
    }
}
