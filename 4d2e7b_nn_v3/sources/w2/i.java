package w2;

import android.os.Handler;
import android.os.Looper;

public class i extends e {

    /* renamed from: b  reason: collision with root package name */
    private static i f24502b;

    private i() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static i g() {
        if (f24502b == null) {
            f24502b = new i();
        }
        return f24502b;
    }

    public void execute(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
