package l;

import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static final String f22346b = w.d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final List f22347a = new ArrayList();

    public void a(c cVar) {
        synchronized (this.f22347a) {
            b(cVar);
        }
    }

    public final void b(c cVar) {
        String str = cVar.f22343a;
        for (b a10 : this.f22347a) {
            try {
                a10.a(cVar);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(b bVar) {
        synchronized (this.f22347a) {
            this.f22347a.add(bVar);
        }
    }

    public void d(b bVar) {
        synchronized (this.f22347a) {
            this.f22347a.remove(bVar);
        }
    }
}
