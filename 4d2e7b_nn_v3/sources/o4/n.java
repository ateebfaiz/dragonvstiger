package o4;

import android.os.Build;
import com.facebook.hermes.intl.h;

public abstract class n {
    public static b a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return z.i();
        }
        return h.i();
    }

    public static b b(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return z.j(str);
        }
        return h.j(str);
    }
}
