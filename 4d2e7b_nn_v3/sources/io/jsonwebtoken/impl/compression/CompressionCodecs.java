package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;

@Deprecated
public final class CompressionCodecs {
    @Deprecated
    public static final CompressionCodec DEFLATE = io.jsonwebtoken.CompressionCodecs.DEFLATE;
    @Deprecated
    public static final CompressionCodec GZIP = io.jsonwebtoken.CompressionCodecs.GZIP;
    private static final CompressionCodecs I = new CompressionCodecs();

    private CompressionCodecs() {
    }
}
