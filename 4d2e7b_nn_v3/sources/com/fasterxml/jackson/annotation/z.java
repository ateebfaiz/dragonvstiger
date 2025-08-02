package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface z {

    public static class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        protected static final a f5055c;

        /* renamed from: a  reason: collision with root package name */
        private final h0 f5056a;

        /* renamed from: b  reason: collision with root package name */
        private final h0 f5057b;

        static {
            h0 h0Var = h0.DEFAULT;
            f5055c = new a(h0Var, h0Var);
        }

        protected a(h0 h0Var, h0 h0Var2) {
            this.f5056a = h0Var;
            this.f5057b = h0Var2;
        }

        private static boolean a(h0 h0Var, h0 h0Var2) {
            h0 h0Var3 = h0.DEFAULT;
            if (h0Var == h0Var3 && h0Var2 == h0Var3) {
                return true;
            }
            return false;
        }

        public static a b(h0 h0Var, h0 h0Var2) {
            if (h0Var == null) {
                h0Var = h0.DEFAULT;
            }
            if (h0Var2 == null) {
                h0Var2 = h0.DEFAULT;
            }
            if (a(h0Var, h0Var2)) {
                return f5055c;
            }
            return new a(h0Var, h0Var2);
        }

        public static a c() {
            return f5055c;
        }

        public static a d(z zVar) {
            if (zVar == null) {
                return f5055c;
            }
            return b(zVar.nulls(), zVar.contentNulls());
        }

        public h0 e() {
            h0 h0Var = this.f5057b;
            if (h0Var == h0.DEFAULT) {
                return null;
            }
            return h0Var;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.f5056a == this.f5056a && aVar.f5057b == this.f5057b) {
                return true;
            }
            return false;
        }

        public h0 f() {
            h0 h0Var = this.f5056a;
            if (h0Var == h0.DEFAULT) {
                return null;
            }
            return h0Var;
        }

        public int hashCode() {
            return this.f5056a.ordinal() + (this.f5057b.ordinal() << 2);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            if (a(this.f5056a, this.f5057b)) {
                return f5055c;
            }
            return this;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this.f5056a, this.f5057b});
        }
    }

    h0 contentNulls() default h0.DEFAULT;

    h0 nulls() default h0.DEFAULT;

    String value() default "";
}
