package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;

public class EllipticCurveSignatureValidator extends EllipticCurveProvider implements SignatureValidator {
    private static final String EC_PUBLIC_KEY_REQD_MSG = "Elliptic Curve signature validation requires an ECPublicKey instance.";

    public EllipticCurveSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(key instanceof ECPublicKey, EC_PUBLIC_KEY_REQD_MSG);
    }

    /* access modifiers changed from: protected */
    public boolean doVerify(Signature signature, PublicKey publicKey, byte[] bArr, byte[] bArr2) throws InvalidKeyException, SignatureException {
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public boolean isValid(byte[] bArr, byte[] bArr2) {
        Signature createSignatureInstance = createSignatureInstance();
        PublicKey publicKey = (PublicKey) this.key;
        try {
            if (EllipticCurveProvider.getSignatureByteArrayLength(this.alg) == bArr2.length || bArr2[0] != 48) {
                bArr2 = EllipticCurveProvider.transcodeSignatureToDER(bArr2);
            }
            return doVerify(createSignatureInstance, publicKey, bArr, bArr2);
        } catch (Exception e10) {
            throw new io.jsonwebtoken.security.SignatureException("Unable to verify Elliptic Curve signature using configured ECPublicKey. " + e10.getMessage(), e10);
        }
    }
}
