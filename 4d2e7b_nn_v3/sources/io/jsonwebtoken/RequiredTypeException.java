package io.jsonwebtoken;

public class RequiredTypeException extends JwtException {
    public RequiredTypeException(String str) {
        super(str);
    }

    public RequiredTypeException(String str, Throwable th) {
        super(str, th);
    }
}
