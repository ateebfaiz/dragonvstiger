package r0;

import androidx.collection.LruCache;
import com.airbnb.lottie.j;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static final g f23626b = new g();

    /* renamed from: a  reason: collision with root package name */
    private final LruCache f23627a = new LruCache(20);

    g() {
    }

    public static g b() {
        return f23626b;
    }

    public j a(String str) {
        if (str == null) {
            return null;
        }
        return (j) this.f23627a.get(str);
    }

    public void c(String str, j jVar) {
        if (str != null) {
            this.f23627a.put(str, jVar);
        }
    }
}
