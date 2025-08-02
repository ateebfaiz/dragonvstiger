package wd;

import hc.m;
import lc.b;
import sc.a;
import tc.f;
import tc.h;
import tc.i;

abstract class e {
    static a a(m mVar) {
        if (mVar.equals(b.f1222c)) {
            return new f();
        }
        if (mVar.equals(b.f1226e)) {
            return new h();
        }
        if (mVar.equals(b.f1239m)) {
            return new i(128);
        }
        if (mVar.equals(b.f1240n)) {
            return new i(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + mVar);
    }
}
