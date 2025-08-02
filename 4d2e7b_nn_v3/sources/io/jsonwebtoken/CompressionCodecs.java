package io.jsonwebtoken;

import io.jsonwebtoken.lang.Classes;

public final class CompressionCodecs {
    public static final CompressionCodec DEFLATE = ((CompressionCodec) Classes.newInstance("io.jsonwebtoken.impl.compression.DeflateCompressionCodec"));
    public static final CompressionCodec GZIP = ((CompressionCodec) Classes.newInstance("io.jsonwebtoken.impl.compression.GzipCompressionCodec"));

    private CompressionCodecs() {
    }
}
