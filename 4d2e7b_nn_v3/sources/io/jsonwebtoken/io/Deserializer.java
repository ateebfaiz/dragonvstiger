package io.jsonwebtoken.io;

public interface Deserializer<T> {
    T deserialize(byte[] bArr) throws DeserializationException;
}
