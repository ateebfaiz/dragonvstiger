package a3;

import io.jsonwebtoken.JwtParser;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13666a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f13667b = i0.i(t.a("mkv", "video/x-matroska"), t.a("glb", "model/gltf-binary"));

    private a() {
    }

    private final String a(String str) {
        int Z = j.Z(str, JwtParser.SEPARATOR_CHAR, 0, false, 6, (Object) null);
        if (Z < 0 || Z == str.length() - 1) {
            return null;
        }
        String substring = str.substring(Z + 1);
        m.e(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String b(String str) {
        m.f(str, "path");
        String a10 = f13666a.a(str);
        if (a10 == null) {
            return null;
        }
        Locale locale = Locale.US;
        m.e(locale, "US");
        String lowerCase = a10.toLowerCase(locale);
        m.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (lowerCase == null) {
            return null;
        }
        String a11 = b.a(lowerCase);
        if (a11 == null) {
            return (String) f13667b.get(lowerCase);
        }
        return a11;
    }

    public static final boolean c(String str) {
        if (str != null) {
            return j.F(str, "video/", false, 2, (Object) null);
        }
        return false;
    }
}
