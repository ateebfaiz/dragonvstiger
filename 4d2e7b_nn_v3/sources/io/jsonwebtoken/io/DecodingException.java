package io.jsonwebtoken.io;

public class DecodingException extends CodecException {
    public DecodingException(String str) {
        super(str);
    }

    public DecodingException(String str, Throwable th) {
        super(str, th);
    }
}
