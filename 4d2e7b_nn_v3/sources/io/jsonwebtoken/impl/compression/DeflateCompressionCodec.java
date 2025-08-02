package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class DeflateCompressionCodec extends AbstractCompressionCodec {
    private static final String DEFLATE = "DEF";

    public byte[] doCompress(byte[] bArr) throws IOException {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(9);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream2, deflater, true);
                try {
                    deflaterOutputStream.write(bArr, 0, bArr.length);
                    deflaterOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Objects.nullSafeClose(byteArrayOutputStream2, deflaterOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    Objects.nullSafeClose(byteArrayOutputStream, deflaterOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                deflaterOutputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                Objects.nullSafeClose(byteArrayOutputStream, deflaterOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            deflaterOutputStream = null;
            Objects.nullSafeClose(byteArrayOutputStream, deflaterOutputStream);
            throw th;
        }
    }

    public byte[] doDecompress(byte[] bArr) throws IOException {
        InflaterOutputStream inflaterOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream2);
                try {
                    inflaterOutputStream.write(bArr);
                    inflaterOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Objects.nullSafeClose(byteArrayOutputStream2, inflaterOutputStream);
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inflaterOutputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inflaterOutputStream = null;
            Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
            throw th;
        }
    }

    public String getAlgorithmName() {
        return DEFLATE;
    }
}
