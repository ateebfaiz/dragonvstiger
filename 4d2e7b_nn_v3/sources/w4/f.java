package w4;

import android.graphics.Bitmap;
import c3.h;

public class f implements h {

    /* renamed from: a  reason: collision with root package name */
    private static f f24613a;

    private f() {
    }

    public static f a() {
        if (f24613a == null) {
            f24613a = new f();
        }
        return f24613a;
    }

    /* renamed from: b */
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
