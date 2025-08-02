package f1;

import f1.j;
import f1.k;
import java.net.InetAddress;
import java.net.URI;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    static final j.f f21451a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final k.a f21452b = new b();

    /* renamed from: c  reason: collision with root package name */
    static final j.f f21453c = new c();

    /* renamed from: d  reason: collision with root package name */
    static final k.a f21454d = new d();

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public URI a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return l.b(jVar);
        }
    }

    class b implements k.a {
        b() {
        }

        /* renamed from: b */
        public void a(k kVar, URI uri) {
            l.f(uri, kVar);
        }
    }

    class c implements j.f {
        c() {
        }

        /* renamed from: b */
        public InetAddress a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return l.a(jVar);
        }
    }

    class d implements k.a {
        d() {
        }

        /* renamed from: b */
        public void a(k kVar, InetAddress inetAddress) {
            l.e(inetAddress, kVar);
        }
    }

    public static InetAddress a(j jVar) {
        return InetAddress.getByName(jVar.F());
    }

    public static URI b(j jVar) {
        return URI.create(jVar.G());
    }

    public static void c(InetAddress inetAddress, k kVar) {
        kVar.l((byte) 34);
        kVar.i(inetAddress.getHostAddress());
        kVar.l((byte) 34);
    }

    public static void d(URI uri, k kVar) {
        r.c(uri.toString(), kVar);
    }

    public static void e(InetAddress inetAddress, k kVar) {
        if (inetAddress == null) {
            kVar.n();
        } else {
            c(inetAddress, kVar);
        }
    }

    public static void f(URI uri, k kVar) {
        if (uri == null) {
            kVar.n();
        } else {
            d(uri, kVar);
        }
    }
}
