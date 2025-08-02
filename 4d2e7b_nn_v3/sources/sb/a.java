package sb;

import kotlin.random.c;

public class a extends rb.a {

    /* renamed from: sb.a$a  reason: collision with other inner class name */
    private static final class C0034a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0034a f2060a = new C0034a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f2061b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
                if (obj instanceof Integer) {
                    num = (Integer) obj;
                    if (num != null && num.intValue() > 0) {
                        num2 = num;
                    }
                    f2061b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f2061b = num2;
        }

        private C0034a() {
        }
    }

    private final boolean c(int i10) {
        Integer num = C0034a.f2061b;
        if (num == null || num.intValue() >= i10) {
            return true;
        }
        return false;
    }

    public c b() {
        if (c(34)) {
            return new yb.a();
        }
        return super.b();
    }
}
