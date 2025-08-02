package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;

public class DefaultCompressionCodecResolver implements CompressionCodecResolver {
    private String getAlgorithmFromHeader(Header header) {
        Assert.notNull(header, "header cannot be null.");
        return header.getCompressionAlgorithm();
    }

    public CompressionCodec resolveCompressionCodec(Header header) {
        String algorithmFromHeader = getAlgorithmFromHeader(header);
        if (!Strings.hasText(algorithmFromHeader)) {
            return null;
        }
        CompressionCodec compressionCodec = CompressionCodecs.DEFLATE;
        if (compressionCodec.getAlgorithmName().equalsIgnoreCase(algorithmFromHeader)) {
            return compressionCodec;
        }
        CompressionCodec compressionCodec2 = CompressionCodecs.GZIP;
        if (compressionCodec2.getAlgorithmName().equalsIgnoreCase(algorithmFromHeader)) {
            return compressionCodec2;
        }
        throw new CompressionException("Unsupported compression algorithm '" + algorithmFromHeader + "'");
    }
}
