package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MacSigner extends MacProvider implements Signer {
    public MacSigner(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this(signatureAlgorithm, (Key) new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()));
    }

    /* access modifiers changed from: protected */
    public Mac doGetMacInstance() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac instance = Mac.getInstance(this.alg.getJcaName());
        instance.init(this.key);
        return instance;
    }

    /* access modifiers changed from: protected */
    public Mac getMacInstance() throws SignatureException {
        try {
            return doGetMacInstance();
        } catch (NoSuchAlgorithmException e10) {
            throw new SignatureException("Unable to obtain JCA MAC algorithm '" + this.alg.getJcaName() + "': " + e10.getMessage(), e10);
        } catch (InvalidKeyException e11) {
            throw new SignatureException("The specified signing key is not a valid " + this.alg.name() + " key: " + e11.getMessage(), e11);
        }
    }

    public byte[] sign(byte[] bArr) {
        return getMacInstance().doFinal(bArr);
    }

    public MacSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isHmac(), "The MacSigner only supports HMAC signature algorithms.");
        if (!(key instanceof SecretKey)) {
            throw new IllegalArgumentException("MAC signatures must be computed and verified using a SecretKey.  The specified key of type " + key.getClass().getName() + " is not a SecretKey.");
        }
    }
}
