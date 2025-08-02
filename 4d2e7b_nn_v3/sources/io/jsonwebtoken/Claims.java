package io.jsonwebtoken;

import java.util.Date;
import java.util.Map;

public interface Claims extends Map<String, Object>, ClaimsMutator<Claims> {
    public static final String AUDIENCE = "aud";
    public static final String EXPIRATION = "exp";
    public static final String ID = "jti";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String SUBJECT = "sub";

    <T> T get(String str, Class<T> cls);

    String getAudience();

    Date getExpiration();

    String getId();

    Date getIssuedAt();

    String getIssuer();

    Date getNotBefore();

    String getSubject();

    Claims setAudience(String str);

    Claims setExpiration(Date date);

    Claims setId(String str);

    Claims setIssuedAt(Date date);

    Claims setIssuer(String str);

    Claims setNotBefore(Date date);

    Claims setSubject(String str);
}
