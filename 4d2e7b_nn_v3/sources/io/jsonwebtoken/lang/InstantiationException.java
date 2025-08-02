package io.jsonwebtoken.lang;

public class InstantiationException extends RuntimeException {
    public InstantiationException(String str, Throwable th) {
        super(str, th);
    }
}
