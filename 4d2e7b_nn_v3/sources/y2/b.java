package y2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f24871a = Logger.getLogger(b.class.getName());

    public static void a(Closeable closeable, boolean z10) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                if (z10) {
                    f24871a.log(Level.WARNING, "IOException thrown while closing Closeable.", e10);
                    return;
                }
                throw e10;
            }
        }
    }

    public static void b(InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
