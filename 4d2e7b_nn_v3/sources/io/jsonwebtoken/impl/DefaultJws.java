package io.jsonwebtoken.impl;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;

public class DefaultJws<B> implements Jws<B> {
    private final B body;
    private final JwsHeader header;
    private final String signature;

    public DefaultJws(JwsHeader jwsHeader, B b10, String str) {
        this.header = jwsHeader;
        this.body = b10;
        this.signature = str;
    }

    public B getBody() {
        return this.body;
    }

    public String getSignature() {
        return this.signature;
    }

    public String toString() {
        return "header=" + this.header + ",body=" + this.body + ",signature=" + this.signature;
    }

    public JwsHeader getHeader() {
        return this.header;
    }
}
