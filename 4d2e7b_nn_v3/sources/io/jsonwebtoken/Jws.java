package io.jsonwebtoken;

public interface Jws<B> extends Jwt<JwsHeader, B> {
    String getSignature();
}
