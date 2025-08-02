package j8;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class k {

    /* renamed from: a  reason: collision with root package name */
    private final Object f12434a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map f12435b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final ReferenceQueue f12436c = new ReferenceQueue();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final k f12437a = new k();
    }

    k() {
    }

    public static k a() {
        return a.f12437a;
    }

    private void b() {
        while (true) {
            SoftReference softReference = (SoftReference) this.f12436c.poll();
            if (softReference != null) {
                this.f12435b.remove(softReference);
            } else {
                return;
            }
        }
    }

    public SoftReference c(a aVar) {
        SoftReference softReference = new SoftReference(aVar, this.f12436c);
        this.f12435b.put(softReference, Boolean.TRUE);
        b();
        return softReference;
    }
}
