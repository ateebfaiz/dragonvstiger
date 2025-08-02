package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.security.MessageDigest;

public class MacValidator implements SignatureValidator {
    private final MacSigner signer;

    public MacValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        this.signer = new MacSigner(signatureAlgorithm, key);
    }

    public boolean isValid(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(this.signer.sign(bArr), bArr2);
    }
}
