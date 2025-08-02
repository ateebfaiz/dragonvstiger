package y0;

import android.util.Log;
import com.airbnb.lottie.p0;
import java.util.HashSet;
import java.util.Set;

public class e implements p0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f24844a = new HashSet();

    public void a(String str, Throwable th) {
        if (com.airbnb.lottie.e.f17634a) {
            Log.d("LOTTIE", str, th);
        }
    }

    public void b(String str) {
        e(str, (Throwable) null);
    }

    public void c(String str) {
        d(str, (Throwable) null);
    }

    public void d(String str, Throwable th) {
        Set set = f24844a;
        if (!set.contains(str)) {
            Log.w("LOTTIE", str, th);
            set.add(str);
        }
    }

    public void e(String str, Throwable th) {
        if (com.airbnb.lottie.e.f17634a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
