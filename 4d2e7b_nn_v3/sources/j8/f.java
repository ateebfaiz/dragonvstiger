package j8;

import java.util.concurrent.ConcurrentHashMap;

public final class f extends ConcurrentHashMap {

    /* renamed from: b  reason: collision with root package name */
    public static final f f12416b = new f();

    /* renamed from: a  reason: collision with root package name */
    private final Object f12417a = new Object();

    private f() {
        super(180, 0.8f, 4);
    }

    public String a(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.f12417a) {
                try {
                    if (size() >= 180) {
                        clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        String intern = str.intern();
        put(intern, intern);
        return intern;
    }
}
