package io.jsonwebtoken;

public abstract class ClaimJwtException extends JwtException {
    public static final String INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was: %s.";
    public static final String MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was not present in the JWT claims.";
    private final Claims claims;
    private final Header header;

    protected ClaimJwtException(Header header2, Claims claims2, String str) {
        super(str);
        this.header = header2;
        this.claims = claims2;
    }

    public Claims getClaims() {
        return this.claims;
    }

    public Header getHeader() {
        return this.header;
    }

    protected ClaimJwtException(Header header2, Claims claims2, String str, Throwable th) {
        super(str, th);
        this.header = header2;
        this.claims = claims2;
    }
}
