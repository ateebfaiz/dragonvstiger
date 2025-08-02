package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.m;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f796a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f797b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f798c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f799d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f800e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f801f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f802g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Charset f803h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile Charset f804i;

    static {
        Charset forName = Charset.forName("UTF-8");
        m.e(forName, "forName(...)");
        f797b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        m.e(forName2, "forName(...)");
        f798c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        m.e(forName3, "forName(...)");
        f799d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        m.e(forName4, "forName(...)");
        f800e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        m.e(forName5, "forName(...)");
        f801f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        m.e(forName6, "forName(...)");
        f802g = forName6;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f804i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        m.e(forName, "forName(...)");
        f804i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f803h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        m.e(forName, "forName(...)");
        f803h = forName;
        return forName;
    }
}
