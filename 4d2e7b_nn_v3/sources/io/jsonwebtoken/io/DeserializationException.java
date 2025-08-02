package io.jsonwebtoken.io;

public class DeserializationException extends SerialException {
    public DeserializationException(String str) {
        super(str);
    }

    public DeserializationException(String str, Throwable th) {
        super(str, th);
    }
}
