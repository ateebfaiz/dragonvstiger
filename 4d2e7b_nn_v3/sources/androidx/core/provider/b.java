package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

abstract class b {
    static Handler a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
