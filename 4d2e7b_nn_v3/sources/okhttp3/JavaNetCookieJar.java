package okhttp3;

import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.j;
import okhttp3.Cookie;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler2) {
        m.f(cookieHandler2, "cookieHandler");
        this.cookieHandler = cookieHandler2;
    }

    private final List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int delimiterOffset = Util.delimiterOffset(str, ";,", i10, length);
            int delimiterOffset2 = Util.delimiterOffset(str, '=', i10, delimiterOffset);
            String trimSubstring = Util.trimSubstring(str, i10, delimiterOffset2);
            if (!j.F(trimSubstring, "$", false, 2, (Object) null)) {
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (j.F(str2, "\"", false, 2, (Object) null) && j.p(str2, "\"", false, 2, (Object) null)) {
                    str2 = str2.substring(1, str2.length() - 1);
                    m.e(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(str2).domain(httpUrl.host()).build());
            }
            i10 = delimiterOffset + 1;
        }
        return arrayList;
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        m.f(httpUrl, ImagesContract.URL);
        try {
            Map<String, List<String>> map = this.cookieHandler.get(httpUrl.uri(), i0.f());
            m.e(map, "cookieHeaders");
            ArrayList arrayList = null;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                List<String> list = (List) next.getValue();
                if (j.q("Cookie", str, true) || j.q("Cookie2", str, true)) {
                    m.e(list, "value");
                    if (!list.isEmpty()) {
                        for (String str2 : list) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            m.e(str2, "header");
                            arrayList.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                        }
                    }
                }
            }
            if (arrayList == null) {
                return r.l();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            m.e(unmodifiableList, "Collections.unmodifiableList(cookies)");
            return unmodifiableList;
        } catch (IOException e10) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Loading cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            m.c(resolve);
            sb2.append(resolve);
            platform.log(sb2.toString(), 5, e10);
            return r.l();
        }
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        m.f(httpUrl, ImagesContract.URL);
        m.f(list, "cookies");
        ArrayList arrayList = new ArrayList();
        for (Cookie cookieToString : list) {
            arrayList.add(Internal.cookieToString(cookieToString, true));
        }
        try {
            this.cookieHandler.put(httpUrl.uri(), i0.d(t.a("Set-Cookie", arrayList)));
        } catch (IOException e10) {
            Platform platform = Platform.Companion.get();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Saving cookies failed for ");
            HttpUrl resolve = httpUrl.resolve("/...");
            m.c(resolve);
            sb2.append(resolve);
            platform.log(sb2.toString(), 5, e10);
        }
    }
}
