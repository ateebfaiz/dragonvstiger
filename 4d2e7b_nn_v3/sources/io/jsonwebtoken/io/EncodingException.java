package io.jsonwebtoken.io;

public class EncodingException extends CodecException {
    public EncodingException(String str, Throwable th) {
        super(str, th);
    }
}
