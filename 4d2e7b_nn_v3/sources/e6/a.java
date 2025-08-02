package e6;

import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11900a = new a();

    private a() {
    }

    public static final boolean a() {
        return false;
    }

    public static final Class b(String str) {
        m.f(str, "className");
        if (!a()) {
            return null;
        }
        return Class.forName(str);
    }
}
