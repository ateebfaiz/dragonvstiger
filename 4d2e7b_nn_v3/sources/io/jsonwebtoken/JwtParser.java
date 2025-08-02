package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public interface JwtParser {
    public static final char SEPARATOR_CHAR = '.';

    JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    boolean isSigned(String str);

    Jwt parse(String str) throws ExpiredJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    <T> T parse(String str, JwtHandler<T> jwtHandler) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    Jws<Claims> parseClaimsJws(String str) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    Jwt<Header, Claims> parseClaimsJwt(String str) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    Jws<String> parsePlaintextJws(String str) throws UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    Jwt<Header, String> parsePlaintextJwt(String str) throws UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException;

    JwtParser require(String str, Object obj);

    JwtParser requireAudience(String str);

    JwtParser requireExpiration(Date date);

    JwtParser requireId(String str);

    JwtParser requireIssuedAt(Date date);

    JwtParser requireIssuer(String str);

    JwtParser requireNotBefore(Date date);

    JwtParser requireSubject(String str);

    JwtParser setAllowedClockSkewSeconds(long j10);

    JwtParser setClock(Clock clock);

    JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver);

    JwtParser setSigningKey(String str);

    JwtParser setSigningKey(Key key);

    JwtParser setSigningKey(byte[] bArr);

    JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver);
}
