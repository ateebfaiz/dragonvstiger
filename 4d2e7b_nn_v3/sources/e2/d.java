package e2;

import android.content.Context;
import com.facebook.o;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;
import q5.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f21143a = new HashMap();

    private final synchronized o e(a aVar) {
        o oVar = (o) this.f21143a.get(aVar);
        if (oVar == null) {
            Context f10 = o.f();
            b e10 = b.f23250h.e(f10);
            if (e10 != null) {
                oVar = new o(e10, g.f21166c.b(f10));
            } else {
                oVar = null;
            }
        }
        if (oVar == null) {
            return null;
        }
        this.f21143a.put(aVar, oVar);
        return oVar;
    }

    public final synchronized void a(a aVar, c cVar) {
        m.f(aVar, "accessTokenAppIdPair");
        m.f(cVar, "appEvent");
        o e10 = e(aVar);
        if (e10 != null) {
            e10.a(cVar);
        }
    }

    public final synchronized void b(n nVar) {
        if (nVar != null) {
            try {
                for (a aVar : nVar.c()) {
                    o e10 = e(aVar);
                    if (e10 != null) {
                        List<c> b10 = nVar.b(aVar);
                        if (b10 != null) {
                            for (c a10 : b10) {
                                e10.a(a10);
                            }
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized o c(a aVar) {
        m.f(aVar, "accessTokenAppIdPair");
        return (o) this.f21143a.get(aVar);
    }

    public final synchronized int d() {
        int i10;
        i10 = 0;
        for (o c10 : this.f21143a.values()) {
            i10 += c10.c();
        }
        return i10;
    }

    public final synchronized Set f() {
        Set keySet;
        keySet = this.f21143a.keySet();
        m.e(keySet, "stateMap.keys");
        return keySet;
    }
}
