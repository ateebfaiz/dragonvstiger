package io.jsonwebtoken;

public class CompressionException extends JwtException {
    public CompressionException(String str) {
        super(str);
    }

    public CompressionException(String str, Throwable th) {
        super(str, th);
    }
}
