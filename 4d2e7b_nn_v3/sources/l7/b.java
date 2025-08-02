package l7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum b {
    OPACITY,
    SCALE_X,
    SCALE_Y,
    SCALE_XY;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f12615a = null;

    public static final class a {
        private a() {
        }

        public final b a(String str) {
            m.f(str, "name");
            switch (str.hashCode()) {
                case -1267206133:
                    if (str.equals("opacity")) {
                        return b.OPACITY;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        return b.SCALE_X;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        return b.SCALE_Y;
                    }
                    break;
                case 1910893003:
                    if (str.equals("scaleXY")) {
                        return b.SCALE_XY;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported animated property: " + str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        b[] a10;
        f12621g = pb.a.a(a10);
        f12615a = new a((DefaultConstructorMarker) null);
    }

    public static final b b(String str) {
        return f12615a.a(str);
    }
}
