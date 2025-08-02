package rb;

import kotlin.jvm.internal.m;

public class a extends qb.a {

    /* renamed from: rb.a$a  reason: collision with other inner class name */
    private static final class C0032a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0032a f1978a = new C0032a();

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f1979b;

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
                    f1979b = num2;
                }
            } catch (Throwable unused) {
            }
            num = null;
            num2 = num;
            f1979b = num2;
        }

        private C0032a() {
        }
    }

    private final boolean c(int i10) {
        Integer num = C0032a.f1979b;
        if (num == null || num.intValue() >= i10) {
            return true;
        }
        return false;
    }

    public void a(Throwable th, Throwable th2) {
        m.f(th, "cause");
        m.f(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
