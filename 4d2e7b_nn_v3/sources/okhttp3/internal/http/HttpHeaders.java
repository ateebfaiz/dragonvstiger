package okhttp3.internal.http;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        m.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        m.f(headers, "$this$parseChallenges");
        m.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (j.q(str, headers.name(i10), true)) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(headers.value(i10)), arrayList);
                } catch (EOFException e10) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e10);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        m.f(response, "$this$promisesBody");
        if (m.b(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1 && !j.q("chunked", Response.header$default(response, "Transfer-Encoding", (String) null, 2, (Object) null), true)) {
            return false;
        }
        return true;
    }

    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) throws EOFException {
        String readToken;
        int skipAll;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    skipCommasAndWhitespace(buffer);
                    str2 = readToken(buffer);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                readToken = readToken(buffer);
                if (readToken != null) {
                    byte b10 = (byte) 61;
                    skipAll = Util.skipAll(buffer, b10);
                    boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                    if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !buffer.exhausted())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int skipAll2 = skipAll + Util.skipAll(buffer, b10);
                        while (true) {
                            if (readToken == null) {
                                readToken = readToken(buffer);
                                if (skipCommasAndWhitespace(buffer)) {
                                    continue;
                                    break;
                                }
                                skipAll2 = Util.skipAll(buffer, b10);
                            }
                            if (skipAll2 == 0) {
                                continue;
                                break;
                            } else if (skipAll2 <= 1 && !skipCommasAndWhitespace(buffer)) {
                                if (startsWith(buffer, (byte) 34)) {
                                    str = readQuotedString(buffer);
                                } else {
                                    str = readToken(buffer);
                                }
                                if (str != null && ((String) linkedHashMap.put(readToken, str)) == null) {
                                    if (skipCommasAndWhitespace(buffer) || buffer.exhausted()) {
                                        readToken = null;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list.add(new Challenge(str2, (Map<String, String>) linkedHashMap));
                        str2 = readToken;
                    }
                } else if (buffer.exhausted()) {
                    list.add(new Challenge(str2, (Map<String, String>) i0.f()));
                    return;
                } else {
                    return;
                }
            }
            Map singletonMap = Collections.singletonMap((Object) null, readToken + j.v("=", skipAll));
            m.e(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str2, (Map<String, String>) singletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        boolean z10;
        byte b10 = (byte) 34;
        if (buffer.readByte() == b10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
                if (indexOfElement == -1) {
                    return null;
                }
                if (buffer.getByte(indexOfElement) == b10) {
                    buffer2.write(buffer, indexOfElement);
                    buffer.readByte();
                    return buffer2.readUtf8();
                } else if (buffer.size() == indexOfElement + 1) {
                    return null;
                } else {
                    buffer2.write(buffer, indexOfElement);
                    buffer.readByte();
                    buffer2.write(buffer, 1);
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        m.f(cookieJar, "$this$receiveHeaders");
        m.f(httpUrl, ImagesContract.URL);
        m.f(headers, "headers");
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.Companion.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z10 = false;
        while (!buffer.exhausted()) {
            byte b10 = buffer.getByte(0);
            if (b10 == 9 || b10 == 32) {
                buffer.readByte();
            } else if (b10 != 44) {
                break;
            } else {
                buffer.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static final boolean startsWith(Buffer buffer, byte b10) {
        if (buffer.exhausted() || buffer.getByte(0) != b10) {
            return false;
        }
        return true;
    }
}
