package okhttp3.internal;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.b;
import kotlin.collections.g0;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.d;
import kotlin.text.h;
import kotlin.text.j;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;

public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final h VERIFY_AS_IP_ADDRESS = new h("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.9.2";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        m.c(timeZone);
        UTC = timeZone;
        String name = OkHttpClient.class.getName();
        m.e(name, "OkHttpClient::class.java.name");
        okHttpName = j.m0(j.l0(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e10) {
        m.f(list, "$this$addIfAbsent");
        if (!list.contains(e10)) {
            list.add(e10);
        }
    }

    public static final int and(byte b10, int i10) {
        return b10 & i10;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        m.f(eventListener, "$this$asFactory");
        return new Util$asFactory$1(eventListener);
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        m.f(obj, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(obj);
            throw new AssertionError(sb2.toString());
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        m.f(obj, "$this$assertThreadHoldsLock");
        if (assertionsEnabled && !Thread.holdsLock(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(obj);
            throw new AssertionError(sb2.toString());
        }
    }

    public static final boolean canParseAsIpAddress(String str) {
        m.f(str, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.c(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        m.f(httpUrl, "$this$canReuseConnectionFor");
        m.f(httpUrl2, "other");
        if (!m.b(httpUrl.host(), httpUrl2.host()) || httpUrl.port() != httpUrl2.port() || !m.b(httpUrl.scheme(), httpUrl2.scheme())) {
            return false;
        }
        return true;
    }

    public static final int checkDuration(String str, long j10, TimeUnit timeUnit) {
        boolean z10;
        boolean z11;
        boolean z12;
        m.f(str, "name");
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        boolean z13 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (timeUnit != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                long millis = timeUnit.toMillis(j10);
                if (millis <= ((long) Integer.MAX_VALUE)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (millis != 0 || i10 <= 0) {
                        z13 = true;
                    }
                    if (z13) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((str + " too small.").toString());
                }
                throw new IllegalArgumentException((str + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((str + " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        m.f(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        m.f(strArr, "$this$concat");
        m.f(str, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        m.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[kotlin.collections.j.A(strArr2)] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i10, int i11) {
        m.f(str, "$this$delimiterOffset");
        m.f(str2, "delimiters");
        while (i10 < i11) {
            if (j.J(str2, str.charAt(i10), false, 2, (Object) null)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, str2, i10, i11);
    }

    public static final boolean discard(Source source, int i10, TimeUnit timeUnit) {
        m.f(source, "$this$discard");
        m.f(timeUnit, "timeUnit");
        try {
            return skipAll(source, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        m.f(iterable, "$this$filterList");
        m.f(function1, "predicate");
        List<T> l10 = r.l();
        for (Object next : iterable) {
            if (((Boolean) function1.invoke(next)).booleanValue()) {
                if (l10.isEmpty()) {
                    l10 = new ArrayList<>();
                }
                c0.c(l10).add(next);
            }
        }
        return l10;
    }

    public static final String format(String str, Object... objArr) {
        m.f(str, "format");
        m.f(objArr, "args");
        b0 b0Var = b0.f709a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        m.e(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        m.f(strArr, "$this$hasIntersection");
        m.f(comparator, "comparator");
        if (!(strArr.length == 0 || strArr2 == null || strArr2.length == 0)) {
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

    public static final long headersContentLength(Response response) {
        m.f(response, "$this$headersContentLength");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1);
        }
        return -1;
    }

    public static final void ignoreIoExceptions(Function0<Unit> function0) {
        m.f(function0, "block");
        try {
            function0.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        m.f(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(r.o(Arrays.copyOf(objArr, objArr.length)));
        m.e(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        m.f(strArr, "$this$indexOf");
        m.f(str, "value");
        m.f(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        m.f(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (m.g(charAt, 31) <= 0 || m.g(charAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i10, int i11) {
        m.f(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i10, int i11) {
        m.f(str, "$this$indexOfLastNonAsciiWhitespace");
        int i12 = i11 - 1;
        if (i12 >= i10) {
            while (true) {
                char charAt = str.charAt(i12);
                if (charAt == 9 || charAt == 10 || charAt == 12 || charAt == 13 || charAt == ' ') {
                    if (i12 == i10) {
                        break;
                    }
                    i12--;
                } else {
                    return i12 + 1;
                }
            }
        }
        return i10;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i10, i11);
    }

    public static final int indexOfNonWhitespace(String str, int i10) {
        m.f(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt != ' ' && charAt != 9) {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return indexOfNonWhitespace(str, i10);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        m.f(strArr, "$this$intersect");
        m.f(strArr2, "other");
        m.f(comparator, "comparator");
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
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        tb.c.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r2 = kotlin.Unit.f12577a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        tb.c.a(r0, (java.lang.Throwable) null);
        r3.delete(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isCivilized(okhttp3.internal.io.FileSystem r3, java.io.File r4) {
        /*
            java.lang.String r0 = "$this$isCivilized"
            kotlin.jvm.internal.m.f(r3, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.m.f(r4, r0)
            okio.Sink r0 = r3.sink(r4)
            r1 = 0
            r3.delete(r4)     // Catch:{ IOException -> 0x0019 }
            tb.c.a(r0, r1)
            r3 = 1
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x0023
        L_0x0019:
            kotlin.Unit r2 = kotlin.Unit.f12577a     // Catch:{ all -> 0x0017 }
            tb.c.a(r0, r1)
            r3.delete(r4)
            r3 = 0
            return r3
        L_0x0023:
            throw r3     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            tb.c.a(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.isCivilized(okhttp3.internal.io.FileSystem, java.io.File):boolean");
    }

    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        int soTimeout;
        m.f(socket, "$this$isHealthy");
        m.f(bufferedSource, "source");
        try {
            soTimeout = socket.getSoTimeout();
            socket.setSoTimeout(1);
            boolean z10 = !bufferedSource.exhausted();
            socket.setSoTimeout(soTimeout);
            return z10;
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        } catch (Throwable th) {
            socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        m.f(str, "name");
        if (j.q(str, "Authorization", true) || j.q(str, "Cookie", true) || j.q(str, "Proxy-Authorization", true) || j.q(str, "Set-Cookie", true)) {
            return true;
        }
        return false;
    }

    public static final void notify(Object obj) {
        m.f(obj, "$this$notify");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        m.f(obj, "$this$notifyAll");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c10) {
        if ('0' <= c10 && '9' >= c10) {
            return c10 - '0';
        }
        if ('a' <= c10 && 'f' >= c10) {
            return c10 - 'W';
        }
        if ('A' <= c10 && 'F' >= c10) {
            return c10 - '7';
        }
        return -1;
    }

    public static final String peerName(Socket socket) {
        m.f(socket, "$this$peerName");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        m.e(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        m.f(bufferedSource, "$this$readBomAsCharset");
        m.f(charset, "default");
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            m.e(charset2, "UTF_8");
            return charset2;
        } else if (select == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            m.e(charset3, "UTF_16BE");
            return charset3;
        } else if (select == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            m.e(charset4, "UTF_16LE");
            return charset4;
        } else if (select == 3) {
            return d.f796a.a();
        } else {
            if (select == 4) {
                return d.f796a.b();
            }
            throw new AssertionError();
        }
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        Object readFieldOrNull;
        m.f(obj, "instance");
        m.f(cls, "fieldType");
        m.f(str, "fieldName");
        Class cls2 = obj.getClass();
        while (true) {
            Class<Object> cls3 = Object.class;
            if (!m.b(cls2, cls3)) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    m.e(declaredField, "field");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (!cls.isInstance(obj2)) {
                        return null;
                    }
                    return cls.cast(obj2);
                } catch (NoSuchFieldException unused) {
                    cls2 = cls2.getSuperclass();
                    m.e(cls2, "c.superclass");
                }
            } else if (!(!m.b(str, "delegate")) || (readFieldOrNull = readFieldOrNull(obj, cls3, "delegate")) == null) {
                return null;
            } else {
                return readFieldOrNull(readFieldOrNull, cls, str);
            }
        }
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        m.f(bufferedSource, "$this$readMedium");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final boolean skipAll(Source source, int i10, TimeUnit timeUnit) throws IOException {
        m.f(source, "$this$skipAll");
        m.f(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos((long) i10)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                source.timeout().clearDeadline();
            } else {
                source.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(String str, boolean z10) {
        m.f(str, "name");
        return new Util$threadFactory$1(str, z10);
    }

    public static final void threadName(String str, Function0<Unit> function0) {
        m.f(str, "name");
        m.f(function0, "block");
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "currentThread");
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            function0.invoke();
        } finally {
            k.b(1);
            currentThread.setName(name);
            k.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        m.f(headers, "$this$toHeaderList");
        IntRange l10 = l.l(0, headers.size());
        ArrayList arrayList = new ArrayList(r.v(l10, 10));
        Iterator it = l10.iterator();
        while (it.hasNext()) {
            int nextInt = ((g0) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        m.f(list, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header next : list) {
            builder.addLenient$okhttp(next.component1().utf8(), next.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(long j10) {
        String hexString = Long.toHexString(j10);
        m.e(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z10) {
        String str;
        m.f(httpUrl, "$this$toHostHeader");
        if (j.K(httpUrl.host(), ":", false, 2, (Object) null)) {
            str = '[' + httpUrl.host() + ']';
        } else {
            str = httpUrl.host();
        }
        if (!z10 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return str;
        }
        return str + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return toHostHeader(httpUrl, z10);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        m.f(list, "$this$toImmutableList");
        List<T> unmodifiableList = Collections.unmodifiableList(r.y0(list));
        m.e(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        m.f(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return i0.f();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        m.e(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j10) {
        m.f(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int toNonNegativeInt(String str, int i10) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > ((long) Integer.MAX_VALUE)) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i10;
    }

    public static final String trimSubstring(String str, int i10, int i11) {
        m.f(str, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i10, i11);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i11));
        m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return trimSubstring(str, i10, i11);
    }

    public static final void wait(Object obj) {
        m.f(obj, "$this$wait");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) {
        m.f(exc, "$this$withSuppressed");
        m.f(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception a10 : list) {
            b.a(exc, a10);
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i10) throws IOException {
        m.f(bufferedSink, "$this$writeMedium");
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public static final int and(short s10, int i10) {
        return s10 & i10;
    }

    public static final int delimiterOffset(String str, char c10, int i10, int i11) {
        m.f(str, "$this$delimiterOffset");
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return delimiterOffset(str, c10, i10, i11);
    }

    public static final String toHexString(int i10) {
        String hexString = Integer.toHexString(i10);
        m.e(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final long and(int i10, long j10) {
        return ((long) i10) & j10;
    }

    public static final void closeQuietly(Socket socket) {
        m.f(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!m.b(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        m.f(serverSocket, "$this$closeQuietly");
        try {
            serverSocket.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b10) {
        m.f(buffer, "$this$skipAll");
        int i10 = 0;
        while (!buffer.exhausted() && buffer.getByte(0) == b10) {
            i10++;
            buffer.readByte();
        }
        return i10;
    }
}
