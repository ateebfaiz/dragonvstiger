package io.jsonwebtoken.impl.crypto;

public interface JwtSignatureValidator {
    boolean isValid(String str, String str2);
}
