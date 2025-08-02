package com.geetest.core;

import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;

public class g extends h {

    /* renamed from: h  reason: collision with root package name */
    public int f5980h;

    public g(X509Certificate x509Certificate) throws CertificateParsingException {
        super(x509Certificate);
        s0 c10 = c(x509Certificate);
        this.f5998a = c.c(c10.a(0));
        this.f5980h = c.c(c10.a(1));
        this.f5999b = c.c(c10.a(2));
        this.f6000c = c.c(c10.a(3));
        this.f6001d = c.b(c10.a(4));
        this.f6002e = c.b(c10.a(5));
        this.f6003f = new n(c10.a(6));
        this.f6004g = new n(c10.a(7));
    }

    public int a() {
        return this.f5980h;
    }

    public p b() {
        p pVar = this.f6004g.f6105v;
        if (pVar != null) {
            return pVar;
        }
        return this.f6003f.f6105v;
    }

    public s0 c(X509Certificate x509Certificate) throws CertificateParsingException {
        e0 e0Var;
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (extensionValue == null || extensionValue.length == 0) {
            throw new CertificateParsingException("Did not find extension with OID 1.3.6.1.4.1.11129.2.1.17");
        }
        try {
            e0Var = new e0(extensionValue);
            s0 a10 = c.a(e0Var);
            e0Var.close();
            return a10;
        } catch (IOException e10) {
            throw new CertificateParsingException("Failed to parse SEQUENCE", e10);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
