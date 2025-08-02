package io.jsonwebtoken;

public class JwtHandlerAdapter<T> implements JwtHandler<T> {
    public T onClaimsJws(Jws<Claims> jws) {
        throw new UnsupportedJwtException("Signed Claims JWSs are not supported.");
    }

    public T onClaimsJwt(Jwt<Header, Claims> jwt) {
        throw new UnsupportedJwtException("Unsigned Claims JWTs are not supported.");
    }

    public T onPlaintextJws(Jws<String> jws) {
        throw new UnsupportedJwtException("Signed plaintext JWSs are not supported.");
    }

    public T onPlaintextJwt(Jwt<Header, String> jwt) {
        throw new UnsupportedJwtException("Unsigned plaintext JWTs are not supported.");
    }
}
