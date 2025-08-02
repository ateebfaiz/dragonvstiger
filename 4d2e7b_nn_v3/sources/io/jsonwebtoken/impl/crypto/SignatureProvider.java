package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;

abstract class SignatureProvider {
    public static final SecureRandom DEFAULT_SECURE_RANDOM;
    protected final SignatureAlgorithm alg;
    protected final Key key;

    static {
        SecureRandom secureRandom = new SecureRandom();
        DEFAULT_SECURE_RANDOM = secureRandom;
        secureRandom.nextBytes(new byte[64]);
    }

    protected SignatureProvider(SignatureAlgorithm signatureAlgorithm, Key key2) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key2, "Key cannot be null.");
        this.alg = signatureAlgorithm;
        this.key = key2;
    }

    /* access modifiers changed from: protected */
    public Signature createSignatureInstance() {
        try {
            return getSignatureInstance();
        } catch (NoSuchAlgorithmException e10) {
            String str = "Unavailable " + this.alg.getFamilyName() + " Signature algorithm '" + this.alg.getJcaName() + "'.";
            if (!this.alg.isJdkStandard() && !isBouncyCastleAvailable()) {
                str = str + " This is not a standard JDK algorithm. Try including BouncyCastle in the runtime classpath.";
            }
            throw new SignatureException(str, e10);
        }
    }

    /* access modifiers changed from: protected */
    public Signature getSignatureInstance() throws NoSuchAlgorithmException {
        return Signature.getInstance(this.alg.getJcaName());
    }

    /* access modifiers changed from: protected */
    public boolean isBouncyCastleAvailable() {
        return RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE;
    }
}
