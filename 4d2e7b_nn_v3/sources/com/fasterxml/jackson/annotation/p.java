package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface p {

    public enum a {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    public static class b implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        protected static final b f5043e;

        /* renamed from: a  reason: collision with root package name */
        protected final a f5044a;

        /* renamed from: b  reason: collision with root package name */
        protected final a f5045b;

        /* renamed from: c  reason: collision with root package name */
        protected final Class f5046c;

        /* renamed from: d  reason: collision with root package name */
        protected final Class f5047d;

        static {
            a aVar = a.USE_DEFAULTS;
            f5043e = new b(aVar, aVar, (Class) null, (Class) null);
        }

        protected b(a aVar, a aVar2, Class cls, Class cls2) {
            this.f5044a = aVar == null ? a.USE_DEFAULTS : aVar;
            this.f5045b = aVar2 == null ? a.USE_DEFAULTS : aVar2;
            Class<Void> cls3 = Void.class;
            this.f5046c = cls == cls3 ? null : cls;
            this.f5047d = cls2 == cls3 ? null : cls2;
        }

        public static b a(a aVar, a aVar2) {
            a aVar3 = a.USE_DEFAULTS;
            if ((aVar == aVar3 || aVar == null) && (aVar2 == aVar3 || aVar2 == null)) {
                return f5043e;
            }
            return new b(aVar, aVar2, (Class) null, (Class) null);
        }

        public static b b(a aVar, a aVar2, Class cls, Class cls2) {
            Class<Void> cls3 = Void.class;
            if (cls == cls3) {
                cls = null;
            }
            if (cls2 == cls3) {
                cls2 = null;
            }
            a aVar3 = a.USE_DEFAULTS;
            if ((aVar == aVar3 || aVar == null) && ((aVar2 == aVar3 || aVar2 == null) && cls == null && cls2 == null)) {
                return f5043e;
            }
            return new b(aVar, aVar2, cls, cls2);
        }

        public static b c() {
            return f5043e;
        }

        public static b d(p pVar) {
            if (pVar == null) {
                return f5043e;
            }
            a value = pVar.value();
            a content = pVar.content();
            a aVar = a.USE_DEFAULTS;
            if (value == aVar && content == aVar) {
                return f5043e;
            }
            Class<Void> valueFilter = pVar.valueFilter();
            Class<Void> cls = null;
            Class<Void> cls2 = Void.class;
            if (valueFilter == cls2) {
                valueFilter = null;
            }
            Class<Void> contentFilter = pVar.contentFilter();
            if (contentFilter != cls2) {
                cls = contentFilter;
            }
            return new b(value, content, valueFilter, cls);
        }

        public static b j(b bVar, b bVar2) {
            if (bVar == null) {
                return bVar2;
            }
            return bVar.n(bVar2);
        }

        public static b k(b... bVarArr) {
            b bVar = null;
            for (b bVar2 : bVarArr) {
                if (bVar2 != null) {
                    if (bVar != null) {
                        bVar2 = bVar.n(bVar2);
                    }
                    bVar = bVar2;
                }
            }
            return bVar;
        }

        public Class e() {
            return this.f5047d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.f5044a == this.f5044a && bVar.f5045b == this.f5045b && bVar.f5046c == this.f5046c && bVar.f5047d == this.f5047d) {
                return true;
            }
            return false;
        }

        public a f() {
            return this.f5045b;
        }

        public Class h() {
            return this.f5046c;
        }

        public int hashCode() {
            return (this.f5044a.hashCode() << 2) + this.f5045b.hashCode();
        }

        public a i() {
            return this.f5044a;
        }

        public b l(Class cls) {
            a aVar;
            if (cls == null || cls == Void.class) {
                aVar = a.USE_DEFAULTS;
                cls = null;
            } else {
                aVar = a.CUSTOM;
            }
            return b(this.f5044a, aVar, this.f5046c, cls);
        }

        public b m(a aVar) {
            if (aVar == this.f5045b) {
                return this;
            }
            return new b(this.f5044a, aVar, this.f5046c, this.f5047d);
        }

        public b n(b bVar) {
            boolean z10;
            boolean z11;
            if (!(bVar == null || bVar == f5043e)) {
                a aVar = bVar.f5044a;
                a aVar2 = bVar.f5045b;
                Class cls = bVar.f5046c;
                Class cls2 = bVar.f5047d;
                a aVar3 = this.f5044a;
                boolean z12 = false;
                if (aVar == aVar3 || aVar == a.USE_DEFAULTS) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                a aVar4 = this.f5045b;
                if (aVar2 == aVar4 || aVar2 == a.USE_DEFAULTS) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                Class cls3 = this.f5046c;
                if (!(cls == cls3 && cls2 == cls3)) {
                    z12 = true;
                }
                if (z10) {
                    if (z11) {
                        return new b(aVar, aVar2, cls, cls2);
                    }
                    return new b(aVar, aVar4, cls, cls2);
                } else if (z11) {
                    return new b(aVar3, aVar2, cls, cls2);
                } else {
                    if (z12) {
                        return new b(aVar3, aVar4, cls, cls2);
                    }
                }
            }
            return this;
        }

        public b o(a aVar) {
            if (aVar == this.f5044a) {
                return this;
            }
            return new b(aVar, this.f5045b, this.f5046c, this.f5047d);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() {
            a aVar = this.f5044a;
            a aVar2 = a.USE_DEFAULTS;
            if (aVar == aVar2 && this.f5045b == aVar2 && this.f5046c == null && this.f5047d == null) {
                return f5043e;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(80);
            sb2.append("JsonInclude.Value(value=");
            sb2.append(this.f5044a);
            sb2.append(",content=");
            sb2.append(this.f5045b);
            if (this.f5046c != null) {
                sb2.append(",valueFilter=");
                sb2.append(this.f5046c.getName());
                sb2.append(".class");
            }
            if (this.f5047d != null) {
                sb2.append(",contentFilter=");
                sb2.append(this.f5047d.getName());
                sb2.append(".class");
            }
            sb2.append(')');
            return sb2.toString();
        }
    }

    a content() default a.ALWAYS;

    Class contentFilter() default Void.class;

    a value() default a.ALWAYS;

    Class valueFilter() default Void.class;
}
