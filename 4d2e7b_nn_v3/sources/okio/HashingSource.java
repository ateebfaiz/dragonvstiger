package okio;

import com.alibaba.pdns.j;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        public final HashingSource hmacSha1(Source source, ByteString byteString) {
            m.f(source, "source");
            m.f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA1");
        }

        public final HashingSource hmacSha256(Source source, ByteString byteString) {
            m.f(source, "source");
            m.f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        public final HashingSource hmacSha512(Source source, ByteString byteString) {
            m.f(source, "source");
            m.f(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        public final HashingSource md5(Source source) {
            m.f(source, "source");
            return new HashingSource(source, j.f17955b);
        }

        public final HashingSource sha1(Source source) {
            m.f(source, "source");
            return new HashingSource(source, j.f17956c);
        }

        public final HashingSource sha256(Source source) {
            m.f(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        public final HashingSource sha512(Source source) {
            m.f(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, String str) {
        super(source);
        m.f(source, "source");
        m.f(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m150deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        byte[] bArr;
        MessageDigest messageDigest2 = this.messageDigest;
        if (messageDigest2 != null) {
            bArr = messageDigest2.digest();
        } else {
            Mac mac2 = this.mac;
            m.c(mac2);
            bArr = mac2.doFinal();
        }
        m.e(bArr, DbParams.KEY_CHANNEL_RESULT);
        return new ByteString(bArr);
    }

    public long read(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "sink");
        long read = super.read(buffer, j10);
        if (read != -1) {
            long size = buffer.size() - read;
            long size2 = buffer.size();
            Segment segment = buffer.head;
            m.c(segment);
            while (size2 > size) {
                segment = segment.prev;
                m.c(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            while (size2 < buffer.size()) {
                int i10 = (int) ((((long) segment.pos) + size) - size2);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(segment.data, i10, segment.limit - i10);
                } else {
                    Mac mac2 = this.mac;
                    m.c(mac2);
                    mac2.update(segment.data, i10, segment.limit - i10);
                }
                size2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                m.c(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        m.f(source, "source");
        m.f(byteString, "key");
        m.f(str, "algorithm");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Unit unit = Unit.f12577a;
            this.mac = instance;
            this.messageDigest = null;
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
