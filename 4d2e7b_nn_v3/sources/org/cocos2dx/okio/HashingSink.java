package org.cocos2dx.okio;

import com.alibaba.pdns.j;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSink extends ForwardingSink {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, j.f17955b);
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, j.f17956c);
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, "SHA-256");
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, "SHA-512");
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

    public void write(Buffer buffer, long j10) throws IOException {
        g.b(buffer.size, 0, j10);
        d dVar = buffer.head;
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, (long) (dVar.f1791c - dVar.f1790b));
            MessageDigest messageDigest2 = this.messageDigest;
            if (messageDigest2 != null) {
                messageDigest2.update(dVar.f1789a, dVar.f1790b, min);
            } else {
                this.mac.update(dVar.f1789a, dVar.f1790b, min);
            }
            j11 += (long) min;
            dVar = dVar.f1794f;
        }
        super.write(buffer, j10);
    }

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
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
