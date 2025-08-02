package io.jsonwebtoken.io;

public interface Encoder<T, R> {
    R encode(T t10) throws EncodingException;
}
