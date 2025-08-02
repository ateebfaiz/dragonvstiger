package io.jsonwebtoken.security;

import io.jsonwebtoken.JwtException;

public class SecurityException extends JwtException {
    public SecurityException(String str) {
        super(str);
    }

    public SecurityException(String str, Throwable th) {
        super(str, th);
    }
}
