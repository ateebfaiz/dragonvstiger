package l9;

import android.util.Base64;
import android.util.Log;
import cd.a;
import cd.b;
import i9.c;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.security.SecurityException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import k9.g;

public class h implements SigningKeyResolver {

    /* renamed from: a  reason: collision with root package name */
    private final e f12765a;

    public h(e eVar) {
        this.f12765a = eVar;
    }

    private static BigInteger a(String str) {
        return new BigInteger(1, Base64.decode(str, 8));
    }

    private static ECPublicKey b(g.c cVar) {
        BigInteger a10 = a(cVar.c());
        BigInteger a11 = a(cVar.d());
        try {
            KeyFactory instance = KeyFactory.getInstance("EC");
            ECPoint eCPoint = new ECPoint(a10, a11);
            a a12 = ad.a.a(cVar.a());
            return (ECPublicKey) instance.generatePublic(new ECPublicKeySpec(eCPoint, new b(cVar.a(), a12.a(), a12.b(), a12.c())));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
            Log.e("OpenIdSignKeyResolver", "failed to generate EC Public Key from JWK: " + cVar, e10);
            return null;
        }
    }

    private Key c(JwsHeader jwsHeader) {
        c b10 = this.f12765a.b();
        if (!b10.g()) {
            Log.e("OpenIdSignKeyResolver", "failed to get LINE JSON Web Key Set [JWK] document.");
            return null;
        }
        String keyId = jwsHeader.getKeyId();
        g.c a10 = ((g) b10.e()).a(keyId);
        if (a10 == null) {
            Log.e("OpenIdSignKeyResolver", "failed to find Key by Id: " + keyId);
            return null;
        }
        String algorithm = jwsHeader.getAlgorithm();
        if (SignatureAlgorithm.forName(algorithm).isEllipticCurve()) {
            return b(a10);
        }
        throw new SecurityException("Unsupported signature algorithm '" + algorithm + '\'');
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        return c(jwsHeader);
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, String str) {
        return c(jwsHeader);
    }
}
