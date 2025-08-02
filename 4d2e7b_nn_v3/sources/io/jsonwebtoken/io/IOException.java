package io.jsonwebtoken.io;

import io.jsonwebtoken.JwtException;

public class IOException extends JwtException {
    public IOException(String str) {
        super(str);
    }

    public IOException(String str, Throwable th) {
        super(str, th);
    }
}
