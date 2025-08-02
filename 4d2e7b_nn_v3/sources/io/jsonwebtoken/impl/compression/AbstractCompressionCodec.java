package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.lang.Assert;
import java.io.IOException;

public abstract class AbstractCompressionCodec implements CompressionCodec {
    public final byte[] compress(byte[] bArr) {
        Assert.notNull(bArr, "payload cannot be null.");
        try {
            return doCompress(bArr);
        } catch (IOException e10) {
            throw new CompressionException("Unable to compress payload.", e10);
        }
    }

    public final byte[] decompress(byte[] bArr) {
        Assert.notNull(bArr, "compressed bytes cannot be null.");
        try {
            return doDecompress(bArr);
        } catch (IOException e10) {
            throw new CompressionException("Unable to decompress bytes.", e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract byte[] doCompress(byte[] bArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract byte[] doDecompress(byte[] bArr) throws IOException;
}
