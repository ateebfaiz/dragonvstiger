package vd;

import hc.d;
import qc.b;

public abstract class a {
    public static byte[] a(qc.a aVar, d dVar) {
        try {
            return b(new b(aVar, dVar));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(b bVar) {
        try {
            return bVar.f("DER");
        } catch (Exception unused) {
            return null;
        }
    }
}
