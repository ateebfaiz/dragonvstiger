package com.geetest.core;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;

public class o extends h {

    /* renamed from: h  reason: collision with root package name */
    public final n4 f6116h;

    /* renamed from: i  reason: collision with root package name */
    public final p f6117i;

    public o(X509Certificate x509Certificate) throws CertificateParsingException, q3 {
        super(x509Certificate);
        int i10;
        n4 c10 = c(x509Certificate);
        this.f6116h = c10;
        List<Boolean> list = null;
        byte[] bArr = null;
        boolean z10 = false;
        boolean z11 = false;
        byte[] bArr2 = null;
        for (i4 next : c10.a()) {
            int intValue = ((p4) next).a().intValue();
            if (intValue == -76003) {
                list = c.b(this.f6116h, next);
            } else if (intValue == -76002) {
                this.f6000c = b(c.e(this.f6116h, next));
            } else if (intValue == -76000) {
                n4 n4Var = (n4) this.f6116h.a(next);
                this.f6003f = new n((n4) n4Var.a(new x4("software")));
                this.f6004g = new n((n4) n4Var.a(new x4("tee")));
            } else if (intValue == -75008) {
                this.f6001d = c.c(this.f6116h, next);
            } else if (intValue != 7) {
                switch (intValue) {
                    case -82006:
                        z10 = c.a(this.f6116h, next).booleanValue();
                        break;
                    case -82005:
                        this.f5999b = c.e(this.f6116h, next);
                        break;
                    case -82004:
                        this.f5998a = c.e(this.f6116h, next);
                        break;
                    case -82003:
                        bArr2 = c.c(this.f6116h, next);
                        break;
                    case -82002:
                        z11 = c.a(this.f6116h, next).booleanValue();
                        break;
                    case -82001:
                        bArr = c.c(this.f6116h, next);
                        break;
                    default:
                        throw new CertificateParsingException("Unknown EAT tag: " + next + "\n in EAT extension:\n" + this);
                }
            } else {
                this.f6002e = c.c(this.f6116h, next);
            }
        }
        if (list != null) {
            i10 = a(list, Boolean.valueOf(z10));
        } else {
            i10 = -1;
        }
        this.f6117i = new p(bArr, z11, i10, bArr2);
    }

    public int a() {
        n nVar = this.f6004g;
        if (nVar != null && nVar.f6088e != null) {
            return nVar.f6087d.intValue();
        }
        n nVar2 = this.f6003f;
        if (nVar2 == null || nVar2.f6088e == null) {
            return -1;
        }
        return nVar2.f6087d.intValue();
    }

    public p b() {
        return this.f6117i;
    }

    public n4 c(X509Certificate x509Certificate) throws CertificateParsingException, q3 {
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.25");
        if (extensionValue == null || extensionValue.length == 0) {
            throw new CertificateParsingException("Did not find extension with OID 1.3.6.1.4.1.11129.2.1.25");
        }
        p3 p3Var = new p3(new ByteArrayInputStream(c.b(c.b(extensionValue))));
        LinkedList linkedList = new LinkedList();
        while (true) {
            i4 a10 = p3Var.a();
            if (a10 == null) {
                return (n4) linkedList.get(0);
            }
            linkedList.add(a10);
        }
    }

    public String toString() {
        return super.toString() + "\nEncoded CBOR: " + this.f6116h;
    }

    public static int b(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 3) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        throw new RuntimeException("Invalid EAT security level: " + i10);
    }

    public static int a(List<Boolean> list, Boolean bool) {
        if (list.size() != 5) {
            throw new RuntimeException("Boot state map has unexpected size: " + list.size());
        } else if (!list.get(4).booleanValue()) {
            boolean booleanValue = list.get(0).booleanValue();
            if (booleanValue != list.get(1).booleanValue() && booleanValue != list.get(2).booleanValue() && booleanValue != list.get(3).booleanValue()) {
                throw new RuntimeException("Unexpected boot state: " + list);
            } else if (bool.booleanValue()) {
                if (booleanValue) {
                    return 0;
                }
                throw new AssertionError("Non-verified official build");
            } else if (booleanValue) {
                return 1;
            } else {
                return 2;
            }
        } else {
            throw new RuntimeException("debug-permanent-disable must never be true: " + list);
        }
    }
}
