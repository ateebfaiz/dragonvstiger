package org.cocos2dx.okhttp3.internal;

import androidx.core.location.LocationRequestCompat;
import com.alibaba.pdns.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.MediaType;
import org.cocos2dx.okhttp3.RequestBody;
import org.cocos2dx.okhttp3.ResponseBody;
import org.cocos2dx.okhttp3.internal.http2.Header;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.BufferedSource;
import org.cocos2dx.okio.ByteString;
import org.cocos2dx.okio.Source;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Comparator<String> NATURAL_ORDER = new a();
    public static final TimeZone UTC = TimeZone.getTimeZone("GMT");
    private static final Charset UTF_16_BE = Charset.forName("UTF-16BE");
    private static final ByteString UTF_16_BE_BOM = ByteString.decodeHex("feff");
    private static final Charset UTF_16_LE = Charset.forName("UTF-16LE");
    private static final ByteString UTF_16_LE_BOM = ByteString.decodeHex("fffe");
    private static final Charset UTF_32_BE = Charset.forName("UTF-32BE");
    private static final ByteString UTF_32_BE_BOM = ByteString.decodeHex("0000ffff");
    private static final Charset UTF_32_LE = Charset.forName("UTF-32LE");
    private static final ByteString UTF_32_LE_BOM = ByteString.decodeHex("ffff0000");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final ByteString UTF_8_BOM = ByteString.decodeHex("efbbbf");
    private static final Pattern VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    private static final Method addSuppressedExceptionMethod;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1561a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f1562b;

        b(String str, boolean z10) {
            this.f1561a = str;
            this.f1562b = z10;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f1561a);
            thread.setDaemon(this.f1562b);
            return thread;
        }
    }

    static {
        Class<Throwable> cls = Throwable.class;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        Method method = null;
        EMPTY_RESPONSE = ResponseBody.create((MediaType) null, bArr);
        EMPTY_REQUEST = RequestBody.create((MediaType) null, bArr);
        try {
            method = cls.getDeclaredMethod("addSuppressed", new Class[]{cls});
        } catch (Exception unused) {
        }
        addSuppressedExceptionMethod = method;
    }

    private Util() {
    }

    public static void addSuppressedIfPossible(Throwable th, Throwable th2) {
        Method method = addSuppressedExceptionMethod;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError assertionError(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset bomAwareCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        ByteString byteString = UTF_8_BOM;
        if (bufferedSource.rangeEquals(0, byteString)) {
            bufferedSource.skip((long) byteString.size());
            return UTF_8;
        }
        ByteString byteString2 = UTF_16_BE_BOM;
        if (bufferedSource.rangeEquals(0, byteString2)) {
            bufferedSource.skip((long) byteString2.size());
            return UTF_16_BE;
        }
        ByteString byteString3 = UTF_16_LE_BOM;
        if (bufferedSource.rangeEquals(0, byteString3)) {
            bufferedSource.skip((long) byteString3.size());
            return UTF_16_LE;
        }
        ByteString byteString4 = UTF_32_BE_BOM;
        if (bufferedSource.rangeEquals(0, byteString4)) {
            bufferedSource.skip((long) byteString4.size());
            return UTF_32_BE;
        }
        ByteString byteString5 = UTF_32_LE_BOM;
        if (!bufferedSource.rangeEquals(0, byteString5)) {
            return charset;
        }
        bufferedSource.skip((long) byteString5.size());
        return UTF_32_LE;
    }

    public static String canonicalizeHost(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static int checkDuration(String str, long j10, TimeUnit timeUnit) {
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j10);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i10 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] concat(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean containsInvalidHostnameAsciiCodes(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int decodeHexDigit(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 < 'A' || c10 > 'F') {
            return -1;
        }
        return c10 - '7';
    }

    private static boolean decodeIpv4Suffix(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char charAt = str.charAt(i14);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i14++;
                }
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        if (i13 != i12 + 4) {
            return false;
        }
        return true;
    }

    private static InetAddress decodeIpv6(String str, int i10, int i11) {
        byte[] bArr = new byte[16];
        int i12 = 0;
        int i13 = -1;
        int i14 = -1;
        while (true) {
            if (i10 >= i11) {
                break;
            } else if (i12 == 16) {
                return null;
            } else {
                int i15 = i10 + 2;
                if (i15 > i11 || !str.regionMatches(i10, "::", 0, 2)) {
                    if (i12 != 0) {
                        if (str.regionMatches(i10, ":", 0, 1)) {
                            i10++;
                        } else if (!str.regionMatches(i10, f.G, 0, 1) || !decodeIpv4Suffix(str, i14, i11, bArr, i12 - 2)) {
                            return null;
                        } else {
                            i12 += 2;
                        }
                    }
                    i14 = i10;
                } else if (i13 != -1) {
                    return null;
                } else {
                    i12 += 2;
                    i13 = i12;
                    if (i15 == i11) {
                        break;
                    }
                    i14 = i15;
                }
                int i16 = 0;
                i10 = i14;
                while (i10 < i11) {
                    int decodeHexDigit = decodeHexDigit(str.charAt(i10));
                    if (decodeHexDigit == -1) {
                        break;
                    }
                    i16 = (i16 << 4) + decodeHexDigit;
                    i10++;
                }
                int i17 = i10 - i14;
                if (i17 == 0 || i17 > 4) {
                    return null;
                }
                int i18 = i12 + 1;
                bArr[i12] = (byte) ((i16 >>> 8) & 255);
                i12 += 2;
                bArr[i18] = (byte) (i16 & 255);
            }
        }
        if (i12 != 16) {
            if (i13 == -1) {
                return null;
            }
            int i19 = i12 - i13;
            System.arraycopy(bArr, i13, bArr, 16 - i19, i19);
            Arrays.fill(bArr, i13, (16 - i12) + i13, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int delimiterOffset(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static boolean discard(Source source, int i10, TimeUnit timeUnit) {
        try {
            return skipAll(source, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z10) {
        String str;
        if (httpUrl.host().contains(":")) {
            str = "[" + httpUrl.host() + "]";
        } else {
            str = httpUrl.host();
        }
        if (!z10 && httpUrl.port() == HttpUrl.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ":" + httpUrl.port();
    }

    public static <T> List<T> immutableList(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int indexOf(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static int indexOfControlOrNonAscii(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt >= 127) {
                return i10;
            }
        }
        return -1;
    }

    private static String inet6AddressToAscii(byte[] bArr) {
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        Buffer buffer = new Buffer();
        while (i11 < bArr.length) {
            if (i11 == i10) {
                buffer.writeByte(58);
                i11 += i13;
                if (i11 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i11 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) (((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255)));
                i11 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static String[] intersect(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i10++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        if (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) {
            return false;
        }
        return true;
    }

    public static boolean nonEmptyIntersection(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager platformTrustManager() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e10) {
            throw assertionError("No System TLS", e10);
        }
    }

    public static boolean skipAll(Source source, int i10, TimeUnit timeUnit) throws IOException {
        long j10;
        long nanoTime = System.nanoTime();
        if (source.timeout().hasDeadline()) {
            j10 = source.timeout().deadlineNanoTime() - nanoTime;
        } else {
            j10 = Long.MAX_VALUE;
        }
        source.timeout().deadlineNanoTime(Math.min(j10, timeUnit.toNanos((long) i10)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192) != -1) {
                buffer.clear();
            }
            if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
                return true;
            }
            source.timeout().deadlineNanoTime(nanoTime + j10);
            return true;
        } catch (InterruptedIOException unused) {
            if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
                return false;
            }
            source.timeout().deadlineNanoTime(nanoTime + j10);
            return false;
        } catch (Throwable th) {
            if (j10 == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + j10);
            }
            throw th;
        }
    }

    public static int skipLeadingAsciiWhitespace(String str, int i10, int i11) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char charAt = str.charAt(i12);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }

    public static ThreadFactory threadFactory(String str, boolean z10) {
        return new b(str, z10);
    }

    public static Headers toHeaders(List<Header> list) {
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            Internal.instance.addLenient(builder, next.name.utf8(), next.value.utf8());
        }
        return builder.build();
    }

    public static String trimSubstring(String str, int i10, int i11) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i10, i11);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i11));
    }

    public static boolean verifyAsIpAddress(String str) {
        return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
    }

    public static int delimiterOffset(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static <T> List<T> immutableList(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!isAndroidGetsocknameError(e10)) {
                    throw e10;
                }
            } catch (RuntimeException e11) {
                if (!"bio == null".equals(e11.getMessage())) {
                    throw e11;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }
}
