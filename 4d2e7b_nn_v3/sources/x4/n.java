package x4;

import b3.c;
import y2.l;

public interface n extends x, c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f24801a;

        /* renamed from: b  reason: collision with root package name */
        public final c3.a f24802b;

        /* renamed from: c  reason: collision with root package name */
        public int f24803c = 0;

        /* renamed from: d  reason: collision with root package name */
        public boolean f24804d = false;

        /* renamed from: e  reason: collision with root package name */
        public final b f24805e;

        /* renamed from: f  reason: collision with root package name */
        public int f24806f;

        /* renamed from: g  reason: collision with root package name */
        public int f24807g;

        private a(Object obj, c3.a aVar, b bVar, int i10) {
            this.f24801a = l.g(obj);
            this.f24802b = (c3.a) l.g(c3.a.j(aVar));
            this.f24805e = bVar;
            this.f24806f = 0;
            this.f24807g = i10;
        }

        public static a a(Object obj, c3.a aVar, int i10, b bVar) {
            return new a(obj, aVar, bVar, i10);
        }

        public static a b(Object obj, c3.a aVar, b bVar) {
            return a(obj, aVar, -1, bVar);
        }
    }

    public interface b {
        void a(Object obj, boolean z10);
    }

    c3.a d(Object obj);

    c3.a e(Object obj, c3.a aVar, b bVar);
}
