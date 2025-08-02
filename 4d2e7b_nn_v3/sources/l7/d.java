package l7;

import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum d {
    LINEAR,
    EASE_IN,
    EASE_OUT,
    EASE_IN_EASE_OUT,
    SPRING;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f12623a = null;

    public static final class a {
        private a() {
        }

        public final d a(String str) {
            m.f(str, "name");
            String lowerCase = str.toLowerCase(Locale.ROOT);
            m.e(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1965056864:
                    if (lowerCase.equals("easeout")) {
                        return d.EASE_OUT;
                    }
                    break;
                case -1310315117:
                    if (lowerCase.equals("easein")) {
                        return d.EASE_IN;
                    }
                    break;
                case -1102672091:
                    if (lowerCase.equals("linear")) {
                        return d.LINEAR;
                    }
                    break;
                case -895679987:
                    if (lowerCase.equals("spring")) {
                        return d.SPRING;
                    }
                    break;
                case 1164546989:
                    if (lowerCase.equals("easeineaseout")) {
                        return d.EASE_IN_EASE_OUT;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported interpolation type : " + str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        d[] a10;
        f12630h = pb.a.a(a10);
        f12623a = new a((DefaultConstructorMarker) null);
    }

    public static final d b(String str) {
        return f12623a.a(str);
    }
}
