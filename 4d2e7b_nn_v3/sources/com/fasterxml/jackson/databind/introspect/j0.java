package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.e;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface j0 {

    public static class a implements j0, Serializable {

        /* renamed from: f  reason: collision with root package name */
        protected static final a f5368f;

        /* renamed from: g  reason: collision with root package name */
        protected static final a f5369g;

        /* renamed from: a  reason: collision with root package name */
        protected final e.c f5370a;

        /* renamed from: b  reason: collision with root package name */
        protected final e.c f5371b;

        /* renamed from: c  reason: collision with root package name */
        protected final e.c f5372c;

        /* renamed from: d  reason: collision with root package name */
        protected final e.c f5373d;

        /* renamed from: e  reason: collision with root package name */
        protected final e.c f5374e;

        static {
            e.c cVar = e.c.PUBLIC_ONLY;
            e.c cVar2 = e.c.ANY;
            e.c cVar3 = cVar;
            e.c cVar4 = cVar;
            e.c cVar5 = cVar;
            f5368f = new a(cVar3, cVar4, cVar2, cVar2, cVar5);
            f5369g = new a(cVar3, cVar4, cVar, cVar, cVar5);
        }

        public a(e.c cVar, e.c cVar2, e.c cVar3, e.c cVar4, e.c cVar5) {
            this.f5370a = cVar;
            this.f5371b = cVar2;
            this.f5372c = cVar3;
            this.f5373d = cVar4;
            this.f5374e = cVar5;
        }

        private e.c m(e.c cVar, e.c cVar2) {
            if (cVar2 == e.c.DEFAULT) {
                return cVar;
            }
            return cVar2;
        }

        public static a o() {
            return f5369g;
        }

        public static a p() {
            return f5368f;
        }

        /* renamed from: A */
        public a h(e.b bVar) {
            return this;
        }

        /* renamed from: B */
        public a l(e.c cVar) {
            if (cVar == e.c.DEFAULT) {
                cVar = f5368f.f5372c;
            }
            e.c cVar2 = cVar;
            if (this.f5372c == cVar2) {
                return this;
            }
            return new a(this.f5370a, this.f5371b, cVar2, this.f5373d, this.f5374e);
        }

        public boolean c(g gVar) {
            return q(gVar.p());
        }

        public boolean d(j jVar) {
            return s(jVar.u());
        }

        public boolean j(j jVar) {
            return t(jVar.u());
        }

        public boolean k(j jVar) {
            return u(jVar.u());
        }

        /* access modifiers changed from: protected */
        public a n(e.c cVar, e.c cVar2, e.c cVar3, e.c cVar4, e.c cVar5) {
            if (cVar == this.f5370a && cVar2 == this.f5371b && cVar3 == this.f5372c && cVar4 == this.f5373d && cVar5 == this.f5374e) {
                return this;
            }
            return new a(cVar, cVar2, cVar3, cVar4, cVar5);
        }

        public boolean q(Field field) {
            return this.f5374e.a(field);
        }

        public boolean s(Method method) {
            return this.f5370a.a(method);
        }

        public boolean t(Method method) {
            return this.f5371b.a(method);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", new Object[]{this.f5370a, this.f5371b, this.f5372c, this.f5373d, this.f5374e});
        }

        public boolean u(Method method) {
            return this.f5372c.a(method);
        }

        /* renamed from: v */
        public a f(e eVar) {
            if (eVar == null) {
                return this;
            }
            return n(m(this.f5370a, eVar.getterVisibility()), m(this.f5371b, eVar.isGetterVisibility()), m(this.f5372c, eVar.setterVisibility()), m(this.f5373d, eVar.creatorVisibility()), m(this.f5374e, eVar.fieldVisibility()));
        }

        /* renamed from: w */
        public a a(e.c cVar) {
            if (cVar == e.c.DEFAULT) {
                cVar = f5368f.f5373d;
            }
            e.c cVar2 = cVar;
            if (this.f5373d == cVar2) {
                return this;
            }
            return new a(this.f5370a, this.f5371b, this.f5372c, cVar2, this.f5374e);
        }

        /* renamed from: x */
        public a e(e.c cVar) {
            if (cVar == e.c.DEFAULT) {
                cVar = f5368f.f5374e;
            }
            e.c cVar2 = cVar;
            if (this.f5374e == cVar2) {
                return this;
            }
            return new a(this.f5370a, this.f5371b, this.f5372c, this.f5373d, cVar2);
        }

        /* renamed from: y */
        public a b(e.c cVar) {
            if (cVar == e.c.DEFAULT) {
                cVar = f5368f.f5370a;
            }
            e.c cVar2 = cVar;
            if (this.f5370a == cVar2) {
                return this;
            }
            return new a(cVar2, this.f5371b, this.f5372c, this.f5373d, this.f5374e);
        }

        /* renamed from: z */
        public a i(e.c cVar) {
            if (cVar == e.c.DEFAULT) {
                cVar = f5368f.f5371b;
            }
            e.c cVar2 = cVar;
            if (this.f5371b == cVar2) {
                return this;
            }
            return new a(this.f5370a, cVar2, this.f5372c, this.f5373d, this.f5374e);
        }
    }

    j0 a(e.c cVar);

    j0 b(e.c cVar);

    boolean c(g gVar);

    boolean d(j jVar);

    j0 e(e.c cVar);

    j0 f(e eVar);

    j0 h(e.b bVar);

    j0 i(e.c cVar);

    boolean j(j jVar);

    boolean k(j jVar);

    j0 l(e.c cVar);
}
