package io.jsonwebtoken.impl.crypto;

public interface SignatureValidator {
    boolean isValid(byte[] bArr, byte[] bArr2);
}
