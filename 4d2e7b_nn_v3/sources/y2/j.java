package y2;

import java.util.Arrays;

public abstract class j {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f24873a;

        /* renamed from: b  reason: collision with root package name */
        private final C0353a f24874b;

        /* renamed from: c  reason: collision with root package name */
        private C0353a f24875c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24876d;

        /* renamed from: y2.j$a$a  reason: collision with other inner class name */
        private static final class C0353a {

            /* renamed from: a  reason: collision with root package name */
            String f24877a;

            /* renamed from: b  reason: collision with root package name */
            Object f24878b;

            /* renamed from: c  reason: collision with root package name */
            C0353a f24879c;

            private C0353a() {
            }
        }

        private C0353a d() {
            C0353a aVar = new C0353a();
            this.f24875c.f24879c = aVar;
            this.f24875c = aVar;
            return aVar;
        }

        private a e(String str, Object obj) {
            C0353a d10 = d();
            d10.f24878b = obj;
            d10.f24877a = (String) l.g(str);
            return this;
        }

        public a a(String str, int i10) {
            return e(str, String.valueOf(i10));
        }

        public a b(String str, Object obj) {
            return e(str, obj);
        }

        public a c(String str, boolean z10) {
            return e(str, String.valueOf(z10));
        }

        public String toString() {
            boolean z10 = this.f24876d;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f24873a);
            sb2.append('{');
            String str = "";
            for (C0353a aVar = this.f24874b.f24879c; aVar != null; aVar = aVar.f24879c) {
                Object obj = aVar.f24878b;
                if (!z10 || obj != null) {
                    sb2.append(str);
                    String str2 = aVar.f24877a;
                    if (str2 != null) {
                        sb2.append(str2);
                        sb2.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append(deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        private a(String str) {
            C0353a aVar = new C0353a();
            this.f24874b = aVar;
            this.f24875c = aVar;
            this.f24876d = false;
            this.f24873a = (String) l.g(str);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj.getClass().getSimpleName());
    }
}
