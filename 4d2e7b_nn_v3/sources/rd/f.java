package rd;

import hc.r;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import kd.c;
import kd.d;
import kd.e;
import ld.g;
import qc.b;
import zc.a;

public class f extends KeyFactorySpi implements a {
    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                nc.a g10 = nc.a.g(r.k(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (e.f572m.equals(g10.i().g())) {
                        c j10 = c.j(g10.j());
                        return new c(new ld.f(j10.l(), j10.k(), j10.g(), j10.i(), j10.m(), j10.n(), j10.o()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                } catch (IOException unused) {
                    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
                }
            } catch (IOException e10) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e10);
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + com.alibaba.pdns.f.G);
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                b i10 = b.i(r.k(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (e.f572m.equals(i10.g().g())) {
                        d i11 = d.i(i10.k());
                        return new d(new g(i11.j(), i11.k(), i11.g()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                } catch (IOException e10) {
                    throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e10.getMessage());
                }
            } catch (IOException e11) {
                throw new InvalidKeySpecException(e11.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + com.alibaba.pdns.f.G);
        }
    }

    /* access modifiers changed from: protected */
    public KeySpec engineGetKeySpec(Key key, Class cls) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Key engineTranslateKey(Key key) {
        return null;
    }
}
