package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public abstract class MacProvider extends SignatureProvider {
    protected MacProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isHmac(), "SignatureAlgorithm must be a HMAC SHA algorithm.");
    }

    public static SecretKey generateKey() {
        return generateKey(SignatureAlgorithm.HS512);
    }

    public static SecretKey generateKey(SignatureAlgorithm signatureAlgorithm) {
        return generateKey(signatureAlgorithm, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    @Deprecated
    public static SecretKey generateKey(SignatureAlgorithm signatureAlgorithm, SecureRandom secureRandom) {
        Assert.isTrue(signatureAlgorithm.isHmac(), "SignatureAlgorithm argument must represent an HMAC algorithm.");
        try {
            return KeyGenerator.getInstance(signatureAlgorithm.getJcaName()).generateKey();
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("The " + signatureAlgorithm.getJcaName() + " algorithm is not available.  " + "This should never happen on JDK 7 or later - please report this to the JJWT developers.", e10);
        }
    }
}
