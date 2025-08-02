package io.jsonwebtoken;

public interface CompressionCodecResolver {
    CompressionCodec resolveCompressionCodec(Header header) throws CompressionException;
}
