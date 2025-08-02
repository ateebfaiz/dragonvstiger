package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

public class SigningKeyResolverAdapter implements SigningKeyResolver {
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        boolean isHmac = forName.isHmac();
        Assert.isTrue(isHmac, "The default resolveSigningKey(JwsHeader, Claims) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, Claims) method instead and return a Key instance appropriate for the " + forName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, claims), forName.getJcaName());
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, Claims claims) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support Claims JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, Claims) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, Claims) method.");
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, String str) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support plaintext JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, String) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, String) method.");
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, String str) {
        SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        boolean isHmac = forName.isHmac();
        Assert.isTrue(isHmac, "The default resolveSigningKey(JwsHeader, String) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, String) method instead and return a Key instance appropriate for the " + forName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, str), forName.getJcaName());
    }
}
