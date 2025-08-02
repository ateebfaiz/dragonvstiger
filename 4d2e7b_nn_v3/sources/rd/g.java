package rd;

import com.alibaba.pdns.j;
import hc.t0;
import lc.b;
import qc.a;

abstract class g {
    static a a(String str) {
        if (str.equals(j.f17956c)) {
            return new a(mc.a.f1324i, t0.f424a);
        }
        if (str.equals("SHA-224")) {
            return new a(b.f1228f, t0.f424a);
        }
        if (str.equals("SHA-256")) {
            return new a(b.f1222c, t0.f424a);
        }
        if (str.equals("SHA-384")) {
            return new a(b.f1224d, t0.f424a);
        }
        if (str.equals("SHA-512")) {
            return new a(b.f1226e, t0.f424a);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    static sc.a b(a aVar) {
        if (aVar.g().equals(mc.a.f1324i)) {
            return wc.a.a();
        }
        if (aVar.g().equals(b.f1228f)) {
            return wc.a.b();
        }
        if (aVar.g().equals(b.f1222c)) {
            return wc.a.c();
        }
        if (aVar.g().equals(b.f1224d)) {
            return wc.a.d();
        }
        if (aVar.g().equals(b.f1226e)) {
            return wc.a.e();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + aVar.g());
    }
}
