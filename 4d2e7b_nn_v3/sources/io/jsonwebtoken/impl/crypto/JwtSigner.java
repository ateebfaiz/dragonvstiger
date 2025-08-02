package io.jsonwebtoken.impl.crypto;

public interface JwtSigner {
    String sign(String str);
}
