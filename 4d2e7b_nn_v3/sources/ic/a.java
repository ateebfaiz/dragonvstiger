package ic;

import dd.c;
import hc.m;
import java.math.BigInteger;
import java.util.Hashtable;
import rc.d;
import rc.e;
import rc.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static e f459a = new C0004a();

    /* renamed from: b  reason: collision with root package name */
    static final Hashtable f460b = new Hashtable();

    /* renamed from: c  reason: collision with root package name */
    static final Hashtable f461c = new Hashtable();

    /* renamed from: d  reason: collision with root package name */
    static final Hashtable f462d = new Hashtable();

    /* renamed from: ic.a$a  reason: collision with other inner class name */
    static class C0004a extends e {
        C0004a() {
        }

        /* access modifiers changed from: protected */
        public d a() {
            BigInteger a10 = a.e("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger a11 = a.e("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger a12 = a.e("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger a13 = a.e("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger valueOf = BigInteger.valueOf(1);
            c b10 = a.c(new c.e(a10, a11, a12, a13, valueOf));
            return new d(b10, new f(b10, ae.d.a("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), a13, valueOf, (byte[]) null);
        }
    }

    static {
        d("FRP256v1", b.f463a, f459a);
    }

    /* access modifiers changed from: private */
    public static c c(c cVar) {
        return cVar;
    }

    static void d(String str, m mVar, e eVar) {
        f460b.put(zd.f.d(str), mVar);
        f462d.put(mVar, str);
        f461c.put(mVar, eVar);
    }

    /* access modifiers changed from: private */
    public static BigInteger e(String str) {
        return new BigInteger(1, ae.d.a(str));
    }

    public static d f(String str) {
        m h10 = h(str);
        if (h10 == null) {
            return null;
        }
        return g(h10);
    }

    public static d g(m mVar) {
        e eVar = (e) f461c.get(mVar);
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public static m h(String str) {
        return (m) f460b.get(zd.f.d(str));
    }
}
