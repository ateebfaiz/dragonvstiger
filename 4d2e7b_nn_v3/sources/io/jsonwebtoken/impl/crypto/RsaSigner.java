package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAKey;

public class RsaSigner extends RsaProvider implements Signer {
    public RsaSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        if (!(key instanceof PrivateKey) || !(key instanceof RSAKey)) {
            throw new IllegalArgumentException("RSA signatures must be computed using an RSA PrivateKey.  The specified key of type " + key.getClass().getName() + " is not an RSA PrivateKey.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] doSign(byte[] bArr) throws InvalidKeyException, SignatureException {
        Signature createSignatureInstance = createSignatureInstance();
        createSignatureInstance.initSign((PrivateKey) this.key);
        createSignatureInstance.update(bArr);
        return createSignatureInstance.sign();
    }

    public byte[] sign(byte[] bArr) {
        try {
            return doSign(bArr);
        } catch (InvalidKeyException e10) {
            throw new io.jsonwebtoken.security.SignatureException("Invalid RSA PrivateKey. " + e10.getMessage(), e10);
        } catch (SignatureException e11) {
            throw new io.jsonwebtoken.security.SignatureException("Unable to calculate signature using RSA PrivateKey. " + e11.getMessage(), e11);
        }
    }
}
