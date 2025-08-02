package io.jsonwebtoken;

import io.jsonwebtoken.JwsHeader;

public interface JwsHeader<T extends JwsHeader<T>> extends Header<T> {
    public static final String ALGORITHM = "alg";
    public static final String CRITICAL = "crit";
    public static final String JSON_WEB_KEY = "jwk";
    public static final String JWK_SET_URL = "jku";
    public static final String KEY_ID = "kid";
    public static final String X509_CERT_CHAIN = "x5c";
    public static final String X509_CERT_SHA1_THUMBPRINT = "x5t";
    public static final String X509_CERT_SHA256_THUMBPRINT = "x5t#S256";
    public static final String X509_URL = "x5u";

    String getAlgorithm();

    String getKeyId();

    T setAlgorithm(String str);

    T setKeyId(String str);
}
