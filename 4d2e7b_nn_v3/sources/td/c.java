package td;

import hc.r;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import kd.f;
import kd.g;
import qc.b;
import zc.a;

public class c extends KeyFactorySpi implements a {
    public PrivateKey a(nc.a aVar) {
        f j10 = f.j(aVar.j());
        return new a(j10.k(), j10.g(), j10.l(), j10.i(), j10.n(), j10.m());
    }

    public PublicKey b(b bVar) {
        g l10 = g.l(bVar.k());
        return new b(l10.k(), l10.g(), l10.j(), l10.i());
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof xd.a) {
            return new a((xd.a) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return a(nc.a.g(r.k(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + com.alibaba.pdns.f.G);
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof xd.b) {
            return new b((xd.b) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return b(b.i(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown key specification: " + keySpec + com.alibaba.pdns.f.G);
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) {
        if (key instanceof a) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (xd.a.class.isAssignableFrom(cls)) {
                a aVar = (a) key;
                return new xd.a(aVar.c(), aVar.a(), aVar.d(), aVar.b(), aVar.f(), aVar.e());
            }
        } else if (!(key instanceof b)) {
            throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + com.alibaba.pdns.f.G);
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        } else {
            if (xd.b.class.isAssignableFrom(cls)) {
                b bVar = (b) key;
                return new xd.b(bVar.d(), bVar.a(), bVar.c(), bVar.b());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + com.alibaba.pdns.f.G);
    }

    public final Key engineTranslateKey(Key key) {
        if ((key instanceof a) || (key instanceof b)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }
}
