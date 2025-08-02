package wd;

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
import qc.b;
import zc.a;

public class f extends KeyFactorySpi implements a {
    public PrivateKey a(nc.a aVar) {
        return new c(aVar);
    }

    public PublicKey b(b bVar) {
        return new d(bVar);
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return a(nc.a.g(r.k(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        } else {
            throw new InvalidKeySpecException("unsupported key specification: " + keySpec.getClass() + com.alibaba.pdns.f.G);
        }
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return b(b.i(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        } else {
            throw new InvalidKeySpecException("unknown key specification: " + keySpec + com.alibaba.pdns.f.G);
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) {
        if (key instanceof c) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else if (!(key instanceof d)) {
            throw new InvalidKeySpecException("unsupported key type: " + key.getClass() + com.alibaba.pdns.f.G);
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        throw new InvalidKeySpecException("unknown key specification: " + cls + com.alibaba.pdns.f.G);
    }

    public final Key engineTranslateKey(Key key) {
        if ((key instanceof c) || (key instanceof d)) {
            return key;
        }
        throw new InvalidKeyException("unsupported key type");
    }
}
