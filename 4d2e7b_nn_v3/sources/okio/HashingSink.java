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

public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        public final HashingSink hmacSha1(Sink sink, ByteString byteString) {
            m.f(sink, "sink");
            m.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA1");
        }

        public final HashingSink hmacSha256(Sink sink, ByteString byteString) {
            m.f(sink, "sink");
            m.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        public final HashingSink hmacSha512(Sink sink, ByteString byteString) {
            m.f(sink, "sink");
            m.f(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        public final HashingSink md5(Sink sink) {
            m.f(sink, "sink");
            return new HashingSink(sink, j.f17955b);
        }

        public final HashingSink sha1(Sink sink) {
            m.f(sink, "sink");
            return new HashingSink(sink, j.f17956c);
        }

        public final HashingSink sha256(Sink sink) {
            m.f(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        public final HashingSink sha512(Sink sink) {
            m.f(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, String str) {
        super(sink);
        m.f(sink, "sink");
        m.f(str, "algorithm");
        this.messageDigest = MessageDigest.getInstance(str);
        this.mac = null;
    }

    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m149deprecated_hash() {
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

    public void write(Buffer buffer, long j10) throws IOException {
        m.f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0, j10);
        Segment segment = buffer.head;
        m.c(segment);
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, (long) (segment.limit - segment.pos));
            MessageDigest messageDigest2 = this.messageDigest;
            if (messageDigest2 != null) {
                messageDigest2.update(segment.data, segment.pos, min);
            } else {
                Mac mac2 = this.mac;
                m.c(mac2);
                mac2.update(segment.data, segment.pos, min);
            }
            j11 += (long) min;
            segment = segment.next;
            m.c(segment);
        }
        super.write(buffer, j10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        m.f(sink, "sink");
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
