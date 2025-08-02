package u1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f24253a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap f24254b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f24255c;

    /* renamed from: d  reason: collision with root package name */
    public static String f24256d = "yyyyMMdd_HHmm";

    public static class a extends ThreadLocal {

        /* renamed from: a  reason: collision with root package name */
        public String f24257a;

        public a(String str) {
            this.f24257a = str;
        }

        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f24257a, Locale.ENGLISH);
        }
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal threadLocal = (ThreadLocal) f24254b.get(str);
        if (threadLocal == null) {
            synchronized (f24253a) {
                try {
                    threadLocal = (ThreadLocal) f24254b.get(str);
                    if (threadLocal == null) {
                        f24255c = new a(str);
                        f24254b.put(str, f24255c);
                        f24255c = null;
                        threadLocal = (ThreadLocal) f24254b.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (SimpleDateFormat) threadLocal.get();
    }

    public static String b() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }
}
