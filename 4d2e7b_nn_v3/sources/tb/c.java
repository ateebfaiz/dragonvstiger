package tb;

import java.io.Closeable;
import kotlin.b;

public abstract class c {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            b.a(th, th2);
        }
    }
}
