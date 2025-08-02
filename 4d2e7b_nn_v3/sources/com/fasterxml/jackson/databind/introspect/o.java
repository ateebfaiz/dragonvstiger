package com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class o {

    /* renamed from: b  reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.util.a f5385b = new c();

    /* renamed from: a  reason: collision with root package name */
    protected final Object f5386a;

    static class a extends o {

        /* renamed from: c  reason: collision with root package name */
        public static final a f5387c = new a((Object) null);

        a(Object obj) {
            super(obj);
        }

        public o a(Annotation annotation) {
            return new e(this.f5386a, annotation.annotationType(), annotation);
        }

        public p b() {
            return new p();
        }

        public com.fasterxml.jackson.databind.util.a c() {
            return o.f5385b;
        }

        public boolean f(Annotation annotation) {
            return false;
        }
    }

    static class b extends o {

        /* renamed from: c  reason: collision with root package name */
        protected final HashMap f5388c;

        public b(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            super(obj);
            HashMap hashMap = new HashMap();
            this.f5388c = hashMap;
            hashMap.put(cls, annotation);
            hashMap.put(cls2, annotation2);
        }

        public o a(Annotation annotation) {
            this.f5388c.put(annotation.annotationType(), annotation);
            return this;
        }

        public p b() {
            p pVar = new p();
            for (Annotation d10 : this.f5388c.values()) {
                pVar.d(d10);
            }
            return pVar;
        }

        public com.fasterxml.jackson.databind.util.a c() {
            if (this.f5388c.size() != 2) {
                return new p(this.f5388c);
            }
            Iterator it = this.f5388c.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it.next();
            return new f((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
        }

        public boolean f(Annotation annotation) {
            return this.f5388c.containsKey(annotation.annotationType());
        }
    }

    public static class c implements com.fasterxml.jackson.databind.util.a, Serializable {
        c() {
        }

        public boolean a(Class cls) {
            return false;
        }

        public boolean b(Class[] clsArr) {
            return false;
        }

        public Annotation get(Class cls) {
            return null;
        }

        public int size() {
            return 0;
        }
    }

    public static class d implements com.fasterxml.jackson.databind.util.a, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Class f5389a;

        /* renamed from: b  reason: collision with root package name */
        private final Annotation f5390b;

        public d(Class cls, Annotation annotation) {
            this.f5389a = cls;
            this.f5390b = annotation;
        }

        public boolean a(Class cls) {
            if (this.f5389a == cls) {
                return true;
            }
            return false;
        }

        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f5389a) {
                    return true;
                }
            }
            return false;
        }

        public Annotation get(Class cls) {
            if (this.f5389a == cls) {
                return this.f5390b;
            }
            return null;
        }

        public int size() {
            return 1;
        }
    }

    static class e extends o {

        /* renamed from: c  reason: collision with root package name */
        private Class f5391c;

        /* renamed from: d  reason: collision with root package name */
        private Annotation f5392d;

        public e(Object obj, Class cls, Annotation annotation) {
            super(obj);
            this.f5391c = cls;
            this.f5392d = annotation;
        }

        public o a(Annotation annotation) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> cls = this.f5391c;
            if (cls != annotationType) {
                return new b(this.f5386a, cls, this.f5392d, annotationType, annotation);
            }
            this.f5392d = annotation;
            return this;
        }

        public p b() {
            return p.f(this.f5391c, this.f5392d);
        }

        public com.fasterxml.jackson.databind.util.a c() {
            return new d(this.f5391c, this.f5392d);
        }

        public boolean f(Annotation annotation) {
            if (annotation.annotationType() == this.f5391c) {
                return true;
            }
            return false;
        }
    }

    public static class f implements com.fasterxml.jackson.databind.util.a, Serializable {

        /* renamed from: a  reason: collision with root package name */
        private final Class f5393a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f5394b;

        /* renamed from: c  reason: collision with root package name */
        private final Annotation f5395c;

        /* renamed from: d  reason: collision with root package name */
        private final Annotation f5396d;

        public f(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            this.f5393a = cls;
            this.f5395c = annotation;
            this.f5394b = cls2;
            this.f5396d = annotation2;
        }

        public boolean a(Class cls) {
            if (this.f5393a == cls || this.f5394b == cls) {
                return true;
            }
            return false;
        }

        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f5393a || cls == this.f5394b) {
                    return true;
                }
            }
            return false;
        }

        public Annotation get(Class cls) {
            if (this.f5393a == cls) {
                return this.f5395c;
            }
            if (this.f5394b == cls) {
                return this.f5396d;
            }
            return null;
        }

        public int size() {
            return 2;
        }
    }

    protected o(Object obj) {
        this.f5386a = obj;
    }

    public static com.fasterxml.jackson.databind.util.a d() {
        return f5385b;
    }

    public static o e() {
        return a.f5387c;
    }

    public abstract o a(Annotation annotation);

    public abstract p b();

    public abstract com.fasterxml.jackson.databind.util.a c();

    public abstract boolean f(Annotation annotation);
}
