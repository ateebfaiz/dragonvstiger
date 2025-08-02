package c8;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f2658a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f2659b;

    public static abstract class a {
        public abstract a a(String str, int i10);

        public abstract a b(String str, Object obj);

        public abstract void c();
    }

    /* renamed from: c8.b$b  reason: collision with other inner class name */
    private static final class C0045b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final long f2660a;

        public C0045b(long j10) {
            this.f2660a = j10;
        }

        public a a(String str, int i10) {
            m.f(str, "key");
            return this;
        }

        public a b(String str, Object obj) {
            m.f(str, "key");
            m.f(obj, "value");
            return this;
        }

        public void c() {
            a.g(this.f2660a);
        }
    }

    private static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final long f2661a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2662b;

        /* renamed from: c  reason: collision with root package name */
        private final List f2663c = new ArrayList();

        public c(long j10, String str) {
            m.f(str, "sectionName");
            this.f2661a = j10;
            this.f2662b = str;
        }

        private final void d(String str, String str2) {
            List list = this.f2663c;
            list.add(str + ": " + str2);
        }

        public a a(String str, int i10) {
            m.f(str, "key");
            d(str, String.valueOf(i10));
            return this;
        }

        public a b(String str, Object obj) {
            m.f(str, "key");
            m.f(obj, "value");
            d(str, obj.toString());
            return this;
        }

        public void c() {
            String str;
            long j10 = this.f2661a;
            String str2 = this.f2662b;
            if (!b.f2659b || !(!this.f2663c.isEmpty())) {
                str = "";
            } else {
                str = " (" + c.a(", ", this.f2663c) + ")";
            }
            a.c(j10, str2 + str);
        }
    }

    private b() {
    }

    public static final a a(long j10, String str) {
        m.f(str, "sectionName");
        return new c(j10, str);
    }

    public static final a b(long j10) {
        return new C0045b(j10);
    }
}
