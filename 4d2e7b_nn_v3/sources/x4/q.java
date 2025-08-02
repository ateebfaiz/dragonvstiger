package x4;

import java.util.concurrent.TimeUnit;
import y2.o;

public class q implements o {

    /* renamed from: a  reason: collision with root package name */
    private static final long f24811a = TimeUnit.MINUTES.toMillis(5);

    private int b() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 1048576;
        }
        if (min < 33554432) {
            return 2097152;
        }
        return 4194304;
    }

    /* renamed from: a */
    public y get() {
        int b10 = b();
        return new y(b10, Integer.MAX_VALUE, b10, Integer.MAX_VALUE, b10 / 8, f24811a);
    }
}
