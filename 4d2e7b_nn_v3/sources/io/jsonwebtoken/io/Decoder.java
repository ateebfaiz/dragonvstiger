package io.jsonwebtoken.io;

public interface Decoder<T, R> {
    R decode(T t10) throws DecodingException;
}
