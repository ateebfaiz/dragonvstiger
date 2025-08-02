package io.jsonwebtoken.io;

public class CodecException extends IOException {
    public CodecException(String str) {
        super(str);
    }

    public CodecException(String str, Throwable th) {
        super(str, th);
    }
}
