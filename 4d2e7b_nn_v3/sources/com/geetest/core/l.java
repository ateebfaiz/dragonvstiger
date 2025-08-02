package com.geetest.core;

import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateParsingException;

public class l implements Comparable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final String f6062a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6063b;

    public l(v vVar) throws CertificateParsingException {
        if (vVar instanceof s0) {
            s0 s0Var = (s0) vVar;
            try {
                this.f6062a = c.f(s0Var.a(0));
                this.f6063b = c.e(s0Var.a(1)).longValue();
            } catch (UnsupportedEncodingException e10) {
                throw new CertificateParsingException("Converting octet stream to String triggered an UnsupportedEncodingException", e10);
            }
        } else {
            throw new CertificateParsingException("Expected sequence for AttestationPackageInfo, found " + vVar.getClass().getName());
        }
    }

    /* renamed from: a */
    public int compareTo(l lVar) {
        int compareTo = this.f6062a.compareTo(lVar.f6062a);
        if (compareTo != 0) {
            return compareTo;
        }
        return Long.compare(this.f6063b, lVar.f6063b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l) || compareTo((l) obj) != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.f6062a + " (version code " + this.f6063b + ")\n";
    }
}
