package io.jsonwebtoken;

public class UnsupportedJwtException extends JwtException {
    public UnsupportedJwtException(String str) {
        super(str);
    }

    public UnsupportedJwtException(String str, Throwable th) {
        super(str, th);
    }
}
