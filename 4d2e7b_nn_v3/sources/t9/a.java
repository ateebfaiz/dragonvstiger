package t9;

import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.util.Set;
import s9.i;
import s9.k;
import u9.c;
import u9.d;
import u9.e;

public class a extends e implements k {

    /* renamed from: d  reason: collision with root package name */
    private final c f13123d;

    /* renamed from: e  reason: collision with root package name */
    private final RSAPublicKey f13124e;

    public a(RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey, (Set) null);
    }

    public boolean a(i iVar, byte[] bArr, ha.c cVar) {
        if (!this.f13123d.c(iVar)) {
            return false;
        }
        Signature c10 = d.c(iVar.h(), b().a());
        try {
            c10.initVerify(this.f13124e);
            try {
                c10.update(bArr);
                return c10.verify(cVar.a());
            } catch (SignatureException unused) {
                return false;
            }
        } catch (InvalidKeyException e10) {
            throw new s9.d("Invalid public RSA key: " + e10.getMessage(), e10);
        }
    }

    public a(RSAPublicKey rSAPublicKey, Set set) {
        c cVar = new c();
        this.f13123d = cVar;
        if (rSAPublicKey != null) {
            this.f13124e = rSAPublicKey;
            cVar.d(set);
            return;
        }
        throw new IllegalArgumentException("The public RSA key must not be null");
    }
}
