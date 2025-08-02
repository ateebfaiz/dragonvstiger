package io.jsonwebtoken.security;

public class InvalidKeyException extends KeyException {
    public InvalidKeyException(String str) {
        super(str);
    }
}
