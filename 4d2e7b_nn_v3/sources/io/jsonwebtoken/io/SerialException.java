package io.jsonwebtoken.io;

public class SerialException extends IOException {
    public SerialException(String str) {
        super(str);
    }

    public SerialException(String str, Throwable th) {
        super(str, th);
    }
}
