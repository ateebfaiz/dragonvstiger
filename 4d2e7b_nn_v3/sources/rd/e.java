package rd;

import com.alibaba.pdns.f;
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
import ld.b;
import ld.c;
import zc.a;

public class e extends KeyFactorySpi implements a {
    /* access modifiers changed from: protected */
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                nc.a g10 = nc.a.g(r.k(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (kd.e.f573n.equals(g10.i().g())) {
                        kd.a k10 = kd.a.k(g10.j());
                        return new a(new b(k10.m(), k10.l(), k10.i(), k10.j(), k10.n(), g.b(k10.g()).getAlgorithmName()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                } catch (IOException unused) {
                    throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
                }
            } catch (IOException e10) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e10);
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + f.G);
        }
    }

    /* access modifiers changed from: protected */
    public PublicKey engineGeneratePublic(KeySpec keySpec) {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                qc.b i10 = qc.b.i(r.k(((X509EncodedKeySpec) keySpec).getEncoded()));
                try {
                    if (kd.e.f573n.equals(i10.g().g())) {
                        kd.b j10 = kd.b.j(i10.k());
                        return new b(new c(j10.k(), j10.l(), j10.i(), g.b(j10.g()).getAlgorithmName()));
                    }
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                } catch (IOException e10) {
                    throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e10.getMessage());
                }
            } catch (IOException e11) {
                throw new InvalidKeySpecException(e11.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + f.G);
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
