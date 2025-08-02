package io.jsonwebtoken;

import io.jsonwebtoken.Header;

public interface Jwt<H extends Header, B> {
    B getBody();

    H getHeader();
}
