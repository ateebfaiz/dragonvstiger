package bc;

import android.os.Looper;
import cc.r;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.n1;

public final class a implements r {
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public n1 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new d(f.a(mainLooper, true), (String) null, 2, (DefaultConstructorMarker) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public int c() {
        return 1073741823;
    }
}
