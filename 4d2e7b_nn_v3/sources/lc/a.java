package lc;

import hc.m;
import java.util.Hashtable;
import oc.b;
import rc.d;
import zd.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static final Hashtable f1216a = new Hashtable();

    /* renamed from: b  reason: collision with root package name */
    static final Hashtable f1217b = new Hashtable();

    static {
        a("B-571", b.F);
        a("B-409", b.D);
        a("B-283", b.f1382n);
        a("B-233", b.f1388t);
        a("B-163", b.f1380l);
        a("K-571", b.E);
        a("K-409", b.C);
        a("K-283", b.f1381m);
        a("K-233", b.f1387s);
        a("K-163", b.f1370b);
        a("P-521", b.B);
        a("P-384", b.A);
        a("P-256", b.H);
        a("P-224", b.f1394z);
        a("P-192", b.G);
    }

    static void a(String str, m mVar) {
        f1216a.put(str, mVar);
        f1217b.put(mVar, str);
    }

    public static d b(String str) {
        m mVar = (m) f1216a.get(f.e(str));
        if (mVar != null) {
            return c(mVar);
        }
        return null;
    }

    public static d c(m mVar) {
        return oc.a.i(mVar);
    }
}
