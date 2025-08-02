package cc;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.h;
import kotlinx.coroutines.n1;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f106a;

    /* renamed from: b  reason: collision with root package name */
    public static final n1 f107b;

    static {
        s sVar = new s();
        f106a = sVar;
        d0.f("kotlinx.coroutines.fast.service.loader", true);
        f107b = sVar.a();
    }

    private s() {
    }

    private final n1 a() {
        Object obj;
        Class<r> cls = r.class;
        try {
            List u10 = h.u(h.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator it = u10.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int c10 = ((r) obj).c();
                    do {
                        Object next = it.next();
                        int c11 = ((r) next).c();
                        if (c10 < c11) {
                            obj = next;
                            c10 = c11;
                        }
                    } while (it.hasNext());
                }
            }
            r rVar = (r) obj;
            if (rVar != null) {
                n1 e10 = t.e(rVar, u10);
                if (e10 != null) {
                    return e10;
                }
            }
            t.b((Throwable) null, (String) null, 3, (Object) null);
            return null;
        } catch (Throwable th) {
            t.b(th, (String) null, 2, (Object) null);
            return null;
        }
    }
}
