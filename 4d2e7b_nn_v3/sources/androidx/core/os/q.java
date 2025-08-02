package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;

final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f15052a = new q();

    private q() {
    }

    @DoNotInline
    public static final void a(PersistableBundle persistableBundle, String str, boolean z10) {
        persistableBundle.putBoolean(str, z10);
    }

    @DoNotInline
    public static final void b(PersistableBundle persistableBundle, String str, boolean[] zArr) {
        persistableBundle.putBooleanArray(str, zArr);
    }
}
