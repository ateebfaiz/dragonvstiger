package io.jsonwebtoken.io;

public interface Serializer<T> {
    byte[] serialize(T t10) throws SerializationException;
}
