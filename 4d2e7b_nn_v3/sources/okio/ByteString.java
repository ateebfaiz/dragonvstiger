package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.d;
import okio.internal.ByteStringKt;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charset = d.f797b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return companion.of(bArr, i10, i11);
        }

        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m139deprecated_decodeBase64(String str) {
            m.f(str, "string");
            return decodeBase64(str);
        }

        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m140deprecated_decodeHex(String str) {
            m.f(str, "string");
            return decodeHex(str);
        }

        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m141deprecated_encodeString(String str, Charset charset) {
            m.f(str, "string");
            m.f(charset, "charset");
            return encodeString(str, charset);
        }

        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m142deprecated_encodeUtf8(String str) {
            m.f(str, "string");
            return encodeUtf8(str);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m143deprecated_of(ByteBuffer byteBuffer) {
            m.f(byteBuffer, "buffer");
            return of(byteBuffer);
        }

        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m145deprecated_read(InputStream inputStream, int i10) {
            m.f(inputStream, "inputstream");
            return read(inputStream, i10);
        }

        public final ByteString decodeBase64(String str) {
            m.f(str, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            boolean z10;
            m.f(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    bArr[i10] = (byte) ((ByteStringKt.decodeHexDigit(str.charAt(i11)) << 4) + ByteStringKt.decodeHexDigit(str.charAt(i11 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final ByteString encodeString(String str, Charset charset) {
            m.f(str, "$this$encode");
            m.f(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            m.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            m.f(str, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(ByteBuffer byteBuffer) {
            m.f(byteBuffer, "$this$toByteString");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i10) throws IOException {
            boolean z10;
            m.f(inputStream, "$this$readByteString");
            int i11 = 0;
            if (i10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                byte[] bArr = new byte[i10];
                while (i11 < i10) {
                    int read = inputStream.read(bArr, i11, i10 - i11);
                    if (read != -1) {
                        i11 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m144deprecated_of(byte[] bArr, int i10, int i11) {
            m.f(bArr, "array");
            return of(bArr, i10, i11);
        }

        public final ByteString of(byte... bArr) {
            m.f(bArr, "data");
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        public final ByteString of(byte[] bArr, int i10, int i11) {
            m.f(bArr, "$this$toByteString");
            Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
            return new ByteString(j.h(bArr, i10, i11 + i10));
        }
    }

    public ByteString(byte[] bArr) {
        m.f(bArr, "data");
        this.data = bArr;
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return byteString.indexOf(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public static final ByteString read(InputStream inputStream, int i10) throws IOException {
        return Companion.read(inputStream, i10);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        m.e(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = byteString.size();
            }
            return byteString.substring(i10, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m137deprecated_getByte(int i10) {
        return getByte(i10);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m138deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        m.e(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public ByteString digest$okio(String str) {
        m.f(str, "algorithm");
        return ByteStringKt.commonDigest(this, str);
    }

    public final boolean endsWith(ByteString byteString) {
        m.f(byteString, "suffix");
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i10) {
        return internalGet$okio(i10);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode2 = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode2);
        return hashCode2;
    }

    public String hex() {
        char[] cArr = new char[(getData$okio().length * 2)];
        int i10 = 0;
        for (byte b10 : getData$okio()) {
            int i11 = i10 + 1;
            cArr[i10] = ByteStringKt.getHEX_DIGIT_CHARS()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = ByteStringKt.getHEX_DIGIT_CHARS()[b10 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        m.f(str, "algorithm");
        m.f(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = instance.doFinal(this.data);
            m.e(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        m.f(byteString, "key");
        return hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        m.f(byteString, "key");
        return hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        m.f(byteString, "key");
        return hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i10) {
        return getData$okio()[i10];
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio(com.alibaba.pdns.j.f17955b);
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        m.f(byteString, "other");
        return byteString.rangeEquals(i11, getData$okio(), i10, i12);
    }

    public final void setHashCode$okio(int i10) {
        this.hashCode = i10;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio(com.alibaba.pdns.j.f17956c);
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        m.f(byteString, "prefix");
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        m.f(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, (Object) null);
    }

    public ByteString toAsciiLowercase() {
        byte b10;
        int i10 = 0;
        while (i10 < getData$okio().length) {
            byte b11 = getData$okio()[i10];
            byte b12 = (byte) 65;
            if (b11 < b12 || b11 > (b10 = (byte) 90)) {
                i10++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b10;
        int i10 = 0;
        while (i10 < getData$okio().length) {
            byte b11 = getData$okio()[i10];
            byte b12 = (byte) 97;
            if (b11 < b12 || b11 > (b10 = (byte) 122)) {
                i10++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String toString() {
        boolean z10;
        ByteString byteString;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf82 = utf8();
            if (utf82 != null) {
                String substring = utf82.substring(0, access$codePointIndexToCharIndex);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String z11 = kotlin.text.j.z(kotlin.text.j.z(kotlin.text.j.z(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (access$codePointIndexToCharIndex < utf82.length()) {
                    return "[size=" + getData$okio().length + " text=" + z11 + "…]";
                }
                return "[text=" + z11 + ']';
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (getData$okio().length <= 64) {
            return "[hex=" + hex() + ']';
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(getData$okio().length);
            sb2.append(" hex=");
            if (64 <= getData$okio().length) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (64 == getData$okio().length) {
                    byteString = this;
                } else {
                    byteString = new ByteString(j.h(getData$okio(), 0, 64));
                }
                sb2.append(byteString.hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream outputStream) throws IOException {
        m.f(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$okio(Buffer buffer, int i10, int i11) {
        m.f(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i10, i11);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return byteString.indexOf(bArr, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r0 < r1) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (r7 < r8) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.m.f(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x0013:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x002e
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0028:
            if (r7 >= r8) goto L_0x002c
        L_0x002a:
            r3 = r5
            goto L_0x0034
        L_0x002c:
            r3 = r6
            goto L_0x0034
        L_0x002e:
            if (r0 != r1) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            if (r0 >= r1) goto L_0x002c
            goto L_0x002a
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(byte[] bArr) {
        m.f(bArr, "suffix");
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        m.f(bArr, "other");
        return i10 >= 0 && i10 <= getData$okio().length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && Util.arrayRangeEquals(getData$okio(), i10, bArr, i11, i12);
    }

    public final boolean startsWith(byte[] bArr) {
        m.f(bArr, "prefix");
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final ByteString substring(int i10) {
        return substring$default(this, i10, 0, 2, (Object) null);
    }

    public static final ByteString of(byte[] bArr, int i10, int i11) {
        return Companion.of(bArr, i10, i11);
    }

    public final int indexOf(ByteString byteString, int i10) {
        m.f(byteString, "other");
        return indexOf(byteString.internalArray$okio(), i10);
    }

    public final int lastIndexOf(ByteString byteString, int i10) {
        m.f(byteString, "other");
        return lastIndexOf(byteString.internalArray$okio(), i10);
    }

    public ByteString substring(int i10, int i11) {
        boolean z10 = false;
        if (i10 >= 0) {
            if (i11 <= getData$okio().length) {
                if (i11 - i10 >= 0) {
                    z10 = true;
                }
                if (!z10) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i10 == 0 && i11 == getData$okio().length) {
                    return this;
                } else {
                    return new ByteString(j.h(getData$okio(), i10, i11));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public int indexOf(byte[] bArr, int i10) {
        m.f(bArr, "other");
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i10, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        m.f(bArr, "other");
        for (int min = Math.min(i10, getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }
}
