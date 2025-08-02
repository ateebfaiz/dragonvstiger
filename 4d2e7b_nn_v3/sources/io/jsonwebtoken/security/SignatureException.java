package io.jsonwebtoken.security;

public class SignatureException extends io.jsonwebtoken.SignatureException {
    public SignatureException(String str) {
        super(str);
    }

    public SignatureException(String str, Throwable th) {
        super(str, th);
    }
}
