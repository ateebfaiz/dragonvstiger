package org.cocos2dx.okio;

import com.alibaba.pdns.j;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, j.f17955b);
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, j.f17956c);
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public final ByteString hash() {
        byte[] bArr;
        MessageDigest messageDigest2 = this.messageDigest;
        if (messageDigest2 != null) {
            bArr = messageDigest2.digest();
        } else {
            bArr = this.mac.doFinal();
        }
        return ByteString.of(bArr);
    }

    public long read(Buffer buffer, long j10) throws IOException {
        long read = super.read(buffer, j10);
        if (read != -1) {
            long j11 = buffer.size;
            long j12 = j11 - read;
            d dVar = buffer.head;
            while (j11 > j12) {
                dVar = dVar.f1795g;
                j11 -= (long) (dVar.f1791c - dVar.f1790b);
            }
            while (j11 < buffer.size) {
                int i10 = (int) ((((long) dVar.f1790b) + j12) - j11);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(dVar.f1789a, i10, dVar.f1791c - i10);
                } else {
                    this.mac.update(dVar.f1789a, i10, dVar.f1791c - i10);
                }
                j12 = ((long) (dVar.f1791c - dVar.f1790b)) + j11;
                dVar = dVar.f1794f;
                j11 = j12;
            }
        }
        return read;
    }

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            Mac instance = Mac.getInstance(str);
            this.mac = instance;
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
