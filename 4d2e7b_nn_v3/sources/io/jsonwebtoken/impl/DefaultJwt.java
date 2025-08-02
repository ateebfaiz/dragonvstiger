package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;

public class DefaultJwt<B> implements Jwt<Header, B> {
    private final B body;
    private final Header header;

    public DefaultJwt(Header header2, B b10) {
        this.header = header2;
        this.body = b10;
    }

    public B getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String toString() {
        return "header=" + this.header + ",body=" + this.body;
    }
}
