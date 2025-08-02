package io.jsonwebtoken;

public class IncorrectClaimException extends InvalidClaimException {
    public IncorrectClaimException(Header header, Claims claims, String str) {
        super(header, claims, str);
    }

    public IncorrectClaimException(Header header, Claims claims, String str, Throwable th) {
        super(header, claims, str, th);
    }
}
