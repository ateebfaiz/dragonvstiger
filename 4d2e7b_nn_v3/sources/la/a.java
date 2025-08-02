package la;

import ma.b;
import ma.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f12772a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f12773b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f12774c;

    static {
        String canonicalName = b.class.getCanonicalName();
        if (canonicalName != null) {
            f12773b = canonicalName;
            String canonicalName2 = d.class.getCanonicalName();
            if (canonicalName2 != null) {
                f12774c = canonicalName2;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private a() {
    }

    public final String a() {
        return f12773b;
    }

    public final String b() {
        return f12774c;
    }
}
