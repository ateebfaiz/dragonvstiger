package org.cocos2dx.okhttp3.internal.http;

import androidx.webkit.ProxyConfig;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.cocos2dx.okhttp3.Challenge;
import org.cocos2dx.okhttp3.Cookie;
import org.cocos2dx.okhttp3.CookieJar;
import org.cocos2dx.okhttp3.Headers;
import org.cocos2dx.okhttp3.HttpUrl;
import org.cocos2dx.okhttp3.Request;
import org.cocos2dx.okhttp3.Response;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.ByteString;

public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    private static void parseChallengeHeader(List<Challenge> list, Buffer buffer) {
        String readToken;
        int skipAll;
        String str;
        while (true) {
            String str2 = null;
            while (true) {
                if (str2 == null) {
                    skipWhitespaceAndCommas(buffer);
                    str2 = readToken(buffer);
                    if (str2 == null) {
                        return;
                    }
                }
                boolean skipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
                readToken = readToken(buffer);
                if (readToken != null) {
                    skipAll = skipAll(buffer, (byte) 61);
                    boolean skipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
                    if (skipWhitespaceAndCommas || (!skipWhitespaceAndCommas2 && !buffer.exhausted())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int skipAll2 = skipAll + skipAll(buffer, (byte) 61);
                        while (true) {
                            if (readToken == null) {
                                readToken = readToken(buffer);
                                if (skipWhitespaceAndCommas(buffer)) {
                                    continue;
                                    break;
                                }
                                skipAll2 = skipAll(buffer, (byte) 61);
                            }
                            if (skipAll2 == 0) {
                                continue;
                                break;
                            } else if (skipAll2 <= 1 && !skipWhitespaceAndCommas(buffer)) {
                                if (buffer.exhausted() || buffer.getByte(0) != 34) {
                                    str = readToken(buffer);
                                } else {
                                    str = readQuotedString(buffer);
                                }
                                if (str == null || ((String) linkedHashMap.put(readToken, str)) != null) {
                                    return;
                                }
                                if (skipWhitespaceAndCommas(buffer) || buffer.exhausted()) {
                                    readToken = null;
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
                    list.add(new Challenge(str2, (Map<String, String>) Collections.emptyMap()));
                    return;
                } else {
                    return;
                }
            }
            list.add(new Challenge(str2, (Map<String, String>) Collections.singletonMap((Object) null, readToken + repeat('=', skipAll))));
        }
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            if (str.equalsIgnoreCase(headers.name(i10))) {
                parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i10)));
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i10) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() == 34) {
            Buffer buffer2 = new Buffer();
            while (true) {
                long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
                if (indexOfElement == -1) {
                    return null;
                }
                if (buffer.getByte(indexOfElement) == 34) {
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
            throw new IllegalArgumentException();
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (indexOfElement == -1) {
                indexOfElement = buffer.size();
            }
            if (indexOfElement != 0) {
                return buffer.readUtf8(indexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(httpUrl, headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, parseAll);
            }
        }
    }

    private static String repeat(char c10, int i10) {
        char[] cArr = new char[i10];
        Arrays.fill(cArr, c10);
        return new String(cArr);
    }

    private static int skipAll(Buffer buffer, byte b10) {
        int i10 = 0;
        while (!buffer.exhausted() && buffer.getByte(0) == b10) {
            i10++;
            buffer.readByte();
        }
        return i10;
    }

    public static int skipUntil(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static int skipWhitespace(String str, int i10) {
        while (i10 < str.length() && ((r0 = str.charAt(i10)) == ' ' || r0 == 9)) {
            i10++;
        }
        return i10;
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z10 = false;
        while (!buffer.exhausted()) {
            byte b10 = buffer.getByte(0);
            if (b10 != 44) {
                if (b10 != 32 && b10 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String next : varyFields(response)) {
            if (!Util.equal(headers.values(next), request.headers(next))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains(ProxyConfig.MATCH_ALL_SCHEMES);
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            if ("Vary".equalsIgnoreCase(headers.name(i10))) {
                String value = headers.value(i10);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i10));
            }
        }
        return builder.build();
    }
}
