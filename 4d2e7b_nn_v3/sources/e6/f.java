package e6;

import java.util.HashMap;
import java.util.Map;

public abstract class f {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map f11906a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11907b;

        public Map a() {
            if (this.f11907b) {
                this.f11907b = false;
                return this.f11906a;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        public a b(Object obj, Object obj2) {
            if (this.f11907b) {
                this.f11906a.put(obj, obj2);
                return this;
            }
            throw new IllegalStateException("Underlying map has already been built");
        }

        private a() {
            this.f11906a = f.b();
            this.f11907b = true;
        }
    }

    public static a a() {
        return new a();
    }

    public static HashMap b() {
        return new HashMap();
    }

    public static Map c() {
        return b();
    }

    public static Map d(Object obj, Object obj2) {
        Map c10 = c();
        c10.put(obj, obj2);
        return c10;
    }

    public static Map e(Object obj, Object obj2, Object obj3, Object obj4) {
        Map c10 = c();
        c10.put(obj, obj2);
        c10.put(obj3, obj4);
        return c10;
    }

    public static Map f(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Map c10 = c();
        c10.put(obj, obj2);
        c10.put(obj3, obj4);
        c10.put(obj5, obj6);
        return c10;
    }

    public static Map g(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        Map c10 = c();
        c10.put(obj, obj2);
        c10.put(obj3, obj4);
        c10.put(obj5, obj6);
        c10.put(obj7, obj8);
        return c10;
    }

    public static Map h(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        Map c10 = c();
        c10.put(obj, obj2);
        c10.put(obj3, obj4);
        c10.put(obj5, obj6);
        c10.put(obj7, obj8);
        c10.put(obj9, obj10);
        return c10;
    }

    public static Map i(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        Map c10 = c();
        c10.put(obj, obj2);
        c10.put(obj3, obj4);
        c10.put(obj5, obj6);
        c10.put(obj7, obj8);
        c10.put(obj9, obj10);
        c10.put(obj11, obj12);
        return c10;
    }
}
