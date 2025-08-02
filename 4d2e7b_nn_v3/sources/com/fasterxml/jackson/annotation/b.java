package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface b {

    public static class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        protected static final a f4948c = new a((Object) null, (Boolean) null);

        /* renamed from: a  reason: collision with root package name */
        protected final Object f4949a;

        /* renamed from: b  reason: collision with root package name */
        protected final Boolean f4950b;

        protected a(Object obj, Boolean bool) {
            this.f4949a = obj;
            this.f4950b = bool;
        }

        private static boolean a(Object obj, Boolean bool) {
            return obj == null && bool == null;
        }

        public static a b(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            if (a(obj, bool)) {
                return f4948c;
            }
            return new a(obj, bool);
        }

        public static a c(Object obj) {
            return b(obj, (Boolean) null);
        }

        public static a d(b bVar) {
            if (bVar == null) {
                return f4948c;
            }
            return b(bVar.value(), bVar.useInput().a());
        }

        public Object e() {
            return this.f4949a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                a aVar = (a) obj;
                if (m0.b(this.f4950b, aVar.f4950b)) {
                    Object obj2 = this.f4949a;
                    if (obj2 != null) {
                        return obj2.equals(aVar.f4949a);
                    }
                    if (aVar.f4949a == null) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public boolean f() {
            if (this.f4949a != null) {
                return true;
            }
            return false;
        }

        public a h(Object obj) {
            if (obj == null) {
                if (this.f4949a == null) {
                    return this;
                }
            } else if (obj.equals(this.f4949a)) {
                return this;
            }
            return new a(obj, this.f4950b);
        }

        public int hashCode() {
            Object obj = this.f4949a;
            int i10 = 1;
            if (obj != null) {
                i10 = 1 + obj.hashCode();
            }
            Boolean bool = this.f4950b;
            if (bool != null) {
                return i10 + bool.hashCode();
            }
            return i10;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[]{this.f4949a, this.f4950b});
        }
    }

    m0 useInput() default m0.DEFAULT;

    String value() default "";
}
