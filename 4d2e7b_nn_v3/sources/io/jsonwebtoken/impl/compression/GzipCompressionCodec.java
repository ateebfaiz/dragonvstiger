package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressionCodec extends AbstractCompressionCodec implements CompressionCodec {
    private static final String GZIP = "GZIP";

    /* access modifiers changed from: protected */
    public byte[] doCompress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream, true);
        try {
            gZIPOutputStream.write(bArr, 0, bArr.length);
            gZIPOutputStream.finish();
            return byteArrayOutputStream.toByteArray();
        } finally {
            Objects.nullSafeClose(gZIPOutputStream, byteArrayOutputStream);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] doDecompress(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2 = new byte[512];
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = null;
                byteArrayOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                Objects.nullSafeClose(byteArrayInputStream, gZIPInputStream, byteArrayOutputStream);
                throw th;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                Objects.nullSafeClose(byteArrayInputStream, gZIPInputStream, byteArrayOutputStream);
                throw th;
            }
            try {
                for (int read = gZIPInputStream.read(bArr2); read != -1; read = gZIPInputStream.read(bArr2)) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Objects.nullSafeClose(byteArrayInputStream2, gZIPInputStream, byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = byteArrayInputStream2;
                Objects.nullSafeClose(byteArrayInputStream, gZIPInputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            byteArrayOutputStream = null;
            Objects.nullSafeClose(byteArrayInputStream, gZIPInputStream, byteArrayOutputStream);
            throw th;
        }
    }

    public String getAlgorithmName() {
        return GZIP;
    }
}
